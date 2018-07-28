package org.eclipse.rcpl.model.cdo.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.eclipse.emf.cdo.common.util.CDOException;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.etypes.EtypesPackage;
import org.eclipse.emf.cdo.expressions.ExpressionsPackage;
import org.eclipse.emf.cdo.net4j.CDONet4jSessionConfiguration;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.security.Access;
import org.eclipse.emf.cdo.security.Assignee;
import org.eclipse.emf.cdo.security.Directory;
import org.eclipse.emf.cdo.security.FilterPermission;
import org.eclipse.emf.cdo.security.Group;
import org.eclipse.emf.cdo.security.PatternStyle;
import org.eclipse.emf.cdo.security.Permission;
import org.eclipse.emf.cdo.security.PermissionFilter;
import org.eclipse.emf.cdo.security.Realm;
import org.eclipse.emf.cdo.security.ResourceFilter;
import org.eclipse.emf.cdo.security.Role;
import org.eclipse.emf.cdo.security.SecurityFactory;
import org.eclipse.emf.cdo.security.SecurityPackage;
import org.eclipse.emf.cdo.security.User;
import org.eclipse.emf.cdo.security.UserPassword;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.net4j.Net4jUtil;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.ContainerUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleException;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.eclipse.rcpl.libs.util.AUtil;
import org.eclipse.rcpl.model.ISession;
import org.eclipse.rcpl.model.RCPLModel;
import org.eclipse.rcpl.model.RcplModelUtil;
import org.eclipse.rcpl.model_2_0_0.rcpl.Addon;
import org.eclipse.rcpl.model_2_0_0.rcpl.Folder;
import org.eclipse.rcpl.model_2_0_0.rcpl.Logins;
import org.eclipse.rcpl.model_2_0_0.rcpl.Perspective;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
import org.eclipse.rcpl.model_2_0_0.rcpl.Resource;
import org.eclipse.rcpl.model_2_0_0.rcpl.provider.RcplItemProviderAdapterFactory;

/**
 * @author Ramin
 * 
 */
public class RcplSession implements ISession {

	public static boolean FORCE_NEW_XMI = false;
	public static final String USER_TEMPLATES = "templates";
	public static final String USER_ADMINISTRATOR = "Administrator";
	public static final String USER_COMPANY_1 = "user1@company.com";
	public static final String USER_COMPANY_2 = "user2@company.com";
	public static final String USER_COMPANY_3 = "user3@company.com";

	public static final String ROLE_TEMPLATES_WRITER = "ROLE_TEMPLATES_WRITER";
	public static final String ROLE_TEMPLATES_READER = "ROLE_TEMPLATES_READER";
	public static final String ROLE_SECURITY_READER = "ROLE_SECURITY_READER";
	public static final String ROLE_COMMUNICATION = "ROLE_COMMUNICATION";
	public static final String ROLE_HOME = "Home Folder /home";
	public static final String ROLE_ADMINISTRATION = "Administration";
	public static final String ROLE_IT_ARCHITECT = "ROLE_IT_ARCHITECT";
	public static final String ROLE_PRODUCT_TECH_COORDINATER = "ROLE_PKT";
	public static final String ROLE_PROJECT_LEADER = "ROLE_PL";

	public static final String GROUP_ADMINISTRATORS = "Administrators";
	public static final String GROUP_TEMPLATES_READER = "GROUP_TR";
	public static final String GROUP_TEMPLATES_WRITER = "GROUP_TW";
	public static final String GROUP_COMPANY = "GROUP_COMPANY";
	public static final String GROUP_IT_ARCHITECTS = "GROUP_ITA";
	public static final String GROUP_PRODUCT_TECH_COORDINATERS = "GROUP_PKT";
	public static final String GROUP_Users = "Users";
	public static final String GROUP_PROJECT_LEADERS = "GROUP_PL";

	// Ist in Wirklichkeit ein user!
	public static final String GROUPCOMM = "GROUPCOMM";
	// Ist in Wirklichkeit eine Rolle!
	public static final String GROUPCOMM2 = "GROUPCOMM2";

	public static final String MESSAGE_REGISTRATION = "kxlklqp&78dn(xLGGc0whka_registration";

	public static final String MESSAGE_CONFIRMATION_1_SEND = "qwelkxlx7klqp&78dn(xLGGc0whka_conf_1";

	public static final String MESSAGE_CONFIRMATION_2_SEND = "qweHHwxn77klqp&78dn(xLGGc0whka_conf2";

	public static boolean connectionFailed = false;

	private static ISession INSTANCE;

	public static String BASE_IMAGE_URL = "https://raw.githubusercontent.com/rassisi/rcpl/master/org.eclipse.rcpl.resources/";

	public static String HOME_URL = "http://rcpl.org";

	private static List<String> imageCodeBases = new ArrayList<String>();
	protected final String COMM1;

	public final String DEFAULT_PASSWORD;

	public final int SOURCE_PORT;

	public final int DESTINATION_PORT;

	private final String DB_NAME;

	protected final String REPOSITORY;

	public boolean DEBUG_RECREATE;

	public boolean ENV_DEV;

	public boolean STANDALONE;

	protected CDOSession session;

	protected CDOTransaction transaction;

	private RcplModelFactory factory;

	private org.eclipse.emf.ecore.resource.Resource xmiCDO;

	private org.eclipse.emf.ecore.resource.Resource xmiLocal;

	protected CDONet4jSessionConfiguration configuration;

	public Hashtable<String, Object> coreDataTable;

	private Connection connection;

	private RCPL rcpl;

	private Perspective wordPerspective;

	private Perspective spreadsheetPerspective;

	private Perspective presentationPerspective;

	private Perspective webPerspective;

	private Perspective settingsPerspective;

	private String perspektiveType;

	private Logins logins;

	protected String COMM2;

	private String userId;

	public String password;

	private String cacheDir;

	private Hashtable<String, String> cdoIds;

	private User user;

	private Realm realm;

	private Directory directory;

	private boolean reachable;

	private boolean launchedByJnlp;

	private RcplModelUtil modelUtil;

	public void addAdditionalImageCodebases(String... additionalCodeBases) {
		if (additionalCodeBases != null) {
			getImageCodeBases().addAll(Arrays.asList(additionalCodeBases));
		}
	}

	public static ISession getDefault() {
		if (INSTANCE == null) {
			INSTANCE = new RcplSession();
		}
		return INSTANCE;
	}

	/**
	 * @param port
	 * @param ePackage
	 */
	public RcplSession() throws SecurityException {

		INSTANCE = this;
		modelUtil = new RcplModelUtil(this);

		testReachable(getImageCodeBases().get(0));

		setCDOServer(null); // "85.25.100.163:80";
		this.DEFAULT_PASSWORD = "joffice";
		this.COMM1 = "b86645f289952e618043e5f2f70c";
		this.SOURCE_PORT = 2037;
		this.DESTINATION_PORT = 2036;
		this.DB_NAME = "joffice";
		this.REPOSITORY = "joffice";
		this.DEBUG_RECREATE = false;
		this.ENV_DEV = false;
		this.STANDALONE = false;
		this.perspektiveType = "WORD";
		this.COMM2 = "2a647b6a1184d48d712042f946420cc48280";
		this.userId = "";
		this.password = "";
		this.coreDataTable = new Hashtable<String, Object>();
		this.factory = new RcplModelFactoryImpl(this);
		this.cdoIds = new Hashtable<String, String>();

		prepareJnlp();

	}

	protected void prepareJnlp() {
//		BasicService basicService = null;
//		try {
//			try {
//				basicService = (BasicService) ServiceManager.lookup("javax.jnlp.BasicService");
//				LAUNCHED_BY_JNLP = true;
//				println("Launched By JNLP");
//			} catch (UnavailableServiceException e) {
//				LAUNCHED_BY_JNLP = false;
//				println("Launched Standalone");
//			}
//
//			if (basicService != null) {
//				String codeBase = basicService.getCodeBase().toString();
//				println("codeBase: " + codeBase);
//			} else {
//				println("codeBase not determined");
//			}
//		} catch (Exception ex) {
//			// ignore
//		}
	}

	private boolean testReachable(String urlString) {
		URL url;
		try {
			url = new URL(urlString);
			InetAddress[] ia = Inet4Address.getAllByName(url.getHost());
			reachable = ia[0].isReachable(3000);
		} catch (MalformedURLException e) {
			reachable = false;
		} catch (UnknownHostException e) {
			reachable = false;
		} catch (IOException e) {
			reachable = false;
		}
		return reachable;
	}

	/**
	 * @param assignee
	 * @param roles
	 */
	public void assignRoles(Assignee assignee, Role... roles) {
		for (Role role : roles) {
			if (role != null) {
				if (!assignee.getRoles().contains(role)) {
					assignee.getRoles().add(role);
					commit();
				}
			}
		}
	}

	/**
	 * 
	 */
	@Override
	public void close(boolean commit, boolean close) {

		if (session != null) {

			if (hasTemplatesWriterRole()) {
				saveXMI_Local();
			}

			if (isDirty()) {
				if (commit) {
					commit();
				} else {
					transaction.rollback();
				}
			}

			if (close) {
				try {
					// if (!transaction.isClosed()) {
					// transaction.close();
					// }
					transaction = null;
				} catch (Exception ex) {
					//
				}
				try {
					session.close();
					session = null;
				} catch (Exception ex) {
					//
				}
			}
		} else {
			saveXMI_Local();
		}

		xmiLocal = null;
	}

	public void closeConnection() {
		// try {
		// connection.close();
		// connection = null;
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	@Override
	public void commit() {
		if (session != null) {
			try {
				// IProgressMonitor m = CDOObjectImpl.progressTask;
				transaction.commit(null); // m);
				// hasCommits = true;
			} catch (CommitException ex) {

				try {
					transaction.commit();

				} catch (Exception ex2) {
					try {
						transaction.rollback();
						ex.printStackTrace();
					} catch (Exception ex3) {
						// ;
					}
				}
			}
		}
		sleep(10);
	}

	// /**
	// * @param message
	// */
	// public void communicate(String message) {
	// User u = null;
	// for (EObject eo : xmiCommunication.getContents()) {
	// if (eo instanceof User) {
	// if (((User) eo).getId().equals(userId)) {
	// u = (User) eo;
	// break;
	// }
	// }
	// }
	//
	// if (u == null) {
	// u = SecurityFactory.eINSTANCE.createUser();
	// u.setId(userId);
	// u.setEmail(message);
	// xmiCommunication.getContents().add(u);
	// commit();
	// }
	// }

	/**
	*
	*/
	public String createDisplayDate(Date date) {
		return new SimpleDateFormat("EEEE MMMM DD, YYYY").format(date);
	}

	@SuppressWarnings("unused")
	private EObject findEObject(String table, String idName, String id) {
		List<EObject> eObjects = findEObjects(table, idName, id);
		if (eObjects.size() > 1) {
			// TODO: ERROR
			return eObjects.get(0);
		}
		if (eObjects.size() == 1) {
			return eObjects.get(0);
		}
		return null;
	}

	public Resource createNewOfficeDocument(RCPL joffice, String templateName) {
		Resource template = modelUtil.findDocument(joffice, templateName);
		if (template != null) {

			if (modelUtil.findOpenedDocument(joffice, templateName) == null) {
				modelUtil.getOpenedResources(joffice).add(template);
			}
			commit();
			return template;
		}
		for (Resource doc : modelUtil.findTemplatesFolder(joffice).getResources()) {
			if (doc instanceof Resource && templateName.equals(doc.getId())) {
				Resource eNewDocument = EcoreUtil.copy(doc);
				eNewDocument.setMainPerspective(modelUtil.findPerspective(perspektiveType));
				// eNewDocument.layout();
				modelUtil.addDocument(joffice, eNewDocument);
				commit();
				return eNewDocument;

			}
		}
		return null;
	}

	/**
	 * @param role
	 * @param path
	 * @param patternStyle
	 * @param access
	 * @param clear
	 */
	protected void createPermissionFilter(Role role, String path, PatternStyle patternStyle, Access access,
			boolean clear) {
		EList<Permission> permissions = role.getPermissions();
		if (clear) {
			permissions.clear();
		} else {
			for (Permission p : permissions) {
				if (p instanceof FilterPermission) {
					FilterPermission f = (FilterPermission) p;
					for (PermissionFilter pf : f.getFilters()) {
						if (pf instanceof ResourceFilter) {
							ResourceFilter r = (ResourceFilter) pf;
							if (r.getPath().equals(path) && r.getPatternStyle().equals(patternStyle)
									&& access.equals(p.getAccess())) {
								return;
							}
						}
					}
				}
			}
		}

		FilterPermission permission = SecurityFactory.eINSTANCE.createFilterPermission();
		ResourceFilter resourceFilter = SecurityFactory.eINSTANCE.createResourceFilter(path, patternStyle);
		permission.getFilters().add(resourceFilter);
		permission.setAccess(access);
		permissions.add(permission);
	}

	private CDOResource createResource(CDOTransaction cdoTransaction) throws CommitException {
		// CDOResource cdoResource = transaction.createResource("/res1");
		// cdoTransaction.commit();
		// factory.initRepository();
		// cdoTransaction.commit();
		// return cdoResource;
		return null;
	}

	private Statement createStatement() {
		try {
			Statement s = connection.createStatement();
			return s;
			// }
			// catch (MySQLNonTransientConnectionException e) {
			// connection = null;
			// connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param outStream
	 * @param buf
	 * @param byteRead
	 * @param byteWritten
	 * @param progress
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	private void downloadBuf(OutputStream outStream, byte[] buf, int[] byteRead, int[] byteWritten) throws IOException {
		outStream.write(buf, 0, byteRead[0]);
		byteWritten[0] += byteRead[0];
		// if (progress && JOUtil.getAbstractOfficePane() != null) {
		// JOAbstractOfficePane.getInstance().updateProgressBar();
		// if (JOAbstractOfficePane.getInstance().getProgressSelection() >=
		// 1000) {
		// JOAbstractOfficePane.getInstance().setProgress(0);
		// }
		// }
	}

	public User findUser(String id) {
		return getRealm().getUser(id);
	}

	/**
	*
	*/
	public String formatAmount(double amount, String currency) {
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		Currency curr = Currency.getInstance(currency);
		numberFormat.setCurrency(curr);
		String result = numberFormat.format(amount);
		return result;
	}

	public String getCacheDir() {
		if (cacheDir == null) {
			cacheDir = System.getProperty("user.home") + "/.rcpl/cache";
			new File(cacheDir).mkdirs();
		}
		return cacheDir;
	}

	@Override
	public List<String> getImageCodeBases() {
		if (imageCodeBases.isEmpty()) {
			imageCodeBases.add(BASE_IMAGE_URL);
		}
		return imageCodeBases;
	}

	public EList<EObject> getContents() {
		if (getResource() == null) {
			return null;
		}
		return getResource().getContents();
	}

	protected Directory getDirectory() {
		if (directory == null) {
			CDOResource security = transaction.getResource("security");
			TreeIterator<EObject> it = security.getAllContents();
			while (it.hasNext()) {
				EObject eo = it.next();
				if (eo instanceof Directory) {
					directory = (Directory) eo;
					// break;
				}
			}

			// User connectedUser = getRealm().getUser("user2");
			// UserPassword password = connectedUser.getPassword();
			// String encryptedPassword = password.getEncrypted();

			// if (password == null) {
			// password = SecurityFactory.eINSTANCE.createUserPassword();
			// // password.setEncrypted(value);
			// connectedUser.setPassword(password);
			// }
			// transaction.commit();
		}
		return directory;
	}

	public RcplModelFactory getFactory() {
		return factory;
	}

	public org.eclipse.emf.ecore.resource.Resource getLocalResource() {
		return xmiLocal;
	}

	// private EOfficeVersion findVersion() {
	// for (EObject o : getContents()) {
	// if (o instanceof EOfficeVersion) {
	// return (EOfficeVersion) o;
	// }
	// }
	// return null;
	// }

	/**
	 * @return
	 */
	public Logins getLogins() {
		if (getContents() == null) {
			return null;
		}
		if (logins == null) {
			for (EObject o : getContents()) {
				if (o instanceof Logins) {
					logins = (Logins) o;
					break;
				}
			}
		}
		return logins;
	}

	public List<Resource> getMyResources(RCPL joffice) {
		for (Folder e : joffice.getAllResources().getChildren()) {
			if (e instanceof Folder) {
				if (RcplModelFactory.MY_DOCUMENTS_FOLDER.equals(e.getId())) {
					return e.getResources();
				}
			}
		}
		return null;
	}

	// public Company getCompany() {
	// if (company == null) {
	// for (EObject o : getContents()) {
	// if (o instanceof Company) {
	// company = (Company) o;
	// break;
	// }
	// }
	// }
	// return company;
	// }

	public EList<Addon> getOfficeParts(RCPL joffice) {
		return joffice.getAllAddons().getChildren();
	}

	// public double getDouble(JOKey key) {
	// String v = getString(key);
	// if (v == null) {
	// return 0;
	// }
	// try {
	// return Double.valueOf(v);
	// } catch (Exception ex) {
	// return 0;
	// }
	// }

	/**
	 * @param id
	 * @return
	 */
	public Role getOrCreateRole(String id) {
		try {
			Role r = getRealm().getRole(id);
			if (r == null) {
				r = getRealm().addRole(id);
				commit();
			}
			return r;
		} catch (Exception ex) {
			return null;
		}
	}

	public User getOrCreateUser(String id, String newPassword) {
		User u = getRealm().getUser(id);
		if (u == null) {
			u = getRealm().addUser(id);
			setUserPasswordIfNotSet(id, newPassword);
			commit();
		} else if (newPassword != null) {

			// credentials = createCredentials(userID, password.toCharArray());
			// getRealm().removeUser(id);
			// commit();
			// u = getRealm().addUser(id);
			// setUserPasswordIfNotSet(id, newPassword);
			// commit();

			// UserPassword pass = u.getPassword(); //
			// SecurityFactory.eINSTANCE.createUserPassword();
			// pass.setEncrypted(newPassword);
			// u.setPassword(pass);
			// commit();
		}
		return u;
	}

	public String getPassword() {
		return password;
	}

	public String getPerspektiveType() {
		return perspektiveType;
	}

	public Perspective getPresentationPerspective() {
		if (presentationPerspective == null) {
			presentationPerspective = modelUtil.findPerspective("PRESENTATION");
		}
		return presentationPerspective;
	}

	/**
	 * @return
	 */
	@Override
	public RCPL getRcpl() {
		if (rcpl == null) {
			try {
				for (EObject eo : getResource().getContents()) {
					if (eo instanceof RCPL) {
						rcpl = (RCPL) eo;
						break;
					}
				}
			} catch (Exception ex) {

			}
		}
		return rcpl;
	}

	protected Realm getRealm() {
		try {
			if (realm == null) {
				CDOResource security = transaction.getResource("security");
				TreeIterator<EObject> it = security.getAllContents();
				while (it.hasNext()) {
					EObject eo = it.next();
					if (eo instanceof Realm) {
						realm = (Realm) eo;
						break;
					}
				}
			}
		} catch (Exception ex) {
			// user has no rights
		}
		return realm;
	}

	@Override
	public org.eclipse.emf.ecore.resource.Resource getResource() {
		if (xmiCDO != null) {
			return xmiCDO;
		}
		return xmiLocal;
	}

	public List<String> getRoleIds() {
		List<String> result = new ArrayList<String>();
		if (user != null) {
			for (Role r : user.getRoles()) {
				result.add(r.getId());
			}

			for (Group g : user.getGroups()) {
				for (Role r : g.getRoles()) {
					result.add(r.getId());
				}
			}
		}

		return result;
	}

	@Override
	public CDOSession getSession() {
		return session;
	}

	public Perspective getSettingsPerspective() {
		if (settingsPerspective == null) {
			settingsPerspective = modelUtil.findPerspective("SETTINGS");
		}
		return settingsPerspective;
	}

	// public String getString(JOKey key) {
	// if (getJoffice() == null) {
	// return key.toString();
	// }
	// for (EPreference pref : getJoffice().getPreferences().getChildren()) {
	// if (key.name().equals(pref.getKey())) {
	// return pref.getValue();
	// }
	// }
	// return null;
	// }

	public Perspective getSpreadsheetPerspective() {
		if (spreadsheetPerspective == null) {
			spreadsheetPerspective = modelUtil.findPerspective("SPREADSHEET");
		}
		return spreadsheetPerspective;
	}

	public CDOTransaction getTransaction() {
		return transaction;
	}

	public User getUser() {
		return user;
	}

	public Perspective getWebPerspective() {
		if (webPerspective == null) {
			webPerspective = modelUtil.findPerspective("WEB");
		}
		return webPerspective;
	}

	public Perspective getWordPerspective() {
		if (wordPerspective == null) {
			wordPerspective = modelUtil.findPerspective("WORD");
		}
		return wordPerspective;
	}

	public boolean hasRole(String roleId) {
		if (user != null) {
			try {
				for (Role r : user.getRoles()) {
					String userRoleId = r.getId();
					if (userRoleId != null && userRoleId.equals(roleId)) {
						return true;
					}
				}
				for (Group g : user.getGroups()) {
					for (Role r : g.getRoles()) {
						String userRoleId = r.getId();
						if (userRoleId.equals(roleId)) {
							return true;
						}
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return false;
	}

	private boolean hasTemplatesWriterRole() {

		if ("templates".equals(userId)) {
			return true;
		}

		// try {
		// if (session != null) {
		// for (Role r : user.getRoles()) {
		// if (ROLE_TEMPLATES_WRITER.equals(r.getId())) {
		// return true;
		// }
		// }
		//
		// // for (Group g : user.getGroups()) {
		// // for (Role r : g.getRoles()) {
		// // if (ROLE_TEMPLATES_WRITER.equals(r.getId())) {
		// // return true;
		// // }
		// // }
		// // }
		// }
		// } catch (Exception ex) {
		// // obviously no rights
		// }
		return false;
	}

	@Override
	public boolean isDemo() {
		return "demo".equals(userId);
	}

	/**
	 * @return
	 */
	public boolean isDirty() {
		return !transaction.isClosed() && transaction.isDirty();
	}

	@Override
	public boolean isOnline() {
		return transaction != null && !transaction.isClosed();
	}

	@Override
	public boolean isValid() {
		if (xmiCDO != null) {
			return transaction == null || !transaction.isClosed();
		}
		return xmiLocal != null;
	}

	public boolean launchedByJNLP() {

		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadJOfficeXMI_Local() {

		try {
			ResourceSet rs = new ResourceSetImpl();
			ComposedAdapterFactory adapterFactory;
			adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory.addAdapterFactory(new RcplItemProviderAdapterFactory());

			adapterFactory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(adapterFactory,
					new BasicCommandStack());

			rs = domain.getResourceSet();

			File localXMIFile = new File(RCPLModel.mobileProvider.getApplicationDir(),
					RCPLModel.XMIName + RCPLModel.XMI_EXTENSION);
			if (FORCE_NEW_XMI) {
				localXMIFile.delete();
			}

			if (FORCE_NEW_XMI || !localXMIFile.exists()) {

				try {

					AUtil.copyInputStream(
							RCPLModel.modelClass.getResourceAsStream(RCPLModel.XMIName + RCPLModel.XMI_EXTENSION),
							localXMIFile);
				} catch (Throwable ex) {
					RCPLModel.logError(ex);
				}
			}

			if (localXMIFile.exists()) {
				RCPLModel.log(this, "XMI File: " + localXMIFile.getAbsolutePath() + " exists");
			}

			URI xmiURI = URI.createFileURI(localXMIFile.getAbsolutePath());
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMLResourceFactoryImpl());
			xmiLocal = rs.createResource(xmiURI);
			xmiLocal.setURI(xmiURI);
			// for performance reason, don't ask
			((ResourceImpl) xmiLocal).setIntrinsicIDToEObjectMap(new HashMap());
			// xmiLocal = new XMIResourceImpl();

			xmiLocal.load(new FileInputStream(localXMIFile), new HashMap<Object, Object>());
		} catch (Throwable e) {
			String msg = e.getMessage();
			if (msg.indexOf("Feature 'version' not found") != -1) {
				return;
			}
			RCPLModel.logError(e);
		}

	}

	/**
	 * @param user
	 * @param password
	 * @throws Throwable
	 */
	public void openSessionAndTransaction(String id, String password) throws Throwable {

		try {
			OMPlatform.INSTANCE.setDebugging(false);
			OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
			OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);
			IManagedContainer container = ContainerUtil.createContainer();
			Net4jUtil.prepareContainer(container);
			TCPUtil.prepareContainer(container);
			CDONet4jUtil.prepareContainer(container);
			container.activate();
			IConnector connector = TCPUtil.getConnector(container, getCDOServer()); // $NON-NLS-1$
			configuration = CDONet4jUtil.createNet4jSessionConfiguration();

			configuration.setConnector(connector);
			configuration.setRepositoryName(REPOSITORY); // $NON-NLS-1$
			IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(id, password);
			configuration.setCredentialsProvider(credentialsProvider);
			session = configuration.openNet4jSession();
			registerPackages();
			transaction = session.openTransaction();
		} catch (LifecycleException ex) {
			// Server is not running
		}
	}

	/**
	*
	*/
	public void putCdoId(String key, EObject eObject) {
		String uriFragment = getResource().getURIFragment(eObject);
		cdoIds.put(key, uriFragment);
	}

	/**
	 * 
	 */
	public void registerPackages() throws Throwable {

		RcplPackage.eINSTANCE.eClass();
		// SdPackage.eINSTANCE.eClass();
		SecurityPackage.eINSTANCE.eClass();

		if (session != null) {
			session.getPackageRegistry().putEPackage(RcplPackage.eINSTANCE);
			// session.getPackageRegistry().putEPackage(SdPackage.eINSTANCE);
			session.getPackageRegistry().putEPackage(SecurityPackage.eINSTANCE);
			session.getPackageRegistry().putEPackage(EcorePackage.eINSTANCE);
			session.getPackageRegistry().putEPackage(ExpressionsPackage.eINSTANCE);
			session.getPackageRegistry().putEPackage(EtypesPackage.eINSTANCE);
		}

	}

	// JOSession.xmiFile = new File(System.getProperty("user.dir"),
	// "joffice.xmi");
	//
	// LOGGER.debug(JOSession.xmiFile.toString());
	//
	// if (!JOSession.xmiFile.exists()) {
	// // copy
	//
	// InputStream stream = JOfficeStandalone.class
	// .getResourceAsStream("/com/joffice/templates/joffice.xmi");
	// if (stream == null) {
	// // send your exception or warning
	// }
	// OutputStream resStreamOut = null;
	// int readBytes;
	// byte[] buffer = new byte[4096];
	// try {
	// resStreamOut = new FileOutputStream(JOSession.xmiFile);
	// while ((readBytes = stream.read(buffer)) > 0) {
	// resStreamOut.write(buffer, 0, readBytes);
	// }
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// } finally {
	// try {
	// stream.close();
	// if (resStreamOut != null) {
	// resStreamOut.close();
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }

	public void removeCdoId(String key) {
		cdoIds.remove(key);
	}

	public void requestRegistration(String password) {
		if ("demo".equals(userId)) {
			return;
		}

		new SignInClient().signIn(userId, password);

		// openSessionAndTransaction(GROUPCOMM, COMM1 + COMM2);
		// xmiCommunication = transaction
		// .getOrCreateResource("/communication/communication.xmi");
		// //$NON-NLS-1$
		// communicate(MESSAGE_REGISTRATION);
		// x

	}

	public void rollback() {
		transaction.rollback();
	}

	private void saveXMI_Local() {

		if (xmiLocal != null

		// && (xmiLocal.isModified() || hasTemplatesWriterRole())) {

		) {

			try {
				// copy content from a cdo user to the local user storage
				if (xmiCDO != null && !xmiCDO.getContents().isEmpty()) { // &&
																			// !hasTemplatesWriterRole())
																			// {

					while (!xmiLocal.getContents().isEmpty()) {
						xmiLocal.getContents().remove(0);
					}

					for (EObject eo : xmiCDO.getContents()) {
						EObject eo2 = EcoreUtil.copy(eo);
						xmiLocal.getContents().add(eo2);
					}
					File localXMIFile = new File(
							"C:/Users/ramin/Documents/wss/rcpl/org.eclipse.rcpl.model_2_0_0/src/org/eclipse/rcpl/model/"
									+ RCPLModel.XMIName + RCPLModel.XMI_EXTENSION);
					// System.getProperty("user.home"), "joffice.xmi");
					URI xmiURI = URI.createFileURI(localXMIFile.getAbsolutePath());
					xmiLocal.setURI(xmiURI);
					xmiLocal.save(Collections.EMPTY_MAP);
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void setLogins(Logins logins) {
		this.logins = logins;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	public void setPerspektiveType(String perspektiveType) {
		this.perspektiveType = perspektiveType;
	}

	public void setUser(User user) {
		this.user = user;
	}

	protected void setUserPassword(String userId, String pass) {
		User user = getRealm().getUser(userId);
		UserPassword password = user.getPassword();
		password = SecurityFactory.eINSTANCE.createUserPassword();
		password.setEncrypted(pass);
		user.setPassword(password);
		commit();
	}

	// private void createPermissionFilter(Assignee role, String path,
	// PatternStyle patternStyle, Access access, boolean clear) {
	// EList<Permission> permissions = role.getPermissions();
	// if (clear) {
	// permissions.clear();
	// }
	// FilterPermission permission = SecurityFactory.eINSTANCE
	// .createFilterPermission();
	// ResourceFilter resourceFilter = SecurityFactory.eINSTANCE
	// .createResourceFilter(path, patternStyle);
	// permission.getFilters().add(resourceFilter);
	// permission.setAccess(access);
	// permissions.add(permission);
	// }
	protected void setUserPasswordIfNotSet(String userId, String pass) {
		User user = getRealm().getUser(userId);
		UserPassword password = user.getPassword();
		if (password == null) {
			password = SecurityFactory.eINSTANCE.createUserPassword();
			password.setEncrypted(pass);
			user.setPassword(password);
			// String encryptedPassword = password.getEncrypted();s
		}
	}

	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param register
	 * @throws Throwable
	 */
	@Override
	public boolean start() throws Throwable {

		loadJOfficeXMI_Local();
		if ("demo".equals(userId) || "".equals(userId)) {
			return true;
		}
		try {

			openSessionAndTransaction(userId, password);

			if (!isOnline()) {
				return false;
			}

			try {
				user = getRealm().getUser(userId);
			} catch (Exception ex) {
				// user has no right
			}

			xmiCDO = transaction
					.getOrCreateResource("/home/" + userId + "/" + RCPLModel.XMIName + RCPLModel.XMI_EXTENSION); //$NON-NLS-1$

		} catch (CDOException ex) {
			return false;
		} catch (LifecycleException ex) {
			return false;
		} catch (SecurityException ex) {
			if (!USER_ADMINISTRATOR.equals(userId)) {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}

		if (getContents().isEmpty()) {
			DEBUG_RECREATE = true;
		}

		if (DEBUG_RECREATE) {
			while (!getContents().isEmpty()) {
				getContents().remove(0);
			}
			EList<EObject> cont = null;

			cont = xmiLocal.getContents();

			for (EObject eo : cont) {
				EObject eo2 = EcoreUtil.copy(eo);
				if (eo2 instanceof RCPL) {
					getContents().add(eo2);
					break;
				}
			}

			commit();
		}

		return true;
	}

	/**
	 * @return
	 */
	protected boolean valid() {
		if (session == null) {
			return false;
		}
		if (getContents() == null) {
			return false;
		}
		return true;
	}

	public boolean isReachable() {
		return reachable;
	}

	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}

	public boolean isLaunchedByJnlp() {
		return launchedByJnlp;
	}

	public static void println(String msg) {
		System.out.println(msg);
	}

	//
	// public static void main(String[] args) {
	// // try {
	// // RapCDOSession session = new RapCDOSession();
	// // session.initCdoSession();
	// // session.createLogin("ramin_" + System.currentTimeMillis(), "123");
	// // session.close(true);
	// // } catch (CommitException e) {
	// // }
	//
	// }

	private String cdoServer;

	@Override
	public String getCDOServer() {
		return cdoServer;
	}

	@Override
	public void setCDOServer(String host) {
		this.cdoServer = host;
	}

	@Override
	public void addAdditionalImageCodebases(String url) {
		// TODO Auto-generated method stub

	}

	private boolean standalone;

	@Override
	public void setStandalone(boolean standalone) {
		this.standalone = standalone;
	}

	@Override
	public boolean isStandalone() {
		return standalone;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	public List<EObject> findEObjects(String table) {
		return findEObjects(table, null, null);
	}

	/**
	*
	*/
	public EObject getCdoObject(String key) {
		String uriFragment = cdoIds.get(key);
		EObject eo = getResource().getEObject(uriFragment);
		return eo;
	}

	/**
	*
	*/
	public EObject getCdoObjectFromId(String id) {
		EObject eObject = getResource().getEObject("L" + id);
		return eObject;
	}

	public Group getOrCreateGroup(String id) {
		Group g = getRealm().getGroup(id);
		if (g == null) {
			g = getRealm().addGroup(id);
			commit();
		}
		return g;
	}

	/**
	 * @param table
	 * @param idName
	 * @param id
	 * @return
	 */
	public List<EObject> findEObjects(String table, String idName, String id) {
		List<EObject> eObjects = new ArrayList<EObject>();
		Statement s = null;
		try {
			s = createStatement();
			String sqlString = "SELECT * FROM " + DB_NAME + "." + table;
			if (id != null && id.length() > 0) {
				sqlString += " where " + idName + " = '" + id + "'";
			}
			s.executeQuery(sqlString);
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				int idVal = (int) rs.getDouble("cdo_id");
				EObject eObject = xmiCDO.getEObject("L" + idVal);
				eObjects.add(eObject);
			}
			rs.close();
			s.close();
		} catch (SQLException e) {
		} catch (Exception e) {
			//
			if (s == null || connection == null) {
				// connect();
				if (connection != null) {
					return findEObjects(table, idName, id);
				}
			}
		}
		return eObjects;
	}

	public RcplModelUtil getModelUtil() {
		return modelUtil;
	}
}

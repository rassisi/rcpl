package org.eclipse.rcpl.model.client;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
import org.eclipse.rcpl.model.EnKeyValue;
import org.eclipse.rcpl.model.IIdProvider;
import org.eclipse.rcpl.model.ISession;
import org.eclipse.rcpl.model.ISessionFacory;
import org.eclipse.rcpl.model.RcplModel;
import org.eclipse.rcpl.model.RcplModelUtil;
import org.eclipse.rcpl.model.RcplSessionFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValue;
import org.eclipse.rcpl.model_2_0_0.rcpl.KeyValues;
import org.eclipse.rcpl.model_2_0_0.rcpl.Logins;
import org.eclipse.rcpl.model_2_0_0.rcpl.RCPL;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplFactory;
import org.eclipse.rcpl.model_2_0_0.rcpl.RcplPackage;
//import org.eclipse.rcpl.model_2_0_0.rcpl.Resource;

/**
 * @author ramin
 *
 */
public abstract class AbstractSession<T extends EObject> implements ISession {

	public static IIdProvider applicationId;

	public static String BASE_IMAGE_URL = "https://raw.githubusercontent.com/rassisi/rcpl/master/org.eclipse.rcpl.resources/";
	public static boolean connectionFailed = false;

	public static final String GROUP_ADMINISTRATORS = "Administrators";
	public static final String GROUP_COMPANY = "GROUP_COMPANY";
	public static final String GROUP_IT_ARCHITECTS = "GROUP_ITA";

	public static final String GROUP_PRODUCT_TECH_COORDINATERS = "GROUP_PKT";
	public static final String GROUP_PROJECT_LEADERS = "GROUP_PL";
	public static final String GROUP_TEMPLATES_READER = "GROUP_TR";
	public static final String GROUP_TEMPLATES_WRITER = "GROUP_TW";
	public static final String GROUP_Users = "Users";
	// Ist in Wirklichkeit ein user!
	public static final String GROUPCOMM = "GROUPCOMM";
	// Ist in Wirklichkeit eine Rolle!
	public static final String GROUPCOMM2 = "GROUPCOMM2";
	public static String HOME_URL = "http://rcpl.org";
	private static List<String> imageCodeBases = new ArrayList<String>();

	private static ISession INSTANCE;
	public static final String MESSAGE_CONFIRMATION_1_SEND = "qwelkxlx7klqp&78dn(xLGGc0whka_conf_1";
	public static final String MESSAGE_CONFIRMATION_2_SEND = "qweHHwxn77klqp&78dn(xLGGc0whka_conf2";
	public static final String MESSAGE_REGISTRATION = "kxlklqp&78dn(xLGGc0whka_registration";
	public static final String ROLE_ADMINISTRATION = "Administration";
	public static final String ROLE_COMMUNICATION = "ROLE_COMMUNICATION";
	public static final String ROLE_HOME = "Home Folder /home";
	public static final String ROLE_IT_ARCHITECT = "ROLE_IT_ARCHITECT";

	public static final String ROLE_PRODUCT_TECH_COORDINATER = "ROLE_PKT";
	public static final String ROLE_PROJECT_LEADER = "ROLE_PL";

	public static final String ROLE_SECURITY_READER = "ROLE_SECURITY_READER";

	public static final String ROLE_TEMPLATES_READER = "ROLE_TEMPLATES_READER";

	public static final String ROLE_TEMPLATES_WRITER = "ROLE_TEMPLATES_WRITER";

	public static ISessionFacory sessionFactory = new RcplSessionFactory();

	public static final String USER_ADMINISTRATOR = "Administrator";

	public static final String USER_COMPANY_1 = "user1@company.com";

	public static final String USER_COMPANY_2 = "user2@company.com";

	public static final String USER_COMPANY_3 = "user3@company.com";

	public static final String USER_TEMPLATES = "templates";

	public static ISession getDefault() {
		if (INSTANCE == null) {
			INSTANCE = sessionFactory.createSession();
		}
		return INSTANCE;
	}

	private String cacheDir;

	private Hashtable<String, String> cdoIds;

	private String cdoServer;

	protected final String COMM1;

	protected String COMM2;

	protected CDONet4jSessionConfiguration configuration;

	private Connection connection;

	public Hashtable<String, Object> coreDataTable;

	private final String DB_NAME;

	public static boolean DEBUG_RECREATE;

	public final String DEFAULT_PASSWORD;

	public final int DESTINATION_PORT;

	private Directory directory;

	public boolean ENV_DEV;

	private IModelFactory factory;

	private boolean launchedByJnlp;

	private Logins logins;

	private RcplModelUtil modelUtil;

	public String password;

	private String perspektiveType;

	private boolean reachable;

	private Realm realm;

	protected final String REPOSITORY;

	protected CDOSession cdoSession;

	public final int SOURCE_PORT;

	private boolean standalone;

	protected CDOTransaction transaction;

	private User user;

	private String userId;

	private Resource xmiRcpl;

	private Resource xmiApplication;

	private Resource xmiLocalApplication;

	/**
	 * @param port
	 * @param ePackage
	 */
	public AbstractSession() throws SecurityException {

		INSTANCE = this;
		modelUtil = new RcplModelUtil(this);

		testReachable(getImageCodeBases().get(0));

		setCDOServer("localhost"); // "85.25.100.163:80";
		this.DEFAULT_PASSWORD = "joffice";
		this.COMM1 = "b86645f289952e618043e5f2f70c";
		this.SOURCE_PORT = 2037;
		this.DESTINATION_PORT = 2036;
		this.DB_NAME = "repo1";
		this.REPOSITORY = "repo1";
		this.ENV_DEV = false;
		this.standalone = false;
		this.perspektiveType = "WORD";
		this.COMM2 = "2a647b6a1184d48d712042f946420cc48280";
		this.userId = "";
		this.password = "";
		this.coreDataTable = new Hashtable<String, Object>();
		this.factory = new RcplModelFactoryImpl(this);
		this.cdoIds = new Hashtable<String, String>();

		prepareJnlp();

		loadLocalXMI(false);

	}

	@Override
	public void addAdditionalImageCodebases(String... additionalCodeBases) {
		if (additionalCodeBases != null) {
			getImageCodeBases().addAll(Arrays.asList(additionalCodeBases));
		}
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

		saveXMI_Local(false);

		if (cdoSession != null) {

			if (hasTemplatesWriterRole()) {
//				saveXMI_Local();
			}

			if (isDirty()) {
				if (commit) {
					commit();
				} else {
					transaction.rollback();
				}
			}

			if (close) {
//				try {
//					transaction = null;
//				} catch (Exception ex) {
//					System.out.println();
//				}
				try {
					cdoSession.close();
					cdoSession = null;
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		}

		xmiRcpl = null;
		xmiApplication = null;
	}

	@Override
	public void commit() {
		if (cdoSession != null) {
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
		} else {
			saveXMI_Local(true);
		}
		saveXMI_Local(false);
		AUtil.sleep(10);
	}

	/**
	*
	*/
	public String createDisplayDate(Date date) {
		return new SimpleDateFormat("EEEE MMMM DD, YYYY").format(date);
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
		CDOResource cdoResource = transaction.createResource("/res1");
		cdoTransaction.commit();
//		factory.initRepository();
		cdoTransaction.commit();
		return cdoResource;
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

	public List<EObject> findEObjects(String table) {
		return findEObjects(table, null, null);
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
				EObject eObject = xmiApplication.getEObject("L" + idVal);
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

	public User findUser(String id) {
		return getRealm().getUser(id);
	}

	public String getCacheDir() {
		if (cacheDir == null) {
			cacheDir = System.getProperty("user.home") + "/.rcpl/cache";
			new File(cacheDir).mkdirs();
		}
		return cacheDir;
	}

	/**
	*
	*/
	public EObject getCdoObject(String key) {
		String uriFragment = cdoIds.get(key);
		EObject eo = getRcplEmfResource().getEObject(uriFragment);
		return eo;
	}

	/**
	*
	*/
	public EObject getCdoObjectFromId(String id) {
		EObject eObject = getRcplEmfResource().getEObject("L" + id);
		return eObject;
	}

	@Override
	public String getCDOServer() {
		return cdoServer;
	}

	@Override
	public EList<EObject> getContents() {
		if (getApplicationEmfResource() == null) {
			return null;
		}
		return getApplicationEmfResource().getContents();
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

	public IModelFactory getFactory() {
		return factory;
	}

	@Override
	public List<String> getImageCodeBases() {
		if (imageCodeBases.isEmpty()) {
			imageCodeBases.add(BASE_IMAGE_URL);
		}
		return imageCodeBases;
	}

	public org.eclipse.emf.ecore.resource.Resource getLocalResource() {
		return xmiRcpl;
	}

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

	@Override
	public RcplModelUtil getModelUtil() {
		return modelUtil;
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

	public String getPassword() {
		return password;
	}

	public String getPerspektiveType() {
		return perspektiveType;
	}

	/**
	 * @return
	 */
	@Override
	public RCPL getRcpl() {
		try {
			return (RCPL) getRcplEmfResource().getContents().get(0);
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public T getApplicationRootObject() {

		if (getApplicationEmfResource() != null) {
			EList<EObject> contents = getApplicationEmfResource().getContents();

			if (contents.isEmpty()) {
				return null;
			}
			T result = (T) contents.get(0);
			return result;
		}
		return null;
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
	public Resource getRcplEmfResource() {
		return xmiRcpl;
	}

	@Override
	public Resource getApplicationEmfResource() {
		return xmiApplication;
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
		return cdoSession;
	}

	public CDOTransaction getTransaction() {
		return transaction;
	}

	public User getUser() {
		return user;
	}

	@Override
	public String getUserId() {
		return userId;
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

	public boolean isLaunchedByJnlp() {
		return launchedByJnlp;
	}

	@Override
	public boolean isOnline() {
		return transaction != null && !transaction.isClosed();
	}

	public boolean isReachable() {
		return reachable;
	}

	@Override
	public boolean isStandalone() {
		return standalone;
	}

	@Override
	public boolean isValid() {
		if (xmiApplication != null) {
			return transaction == null || !transaction.isClosed();
		}
		return xmiRcpl != null;
	}

	public boolean launchedByJNLP() {

		return true;
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
			cdoSession = configuration.openNet4jSession();
			registerPackages();
			transaction = cdoSession.openTransaction();
		} catch (LifecycleException ex) {
			// Server is not running
			System.out.println();
		}
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

	/**
	*
	*/
	public void putCdoId(String key, EObject eObject) {
		String uriFragment = getRcplEmfResource().getURIFragment(eObject);
		cdoIds.put(key, uriFragment);
	}

	/**
	 * 
	 */
	public void registerPackages() throws Throwable {
		RcplPackage.eINSTANCE.eClass();
		SecurityPackage.eINSTANCE.eClass();
		if (cdoSession != null) {
			cdoSession.getPackageRegistry().putEPackage(RcplPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(SecurityPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(EcorePackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(ExpressionsPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(EtypesPackage.eINSTANCE);
			registerApplicationPackages(cdoSession);
		}

	}

	abstract protected void registerApplicationPackages(CDOSession cdoSession);

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

	private void saveXMI_Local(boolean application) {
		try {
			Resource resource;
			if (application) {
				resource = xmiApplication;
			} else {
				resource = xmiRcpl;
			}
			File localXMIFile = getLocalXmiFile(application);
			URI xmiURI = URI.createFileURI(localXMIFile.getAbsolutePath());
			resource.setURI(xmiURI);

			resource.save(Collections.EMPTY_MAP);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void copyFromCDOToLocal() {
		if (xmiRcpl != null)

		// && (xmiLocal.isModified() || hasTemplatesWriterRole())) {

		{

			try {
				// copy content from a cdo user to the local user storage
				if (xmiApplication != null && !xmiApplication.getContents().isEmpty()) { // &&
					// !hasTemplatesWriterRole())
					// {

					while (!xmiRcpl.getContents().isEmpty()) {
						xmiRcpl.getContents().remove(0);
					}

					for (EObject eo : xmiApplication.getContents()) {
						EObject eo2 = EcoreUtil.copy(eo);
						xmiRcpl.getContents().add(eo2);
					}

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void setCDOServer(String host) {
		this.cdoServer = host;
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

	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}

	@Override
	public void setStandalone(boolean standalone) {
		this.standalone = standalone;
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

	private void createPermissionFilter(Assignee role, String path, PatternStyle patternStyle, Access access,
			boolean clear) {
//		EList<Permission> permissions = role.getPermissions();
//		if (clear) {
//			permissions.clear();
//		}
//		FilterPermission permission = SecurityFactory.eINSTANCE.createFilterPermission();
//		ResourceFilter resourceFilter = SecurityFactory.eINSTANCE.createResourceFilter(path, patternStyle);
//		permission.getFilters().add(resourceFilter);
//		permission.setAccess(access);
//		permissions.add(permission);
	}

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

	/**
	 * @param register
	 * @throws Throwable
	 */
	@Override
	public boolean start() throws Throwable {

		// ---------- load Rcpl model always locally

//		if ("demo".equals(userId) || "".equals(userId)) {
//			return true;
//		}
		try {

			userId = "Administrator";
			password = "0000";
			openSessionAndTransaction(userId, password);

			if (!isOnline()) {
				loadLocalXMI(true);
				xmiApplication = xmiLocalApplication;
				return true;
			}

			try {
				if (getRealm() != null) {
					user = getRealm().getUser(userId);
				}
			} catch (Exception ex) {
				// user has no right
			}

			xmiApplication = transaction.getOrCreateResource(
					"/home/" + userId + "/" + AbstractSession.applicationId.getId() + RcplModel.XMI_EXTENSION); //$NON-NLS-1$

			if (getContents().isEmpty()) {

				if (getContents().isEmpty()) {
					loadLocalXMI(true);
					getContents().add(xmiLocalApplication.getContents().get(0));
					commit();
				}
//				createInitialApplicationModel(getContents());
			}

		} catch (CDOException ex) {
			return false;
		} catch (LifecycleException ex) {
			return false;
		} catch (SecurityException ex) {
			if (!USER_ADMINISTRATOR.equals(userId)) {
				return false;
			}
		} catch (Exception ex) {
			loadLocalXMI(true);
			xmiApplication = xmiLocalApplication;
		}

		return true;
	}

	abstract protected void createInitialApplicationModel(EList<EObject> contents);

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
	 * @return
	 */
	protected boolean valid() {
		if (cdoSession == null) {
			return false;
		}
		if (getContents() == null) {
			return false;
		}
		return true;
	}

	/**
	 * @param message
	 */
	public void communicate(String message) {
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
	}

	private void loadLocalXMI(boolean application) {

		boolean DEBUG_COMPARE_CONTENT = false;

		try {
			ResourceSet rs = new ResourceSetImpl();
			ComposedAdapterFactory composedAdapterFactory;
			composedAdapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
			addAdapterFactories(composedAdapterFactory);
			AdapterFactoryEditingDomain domain = new AdapterFactoryEditingDomain(composedAdapterFactory,
					new BasicCommandStack());

			rs = domain.getResourceSet();

			String fileName = getLocalXmiFileName(application);
			File localXMIFile = getLocalXmiFile(application);

			// ---------- compare local XML File with the resource

			File tempXMIFile = File.createTempFile("rcpl_temp_", "temp");

			try {
				AUtil.copyInputStream(RcplModel.modelClass.getResourceAsStream(fileName), tempXMIFile);
			} catch (Throwable ex) {
				RcplModel.logError(ex);
			}

			boolean forceNewXMI =

					DEBUG_RECREATE

							|| !localXMIFile.exists()

							|| (DEBUG_COMPARE_CONTENT && !FileUtils.contentEquals(tempXMIFile, localXMIFile));

			tempXMIFile.delete();

			if (forceNewXMI) {
				if (localXMIFile.exists()) {
					localXMIFile.delete();
				}
				try {
					AUtil.copyInputStream(RcplModel.modelClass.getResourceAsStream(fileName), localXMIFile);
				} catch (Throwable ex) {
					RcplModel.logError(ex);
				}
			}

			if (localXMIFile.exists()) {
				RcplModel.log(this, "XMI File: " + localXMIFile.getAbsolutePath() + " exists");
			}

			URI xmiURI = URI.createFileURI(localXMIFile.getAbsolutePath());
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMLResourceFactoryImpl());
			Resource resource;
			if (application) {
				xmiLocalApplication = rs.createResource(xmiURI);
				xmiLocalApplication.setURI(xmiURI);
				resource = xmiLocalApplication;

			} else {
				xmiRcpl = rs.createResource(xmiURI);
				xmiRcpl.setURI(xmiURI);
				resource = xmiRcpl;
			}
			// for performance reason, don't ask
			((ResourceImpl) resource).setIntrinsicIDToEObjectMap(new HashMap());
			// xmiLocal = new XMIResourceImpl();

			resource.load(new FileInputStream(localXMIFile), new HashMap<Object, Object>());
			if (forceNewXMI) {
				getRcpl().getKeyvalues().getKeyvalues().clear();
			}
		} catch (Throwable e) {
			String msg = e.getMessage();
			if (msg.indexOf("Feature 'version' not found") != -1) {
				return;
			}
			RcplModel.logError(e);
		}

	}

	private String getLocalXmiFileName(boolean application) {
		return AbstractSession.applicationId.getId() + (application ? "_application" : "_rcpl")
				+ RcplModel.XMI_EXTENSION;
	}

	private File getLocalXmiFile(boolean application) {
		return new File(RcplModel.getMobileProvider().getApplicationDir(), getLocalXmiFileName(application));
	}

	abstract protected void addAdapterFactories(ComposedAdapterFactory composedFactory);

	// ---------- get value

	private KeyValues findKeyValueFolder(String path, boolean create) {
		if (getRcpl() == null) {
			return null;
		}
		StringTokenizer tok = new StringTokenizer(path, "/");

		KeyValues root = getRcpl().getKeyvalues();
		if (root == null) {
			root = RcplFactory.eINSTANCE.createKeyValues();
			getRcpl().setKeyvalues(root);
			commit();
		}

		boolean changed = false;
		while (tok.hasMoreElements()) {
			String folderName = tok.nextToken();
			boolean found = false;
			for (KeyValues kv : root.getKeyvaluesFolder()) {
				if (folderName.equals(kv.getName())) {
					root = kv;
					found = true;
				}
			}
			if (!found) {
				if (!create) {
					return null;
				}
				KeyValues kv = RcplFactory.eINSTANCE.createKeyValues();
				kv.setName(folderName);
				root.getKeyvaluesFolder().add(kv);
				root = kv;
				changed = true;
			}
		}
		if (changed) {
			commit();
		}
		return root;
	}

	@Override
	public String getValue(String path, String key) {
		KeyValues root = findKeyValueFolder(path, false);
		if (root != null) {
			for (KeyValue kv : root.getKeyvalues()) {
				if (key.equals(kv.getKey())) {
					return kv.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public String getValue(String path, String key, String defaultValue) {
		String value = getValue(path, key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	@Override
	public List<String> loadKeys(String folder, String matchKey) {
		List<String> keys = new ArrayList<String>();
		KeyValues root = findKeyValueFolder(folder, false);
		if (root != null) {
			for (KeyValue kv : root.getKeyvalues()) {
				if (kv.getKey().startsWith(matchKey)) {
					keys.add(kv.getKey());
				}
			}
		}
		return keys;
	}

	@Override
	public void setMaxKeyValues(String path, EnKeyValue matchKey, int max) {
		List<String> keys = loadKeys(path, matchKey.name());
		List<KeyValue> keyValuesToDelete = new ArrayList<KeyValue>();
		KeyValues root = findKeyValueFolder(path, false);
		if (root != null) {
			if (keys.size() > max) {
				for (int i = 0; i < keys.size() - max; i++) {
					String key = keys.get(i);
					for (KeyValue kv : root.getKeyvalues()) {
						if (kv.getKey().startsWith(matchKey.name())) {
							keyValuesToDelete.add(kv);
						}
					}
				}
			}
			for (KeyValue keyValue : keyValuesToDelete) {
				root.getKeyvalues().remove(keyValue);
			}
		}
	}

	// ---------- put value

	@Override
	public void putValue(String path, String key, String value) {
		try {
			KeyValues root = findKeyValueFolder(path, true);
			for (KeyValue kv : root.getKeyvalues()) {
				if (key.equals(kv.getKey())) {
					kv.setName(key);
					kv.setValue(value);
					return;
				}
			}
			KeyValue kv = RcplFactory.eINSTANCE.createKeyValue();
			kv.setKey(key);
			kv.setName(key);
			kv.setValue(value);
			root.getKeyvalues().add(kv);
			commit();
		} catch (Exception ex) {
			//
		}
	}

	// ---------- delete value

	@Override
	public void deleteAllValues(String path, String matchKey) {
		List<KeyValue> keyValuesToDelete = new ArrayList<KeyValue>();
		KeyValues root = findKeyValueFolder(path, false);
		if (root != null) {
			for (KeyValue kv : root.getKeyvalues()) {
				String k = kv.getKey();
				if (k.startsWith(matchKey)) {
					keyValuesToDelete.add(kv);
				}
			}
			for (KeyValue keyValue : keyValuesToDelete) {
				root.getKeyvalues().remove(keyValue);
			}
			commit();
		}
	}
}

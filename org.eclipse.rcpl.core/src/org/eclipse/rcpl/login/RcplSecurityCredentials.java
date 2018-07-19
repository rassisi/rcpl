package org.eclipse.rcpl.login;

import java.util.List;

import com.warrenstrange.googleauth.ICredentialRepository;

/**
 * @author Ramin
 *
 */
public class RcplSecurityCredentials implements ICredentialRepository {

	@Override
	public String getSecretKey(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUserCredentials(String userName, String secretKey, int validationCode, List<Integer> scratchCodes) {
		// TODO Auto-generated method stub

	}

}

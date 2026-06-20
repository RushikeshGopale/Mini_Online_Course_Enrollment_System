package org.techhub.Service;

import org.techhub.Repository.ValidateLogin;
import org.techhub.Repository.ValidateLoginRepoImpl;

public class ValidateLoginServiceImpl implements ValidateLoginService {

	
	ValidateLogin vlogin=new ValidateLoginRepoImpl();
	@Override
	public String checkLogin(String email, String password) {
		// TODO Auto-generated method stub
		return vlogin.checkLogin(email, password);
	}

}

package org.techhub.Service;

import org.techhub.Model.RegisterModel;
import org.techhub.Repository.*;

public class RegisterServiceImpl implements RegisterService {

	RegisterRepo repo=new RegisterRepoImpl();
	@Override
	public boolean register(RegisterModel model) {
		// TODO Auto-generated method stub
		return repo.register(model);
	}

}

package org.techhub.Repository;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.RegisterModel;

public class RegisterRepoImpl extends DBConfig implements RegisterRepo{

	@Override
	public boolean register(RegisterModel model) {
		try {
			stmt=con.prepareStatement("insert into user(uid,name,email,contact,password) values('0',?,?,?,?)");
			stmt.setString(1,model.getName());
			stmt.setString(2,model.getEmail());
			stmt.setString(3,model.getContact());
			stmt.setString(4,model.getPassword());			
			int value=stmt.executeUpdate();
			
			//if(value>0)
			return value>0;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is :"+e);
			return false;
		}
	}

}

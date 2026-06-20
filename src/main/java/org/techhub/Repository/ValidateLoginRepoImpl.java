package org.techhub.Repository;

import org.techhub.DBConfig.DBConfig;

public class ValidateLoginRepoImpl extends DBConfig implements ValidateLogin {

	@Override
	public String checkLogin(String email, String password) {

		try {
			
			stmt = con.prepareStatement("select role from user where email=? and password=?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();

			if (rs.next())
			{
				return rs.getString("role");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
			
		}
		return "invalid";
		
	}
}

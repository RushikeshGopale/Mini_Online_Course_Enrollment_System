package org.techhub.DBConfig;
import java.sql.*;
import java.util.List;

import org.techhub.Model.EnrollmentsModel;
public class DBConfig {
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	public DBConfig()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/minionlinecourseenrollment","root","Rutuja2905");
		}
		catch(Exception e)
		{
			System.out.println("Error is :"+e);
			
		}
	}
}

package org.techhub.Repository;
import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.*;
import org.techhub.Model.*;

public class UserCourseRepoImpli extends DBConfig implements UserCourseRepo{

	List<CourseModel>cList;
	@Override
	public List<CourseModel> viewCourse() {
		try {
			cList=new ArrayList<CourseModel>();
			stmt=con.prepareStatement("select * from course where status=1 order by cid");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				CourseModel cm=new CourseModel();
				cm.setCid(rs.getInt(1));
				cm.setCname(rs.getString(2));
				cm.setInstructor(rs.getString(3));
				cm.setDuration(rs.getString(4));
				cm.setDesc(rs.getString(5));
				cList.add(cm);		
			}
			return cList;
		}
		catch(Exception e)
		{
			System.out.println("Error is:"+e);
			return null;
		}
	}
	@Override
	public boolean enrollCourse(int userId, int courseId) {
		// TODO Auto-generated method stub
		try {
			stmt=con.prepareStatement("insert into enrollments values('0',?,?,?)");
			stmt.setInt(1, userId);
			stmt.setInt(2, courseId);
			stmt.setInt(3,1);
			
			int value=stmt.executeUpdate();
			
			return value>0;
		}catch(Exception ex)
		{
			return false;
		}
	}
	
	public boolean isEnrolled(int userId, int courseId) {
	    try {
	        stmt = con.prepareStatement(
	            "SELECT 1 FROM enrollments WHERE user_id=? AND course_id=? AND status=1"
	        );
	        stmt.setInt(1, userId);
	        stmt.setInt(2, courseId);

	        rs = stmt.executeQuery();
	        return rs.next();

	    } catch (Exception e) {
	        System.out.println("Error: " + e);
	        return false;
	    }
	}
	@Override
	public List<EnrollmentsModel> viewEnrollment(int userId) {
		List<EnrollmentsModel> eList = new ArrayList<>();;
		try {
			stmt=con.prepareStatement("SELECT e.*, c.cname FROM enrollments e JOIN course c ON e.course_id = c.cid WHERE e.user_id=?");
			stmt.setInt(1, userId);
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				EnrollmentsModel em=new EnrollmentsModel();
				
				 em.setEid(rs.getInt("id"));
		            em.setUserID(rs.getInt("user_id"));
		            em.setCourseID(rs.getInt("course_id"));
		            em.setStatus(rs.getInt("status"));

		            em.setCname(rs.getString("cname"));
		            eList.add(em);
				
			}
		}catch(Exception ex)
		{
			return null;
		}
		return eList;
	}
	@Override
	public boolean updateProfile(int userId, String name, String email, String pass) {
		try {
	        stmt = con.prepareStatement(
	            "update user SET name=?, email=?, password=? where uid=?"
	        );

	        stmt.setString(1, name);
	        stmt.setString(2, email);
	        stmt.setString(3, pass);
	        stmt.setInt(4, userId);

	        return stmt.executeUpdate() > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}
	

}

package org.techhub.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.techhub.DBConfig.DBConfig;
import org.techhub.Model.CourseModel;
import org.techhub.Model.EnrollmentsModel;

public class CourseRepoImpl extends DBConfig implements CourseRepo {

	List<CourseModel>cList;
	@Override
	public boolean isAddCourse(CourseModel model) {
		try {
			stmt=con.prepareStatement("insert into course (cid,cname,instructor,duration,descr)values('0',?,?,?,?)");
			stmt.setString(1,model.getCname());
			stmt.setString(2,model.getInstructor());
			stmt.setString(3,model.getDuration());
			stmt.setString(4,model.getDesc());
			int value=stmt.executeUpdate();
			return value>0;
			
		}
		catch(Exception e)
		{
			System.out.println("Error is"+e);
			return false;
		}
	}

	@Override
	public List<CourseModel> getAllCourses() {
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
	public boolean isDeleteById(int id) {
		try {
			stmt=con.prepareStatement("update course set status=0 where cid=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
				return false;
			
			}
			catch(Exception e)
			{
				System.out.println("Error is:"+e);
				return false;
			}

	}

	@Override
	public boolean isupdateCourse(CourseModel model) {
		try {
			stmt=con.prepareStatement("update course set cname=?,instructor=?,duration=?,descr=? where cid=?");
			stmt.setString(1, model.getCname());
			stmt.setString(2, model.getInstructor());
			stmt.setString(3, model.getDuration());
			stmt.setString(4, model.getDesc());
			stmt.setInt(5,model.getCid());
			int value=stmt.executeUpdate();
			if(value>0)
			{
				return true;
			}
			else
				return false;
			
		} catch (SQLException e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}

	@Override
	public List<CourseModel> getCourseListByName(String name) {
		try {
			cList=new ArrayList<CourseModel>();
			stmt=con.prepareStatement("select * from course where cname like ? and status=1 order by cid");
			stmt.setString(1, "%"+name+"%");
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
	public List<EnrollmentsModel> viewAllEnrollment() {
		List<EnrollmentsModel> emodel=new ArrayList<EnrollmentsModel>();
		try {
			stmt=con.prepareStatement("select u.name,c.cname from course c join enrollments e on c.cid=e.cid join user u on e.uid=u.uid");
			rs=stmt.executeQuery();
			
			while(rs.next())
			{
				EnrollmentsModel em=new EnrollmentsModel();


				em.setCname(rs.getString("cname"));
		        em.setName(rs.getString("name"));
		        
		        emodel.add(em);
			}
			
			return emodel;
		}catch(Exception ex)
		{
			return null;
		}
	}

}

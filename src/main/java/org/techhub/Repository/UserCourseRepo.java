package org.techhub.Repository;
import org.techhub.Model.*;
import java.util.*;
public interface UserCourseRepo {
	public List<CourseModel> viewCourse();
	public boolean enrollCourse(int userId,int courseId);
	public boolean isEnrolled(int userId, int courseId);
	
	public List<EnrollmentsModel> viewEnrollment(int userId);
	public boolean updateProfile(int userId, String name, String email, String pass);
}

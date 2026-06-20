package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CourseModel;
import org.techhub.Model.EnrollmentsModel;
public interface UserService {
	public List<CourseModel> viewCourse();
	public boolean enrollCourse(int userId,int courseId);
	public boolean isEnrolled(int userId, int courseId);
	
	public List<EnrollmentsModel> viewEnrollment(int userId);
	public boolean updateProfile(int userId, String name, String email, String pass);
}

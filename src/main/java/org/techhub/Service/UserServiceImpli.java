package org.techhub.Service;

import org.techhub.Repository.*;

import java.util.List;

import org.techhub.Model.*;
public class UserServiceImpli implements UserService{

	UserCourseRepo user=new UserCourseRepoImpli();
	@Override
	public List<CourseModel> viewCourse() {
		// TODO Auto-generated method stub
		return user.viewCourse();
	}
	
	public boolean enrollCourse(int userId,int courseId) {
		return user.enrollCourse(userId, courseId);
	}

	@Override
	public boolean isEnrolled(int userId, int courseId) {
		// TODO Auto-generated method stub
		return user.isEnrolled(userId, courseId);
	}

	@Override
	public List<EnrollmentsModel> viewEnrollment(int userId) {
		// TODO Auto-generated method stub
		return user.viewEnrollment(userId);
	}

	@Override
	public boolean updateProfile(int userId, String name, String email, String pass) {
		// TODO Auto-generated method stub
		return user.updateProfile(userId, name, email, pass);
	}

}

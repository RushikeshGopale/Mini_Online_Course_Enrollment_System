package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CourseModel;
import org.techhub.Model.EnrollmentsModel;
import org.techhub.Repository.*;

public class CourseServiceImpl implements CourseService {

	CourseRepo crepo=new CourseRepoImpl();
	@Override
	public boolean isAddCourse(CourseModel model) {
		// TODO Auto-generated method stub
		return crepo.isAddCourse(model);
	}
	@Override
	public List<CourseModel> getAllCourses() {
		// TODO Auto-generated method stub
		return crepo.getAllCourses();
	}
	@Override
	public boolean isDeleteById(int id) {
		// TODO Auto-generated method stub
		return crepo.isDeleteById(id);
	}
	@Override
	public boolean isupdateCourse(CourseModel model) {
		// TODO Auto-generated method stub
		return crepo.isupdateCourse(model);
	}
	@Override
	public List<CourseModel> getCourseListByName(String name) {
		// TODO Auto-generated method stub
		return crepo.getCourseListByName(name);
	}
	@Override
	public List<EnrollmentsModel> viewAllEnrollment() {
		// TODO Auto-generated method stub
		return crepo.viewAllEnrollment();
	}

}

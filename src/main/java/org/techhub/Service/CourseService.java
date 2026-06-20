package org.techhub.Service;

import java.util.List;

import org.techhub.Model.CourseModel;
import org.techhub.Model.EnrollmentsModel;

public interface CourseService {
	public boolean isAddCourse(CourseModel model);
	public List<CourseModel> getAllCourses();
	public boolean isDeleteById(int id);
	public boolean isupdateCourse(CourseModel model);
	public List<CourseModel> getCourseListByName(String name);
	public List<EnrollmentsModel> viewAllEnrollment();
}

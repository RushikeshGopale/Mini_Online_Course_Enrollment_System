package org.techhub.Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EnrollmentsModel extends CourseModel {
	private int eid;
	private int userID;
	private int courseID;
	private int status;
	private String userName; 
}

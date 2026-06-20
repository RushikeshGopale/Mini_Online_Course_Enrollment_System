package org.techhub.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseModel extends RegisterModel{
	private int cid;
	private String cname;
	private String instructor;
	private String duration;
	private String desc;
	

}

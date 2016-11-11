package org.ulv.pro.langen.model;

public class Lesson extends NamedEntity {

	private static final long serialVersionUID = 9126266427191636319L;
	
	private Integer courseId;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}

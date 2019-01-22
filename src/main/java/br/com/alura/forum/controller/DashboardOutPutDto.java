package br.com.alura.forum.controller;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.topic.domain.Topic;

public class DashboardOutPutDto {
	

	private String courseName;
	private List<String> subcategoryName;
	private String categoryName;
	private int alltopics;
    private int lastWeektopics;
    private int unansweredtopics;
    
    public DashboardOutPutDto(Topic topic) {
		this.courseName = topic.getCourse().getName();
		//sthis.subcategoryName = ?;
		this.categoryName = topic.getCourse().getCategoryName();
		this.alltopics = alltopics;
		this.lastWeektopics = lastWeektopics;
		this.unansweredtopics = unansweredtopics;
    	
	}
    
	public static List<DashboardOutPutDto> listFromTopics(List<Topic> topics) {
		return topics.stream().map(DashboardOutPutDto :: new).collect(Collectors.toList());
	}

	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
//	public String getSubcategoryName() {
//		return subcategoryName;
//	}
//	public void setSubcategoryName(String subcategoryName) {
//		this.subcategoryName = subcategoryName;
//	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}

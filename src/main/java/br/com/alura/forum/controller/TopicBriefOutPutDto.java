package br.com.alura.forum.controller;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.model.topic.domain.TopicStatus;
	
public class TopicBriefOutPutDto {

	private Long id;
	private String shortDescription;
	private long secondsSinceLastUpdate;
	private String ownerName;
	private String courseName;
	private String subcategoryName;
	private String categoryName;
	private int numberOfResponses;
	private boolean solved;

	public TopicBriefOutPutDto(Topic topic) {
		this.id = topic.getId();
		this.shortDescription = topic.getShortDescription();
		this.secondsSinceLastUpdate = getSecondsSince(topic.getLastUpdate());
		this.ownerName = topic.getOwner().getName();
		this.courseName = topic.getCourse().getName();
		this.subcategoryName = topic.getCourse().getSubcategoryName();
		this.categoryName = topic.getCourse().getCategoryName();
		this.numberOfResponses = topic.getNumberOfAnswers();
		this.solved = TopicStatus.SOLVED.equals(topic.getStatus());
		
		}
	
	private long getSecondsSince(Instant lastUpadate) {
		return Duration.between(lastUpadate, Instant.now())
				.get(ChronoUnit.SECONDS);
		
	}

	public static List<TopicBriefOutPutDto> listFromTopics(List<Topic> topics){
		return topics.stream()
				.map(TopicBriefOutPutDto :: new).collect(Collectors.toList());
	}
	
	public Long getId() {
		return id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public long getSecondsSinceLastUpdate() {
		return secondsSinceLastUpdate;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int getNumberOfResponses() {
		return numberOfResponses;
	}

	public boolean isSolved() {
		return solved;
	}

}

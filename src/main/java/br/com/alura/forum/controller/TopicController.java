package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.User;
import br.com.alura.forum.model.topic.domain.Topic;

@RestController
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping(value = "/api/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutPutDto> listTopics(){
//		
//		Category subCategory = new Category("java", new Category("Programação"));
//		Course course = new Course("java e JSF", subCategory);
//		Topic topic = new Topic("Problemas com JSF", "Erro ao fazer conversão de data", 
//				new User("Fulano", "fulano@gmail.com", "123456"), course);
		
		
		
		
		List <Topic> topics = topicRepository.findAll();
		return TopicBriefOutPutDto.listFromTopics(topics);
	}

}

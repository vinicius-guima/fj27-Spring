package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.input.TopicSearchInputDto;
import br.com.alura.forum.controller.repository.TopicRepository;
import br.com.alura.forum.model.topic.domain.Topic;

@RestController
public class TopicController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@GetMapping(value = "/api/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TopicBriefOutPutDto> listTopics(TopicSearchInputDto topicSearch){
//		
//		Category subCategory = new Category("java", new Category("Programação"));
//		Course course = new Course("java e JSF", subCategory);
//		Topic topic = new Topic("Problemas com JSF", "Erro ao fazer conversão de data", 
//				new User("Fulano", "fulano@gmail.com", "123456"), course);
	
		Specification<Topic> topicSearchSpecification = topicSearch.build();
		List <Topic> topics = topicRepository.findAll(topicSearchSpecification);
		
		return TopicBriefOutPutDto.listFromTopics(topics);
	}

}

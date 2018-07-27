package com.tandt.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics=  new ArrayList<>( Arrays.asList(
			new Topic("1","thinking in java","java books"),
			new Topic("2","thinking in Spring","spring framework books"),
			new Topic("3","thinking in C++","C++ books"),
			new Topic("4","thinking in Phyton","Phyton books"),
			new Topic("5","thinking in Javascript","Javascript books") 
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		Topic topic= topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		return topic;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
		
	}

	public void updateTopic(String id, Topic topic) {

       for(int i=0;i<topics.size();i++) {
    	   Topic t= topics.get(i);
    	   if(t.getId().equals(id)) {
    		   topics.set(i, topic);
    		   return;
    	   }
    	   
       }
		
	}

	public void deleteTopic(String id) {
	   topics.removeIf(t-> t.getId().equals(id));		
	}

}

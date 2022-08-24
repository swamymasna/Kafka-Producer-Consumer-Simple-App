package com.swamy.messagestore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {

	private List<String>list = new ArrayList<>();

	public void addMessages(String message) {
		list.add(message);
	}
	
	public String getListData() {
		return list.toString();
	}
}







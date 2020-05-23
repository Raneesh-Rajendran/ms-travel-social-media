package com.ms.travel.social.content.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ms.travel.social.content.configuration.ContentConfiguration;

@RestController
public class ContentController {
	
	@Autowired
	private ContentConfiguration config;
	
	@GetMapping("/static")
	public StaticContent getContent() {
		StaticContent content = new StaticContent();
		content.setString1(config.getString1());
		content.setString2(config.getString2());
		return content;
	}
	

}

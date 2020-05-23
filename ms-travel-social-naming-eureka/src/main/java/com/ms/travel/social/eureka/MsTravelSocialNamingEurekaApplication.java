package com.ms.travel.social.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsTravelSocialNamingEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTravelSocialNamingEurekaApplication.class, args);
	}

}

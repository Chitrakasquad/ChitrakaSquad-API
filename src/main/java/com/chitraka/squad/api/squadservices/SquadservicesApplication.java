package com.chitraka.squad.api.squadservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.chitraka.squad.api.squadservices.model.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class SquadservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SquadservicesApplication.class, args);
	}

}

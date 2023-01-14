package com.example.meetingrooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.meetingrooms.repository")
@EntityScan("com.example.meetingrooms.entity")
public class MeetingRoomApplication {


	public static void main(String[] args) {
		SpringApplication.run(MeetingRoomApplication.class, args);
	}
}

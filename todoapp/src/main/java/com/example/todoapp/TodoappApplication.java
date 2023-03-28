package com.example.todoapp;

import com.example.todoapp.model.Task;
import com.example.todoapp.repo.TaskRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.Month;

import static com.example.todoapp.enumeration.Status.TASK_COMPLETED;

@SpringBootApplication
public class TodoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoappApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner (TaskRepo taskRepo) {
		return args -> {
			taskRepo.save(new Task(
					null,
					"Do assignment 1",
					"Full stack",
					LocalDateTime.of(2017, Month.FEBRUARY,3,6,30,40,50000 ),
					TASK_COMPLETED,
					false,
					LocalDateTime.of(2017, Month.JANUARY,3,6,30,40,50000 ),
					LocalDateTime.of(2017, Month.JANUARY,3,8,30,40,50000 )));

			taskRepo.save(new Task(
					null, "Do assignment 2",
					"Front end",
					LocalDateTime.of(2019, Month.SEPTEMBER,1,2,44,56,50000 ),
					TASK_COMPLETED,
					false,
					LocalDateTime.of(2019, Month.DECEMBER,3,1,30,40,50000 ),
					LocalDateTime.of(2019, Month.DECEMBER,3,13,30,40,40000 )));

			taskRepo.save(new Task(
					null, "Do assignment 3",
					"Back end",
					LocalDateTime.of(2019, Month.FEBRUARY,3,6,30,40,50000 ),
					TASK_COMPLETED,
					false,
					LocalDateTime.of(2020, Month.JANUARY,3,6,30,40,50000 ),
					LocalDateTime.of(2022, Month.JANUARY,3,8,30,40,50000 )));
		};
	}

}

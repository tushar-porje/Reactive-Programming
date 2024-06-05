package com.reactiveprogramming.webflux.webfluxproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reactiveprogramming.webflux.webfluxproject.student.Student;
import com.reactiveprogramming.webflux.webfluxproject.student.StudentRepository;

@SpringBootApplication
public class WebfluxprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxprojectApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				repository.save(
						Student.builder()
								.firstname("Test" + i)
								.lastname("test" + i)
								.age(i)
								.build()
				).subscribe();
			}
		};
	}

}

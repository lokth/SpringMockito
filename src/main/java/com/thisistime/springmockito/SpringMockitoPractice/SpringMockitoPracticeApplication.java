package com.thisistime.springmockito.SpringMockitoPractice;

		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMockitoPracticeApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringMockitoPracticeApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringMockitoPracticeApplication.class, args);
	}



	@Bean
	public CommandLineRunner setUp(ToDoRepository toDoRepository){
		return (args) -> {
			toDoRepository.save(new ToDo("Revode unused imports", true));
			toDoRepository.save(new ToDo("Clean the code", true));
			toDoRepository.save(new ToDo("Build the artifacts", false));
			toDoRepository.save(new ToDo("Deploy the jar file", true));
			logger.info("The sample data has been generated");
		};
	}
}

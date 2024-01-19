package com.coderains.learnspringframework.learnspringFramwork6;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coderains.learnspringframework.learnspringFramwork6.config.ApplicationConfig;
import com.coderains.learnspringframework.learnspringFramwork6.games.GameRunner;
import com.coderains.learnspringframework.learnspringFramwork6.games.Mario;

@SpringBootApplication
public class LearnSpringFramwork6Application {

	private static GameRunner gameRunner = new GameRunner(new Mario());

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		System.out.println(context.getBean("name"));
		gameRunner.run();
		context.close();
	}

}

package com.gryszkoszymon.projectplanner;

import com.gryszkoszymon.projectplanner.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EnableWebSecurity
public class ProjectPlannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPlannerApplication.class, args);
	}

}

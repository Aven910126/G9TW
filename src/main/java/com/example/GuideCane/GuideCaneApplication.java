package com.example.GuideCane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan(basePackages = "package com.example.GuideCane.model;")
@EnableJpaAuditing
public class GuideCaneApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuideCaneApplication.class, args);
	}
}

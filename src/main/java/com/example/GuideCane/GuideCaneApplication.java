package com.example.GuideCane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"<com.example.GuideCane>"})
@EnableJpaRepositories(basePackages="<com.example.GuideCane.repository>")
@EnableTransactionManagement
@EntityScan(basePackages="<com.example.GuideCane.model>")
public class GuideCaneApplication {
	public static void main(String[] args) {
		SpringApplication.run(GuideCaneApplication.class, args);
	}
}

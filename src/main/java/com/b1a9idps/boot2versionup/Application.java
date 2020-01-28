package com.b1a9idps.boot2versionup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.b1a9idps.boot2versionup.binder")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

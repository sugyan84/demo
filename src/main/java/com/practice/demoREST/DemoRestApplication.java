package com.practice.demoREST;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.practice")
public class DemoRestApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoRestApplication.class, args);

        SpringApplication app = new SpringApplication(DemoRestApplication.class);
        //app.setBanner(new BannerPrinter());
        app.setAddCommandLineProperties(false);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.setAdditionalProfiles("stage");
        app.run(args);

        //System.exit(SpringApplication.exit(SpringApplication.run(DemoRestApplication.class, args)));
    }
}

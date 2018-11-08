package com.practice.demoREST;

import java.util.Base64;
import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@ComponentScan(basePackages = "com.practice")
@PropertySource("classpath:test.properties")
public class DemoRestApplication {

    public static void main(String[] args) {
        //SpringApplication.run(DemoRestApplication.class, args);

        SpringApplication app = new SpringApplication(DemoRestApplication.class);
        //app.setBanner(new BannerPrinter());
        app.setAddCommandLineProperties(false);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
        app.setAdditionalProfiles("dev");
        app.run(args);

        System.out.println("Base64 encode: "+(Base64.getEncoder().encodeToString("username:password".getBytes())));

        //System.exit(SpringApplication.exit(SpringApplication.run(DemoRestApplication.class, args)));
    }
}

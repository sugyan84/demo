package com.practice.resources;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.practice.consumers.trial.DemoConsumer;


@RestController
@RequestMapping("/user")
public class UserResource {

    private int counter;

    @Value("${developer.name}")
    private String developerName;

    @Value("${developer.rollNo}")
    private String developerRollNo;

    @Autowired
    private Environment env;

    @RequestMapping(value = {"/test", "/trial"},
                    method = RequestMethod.GET,
                    produces = MediaType.TEXT_PLAIN )
    public String test() {
        counter = counter + 1;
        DemoConsumer consumer = new DemoConsumer();

        StringBuffer retVal = new StringBuffer();

        retVal.append("Value using Environment is |"+env.getProperty("developer.rollNo")+"|");
        retVal.append("\n");
        retVal.append("Value using @Value is |"+developerRollNo+"|");

        return retVal.toString();
    }
}

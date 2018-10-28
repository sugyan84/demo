package com.practice.resources;

import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.practice.consumers.trial.DemoConsumer;


@RestController
@RequestMapping("/user")
public class UserResource {

    private int counter;

    @RequestMapping(value = {"/test", "/trial"},
                    method = RequestMethod.GET,
                    produces = MediaType.TEXT_PLAIN )
    public String test() {
        counter = counter + 1;
        DemoConsumer consumer = new DemoConsumer();

        return consumer.getEmployees();
    }
}

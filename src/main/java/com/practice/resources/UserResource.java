package com.practice.resources;

import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @Value("${developer.contact}")
    private String developerContact;

    @Autowired
    private Environment env;

    @RequestMapping(value = {"/test", "/trial"},
                    method = RequestMethod.GET,
                    produces = MediaType.TEXT_PLAIN )
    public String test(HttpServletRequest request) {
        counter = counter + 1;
        DemoConsumer consumer = new DemoConsumer();

        StringBuffer retVal = new StringBuffer();

        retVal.append("Developer Name: |"+env.getProperty("developer.name")+"|");
        retVal.append("\n");
        retVal.append("Contact: |"+ developerContact +"|");

        System.out.println("IP Address: "+request.getRemoteAddr());

        return retVal.toString();
    }


    @GetMapping("/basic")
    public String basicAuth(@RequestHeader("Authorization") String header){

        String[] splitHeader = header.split(" ");

        byte[] arr = Base64.getDecoder().decode(header);

        String decodedStr = String.valueOf(arr);

        header = splitHeader[1];

        System.out.println(header);

        StringBuffer sbfr = new StringBuffer();
        sbfr.append("Header received=|"+header);
        sbfr.append("\n");
        sbfr.append("Decoding to:|"+ decodedStr);
        sbfr.append("\n");

        return sbfr.toString();
    }
}

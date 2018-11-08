package com.practice.resources;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.practice.consumers.interf.ResponseDTO;
import com.practice.consumers.interf.ServiceDispatcher;


@RestController
@RequestMapping("/news")
public class NewsResource {

    @Autowired
    @Qualifier(value = "newsServiceDispatcher")
    private ServiceDispatcher serviceDispatcher;


    @GetMapping(value = "/top", produces = MediaType.APPLICATION_JSON)
    @ResponseBody
    public ResponseDTO getTopHeadlines(){
       return serviceDispatcher.makeCall();
    }

}

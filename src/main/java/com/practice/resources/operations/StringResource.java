package com.practice.resources.operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practice.services.string.StringService;


@RestController
@RequestMapping("/string")
public class StringResource {

    @Autowired
    private StringService service;

    @Value("${string.input.max.length}")
    int maxInputStringLength;

    @GetMapping("/wordRepeatCounter")
    public String duplicateWordCounter(@RequestParam("input") String input) {

        if (input == null) {
            return "Input string is null";
        }

        if (input != null && input.length() > maxInputStringLength) {
            return "Input String shouldn't be greater than "+maxInputStringLength+" characters.";
        }

        return service.duplicateWordCounter(input);
    }
}

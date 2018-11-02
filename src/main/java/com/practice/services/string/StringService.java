package com.practice.services.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.stereotype.Service;


@Service
public class StringService {

    public String duplicateWordCounter(String input) {

        Map<String, Integer> counterMap = new HashMap<>();

        String[] strSplit = input.trim().split(" ");

        for (int i = 0; i < strSplit.length; i++) {

            if (counterMap.containsKey(strSplit[i].trim())) {
                counterMap.put(strSplit[i], counterMap.get(strSplit[i]) + 1);
            } else {
                counterMap.put(strSplit[i], 1);
            }
        }

        Iterator itr = counterMap.entrySet().iterator();
        StringBuffer response = new StringBuffer();

        while (itr.hasNext()){
            Map.Entry entry = (Map.Entry) itr.next();

            response.append(entry.getKey()+" --> "+entry.getValue());
            response.append("\n");
        }

        return response.toString();
    }
}

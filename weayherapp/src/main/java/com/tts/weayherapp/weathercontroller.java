package com.tts.weayherapp;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class weathercontroller {
    @Autowired
    private weatherservice weatherService;

    // @GetMapping("/")
    // public String getIndex(Model model) {
    // response response = weatherService.getForecast("43210");
    // model.addAttribute("data", response);
    // return "index";
    // }
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("request", new request());
        return "index";
    }

    @PostMapping("/")
    public String postIndex(request request, Model model) {
        response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }
}
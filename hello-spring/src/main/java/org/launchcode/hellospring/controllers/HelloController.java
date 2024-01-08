package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //handle request at path http://localhost:8080/hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //handle request at path http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handle request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handle requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name= 'languages' id= 'language-select'>" +
                "<option value=''>--Please choose an option--</option>" +
                "<option value='English'>English</option>" +
                "<option value='Indonesian'>Indonesian</option>" +
                "<option value='Batak'>Batak</option>" +
                "<option value='Kiswahili'>Kiswahili</option>" +
                "<option value='Norwegian'>Norwegian</option>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name==null) {
            name = "World";
        }
        else if (language.equals("Indonesian") && name==null){
            name = "Dunia";
        } else if (language.equals("Batak") && name==null) {
            name = "Portibi";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("English")) {
            greeting = "Hello";
        } else if (l.equals("Indonesian")) {
            greeting = "Halo";
        } else if (l.equals("Batak")) {
            greeting = "Horas";
        }

        return greeting + " " + n;
    }
}

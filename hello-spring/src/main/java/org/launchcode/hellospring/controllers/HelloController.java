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
                "<form action='hello/form' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name= 'language' id= 'language'>" +
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

    @RequestMapping(value = "hello/form", method= RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name=="" && language.equals("English")) {
            name = "World";
        } else if (name=="" && language.equals("Indonesian")) {
            name = "Dunia";
        } else if (name=="" && language.equals("Batak")) {
            name = "Portibi";
        } else if (name=="" && language.equals("Kiswahili")) {
            name = "Dunia";
        } else if (name=="" && language.equals("Norwegian")) {
            name = "Verden";
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
        } else if (l.equals("Kiswahili")) {
            greeting = "Habari";
        } else if (l.equals("Norwegian")) {
            greeting = "Hallo";
        }

        return "<html>" +
                "<h1 style= 'color: red'>" + greeting + ", " + n + "!</h1>" +
                "</html>";
    }
}

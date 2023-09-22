package com.studio8.springandcontrollersch8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class SkillsController {

    @GetMapping("/")
    public String renderSkills() {

        return "<html>"+
                "<body>" +

                "<h1>Skills Tracker</h1>" +
                "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                "<ol>" +
                "<li>Java</li>" +
                "<li>JavaScript</li>" +
                "<li>Python</li>" +
                "</ol>" +
                "<a href='/form'>Fill out your form</a>" +

                "</body>" +
                "</html>";
    }



    /** When we submit a form, we are making a POST request,
     * the inputs we filled in with our answers are now sent
     * in the body of our POST request. In our case, we
     * sent an object from our form to our Post method that
     * it can read. Our Post body from our form would look
     * something like this.
     *
     * {
     * name: userInput,
     * fave1: userInput,
     * fave2: userInput,
     * fave3: userInput,
     * }
     *
     * Now our PostMapping has these properties passed to it that
     * it can read and use. It can access the object with @RequestParam
     * annotation. We have to name our RequestParam arguments with
     * the exact name of the key in our request data, otherwise, it won't
     * have anything to access and return null.
     * **/



    @GetMapping("/form")
    public String formController() {
        return "<html>" +
                "<body>" +

                "<form action='form' method='POST'" +

                "<label>Name:</label>" +
                "<input type='text' name='userName' /><br/>" +

                "<label>My favorite language:</label>" +
                "<select name='fave1'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='TypeScript'>TypeScript</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='Ruby'>Ruby</option>" +
                "</select><br />" +

                "<label>My second favorite language:</label>" +
                "<select name='fave2'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='TypeScript'>TypeScript</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='Ruby'>Ruby</option>" +
                "</select><br />" +

                "<label>My third favorite language:</label>" +
                "<select name='fave3'>" +
                "<option value='Java'>Java</option>" +
                "<option value='JavaScript'>JavaScript</option>" +
                "<option value='TypeScript'>TypeScript</option>" +
                "<option value='Python'>Python</option>" +
                "<option value='Ruby'>Ruby</option>" +
                "</select><br />" +

                "<input type='submit' value='Submit' />" +

                "</form>" +
                "</body>" +
                "</html>";
    }

    @PostMapping("/form")
    public String renderSkills(@RequestParam String userName, String fave1, String fave2, String fave3) {
        return "<html>" +
                "<body>" +

                "<h1>" + userName + "</h1>" +
                "<h3>Favorite Languages</h3>" +
                "<ol>" +
                "<li>" + fave1 + "</li>" +
                "<li>" + fave2 + "</li>" +
                "<li>" + fave3 + "</li>" +
                "</ol>" +

                "</body>" +
                "</html>";
    }
}

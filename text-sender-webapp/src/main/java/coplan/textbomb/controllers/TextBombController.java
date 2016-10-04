package coplan.textbomb.controllers;

import coplan.textbomb.messaging.Sender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class TextBombController {

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.GET)
    public String showHomePage(ModelMap modelMap) {
        ArrayList<String> carrierList = new ArrayList<String>();

        carrierList.add("AT&T");
        carrierList.add("Verizon");

        modelMap.put("carriers", carrierList);

        return "index";
    }

    @RequestMapping(value = {"/", "/home", "/index"}, method = RequestMethod.POST)
    public String initTextBomb(@RequestParam("phone_number") final String phoneNumber, @RequestParam("carrier") final String carrier, @RequestParam("message_text") final String messageText, @RequestParam("num_messages") final int numMessages, @RequestParam("delay") final int delay, @RequestParam("gmail_username") final String gmailUsername, @RequestParam("gmail_password") final String gmailPassword, ModelMap modelMap){

        System.out.println("Init text bomb activated to " + phoneNumber);

        HashMap<String,String> carrierMap = new HashMap<String,String>();
        carrierMap.put("AT&T", "@txt.att.net");
        carrierMap.put("Verizon", "@vzwpix.com");

        String carrierExtension = carrierMap.get(carrier);

        Sender.send(phoneNumber, carrierExtension, numMessages, delay, messageText, gmailUsername, gmailPassword);

        modelMap.put("message", "Text bomb successfully initiated to " + phoneNumber);
        return "index";
    }
}
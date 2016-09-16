package coplan.execution;


import coplan.messaging.Sender;

import java.util.HashMap;
import java.util.Set;

public class Driver {

    public static void main(String[] args) {

        HashMap<String,String> carriers = new HashMap<String,String>();
        carriers.put("AT&T", "attemail");
        carriers.put("Verizon", "vzwpix");

        Set<String> carrierList = carriers.keySet();

        Prompter prompter = new Prompter();

        //gets the phone number
        final String phoneNumber = prompter.prompt("Please enter a valid 10-digit US phone number:");
        if(phoneNumber.length() != 10){
            System.out.println("Invalid phone number!");
            System.exit(-1);
        }

        //gets the carrier
        String carrierPrompt = "Please enter one of the available carriers (";
        for(String carrierName : carrierList){
            carrierPrompt += (carrierName + " ");
        }
        carrierPrompt = carrierPrompt.trim() + "):";

        String carrierName = prompter.prompt(carrierPrompt);
        if(!carriers.containsKey(carrierName)) {
            System.out.println("Invalid carrier!");
            System.exit(-1);
        }
        final String carrierExtension = carriers.get(carrierName);

        //gets the number of messages to send
        final int numMessages = Integer.parseInt(prompter.prompt("Enter the number of messages you would like to send:"));
        if(numMessages <= 0 || numMessages >= 1000){
            System.out.println("Invalid number of messages! Please choose a number between 1 and 999 inclusive.");
            System.exit(-1);
        }

        //gets the number of seconds to delay between messages
        final int delay = Integer.parseInt(prompter.prompt("Enter the delay in seconds between each message:"));
        if(delay <= 0 || delay >= 10 * 60){
            System.out.println("Invalid delay between messages. Please choose a value between one second and ten minutes.");
            System.exit(-1);
        }

        //gets your gmail username
        final String gmailUsername = prompter.prompt("Enter your gmail username:");

        //gets your gmail password (hidden user input)
        final String gmailPassword = prompter.promptPassword("Enter your gmail password:");

        System.out.println("\nInput recieved successfully.\n");

        Sender.send(phoneNumber, carrierExtension, numMessages, delay, gmailUsername, gmailPassword);
    }
}

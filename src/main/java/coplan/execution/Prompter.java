package coplan.execution;

import java.util.Scanner;

/**
 * Created by afcoplan on 9/16/16.
 */
public class Prompter {

    private Scanner scanner;

    public Prompter(){
        this.scanner = new Scanner(System.in);
    }

    public String prompt(String message){
        System.out.print(message + " ");
        return scanner.nextLine();
    }
}

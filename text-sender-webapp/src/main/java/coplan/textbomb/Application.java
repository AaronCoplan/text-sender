package coplan.textbomb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args){

        //redirect System.out to a log file
        String logfilePath = "/home/afcoplan/text-bomb-webapp.log";
        File logFile = new File(logfilePath);
        if(logFile.exists()){
            logFile.delete();
            try{
                logFile.createNewFile();
            }catch(Exception e){
                e.printStackTrace();
                System.exit(-1);
            }
        }else{
            try{
                logFile.createNewFile();
            }catch(Exception e){
                e.printStackTrace();
                System.exit(-1);
            }
        }

        try{
            PrintStream logFileStream = new PrintStream(logFile);
            System.setOut(logFileStream);
            System.setErr(logFileStream);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        SpringApplication.run(Application.class, args);
    }
}

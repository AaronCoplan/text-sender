# text-sender

Command line or webapp based text sender. Prompts for user input and sends messages based on the input parameters.

This project is licensed under the MIT License.

## Instructions for how to run single instance:

* Clone the repository: `git clone https://github.com/AaronCoplan/text-sender` or `git clone git@github.com:AaronCoplan/text-sender.git`
* Change directory into the project directory: `cd text-sender/text-sender`
* Run `mvn clean package`
* Run `java -jar target/text-sender-v1.0.0-jar-with-dependencies.jar`
* Respond to the prompts and enjoy!

## Instructions for running the webapp:

* Clone the repository: `git clone https://github.com/AaronCoplan/text-sender` or `git clone git@github.com:AaronCoplan/text-sender.git`
* Change directory into the project directory: `cd text-sender/text-sender-webapp/`
* Run `mvn clean package`
* Run `java -jar target/web-app-v0.0.1.jar &` (log file will be named text-bomb-webapp.log)
* In a browser, navigate to http://localhost:8080
* When done, run: `ps aux | grep webapp`
* Get the process number from the results and run: `kill <process number>`

## Dependencies

The following dependencies must be met in order for the above build instructions to work:

* Maven
* Java
* Git

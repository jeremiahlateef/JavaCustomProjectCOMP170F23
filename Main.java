import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // import Scanner that will be used to requests user input
        Scanner170 console = new Scanner170(System.in);
        welcomeStatement(console);
        // Store the username of the user and call it when necessary.
        String username = console.next();
        // Store all the responses in a variable
        String responseOne = "";
        String responseTwo = "";
        String responseThree = "";
        // Create methods for each category.
        // Add method that will store the value of each category

        cuisine(responseOne, console);
        allergies(responseTwo, console);
        preference(responseThree, console);

        // create the main method that will process all the responses and data.
        userResponses(responseOne, responseTwo, responseThree);

        //Print a goodbye message
        goodbyeStatement();
    }

    public static void welcomeStatement(Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./welcomeMessage.txt"));
        System.out.println(input);
        String name = console.nextLine();
        System.out.println("Thanks" + name + "answer these three questions to get your personalised recipe list.");
    }

    public static String cuisine(String responseOne, Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./cuisine.txt"));
        System.out.println(input);
        String continent = console.nextLine();

        String answer = console.next();
        answer = answer.toUpperCase(); //convert each answer to uppercase
        answer = responseOne;
        return responseOne;
    }

    // create a method for allergies
    public static String allergies(String responseTwo, Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./allergies.txt"));
        System.out.println(input);
        String allergies = console.nextLine();
        return responseTwo;
    }

    // create a method for dietary preference
    public static String preference(String responseThree, Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./preference.txt"));
        System.out.println(input);
        String preference = console.nextLine();
        return responseThree;
    }

    //create a method that will aggregate all the responses from the user
    //The method will be used to extract information from the JSON file and print it out to the console.
    public static void userResponses(String responseOne, String responseTwo, String responseThree) {

    }

    // create a method that will report the goodbye statement
    public static void goodbyeStatement() throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./goodbyeStatement.txt"));
        System.out.println(input);
    }

}

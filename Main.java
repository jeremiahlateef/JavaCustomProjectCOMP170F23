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
                // Parse the JSON file
        Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));


        // System.out.println("hi");
        // Parse the JSON file
        // Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));

        //typecast the recipeObj to JSONObject

        // Create a JSON Object
        JSONObject recipeObj = (JSONObject) jsonObj;

        //Get European address
        Map continent = ((Map) recipeObj.get("European"));

        //Create an array and get the meal array from the continent object
        JSONArray recipeArr = (JSONArray) continent.get("meal");

        //create an iterator for the meal array
        Iterator<Object> mealIterator = recipeArr.iterator();

        //Create a boolean variable to retrieve the vegan menu based on its truism or falsity.
        boolean vegan = true;
        //Use a while loop to iterate through the meal Array
        while (mealIterator.hasNext()) {
            //Create an object for the meal object
            JSONObject menu = (JSONObject) mealIterator.next();


            if (vegan) {
                if ((Boolean) menu.get("vegan")) {
                    //if true, prints vegan true value
                    //if false, prints vegan false value
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get("nuts");

                    //System.out.println("Answer");
                    Iterator<Object> finalMenuIterator = allergies.iterator();
                    while (finalMenuIterator.hasNext()) {
                        System.out.println(finalMenuIterator.next());
                    }
                    //System.exit(0);
                }
            } else {
                if (!(Boolean) menu.get("vegan")) {
                    //if true, prints vegan true value
                    //if false, prints vegan false value
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get("nuts");

                    //System.out.println("Answer");
                    Iterator<Object> finalMenuIterator = allergies.iterator();
                    while (finalMenuIterator.hasNext()) {
                        System.out.println(finalMenuIterator.next());
                    }
                    System.exit(0);
                }
            }

//

        }
        System.exit(0);
        
        // import Scanner that will be used to requests user input
        Scanner170 console = new Scanner170(System.in);
        //welcomeStatement(console);
        // Store the username of the user and call it when necessary.
        String username = console.next();
        // Store all the responses in a variable
        String responseOne = "";
        boolean responseTwo = true;
        String responseThree = "";
        // Create methods for each category.
        // Add method that will store the value of each category

        cuisine(console);
        allergies(console);
        preference(console);

        //
        // System.out.println("hi");


        // create the main method that will process all the responses and data.
        //userResponses(responseOne, responseTwo, responseThree);

        //Print a goodbye message
        // goodbyeStatement();
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
    public static void userResponses(String responseOne, boolean responseTwo, String responseThree) {
    
        // Parse the JSON file
        Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));


        // System.out.println("hi");
        // Parse the JSON file
        // Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));

        //typecast the recipeObj to JSONObject

        // Create a JSON Object
        JSONObject recipeObj = (JSONObject) jsonObj;

        //Get European address
        Map continent = ((Map) recipeObj.get("European"));

        //Create an array and get the meal array from the continent object
        JSONArray recipeArr = (JSONArray) continent.get("meal");

        //create an iterator for the meal array
        Iterator<Object> mealIterator = recipeArr.iterator();

        //Create a boolean variable to retrieve the vegan menu based on its truism or falsity.
        boolean vegan = true;
        //Use a while loop to iterate through the meal Array
        while (mealIterator.hasNext()) {
            //Create an object for the meal object
            JSONObject menu = (JSONObject) mealIterator.next();


            if (vegan) {
                if ((Boolean) menu.get("vegan")) {
                    //if true, prints vegan true value
                    //if false, prints vegan false value
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get("nuts");

                    //System.out.println("Answer");
                    Iterator<Object> finalMenuIterator = allergies.iterator();
                    while (finalMenuIterator.hasNext()) {
                        System.out.println(finalMenuIterator.next());
                    }
                    //System.exit(0);
                }
            } else {
                if (!(Boolean) menu.get("vegan")) {
                    //if true, prints vegan true value
                    //if false, prints vegan false value
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get("nuts");

                    //System.out.println("Answer");
                    Iterator<Object> finalMenuIterator = allergies.iterator();
                    while (finalMenuIterator.hasNext()) {
                        System.out.println(finalMenuIterator.next());
                    }
                    // System.exit(0);
                }
            }

//

        }
        //System.exit(0);
        



    }

    // create a method that will report the goodbye statement
    public static void goodbyeStatement() throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./goodbyeStatement.txt"));
        System.out.println(input);
    }

}

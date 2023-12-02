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
    public static void main(String[] args) throws FileNotFoundException, Exception {

        // import the Scanner object that will be used to request user input
        Scanner170 console = new Scanner170(System.in);

        welcomeStatement(console);
        // Store the username of the user and call it when necessary.

        // String username = console.next();
        // Store all the responses these variable
        String responseOne = cuisine(console);
        String responseTwo = allergies(console);
        boolean responseThree = preference(console);
        //Print a goodbye message to the user
        goodbyeStatement();
//        System.out.println(responseOne);
//        System.out.println(responseTwo);
//        System.out.println(responseThree);


        // Create methods for each category.
        // Add method that will store the value of each category


        //
        // System.out.println("hi");


        // Parse the JSON file
        Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));


        // System.out.println("hi");
        // Parse the JSON file
        // Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));

        //typecast the recipeObj to JSONObject

        // Create a JSON Object
        JSONObject recipeObj = (JSONObject) jsonObj;

        //Get the location
        Map continent = ((Map) recipeObj.get(responseOne));

        //Create an array and get the meal array from the continent object
        JSONArray recipeArr = (JSONArray) continent.get("meal");

        //create an iterator for the meal array
        Iterator<Object> mealIterator = recipeArr.iterator();

        //Create a boolean variable to retrieve items for the vegan menu.
        boolean vegan = responseThree;
        //Use a while loop to iterate through the meal Array
        while (mealIterator.hasNext()) {
            //Create an object for the meal object
            JSONObject menu = (JSONObject) mealIterator.next();


            if (vegan) {
                if ((Boolean) menu.get("vegan")) {
                    //if true, prints vegan true value
                    //if false, prints vegan false value
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get(responseTwo);

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
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get(responseTwo);

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


        // create the main method that will process all the responses and data.
        //userResponses(responseOne, responseTwo, responseThree);


    }

    public static void welcomeStatement(Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./welcomeMessage.txt"));
        File newFile = CheckIO.findFile("./welcomeMessage.txt");

        if (newFile.exists()) {
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }
        String name = console.nextLine();
        //If else to make sure the user types a response
        while (name.isEmpty()) {
            System.out.println("Please type your name: ");
            name = console.nextLine();
        }
        System.out.println("Thanks " + name + " answer these three questions to get your personalised recipe list.");
        System.out.println();
    }


    public static String userResponses(String responseOne, String responseTwo, String responseThree) throws Exception {
        String answer = "hi";

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
        return answer;

    }


    public static String cuisine(Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./cuisine.txt"));
        File newFile = CheckIO.findFile("./cuisine.txt");

        if (newFile.exists()) {
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }

        String continent = console.nextLine();
        continent = continent.toUpperCase();


        //If else to make sure the user types a response
        while (continent.isEmpty()) {
            System.out.println("Please choose a response from A to D");
            continent = console.nextLine();
            continent = continent.toUpperCase();
        }
        continent = continent.toUpperCase();
        while (!(continent.equals("A")) && !(continent.equals("B")) && !(continent.equals("C")) && !(continent.equals("D"))) {
            System.out.println("Please select a response from A to D");
            continent = console.nextLine();
            continent = continent.toUpperCase();

        }
        if (continent.equals("A")) {
            continent = "Africa";
        } else if (continent.equals("B")) {
            continent = "Asia";
        } else if (continent.equals("C")) {
            continent = "Caribbean";
        } else {
            continent = "Europe";
        }

        System.out.print("Thank you for your response. You chose " + continent + ".");
        System.out.println();
        System.out.println();


        return continent;
    }

    // create a method for allergies
    public static String allergies(Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./allergies.txt"));
        File newFile = CheckIO.findFile("./allergies.txt");

        if (newFile.exists()) {
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }

        //change question to allergy
        String question = console.nextLine();
        question = question.toUpperCase();

        //If else to make sure the user types a response
        while (question.isEmpty()) {
            System.out.println("Please choose a response from A to D");
            question = console.nextLine();
            question = question.toUpperCase();

        }

        while (!(question.equals("A")) && !(question.equals("B")) && !(question.equals("C")) && !(question.equals("D"))) {
            System.out.println("Please select a response from A to D");
            question = console.nextLine();
            question = question.toUpperCase();

        }
        if (question.equals("A")) {
            question = "dairy";
        } else if (question.equals("B")) {
            question = "nuts";
        } else if (question.equals("C")) {
            question = "seafood";
        } else {
            question = "none";
        }

        System.out.print("Thank you for your response. Your allergy is " + question + ".");
        System.out.println();
        System.out.println();


        return question;
    }

    // create a method for dietary preference
    public static boolean preference(Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./preference.txt"));

        File newFile = CheckIO.findFile("./preference.txt");

        if (newFile.exists()) {
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }
        boolean vegan = true;

        String question = console.nextLine();
        question = question.toUpperCase();

        //If else to make sure the user types a response
        while (question.isEmpty()) {
            System.out.println("Please choose a response from A to B");
            question = console.nextLine();
            question = question.toUpperCase();

        }
        while (!(question.equals("A")) && !(question.equals("B"))) {
            System.out.println("Please select a response between A or B");
            question = console.nextLine();
            question = question.toUpperCase();

        }
        if (question.equals("A")) {
            question = "vegan";
            vegan = true;
        } else {
            question = "non-vegan";
            vegan = false;
        }

        //String question = console.nextLine();
        System.out.print("Thank you for your response. Your preference is " + question + ".");
        System.out.println();
        System.out.println();


        return vegan;
    }

    //create a method that will aggregate all the responses from the user
    //The method will be used to extract information from the JSON file and print it out to the console.

    // create a method that will report the goodbye statement
    public static void goodbyeStatement() throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./goodbyeStatement.txt"));

        File newFile = CheckIO.findFile("./preference.txt");

        if (newFile.exists()) {
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }
    }

}

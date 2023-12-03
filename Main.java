import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        /*
        Pseudo Code
  *      The first step is to import the Scanner method to request for user data.
  *     The second step is to print a welcome statement that informs the user on what the program does.
  *      The user will be asked to provide a response to three questions. The questions will be stored in three variables.
  *     The questions will be structured inside three different methods.

  *     In each of the methods, a response from the user is necessary. To ensure the user provides a response,
        two tests would be implemented. The first test would check if the user returns an empty statement,
        and request for a response if an empty statement is returned.

        The second test would check if the user returns a response that is among a predefined values. If the user does not
        return a method among the predefined value, the user is asked to provide another response until the appropriate one is provided

        The first method, named cuisine, will ask the user the region or continent they want their menu from.
        The user will choose an answer amongst Europe, Caribbean, Africa or Asia.
        The response will be saved in a String variable.

        The second method will ask the user their dietary preference: vegan or non-vegan.
        The response will be saved in a boolean variable where true represents vegan and false represents non-vegan.

        The third method will be split into two. If the user's preference is vegan, then the veganAllergies method will run.
        If not, the nonVeganAllergies would run. The difference between both is that veganAllergies has two options (nuts, No Allergies)
        while nonVeganAllergies has four (Seafood, Nuts, Dairy, No allergies).
        The response will be stored in a String variable.

        The three responses from the method would be passed as a parameter into a method that extracts the information from the JSON.
        The method will use the response to get the array that satisfies three conditions. The method will be named userResponse.

        Explanation of the JSON file.
        "JSON is a lightweight text-based open standard for human-readable data exchange."
         The data in the JSON file is written in JavaScript language.
        JSON consist of stacked key/value pairs. The keys and values are stored in double quotations.
        The key stores values of any data type, primitive or non-primitive.
        An example in the JSON file is "continent": "Europe". The key is "continent". The value is "Europe".


        There are four main key/value pairs in the JSON file.
        The keys are in this order: Europe, Africa, Asia, and Caribbean. The value of each pair is stored in an object.
        Each key has an array named "menu".   In the menu, there are two objects.
        The first object stores menus for non-vegans("vegan": false), the second for vegans("vegan": true).
        Each of the object has an allergies array that contains the menus for each of the main key.
        The allergies array for non-vegans has an object that contains four values/elements. They are "nuts", "dairy", "seafood", and "none".
        The allergies array for vegans has an object that contains two values/elements. They are "nuts" and "none".
        The "nuts" array contain menus that do not contain nuts. Same method is executed for the "dairy" and "seafood" arrays.
        The "none" array contains all the menus we gathered for each main key/element. It also contains menus from the other arrays.

        Psuedo code of the userResponse method.
        The JSON-simple library will be used to decode the data in the JSON file.
        The library has a dependency (json-simple-1.1 jar file) which is stored in the CLASSPATH of IntelliJ
        The three responses will be passed as a parameter in the method and used to extract the data in the JSON file.
  */

        // import Scanner that will be used to requests user input
        Scanner170 console = new Scanner170(System.in);

        // Store the username of the user and call it when necessary.
        String username = welcomeStatement(console);

        // Store all the responses in a variable
        String responseOne = cuisine(console);
        boolean responseTwo = preference(console);
//        use a ternary operator to choose which method to run based on the true/false value of responseTwo.
        String responseThree = (responseTwo) ? veganAllergies(console) : nonVeganAllergies(console);

        // create the main method that will process all the responses and data.
        userResponses(responseOne, responseTwo, responseThree);

        //Print a goodbye message
        goodbyeStatement(username);
    }

    public static String welcomeStatement(Scanner170 console) throws FileNotFoundException {
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
            System.out.println("Please type your name");
            name = console.nextLine();
        }
        System.out.println("Thanks " + name + " answer these three questions to get your personalised recipe list.");
        System.out.println();
        return name;
    }


    public static void userResponses(String responseOne, boolean responseTwo, String responseThree) throws Exception {
        ;
        // Parse the JSON file
        Object jsonObj = new JSONParser().parse(new FileReader("./recipeData.json"));

        // Create a JSON Object
        //typecast the recipeObj to JSONObject into recipeObj
        JSONObject recipeObj = (JSONObject) jsonObj;

        //Get continent/region from responseOne variable
        Map continent = ((Map) recipeObj.get(responseOne));

        //Create an array and get the menu array from the continent object
        JSONArray recipeArr = (JSONArray) continent.get("menu");

        //create an iterator for the menu array
        Iterator<Object> mealIterator = recipeArr.iterator();

        //Create a boolean variable to retrieve the vegan menu based on its truism or falsity.
        boolean vegan = responseTwo;
        //Use a while loop to iterate through the meal Array
        while (mealIterator.hasNext()) {
            //Create an object for the meal object
            JSONObject menu = (JSONObject) mealIterator.next();

            if (vegan) {
                //it is true, thus it prints the vegan true values
                if ((Boolean) menu.get("vegan")) {

//                    The arrays of responseThree are retrieved
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get(responseThree);

                    //Iterate over the array and print out the elements;
                    Iterator<Object> finalMenuIterator = allergies.iterator();
                    while (finalMenuIterator.hasNext()) {
                        System.out.println(finalMenuIterator.next());
                    }
                    //  System.exit(0);
                }
            } else {
                if (!(Boolean) menu.get("vegan")) {
                    //it is  false, thus, it prints vegan false values
                    JSONArray allergies = (JSONArray) ((JSONObject) ((JSONArray) menu.get("allergies")).get(0)).get(responseThree);

                    //System.out.println("Answer");
                    Iterator<Object> finalMenuIterator = allergies.iterator();
                    while (finalMenuIterator.hasNext()) {
                        System.out.println(finalMenuIterator.next());
                    }
                    // System.exit(0);
                }
            }
        }

        System.out.println();
    }


    public static String cuisine(Scanner170 console) throws FileNotFoundException {
//        Create a variable for the file and retrieve it.
        Scanner170 input = new Scanner170(new File("./cuisine.txt"));
//        Find the file
        File newFile = CheckIO.findFile("./cuisine.txt");

        if (newFile.exists()) { //if file exists, print out the content.
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }

//        ask the user to pick a response and store it in the continent variable
        String continent = console.nextLine();
        continent = continent.toUpperCase();


        //Test to make sure the user types a response
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
//        Test to make sure the user pick a response among the predefined values.
        if (continent.equals("A")) {
            continent = "Africa";
        } else if (continent.equals("B")) {
            continent = "Asia";
        } else if (continent.equals("C")) {
            continent = "Caribbean";
        } else {
            continent = "Europe";
        }

//        print out the user response
        System.out.print("Thank you for your response. You chose " + continent + ".");
        System.out.println();
        System.out.println();


        return continent;
    }

    // create a method for dietary preference
    public static boolean preference(Scanner170 console) throws FileNotFoundException {
//        Create a variable for the file and retrieve it.
        Scanner170 input = new Scanner170(new File("./preference.txt"));
//       Find the file
        File newFile = CheckIO.findFile("./preference.txt");

        if (newFile.exists()) { //if file exists, print out the content.
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }
        boolean vegan = true;

        String diet = console.nextLine();
        diet = diet.toUpperCase();

        //Test to make sure the user types a response
        while (diet.isEmpty()) {
            System.out.println("Please choose a response from A to B");
            diet = console.nextLine();
            diet = diet.toUpperCase();

        }
//        Test to make sure the user pick a response among the predefined values.
        while (!(diet.equals("A")) && !(diet.equals("B"))) {
            System.out.println("Please select a response A or B");
            diet = console.nextLine();
            diet = diet.toUpperCase();
        }
        if (diet.equals("A")) {
            diet = "vegan";
            vegan = true;
        } else {
            diet = "non-vegan";
            vegan = false;
        }

//    Print out the user response.
        System.out.print("Thank you for your response. Your dietary preference is " + diet + ".");
        System.out.println();
        System.out.println();

//        return true or false.
        return vegan;
    }

    //    create a method that chooses the vegan or non-vegan method based on the value of the preference method.
    // create a method for allergies
    public static String nonVeganAllergies(Scanner170 console) throws FileNotFoundException {
//        Create a variable for the file and retrieve it.
        Scanner170 input = new Scanner170(new File("./nonvegan.txt"));
//       Find the file
        File newFile = CheckIO.findFile("./nonvegan.txt");

        if (newFile.exists()) { //if file exists, print out the content.
            while (input.hasNext()) {
                System.out.println(input.nextLine());
            }
        } else {
            System.out.print("file not found");
        }

        //change question to allergy
        String question = console.nextLine();
        question = question.toUpperCase();

        //Test to make sure the user types a response
        while (question.isEmpty()) {
            System.out.println("Please choose a response from A to D");
            question = console.nextLine();
            question = question.toUpperCase();

        }
        //Test to make sure the user types among the predefined values.
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

        //        print out the user response
        System.out.print("Thank you for the response. Your allergen is " + question + ".");
        System.out.println();
        System.out.println();


        return question;
    }


    //    create a method for vegans with or without allergies
    public static String veganAllergies(Scanner170 console) throws FileNotFoundException {
        Scanner170 input = new Scanner170(new File("./vegan.txt"));
        File newFile = CheckIO.findFile("./vegan.txt");

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

        //Test to make sure the user types a response
        while (question.isEmpty()) {
            System.out.println("Please choose a response from A or B");
            question = console.nextLine();
            question = question.toUpperCase();

        }

        //Test to make sure the user types a response
        while (!(question.equals("A")) && !(question.equals("B"))) {
            System.out.println("Please select a response from A or B");
            question = console.nextLine();
            question = question.toUpperCase();

        }
        if (question.equals("A")) {
            question = "nuts";
        } else {
            question = "none";
        }

//        Print our the user response
        System.out.print("Thank you for your response. Your allergy is " + question + ".");
        System.out.println();
        System.out.println();


        return question;
    }


    //create a method that will aggregate all the responses from the user
    //The method will be used to extract information from the JSON file and print it out to the console.

    // create a method that will report the goodbye statement
    public static void goodbyeStatement(String username) {
        System.out.println("Thank you " + username + " for exploring cuisines across the world.");
        System.out.println();

    }


}

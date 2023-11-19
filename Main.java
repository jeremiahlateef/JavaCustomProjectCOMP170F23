import java.util.Scanner;
import org.json.*; //added a library to parse the JSON data

public class Main {
   public static void main(String[] args) {
      // import Scanner that will be used to requests user input
      Scanner console = new Scanner(System.in);
      welcomeStatement();
      // Store the username of the user and call it when necessary.
      String username = console.next();
      // Store all the responses in a variable
      String responseOne = "";
      String responseTwo;
      String responseThree;
      // Create methods for each category.
      // Add method that will store the value of each category

      nationality(responseOne);
      System.out.println(responseOne);

      // create the main method that will process all the responses and data.

      // Add the JSON data and read it.
      String jsonString = "./recipeData.json";
      JSONObject obj = new JSONObject(jsonString);
      JSONArray arr = obj.getJSONObject(0);



   }

   public static void welcomeStatement() {
      System.out.println("Hi! Welcome to Multicultural Menu!!");
      System.out.println("We have curated recipes from various parts of the world for you to enjoy.");
      System.out.println("Take this short quiz, and let's go on an exciting culinary journey.");
      System.out.print("Type your name: ");
      String name = console.nextLine();
      System.out.println("Thanks" + name + "answer these three questions to get your personalised recipe list.");
   }

   public static String cuisine(String responseOne) {
      Scanner console = new Scanner(System.in);
      System.out.println(
            "There are so many places to choose from. We have narrowed it down to four choices. Click on the location of your choice.");
      System.out.println("A. Africa");
      System.out.println("B. Asia");
      System.out.println("C. Carribean");
      System.out.println("D. Europe");
      String continent = console.nextLine();
      ;
      String answer = console.next();
      answer = answer.toUpperCase();
      /*
       * if (answer.equals("A")) {
       * System.out.println("correct");
       * } else {
       * System.out.println("not correct");
       * }
       */
      answer = responseOne;
      return responseOne;
   }

   // create a method for cuisine
   public static String allergies(String responseTwo) {

      System.out.println("Do you have any allergies. If yes, pick one from the options if none, pick the last option.");
      System.out.println("A. Dairy");
      System.out.println("B. Nuts - Pinenuts, Peanuts, Walnuts, Cashwenuts, Hazelnuts");
      System.out.println("C. Seafood- including shellfish");
      System.out.println("No Allergies");
      String allergies = console.nextLine();

      return responseTwo;
   }

   // create a method for allergies
   public static String preference(String responseThree) {

      System.out.println("Last Question! Do you have any particular dietary preferences?");
      System.out.println("A. Vegan");
      System.out.println("B. Non-vegan");
      String preference = console.nextLine();

      return responseThree;
   }
   // create a method that will

public static void main

   goodbyestatement(){

  System.out.println(name + " !. You have excellent taste, give us some time while we cook up your recipe selections.");
  System.out.println("Thanks for exploring cuisines across the world! Happy Cooking."); 
}

}

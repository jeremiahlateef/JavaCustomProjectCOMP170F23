import java.util.Scanner;

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

   }

   public static void welcomeStatement() throws FileNotFoundException {
      Scanner170 input = new Scanner170(new File(welcomemessage.txt));
      String name = console.nextLine();
      System.out.println("Thanks" + name + "answer these three questions to get your personalised recipe list.");
   }

   public static String cuisine(String responseOne) throws FileNotFoundException {
      Scanner170 input = new Scanner170(new File(cuisine.txt));
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

   // create a method for allergies
   public static String allergies(String responseTwo) throws FileNotFoundException {
      Scanner170 input = new Scanner170(new File(allergies.txt));
      String allergies = console.nextLine();
      return responseTwo;
   }

   // create a method for dietary preference
   public static String preference(String responseThree) throws FileNotFoundException {
      Scanner170 input = new Scanner170(new File(preference.txt));
      String preference = console.nextLine();
      return responseThree;
   }
   // create a method that will report the goodbye statement

public static void goodbyestatement() throws FileNotFoundException {
Scanner170 input = new Scanner170(new File(goodbyestatement.txt));
}

}
  


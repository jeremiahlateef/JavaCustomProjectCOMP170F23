import java.util.Scanner;

public class Main {
public static void main(String[] args) {
// import Scanner that will be used to requests user input
Scanner console = new Scanner(System.in);
welcomeStatement();
// Store the username of the user and call it when necessary.
String username = console.next();
//Store all the responses in a variable
String responseOne = "";
String responseTwo;
String responseThree;
// Create methods for each category.
//Add method that will store the value of each category

nationality(responseOne);
System.out.println(responseOne);

// create the main method that will process all the responses and data.


}

public static void welcomeStatement() {
System.out.println("Hi! Welcome to Multicultural Menu!!");
  System.out.println("We have curated over    recipes for you to enjoy.");
  System.out.println("Take this short quiz, and let's go on an exciting culinary journey.");
System.out.print("Type your name: ");
  String name= console.nextLine();
  System.out.println("Thanks" + name + "answer these three questions to get recipes from all over the world.");
  System.out.println("There are so many places to choose from. We have narrowed it down to four choices. Click on the location of your choice.");
  System.out.println("A. Africa");
  System.out.println("B. Asia");
  System.out.println("C. Carribean");
  System.out.println("D. European");
  String continent= console.nextLine();
  System.out.println("Do you have any allergies. If yes, pick one from the options if none, pick the last option.");
  System.out.println("A. Dairy");
  System.out.println("B. Nuts - Pinenuts, Peanuts, Walnuts, Cashwenuts, Hazelnuts");
  System.out.println("C. Seafood- including shellfish");
  System.out.println("No Allergies");
  String allergies= console.nextLine();
  System.out.println("Last Question! Do you have any particular dietary preferences?");
  System.out.println("A. Vegan");
  System.out.println("B. Non-vegan");
  String preference= console.nextLine();
  System.out.println(name + " !. You have excellent taste, give us some time while we cook up your recipe selections.");
  System.out.println("Thanks for your patience! Here are your recipes."); 
}
  
  
  
  

}

public static String nationality(String responseOne) {
Scanner console = new Scanner(System.in);
System.out.println("What nationality do you want? ");
// Creaet content that will be asked of the participants
System.out.println("Choose between these options: A B C D ");
String answer = console.next();
answer = answer.toUpperCase();
if (answer.equals("A")) {
System.out.println("correct");
} else {
System.out.println("not correct");
}
answer = responseOne;
return responseOne;
}

// create a method for cuisine
public static String cuisine(String responseTwo) {
return responseTwo;
}

// create a method for allergies
public static String allergies(String responseThree) {

return responseThree;
}
//create a method that will

}

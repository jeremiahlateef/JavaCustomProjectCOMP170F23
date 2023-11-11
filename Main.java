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
System.out.println("Hi! Welcome to our ...");
System.out.print("Please tell us your first name: ");

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
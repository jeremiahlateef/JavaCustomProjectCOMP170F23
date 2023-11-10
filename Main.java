import java.util.Scanner;

public class Main {
   public static void main(String[] args){
      Scanner console = new Scanner(System.in);
      welcomeStatement();
      String username = console.next();
      nationality();

   }
   public static void welcomeStatement(){
      System.out.println("Hi! Welcome to our ...");
      System.out.print("Please tell us your first name: ");
      
   }
   public static void nationality(Scanner console){
      System.out.println("What nationality do you want? ");
      System.out.println("Choose between these options: A B C D ");
      String answer = console.next();
      if(answer.nameEquals().equalIgnoreCase("A")){
         System.out.println("correct")
      }

   }
}

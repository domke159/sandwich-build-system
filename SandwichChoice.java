import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SandwichChoice {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("How many sandwiches would you like?");
 		
    int sandwichAmount = 0;
    boolean correctInput = false;
 		
    //checks if user input for sandwich amount is correct
    while (!correctInput) {
      try {
        sandwichAmount = input.nextInt();
        if (sandwichAmount <= 0) {
          throw new InputMismatchException ("\nPlease enter a valid number");
        }
        correctInput = true;
      }
      catch (InputMismatchException exception) {
        input.nextLine();
        System.out.println("\nPlease enter a valid number: ");
      }
    }
 		
    List<Boolean> isNutFree = new ArrayList<>();
    List<Boolean> isVegetarian = new ArrayList<>();
    List<String> allBreadList = new ArrayList<>();
    List<String> allFillingList = new ArrayList<>();
    List<String> allToppingList = new ArrayList<>();
		
    double totalCostBeforeTax = 0;
    double totalCostAfterTax = 0;
 		
    //runs the for loop as many times as the number of sandwiches wanted by the user
    for (int i = 0; i < sandwichAmount; i++) { //beginning of the for loop for the sandwich making 
      //creates new chosenBreadList, chosenFillingList, chosenToppingList for each sandwich
      List<String> chosenBreadList = new ArrayList<>();
      List<String> chosenFillingList = new ArrayList<>();
      List<String> chosenToppingList = new ArrayList<>();
	 		
      System.out.println("\nEnter the number of the bread from the list that you would like to choose:\n");
			
      Map<String, Double> availableBreads = new HashMap<>();
      List<String> availableBreadList = new ArrayList<>();
      Bread breads = new Bread(availableBreads, availableBreadList);
			
      System.out.println( "Bread List:" );
      System.out.println("================================================================");			
			
      int br = 1;	
      String dot = ".";
      //prints out the list of the breads to choose from
      for(String aBreads: breads.getIngredientList()) {
        System.out.format("%d%-2s%-31s %15.2f£\n", br, dot, aBreads, breads.getIngredients().get(aBreads));
        br++;
      }	
			
      System.out.println("================================================================\n");
      System.out.println("Your choice:");
			
      int breadIndex = 0;
      correctInput = false;
      //checks if the user input for the bread is correct
      while (!correctInput) {
        try {
          breadIndex = input.nextInt();
          if (breadIndex <= 0 || breadIndex > 5) {
            throw new InputMismatchException ("\nPlease enter a valid number");
          }
          correctInput = true;
        }
        catch (InputMismatchException exception) {
          input.nextLine();
          System.out.println("\nPlease enter a valid number: ");
        }
      }
						
      Map<String, Double> availableFillings = new HashMap<>();
      List<String> availableFillingList = new ArrayList<>();
      Filling fillings = new Filling(availableFillings, availableFillingList);
			
      System.out.println( "\nFilling List:" );
      System.out.println("================================================================");
			
      int fil = 1;	
      //prints out the list of fillings to choose from
      for(String aFillings: fillings.getIngredientList()) {
        System.out.format("%d%-2s%-31s %15.2f£\n", fil, dot, aFillings, fillings.getIngredients().get(aFillings));
        fil++;
      }
			
      System.out.println("================================================================\n");		
      System.out.println("How many fillings would you like?");
			
      int fillingAmount = 0;
      int[] fillingIndexArray = new int[0];
      //checks if the user input for the filling amount is correct
      correctInput = false;
      while (!correctInput) {
        try {
          fillingAmount = input.nextInt();
          if (fillingAmount < 0) {
          throw new InputMismatchException ("\nPlease enter a valid number");
          }
          correctInput = true;
          fillingIndexArray = new int[fillingAmount];
        }
        catch (InputMismatchException exception) {
          input.nextLine();
          System.out.println("\nPlease enter a valid number: ");
        }
      }
			
      //if filling amount is not 0 runs the for loop as many times as the amount of fillings wanted by the user 
      if (fillingAmount > 0) {				
        for (int f = 0; f < fillingAmount; f++) {
          if (f == 0) {
            System.out.println("\nEnter the number of the first filling that you would like from the list above:");
          }
          else {
            System.out.println("\nEnter the number of the next filling that you would like from the list above:");
          }
				
          int fillingIndex = 0;
          correctInput = false;
          //checks if the user input for the filling is correct
          while (!correctInput) {
            try {
              fillingIndex = input.nextInt();
              if (fillingIndex <= 0 || fillingIndex > 8) {
                throw new InputMismatchException ("\nPlease enter a valid number");
              }
              correctInput = true;
              fillingIndexArray[f] = fillingIndex;
            }
            catch (InputMismatchException exception) {
              input.nextLine();
              System.out.println("\nPlease enter a valid number: ");
            }
          }
        }			
      }
			
      Map<String, Double> availableToppings = new HashMap<>();
      List<String> availableToppingList = new ArrayList<>();
      Topping toppings = new Topping(availableToppings, availableToppingList);
			
      System.out.println( "\nTopping List:" );
      System.out.println("================================================================");
			
      int top = 1;	
      //prints out the list of toppings to choose from
      for(String aToppings: toppings.getIngredientList()) {
        System.out.format("%d%-2s%-31s %15.2f£\n", top, dot, aToppings, toppings.getIngredients().get(aToppings));
        top++;
      }
			
      System.out.println("================================================================\n");	
      System.out.println("How many toppings would you like?");

      int toppingAmount = 0;
      int[] toppingIndexArray = new int[0];
      //checks if the user input for the topping amount is correct
      correctInput = false;
      while (!correctInput) {
        try {
          toppingAmount = input.nextInt();
          if (toppingAmount < 0) {
            throw new InputMismatchException ("\nPlease enter a valid number");
          }
          correctInput = true;
          toppingIndexArray = new int[toppingAmount];
        }
        catch (InputMismatchException exception) {
          input.nextLine();
          System.out.println("\nPlease enter a valid number: ");
        }
      }
			
      //if topping amount is not 0 runs the for loop as many times as the amount of toppings wanted by the user
      if (toppingAmount > 0) {			
        for (int t = 0; t < toppingAmount; t++) {
          if (t == 0) {
            System.out.println("\nEnter the number of the first topping that you would like from the list above:");
          }
          else {
            System.out.println("\nEnter the number of the next topping that you would like from the list above:");
          }
				
          int toppingIndex = 0;
          correctInput = false;
          //checks if the user input for the topping is correct
          while (!correctInput) {
            try {
              toppingIndex = input.nextInt();
              if (toppingIndex <= 0 || toppingIndex > 5) {
                throw new InputMismatchException ("\nPlease enter a valid number");
              }
              correctInput = true;
              toppingIndexArray[t] = toppingIndex;
            }
            catch (InputMismatchException exception) {
              input.nextLine();
              System.out.println("\nPlease enter a valid number: ");
            }
          }
        }			
      }
			
      Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);
			
      //makes the sandwich
      s.makeSandwich(breadIndex, fillingIndexArray, toppingIndexArray, fillingAmount, toppingAmount,
		     s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
			
      //calculates the price of the current sandwich before the tax and adds the value to the total price of the order before tax
      totalCostBeforeTax += s.sandwichPriceBeforeTax(s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
			
      //adds the chosen bread, fillings and toppings of the current sandwich to the lists of all breads, fillings and toppings
      allBreadList.addAll(s.getChosenBreadList());
      allFillingList.addAll(s.getChosenFillingList());
      allToppingList.addAll(s.getChosenToppingList());
			
      //checks if the sandwich is nut-free and adds the value to the isNutFree list
      isNutFree.add(s.isNutFree(chosenBreadList, chosenFillingList, chosenToppingList));
			
      //checks if the sandwich is vegetarian and adds the value to the isVegetarian list
      isVegetarian.add(s.isVegetarian(chosenBreadList, chosenFillingList, chosenToppingList));
			
      //if the current sandwich that is being made is not the last one, asks the user to make the next sandwich
      if (i != sandwichAmount - 1) {
        System.out.println("\n\nMake your next sandwich");
      }		
      //if the current sandwich that is being made is the last one, prints out the information about the order
      else { //beginning of the information printing
        System.out.println("\nYour order: ");
        System.out.println("================================================================");
        int inf = 1; //inf - is nut free
        //prints out the information about the sandwiches of whether they are nut-free or not
        for(boolean isNutF: isNutFree) {
          if (isNutF == true) {
            if (inf == 1) {
            System.out.println("Your first sandwich is nut-free");
            }
            else {
              System.out.println("Your next sandwich is nut-free");
            }
          }
          else {
            if (inf == 1) {
              System.out.println("Your first sandwich contains nuts");
            }
            else {
              System.out.println("Your next sandwich contains nuts");
            }
          }
          inf++;
        }
				
        int iv = 1; //iv - is vegetarian
        //prints out the information about the sandwiches of whether they are vegetarian or not
        for(boolean isVeg: isVegetarian) {
          if (isVeg == true) {
            if (iv == 1) {
              System.out.println("Your first sandwich is Vegetarian");
              System.out.println("\n================================================================");
            }
            else {
              System.out.println("Your next sandwich is vegetarian");
            }
          }
          else {
            if (iv == 1) {
              System.out.println("Your first sandwich is not vegetarian");
            }
            else {
              System.out.println("Your next sandwich is not vegetarian");
            }
          }
          iv++;
        }
				
        System.out.println("================================================================");
        System.out.println("\nChosen ingredients:");
        System.out.println("================================================================");
				
        //prints out the list of all of the breads, fillings and toppings chosen by the user
        for(String aBreads: allBreadList) {
          System.out.format("%-30s %19.1f£\n", aBreads, breads.getIngredients().get(aBreads));
        }
        for(String aFillings: allFillingList) {
          System.out.format("%-30s %19.1f£\n", aFillings, fillings.getIngredients().get(aFillings));
        }
        for(String aToppings: allToppingList) {
          System.out.format("%-30s %19.1f£\n", aToppings, toppings.getIngredients().get(aToppings));
        }
				
        System.out.println("================================================================\n");
				
        System.out.println("****************************************************************");
        //prints out the total price of the order before tax
        System.out.format("Total price before tax: %26.2f£\n", totalCostBeforeTax);
				
        //calculates the total price of the order after tax
        totalCostAfterTax = s.sandwichPriceAfterTax(totalCostBeforeTax);
				
        //prints out the total price of the order after tax
        System.out.format("Total price after tax: %27.2f£\n", totalCostAfterTax);
        System.out.println("****************************************************************");
				
      } //end of the information printing		
    } //end of the for loop for the sandwich making	
  } //end of the main method	
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SandwichMenu {
	
  public static void main(String[] args) {
    List<String> allBreadList = new ArrayList<>();
    List<String> allFillingList = new ArrayList<>();
    List<String> allToppingList = new ArrayList<>();
    List<Boolean> isNutFree = new ArrayList<>();
    List<Boolean> isVegetarian = new ArrayList<>();		
    List<String> chosenSandwiches = new ArrayList<>();
		
    double totalCostBeforeTax = 0;
    double totalCostAfterTax = 0;
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
 		
    System.out.println("\nSandwich Menu:");
    System.out.println("================================================================");
    System.out.println("1. Extra Chicken Sandwich");
    System.out.println("2. Bacon and Cheese Sandwich");
    System.out.println("3. Ham and Vegetables Sandwich");
    System.out.println("4. Jibarito Sandwich");
    System.out.println("================================================================");

    for (int i = 0; i < sandwichAmount; i++) { //beginning of the for loop for the sandwich making
      //creates new chosenBreadList, chosenFillingList, chosenToppingList for each sandwich
      List<String> chosenBreadList = new ArrayList<>();
      List<String> chosenFillingList = new ArrayList<>();
      List<String> chosenToppingList = new ArrayList<>();
			
      if(i == 0) {
        System.out.println("\nEnter the number of the first sandwich that you would like to choose: ");
      }
      else {
        System.out.println("\nEnter the number of the next sandwich that you would like to choose: ");
      }
	 		
      int sandwichIndex = 0;
      correctInput = false;
      //checks if user input for sandwich index is correct
      while (!correctInput) {
        try {
          sandwichIndex = input.nextInt();
          if (sandwichIndex <= 0 || sandwichIndex > 4) {
            throw new InputMismatchException ("\nPlease enter a valid number");
          }
          correctInput = true;
        }
        catch (InputMismatchException exception) {
          input.nextLine();
          System.out.println("\nPlease enter a valid number: ");
        }
      }
	 		
      //if sandwich index is 1 makes Extra Chicken Sandwich
      if (sandwichIndex == 1) {
        Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);	 		
        //chooses Pita Bread
        int breadIndex = 4;
        int fillingAmount = 4;
        int toppingAmount = 2;
        //chooses Chicken, Chicken, Lettuce and Tomatoes as fillings
        int[] fillingIndexArray = new int[] {3, 3, 5, 7};
        //chooses Mayonnaise and Mustard as toppings
        int[] toppingIndexArray = new int[] {4, 5};
		 		
        //makes the Extra Chicken Sandwich
        s.makeSandwich(breadIndex, fillingIndexArray, toppingIndexArray, fillingAmount, toppingAmount,
                       s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //calculates the price of the Extra Chicken Sandwich before the tax and adds the value to the total price of the order before tax
        totalCostBeforeTax += s.sandwichPriceBeforeTax(s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //adds the bread, fillings and toppings of the Extra Chicken Sandwich to the lists of all breads, fillings and toppings
        allBreadList.addAll(chosenBreadList);
        allFillingList.addAll(chosenFillingList);
        allToppingList.addAll(chosenToppingList);
				
        //adds Extra Chicken Sandwich to the chosenSandwiches list
        chosenSandwiches.add("Extra Chicken Sandwich");
				
        //checks if the Extra Chicken Sandwich is nut-free and adds the value to the isNutFree list
        isNutFree.add(s.isNutFree(chosenBreadList, chosenFillingList, chosenToppingList));
				
        //checks if the Extra Chicken Sandwich is vegetarian and adds the value to the isVegetarian list
        isVegetarian.add(s.isVegetarian(chosenBreadList, chosenFillingList, chosenToppingList));			
      }
			
      //if sandwich index is 2 makes Bacon and Cheese Sandwich
      if (sandwichIndex == 2) {
        Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);
        //chooses Wholewheat Bread
        int breadIndex = 5;
        int fillingAmount = 3;
        int toppingAmount = 1;
        //chooses Bacon, Cheddar Cheese and Onions as fillings
        int[] fillingIndexArray = new int[] {1, 2, 6};
        //chooses Garlic Sauce as topping
        int[] toppingIndexArray = new int[] {2};
		 		
        //makes the Bacon and Cheese Sandwich
        s.makeSandwich(breadIndex, fillingIndexArray, toppingIndexArray, fillingAmount, toppingAmount,
                       s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //calculates the price of the Bacon and Cheese Sandwich before the tax and adds the value to the total price of the order before tax
        totalCostBeforeTax += s.sandwichPriceBeforeTax(s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //adds the bread, fillings and toppings of the Bacon and Cheese Sandwich to the lists of all breads, fillings and toppings
        allBreadList.addAll(chosenBreadList);
        allFillingList.addAll(chosenFillingList);
        allToppingList.addAll(chosenToppingList);
				
        //adds Bacon and Cheese Sandwich to the chosenSandwiches list
        chosenSandwiches.add("Bacon and Cheese Sandwich");
				
        //checks if the Bacon and Cheese Sandwich is nut-free and adds the value to the isNutFree list
        isNutFree.add(s.isNutFree(chosenBreadList, chosenFillingList, chosenToppingList));
				
        //checks if the Bacon and Cheese Sandwich is vegetarian and adds the value to the isVegetarian list
        isVegetarian.add(s.isVegetarian(chosenBreadList, chosenFillingList, chosenToppingList));
      }
			
      //if sandwich index is 3 makes Ham and Vegetables Sandwich
      if (sandwichIndex == 3) {
        Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);
        //chooses Gluten-Free White Bread
        int breadIndex = 2;
        int fillingAmount = 4;
        int toppingAmount = 2;
        //chooses Ham, Lettuce, Onions and Tomatoes as fillings
        int[] fillingIndexArray = new int[] {4, 5, 6, 7};
        //chooses Ketchup and Mayonnaise as toppings
        int[] toppingIndexArray = new int[] {3, 4};
		 		
        //makes the Ham and Vegetables Sandwich
        s.makeSandwich(breadIndex, fillingIndexArray, toppingIndexArray, fillingAmount, toppingAmount,
                       s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //calculates the price of the Ham and Vegetables Sandwich before the tax and adds the value to the total price of the order before tax
        totalCostBeforeTax += s.sandwichPriceBeforeTax(s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //adds the bread, fillings and toppings of the Ham and Vegetables Sandwich to the lists of all breads, fillings and toppings
        allBreadList.addAll(chosenBreadList);
        allFillingList.addAll(chosenFillingList);
        allToppingList.addAll(chosenToppingList);
				
        //adds Ham and Vegetables Sandwich to the chosenSandwiches list
        chosenSandwiches.add("Ham and Vegetables Sandwich");
				
        //checks if the Ham and Vegetables Sandwich is nut-free and adds the value to the isNutFree list
        isNutFree.add(s.isNutFree(chosenBreadList, chosenFillingList, chosenToppingList));
				
        //checks if the Ham and Vegetables Sandwich is vegetarian and adds the value to the isVegetarian list
        isVegetarian.add(s.isVegetarian(chosenBreadList, chosenFillingList, chosenToppingList));			
      }
			
      //if sandwich index is 4 makes Jibarito Sandwich
      if (sandwichIndex == 4) {
        Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);
        //chooses Pita Bread
        int breadIndex = 4;
        int fillingAmount = 4;
        int toppingAmount = 2;
        //chooses Bacon, Cheddar Cheese, Ham and Lettuce as fillings
        int[] fillingIndexArray = new int[] {1, 2, 4, 5};
        //chooses Garlic Sauce and Mayonnaise as toppings
        int[] toppingIndexArray = new int[] {2, 4};
		 		
        //makes the Jibarito Sandwich
        s.makeSandwich(breadIndex, fillingIndexArray, toppingIndexArray, fillingAmount, toppingAmount,
                       s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //calculates the price of the Jibarito Sandwich before the tax and adds the value to the total price of the order before tax
        totalCostBeforeTax += s.sandwichPriceBeforeTax(s.getChosenBreadList(), s.getChosenFillingList(), s.getChosenToppingList());
		 		
        //adds the bread, fillings and toppings of the Jibarito Sandwich to the lists of all breads, fillings and toppings
        allBreadList.addAll(chosenBreadList);
        allFillingList.addAll(chosenFillingList);
        allToppingList.addAll(chosenToppingList);
				
        //adds Jibarito Sandwich to the chosenSandwiches list
        chosenSandwiches.add("Jibarito Sandwich");
				
        //checks if the Jibarito Sandwich is nut-free and adds the value to the isNutFree list
        isNutFree.add(s.isNutFree(chosenBreadList, chosenFillingList, chosenToppingList));
				
        //checks if the Jibarito Sandwich is vegetarian and adds the value to the isVegetarian list
        isVegetarian.add(s.isVegetarian(chosenBreadList, chosenFillingList, chosenToppingList));	
      }
    } //end of the for loop for the sandwich making
		
    Map<String, Double> availableBreads = new HashMap<>();
    List<String> availableBreadList = new ArrayList<>();
    Bread breads = new Bread(availableBreads, availableBreadList);
		
    Map<String, Double> availableFillings = new HashMap<>();
    List<String> availableFillingList = new ArrayList<>();
    Filling fillings = new Filling(availableFillings, availableFillingList);
		
    Map<String, Double> availableToppings = new HashMap<>();
    List<String> availableToppingList = new ArrayList<>();
    Topping toppings = new Topping(availableToppings, availableToppingList);
		
    System.out.println("\nYour order: ");
    System.out.println("================================================================");
		
    //prints out the names of the chosen sandwiches
    for(String cBreads: chosenSandwiches) {
      System.out.println(cBreads);
    }
		
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
    System.out.println("Ingredients: ");
    System.out.println("================================================================");
		
    //prints out the list of all of the breads, fillings and toppings of the chosen sandwiches by the user
    for(String aBreads: allBreadList) {
      System.out.format("%-31s %18.2f£\n", aBreads, breads.getIngredients().get(aBreads));
    }
    for(String aFillings: allFillingList) {
      System.out.format("%-31s %18.2f£\n", aFillings, fillings.getIngredients().get(aFillings));
    }
    for(String aToppings: allToppingList) {
      System.out.format("%-31s %18.2f£\n", aToppings, toppings.getIngredients().get(aToppings));
    }
		
    System.out.println("================================================================\n");
		
    System.out.println("****************************************************************");
    //prints out the total price of the order before tax
    System.out.format("Total price before tax: %26.2f£\n", totalCostBeforeTax);
		
    List<String> chosenBreadList = new ArrayList<>();
    List<String> chosenFillingList = new ArrayList<>();
    List<String> chosenToppingList = new ArrayList<>();
    Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);	
		
    //calculates the total price of the order after tax
    totalCostAfterTax = s.sandwichPriceAfterTax(totalCostBeforeTax);
		
    //prints out the total price of the order after tax
    System.out.format("Total price after tax: %27.2f£\n", totalCostAfterTax);
    System.out.println("****************************************************************");
  } //end of the main method
}

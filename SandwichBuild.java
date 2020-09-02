import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SandwichBuild {
	
  public static void main(String[] args) {
    //the amount of sandwiches is 2
    int sandwichAmount = 2;

    for (int i = 0; i < sandwichAmount; i++) {
      //creates new chosenBreadList, chosenFillingList, chosenToppingList for each sandwich
      List<String> chosenBreadList = new ArrayList<>();
      List<String> chosenFillingList = new ArrayList<>();
      List<String> chosenToppingList = new ArrayList<>();
			
      //gives breadIndex value 1 which means that the bread for the sandwich will be Ciabatta
      int breadIndex = 1;
			
      //the amount of fillings for the sandwich is 2
      int fillingAmount = 2;
      //adds values of 1 and 2 to the array which means that the fillings for the sandwich will be Bacon and Cheddar Cheese
      int[] fillingIndexArray = new int[] {1, 2};
			
      //the amount of toppings for the sandwich is 2
      int toppingAmount = 2;
      //adds values of 1 and 2 to the array which means that the fillings for the sandwich will be Chilli Sauce and Garlic Sauce      int[] toppingIndexArray = new int[] {1, 2};
			
      Sandwich s = new Sandwich(chosenBreadList, chosenFillingList, chosenToppingList);
      //makes the sandwich based on the user choices
      s.makeSandwich(breadIndex, fillingIndexArray, toppingIndexArray, fillingAmount, toppingAmount, chosenBreadList, chosenFillingList, chosenToppingList);
      //calculates the price of the sandwich before tax
      double priceBeforeTax = s.sandwichPriceBeforeTax(chosenBreadList, chosenFillingList, chosenToppingList);
      //calculates the price of the sandwich after tax
      double priceAfterTax = s.sandwichPriceAfterTax(priceBeforeTax);
			
      //prints out the list of chosen bread, fillings and toppings
      System.out.println("Ingredients:");
      for(String cBreads: s.getChosenBreadList()) {
        System.out.println(cBreads);
      }
      for(String cFillings: s.getChosenFillingList()) {
        System.out.println(cFillings);
      }
      for(String cToppings: s.getChosenToppingList()) {
        System.out.println(cToppings);
      }
			
      Map<String, Double> availableBreads = new HashMap<>();
      List<String> availableBreadList = new ArrayList<>();
      Bread breads = new Bread(availableBreads, availableBreadList);
			
      Map<String, Double> availableFillings = new HashMap<>();
      List<String> availableFillingList = new ArrayList<>();
      Filling fillings = new Filling(availableFillings, availableFillingList);
			
      Map<String, Double> availableToppings = new HashMap<>();
      List<String> availableToppingList = new ArrayList<>();
      Topping toppings = new Topping(availableToppings, availableToppingList);
			
      //prints out the prices of chosen bread, fillings and toppings
      System.out.println("\nPrices:");
      for(String cBreads: s.getChosenBreadList()) {
        System.out.println(breads.getIngredients().get(cBreads));
      }
      for(String cFillings: s.getChosenFillingList()) {
        System.out.println(fillings.getIngredients().get(cFillings));
      }
      for(String cToppings: s.getChosenToppingList()) {
        System.out.println(toppings.getIngredients().get(cToppings));
      }
			
      //prints out the price of the sandwich before and after tax
      System.out.println("\nPrice before tax:");
      System.out.println(priceBeforeTax);			
      System.out.println("\nPrice after tax:");
      System.out.println(priceAfterTax + "\n");
    }
  }
}


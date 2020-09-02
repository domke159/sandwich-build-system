import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Sandwich {
	
  private final static double TAX_RATE = 1.2;
	
  private List<String> chosenBreadList;
  private List<String> chosenFillingList;
  private List<String> chosenToppingList;
	
  //constructor for Sandwich class that takes three String lists as parameters (for chosen breads, fillings and toppings) and sets their values
  public Sandwich(List<String> chosenBreadList, List<String> chosenFillingList, List<String> chosenToppingList) {
    setChosenBreadList(chosenBreadList);
    setChosenFillingList(chosenFillingList);
    setChosenToppingList(chosenToppingList);
  }

  //get and set methods for chosen bread list, chosen filling list and chosen topping list
  public void setChosenBreadList(List<String> chosenBreadList) {
    this.chosenBreadList = chosenBreadList;
  }
	
  public List<String> getChosenBreadList() {
    return chosenBreadList;
  }
	
  public void setChosenFillingList(List<String> chosenFillingList) {
    this.chosenFillingList = chosenFillingList;
  }
	
  public List<String> getChosenFillingList() {
    return chosenFillingList;
  }
	
  public void setChosenToppingList(List<String> chosenToppingList) {
    this.chosenToppingList = chosenToppingList;
  }
	
  public List<String> getChosenToppingList() {
    return chosenToppingList;
  }
	
  //method for making a sandwich that adds bread, fillings and toppings chosen by the user to the chosenBreadList, chosenFillingList and chosenToppingList
  public void makeSandwich(int breadIndex, int fillingIndexArray[], int toppingIndexArray[], int fillingAmount, int toppingAmount,
			List<String> chosenBreadList, List<String> chosenFillingList, List<String> chosenToppingList) {
    Map<String, Double> sandwichBreads = new HashMap<>();
    List<String> sandwichBreadList = new ArrayList<>();
    Map<String, Double> sandwichFillings = new HashMap<>();
    List<String> sandwichFillingList = new ArrayList<>();
    Map<String, Double> sandwichToppings = new HashMap<>();
    List<String> sandwichToppingList = new ArrayList<>();
	
    Bread b = new Bread(sandwichBreads, sandwichBreadList);
    Filling f = new Filling(sandwichFillings, sandwichFillingList);
    Topping t = new Topping(sandwichToppings, sandwichToppingList);
		
    //finds the bread that user wants in the bread list and adds it to the chosenBreadList
    chosenBreadList.add(b.getIngredientList().get(breadIndex - 1));
		
    //finds the fillings that user wants in the filling list and adds it to the chosenFillingList
    for (int i = 0; i < fillingAmount; i++) {
      chosenFillingList.add(f.getIngredientList().get(fillingIndexArray[i] - 1));
    }	

    //finds the toppings that user wants in the topping list and adds it to the chosenToppingList
    for (int i = 0; i < toppingAmount; i++) {
      chosenToppingList.add(t.getIngredientList().get(toppingIndexArray[i] - 1));
    }		
  }
	
  //method that calculates the price of the sandwich before tax
  public double sandwichPriceBeforeTax(List<String> chosenBreadList, List<String> chosenFillingList, List<String> chosenToppingList) {
    double priceBeforeTax = 0;
		
    Map<String, Double> sandwichBreads = new HashMap<>();
    List<String> sandwichBreadList = new ArrayList<>();
    Map<String, Double> sandwichFillings = new HashMap<>();
    List<String> sandwichFillingList = new ArrayList<>();
    Map<String, Double> sandwichToppings = new HashMap<>();
    List<String> sandwichToppingList = new ArrayList<>();
		
    Bread b = new Bread(sandwichBreads, sandwichBreadList);
    Filling f = new Filling(sandwichFillings, sandwichFillingList);
    Topping t = new Topping(sandwichToppings, sandwichToppingList);
		
    //finds the price of the bread that user wants in the bread map and adds its value to the total price before tax
    for(String cBreads: getChosenBreadList()) {
      priceBeforeTax += b.getIngredients().get(cBreads);
    }

    //finds the price of the fillings that user wants in the filling map and adds its value to the total price before tax
    for(String cFillings: getChosenFillingList()) {
      priceBeforeTax += f.getIngredients().get(cFillings);
    }

    //finds the price of the toppings that user wants in the topping map and adds its value to the total price before tax
    for(String cToppings: getChosenToppingList()) {
      priceBeforeTax += t.getIngredients().get(cToppings);
    }

    //returns the value of the sandwich price before tax
    return priceBeforeTax;
  }
	
  //method for calculating the price of the sandwich after tax
  public double sandwichPriceAfterTax(double priceBeforeTax) {
    //returns the value of the sandwich price after tax
    return priceBeforeTax * TAX_RATE;
  }
	
  //method that checks if the sandwich is nut-free
  public boolean isNutFree(List<String> chosenBreadList, List<String> chosenFillingList, List<String> chosenToppingList) {
    Map<String, Double> sandwichBreads = new HashMap<>();
    List<String> sandwichBreadList = new ArrayList<>();
    Map<String, Double> sandwichFillings = new HashMap<>();
    List<String> sandwichFillingList = new ArrayList<>();
    Map<String, Double> sandwichToppings = new HashMap<>();
    List<String> sandwichToppingList = new ArrayList<>();
		
    Bread b = new Bread(sandwichBreads, sandwichBreadList);
    Filling f = new Filling(sandwichFillings, sandwichFillingList);
    Topping t = new Topping(sandwichToppings, sandwichToppingList);
		
    boolean isBreadNutFree;
    //checks if the bread chosen by the user is nut-free because the bread is the only ingredient that might contain nuts
    if(chosenBreadList.contains("Nut Bread")) {
      isBreadNutFree = b.isNutFree();
    }
    else {
      isBreadNutFree = !(b.isNutFree());
    }
		
    //gives isFillingNutFree and isToppingNutFree true values because there are not any fillings or toppings that contain nuts
    boolean isFillingNutFree = f.isNutFree();
    boolean isToppingNutFree = t.isNutFree();
		
    //if all ingredients are nut-free returns true value, if not - false value
    if((isBreadNutFree == true) && (isFillingNutFree == true) && (isToppingNutFree == true)) {
      return true;
    }
    else {
      return false;
    }
  }
	
  //method that checks if the sandwich is vegetarian
  public boolean isVegetarian(List<String> chosenBreadList, List<String> chosenFillingList, List<String> chosenToppingList) {
    Map<String, Double> sandwichBreads = new HashMap<>();
    List<String> sandwichBreadList = new ArrayList<>();
    Map<String, Double> sandwichFillings = new HashMap<>();
    List<String> sandwichFillingList = new ArrayList<>();
    Map<String, Double> sandwichToppings = new HashMap<>();
    List<String> sandwichToppingList = new ArrayList<>();
		
    Bread b = new Bread(sandwichBreads, sandwichBreadList);
    Filling f = new Filling(sandwichFillings, sandwichFillingList);
    Topping t = new Topping(sandwichToppings, sandwichToppingList);
		
    //gives isBreadVegetarian true value because all of the breads are vegetarian
    boolean isBreadVegetarian = b.isVegetarian();

    boolean isFillingVegetarian;		
    //checks if the fillings chosen by the user are vegetarian because chosen fillings might not be vegetarian
    if((chosenFillingList.contains("Bacon")) || (chosenFillingList.contains("Chicken")) || (chosenFillingList.contains("Ham"))) {
      isFillingVegetarian = f.isVegetarian();
    }
    else {
      isFillingVegetarian = !(f.isVegetarian());
    }
		
    //gives isToppingVegetarian true value because all of the toppings are vegetarian
    boolean isToppingVegetarian = t.isVegetarian();
		
    //if all ingredients are vegetarian returns true value, if not - false value
    if((isBreadVegetarian == true) && (isFillingVegetarian == true) && (isToppingVegetarian == true)) {
      return true;
    }
    else {
      return false;
    }
  }	
}

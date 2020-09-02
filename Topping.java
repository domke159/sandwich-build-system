import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Topping extends Ingredient {
	
  private String toppingName;
  private double cost;
  private Map<String, Double> toppings = new HashMap<>();
  private List<String> toppingList;
	
  //constructor for Topping class that takes string and double values as parameters and sets them
    public Topping(String toppingName, double cost) {
      setIngredientName(toppingName);
      setIngredientCost(cost);
    }
	
  //another constructor for Topping class that takes a map and a list as parameters and sets their values
  public Topping(Map<String, Double> toppings, List<String> toppingList) {
    addIngredients(toppings, toppingList);
    setIngredients(toppings);
    setIngredientList(toppingList);
  }
	
	
  //get and set methods for topping name, topping cost, topping map and topping list
  public void setIngredientName (String toppingName) {
    this.toppingName = toppingName;
  }
	
  public String getIngredientName() {
    return toppingName;
  }
	
  public void setIngredientCost(double cost) {
    this.cost = cost;
  }
	
  public double getIngredientCost() {
    return cost;
  }
	
  public void setIngredients(Map<String, Double> toppings) {
    this.toppings = toppings;
  }
	
  public Map<String, Double> getIngredients(){
    return toppings;
  }
	
  public void setIngredientList(List<String> toppingList) {
    this.toppingList = toppingList;
  }
	
  public List<String> getIngredientList(){
    return Collections.unmodifiableList(toppingList);
  }
	
  //method for creating multiple topping objects and adding their values to the map
  public void addIngredients(Map<String, Double> toppings, List<String> toppingList) {
    Topping ketchup = new Topping("Ketchup", 0.2);
    toppings.put(ketchup.getIngredientName(), ketchup.getIngredientCost());
		
    Topping mayonnaise = new Topping("Mayonnaise", 0.2);
    toppings.put(mayonnaise.getIngredientName(), mayonnaise.getIngredientCost());
		
    Topping mustard = new Topping("Mustard", 0.2);
    toppings.put(mustard.getIngredientName(), mustard.getIngredientCost());
		
    Topping garlicSauce = new Topping("Garlic Sauce", 0.3);
    toppings.put(garlicSauce.getIngredientName(), garlicSauce.getIngredientCost());
		
    Topping chilliSauce = new Topping("Chilli Sauce", 0.3);
    toppings.put(chilliSauce.getIngredientName(), chilliSauce.getIngredientCost());
		
    //adds all topping names to the toppingList and sorts it
    toppingList.addAll(toppings.keySet());
    Collections.sort(toppingList);
  }
	
  //boolean method that returns a true value because all toppings are nut-free
  public boolean isNutFree() {
    return true;
  }
	
  //boolean method that returns a true value because all toppings are vegetarian
  public boolean isVegetarian() {
    return true;
  }
}

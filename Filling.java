import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Filling extends Ingredient {
	
  private String fillingName;
  private double cost;
  private Map<String, Double> fillings = new HashMap<>();
  private List<String> fillingList;
	
  //constructor for Filling class that takes string and double values as parameters and sets them
  public Filling(String fillingName, double cost) {
    setIngredientName(fillingName);
    setIngredientCost(cost);
  }
	
  //another constructor for Filling class that takes a map and a list as parameters and sets their values
  public Filling(Map<String, Double> fillings, List<String> fillingList) {
    addIngredients(fillings, fillingList);
    setIngredients(fillings);
    setIngredientList(fillingList);
  }
	
  //get and set methods for filling name, filling cost, filling map and filling list
  public void setIngredientName (String fillingName) {
    this.fillingName = fillingName;
  }
	
  public String getIngredientName() {
    return fillingName;
  }
	
  public void setIngredientCost(double cost) {
    this.cost = cost;
  }
	
  public double getIngredientCost() {
    return cost;
  }
	
  public void setIngredients(Map<String, Double> fillings) {
    this.fillings = fillings;
  }
	
  public Map<String, Double> getIngredients(){
    return fillings;
  }
	
  public void setIngredientList(List<String> fillingList) {
    this.fillingList = fillingList;
  }
	
  public List<String> getIngredientList(){
    return Collections.unmodifiableList(fillingList);
  }

  //method for creating multiple filling objects and adding their values to the map
  public void addIngredients(Map<String, Double> fillings, List<String> fillingList) {
    Filling ham = new Filling("Ham", 0.7);
    fillings.put(ham.getIngredientName(), ham.getIngredientCost());
		
    Filling lettuce = new Filling("Lettuce", 0.2);
    fillings.put(lettuce.getIngredientName(), lettuce.getIngredientCost());
		
    Filling bacon = new Filling("Bacon", 0.6);
    fillings.put(bacon.getIngredientName(), bacon.getIngredientCost());
		
    Filling cheddarCheese = new Filling("Cheddar Cheese", 0.3);
    fillings.put(cheddarCheese.getIngredientName(), cheddarCheese.getIngredientCost());
		
    Filling chicken = new Filling("Chicken", 0.8);
    fillings.put(chicken.getIngredientName(), chicken.getIngredientCost());
		
    Filling onions = new Filling("Onions", 0.3);
    fillings.put(onions.getIngredientName(), onions.getIngredientCost());
		
    Filling tomatoes = new Filling("Tomatoes", 0.3);
    fillings.put(tomatoes.getIngredientName(), tomatoes.getIngredientCost());
		
    Filling vegetarianSausage = new Filling("Vegetarian Sausage", 0.7);
    fillings.put(vegetarianSausage.getIngredientName(), vegetarianSausage.getIngredientCost());
		
    //adds all filling names to the fillingList and sorts it
    fillingList.addAll(fillings.keySet());
    Collections.sort(fillingList);
  }
	
  //boolean method that returns a true value because all fillings are nut-free
  public boolean isNutFree() {
    return true;
  }
	
  //boolean method that returns a false value because there are meat ingredients in the filling list
  public boolean isVegetarian() {
    return false;
  }
}

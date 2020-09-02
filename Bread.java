import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Bread extends Ingredient {
	
  private String breadName;
  private double cost;
  private Map<String, Double> breads = new HashMap<>();
  private List<String> breadList;
	
  //constructor for Bread class that takes string and double values as parameters and sets them
  public Bread(String breadName, double cost) {
    setIngredientName(breadName);
    setIngredientCost(cost);
  }
	
  //another constructor for Bread class that takes a map and a list as parameters and sets their values
  public Bread(Map<String, Double> breads, List<String> breadList) {
    addIngredients(breads, breadList);
    setIngredients(breads);
    setIngredientList(breadList);
  }
	
  //get and set methods for bread name, bread cost, bread map and bread list
  public void setIngredientName (String breadName) {
    this.breadName = breadName;
  }
	
  public String getIngredientName() {
    return breadName;
  }
	
  public void setIngredientCost(double cost) {
    this.cost = cost;
  }
	
  public double getIngredientCost() {
    return cost;
  }
	
  public void setIngredients(Map<String, Double> breads) {
    this.breads = breads;
  }
	
  public Map<String, Double> getIngredients(){
    return breads;
  }
	
  public void setIngredientList(List<String> breadList) {
    this.breadList = breadList;
  }
	
  public List<String> getIngredientList(){
    return Collections.unmodifiableList(breadList);
  }
	
  //method for creating multiple bread objects and adding their values to the map
  public void addIngredients(Map<String, Double> breads, List<String> breadList) {
    Bread pitaBread = new Bread("Pita Bread", 0.5);
    breads.put(pitaBread.getIngredientName(), pitaBread.getIngredientCost());
		
    Bread ciabatta = new Bread("Ciabatta", 0.6);
    breads.put(ciabatta.getIngredientName(), ciabatta.getIngredientCost());
		
    Bread WholewheatBread = new Bread("Wholewheat Bread", 0.4);
    breads.put(WholewheatBread.getIngredientName(), WholewheatBread.getIngredientCost());
		
    Bread glutenFreeWhiteBread = new Bread("Gluten-Free White Bread", 0.4);
    breads.put(glutenFreeWhiteBread.getIngredientName(), glutenFreeWhiteBread.getIngredientCost());
		
    Bread nutFreeBread = new Bread("Nut Bread", 0.5);
    breads.put(nutFreeBread.getIngredientName(), nutFreeBread.getIngredientCost());
		
    //adds all bread names to the breadList and sorts it
    breadList.addAll(breads.keySet());
    Collections.sort(breadList);
  }
	
  //boolean method that returns a false value because there is an ingredient with nuts in the bread list
  public boolean isNutFree() {
    return false;
  }
	
  //boolean method that returns a true value because all breads are vegetarian
    public boolean isVegetarian() {
    return true;
  }
}
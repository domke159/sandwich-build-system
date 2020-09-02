import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class Ingredient {
	
  private String ingredientName;
  private double ingredientCost;
  private Map<String, Double> ingredients = new HashMap<>();
  private List<String> ingredientList;
	
  //get and set methods for the name, cost, map and list of the ingredient
  public abstract void setIngredientName(String ingredientName);
	
  public abstract String getIngredientName();
	
  public abstract void setIngredientCost(double ingredientCost);
	
  public abstract double getIngredientCost();
	
  public abstract void setIngredients(Map<String, Double> ingredients);
	
  public abstract Map<String, Double> getIngredients();
	
  public abstract void setIngredientList(List<String> ingredientList);
	
  public abstract List<String> getIngredientList();
	
  //method for adding values to the ingredient map and list
  public abstract void addIngredients(Map<String, Double> ingredients, List<String> ingredientList);

  //method for checking if the ingredient is nut-free
  public abstract boolean isNutFree();
	
  //method for checking if the ingredient is vegetarian
  public abstract boolean isVegetarian();
}
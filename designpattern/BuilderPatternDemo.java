package designpattern;

import java.util.ArrayList;
import java.util.List;

//Step 1:Create an interface Item representing food item and packing.

interface Item {
	   public String name();
	   public Packing packing();
	   public float price();	
	}

interface Packing {
	   public String pack();
	}

//Step 2:Create concrete classes implementing the Packing interface.
class Wrapper implements Packing {

	   @Override
	   public String pack() {
	      return "Wrapper";
	   }
	}

class Bottle implements Packing {

	   @Override
	   public String pack() {
	      return "Bottle";
	   }
	}

//Step 3:Create abstract classes implementing the item interface providing default functionalities.
abstract class Burger implements Item {

	   @Override
	   public Packing packing() {
	      return new Wrapper();
	   }

	   @Override
	   public abstract float price();
	}

abstract class ColdDrink implements Item {

	@Override
	public Packing packing() {
       return new Bottle();
	}

	@Override
	public abstract float price();
}

//Step 4:Create concrete classes extending Burger and ColdDrink classes
class VegBurger extends Burger {

	   @Override
	   public float price() {
	      return 25.0f;
	   }

	   @Override
	   public String name() {
	      return "Veg Burger";
	   }
	}
class ChickenBurger extends Burger {

	   @Override
	   public float price() {
	      return 50.5f;
	   }

	   @Override
	   public String name() {
	      return "Chicken Burger";
	   }
	}
class Coke extends ColdDrink {

	   @Override
	   public float price() {
	      return 30.0f;
	   }

	   @Override
	   public String name() {
	      return "Coke";
	   }
	}
class Pepsi extends ColdDrink {

	   @Override
	   public float price() {
	      return 35.0f;
	   }

	   @Override
	   public String name() {
	      return "Pepsi";
	   }
	}

//Step 5:Create a Meal class having Item objects defined above.

class Meal {
   private List<Item> items = new ArrayList<Item>();	

   public void addItem(Item item){
      items.add(item);
   }

   public float getCost(){
      float cost = 0.0f;
      
      for (Item item : items) {
         cost += item.price();
      }		
      return cost;
   }

   public void showItems(){
   
      for (Item item : items) {
         System.out.print("Item : " + item.name());
         System.out.print(", Packing : " + item.packing().pack());
         System.out.println(", Price : " + item.price());
      }		
   }	
}


//Step 6:Create a MealBuilder class, the actual builder class responsible to create Meal objects.

class MealBuilder {

	   public Meal prepareVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new VegBurger());
	      meal.addItem(new Coke());
	      return meal;
	   }   

	   public Meal prepareNonVegMeal (){
	      Meal meal = new Meal();
	      meal.addItem(new ChickenBurger());
	      meal.addItem(new Pepsi());
	      return meal;
	   }
	}

//Step 7:BuiderPatternDemo uses MealBuider to demonstrate builder pattern.

public class BuilderPatternDemo {
	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();

	      Meal vegMeal = mealBuilder.prepareVegMeal();
	      System.out.println("Veg Meal");
	      vegMeal.showItems();
	      System.out.println("Total Cost: " + vegMeal.getCost());

	      Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
	      System.out.println("\n\nNon-Veg Meal");
	      nonVegMeal.showItems();
	      System.out.println("Total Cost: " + nonVegMeal.getCost());
	}

}

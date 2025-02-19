package main.java.coffeevendingmachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeVendingMachine {
    private CoffeeVendingMachine instance;
    private final List<Coffee> coffeeMenu;
    private final Map<String, Ingredient> ingredients;


    public CoffeeVendingMachine() {
        this.coffeeMenu = new ArrayList<>();
        this.ingredients = new HashMap<>();
        initializeIngredients();
        initializeCoffeeMenu();

    }

    public void displayMenu() {
        System.out.println("Coffee Menu:");
        for (Coffee coffee : coffeeMenu) {
            System.out.println(coffee.getName() + " - $" + coffee.getPrice());
        }
    }

    public synchronized Coffee selectCoffee(String coffeeName) {
        for (Coffee coffee : coffeeMenu) {
            if (coffee.getName().equalsIgnoreCase(coffeeName)) {
                return coffee;
            }
        }
        return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee, Payment payment) {
        if (payment.getAmount() >= coffee.getPrice()) {
            if (hasEnoughIngredients(coffee)) {
                updateIngredients(coffee);
                System.out.println("Dispensing " + coffee.getName() + "...");
                double change = payment.getAmount() - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
            } else {
                System.out.println("Insufficient ingredients to make " + coffee.getName());
            }
        } else {
            System.out.println("Insufficient payment for " + coffee.getName());
        }
    }

    private boolean hasEnoughIngredients(Coffee coffee) {
        for(Map.Entry<Ingredient, Integer> entry: coffee.getRecipe().entrySet()) {
            Ingredient ingrediant = entry.getKey();

            int requiredQuantity = entry.getValue();

            if (requiredQuantity > ingrediant.getQuantity()) {
                return false;
            }
        }

        return true;
    }

    private void updateIngredients(Coffee coffee) {
        for (Map.Entry<Ingredient, Integer> entry : coffee.getRecipe().entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredQuantity = entry.getValue();
            ingredient.updateQuantity(-requiredQuantity);
            if (ingredient.getQuantity() < 3) {
                System.out.println("Low inventory alert: " + ingredient.getName());
            }
        }
    }

    private void initializeCoffeeMenu() {
        Map<Ingredient, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(ingredients.get("coffee"), 1);
        espressoRecipe.put(ingredients.get("water"), 1);
        Coffee espressoCoffee = new Coffee("espresso", 2, espressoRecipe);
        coffeeMenu.add(espressoCoffee);

        Map<Ingredient, Integer> latteCoffeeRecipe = new HashMap<>();
        latteCoffeeRecipe.put(ingredients.get("coffee"), 1);
        latteCoffeeRecipe.put(ingredients.get("milk"), 1);
        latteCoffeeRecipe.put(ingredients.get("water"), 1);
        Coffee latteCoffee = new Coffee("latte", 2, latteCoffeeRecipe);
        coffeeMenu.add(latteCoffee);
    }

    private void initializeIngredients() {
        Ingredient water = new Ingredient("water", 10);
        ingredients.put("water", water);
        Ingredient milk = new Ingredient("milk", 10);
        ingredients.put("milk", milk);
        Ingredient coffee = new Ingredient("coffee", 10);
        ingredients.put("coffee", coffee);
    }




}

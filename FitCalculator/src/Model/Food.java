package Model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public  class Food {
    Map<String, Integer> foodList = new HashMap<String, Integer>();

    public Food() throws FileNotFoundException {
        getFoodList();
    }

    //reads txt file and stores values in hashmap
    public void getFoodList() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("/Users/mshabrajshahid/IdeaProjects/FitCalculator/src/Model/FoodList.txt"));
        while(sc.hasNext()){

            String[] lineParts = sc.nextLine().split(":",2);
            if(lineParts.length>=2){

                String food = lineParts[0];
                String calorie = lineParts[1];
                foodList.put(food, Integer.parseInt(calorie));
            }

        }
        for (String foodItem : foodList.keySet() ){

            System.out.println(foodItem + " has " + foodList.get(foodItem) + " calories.");
        }


    }

    //this method is used by foodpage to show list of food and their calories
    public Object[][] getFoodAndFoodCalories() {

        Object[][] foodCalorieArray = new Object[foodList.size()][2];

        Object[] keys = foodList.keySet().toArray();
        Object[] values = foodList.values().toArray();

        for (int row = 0; row < foodCalorieArray.length; row++) {
            foodCalorieArray[row][0] = keys[row];
            foodCalorieArray[row][1] = values[row];
        }


        return foodCalorieArray;
    }




}

package Model;

public interface CalculateCalories {

    int getExerciseLevel();
    int getAge();
    double getHeight();
    char getGender();
    double getWeight();

    //calculates BMR
     default double calculateBMR() {

        int BMR = 0;

        if (getGender() == ('M' | 'm')) {
            BMR = (int) (66 + (6.23 * getWeight()) + (12.7 * getHeight()) - (6.8 * getAge()));
        } else if (getGender() == ('F' | 'f')){
            BMR = (int) (665 + (4.35 * getWeight()) + (4.7 * getHeight()) - (4.7 * getAge()));
        }

        return BMR;
    }

    //calculates calories
     default double calculateCaloriesPerDay(){
        double caloriesPerDay =0;

        switch (getExerciseLevel()){
            case 1 : caloriesPerDay = calculateBMR() * 1.20 ; break;
            case 2 : caloriesPerDay = calculateBMR() * 1.38 ; break;
            case 3 : caloriesPerDay = calculateBMR() * 1.55 ; break;
            case 4 : caloriesPerDay = calculateBMR() * 1.73 ; break;
            case 5 : caloriesPerDay = calculateBMR() * 1.90 ; break;
            default: break;
        }

        return  caloriesPerDay;
    }


}

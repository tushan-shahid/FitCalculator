package Model;

public abstract class UserDetails implements CalculateCalories {

   private int age;
   private char gender;
   private double height;
   private double weight;
   private int exerciseLevel;



    public UserDetails() {

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() { return weight; }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getExerciseLevel() {
        return exerciseLevel;
    }

    public void setExerciseLevel(int exerciseLevel) {
        this.exerciseLevel = exerciseLevel;
    }


    @Override
    public String toString() {
        return  '{'+"age=" + age +
                ", gender='" + gender +
                ", height=" + height +
                ", weight=" + weight +
                ", calories needed=" + calculateCaloriesPerDay()+
                '}';
    }

}


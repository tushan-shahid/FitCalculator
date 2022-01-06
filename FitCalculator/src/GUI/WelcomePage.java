package GUI;

import Model.UserDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.NumberFormat;

public class WelcomePage extends UserDetails implements ActionListener {

    JFrame myFrame = new JFrame();
    JLabel welcomeLabel = new JLabel();
    JLabel startMessageLabel = new JLabel();
    JLabel askLevelOfExercise = new JLabel();
    JLabel messageLabel = new JLabel();


    private JLabel genderLabel;
    private JLabel ageLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JLabel exerciseLevelLabel;

    private int initialCaloriesPerDay;

    private static String genderString = "Gender(M/F): ";
    private static String ageString = "Age(years): ";
    private static String heightString = "Height(cm): ";
    private static String weightString = "Weight(kg): ";
    private static String exerciseLevelString = "Exercise Level: ";

    private JTextField genderField;
    private JFormattedTextField ageField;
    private JFormattedTextField heightField;
    private JFormattedTextField weightField;
    private JFormattedTextField exerciseLevelField;

    private NumberFormat ageFormat;
    private NumberFormat heightFormat;
    private NumberFormat weightFormat;
    private NumberFormat exerciseLevelFormat;

    JButton enterButton = new JButton("ENTER");
    JButton resetButton = new JButton("RESET");

//setting up welcome page
    WelcomePage(String id){
        welcomeLabel.setBounds(10,10,400, 70);
        welcomeLabel.setFont(new Font(null,Font.BOLD,25));
        welcomeLabel.setText("Hello "+ id);

        startMessageLabel.setBounds(50, 50, 400 , 70);
        startMessageLabel.setText("Please enter details about yourself.");

        setUpFormats();

        genderLabel = new JLabel(genderString);
        genderLabel.setBounds(100, 200, 140 , 50);
        ageLabel = new JLabel(ageString);
        ageLabel.setBounds(100,250,140,50);
        heightLabel = new JLabel(heightString);
        heightLabel.setBounds(100,300,140,50);
        weightLabel = new JLabel(weightString);
        weightLabel.setBounds(100,350,140,50);

        askLevelOfExercise.setBounds(50,100,500,110);
        askLevelOfExercise.setText("<html><body><p>ENTER YOUR LEVEL OF EXERCISE<br/>No Exercise (ENTER 1)<br/>Light Exercise 1-3 times/week (ENTER 2)<br/>Moderate Exercise 4-5 times/week (ENTER 3)<br/>Intense Exercise 6-7 times/week (ENTER 4)<br/>Very Intense Exercise 6-7 times/week + Active/Physical Job (ENTER 5)</p></body></html>");

        exerciseLevelLabel = new JLabel(exerciseLevelString);
        exerciseLevelLabel.setBounds(100,400,140,50);


        genderField = new JTextField();
        genderField.setBounds(200,200,280,50);

        ageField = new JFormattedTextField(ageFormat);
        ageField.setBounds(200,250,280,50);


        heightField = new JFormattedTextField(heightFormat);
        heightField.setBounds(200,300,280,50);


        weightField = new JFormattedTextField(weightFormat);
        weightField.setBounds(200,350,280,50);


        exerciseLevelField = new JFormattedTextField(exerciseLevelFormat);
        exerciseLevelField.setBounds(200,400,280,50);



        enterButton.setBounds(100,450,200,50);
        enterButton.addActionListener(this);

        resetButton.setBounds(300,450 ,200,50);
        resetButton.addActionListener(this);




        myFrame.add(welcomeLabel);
        myFrame.add(startMessageLabel);
        myFrame.add(askLevelOfExercise);

        myFrame.add(genderLabel);
        myFrame.add(genderField);
        myFrame.add(ageLabel);
        myFrame.add(ageField);
        myFrame.add(heightLabel);
        myFrame.add(heightField);
        myFrame.add(weightLabel);
        myFrame.add(weightField);
        myFrame.add(exerciseLevelLabel);
        myFrame.add(exerciseLevelField);

        myFrame.add(enterButton);
        myFrame.add(resetButton);

        myFrame.add(messageLabel);

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(800,800);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    //this method sets up the input format of use fields
    private void setUpFormats() {
        ageFormat = NumberFormat.getNumberInstance();

        heightFormat = NumberFormat.getNumberInstance();
        heightFormat.setMinimumFractionDigits(3);

        weightFormat = NumberFormat.getNumberInstance();
        weightFormat.setMinimumFractionDigits(3);

        exerciseLevelFormat = NumberFormat.getIntegerInstance();
        exerciseLevelFormat.setMinimumIntegerDigits(1);
        exerciseLevelFormat.setMaximumIntegerDigits(5);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton){
            genderField.setText("");
            ageField.setText("");
            heightField.setText("");
            weightField.setText("");
            exerciseLevelField.setText("");
        }if(e.getSource()==enterButton) {
            char gender = genderField.getText().charAt(0);
            setGender(gender);
            int age = Integer.parseInt(ageField.getText());
            setAge(age);
            double height = Double.parseDouble(heightField.getText());
            setHeight(height);
            double weight = Double.parseDouble(weightField.getText());
            setWeight(weight);
            int exerciseLevel = Integer.parseInt(exerciseLevelField.getText());
            setExerciseLevel(exerciseLevel);

            initialCaloriesPerDay = (int) calculateCaloriesPerDay();
            System.out.println(initialCaloriesPerDay);

            myFrame.dispose();

            try {
                FoodPage foodpage = new FoodPage(initialCaloriesPerDay);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }


        }else{
            messageLabel.setForeground(Color.red);
            messageLabel.setText("Invalid Input!");

        }
    }
}

package GUI;

import Model.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

public class FoodPage extends Food {

    JFrame myFrame = new JFrame();
    JLabel initialCalorieMessageLabel = new JLabel();
    JLabel foodEatenMessageLabel = new JLabel();

    private  int userEatenCalories;
    private int initialCalories;


    public FoodPage(int initialCaloriesPerDay) throws FileNotFoundException {

         initialCalories=initialCaloriesPerDay;

        Food food = new Food();

        String[] columnNames = {"Food", "Calories",};
        Object[][] data = getFoodAndFoodCalories();

        JTable table = new JTable(data, columnNames);

        table.setPreferredScrollableViewportSize(new Dimension(770, 400));
        table.setFillsViewportHeight(true);

        initialCalorieMessageLabel.setBounds(10,450,400, 70);
        initialCalorieMessageLabel.setText("You need " + initialCalories + " Calories per day to live a healthy lifestyle" );

        foodEatenMessageLabel.setBounds(10,480,400,70);
        foodEatenMessageLabel.setText("<html><body><p>Please select what you have eaten from above Food List.<br/>(click calorie corresponding food item)</p></body></html>");


        JScrollPane scrollPane = new JScrollPane(table);


        //checks to see which food was chosen
        //please click calorie number on list and it will subtract from initial calories of user
        table.addMouseListener(new MouseAdapter() {
                                   public void mouseClicked(MouseEvent e) {
                                       if (e.getClickCount() == 1) {
                                           JTable target = (JTable) e.getSource();
                                           int row = target.getSelectedRow(); // select a row
                                           int column = target.getSelectedColumn(); // select a column

                                           userEatenCalories = (int) table.getValueAt(row,column);
                                           System.out.println( table.getValueAt(row,column));

                                          initialCalories = (initialCalories - userEatenCalories);
                                           System.out.println(initialCalories);
                                           JOptionPane.showMessageDialog(myFrame, "After Eating. You have " + initialCalories + " Calories left. \n Thank you for using FitCalculator!");

                                       }
                                   }
                               });
        myFrame.add(initialCalorieMessageLabel);
        myFrame.add(foodEatenMessageLabel);
        myFrame.add(scrollPane);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(800,800);
        myFrame.setLayout(null);
        myFrame.setVisible(true);

    }
}

package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    //fields for login page
    JFrame myFrame = new JFrame();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JTextField idField = new JTextField();
    JPasswordField pwField = new JPasswordField();
    JLabel idLabel = new JLabel("User ID: ");
    JLabel pwLabel = new JLabel("Password: ");
    JLabel welcomeMessage = new JLabel("Welcome To FitCalculator!");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    //setting up login page
    LoginPage(HashMap<String, String> originalInfo){
        loginInfo = originalInfo;

        welcomeMessage.setBounds(100,100,400,70);
        welcomeMessage.setFont(new Font(null,Font.BOLD,25));

        idLabel.setBounds(100, 200, 140 , 50);
        pwLabel.setBounds(100, 300, 140 , 50);

        messageLabel.setBounds(250, 500, 500, 70);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        idField.setBounds(250,200,400,50);
        pwField.setBounds(250,300,400,50);

        loginButton.setBounds(250,400,200,50);
        loginButton.addActionListener(this);

        resetButton.setBounds(450, 400 ,200,50);
        resetButton.addActionListener(this);

        myFrame.add(welcomeMessage);
        myFrame.add(idLabel);
        myFrame.add(pwLabel);
        myFrame.add(messageLabel);
        myFrame.add(idField);
        myFrame.add(pwField);
        myFrame.add(loginButton);
        myFrame.add(resetButton);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(800,800);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
    }

    //this method checks to see what button has been pressed and performs tasks accordingly
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==resetButton){
            idField.setText("");
            pwField.setText("");
            messageLabel.setText("");
        }

        if(e.getSource()==loginButton){
            String id = idField.getText();
            String pw = String.valueOf(pwField.getPassword());

            if(loginInfo.containsKey(id)){
                if(loginInfo.get(id).equals(pw)){
                    messageLabel.setForeground(Color.blue);
                    messageLabel.setText("LOGIN SUCCESS!");
                    myFrame.dispose();
                    WelcomePage welcomePage = new WelcomePage(id);
                }else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("WRONG PASSWORD.");
                }
            }else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("WRONG USER ID.");
            }
        }
    }
}

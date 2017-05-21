package codeu.chat.client.simplegui.newaccountframe;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewAccount extends JFrame {

    // constructor
    public NewAccount () {

        // groundwork
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setAlignmentX(LEFT_ALIGNMENT);
        GridBagConstraints gbConstraints = new GridBagConstraints();

        // create welcome label
        JLabel welcomeLabel = new JLabel("Welcome to ChatU!\nPlease select a username and password.");
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 0;
        panel.add(welcomeLabel, gbConstraints);

        // create user label
        JLabel userNameLabel = new JLabel("Please create a user name");
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 1;
        panel.add(userNameLabel, gbConstraints);

        // username textfield
        JTextField userNameTextField = new JTextField("", 20);
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 2;
        panel.add(userNameTextField, gbConstraints);

        // create password label
        JLabel userPasswordLabel = new JLabel("Please create a password");
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 3;
        panel.add(userPasswordLabel, gbConstraints);

        // password textfield
        JTextField userpasswordTextField = new JTextField("", 20);
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 4;
        panel.add(userpasswordTextField, gbConstraints);

        // create account button
        JButton createAccountButton = new JButton("Create");
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 5;
        panel.add(createAccountButton, gbConstraints);

        // cancel button
        JButton cancelButton = new JButton("Cancel");
        gbConstraints.gridx = 1;
        gbConstraints.gridy = 5;
        panel.add(cancelButton, gbConstraints);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create an Account");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    } // end of NewAccount()



}   // end of class NewAccount

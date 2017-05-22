package codeu.chat.client.simplegui.newaccountframe;

/**
 * @author  Troy Jones
 * @date    5/21/17
 * @brief   Contains all GUI necessary to execute the frame to 
 *          create a new account.
 */

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewAccount extends JFrame {

    // constructor
    public NewAccount () {

        // fill welcomeTextPanel
        JPanel welcomeTextPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to ChatU!");
        JLabel instructionLabel = 
            new JLabel("Please select a username and password.");
        welcomeTextPanel.add(welcomeLabel);
        welcomeTextPanel.add(instructionLabel);
        BoxLayout welcomeLayout = 
            new BoxLayout(welcomeTextPanel, BoxLayout.Y_AXIS);
        welcomeTextPanel.setLayout(welcomeLayout);

        // fill usernameAndPasswordPanel
        JPanel usernameAndPasswordPanel = new JPanel();
        JLabel userNameLabel = new JLabel("Choose a user name");
        usernameAndPasswordPanel.add(userNameLabel);
        JTextField userNameTextField = new JTextField(10);
        usernameAndPasswordPanel.add(userNameTextField);
        JLabel userPasswordLabel = new JLabel("Choose a password");
        usernameAndPasswordPanel.add(userPasswordLabel);
        JTextField userpasswordTextField = new JTextField(10);
        usernameAndPasswordPanel.add(userpasswordTextField);
        BoxLayout userstuffLayout = new BoxLayout(usernameAndPasswordPanel, BoxLayout.Y_AXIS);
        usernameAndPasswordPanel.setLayout(userstuffLayout);

        // fill buttonsPanel
        JPanel buttonsPanel = new JPanel();
        JButton createAccountButton = new JButton("Create");
        buttonsPanel.add(createAccountButton);
        JButton cancelButton = new JButton("Cancel");
        buttonsPanel.add(cancelButton);

        // fill mainPanel
        JPanel mainPanel = new JPanel();
        BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainLayout);
        mainPanel.add(welcomeTextPanel);
        mainPanel.add(usernameAndPasswordPanel);
        mainPanel.add(buttonsPanel);

        // publish frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Create an Account");
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    } // end of NewAccount()



}   // end of class NewAccount

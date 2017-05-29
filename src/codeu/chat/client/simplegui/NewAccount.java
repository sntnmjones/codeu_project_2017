package codeu.chat.client.simplegui;

<<<<<<< HEAD
import java.awt.*;
=======
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import codeu.chat.UserMap;
<<<<<<< HEAD
import codeu.chat.client.ClientContext;
=======
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b

@SuppressWarnings("serial")
/**
 * @author  Troy Jones
 * @date    5/21/17
 * @brief   Contains all GUI necessary to execute the frame to 
 *          create a new account.
 */
public class NewAccount extends JFrame {

<<<<<<< HEAD
    //UserMap userMap;
    //HashMap<String, char[]> usernameAndPassword;
    ClientContext context;

    public NewAccount (JFrame mainFrame, ClientContext context) {
        JFrame newAccountFrame = new JFrame();
        this.context = context;

        //userMap = new UserMap();
=======
    UserMap userMap;
    HashMap<String, char[]> usernameAndPassword;

    public NewAccount (JFrame mainFrame) {
        JFrame newAccountFrame = new JFrame();
        userMap = new UserMap();
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
        // create mainPanel
        JPanel mainPanel = new JPanel();
        BoxLayout mainPanelLayout = 
                new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
        mainPanel.setLayout(mainPanelLayout);

        // fill welcomeTextPanel
        JPanel welcomeTextPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to ChatU!");
        welcomeTextPanel.add(welcomeLabel);
        mainPanel.add(welcomeTextPanel);

        // username label and textfield
        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Choose a user name up to 10 characters");
        usernamePanel.add(usernameLabel);
        JTextField userNameTextField = new JTextField(10);
        usernamePanel.add(userNameTextField);
        mainPanel.add(usernamePanel);

        // password label and textfield
        JPanel userPasswordPanel = new JPanel();
        JLabel userPasswordLabel = new JLabel("Choose a password up to 10 characters");
        userPasswordPanel.add(userPasswordLabel);
        JPasswordField userpasswordTextField = new JPasswordField(10);
        userPasswordPanel.add(userpasswordTextField);
        // TODO: enable password authentication
        //mainPanel.add(userPasswordPanel); // commented out until needed

        // fill buttonsPanel
        JPanel buttonsPanel = new JPanel();
        JButton createAccountButton = new JButton("Create");
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                String userName = new String(userNameTextField.getText());
<<<<<<< HEAD
                //usernameAndPassword = codeu.chat.UserMap.map;

                // Checks
                if (context.user.lookupByName(userName) != null) {
                        JOptionPane.showMessageDialog(newAccountFrame, "User already exists.");
=======
                usernameAndPassword = codeu.chat.UserMap.map;

                if(usernameAndPassword.containsKey(userName)) {
                    JOptionPane.showMessageDialog(newAccountFrame, "User already exists.");
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
                } else {
                    if(userName.length() > 10) {
                        JOptionPane.showMessageDialog(newAccountFrame,
                                "User name is larger than 10 characters.");
                    } else {
                        char[] tempPassword = {'a'};
<<<<<<< HEAD
                        context.accessController.newUser(userName);
                        context.user.addUser(userName);
=======
                        usernameAndPassword.put(userName, tempPassword);
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
                        // start chat
                        JOptionPane.showMessageDialog(newAccountFrame, "Please sign in.");
                        newAccountFrame.dispose();
                        mainFrame.setVisible(true);
                    }
                }
<<<<<<< HEAD
                //System.out.println(context.user.showUserInfo(userName));

=======
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
            }
        });

        buttonsPanel.add(createAccountButton);
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainFrame.setVisible(true);
                newAccountFrame.dispose();
            }
        });
        buttonsPanel.add(cancelButton);
        mainPanel.add(buttonsPanel);

        // publish frame
        newAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newAccountFrame.setTitle("Create an Account");
        newAccountFrame.setSize(500, 200);
        newAccountFrame.add(mainPanel);
        newAccountFrame.setVisible(true);
        buttonsPanel.getRootPane().setDefaultButton(createAccountButton);
    } // end of NewAccount()

<<<<<<< HEAD
}   // end of class NewAccount
=======
}   // end of class NewAccount
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b

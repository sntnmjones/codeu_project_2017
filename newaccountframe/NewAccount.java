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

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbConstraints = new GridBagConstraints();

        // create user label
        JLabel userNameLabel = new JLabel("Please create a user name");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 0;
        panel.add(userNameLabel, gbConstraints);

        // username textfield
        JTextField usernameTextField = new JTextField("", 20);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 1;
        panel.add(usernameTextField, gbConstraints);

        // create password label
        JLabel userPasswordLabel = new JLabel("Please create a password");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 2;
        panel.add(userPasswordLabel, gbConstraints);

        // password textfield
        JTextField userpasswordTextField = new JTextField("", 20);
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 3;
        panel.add(userpasswordTextField, gbConstraints);

        // create account button
        JButton createAccountButton = new JButton("Create");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 3;
        panel.add(createAccountButton, gbConstraints);

        // cancel button
        JButton cancelButton = new JButton("Cancel");
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;
        gbConstraints.gridx = 0;
        gbConstraints.gridy = 4;
        panel.add(cancelButton, gbConstraints);

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Create an Account");
        panel.add(cancelButton);
        panel.add(userNameLabel);
        panel.add(userPasswordLabel);
        panel.add(usernameTextField);
        panel.add(userpasswordTextField);
        //this.add(panel);
        
        this.pack();
        this.setVisible(true);
    }   // end of NewAccount()



}   // end of class NewAccount

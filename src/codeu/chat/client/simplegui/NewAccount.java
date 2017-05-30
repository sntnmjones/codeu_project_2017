package codeu.chat.client.simplegui;

import java.awt.*;
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

import codeu.chat.client.simplegui.originalgui.OriginalChatSimpleGui;
import codeu.chat.client.ClientContext;

@SuppressWarnings("serial")
/**
 * Contains all GUI necessary to execute the frame to create a new account.
 */
public class NewAccount extends JFrame {

    ClientContext context;

    /**
     * Constructor - Contains all GUI necessary to execute the frame to create a new account.
     * 
     * @param mainFrame Passes in reference to the initial frame landed on upon application launch.
     * @param context   Passes in reference to instance of ClientContext class.
     */
    public NewAccount (JFrame mainFrame, ClientContext context) {
        JFrame newAccountFrame = new JFrame();
        this.context = context;

        // Creates mainPanel.
        JPanel mainPanel = new JPanel();
        BoxLayout mainPanelLayout = new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS);
        mainPanel.setLayout(mainPanelLayout);

        // Fills welcomeTextPanel.
        JPanel welcomeTextPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to ChatU!");
        welcomeTextPanel.add(welcomeLabel);
        mainPanel.add(welcomeTextPanel);

        // Assembles username label and textfield.
        JPanel usernamePanel = new JPanel();
        JLabel usernameLabel = new JLabel("Choose a user name up to 10 characters");
        usernamePanel.add(usernameLabel);
        JTextField userNameTextField = new JTextField(10);
        usernamePanel.add(userNameTextField);
        mainPanel.add(usernamePanel);

        // Assembles password label and textfield.
        JPanel userPasswordPanel = new JPanel();
        JLabel userPasswordLabel = new JLabel("Choose a password up to 10 characters");
        userPasswordPanel.add(userPasswordLabel);
        JPasswordField userpasswordTextField = new JPasswordField(10);
        userPasswordPanel.add(userpasswordTextField);

        JPanel buttonsPanel = new JPanel();
        JButton createAccountButton = new JButton("Create");

        // Prompts user for username, if valid, will create new user on server.
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String userName = new String(userNameTextField.getText());
                if (context.user.lookupByName(userName) != null) {
                    JOptionPane.showMessageDialog(newAccountFrame, "User already exists.");
                } else {
                    if(userName.length() > 10) {
                        JOptionPane.showMessageDialog(newAccountFrame,
                                "User name is larger than 10 characters.");
                    } else {
                        context.user.addUser(userName);
                        // Starts chat.
                        if(!context.user.showUserInfo(userName).equals("Null user")) {
                            context.user.signInUser(userName);
                            OriginalChatSimpleGui convoFrame = new OriginalChatSimpleGui(context.accessController, context.accessView, userName, mainFrame);
                            convoFrame.run();
                            newAccountFrame.dispose();
                        } else {
                            // TODO
                        }
                    }
                }
            }
        });
        buttonsPanel.add(createAccountButton);

        // Allows user to cancel user creation and redirects to mainFrame(landing frame).
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                mainFrame.setVisible(true);
                newAccountFrame.dispose();
            }
        });
        buttonsPanel.add(cancelButton);
        mainPanel.add(buttonsPanel);
        newAccountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newAccountFrame.setTitle("Create an Account");
        newAccountFrame.setSize(500, 200);
        newAccountFrame.add(mainPanel);
        newAccountFrame.setVisible(true);
        buttonsPanel.getRootPane().setDefaultButton(createAccountButton);
    } // end of NewAccount()

}

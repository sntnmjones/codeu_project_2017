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

<<<<<<< HEAD
import codeu.chat.client.simplegui.originalgui.OriginalChatSimpleGui;
=======
import codeu.chat.UserMap;
>>>>>>> origin/master
import codeu.chat.client.ClientContext;

@SuppressWarnings("serial")
/**
 * Contains all GUI necessary to execute the frame to create a new account.
 */
public class NewAccount extends JFrame {
    ///////////////////////
    // PRIVATE VARIABLES //
    ///////////////////////
    private ClientContext clientContext;
    private HashMap<String, char[]> usernameAndPassword = UserMap.getMap();

<<<<<<< HEAD
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
=======
    ////////////////////
    // PUBLIC METHODS //
    ////////////////////
    /**
     * Creates a new JFrame, populates it with a JPanel that includes: a textarea where the user 
     *         will enter username, a button to submit, and a button to cancel.
     * 
     * @param clientContext The View and Controller portion of the MVC architecture.
     */
    public NewAccount (JFrame mainFrame, ClientContext clientContext) {
        this.clientContext = clientContext;
        JFrame newAccountFrame = new JFrame();
        // create mainPanel
>>>>>>> origin/master
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

<<<<<<< HEAD
        // Assembles password label and textfield.
        JPanel userPasswordPanel = new JPanel();
        JLabel userPasswordLabel = new JLabel("Choose a password up to 10 characters");
        userPasswordPanel.add(userPasswordLabel);
        JPasswordField userpasswordTextField = new JPasswordField(10);
        userPasswordPanel.add(userpasswordTextField);
=======
        // TODO: 
        // password label and textfield
        // JPanel userPasswordPanel = new JPanel();
        // JLabel userPasswordLabel = new JLabel("Choose a password up to 10 characters");
        // userPasswordPanel.add(userPasswordLabel);
        // JPasswordField userpasswordTextField = new JPasswordField(10);
        // userPasswordPanel.add(userpasswordTextField);
        // TODO: enable password authentication
        //mainPanel.add(userPasswordPanel); // commented out until needed
>>>>>>> origin/master

        JPanel buttonsPanel = new JPanel();
        JButton createAccountButton = new JButton("Create");
<<<<<<< HEAD

        // Prompts user for username, if valid, will create new user on server.
=======
        // Checks to see if username entered exists, if it does not and is less than 10 characters
        //         long, it will put it in hashMap and server.
>>>>>>> origin/master
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                context.user.updateUsers();
                String userName = new String(userNameTextField.getText());
<<<<<<< HEAD
                if (context.user.lookupByName(userName) != null) {
=======

                if(usernameAndPassword.containsKey(userName)) {
>>>>>>> origin/master
                    JOptionPane.showMessageDialog(newAccountFrame, "User already exists.");
                } else {
                    if(userName.length() > 10) {
                        JOptionPane.showMessageDialog(newAccountFrame,
                                "User name is larger than 10 characters.");
                    } else {
<<<<<<< HEAD
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
=======
                        char[] tempPassword = {'a'};
                        clientContext.user.addUser(userName);
                        usernameAndPassword.put(userName, tempPassword);
                        // start chat
                        JOptionPane.showMessageDialog(newAccountFrame, "Please sign in.");
                        newAccountFrame.dispose();
                        mainFrame.setVisible(true);
>>>>>>> origin/master
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
    }

<<<<<<< HEAD
}
=======
}   
>>>>>>> origin/master

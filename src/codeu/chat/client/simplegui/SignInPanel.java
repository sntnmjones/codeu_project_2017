package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.UserMap;
import codeu.chat.client.ClientContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

@SuppressWarnings("serial")
/**
 * This panel contains from top to bottom: a user message, Username field, Password field, 
 *         and button.
 */
public final class SignInPanel extends JPanel {

    /////////////////////
    // PRIVATE METHODS //
    /////////////////////
    private JFrame frame = ChatSimpleGui.getMainFrame();
    private ClientContext clientContext;

    ////////////////////
    // PUBLIC METHODS //
    ////////////////////
    /**
     * Constructor that sets up and displays the panel to sign in to start conversating.
     * 
     * @param clientContext The View and Controller portion of the MVC architecture.
     */
    public SignInPanel(ClientContext clientContext) {
        super(new GridBagLayout());
        this.clientContext = clientContext;
        initialize();
    }

    /////////////////////
    // PRIVATE METHODS //
    /////////////////////
    /**
     * Creates a JPanel that enables the user to enter in a username and if valid, transfer the 
     *         user to the conversation frame.
     */
    private void initialize() {

        // Set layout within panel.
        JPanel innerLayout = new JPanel();
        innerLayout.setLayout(new BoxLayout(innerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Already a user?");
        JLabel userLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        // Password label currently not in use.
        // JLabel passwordLabel = new JLabel("Password");
        // JPasswordField passwordField = new JPasswordField();
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                HashMap<String, char[]> map = codeu.chat.UserMap.map;
                String userName = usernameField.getText();
                clientContext.user.signInUser(userName);
                if(map.containsKey(userName)) {
                    new Conversation(clientContext);
                    frame.setVisible(false);
                } else {
                    if(!map.containsKey(userName)) {
                        JOptionPane.showMessageDialog(frame, "User name is not found.");
                    }
                }
            }
        });
        innerLayout.add(userQuestionLabel);
        innerLayout.add(userLabel);
        innerLayout.add(usernameField);
        // TODO: enable password authentication
        //innerLayout.add(passwordLabel);
        //innerLayout.add(passwordField);
        innerLayout.add(signInButton);

        this.add(innerLayout);
        frame.getRootPane().setDefaultButton(signInButton);

    }
}


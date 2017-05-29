package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.UserMap;
<<<<<<< HEAD
import codeu.chat.client.ClientContext;
=======
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

@SuppressWarnings("serial")
/**
 * @author  Suveena
 * @date    5/18/17
 * @brief   This panel contains from top to bottom: 
 *          a user message, Username field, Password field, and button.
 */
public final class SignInPanel extends JPanel {

    public static JFrame frame = codeu.chat.client.simplegui.ChatSimpleGui.mainFrame;
<<<<<<< HEAD
    ClientContext context;

    public SignInPanel(ClientContext clientContext) {
        super(new GridBagLayout());
        this.context = clientContext;
=======

    public SignInPanel() {
        super(new GridBagLayout());
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
        initialize();
    }

    public static void setFrame(JFrame satelliteFrame) {
        frame = satelliteFrame;
    }

    private void initialize() {

        // Set layout within panel.
        JPanel innerLayout = new JPanel();
        innerLayout.setLayout(new BoxLayout(innerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Already a user?");
        JLabel userLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        // Password label currently not in use.
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
<<<<<<< HEAD
                //HashMap<String, char[]> map = codeu.chat.UserMap.map;
                String userName = usernameField.getText();
                if(!(context.user.showUserInfo(userName).equals("Null user"))){
                    new Conversation();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(frame, "User name is not found.");
=======
                HashMap<String, char[]> map = codeu.chat.UserMap.map;
                String userName = usernameField.getText();
                if(map.containsKey(userName)) {
                    new Conversation();
                    frame.setVisible(false);
                } else {
                    if(!map.containsKey(userName)) {
                        JOptionPane.showMessageDialog(frame, "User name is not found.");
                    }
>>>>>>> 84e2c5c37721c3be4d5a0071162afa655ca0ca6b
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


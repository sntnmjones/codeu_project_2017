package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.UserMap;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

@SuppressWarnings("serial")
/**
 * @author  Suveena
 * @date    5/18/17
 * @brief   This panel contains from top to bottom; 
 *          a user message, Username field, Password field, and button
 */
public final class SignInPanel extends JPanel {

    public static JFrame frame = null;

    public SignInPanel() {
        super(new GridBagLayout());
        initialize();
    }

    public static void setFrame(JFrame satelliteFrame) {
        codeu.chat.client.simplegui.SignInPanel.frame = satelliteFrame;
    }

    private void initialize() {

        // Set layout within panel
        JPanel InnerLayout = new JPanel();
        InnerLayout.setLayout(new BoxLayout(InnerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Already a user?");
        JLabel userLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                HashMap<String, char[]> map = codeu.chat.UserMap.map;

                String userName = usernameField.getText();
                char[] password = passwordField.getPassword();

                if(map.containsKey(userName) && password == map.get(userName)) {
                    // start conversation
                } else {
                    if(!map.containsKey(userName)) {
                        JOptionPane.showMessageDialog(frame, "User name is not found.");
                    } else if(password != map.get(userName)) {
                        JOptionPane.showMessageDialog(frame, "Password is not correct.");
                    }
                }
            }
        });
        InnerLayout.add(userQuestionLabel);
        InnerLayout.add(userLabel);
        InnerLayout.add(usernameField);
        InnerLayout.add(passwordLabel);
        InnerLayout.add(passwordField);
        InnerLayout.add(signInButton);

        this.add(InnerLayout);

    }
}


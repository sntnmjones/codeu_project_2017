package codeu.chat.client.simplegui.landing_frame;

/**
 * @author  Suveena
 * @date    5/18/17
 * @brief   This panel contains from top to bottom; 
 *          a user message, Username field, Password field, and button
 */

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public final class SignInPanel extends JPanel {

    public SignInPanel() {
        super(new GridBagLayout());
        initialize();
    }

    private void initialize() {

        // Set layout within panel
        JPanel InnerLayout = new JPanel();
        InnerLayout.setLayout(new BoxLayout(InnerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Already a user?");
        JLabel userLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password");
        JTextField passwordField = new JTextField();
        JButton signInButton = new JButton("Sign In");

        InnerLayout.add(userQuestionLabel);
        InnerLayout.add(userLabel);
        InnerLayout.add(usernameField);
        InnerLayout.add(passwordLabel);
        InnerLayout.add(passwordField);
        InnerLayout.add(signInButton);

        this.add(InnerLayout);

    }
}


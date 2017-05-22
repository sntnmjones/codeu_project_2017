package codeu.chat.client.simplegui;

import javax.swing.*;
import java.awt.*;

/**
 * @author  Suveena
 * @date    5/18/17
 * @brief   This class contains a button for the user to create an account.
 *          This panel contains from top to bottom; a message, a button.
 */

@SuppressWarnings("serial")
public class CreateAccountPanel extends JPanel{

    public CreateAccountPanel() {
        super(new GridBagLayout());
        initialize();
    }

    private void initialize() {


        // Set layout within panel
        JPanel InnerLayout = new JPanel();
        InnerLayout.setLayout(new BoxLayout(InnerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Create an Account");
        JButton createAccountButton = new JButton("Get Started!");

        InnerLayout.add(userQuestionLabel);
        InnerLayout.add(createAccountButton);

        this.add(InnerLayout);

    }
}

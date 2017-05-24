package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.client.simplegui.NewAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author  Suveena
 * @date    5/18/17
 * @brief   This class contains a button for the user to create an account.
 *          This panel contains from top to bottom; a message, a button.
 */
@SuppressWarnings("serial")
public class CreateAccountPanel extends JPanel {
    JFrame frame = null;
    public CreateAccountPanel() {
        super(new GridBagLayout());
        initialize();
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private void initialize() {

        // Set layout within panel
        JPanel innerLayout = new JPanel();
        innerLayout.setLayout(new BoxLayout(innerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Create an Account");
        JButton createAccountButton = new JButton("Get Started!");

        // this action is for when the user clicks "create account",
        //  it makes the Create Account frame visible
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                NewAccount newAccount = new NewAccount();
                newAccount.setVisible(true);
                frame.dispose();
            }
        });

        innerLayout.add(userQuestionLabel);
        innerLayout.add(createAccountButton);

        this.add(innerLayout);

    }
}

package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.client.ClientContext;
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
    JFrame frame = codeu.chat.client.simplegui.ChatSimpleGui.mainFrame;
    ClientContext context;

    public CreateAccountPanel(ClientContext context) {
        super(new GridBagLayout());
        initialize();
        this.context = context;
    }

    public void setFrame(JFrame satelliteFrame) {
        this.frame = satelliteFrame;
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
                new NewAccount(frame, context);
                frame.setVisible(false);
            }
        });

        innerLayout.add(userQuestionLabel);
        innerLayout.add(createAccountButton);

        this.add(innerLayout);

    }
}
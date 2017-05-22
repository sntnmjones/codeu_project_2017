package codeu.chat.client.simplegui.landing_frame;

import javax.swing.*;

import codeu.chat.client.simplegui.newaccountframe.NewAccount;

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

    CreateAccountPanel() {
        super(new GridBagLayout());
        initialize();
    }

    private void initialize() {


        // Set layout within panel
        JPanel InnerLayout = new JPanel();
        InnerLayout.setLayout(new BoxLayout(InnerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Create an Account");
        JButton createAccountButton = new JButton("Get Started!");
        // createAccountButton.addActionListener(new ActionListener(){
        //     public void actionPerformed(ActionEvent ae){

        //     }
        // });
        InnerLayout.add(userQuestionLabel);
        InnerLayout.add(createAccountButton);

        this.add(InnerLayout);

    }
}

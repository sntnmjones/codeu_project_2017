package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.client.ClientContext;
import codeu.chat.client.simplegui.ChatSimpleGui;
import codeu.chat.client.simplegui.NewAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
/**
 * This class contains a button for the user to create an account. This panel contains from top to
 *         bottom; a message, a button.
 */
public class CreateAccountPanel extends JPanel {
    ///////////////////////
    // PRIVATE VARIABLES //
    ///////////////////////
    private JFrame frame = ChatSimpleGui.getMainFrame();
    private ClientContext clientContext;

    ////////////////////
    // PUBLIC METHODS //
    ////////////////////
    /**
     * Constructor that sets up and publishes the JPanel to create a new user.
     * 
     * @param clientContext The View and Controller portion of the MVC architecture.
     */
    public CreateAccountPanel(ClientContext clientContext) {
        super(new GridBagLayout());
        this.clientContext = clientContext;
        initialize();
    }

    /////////////////////
    // PRIVATE METHODS //
    /////////////////////
    /**
     * Sets up JPanel that goes inside the landing frame. Creates a button for the user to press
     *         to create a new user name.
     */
    private void initialize() {

        // Set layout within panel
        JPanel innerLayout = new JPanel();
        innerLayout.setLayout(new BoxLayout(innerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Create an Account");
        JButton createAccountButton = new JButton("Get Started!");

        // this action is for when the user clicks "create account", it makes the Create Account
        //         frame visible
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new NewAccount(frame, clientContext);
                frame.setVisible(false);
            }
        });

        innerLayout.add(userQuestionLabel);
        innerLayout.add(createAccountButton);

        this.add(innerLayout);

    }

}

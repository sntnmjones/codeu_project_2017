package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.client.ClientContext;
<<<<<<< HEAD
=======
import codeu.chat.client.simplegui.ChatSimpleGui;
>>>>>>> origin/master
import codeu.chat.client.simplegui.NewAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
/**
<<<<<<< HEAD
 * This class contains a button for the user to create an account. This panel contains from top
 *         to bottom; a message, a button.
 */
public class CreateAccountPanel extends JPanel {
    JFrame frame;
    ClientContext context;

    /**
     * Constructor - Passes in instance to ClientContext which enables MVC methods and an instance
     *         to the JFrame mainFrame which is the frame you first land on.
     * 
     * @param context   Passes in instance to ClientContext.
     * @param mainFrame Passes in instance to the initial frame of application(landing frame).
     */
    public CreateAccountPanel(ClientContext context, JFrame mainFrame) {
=======
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
>>>>>>> origin/master
        super(new GridBagLayout());
        this.clientContext = clientContext;
        initialize();
        this.context = context;
        frame = mainFrame;
    }

<<<<<<< HEAD
    /**
     * Allows remote access to change member variable 'frame'.
     * 
     * @param satelliteFrame    JFrame being passed in to overwrite JFrame frame.
     */
    public void setFrame(JFrame satelliteFrame) {
        this.frame = satelliteFrame;
    }

    /**
     * Creates and displays the panel that is used for creating a new user. 
     *         Includes button to create a new user, which redirects user to a new frame.
=======
    /////////////////////
    // PRIVATE METHODS //
    /////////////////////
    /**
     * Sets up JPanel that goes inside the landing frame. Creates a button for the user to press
     *         to create a new user name.
>>>>>>> origin/master
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
<<<<<<< HEAD
                new NewAccount(frame, context);
=======
                new NewAccount(frame, clientContext);
>>>>>>> origin/master
                frame.setVisible(false);
            }
        });

        innerLayout.add(userQuestionLabel);
        innerLayout.add(createAccountButton);

        this.add(innerLayout);

    }
<<<<<<< HEAD
}
=======

}
>>>>>>> origin/master

package codeu.chat.client.simplegui;

import javax.swing.*;

import codeu.chat.client.simplegui.originalgui.OriginalChatSimpleGui;
import codeu.chat.client.ClientContext;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;

@SuppressWarnings("serial")
/**
 * This class creates a panel that contains from top to bottom: a user message, Username field,
 *         Password field, and button.
 */
public final class SignInPanel extends JPanel {

    public JFrame frame;
    ClientContext context;

    /**
     * Constructor - Creates and displays panel that contains a textfield for user to enter
     *         username and button to submit.
     * 
     * @param clientContext Reference to ClientContext class.
     * @param mainFrame     Reference to mainFrame, which is the landing frame upon app launch.
     */
    public SignInPanel(ClientContext clientContext, JFrame mainFrame) {
        super(new GridBagLayout());
        this.context = clientContext;
        frame = mainFrame;
        initialize();
    }

    /**
     * Creates and displays panel that contains a textfield for user to enter
     *         username and button to submit.
     */
    private void initialize() {

        // Set layout within panel.
        JPanel innerLayout = new JPanel();
        innerLayout.setLayout(new BoxLayout(innerLayout, BoxLayout.Y_AXIS));

        JLabel userQuestionLabel = new JLabel("Already a user?");
        JLabel userLabel = new JLabel("Username");
        JTextField usernameField = new JTextField();
        JButton signInButton = new JButton("Sign In");

        // Sign in button allows user, if valid, to sign in and transfers user to
        //         OriginalConversationPanel.
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String userName = usernameField.getText();
                context.user.updateUsers();
                if(context.user.lookup(context.user.lookupByName(userName)) != null) {

                    context.user.signInUser(userName);
                    OriginalChatSimpleGui convoFrame = new OriginalChatSimpleGui(context.accessController, context.accessView, userName, frame);
                    convoFrame.run();
                    frame.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(frame, "User name is not found.");
                
                }
            }
        });
        innerLayout.add(userQuestionLabel);
        innerLayout.add(userLabel);
        innerLayout.add(usernameField);
        innerLayout.add(signInButton);

        this.add(innerLayout);
        frame.getRootPane().setDefaultButton(signInButton);

    }
}

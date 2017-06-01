package codeu.chat.client.simplegui;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import codeu.chat.client.ClientContext;
import codeu.chat.client.simplegui.ChatSimpleGui;

@SuppressWarnings("serial")
/**
 * Contains all GUI necessary to execute the frame to enable chat.
 */
public class Conversation extends JFrame {

    ///////////////////////
    // PRIVATE VARIABLES //
    ///////////////////////
    private ClientContext clientContext;
    // Used to see if user has clicked inside the editable textarea.
    //         If true, the default text will clear. If false, the text inside stays.
    private boolean isFirstClick = true;
    private JFrame landingFrame = ChatSimpleGui.getMainFrame();

    ////////////////////
    // PUBLIC METHODS //
    ////////////////////
    /**
     * Constructor that creates a new JFrame, and populates it with TextAreas for active 
     *         conversations, current conversation and an area to enter text to submit to the 
     *         server.
     * 
     * @param clientContext The View and Controller portion of the MVC architecture.
     */
    public Conversation(ClientContext clientContext) {

        this.clientContext = clientContext;
        JFrame frame = new JFrame();

        // Main container that components will go inside. Will then be appended to frame.
        Container mainPanel = frame.getContentPane();
        mainPanel.setLayout(new FlowLayout(0));
        
        // Choose a conversation label.
        JLabel welcomeLabel = new JLabel("Please choose a conversation");
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        // Conversation list text area (post active conversations list here).
        JPanel conversationListSubPanel = new JPanel();
        JTextArea conversationListArea = new JTextArea(5, 400);
        conversationListArea.setLineWrap(true);
        conversationListArea.setWrapStyleWord(true);
        conversationListArea.setEditable(false);
        conversationListSubPanel.add(conversationListArea);
        mainPanel.add(conversationListSubPanel, BorderLayout.CENTER);

        // Current conversation area label.
        JLabel currentConvoLabel = new JLabel("Active conversation with: ");
        mainPanel.add(currentConvoLabel);

        // Current conversation text area (post current conversation here).
        JPanel currentConvoSubPanel = new JPanel();
        JTextArea currentConversationArea = new JTextArea(5, 400);
        currentConversationArea.setLineWrap(true);
        currentConversationArea.setWrapStyleWord(true);
        currentConversationArea.setEditable(false);
        currentConvoSubPanel.add(currentConversationArea);
        mainPanel.add(currentConvoSubPanel);

        // Pseudo padding.
        JLabel paddingLabel = new JLabel(" ");
        mainPanel.add(paddingLabel);

        // Text area for user input.
        JPanel userInputSubPanel = new JPanel();
        JTextArea userInputTextArea = new JTextArea("Your message here!", 5, 400);
        userInputTextArea.setLineWrap(true);
        userInputTextArea.setWrapStyleWord(true);
        // On mouse click, text prompting user to type will disappear.
        userInputTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (isFirstClick) {
                    userInputTextArea.setText("");
                    isFirstClick = false;
                }
            }
        });
        userInputSubPanel.add(userInputTextArea);
        mainPanel.add(userInputSubPanel);

        // Psuedo padding.
        mainPanel.add(paddingLabel);

        // Fill buttonsPanel.
        JPanel buttonsPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        buttonsPanel.add(submitButton);

        // Logout button: logs out of conversation, returns user back to landing frame.
        JButton logoutButton = new JButton("Logout");
        buttonsPanel.add(logoutButton);
        // Upon clicking logout button, user will be directed back to landing frame.
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                landingFrame.setVisible(true);
                frame.dispose();
            }
        });
        mainPanel.add(buttonsPanel);
        buttonsPanel.getRootPane().setDefaultButton(submitButton);

        // publish frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ChatU Conversation Area");
        frame.setSize(500, 500);
        frame.getContentPane();
        frame.setVisible(true);
    }

}
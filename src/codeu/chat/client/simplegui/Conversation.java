package codeu.chat.client.simplegui.conversationframe;

/**
 * @author  Troy Jones
 * @date    5/21/17
 * @brief   Contains all GUI necessary to execute the frame to 
 *          enable chat.
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")

public class Conversation extends JFrame {

    boolean notClickedYet = true;

    // constructor
    public Conversation() {

        JFrame frame = new JFrame();

        // fill mainPanel
        Container mainPanel = frame.getContentPane();
        mainPanel.setLayout(new FlowLayout(0));

        // choose a conversation label
        JLabel welcomeLabel = new JLabel("Please choose a conversation");
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        // conversation list text area (post active conversations list here)
        JPanel conversationListSubPanel = new JPanel();
        JTextArea conversationListArea = new JTextArea(5, 400);
        conversationListArea.setLineWrap(true);
        conversationListArea.setWrapStyleWord(true);
        conversationListArea.setEditable(false);
        conversationListSubPanel.add(conversationListArea);
        mainPanel.add(conversationListSubPanel, BorderLayout.CENTER);

        // current conversation area label
        JLabel currentConvoLabel = new JLabel("Active conversation with: ");
        mainPanel.add(currentConvoLabel);

        // current conversation text area (post current conversation here)
        JPanel currentConvoSubPanel = new JPanel();
        JTextArea currentConversationArea = new JTextArea(5, 400);
        currentConversationArea.setLineWrap(true);
        currentConversationArea.setWrapStyleWord(true);
        currentConversationArea.setEditable(false);
        currentConvoSubPanel.add(currentConversationArea);
        mainPanel.add(currentConvoSubPanel);

        // pseudo padding
        JLabel paddingLabel = new JLabel(" ");
        mainPanel.add(paddingLabel);

        // text area for user input
        JPanel userInputSubPanel = new JPanel();
        JTextArea userInputTextArea = new JTextArea("Your message here!", 5, 400);
        userInputTextArea.setLineWrap(true);
        userInputTextArea.setWrapStyleWord(true);
        userInputTextArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (notClickedYet) {
                    userInputTextArea.setText("");
                    notClickedYet = false;
                }
            }
        });
        userInputSubPanel.add(userInputTextArea);
        mainPanel.add(userInputSubPanel);

        // psuedo padding
        mainPanel.add(paddingLabel);

        // fill buttonsPanel
        JPanel buttonsPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        buttonsPanel.add(submitButton);
        JButton logoutButton = new JButton("Logout");
        buttonsPanel.add(logoutButton);
        mainPanel.add(buttonsPanel);

        // publish frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ChatU Conversation Area");
        frame.setSize(500, 500);
        frame.getContentPane();
        frame.setVisible(true);
    } // end of Conversation()

} // end of class Conversation

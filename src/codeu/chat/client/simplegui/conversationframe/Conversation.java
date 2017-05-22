package codeu.chat.client.simplegui.conversationframe;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Conversation extends JFrame {

    // constructor
    public Conversation() {

        // fill welcomeTextPanel
        JPanel welcomeTextPanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Please choose a conversation");
        welcomeTextPanel.add(welcomeLabel);


        // fill textareaPanel
        JPanel textareaPanel = new JPanel();

        BoxLayout textareaLayout = 
            new BoxLayout(textareaPanel, BoxLayout.Y_AXIS);
        textareaPanel.setLayout(textareaLayout);

        JTextArea conversationListArea = new JTextArea(5,10);
        conversationListArea.setLineWrap(true);
        conversationListArea.setWrapStyleWord(true);
        conversationListArea.setEditable(false);
        textareaPanel.add(conversationListArea);

        JTextArea currentConversationArea = new JTextArea(5,10);
        currentConversationArea.setLineWrap(true);
        currentConversationArea.setWrapStyleWord(true);
        currentConversationArea.setEditable(false);
        textareaPanel.add(currentConversationArea);

        JTextArea userInputTextArea = new JTextArea(5,10);  
        userInputTextArea.setLineWrap(true);
        userInputTextArea.setWrapStyleWord(true);
        textareaPanel.add(userInputTextArea);


        // fill buttonsPanel
        JPanel buttonsPanel = new JPanel();
        JButton submitButton = new JButton("Submit");
        buttonsPanel.add(submitButton);
        JButton logoutButton = new JButton("Logout");
        buttonsPanel.add(logoutButton);

        // fill mainPanel
        JPanel mainPanel = new JPanel();
        BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainLayout);

        mainPanel.add(welcomeTextPanel);
        mainPanel.add(textareaPanel);
        mainPanel.add(buttonsPanel);

        // publish frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ChatU Conversation Area");
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    } // end of NewAccount()

} // end of class NewAccount

// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package codeu.chat.client.simplegui;

import codeu.chat.UserMap;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import codeu.chat.client.ClientContext;
import codeu.chat.client.Controller;
import codeu.chat.client.View;
import codeu.chat.util.Logger;

/**
 * Chat - top-level client application - Java Simple GUI (using Java Swing)
 */
public final class ChatSimpleGui {
    ///////////////////////
    // PRIVATE VARIABLES //
    ///////////////////////
    private static JFrame mainFrame;
    private ClientContext clientContext;
    private final static Logger.Log LOG = Logger.newLog(ChatSimpleGui.class);
    private UserMap userMap = new UserMap();    // Map for username and password storage.

    ////////////////////
    // PUBLIC METHODS //
    ////////////////////
    /**
     * Constructor that instantiates clientContext.
     * 
     * @param controller    The Controller portion of the MVC architecture.
     * @param view          The View portion of the MVC architecture. 
     */
    public ChatSimpleGui(Controller controller, View view) {
        clientContext = new ClientContext(controller, view);
    }

    /**
     * Executes initialization of landing frame. 
     */
    public void run() {

        try {

            initialize();
            mainFrame.setVisible(true);

        } catch (Exception ex) {
            System.out.println("ERROR: Exception in ChatSimpleGui.run. Check log for details.");
            LOG.error(ex, "Exception in ChatSimpleGui.run");
            System.exit(1);
        }
    }

    /////////////////////
    // PRIVATE METHODS //
    /////////////////////
    /**
     * Creates JFrame and JPanels. Passes ClientContext to each panel.
     */
    private void initialize() {

        // Outermost frame.
        // NOTE: may have to tweak size, or place in scrollable panel.
        mainFrame = new JFrame("ChatU");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(790, 450);

        // Main View - outermost graphics panel.
        JPanel mainViewPanel = new JPanel(new GridBagLayout());

        // Build main panels - Sign In, Create Account.

        // Panel with just label -- Cleaner to make a new class?
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        labelPanel.setBorder(paneBorder());
        labelPanel.add(new JLabel("Welcome to ChatU!"));
        labelPanel.add(new JLabel("Please choose from an option below:"));
        GridBagConstraints labelViewC = new GridBagConstraints();

        // Creates new Jpanel for user sign in pane
        JPanel userSignIn = new SignInPanel(clientContext);
        userSignIn.setBorder(paneBorder());
        GridBagConstraints usersViewC = new GridBagConstraints();

        // ConversationsPanel gets access to MessagesPanel
        CreateAccountPanel newAccountPanel = new CreateAccountPanel(clientContext);
        newAccountPanel.setBorder(paneBorder());
        GridBagConstraints newAccountViewC = new GridBagConstraints();

        // Dummy panel for formatting
        JPanel dummyPanel = new JPanel();
        dummyPanel.setBorder(paneBorder());
        GridBagConstraints dummyViewC = new GridBagConstraints();

        // Placement of main panels.

        labelViewC.gridx = 0;
        labelViewC.gridy = 0;
        labelViewC.gridwidth = 2;
        labelViewC.gridheight = 1;
        labelViewC.fill = GridBagConstraints.BOTH;
        labelViewC.weighty = 0.7;

        usersViewC.gridx = 0;
        usersViewC.gridy = 1;
        usersViewC.gridwidth = 1;
        usersViewC.gridheight = 1;
        usersViewC.fill = GridBagConstraints.BOTH;
        usersViewC.weightx = 0.3;
        usersViewC.weighty = 0.3;

        newAccountViewC.gridx = 1;
        newAccountViewC.gridy = 1;
        newAccountViewC.gridwidth = 1;
        newAccountViewC.gridheight = 1;
        newAccountViewC.fill = GridBagConstraints.BOTH;
        newAccountViewC.weightx = 0.7;
        newAccountViewC.weighty = 0.3;

        dummyViewC.gridx = 0;
        dummyViewC.gridy = 2;
        dummyViewC.gridwidth = 2;
        dummyViewC.gridheight = 1;
        dummyViewC.fill = GridBagConstraints.BOTH;
        dummyViewC.weighty = 0.7;

        mainViewPanel.add(labelPanel, labelViewC);
        mainViewPanel.add(userSignIn, usersViewC);
        mainViewPanel.add(newAccountPanel, newAccountViewC);
        mainViewPanel.add(dummyPanel, dummyViewC);

        mainFrame.add(mainViewPanel);
        mainFrame.pack();
    }

    /**
     * Creates borders for panel separation on landing frame.
     * 
     * @return Returns a created instance of Border.
     */
    private Border paneBorder() {
        Border outside = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        Border inside = BorderFactory.createEmptyBorder(8, 8, 8, 8);
        return BorderFactory.createCompoundBorder(outside, inside);
    }

    ///////////////////////
    // PROTECTED METHODS //
    ///////////////////////
    /**
     * Closes the landing frame.
     */
    protected void closeFrame() {
        mainFrame.dispose();
    }

    /////////////////////
    // STATIC METHODS  //
    /////////////////////

    /**
     * Gives access to mainFrame.
     * 
     * @return Returns access to mainFrame.
     */
    static JFrame getMainFrame() {
        return mainFrame;
    }

}

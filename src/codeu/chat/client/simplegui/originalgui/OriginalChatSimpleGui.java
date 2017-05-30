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
package codeu.chat.client.simplegui.originalgui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import codeu.chat.client.ClientContext;
import codeu.chat.client.Controller;
import codeu.chat.client.View;
import codeu.chat.util.Logger;

/**
 * Chat - top-level client application - Java Simple GUI (using Java Swing).
 */
public final class OriginalChatSimpleGui {

  private final static Logger.Log LOG = Logger.newLog(OriginalChatSimpleGui.class);
  private JFrame mainFrame;
  private JFrame landingFrame;
  private final ClientContext clientContext;
  public String username;

  /**
   * Constructor - sets up the Chat Application.
   * 
   * @param controller  Reference to Controller class.
   * @param view        Reference to View class.
   * @param username    Reference to current user name.
   */
  public OriginalChatSimpleGui(Controller controller, View view, String username) {
    
    clientContext = new ClientContext(controller, view);
    this.username = username;

  }

  /**
   * Constructor - sets up the Chat Application.
   * 
   * @param controller    Reference to Controller class.
   * @param view          Reference to View class.
   * @param username      Reference to current user name.
   * @param landingFrame  Reference to landing frame.
   */
  public OriginalChatSimpleGui(Controller controller, View view, String username,
      JFrame landingFrame) {

    clientContext = new ClientContext(controller, view);
    this.landingFrame = landingFrame;
    this.username = username;

  }

  

  /**
   * Runs the GUI client.
   */
  public void run() {

    try {

      initialize();
      mainFrame.setVisible(true);

    } catch (Exception ex) {
      System.out.println("ERROR: Exception in OriginalChatSimpleGui.run. Check log for details.");
      LOG.error(ex, "Exception in OriginalChatSimpleGui.run");
      System.exit(1);
    }
  }

  /**
   * Creates borders for user interface.
   * 
   * @return Border - Returns Border object.
   */
  private Border paneBorder() {
    Border outside = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    Border inside = BorderFactory.createEmptyBorder(8, 8, 8, 8);
    return BorderFactory.createCompoundBorder(outside, inside);
  }

  /**
   * Initializes the GUI.
   */
  private void initialize() {

    // Outermost frame.
    // NOTE: may have tweak size, or place in scrollable panel.
    mainFrame = new JFrame("Chat");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(790, 450);

    // Main View - outermost graphics panel.
    final JPanel mainViewPanel = new JPanel(new GridBagLayout());
    mainViewPanel.setBorder(paneBorder());

    // Build main panels - Users, Conversations, Messages.
    final JPanel usersViewPanel = new OriginalUserPanel(clientContext, this.username, mainFrame,
        landingFrame);
    usersViewPanel.setBorder(paneBorder());
    final GridBagConstraints usersViewC = new GridBagConstraints();

    final OriginalMessagePanel messagesViewPanel = new OriginalMessagePanel(clientContext);
    messagesViewPanel.setBorder(paneBorder());
    final GridBagConstraints messagesViewC = new GridBagConstraints();

    // ConversationsPanel gets access to MessagesPanel
    final JPanel conversationsViewPanel = new OriginalConversationPanel
        (clientContext, messagesViewPanel);
    conversationsViewPanel.setBorder(paneBorder());
    final GridBagConstraints conversationViewC = new GridBagConstraints();

    // Placement of main panels.
    usersViewC.gridx = 0;
    usersViewC.gridy = 0;
    usersViewC.gridwidth = 1;
    usersViewC.gridheight = 1;
    usersViewC.fill = GridBagConstraints.BOTH;
    usersViewC.weightx = 0.3;
    usersViewC.weighty = 0.3;

    conversationViewC.gridx = 1;
    conversationViewC.gridy = 0;
    conversationViewC.gridwidth = 1;
    conversationViewC.gridheight = 1;
    conversationViewC.fill = GridBagConstraints.BOTH;
    conversationViewC.weightx = 0.7;
    conversationViewC.weighty = 0.3;

    messagesViewC.gridx = 0;
    messagesViewC.gridy = 1;
    messagesViewC.gridwidth = 2;
    messagesViewC.gridheight = 1;
    messagesViewC.fill = GridBagConstraints.BOTH;
    messagesViewC.weighty = 0.7;

    mainViewPanel.add(usersViewPanel, usersViewC);
    mainViewPanel.add(conversationsViewPanel, conversationViewC);
    mainViewPanel.add(messagesViewPanel, messagesViewC);

    mainFrame.add(mainViewPanel);
    mainFrame.pack();
  }
}


# CODEU CHAT SERVER | README


## DISCLAIMER

CODEU is a program created by Google to develop the skills of future software
engineers. This project is not an offical Google Product. This project is a
playground for those looking to develop their coding and software engineering
skills.

## REFACTORINGS

### ClientUser.Java new method:
- lookupByName is a method that takes in a String and checks the usersById map to see if there exists a user with the given String as their name
- It is useful in performing checks, namely, in the login and create account features
- Previously, there was just a method that looked up a user by the Uuid, however when the client only supplies a name to the GUI, that is the only information we have, and that needed to be enough to perform a lookup to check whether or not there is such a user
- The benefits of this method are to solve the above issues; however, in the implementation of this, we are only working with the client, and not asking the server for the information: to check if the username is valid or taken. - This is a good thing in that it means that it will take less time to fetch the data we need, yet there is a chance that if the method's logic was notimplemented correctly, that the client would hold the information and not update it for other clients to see.

### ChatSimpleGUI
- We modified the ChatSimpleGUI class, because we needed it to to be our new sign in and create account default frame
- Therefore, we created a file under the simplegui directory with the original GUI files, and prepended "Original" to the same class names to indicate which version was which (since we needed the original GUI files as well).
- The benefits of this was that we did not have to make too many changes to class names in the existing code, and it the given name of the classes reflected what exactly the GUI was, so there was consistency in our understanding of which classes held what GUI components
- The downside here was that there was confusion when it came time to rename the methods and data members called within these classes - because the new and old GUI class names were originally the same, it was fairly hard to spot which version, "Original" or New, of whatever class we referenced we were actually pointing to, without reading methods in detail
### NewAccount Class
- One completely new class we created was the NewAccount class, which separates the CreateAccountPanel from the actual text fields and JButtons that we had in the CreateAccountPanel class.
- This was separated into a new class to keep the code clean and readable, since the initialize method was quite lengthy and becoming difficult for us to read
- The benefits of doing so were that we ended up with neater, less buggy code; however, the downside was that we had to again pass in the Controller AND the JFrame holding the CreateAccountPanel so that we would be able to close the frame once a new user was created. Passing an entire GUI frame could cause lags, and in general, just gives more classes access to the frame, which is not ideal


## BUG FIXES

### Once you create an account, you must sign in separately
- We intended for the user to be automatically signed in once they created their account, yet they still had to log in separately
- This was happening because we did not implement the same functionality from the sign in button's action listener to the create account's
- We edited the action listener to create the account, close out of the startup GUI frame, and open up the conversation view GUI

###Two users with the same name could be created
- We intended to have each username represent a unique user
- However, we had an issue where we were not checking the user's name to see if it already existed in the map of created users
- We created a new method that searched for existing users by name and performed a check on the map to check if a user with the name was already in the map, and if so, an error message would pop up

###Logout functionality
- When users logged out, they were not being removed from the list of users on the client GUI
- The logout function was only updating the specific user's list, it was not conveying this to any other ClientUser
- A solution would be to send a message to the server saying that a User had left the chat room, however, we decided to change the panel's description to include all created users.
- This was done in the interest of directing our time to adding more features and debugging more

###Message panel changes colors to customize
- When button was deselected, it stays the same color
- Every time the radio button was clicked, it was to turn a certain color, but no checks were being made to see if it was actually selected or not
- Added a conditional statement in the actionlistener, which, every other time the radio button was selected, set it to light gray

## CHECKED REQUIREMENTS
- The project must compile.
- It must be possible to run and connect a client to a server. Include instructions on how to run your client and server.
- It must be possible for multiple clients to talk to the same server and exchange messages.
- For features: the user must be able to activate/trigger the feature from the UI, or its effects must be evident to the user if it is enabled by default, supporting documentation on how to use the feature must be provided.
- For refactorings: provide supporting documentation explaining what was done, why it was done, and the pros/cons of the new code.
For bug fixes: provide a bug description (symptom), a summary of what caused the bug (diagnosis), and how you fixed it (cure).

## SETUP INSTRUCTIONS

  1. To build the project:
       ```
       $ sh clean.sh
       $ sh make.sh
       ```

  2. To test the project:
       ```
       $ sh test.sh
       ```

  3. To run the project you will need to run both the client and the server. Run
     the following two commands in separate shells:

      *Running Server (first) and Client (second) Instructions:*

      ```
       $ sh run_server.sh 100 ABABAB 2007 ./
       $ sh run_simple_gui_client.sh
       ```

      *Alternatively, as provided*

       ```
       $ sh run_server.sh <team_id> <team_secret> <port> <persistent-dir>
       $ sh run_client.sh <host> <port>
       ```

     You must specify the following startup arguments for `run_server.sh:
     + `<team_id>` and `<team_secret>`: a numeric id for your team, and a secret
       code, which are used to authenticate your server with the Relay server.
       You can specify any integer value for `<team_id>`, and a value expressed
       in hexadecimal format (using numbers `0-9` and letters in the range
       `A-F`) for `<team_secret>` when you launch the server in your local setup
       since it will not connect to the Relay server.
     + `<port>`: the TCP port that your Server will listen on for connections
       from the Client. You can use any value between 1024 and 65535, as long as
       there is no other service currently listening on that port in your
       system. The server will return an error:

         ```
         java.net.BindException: Address already in use (Bind failed)
         ```

       if the port is already in use.
     + `<persistent-dir>`: the path where you want the server to save data between
       runs.

     The startup arguments for `run_client.sh` are the following:
     + `<host>`: the hostname or IP address of the computer on which the server
       is listening. If you are running server and client on the same computer,
       you can use `localhost` here.
     + `<port>`: the port on which your server is listening. Must be the same
       port number you have specified when you launched `run_server.sh`.


All running images write informational and exceptional events to log files.
The default setting for log messages is "INFO". You may change this to get
more or fewer messages, and you are encouraged to add more LOG statements
to the code. The logging is implemented in `codeu.chat.util.Logger.java`,
which is built on top of `java.util.logging.Logger`, which you can refer to
for more information.


## Source Directories -- Provided Information

The major project components have been separated into their own packages. The
main packages/directories under `src/codeu/chat` are:

### codeu.chat.client

Classes for building the two clients (`codeu.chat.ClientMain` and
`codeu.chat.SimpleGuiClientMain`).

### codeu.chat.server

Classes for building the server (`codeu.chat.ServerMain`).

### codeu.chat.relay

Classes for building the Relay Server (`codeu.chat.RelayMain`). The Relay Server
is not needed to get started.

### codeu.chat.common

Classes that are shared by the clients and servers.

### codeu.chat.util

Some basic infrastructure classes used throughout the project.


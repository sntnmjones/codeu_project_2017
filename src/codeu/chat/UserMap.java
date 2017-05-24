package codeu.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Suveena on 5/24/17.
 */

/* Basic structure that holds all the users. Create this map upon starting GUI.
Each time we add a new user, check to make sure that they don't already exist.
If they do not, add them to the map.*/

public class UserMap {

    HashMap<String, String> map;

    public UserMap() {
        this.map = new HashMap<String, String>();
    }

   /*ArrayList<User> userList;

    public UserMap() {
        this.userList = new ArrayList<User>();
    }

    // Checks if user exists given a username (String)
    public User checkUser(String name) {
        Iterator<User> itr = this.userList.iterator();
        while (itr.hasNext()) {
            User nextUser = itr.next();
            if(nextUser.username.equals(name)) {
                return nextUser;
            }
        }
        return null;
    }

    // Not yet tested -- should return true if user/pass match
    public boolean checkPassword(String name, String pass) {
        User targetUser = checkUser(name);
        if (targetUser != null) {
            if (targetUser.password == pass) {
                return true;
            }
        }
        return false;
    }*/
}

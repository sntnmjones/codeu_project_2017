package codeu.chat;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Suveena on 5/24/17.
 */

/* Basic structure that holds all the users. Create this map upon starting GUI.
Each time we add a new user, check to make sure that they don't already exist.
If they do not, add them to the map.*/

public class UserMap {

    ArrayList<User> userList;

    public UserMap() {
        this.userList = new ArrayList<User>();
    }

    // Checks if user exists given a username (String)
    public boolean checkUser(String name) {
        Iterator<User> itr = this.userList.iterator();
        while (itr.hasNext()) {
           // if (itr.)
        }
    }
}

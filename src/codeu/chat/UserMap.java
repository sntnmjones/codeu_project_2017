package codeu.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import codeu.chat.client.simplegui.NewAccount;

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

    public HashMap<String, String> getMap() {
        return this.map;
    }

}
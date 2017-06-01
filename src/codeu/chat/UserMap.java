package codeu.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import codeu.chat.client.simplegui.NewAccount;

/**
 * Basic structure that holds all the users. Creates this map upon starting GUI. Each time we add
 *         a new user, check to make sure that they don't already exist. If they do not, add them
 *         to the map.
 */
public class UserMap {
    ///////////////////////
    // PRIVATE VARIABLES //
    ///////////////////////
    private static HashMap<String, char[]> map = new HashMap<String, char[]>();

    ////////////////////
    // PUBLIC METHODS //
    ////////////////////
    public UserMap() {
        String admin = "admin";
        char[] password = {'a','d','m','i','n'};
        map.put(admin, password);
    }

    ////////////////////
    // STATIC METHODS //
    ////////////////////
    public static HashMap<String, char[]> getMap() {
        return map;
    }

}
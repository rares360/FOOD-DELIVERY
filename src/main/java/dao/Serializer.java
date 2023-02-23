package dao;

import business.Order;
import model.User;
import model.products.MenuItem;

import java.io.*;
import java.util.*;

public class Serializer {
    private final String FILENAMEUSER = "src\\user-serialization.txt";
    private final String FILENAMEORDER = "src\\order-serialization.txt";
    private final String FILENAMEMENU = "src\\menu-serialization.txt";

    public void serializeUser(Set<User> userSet) {
        try {
            FileOutputStream file = new FileOutputStream(FILENAMEUSER);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(userSet);
            out.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Set<User> deserializeUser() {
        Set<User> userSet = new HashSet<User>();
        try {
            FileInputStream file = new FileInputStream(FILENAMEUSER);
            if (file.available() > 0) {
                ObjectInputStream in = new ObjectInputStream(file);
                userSet = (Set<User>) in.readObject();
                in.close();
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userSet;
    }
    public void serializeOrder(Map<Order, Set<MenuItem>> map) {
        try {
            FileOutputStream file = new FileOutputStream(FILENAMEORDER);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(map);
            out.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<Order, Set<MenuItem>> deserializeOrder() {
        Map<Order, Set<MenuItem>> map = new HashMap<>();
        try {
            FileInputStream file = new FileInputStream(FILENAMEORDER);
            if (file.available() > 0) {
                ObjectInputStream in = new ObjectInputStream(file);
                map = (HashMap) in.readObject();
                in.close();
                file.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }
    public void serializeMenu(Set<MenuItem> items) {
        try {
            FileOutputStream file = new FileOutputStream(FILENAMEMENU);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(items);
            out.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Set<MenuItem> deserializeMenu() {
        Set<MenuItem> menuItemSet = new HashSet<MenuItem>();
        try {
            FileInputStream file = new FileInputStream(FILENAMEMENU);
            if (file.available() > 0) {
                ObjectInputStream in = new ObjectInputStream(file);
                menuItemSet = (Set<MenuItem>) in.readObject();
                in.close();
                file.close();
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return menuItemSet;
    }
}

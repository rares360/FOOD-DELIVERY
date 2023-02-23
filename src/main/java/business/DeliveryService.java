package business;

import dao.FileWrite;
import dao.Serializer;
import model.User;
import model.products.BaseProduct;
import model.products.CompositeProduct;
import model.products.MenuItem;
import presentation.AdminView;
import presentation.ClientView;
import presentation.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService {

    private Set<MenuItem> menuItemSet;
    private Set<MenuItem> filterSet = new HashSet<>();
    private Set<User> userSet;
    private Set<MenuItem> cart = new HashSet<>();
    private Map<Order, Set<MenuItem>> orderMap = new HashMap<>();
    private Controller controller;
    private AdminView adminView;
    private ClientView clientView;

    public DeliveryService() {
        this.orderMap = new Serializer().deserializeOrder();
        this.menuItemSet = new Serializer().deserializeMenu();
        this.userSet = new Serializer().deserializeUser();
    }

    public void readUsers() throws IOException {
        BufferedReader reader = null;
        String File = ("src\\members.csv");
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(File));
            String headerLine = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tkn = line.split(",");
                userSet.add(new User(Integer.parseInt(tkn[0]), tkn[1], tkn[2], Integer.parseInt(tkn[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
    }

    public void writeUsers(String username, String password, int type) throws IOException {
        readUsers();
        boolean checkUsername = true;
        for (User currentUser : userSet) {
            if (currentUser.getUsername().equals(username)) {
                checkUsername = false;
            }
        }
        if (checkUsername == false) {
            JOptionPane.showMessageDialog(null, "Username is taken!");
        } else {
            int id = userSet.size() + 1;
            String File = ("src\\members.csv");
            FileWriter fw = new FileWriter(File, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(id + "," + username + "," + password + "," + type);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, "User created!");
        }
    }

    public boolean find(String username, String password) {
        if (null == userSet) {
            throw new IllegalStateException("user list is empty");
        }
        return userSet.stream()
                .filter(u -> u.getUsername().equals(username))
                .filter(u -> u.getPassword().equals(password))
                .findFirst()
                .isPresent();
    }


    public Set<MenuItem> createMenuSet() {
       // menuItemSet=null;
        if (menuItemSet == null) {
            FileWrite fileWriter = new FileWrite();
            menuItemSet = fileWriter.importMenu("products.csv");
            new Serializer().serializeMenu(menuItemSet);
        }
        return menuItemSet;
    }

    public String[][] getProductData() {
        menuItemSet = new Serializer().deserializeMenu();
        String[][] result = new String[menuItemSet.size()][7];
        int idx = 0;
        for (MenuItem currentItem : menuItemSet) {
            result[idx][0] = currentItem.getTitle();
            result[idx][1] = Double.toString(currentItem.getRating());
            result[idx][2] = Double.toString(currentItem.getCalories());
            result[idx][3] = Double.toString(currentItem.getProtein());
            result[idx][4] = Double.toString(currentItem.getFat());
            result[idx][5] = Double.toString(currentItem.getSodium());
            result[idx][6] = Double.toString(currentItem.getPrice());
            idx++;
        }
        return result;
    }

    public void addNewBaseItem(String title, double rating, double calories, double protein, double fat, double sodium, double price) throws IOException {
        MenuItem menuItem = new MenuItem(title, rating, calories, protein, fat, sodium, price);
        boolean checkTitle = true;
        for (MenuItem currentItem : menuItemSet) {
            if (currentItem.getTitle().equals(title)) {
                checkTitle = false;
                break;
            }
        }
        if (checkTitle == false) {
            JOptionPane.showMessageDialog(null, "Title is taken!");
        } else {
            /*String File = ("src\\products.csv");
            FileWriter fw = new FileWriter(File, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(title + "," + rating + "," + calories + "," + protein + "," + fat + "," + sodium + "," + price);
            pw.flush();
            pw.close();*/
            JOptionPane.showMessageDialog(null, "Food added!");
            menuItemSet.add(menuItem);
            new Serializer().serializeMenu(menuItemSet);
        }
    }

    public void deleteItem(String title) {
        for (MenuItem currentItem : menuItemSet) {
            if (currentItem.getTitle().equals(title)) {
                menuItemSet.remove(currentItem);
                break;
            }
        }
        new Serializer().serializeMenu(menuItemSet);
    }

    public void editItem(String title, double rating, double calories, double protein, double fat, double sodium, double price) {
        for (MenuItem currentItem : menuItemSet) {
            if (currentItem.getTitle().equals(title)) {
                currentItem.setRating(rating);
                currentItem.setCalories(calories);
                currentItem.setProtein(protein);
                currentItem.setFat(fat);
                currentItem.setSodium(sodium);
                currentItem.setPrice(price);
                break;
            }
        }
        for (MenuItem currentItem : menuItemSet) {
            System.out.println("\n" + currentItem);
        }
        new Serializer().serializeMenu(menuItemSet);
    }

    public void addToCart(String title) {
        for (MenuItem currentItem : menuItemSet) {
            if (currentItem.getTitle().equals(title)) {
                cart.add(currentItem);
                break;
            }
        }
    }

    public void showCart() {
        String message = "YOUR CART: \n";
        double price = 0;
        for (MenuItem currentItem : cart) {
            price += currentItem.getPrice();
            message += "TITLE: " + currentItem.getTitle() + " PRICE: " + currentItem.getPrice() + "\n";
        }
        message += "\n YOUR TOTAL PRICE IS : " + price;
        JOptionPane.showMessageDialog(null, message);
    }

    public Set<MenuItem> filterMenu(String title, String minRating, String maxRating, String minCalories, String maxCalories, String minProtein, String maxProtein, String minFat, String maxFat, String minSodium, String maxSodium, String minPrice, String maxPrice) {
        this.getProductData();
        double minRatingD, maxRatingD, minCaloriesD, maxCaloriesD, minProteinD, maxProteinD, minFatD, maxFatD, minSodiumD, maxSodiumD, minPriceD, maxPriceD;
        filterSet.clear();
        int countMust = 0;
        if (!title.equals("")) {
            countMust++;
        }
        if (!minRating.equals("")) {
            countMust++;
        }
        if (!maxRating.equals("")) {
            countMust++;
        }
        if (!minCalories.equals("")) {
            countMust++;
        }
        if (!maxCalories.equals("")) {
            countMust++;
        }
        if (!minProtein.equals("")) {
            countMust++;
        }
        if (!maxProtein.equals("")) {
            countMust++;
        }
        if (!minFat.equals("")) {
            countMust++;
        }
        if (!maxFat.equals("")) {
            countMust++;
        }
        if (!minSodium.equals("")) {
            countMust++;
        }
        if (!maxSodium.equals("")) {
            countMust++;
        }
        if (!minPrice.equals("")) {
            countMust++;
        }
        if (!maxPrice.equals("")) {
            countMust++;
        }
        /*menuItemSet.stream().forEach(currentItem->{

        });*/
        for (MenuItem currentItem : menuItemSet) {
            int count=0;
            if (!title.equals("")) {
                if (currentItem.getTitle().equals(title)) {
                    count++;
                }
            }
            if (!minRating.equals("")) {
                minRatingD = Double.parseDouble(minRating);
                if (currentItem.getRating() >= minRatingD) {
                    count++;
                }
            }
            if (!maxRating.equals("")) {
                maxRatingD = Double.parseDouble(maxRating);
                if (currentItem.getRating() <= maxRatingD) {
                    count++;
                }
            }
            if (!minCalories.equals("")) {
                minCaloriesD = Double.parseDouble(minCalories);
                if (currentItem.getCalories() >= minCaloriesD) {
                    count++;
                }
            }
            if (!maxCalories.equals("")) {
                maxCaloriesD = Double.parseDouble(maxCalories);
                if (currentItem.getCalories() <= maxCaloriesD) {
                    count++;
                }
            }
            if (!minProtein.equals("")) {
                minProteinD = Double.parseDouble(minProtein);
                if (currentItem.getProtein() >= minProteinD) {
                    count++;
                }
            }
            if (!maxProtein.equals("")) {
                maxProteinD = Double.parseDouble(maxProtein);
                if (currentItem.getProtein() <= maxProteinD) {
                    count++;
                }
            }
            if (!minFat.equals("")) {
                minFatD = Double.parseDouble(minFat);
                if (currentItem.getFat() >= minFatD) {
                    count++;
                }
            }
            if (!maxFat.equals("")) {
                maxFatD = Double.parseDouble(maxFat);
                if (currentItem.getFat() <= maxFatD) {
                    count++;
                }
            }
            if (!minSodium.equals("")) {
                minSodiumD = Double.parseDouble(minSodium);
                if (currentItem.getSodium() >= minSodiumD) {
                    count++;
                }
            }
            if (!maxSodium.equals("")) {
                maxSodiumD = Double.parseDouble(maxSodium);
                if (currentItem.getSodium() <= maxSodiumD) {
                    count++;
                }
            }
            if (!minPrice.equals("")) {
                minPriceD = Double.parseDouble(minPrice);
                if (currentItem.getPrice() >= minPriceD) {
                    count++;
                }
            }
            if (!maxPrice.equals("")) {
                maxPriceD = Double.parseDouble(maxPrice);
                if (currentItem.getPrice() <= maxPriceD) {
                    count++;
                }
            }
            if (count == countMust) {
                filterSet.add(currentItem);
            }
        }

        return filterSet;
        /*
        System.out.println("--------------");
        for (MenuItem currentItem : filterSet) {
            System.out.println("\n" + currentItem);
        }
        System.out.println("--------------");
*/
    }

    public void clearFilters() {
        filterSet.addAll(menuItemSet);
        for (MenuItem currentItem : filterSet) {
            System.out.println("\n" + currentItem);
        }
    }

    public void order(User user) {
        int index = 0;
        if (orderMap == null) {
            index = 1;
        } else {
            index = orderMap.size() + 1;
        }
        Order order = new Order(index, user.getId());
        orderMap.put(order, cart);

        String message = "YOUR ORDER: \n";
        double price = 0;
        for (MenuItem currentItem : cart) {
            price += currentItem.getPrice();
            message += "TITLE: " + currentItem.getTitle() + " PRICE: " + currentItem.getPrice() + "\n";
        }
        message += "\n YOUR TOTAL PRICE IS : " + price;
        JOptionPane.showMessageDialog(null, message);
        new Serializer().serializeOrder(orderMap);
        cart.clear();
    }

    public void timeInterval(int timeI, int timeF) throws IOException {
        FileWriter writer = new FileWriter("raport1.txt");
        writer.write(" The orders performed between " + timeI + ":00 and " + timeF + ":00 :");
        Set<Order> collect = orderMap.keySet().stream().filter(order -> order.getOrderTime().getHour() >= timeI && order.getOrderTime().getHour() <= timeF).collect(Collectors.toSet());
        collect.forEach(item -> {
            try {
                writer.write(item.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        writer.flush();
    }

    public void productsOrdered(int n) {
        Map<MenuItem, Integer> stats = new HashMap<MenuItem, Integer>();
        menuItemSet.stream().forEach(crtM -> {
            stats.put(crtM, 0);
        });
        orderMap.keySet().stream().forEach(crtItem->{
            orderMap.get(crtItem).stream().forEach(crtMenuItem->{
                menuItemSet.stream().forEach(crtM->{
                    if(Objects.equals(crtM.getTitle(), crtMenuItem.getTitle())){
                        stats.put(crtM, stats.get(crtM) + 1);
                    }
                });
            });
        });
        try {
            FileWriter writer = new FileWriter("raport2.txt");
            writer.write("Menu items that were ordered more than " + n + ":\n");
            stats.keySet().stream().forEach(menuItem -> {
                if(stats.get(menuItem) >= n){
                    try {
                        writer.write(menuItem.toString() + " was ordered " + stats.get(menuItem) + " times.\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clientsAndOrders(int times, double value){
        Map<User, Integer> stats = new HashMap<User, Integer>();

        userSet.stream().forEach( user  -> {
                stats.put(user, 0);
        });

        orderMap.keySet().stream().forEach(order->{
            double orderValue = 0;

            orderValue = orderMap.get(order).stream().map(crtMenuItem -> {return crtMenuItem.getPrice();})
                    .reduce(0.0, DeliveryService::add);

            double finalOrderValue = orderValue;
            userSet.stream().forEach(user -> {
                if(order.getClientId() == user.getId()){
                    if(finalOrderValue > value){
                        stats.put(user, stats.get(user) + 1);
                    }
                }
            });
        });


        try {
            FileWriter writer = new FileWriter("raport3.txt");
            writer.write("Users that have atleast " + times + " orders with value over "+ value+":\n");
            stats.keySet().stream().forEach( user->{
                if(stats.get(user) >= times){
                    try {
                        writer.write(user.getUsername() + " has ordered " + stats.get(user) + " times.\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ordersInASpecifiedDay(LocalDate date){
        Map<MenuItem, Integer> stats = new HashMap<MenuItem, Integer>();
        menuItemSet.stream().forEach(crtM -> {
            stats.put(crtM, 0);
        });

        orderMap.keySet().stream().forEach( order -> {
            if(order.getOrderTime().toLocalDate().equals(date)){
                orderMap.get(order).stream().forEach(crtMenuItem ->{
                    stats.keySet().stream().forEach(crtM -> {
                        if(Objects.equals(crtM.getTitle(), crtMenuItem.getTitle())){
                            stats.put(crtM, stats.get(crtM) + 1);
                        }
                    });
                });
            }
        });

        try {
            FileWriter writer = new FileWriter("raport4.txt");
            writer.write("Products that have been ordered in "+date.toString()+ ":\n");

            stats.keySet().stream().forEach(menuItem -> {
                try {
                    if(stats.get(menuItem) != 0){
                        writer.write(menuItem.toString() + " was ordered " + stats.get(menuItem) + " times.\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Set<MenuItem> getCart() {
        return cart;
    }

    public void setCart(Set<MenuItem> cart) {
        this.cart = cart;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public static double add(double a, double b) {
        return a + b;
    }
}

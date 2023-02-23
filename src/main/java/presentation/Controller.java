package presentation;

import business.DeliveryService;
import business.Order;
import dao.Serializer;
import dao.UsersWriter;
import model.User;
import model.products.BaseProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Controller {
    private LoginView loginView;
    private RegisterView registerView = new RegisterView();
    private ClientView clientView = new ClientView();
    private AdminView adminView = new AdminView();
    private FilterView filterView = new FilterView();
    private ReportsView reportsView=new ReportsView();
    private User user;
    private Set<User> userSet;
    private Set<model.products.MenuItem> menuItemSet;
    private DeliveryService deliveryService;


    public Controller(LoginView loginView, DeliveryService deliveryService) {
        this.loginView = loginView;
        this.deliveryService = deliveryService;
        this.loginView.getBtnLogin(new BtnLoginListener());
        this.loginView.getBtnRegister(new BtnLoginRegisterListener());

        this.registerView.getBtnRegister(new BtnRegisterRegisterListener());

        this.clientView.getBtnFilter(new BtnClientFilterListener());
        this.clientView.getBtnClearFilters(new BtnClientClearFiltersListener());
        this.clientView.getBtnPlaceOrder(new BtnClientPlaceOrderListener());
        this.clientView.getBtnAddToCart(new BtnClientAddToCartListener());
        this.clientView.getBtnCart(new BtnClientCartListener());

        this.adminView.getBtnAddNewBaseProduct(new BtnAdminAddNewBaseProduct());
        this.adminView.getBtnEditItem(new BtnAdminEditItem());
        this.adminView.getBtnApplyChanges(new BtnAdminApplyChanges());
        this.adminView.getBtnDeleteItem(new BtnAdminDeleteItem());
        this.adminView.getBtnAddNewComposite(new BtnAdminAddNewComposite());
        this.adminView.getGenerateReports(new BtnAdminGenerateReports());

        this.reportsView.getBtnGOTime(new BtnGOTime());
        this.reportsView.getBtnGOClients(new BtnGOClients());
        this.reportsView.getBtnGOOrders(new BtnGOOrders());
        this.reportsView.getBtnGOProducts(new BtnGOProducts());

        this.filterView.getBtnApply(new BtnFilterApply());

    }

    public boolean adminCheckBoxes() {
        if (adminView.getTextFieldTitle().isEmpty() || adminView.getTextFieldCalories().isEmpty() || adminView.getTextFieldProtein().isEmpty() ||
                adminView.getTextFieldFats().isEmpty() || adminView.getTextFieldSodium().isEmpty() || adminView.getTextPrice().isEmpty()) {
            return false;
        }
        return true;
    }

    class BtnLoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (loginView.getTextFieldUsername().isEmpty() || loginView.getTextFieldPassword().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please don't leave the boxes empty!");
            } else {
                userSet = deliveryService.getUserSet();
                String username = loginView.getTextFieldUsername();
                String password = loginView.getTextFieldPassword();
                try {
                    deliveryService.readUsers();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                boolean check;
                check = deliveryService.find(username, password);
                if (check == true) {
                    int type = -1;
                    for (User crtUser : userSet) {
                        if (username.equals(crtUser.getUsername())) {
                            user = crtUser;
                            type = crtUser.getType();
                        }
                    }
                    menuItemSet = deliveryService.createMenuSet();
                    //new Serializer().serializeMenu(menuItemSet);
                    if (type == 0) {
                        adminView.setVisible(true);
                        adminView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    } else if (type == 1) {
                        //employee TO DO
                    } else if (type == 2) {
                        clientView.setVisible(true);
                        clientView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Something went wrong! Please try again later!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password!");
                }
            }
        }
    }

    class BtnLoginRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            registerView.setVisible(true);
        }
    }

    class BtnRegisterRegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (registerView.getTextFieldUsername().isEmpty() || registerView.getTextFieldPassword().isEmpty() || registerView.getTextFieldConfirmPassword().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please don't leave the boxes empty!");
            } else {
                if (!(registerView.getTextFieldPassword().equals(registerView.getTextFieldConfirmPassword()))) {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!");
                } else {
                    int type = -1;
                    String typeString = registerView.getComboBox().getSelectedItem().toString();
                    if (typeString == "ADMIN") {
                        type = 0;
                    } else if (typeString == "EMPLOYEE") {
                        type = 1;
                    } else if (typeString == "CLIENT") {
                        type = 2;
                    }
                    String username = registerView.getTextFieldUsername();
                    String password = registerView.getTextFieldPassword();
                    try {
                        deliveryService.writeUsers(username, password, type);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }
    }

    //ADMINISTRATOR
    class BtnAdminAddNewBaseProduct implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (adminCheckBoxes() == false) {
                JOptionPane.showMessageDialog(null, "Some boxes are empty!");
            } else {
                String title = adminView.getTextFieldTitle();
                double rating = Double.parseDouble(adminView.getTextFieldRating());
                double calories = Double.parseDouble(adminView.getTextFieldCalories());
                double proteins = Double.parseDouble(adminView.getTextFieldProtein());
                double fats = Double.parseDouble(adminView.getTextFieldFats());
                double sodium = Double.parseDouble(adminView.getTextFieldSodium());
                double price = Double.parseDouble(adminView.getTextPrice());
                try {
                    deliveryService.addNewBaseItem(title, rating, calories, proteins, fats, sodium, price);
                    //adminView.refreshTable();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                adminView.refreshTable();
            }
        }
    }

    class BtnAdminEditItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (adminCheckBoxes() == false) {
                JOptionPane.showMessageDialog(adminView, "Some boxes are empty!");
            } else {
                String title = adminView.getTextFieldTitle();
                double rating = Double.parseDouble(adminView.getTextFieldRating());
                double calories = Double.parseDouble(adminView.getTextFieldCalories());
                double proteins = Double.parseDouble(adminView.getTextFieldProtein());
                double fats = Double.parseDouble(adminView.getTextFieldFats());
                double sodium = Double.parseDouble(adminView.getTextFieldSodium());
                double price = Double.parseDouble(adminView.getTextPrice());
                deliveryService.editItem(title, rating, calories, proteins, fats, sodium, price);
            }
            adminView.refreshTable();
        }
    }

    class BtnAdminApplyChanges implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.setVisible(false);
            JOptionPane.showMessageDialog(null, "Saved!");
        }
    }

    class BtnAdminDeleteItem implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (adminView.getTextFieldTitle().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Title box is empty!");
            } else {
                String title = adminView.getTextFieldTitle();
                deliveryService.deleteItem(title);
            }
            adminView.refreshTable();
        }
    }

    class BtnAdminAddNewComposite implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class BtnAdminGenerateReports implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reportsView.setVisible(true);
        }
    }


    //CLIENT
    class BtnClientFilterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filterView.setVisible(true);
            filterView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    class BtnClientClearFiltersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.clearFilters();
            clientView.refreshTable(menuItemSet);
        }
    }

    class BtnClientPlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.order(user);
        }
    }

    class BtnClientAddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (clientView.getTableMenu().getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null, "Please select something!");
            } else {
                String item = clientView.getTableMenu().getValueAt(clientView.getTableMenu().getSelectedRow(),0).toString();
                System.out.println(item);
                deliveryService.addToCart(item);
            }
        }
    }

    class BtnClientCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (deliveryService.getCart() == null) {
                JOptionPane.showMessageDialog(null, "Your cart is empty!");
            } else {
                deliveryService.showCart();
            }
        }
    }

    class BtnFilterApply implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = "", minRating = "", maxRating = "", minCalories = "", maxCalories = "", minProtein = "", maxProtein = "", minFat = "", maxFat = "", minSodium = "", maxSodium = "", minPrice = "", maxPrice = "";
            if (!filterView.getTextFieldKeyWord().equals("")) {
                title = filterView.getTextFieldKeyWord();
            }
            if (!filterView.getTextFieldRating().equals("")) {
                minRating = filterView.getTextFieldRating();
            }
            if (!filterView.getTextFieldRatingMax().equals("")) {
                maxRating = filterView.getTextFieldRatingMax();
            }
            if (!filterView.getTextFieldCalories().equals("")) {
                minCalories = filterView.getTextFieldCalories();
            }
            if (!filterView.getTextFieldCaloriesMax().equals("")) {
                maxCalories = filterView.getTextFieldCaloriesMax();
            }
            if (!filterView.getTextFieldProtein().equals("")) {
                minProtein = filterView.getTextFieldProtein();
            }
            if (!filterView.getTextFieldProteinMax().equals("")) {
                maxProtein = filterView.getTextFieldProteinMax();
            }
            if (!filterView.getTextFieldFat().equals("")) {
                minFat = filterView.getTextFieldFat();
            }
            if (!filterView.getTextFieldFatMax().equals("")) {
                maxFat = filterView.getTextFieldFatMax();
            }
            if (!filterView.getTextFieldSodium().equals("")) {
                minSodium = filterView.getTextFieldSodium();
            }
            if (!filterView.getTextFieldSodiumMax().equals("")) {
                maxSodium = filterView.getTextFieldSodiumMax();
            }
            if (!filterView.getTextFieldPrice().equals("")) {
                minPrice = filterView.getTextFieldPrice();
            }
            if (!filterView.getTextFieldPriceMax().equals("")) {
                maxPrice = filterView.getTextFieldPriceMax();
            }
            clientView.refreshTable(deliveryService.filterMenu(title, minRating, maxRating, minCalories, maxCalories, minProtein, maxProtein, minFat, maxFat, minSodium, maxSodium, minPrice, maxPrice));
        }
    }

    //REPORTS
    class BtnGOTime implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        if(reportsView.getTextFieldTimeIntervalI().isEmpty() || reportsView.getTextFieldTimeIntervalF().isEmpty()){
            JOptionPane.showMessageDialog(adminView, "Some boxes are empty!");
        }else{
            int timeI=0;
            int timeF=0;
            timeI=Integer.parseInt(reportsView.getTextFieldTimeIntervalI());
            timeF=Integer.parseInt(reportsView.getTextFieldTimeIntervalF());
            try {
                deliveryService.timeInterval(timeI, timeF);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(adminView, "Generated!");
        }
        }
    }
    class BtnGOClients implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(reportsView.getTextFieldClientsAndOrdersTimes().isEmpty() || reportsView.getTextFieldClientsAndOrdersValue().isEmpty()){
                JOptionPane.showMessageDialog(null, "Some boxes are empty!");
            }else{
                int times=Integer.parseInt(reportsView.getTextFieldClientsAndOrdersTimes());
                int value=Integer.parseInt(reportsView.getTextFieldClientsAndOrdersValue());
                deliveryService.clientsAndOrders(times, value);
                JOptionPane.showMessageDialog(adminView, "Generated!");
            }
        }
    }
    class BtnGOProducts implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(reportsView.getTextFieldProductsOrderedN().isEmpty()){
                JOptionPane.showMessageDialog(adminView, "Number box is empty!");
            }else{
                int n=Integer.parseInt(reportsView.getTextFieldProductsOrderedN());
                deliveryService.productsOrdered(n);
                JOptionPane.showMessageDialog(adminView, "Generated!");
            }
        }
    }
    class BtnGOOrders implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(reportsView.getTextFieldInADayYear().isEmpty() || reportsView.getTextFieldInADayMonth().isEmpty() || reportsView.getTextFieldInADayDay().isEmpty()){
                JOptionPane.showMessageDialog(adminView, "Number box is empty!");
            }else{
                int year=Integer.parseInt(reportsView.getTextFieldInADayYear());
                int month=Integer.parseInt(reportsView.getTextFieldInADayMonth());
                int day=Integer.parseInt(reportsView.getTextFieldInADayDay());
                deliveryService.ordersInASpecifiedDay(LocalDate.of(year, month, day));
                JOptionPane.showMessageDialog(adminView, "Generated!");
            }
        }
    }

    public Set<model.products.MenuItem> getMenuItemSet() {
        return menuItemSet;
    }

    public void setMenuItemSet(Set<model.products.MenuItem> menuItemSet) {
        this.menuItemSet = menuItemSet;
    }

}

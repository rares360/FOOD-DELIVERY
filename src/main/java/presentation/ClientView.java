package presentation;

import business.DeliveryService;
import model.products.BaseProduct;
import model.products.MenuItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientView extends JFrame {
    private DeliveryService deliveryService;
    private JFrame frame;
    private JTable tableMenu;

    private Object[][] data;
    private JButton btnFilter;
    private JButton btnClearFilters;
    private JButton btnPlaceOrder;
    private JButton btnAddToCart;
    private JButton btnCart;

    private JScrollPane jScrollPane;

    public ClientView() {
        this.deliveryService = new DeliveryService();
        this.setAlwaysOnTop(true);
        this.getContentPane().setBackground(new Color(102, 153, 204));
        this.getContentPane().setLayout(null);

        JLabel lblMeniu = new JLabel("MENU");
        lblMeniu.setBounds(416, 5, 51, 26);
        lblMeniu.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 24));
        this.getContentPane().add(lblMeniu);

        tableMenu = new JTable(
                this.deliveryService.getProductData(),
                new String[]{
                        "TITLE", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE"
                }
        );
        tableMenu.getColumnModel().getColumn(0).setPreferredWidth(170);
        tableMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        tableMenu.setBounds(10, 59, 864, 400);
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(10, 59, 864, 400);
        this.getContentPane().add(jScrollPane);
        jScrollPane.setViewportView(tableMenu);

        btnFilter = new JButton("FILTER");
        btnFilter.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnFilter.setBounds(10, 470, 111, 23);
        this.getContentPane().add(btnFilter);

        btnClearFilters = new JButton("CLEAR FILTERS");
        btnClearFilters.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnClearFilters.setBounds(10, 497, 111, 23);
        this.getContentPane().add(btnClearFilters);

        btnCart = new JButton("CART");
        btnCart.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnCart.setBounds(763, 497, 111, 23);
        this.getContentPane().add(btnCart);

        btnAddToCart = new JButton("ADD TO CART");
        btnAddToCart.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnAddToCart.setBounds(763, 470, 111, 23);
        this.getContentPane().add(btnAddToCart);

        btnPlaceOrder = new JButton("PLACE ORDER");
        btnPlaceOrder.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnPlaceOrder.setBounds(131, 497, 622, 22);
        this.getContentPane().add(btnPlaceOrder);

        JScrollBar scrollBarV = new JScrollBar();
        scrollBarV.setBackground(new Color(255, 255, 255));
        scrollBarV.setBounds(857, 59, 17, 400);
        this.getContentPane().add(scrollBarV);

        JScrollBar scrollBarH = new JScrollBar();
        scrollBarH.setOrientation(JScrollBar.HORIZONTAL);
        scrollBarH.setBounds(10, 442, 837, 17);

        //jScrollPane.add(scrollBarH);
        //jScrollPane.add(scrollBarV);


        this.setBounds(100, 100, 900, 570);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);

    }
    public void refreshTable(Set<MenuItem> menuItemSet) {

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
        tableMenu = new JTable(
                result,
                new String[]{
                        "TITLE", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE"
                }
        );
        tableMenu.getColumnModel().getColumn(0).setPreferredWidth(170);
        tableMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        tableMenu.setBounds(10, 59, 864, 400);
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(10, 59, 864, 400);
        this.getContentPane().add(jScrollPane);
        jScrollPane.setViewportView(tableMenu);
    }


    public JTable getTableMenu() {
        return tableMenu;
    }
    public void setTableMenu(JTable tableMenu) {
        this.tableMenu = tableMenu;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    /*public String getValueAt(int row) {
        return deliveryService.getProductDataSelected(row,0)[row][0];
    }*/

    public void getBtnFilter(ActionListener action){btnFilter.addActionListener(action);}
    public void getBtnClearFilters(ActionListener action){btnClearFilters.addActionListener(action);}
    public void getBtnPlaceOrder(ActionListener action){btnPlaceOrder.addActionListener(action);}
    public void getBtnAddToCart(ActionListener action){btnAddToCart.addActionListener(action);}
    public void getBtnCart(ActionListener action){btnCart.addActionListener(action);}
}

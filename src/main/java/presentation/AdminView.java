package presentation;

import business.DeliveryService;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

public class AdminView extends JFrame {
    private DeliveryService deliveryService;

    private JTable tableMenu;
    private JTextField textFieldTitle;
    private JTextField textFieldRating;
    private JTextField textFieldCalories;
    private JTextField textFieldProtein;
    private JTextField textFieldFats;
    private JTextField textFieldSodium;
    private JTextField textPrice;

    private JButton btnAddNewBaseProduct;
    private JButton btnEditItem;
    private JButton btnApplyChanges;
    private JButton btnDeleteItem;
    private JButton btnAddNewComposite;
    private JButton btnGenerateReports;

    private JScrollBar scrollBarV;
    private JScrollBar scrollBarH;

    private JScrollPane jScrollPane;

    public AdminView() {
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
        tableMenu.setEnabled(false);
        jScrollPane = new JScrollPane();
        jScrollPane.setBounds(10, 59, 864, 400);
        this.getContentPane().add(jScrollPane);
        jScrollPane.setViewportView(tableMenu);

        btnAddNewBaseProduct = new JButton("ADD NEW BASE PRODUCT");
        btnAddNewBaseProduct.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnAddNewBaseProduct.setBounds(10, 458, 201, 23);
        this.getContentPane().add(btnAddNewBaseProduct);

        btnDeleteItem = new JButton("DELETE ITEM");
        btnDeleteItem.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnDeleteItem.setBounds(552, 458, 111, 23);
        this.getContentPane().add(btnDeleteItem);

        btnEditItem = new JButton("EDIT ITEM");
        btnEditItem.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnEditItem.setBounds(221, 458, 111, 23);
        this.getContentPane().add(btnEditItem);

        scrollBarV = new JScrollBar();
        scrollBarV.setBackground(new Color(255, 255, 255));
        scrollBarV.setBounds(857, 59, 17, 400);
        this.getContentPane().add(scrollBarV);

        scrollBarH = new JScrollBar();
        scrollBarH.setOrientation(JScrollBar.HORIZONTAL);
        scrollBarH.setBounds(10, 442, 837, 17);
        this.getContentPane().add(scrollBarH);

        btnAddNewComposite = new JButton("ADD NEW COMPOSITE PRODUCT");
        btnAddNewComposite.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnAddNewComposite.setBounds(673, 458, 201, 23);
        this.getContentPane().add(btnAddNewComposite);

        btnApplyChanges = new JButton("APPLY CHANGES");
        btnApplyChanges.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnApplyChanges.setBounds(342, 458, 200, 23);
        this.getContentPane().add(btnApplyChanges);

        textFieldTitle = new JTextField();
        textFieldTitle.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textFieldTitle.setBounds(10, 504, 160, 20);
        this.getContentPane().add(textFieldTitle);
        textFieldTitle.setColumns(10);

        JLabel lblTitle = new JLabel("TITLE");
        lblTitle.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblTitle.setBounds(10, 488, 30, 16);
        this.getContentPane().add(lblTitle);

        JLabel lblRating = new JLabel("RATING");
        lblRating.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblRating.setBounds(180, 488, 44, 16);
        this.getContentPane().add(lblRating);

        JLabel lblCalories = new JLabel("CALS");
        lblCalories.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblCalories.setBounds(262, 488, 51, 16);
        this.getContentPane().add(lblCalories);

        JLabel lblProteins = new JLabel("PROTEINS");
        lblProteins.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblProteins.setBounds(342, 488, 59, 16);
        this.getContentPane().add(lblProteins);

        JLabel lblFats = new JLabel("FATS");
        lblFats.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblFats.setBounds(422, 488, 59, 16);
        this.getContentPane().add(lblFats);

        JLabel lblPrice = new JLabel("PRICE");
        lblPrice.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblPrice.setBounds(582, 488, 59, 16);
        this.getContentPane().add(lblPrice);

        textFieldRating = new JTextField();
        textFieldRating.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textFieldRating.setColumns(10);
        textFieldRating.setBounds(180, 504, 70, 20);
        this.getContentPane().add(textFieldRating);

        textFieldCalories = new JTextField();
        textFieldCalories.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textFieldCalories.setColumns(10);
        textFieldCalories.setBounds(262, 504, 70, 20);
        this.getContentPane().add(textFieldCalories);

        textFieldProtein = new JTextField();
        textFieldProtein.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textFieldProtein.setColumns(10);
        textFieldProtein.setBounds(342, 504, 70, 20);
        this.getContentPane().add(textFieldProtein);

        textFieldFats = new JTextField();
        textFieldFats.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textFieldFats.setColumns(10);
        textFieldFats.setBounds(422, 504, 70, 20);
        this.getContentPane().add(textFieldFats);

        textFieldSodium = new JTextField();
        textFieldSodium.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textFieldSodium.setColumns(10);
        textFieldSodium.setBounds(502, 504, 70, 20);
        this.getContentPane().add(textFieldSodium);

        textPrice = new JTextField();
        textPrice.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        textPrice.setColumns(10);
        textPrice.setBounds(582, 504, 70, 20);
        this.getContentPane().add(textPrice);

        JLabel lblSodium = new JLabel("SODIUM");
        lblSodium.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 16));
        lblSodium.setBounds(502, 488, 59, 16);
        this.getContentPane().add(lblSodium);

        btnGenerateReports = new JButton("GENERATE REPORTS");
        btnGenerateReports.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnGenerateReports.setBounds(673, 504, 201, 23);
        this.getContentPane().add(btnGenerateReports);
        this.setBounds(100, 100, 900, 570);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    public void refreshTable() {
        this.remove(tableMenu);
        tableMenu = new JTable(
                this.deliveryService.getProductData(),
                new String[]{
                        "TITLE", "RATING", "CALORIES", "PROTEIN", "FAT", "SODIUM", "PRICE"
                }
        );
        tableMenu.getColumnModel().getColumn(0).setPreferredWidth(170);
        tableMenu.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        tableMenu.setBounds(10, 59, 864, 400);
        tableMenu.setEnabled(false);
        jScrollPane.setViewportView(tableMenu);
        tableMenu.revalidate();
        tableMenu.repaint();
       // tableMenu.revalidate();
       // jScrollPane.revalidate();
        //tableMenu.revalidate();
        //jScrollPane.repaint();
        //tableMenu.invalidate();
    }

    public String getTextFieldTitle() {
        return textFieldTitle.getText();
    }

    public void setTextFieldTitle(JTextField textFieldTitle) {
        this.textFieldTitle = textFieldTitle;
    }

    public String getTextFieldRating() {
        return textFieldRating.getText();
    }

    public void setTextFieldRating(JTextField textFieldRating) {
        this.textFieldRating = textFieldRating;
    }

    public String getTextFieldCalories() {
        return textFieldCalories.getText();
    }

    public void setTextFieldCalories(JTextField textFieldCalories) {
        this.textFieldCalories = textFieldCalories;
    }

    public String getTextFieldProtein() {
        return textFieldProtein.getText();
    }

    public void setTextFieldProtein(JTextField textFieldProtein) {
        this.textFieldProtein = textFieldProtein;
    }

    public String getTextFieldFats() {
        return textFieldFats.getText();
    }

    public void setTextFieldFats(JTextField textFieldFats) {
        this.textFieldFats = textFieldFats;
    }

    public String getTextFieldSodium() {
        return textFieldSodium.getText();
    }

    public void setTextFieldSodium(JTextField textFieldSodium) {
        this.textFieldSodium = textFieldSodium;
    }

    public String getTextPrice() {
        return textPrice.getText();
    }

    public void setTextPrice(JTextField textPrice) {
        this.textPrice = textPrice;
    }

    public void getBtnAddNewBaseProduct(ActionListener action) {
        btnAddNewBaseProduct.addActionListener(action);
    }

    public void getBtnEditItem(ActionListener action) {
        btnEditItem.addActionListener(action);
    }

    public void getBtnApplyChanges(ActionListener action) {
        btnApplyChanges.addActionListener(action);
    }

    public void getBtnDeleteItem(ActionListener action) {
        btnDeleteItem.addActionListener(action);
    }

    public void getBtnAddNewComposite(ActionListener action) {
        btnAddNewComposite.addActionListener(action);
    }

    public void getGenerateReports(ActionListener action) {
        btnGenerateReports.addActionListener(action);
    }

    public JTable getTableMenu() {
        return tableMenu;
    }

    public void setTableMenu(JTable tableMenu) {
        this.tableMenu = tableMenu;
    }
}

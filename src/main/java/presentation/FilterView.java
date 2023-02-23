package presentation;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class FilterView extends JFrame {

    private JTextField textFieldKeyWord;
    private JTextField textFieldRating;
    private JTextField textFieldCalories;
    private JTextField textFieldProtein;
    private JTextField textFieldFat;
    private JTextField textFieldSodium;
    private JTextField textFieldPrice;
    private JTextField textFieldRatingMax;
    private JTextField textFieldCaloriesMax;
    private JTextField textFieldProteinMax;
    private JTextField textFieldFatMax;
    private JTextField textFieldSodiumMax;
    private JTextField textFieldPriceMax;

    private JButton btnApply;

    public FilterView() {
        this.getContentPane().setBackground(new Color(102, 153, 204));
        this.setAlwaysOnTop(true);
        this.setBounds(100, 100, 500, 350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblKeyword = new JLabel("KEYWORD:");
        lblKeyword.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblKeyword.setBounds(10, 11, 110, 25);
        this.getContentPane().add(lblKeyword);

        JLabel lblRating = new JLabel("RATING (min):");
        lblRating.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblRating.setBounds(10, 47, 110, 25);
        this.getContentPane().add(lblRating);

        JLabel lblCaloriesmin = new JLabel("CALORIES (min):");
        lblCaloriesmin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblCaloriesmin.setBounds(10, 83, 110, 25);
        this.getContentPane().add(lblCaloriesmin);

        JLabel lblProteinmin = new JLabel("PROTEIN (min):");
        lblProteinmin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblProteinmin.setBounds(10, 119, 110, 25);
        this.getContentPane().add(lblProteinmin);

        JLabel lblFatmin = new JLabel("FAT (min):");
        lblFatmin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblFatmin.setBounds(10, 155, 110, 25);
        this.getContentPane().add(lblFatmin);

        JLabel lblSodiummin = new JLabel("SODIUM (min):");
        lblSodiummin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblSodiummin.setBounds(10, 191, 110, 25);
        this.getContentPane().add(lblSodiummin);

        JLabel lblPricemin = new JLabel("PRICE (min):");
        lblPricemin.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblPricemin.setBounds(10, 227, 110, 25);
        this.getContentPane().add(lblPricemin);

        textFieldKeyWord = new JTextField();
        textFieldKeyWord.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldKeyWord.setBounds(130, 15, 130, 20);
        this.getContentPane().add(textFieldKeyWord);
        textFieldKeyWord.setColumns(10);

        textFieldRating = new JTextField();
        textFieldRating.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldRating.setColumns(10);
        textFieldRating.setBounds(130, 51, 130, 20);
        this.getContentPane().add(textFieldRating);

        textFieldCalories = new JTextField();
        textFieldCalories.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldCalories.setColumns(10);
        textFieldCalories.setBounds(130, 87, 130, 20);
        this.getContentPane().add(textFieldCalories);

        textFieldProtein = new JTextField();
        textFieldProtein.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldProtein.setColumns(10);
        textFieldProtein.setBounds(130, 123, 130, 20);
        this.getContentPane().add(textFieldProtein);

        textFieldFat = new JTextField();
        textFieldFat.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldFat.setColumns(10);
        textFieldFat.setBounds(130, 160, 130, 20);
        this.getContentPane().add(textFieldFat);

        textFieldSodium = new JTextField();
        textFieldSodium.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldSodium.setColumns(10);
        textFieldSodium.setBounds(130, 196, 130, 20);
        this.getContentPane().add(textFieldSodium);

        textFieldPrice = new JTextField();
        textFieldPrice.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(130, 232, 130, 20);
        this.getContentPane().add(textFieldPrice);

        textFieldRatingMax = new JTextField();
        textFieldRatingMax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldRatingMax.setColumns(10);
        textFieldRatingMax.setBounds(335, 51, 130, 20);
        this.getContentPane().add(textFieldRatingMax);

        JLabel lblmax = new JLabel("(max) :");
        lblmax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblmax.setBounds(270, 47, 55, 25);
        this.getContentPane().add(lblmax);

        JLabel lblmax_1 = new JLabel("(max) :");
        lblmax_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblmax_1.setBounds(270, 83, 55, 25);
        this.getContentPane().add(lblmax_1);

        JLabel lblmax_2 = new JLabel("(max) :");
        lblmax_2.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblmax_2.setBounds(270, 119, 55, 25);
        this.getContentPane().add(lblmax_2);

        JLabel lblmax_3 = new JLabel("(max) :");
        lblmax_3.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblmax_3.setBounds(270, 155, 55, 25);
        this.getContentPane().add(lblmax_3);

        JLabel lblmax_4 = new JLabel("(max) :");
        lblmax_4.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblmax_4.setBounds(270, 191, 55, 25);
        this.getContentPane().add(lblmax_4);

        JLabel lblmax_5 = new JLabel("(max) :");
        lblmax_5.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 22));
        lblmax_5.setBounds(270, 227, 55, 25);
        this.getContentPane().add(lblmax_5);

        textFieldCaloriesMax = new JTextField();
        textFieldCaloriesMax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldCaloriesMax.setColumns(10);
        textFieldCaloriesMax.setBounds(335, 88, 130, 20);
        this.getContentPane().add(textFieldCaloriesMax);

        textFieldProteinMax = new JTextField();
        textFieldProteinMax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldProteinMax.setColumns(10);
        textFieldProteinMax.setBounds(335, 124, 130, 20);
        this.getContentPane().add(textFieldProteinMax);

        textFieldFatMax = new JTextField();
        textFieldFatMax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldFatMax.setColumns(10);
        textFieldFatMax.setBounds(335, 160, 130, 20);
        this.getContentPane().add(textFieldFatMax);

        textFieldSodiumMax = new JTextField();
        textFieldSodiumMax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldSodiumMax.setColumns(10);
        textFieldSodiumMax.setBounds(335, 196, 130, 20);
        this.getContentPane().add(textFieldSodiumMax);

        textFieldPriceMax = new JTextField();
        textFieldPriceMax.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldPriceMax.setColumns(10);
        textFieldPriceMax.setBounds(335, 232, 130, 20);
        this.getContentPane().add(textFieldPriceMax);

        btnApply = new JButton("APPLY");
        btnApply.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        btnApply.setBounds(335, 15, 130, 21);
        this.getContentPane().add(btnApply);
        this.setVisible(false);
    }
    public void getBtnApply(ActionListener action){btnApply.addActionListener(action);}

    public String getTextFieldKeyWord() {
        return textFieldKeyWord.getText();
    }

    public String getTextFieldRating() {
        return textFieldRating.getText();
    }

    public String getTextFieldCalories() {
        return textFieldCalories.getText();
    }

    public String getTextFieldProtein() {
        return textFieldProtein.getText();
    }

    public String getTextFieldFat() {
        return textFieldFat.getText();
    }

    public String getTextFieldSodium() {
        return textFieldSodium.getText();
    }

    public String getTextFieldPrice() {
        return textFieldPrice.getText();
    }

    public String getTextFieldRatingMax() {
        return textFieldRatingMax.getText();
    }

    public String getTextFieldCaloriesMax() {
        return textFieldCaloriesMax.getText();
    }

    public String getTextFieldProteinMax() {
        return textFieldProteinMax.getText();
    }

    public String getTextFieldFatMax() {
        return textFieldFatMax.getText();
    }

    public String getTextFieldSodiumMax() {
        return textFieldSodiumMax.getText();
    }

    public String getTextFieldPriceMax() {
        return textFieldPriceMax.getText();
    }
}

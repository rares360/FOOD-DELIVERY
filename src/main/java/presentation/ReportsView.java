package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ReportsView extends JFrame {

    private JFrame frame;
    private JTextField textFieldTimeIntervalI;
    private JTextField textFieldProductsOrderedN;
    private JTextField textFieldClientsAndOrdersTimes;
    private JTextField textFieldInADayYear;
    private JTextField textFieldInADayMonth;
    private JTextField textFieldClientsAndOrdersValue;
    private JTextField textFieldTimeIntervalF;
    private JTextField textFieldInADayDay;

    private JButton btnGOTime;
    private JButton btnGOProducts;
    private JButton btnGOClients;
    private JButton btnGOOrders;

    public ReportsView() {
        this.getContentPane().setBackground(new Color(102, 153, 204));
        this.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("TIME INTERVAL");
        lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 78, 26);
        this.getContentPane().add(lblNewLabel);

        JLabel lblProductsOrdered = new JLabel("PRODUCTS ORDERED");
        lblProductsOrdered.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblProductsOrdered.setBounds(10, 48, 115, 26);
        this.getContentPane().add(lblProductsOrdered);

        JLabel lblClientsAndOrders = new JLabel("CLIENTS AND ORDERS");
        lblClientsAndOrders.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblClientsAndOrders.setBounds(10, 85, 115, 26);
        this.getContentPane().add(lblClientsAndOrders);

        JLabel lblOrdersInA = new JLabel("ORDERS IN A DAY");
        lblOrdersInA.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblOrdersInA.setBounds(10, 122, 115, 26);
        this.getContentPane().add(lblOrdersInA);

        JLabel lblInitialTime = new JLabel("YEAR");
        lblInitialTime.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblInitialTime.setBounds(135, 122, 67, 26);
        this.getContentPane().add(lblInitialTime);

        JLabel lblTimes = new JLabel("TIMES");
        lblTimes.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblTimes.setBounds(135, 85, 67, 26);
        this.getContentPane().add(lblTimes);

        JLabel lblNumber = new JLabel("NUMBER");
        lblNumber.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblNumber.setBounds(135, 48, 67, 26);
        this.getContentPane().add(lblNumber);

        JLabel lblInitialTime_1 = new JLabel("INITIAL TIME");
        lblInitialTime_1.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblInitialTime_1.setBounds(135, 11, 61, 26);
        this.getContentPane().add(lblInitialTime_1);

        textFieldTimeIntervalI = new JTextField();
        textFieldTimeIntervalI.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldTimeIntervalI.setBounds(206, 15, 61, 20);
        this.getContentPane().add(textFieldTimeIntervalI);
        textFieldTimeIntervalI.setColumns(10);

        textFieldProductsOrderedN = new JTextField();
        textFieldProductsOrderedN.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldProductsOrderedN.setColumns(10);
        textFieldProductsOrderedN.setBounds(206, 52, 61, 20);
        this.getContentPane().add(textFieldProductsOrderedN);

        textFieldClientsAndOrdersTimes = new JTextField();
        textFieldClientsAndOrdersTimes.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldClientsAndOrdersTimes.setColumns(10);
        textFieldClientsAndOrdersTimes.setBounds(206, 89, 61, 20);
        this.getContentPane().add(textFieldClientsAndOrdersTimes);

        textFieldInADayYear = new JTextField();
        textFieldInADayYear.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldInADayYear.setColumns(10);
        textFieldInADayYear.setBounds(206, 126, 61, 20);
        this.getContentPane().add(textFieldInADayYear);

        JLabel lblMonth = new JLabel("MONTH");
        lblMonth.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblMonth.setBounds(277, 122, 67, 26);
        this.getContentPane().add(lblMonth);

        JLabel lblValue = new JLabel("VALUE");
        lblValue.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblValue.setBounds(277, 85, 42, 26);
        this.getContentPane().add(lblValue);

        JLabel lblFinalTime = new JLabel("FINAL TIME");
        lblFinalTime.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblFinalTime.setBounds(277, 11, 53, 26);
        this.getContentPane().add(lblFinalTime);

        textFieldInADayMonth = new JTextField();
        textFieldInADayMonth.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldInADayMonth.setColumns(10);
        textFieldInADayMonth.setBounds(340, 126, 61, 20);
        this.getContentPane().add(textFieldInADayMonth);

        textFieldClientsAndOrdersValue = new JTextField();
        textFieldClientsAndOrdersValue.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldClientsAndOrdersValue.setColumns(10);
        textFieldClientsAndOrdersValue.setBounds(340, 89, 61, 20);
        this.getContentPane().add(textFieldClientsAndOrdersValue);

        textFieldTimeIntervalF = new JTextField();
        textFieldTimeIntervalF.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldTimeIntervalF.setColumns(10);
        textFieldTimeIntervalF.setBounds(340, 15, 61, 20);
        this.getContentPane().add(textFieldTimeIntervalF);

        JLabel lblDay = new JLabel("DAY");
        lblDay.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        lblDay.setBounds(411, 122, 29, 26);
        this.getContentPane().add(lblDay);

        textFieldInADayDay = new JTextField();
        textFieldInADayDay.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        textFieldInADayDay.setColumns(10);
        textFieldInADayDay.setBounds(450, 126, 61, 20);
        this.getContentPane().add(textFieldInADayDay);

        btnGOTime = new JButton("GO");
        btnGOTime.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        btnGOTime.setBounds(521, 14, 53, 23);
        this.getContentPane().add(btnGOTime);

        btnGOProducts = new JButton("GO");
        btnGOProducts.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        btnGOProducts.setBounds(521, 51, 53, 23);
        this.getContentPane().add(btnGOProducts);

        btnGOClients = new JButton("GO");
        btnGOClients.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        btnGOClients.setBounds(521, 88, 53, 23);
        this.getContentPane().add(btnGOClients);

        btnGOOrders = new JButton("GO");
        btnGOOrders.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
        btnGOOrders.setBounds(521, 125, 53, 23);
        this.getContentPane().add(btnGOOrders);
        this.setBackground(Color.WHITE);
        this.setAlwaysOnTop(true);
        this.setBounds(100, 100, 600, 224);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void getBtnGOTime(ActionListener action){btnGOTime.addActionListener(action);}
    public void getBtnGOProducts(ActionListener action){btnGOProducts.addActionListener(action);}
    public void getBtnGOClients(ActionListener action){btnGOClients.addActionListener(action);}
    public void getBtnGOOrders(ActionListener action){btnGOOrders.addActionListener(action);}

    public String getTextFieldTimeIntervalI() {
        return textFieldTimeIntervalI.getText();
    }

    public String getTextFieldProductsOrderedN() {
        return textFieldProductsOrderedN.getText();
    }

    public String getTextFieldClientsAndOrdersTimes() {
        return textFieldClientsAndOrdersTimes.getText();
    }

    public String getTextFieldInADayYear() {
        return textFieldInADayYear.getText();
    }

    public String getTextFieldInADayMonth() {
        return textFieldInADayMonth.getText();
    }

    public String getTextFieldClientsAndOrdersValue() {
        return textFieldClientsAndOrdersValue.getText();
    }

    public String getTextFieldTimeIntervalF() {
        return textFieldTimeIntervalF.getText();
    }

    public String getTextFieldInADayDay() {
        return textFieldInADayDay.getText();
    }
}

package presentation;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionListener;

public class RegisterView extends JFrame {

    private JFrame frame;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldConfirmPassword;

    private JButton btnRegister;

    private JComboBox comboBox;

    public RegisterView() {
        this.setBackground(Color.BLACK);
        this.getContentPane().setBackground(new Color(102, 153, 204));
        this.getContentPane().setLayout(null);

        JLabel lblDelivery = new JLabel("360DELIVERY");
        lblDelivery.setBounds(136, 5, 212, 49);
        lblDelivery.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 45));
        this.getContentPane().add(lblDelivery);

        JLabel lblRegister = new JLabel("REGISTER");
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 31));
        lblRegister.setBounds(136, 127, 212, 49);
        this.getContentPane().add(lblRegister);

        textFieldUsername = new JTextField();
        textFieldUsername.setForeground(Color.BLACK);
        textFieldUsername.setBackground(Color.WHITE);
        textFieldUsername.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldUsername.setBounds(136, 232, 212, 25);
        this.getContentPane().add(textFieldUsername);
        textFieldUsername.setColumns(10);

        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsername.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
        lblUsername.setBounds(136, 187, 212, 34);
        this.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
        lblPassword.setBounds(136, 268, 212, 34);
        this.getContentPane().add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setForeground(Color.BLACK);
        textFieldPassword.setBackground(Color.WHITE);
        textFieldPassword.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(136, 313, 212, 25);
        this.getContentPane().add(textFieldPassword);

        btnRegister = new JButton("REGISTER");
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setBounds(136, 485, 212, 23);
        this.getContentPane().add(btnRegister);

        JLabel lblConfirmPassword = new JLabel("CONFIRM PASSWORD");
        lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirmPassword.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
        lblConfirmPassword.setBounds(136, 349, 212, 34);
        this.getContentPane().add(lblConfirmPassword);

        textFieldConfirmPassword = new JTextField();
        textFieldConfirmPassword.setForeground(Color.BLACK);
        textFieldConfirmPassword.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 16));
        textFieldConfirmPassword.setColumns(10);
        textFieldConfirmPassword.setBackground(Color.WHITE);
        textFieldConfirmPassword.setBounds(136, 394, 212, 25);
        this.getContentPane().add(textFieldConfirmPassword);
        this.setBounds(100, 100, 500, 560);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"ADMIN", "EMPLOYEE", "CLIENT"}));
        comboBox.setBounds(136, 452, 212, 22);
        this.getContentPane().add(comboBox);

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(false);
    }

    public String getTextFieldUsername() {
        return textFieldUsername.getText();
    }

    public void setTextFieldUsername(JTextField textFieldUsername) {
        this.textFieldUsername.setText(String.valueOf(textFieldUsername));
    }

    public String getTextFieldPassword() {
        return textFieldPassword.getText();
    }

    public void setTextFieldPassword(JTextField textFieldPassword) {
        this.textFieldPassword.setText(String.valueOf(textFieldPassword));
    }

    public String getTextFieldConfirmPassword() {
        return textFieldConfirmPassword.getText();
    }

    public void setTextFieldConfirmPassword(JTextField textFieldConfirmPassword) {
        this.textFieldConfirmPassword.setText(String.valueOf(textFieldConfirmPassword));
    }
    public JComboBox getComboBox() {
        return comboBox;
    }
    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public void getBtnRegister(ActionListener action){btnRegister.addActionListener(action);}
}

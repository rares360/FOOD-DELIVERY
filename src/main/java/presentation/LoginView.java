package presentation;

import business.DeliveryService;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginView extends JFrame{

    private JFrame frame;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private DeliveryService deliveryService;
    private JButton btnLogin;
    private JButton btnRegister;

    public LoginView() {
        this.setBackground(Color.BLACK);
        this.getContentPane().setBackground(new Color(102, 153, 204));
        this.getContentPane().setLayout(null);

        JLabel lblDelivery = new JLabel("360DELIVERY");
        lblDelivery.setBounds(136, 5, 212, 49);
        lblDelivery.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 45));
        this.getContentPane().add(lblDelivery);

        JLabel lblWelcome = new JLabel("WELCOME!");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 31));
        lblWelcome.setBounds(136, 57, 212, 34);
        this.getContentPane().add(lblWelcome);

        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 31));
        lblLogin.setBounds(136, 127, 212, 49);
        this.getContentPane().add(lblLogin);

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

        btnLogin = new JButton("LOGIN");
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
        btnLogin.setBounds(136, 451, 212, 23);
        this.getContentPane().add(btnLogin);

        btnRegister = new JButton("REGISTER");
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 18));
        btnRegister.setBackground(Color.WHITE);
        btnRegister.setBounds(136, 485, 212, 23);

        this.getContentPane().add(btnRegister);
        this.setBounds(100, 100, 500, 560);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
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

    public void getBtnLogin(ActionListener action){btnLogin.addActionListener(action);}
    public void getBtnRegister(ActionListener action){btnRegister.addActionListener(action);}
}

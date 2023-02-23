package dao;

import model.User;

import javax.swing.*;
import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;

public abstract class UsersWriter  {
    private static ArrayList<User>users;
    public static void readUsers() throws IOException {
        if(null == users){
            BufferedReader reader=null;
            users=new ArrayList<User>();
            String File=("src\\members.csv");
            String line="";
            try{
                reader=new BufferedReader(new FileReader(File));
                String headerLine=reader.readLine();
                while((line=reader.readLine())!=null){
                    String [] tkn=line.split(",");
                    users.add(new User(Integer.parseInt(tkn[0]),tkn[1],tkn[2],Integer.parseInt(tkn[3])));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                reader.close();
            }
        }
    }
    public static void writeUsers(String username,String password,int type) throws IOException {
        readUsers();
        boolean checkUsername=true;
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getUsername().equals(username)){
                checkUsername=false;
            }
        }
        if(checkUsername==false){
            JOptionPane.showMessageDialog(null, "Username is taken!");
        }else {
            int id = users.size() + 1;
            String File = ("src\\members.csv");
            java.io.FileWriter fw = new FileWriter(File, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println(id + "," + username + "," + password + "," + type);
            pw.flush();
            pw.close();
            JOptionPane.showMessageDialog(null, "User created!");
        }
    }
    public static boolean find(String username,String password){
        if(null == users){
            throw new IllegalStateException("user list is empty");
        }
        return users.stream()
                .filter(u->u.getUsername().equals(username))
                .filter(u->u.getPassword().equals(password))
                .findFirst()
                .isPresent();
    }
}

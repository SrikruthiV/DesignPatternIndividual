//facade pattern implemented with help of bridge pattern

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facade {
    private int userType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList = new ClassProductList();
    private Person thePerson;

    public boolean login() {
        Login loginF = new Login(this);
        loginF.setVisible(true);
        boolean x = loginF.getResult();
        userType = loginF.getUserType();
        thePerson = loginF.getPerson();
        loginF.dispose();
        return x;
    }

    public void addTrading(){
        if(userType == 0)
        {
            JOptionPane.showMessageDialog(null, "Button to Create Buyer Tradring Menu");
        }
        else{
            JOptionPane.showMessageDialog(null, "Button to Create Seller Trading Menu");
        }
    }

    public void viewTrading(){
        if(userType == 0){
            JOptionPane.showMessageDialog(null, "Button to View Buyer Trading Menu");
        }else {
            JOptionPane.showMessageDialog(null, "Button to View Seller Trading Menu");
        }
    }

    public void viewOffering(){
    	JOptionPane.showMessageDialog(null, "Button to View Offering");
    }

    public void markOffering(){
    	JOptionPane.showMessageDialog(null, "Button to Mark Offerring");
    }

    public void submitOffering(){
    	JOptionPane.showMessageDialog(null, "Button to Submit Offering");
    }

    public void remind(){
    	JOptionPane.showMessageDialog(null, "Button to Remind");
    }

    public void createUser(){
    	JOptionPane.showMessageDialog(null, "Button to Create Another User");
    }

    public void createProductList(){
        try {
            Scanner sc = new Scanner(new File("ProductInfo.txt"));
            while (sc.hasNextLine()){
                String productArray[] = sc.nextLine().split(":");

                theProductList.add(new Product(productArray[1], productArray[0]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        JOptionPane.showMessageDialog(null, "Product List Created");
    }

    public void attachProductToUser(){
        try {
            Scanner sc = new Scanner(new File("UserProduct.txt"));
            while (sc.hasNextLine()){
                String proUserArray[] = sc.nextLine().split(":");
                if(proUserArray[0].equals(thePerson.getName())) {
                    Product prod=null;
                    for(int i=0;i<theProductList.size();i++)
                    {
                        Product pro=theProductList.get(i);
                        if(pro.getName().equals(proUserArray[1])) {
                            prod = pro;
                            break;
                        }
                    }
                    if(prod != null)
                        thePerson.addProductList(prod);
                }

            }
            JOptionPane.showMessageDialog(null, "Product List attached to user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectProduct(){
        String productList = "Select one: \n";
        for(int i=0;i<theProductList.size();i++){
            productList += i +" "+ theProductList.get(i).getName() +"\n";
        }
        int opt = Integer.parseInt(JOptionPane.showInputDialog(productList));
        if(opt > 0 && opt < theProductList.size())
            theSelectedProduct = theProductList.get(opt);
    }

    public void productOperation(){

    }

    public void accept(ReminderVisitor reminderVisitor) {
    }

    public Person getThePerson() {
        return thePerson;
    }
}

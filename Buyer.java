//Factory Pattern is used to implement the menu display.
import javax.swing.*;

public class Buyer extends Person{
    public Buyer(String bname, String passwd,Facade faca) {
        super(bname, passwd, faca);
    }

    @Override
    public ProductMenu createProductMenu() {
        int choice = Integer.parseInt(JOptionPane.showInputDialog("1. Meat Product\n2. Produce Product"));
        if(choice == 1){
            super.productMenu = new MeatProductMenu(this);
        }else if(choice == 2){
            super.productMenu = new ProduceProductMenu(this);
        }
        return super.productMenu;
    }

    @Override
    public void showMenu() {
        super.productMenu.showMenu();
    }
}

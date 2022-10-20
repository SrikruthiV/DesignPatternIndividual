// users factory design pattern to display menu

import javax.swing.*;

public class Seller extends Person{
    public Seller(String sname, String spass, Facade fac) {
        super(sname, spass, fac);
    }

    @Override
    public ProductMenu createProductMenu() {
        int ch = Integer.parseInt(JOptionPane.showInputDialog("1. Meat Product \n2. Produce Product"));
        if(ch == 1){
            super.productMenu = new MeatProductMenu(this);
        }else if(ch == 2){
            super.productMenu = new ProduceProductMenu(this);
        }
        return super.productMenu;
    }

    @Override
    public void showMenu() {
        super.productMenu.showMenu();
    }
}

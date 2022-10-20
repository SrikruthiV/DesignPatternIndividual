import javax.swing.*;

public abstract class Person extends JFrame{
    private String perName;
    private String perPassword;
    protected Facade objfacade;
    protected ProductMenu productMenu;
    private ClassProductList clsProdList;

    public Person(String pname, String ppassword, Facade pfacade) {
        this.perName = pname;
        this.perPassword = ppassword;
        this.objfacade = pfacade;
    }

    public void showAddButton(){
    }

    public void showViewButton(){}

    public void showRadioButton() {productMenu.showRadioButton();}

    public void showLabel(){}
    
    public void addProductList(Product prod){
        clsProdList.add(prod);
    }

    public abstract ProductMenu createProductMenu();
    
    public abstract void showMenu();
}

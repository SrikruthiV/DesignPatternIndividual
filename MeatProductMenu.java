import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeatProductMenu extends JFrame implements ProductMenu{
    private Person personObj;
    private JButton addMeatBtn,viewMeatBtn,meatList,attachedMeatList,selectMeatList;

    public MeatProductMenu(Person person) throws HeadlessException {
    	System.out.println("Factory Pattern Implemented for Meat");
        this.personObj = person;
    }

    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        meatList=new JButton("Create Meat Product List");
        meatList.setBounds(50,150,150,25);
        add(meatList);
        meatList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.createProductList();
            }
        });

        attachedMeatList=new JButton("Attached Meat Products");
        attachedMeatList.setBounds(50,200,150,25);
        add(attachedMeatList);
        attachedMeatList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.attachProductToUser();
            }
        });

        selectMeatList=new JButton("Select Meat product");
        selectMeatList.setBounds(50,250,150,25);
        add(selectMeatList);

        selectMeatList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.selectProduct();
            }
        });;

        setLayout(null);
        setVisible(true);
        setSize(250,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Meat Product Menu");

    }

    @Override
    public void showAddButton() {
        addMeatBtn=new JButton("Add Trading");
        addMeatBtn.setBounds(50,50,150,25);
        add(addMeatBtn);

        addMeatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.addTrading();
            }
        });
    }

    @Override
    public void showViewButton() {
        viewMeatBtn=new JButton("View Trading");
        viewMeatBtn.setBounds(50,100,150,25);
        add(viewMeatBtn);

        viewMeatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.viewTrading();
            }
        });
    }

    @Override
    public void showRadioButton() {}

    @Override
    public void showLabels() {}

    @Override
    public void showComboxes() {}
}

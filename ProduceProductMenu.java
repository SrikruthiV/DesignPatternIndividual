import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProduceProductMenu extends JFrame implements ProductMenu {
    private JButton addBtn,viewBtn,product_list,attached_product_list,selectProductList;
    private Person person;
    private ArrayList<JLabel> lab;

    public ProduceProductMenu(Person buyer) {
        this.person = buyer;
    }

    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        product_list=new JButton("Create Product List");
        product_list.setBounds(50,150,150,25);
        add(product_list);
        product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.createProductList();
            }
        });

        attached_product_list=new JButton("Attached Products");
        attached_product_list.setBounds(50,200,150,25);
        add(attached_product_list);
        attached_product_list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.attachProductToUser();
            }
        });

        selectProductList=new JButton("Select product");
        selectProductList.setBounds(50,250,150,25);
        add(selectProductList);

        selectProductList.addActionListener(new ActionListener() {
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
        addBtn=new JButton("Add Trading");
        addBtn.setBounds(50,50,150,25);
        add(addBtn);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.addTrading();
            }
        });
    }

    @Override
    public void showViewButton() {
        viewBtn=new JButton("View Trading");
        viewBtn.setBounds(50,100,150,25);
        add(viewBtn);

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.viewTrading();
            }
        });
    }

    @Override
    public void showRadioButton() {}

    @Override
    public void showLabels() {
        for(JLabel l:lab){
            l.setVisible(true);
        }
    }

    @Override
    public void showComboxes() {}
}

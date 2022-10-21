import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProduceProductMenu extends JFrame implements ProductMenu {
    private JButton addProBtn,viewProBtn,produceList,attachedProduceList,selectProduceList;
    private Person personObj;
    private ArrayList<JLabel> lab;

    public ProduceProductMenu(Person buyer) {
    	System.out.println("Factory Pattern Implemented for Produce");
        this.personObj = buyer;
    }

    @Override
    public void showMenu() {
        showAddButton();
        showViewButton();
        produceList=new JButton("Create Product List");
        produceList.setBounds(50,150,150,25);
        add(produceList);
        produceList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.createProductList();
            }
        });

        attachedProduceList=new JButton("Attached Products");
        attachedProduceList.setBounds(50,200,150,25);
        add(attachedProduceList);
        attachedProduceList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.attachProductToUser();
            }
        });

        selectProduceList=new JButton("Select product");
        selectProduceList.setBounds(50,250,150,25);
        add(selectProduceList);

        selectProduceList.addActionListener(new ActionListener() {
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
        setTitle("Prduce Product Menu");
    }

    @Override
    public void showAddButton() {
        addProBtn=new JButton("Add Trading");
        addProBtn.setBounds(50,50,150,25);
        add(addProBtn);

        addProBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.facadeObj.addTrading();
            }
        });
    }

    @Override
    public void showViewButton() {
        viewProBtn=new JButton("View Trading");
        viewProBtn.setBounds(50,100,150,25);
        add(viewProBtn);

        viewProBtn.addActionListener(new ActionListener() {
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

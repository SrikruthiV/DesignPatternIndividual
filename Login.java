import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Login extends JFrame {

    private final JRadioButton buyerRB;
    private final JRadioButton sellerRB;
    private volatile int count;
    private boolean loginSuccess;
    private ArrayList<String> buyersList;
    private ArrayList<String> sellersList;
    private int uType;
    private Person per;
    private Facade fac;

    public Login(Facade facade)
    {

        this.fac = facade;
        getBuyers();
        getsellers();

        count = 0;


        JLabel userLabel = new JLabel("Username :");
        userLabel.setBounds(20,20,100,25);
        this.add(userLabel);
        
        JTextField uname = new JTextField();
        uname.setBounds(100,20,150,25);
        add(uname);

        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setBounds(20,70,150,25);
        add(passwordLabel);

        JPasswordField pwd = new JPasswordField();
        pwd.setBounds(100,70,150,25);
        add(pwd);

        buyerRB = new JRadioButton("Buyer    ");
        buyerRB.setBounds(80,100,80,20);
        add(buyerRB);
        
        sellerRB = new JRadioButton("Seller");
        sellerRB.setBounds(180,100,80,20);
        add(sellerRB);

        buyerRB.addActionListener(e -> sellerRB.setSelected(false));
        sellerRB.addActionListener(e -> buyerRB.setSelected(false));

        JButton logbutton = new JButton("Login");
        logbutton.setBounds(120,130,100,30);
        add(logbutton);

        logbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
            	if(uname.getText().isEmpty() || pwd.getText().isEmpty()|| (!buyerRB.isSelected() && !sellerRB.isSelected()))
                {
                    JOptionPane.showMessageDialog(null,"Invalid Credentials, All feild are mandatory.");
                }
            	else 
            	{
            		if(buyerRB.isSelected())
            		{
            				int b=0;
                        	while(b<buyersList.size())
                        	{
                        		String str[]=buyersList.get(b).split(":");
                        		if(uname.getText().equals(str[0]) && pwd.getText().equals(str[1]))
                        		{
                        			uType = 0;
                        			per = new Buyer(uname.getText(), pwd.getText(), facade);
                        			loginSuccess = true;
                        			count = 1;
                        		}
                        		b++;
                        	}
            		}
            		if(sellerRB.isSelected())
            		{
            				int s=0;
                        	while(s<sellersList.size())
                        	{
                        		String str[]=sellersList.get(s).split(":");
                        		if(uname.getText().equals(str[0]) && pwd.getText().equals(str[1]))
                        		{
                        			uType = 0;
                        			per = new Buyer(uname.getText(), pwd.getText(), facade);
                        			loginSuccess = true;
                        			count = 1;
                        		}
                        		s++;
                        	}
            		}

            	}
            }
        });

        setLayout(null);
        setSize(300,220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Login Page");
    }

    private void getBuyers() {
       buyersList = new ArrayList<>();
        try {
        	Scanner sc = new Scanner(new File("BuyerInfo.txt"));
            while(sc.hasNextLine()){
                buyersList.add(sc.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getsellers() {
        sellersList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("SellerInfo.txt"));
            while(sc.hasNextLine()){
                sellersList.add(sc.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean getResult() {
        while (count == 0) 
        	Thread.onSpinWait();
        return loginSuccess;
    }

    public int getUserType() {
        return uType;
    }

    public Person getPerson() {
        return per;
    }
}

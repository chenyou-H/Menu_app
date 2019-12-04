import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class updateMenu implements ComponentListener {
	JFrame jf;
	JButton b1;
	JButton back;
	JButton addMore;
	JTextField foodNameTF;
	JTextField descriptionTF;
	JTextField priceTF;
	JTextField sizeTF;
	JTextField cateTF;
	JLabel foodName, description,price, size,category;
	JDBC DB;
	
	String restInfor;
	
	updateMenu(String restInfor){	

		this.restInfor = restInfor;
		setFrameAndComponent();
		addComponent();
		addActionToComponent();
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("Food Information");
		b1= new JButton("Done");
		back= new JButton("back");
		addMore= new JButton("add more");
		foodNameTF = new JTextField();
		descriptionTF = new JTextField();
		priceTF = new JTextField();
		sizeTF = new JTextField();
		cateTF = new JTextField();
		foodName = new JLabel("food name");
		description= new JLabel("description");
		price = new JLabel("price");
		size = new JLabel("size");
		category = new JLabel("category");
		DB = new JDBC();
		 
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(foodNameTF);
		jf.add(descriptionTF);
		jf.add(priceTF);
		jf.add(sizeTF);
		jf.add(cateTF);
		jf.add(foodName);
		jf.add(description);
		jf.add(price);
		jf.add(size);
		jf.add(category);
		jf.add(b1);
		jf.add(back);
		jf.add(addMore);
	}
	
	void addActionToComponent() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				try {
					int restID = DB.getRestID(restInfor);
					int categoryID = DB.getCateID(cateTF.getText(), restID);
					DB.insertFood(categoryID, foodNameTF.getText(), descriptionTF.getText(), priceTF.getText(), sizeTF.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
				jf.dispose();
				new ManagerInterface();
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jf.dispose();
				new inputCategory(restInfor);
			
			}
		});
		
		addMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					int restID = DB.getRestID(restInfor);
					DB.insertCategory(restID, cateTF.getText());
					int categoryID = DB.getCateID(cateTF.getText(), restID);
					DB.insertFood(categoryID, foodNameTF.getText(), descriptionTF.getText(), priceTF.getText(), sizeTF.getText());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				jf.dispose();
				new updateMenu(restInfor);
			}
		});
		
	}
	


	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
	
		b1.setBounds(jf.getWidth()/3*2,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		back.setBounds(jf.getWidth()/25,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		addMore.setBounds(jf.getWidth()/3,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		foodNameTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*2,jf.getWidth()/2 , jf.getHeight()/15);
		descriptionTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*3,jf.getWidth()/2 , jf.getHeight()/15);
		priceTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*4,jf.getWidth()/2 , jf.getHeight()/15);
		sizeTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*5,jf.getWidth()/2 , jf.getHeight()/15);
		cateTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10,jf.getWidth()/2 , jf.getHeight()/15);
		
		foodName.setBounds(jf.getWidth()/20, jf.getHeight()/10*2,jf.getWidth()/2 , jf.getHeight()/15);
		description.setBounds(jf.getWidth()/20, jf.getHeight()/10*3,jf.getWidth()/2 , jf.getHeight()/15);
		price.setBounds(jf.getWidth()/20, jf.getHeight()/10*4,jf.getWidth()/2 , jf.getHeight()/15);
		size.setBounds(jf.getWidth()/20, jf.getHeight()/10*5,jf.getWidth()/2 , jf.getHeight()/15);
		category.setBounds(jf.getWidth()/20, jf.getHeight()/10,jf.getWidth()/2 , jf.getHeight()/15);	
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}

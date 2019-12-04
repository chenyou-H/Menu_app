import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.*;

public class UpdateOrDelete implements ComponentListener {
	
	JFrame jf;
	JButton b1;
	JButton b2;
	JButton back;
	JDBC DB;
	String restAddress, itemInfor;
	UpdateOrDelete(String restAddress, String itemInfor){
		this.restAddress = restAddress;
		this.itemInfor = itemInfor;
		
		setFrameAndComponent();
		addComponent();
		addActionToComponent();
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("Login");
		b1= new JButton("Update");
		b2 = new JButton("Delete");
		back = new JButton("Back");
		DB = new JDBC();
		
		b1.setBounds(50,100,jf.getWidth()/5, jf.getHeight()/10);  
		b2.setBounds(200,100,jf.getWidth()/5, jf.getHeight()/10);  
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(b1);
		jf.add(b2);
		jf.add(back);
	}
	
	void addActionToComponent() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				new changeItem(restAddress, itemInfor);
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				//new ManagerInterface();
				String itemID = itemInfor.substring(0,itemInfor.indexOf(" ")).trim();
				try {
					DB.deleteFood(itemID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new editMenu(restAddress);
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new editMenu(restAddress);
			}
		});
	}
	

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		b1.setBounds(jf.getWidth()/8,jf.getHeight()/4,jf.getWidth()/4, jf.getHeight()/10);  
		b2.setBounds(jf.getWidth()/2,jf.getHeight()/4,jf.getWidth()/4, jf.getHeight()/10); 
		back.setBounds(jf.getWidth()/2,jf.getHeight()/2,jf.getWidth()/4, jf.getHeight()/10); 
		
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}

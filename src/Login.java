import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.*;

public class Login implements ComponentListener {
	
	JFrame jf;
	JButton b1;
	JButton b2;
	Login(){	
		setFrameAndComponent();
		addComponent();
		addActionToComponent();
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("Login");
		b1= new JButton("Customer");
		b2 = new JButton("Manager");
		
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
	}
	
	void addActionToComponent() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				new MenuIndex();
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				//new ManagerInterface();
				new ManagerLogin();
			}
		});
	}
	
	void runLogin() {
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		b1.setBounds(jf.getWidth()/8,jf.getHeight()/4,jf.getWidth()/4, jf.getHeight()/10);  
		b2.setBounds(jf.getWidth()/2,jf.getHeight()/4,jf.getWidth()/4, jf.getHeight()/10); 
		
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

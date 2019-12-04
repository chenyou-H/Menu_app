import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ManagerLogin implements ComponentListener{
	JFrame jf;
	JButton b1;
	JButton back;
	JTextField userNameTF;
	JTextField PsTF;
	JLabel userNameLabel;
	JLabel PsLabel;

	JDBC DB;
	
	ManagerLogin(){	
		setFrameAndComponent();
		addComponent();
		addActionToComponent();
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("Manager Login");
		b1= new JButton("continute");
		back= new JButton("back");
		userNameTF = new JTextField();
		PsTF = new JPasswordField();// JTextField();
		userNameLabel = new JLabel("Username");
		PsLabel = new JLabel("Password");
		DB = new JDBC();
		
		
		
	//	b1.setBounds(50,100,jf.getWidth()/5, jf.getHeight()/10);  
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(userNameTF);
		jf.add(PsTF);
		jf.add(userNameLabel);
		jf.add(PsLabel);
	
		jf.add(b1);
		jf.add(back);

	}
	
	void addActionToComponent() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(userNameTF.getText().equals("123")==false || PsTF.getText().equals("123")==false) {
					JOptionPane.showMessageDialog(jf,"Wrong user name or password","Inane waring", JOptionPane.WARNING_MESSAGE);
				}
				else {
					jf.dispose();
					new ManagerInterface();
				}
				
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jf.dispose();
				new Login();
			
			}
		});
		
	}
	

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		b1.setBounds(jf.getWidth()/3*2,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		back.setBounds(jf.getWidth()/25,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		
		userNameTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10,jf.getWidth()/2 , jf.getHeight()/10);
		PsTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*2,jf.getWidth()/2 , jf.getHeight()/10);
		PsLabel.setBounds(jf.getWidth()/20, jf.getHeight()/10*2,jf.getWidth()/5, jf.getHeight()/10);
		userNameLabel.setBounds(jf.getWidth()/20, jf.getHeight()/10,jf.getWidth()/5, jf.getHeight()/10);
		
		
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

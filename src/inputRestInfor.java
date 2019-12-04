import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class inputRestInfor implements ComponentListener{
	JFrame jf;
	JButton b1;
	JButton back;
	JTextField restName;
	JTextField restAddress;
	JLabel restNameLabel;
	JLabel restAddressLabel;
	JLabel open_date, open_hours;
	JTextField open_dateTF, open_hoursTF;
	JDBC DB;
	
	inputRestInfor(){	
		setFrameAndComponent();
		addComponent();
		addActionToComponent();
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("Restaurant Information");
		b1= new JButton("next");
		back= new JButton("back");
		restName = new JTextField();
		restAddress = new JTextField();
		restNameLabel = new JLabel("Name");
		restAddressLabel = new JLabel("Address");
		open_date = new JLabel("open date");
		open_hours = new JLabel("open hours");
		open_dateTF = new JTextField();
		open_hoursTF = new JTextField();
		DB = new JDBC();
		
	//	b1.setBounds(50,100,jf.getWidth()/5, jf.getHeight()/10);  
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(restName);
		jf.add(restAddress);
		jf.add(restNameLabel);
		jf.add(restAddressLabel);
		jf.add(open_date);
		jf.add(open_hours);
		jf.add(open_dateTF);
		jf.add(open_hoursTF);
		jf.add(b1);
		jf.add(back);

	}
	
	void addActionToComponent() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int checker=1;
				try {
					checker = DB.insertRestInfor(restName.getText(), restAddress.getText(),open_dateTF.getText(),open_hoursTF.getText());
					System.out.println("Succuessful Insert restaurant information");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(checker ==0) {
					jf.dispose();
					new ManagerInterface();
					JOptionPane.showMessageDialog(jf, "There is a restaurant in this address" );
				}
				else {
					
					try {
						if(DB.checkRestName(restName.getText())==1) {
						//	DB.copyMenu(restName.getText(), restAddress.getText());
							jf.dispose();
							new ManagerInterface();
							JOptionPane.showMessageDialog(jf, "We already linked your restaurant to exist restaurant with same name" );
						}
						else {
							jf.dispose();
							new inputCategory(restAddress.getText());
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}

			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jf.dispose();
				new ManagerInterface();
			
			}
		});
		
	}
	

	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		b1.setBounds(jf.getWidth()/3*2,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		back.setBounds(jf.getWidth()/25,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		
		restName.setBounds(jf.getWidth()/8*3, jf.getHeight()/10,jf.getWidth()/2 , jf.getHeight()/10);
		restAddress.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*2,jf.getWidth()/2 , jf.getHeight()/10);
		restAddressLabel.setBounds(jf.getWidth()/20, jf.getHeight()/10*2,jf.getWidth()/5, jf.getHeight()/10);
		restNameLabel.setBounds(jf.getWidth()/20, jf.getHeight()/10,jf.getWidth()/10, jf.getHeight()/10);
		
		open_date.setBounds(jf.getWidth()/20, jf.getHeight()/10*3,jf.getWidth()/5, jf.getHeight()/10);
		open_hours.setBounds(jf.getWidth()/20, jf.getHeight()/10*4,jf.getWidth()/5, jf.getHeight()/10);
		open_dateTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*3,jf.getWidth()/2, jf.getHeight()/10);
		open_hoursTF.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*4,jf.getWidth()/2, jf.getHeight()/10);
		
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

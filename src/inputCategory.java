import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class inputCategory implements ComponentListener {
	JFrame jf;
	JButton b1;
	JButton back;
	JButton addMore;
	JTextField categoryTextField11;
	JTextField categoryTextField12;
	JTextField categoryTextField13;
	JTextField categoryTextField14;
	JTextField categoryTextField15;
	JLabel categoryName;
	JDBC DB;
	
	String restInfor;
	
	inputCategory(String categoryTextField){	
		restInfor = categoryTextField;
		setFrameAndComponent();
		addComponent();
		addActionToComponent();
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("Category Information");
		b1= new JButton("next");
		back= new JButton("back");
		addMore= new JButton("add more");
		categoryTextField11 = new JTextField();
		categoryTextField12 = new JTextField();
		categoryTextField13 = new JTextField();
		categoryTextField14 = new JTextField();
		categoryTextField15 = new JTextField();
		categoryName = new JLabel("Category");
		DB = new JDBC();
		
	//	b1.setBounds(50,100,jf.getWidth()/5, jf.getHeight()/10);  
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(categoryTextField11);
		jf.add(categoryTextField12);
		jf.add(categoryTextField13);
		jf.add(categoryTextField14);
		jf.add(categoryTextField15);
		jf.add(categoryName);
		jf.add(b1);
		jf.add(back);
		jf.add(addMore);
	}
	
	void addActionToComponent() {
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//jf.dispose();
				try {
					
					int restID = DB.getRestID(restInfor);
					if(categoryTextField11.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField11.getText());
					}
					
					if(categoryTextField12.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField12.getText());
					}
					
					if(categoryTextField13.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField13.getText());
					}
					
					if(categoryTextField14.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField14.getText());
					}
					
					if(categoryTextField15.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField15.getText());
					}
				
					System.out.println("Succuessful Insert category information");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				jf.dispose();
				new inputFood(restInfor);
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jf.dispose();
				new inputRestInfor();
			
			}
		});
		
		addMore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					int restID = DB.getRestID(restInfor);
					if(categoryTextField11.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField11.getText());
					}
					
					if(categoryTextField12.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField12.getText());
					}
					
					if(categoryTextField13.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField13.getText());
					}
					
					if(categoryTextField14.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField14.getText());
					}
					
					if(categoryTextField15.getText().equals("")!=true) {
						DB.insertCategory(restID, categoryTextField15.getText());
						
					}
					System.out.println("Succuessful Insert category information");
					

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				jf.dispose();
				new inputCategory(restInfor);
			}
		});
		
	}
	


	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		b1.setBounds(jf.getWidth()/3*2,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		back.setBounds(jf.getWidth()/25,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		addMore.setBounds(jf.getWidth()/3,jf.getHeight()/3*2,jf.getWidth()/4, jf.getHeight()/10);  
		categoryTextField11.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*2,jf.getWidth()/2 , jf.getHeight()/15);
		categoryTextField12.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*3,jf.getWidth()/2 , jf.getHeight()/15);
		categoryTextField13.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*4,jf.getWidth()/2 , jf.getHeight()/15);
		categoryTextField14.setBounds(jf.getWidth()/8*3, jf.getHeight()/10*5,jf.getWidth()/2 , jf.getHeight()/15);
		categoryTextField15.setBounds(jf.getWidth()/8*3, jf.getHeight()/10,jf.getWidth()/2 , jf.getHeight()/15);
		categoryName.setBounds(jf.getWidth()/20, jf.getHeight()/5,jf.getWidth()/6, jf.getHeight()/10);
		
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

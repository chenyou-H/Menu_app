import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuListToDelete implements ComponentListener {
	
	JFrame jf;
	JButton back;
	JButton Done;
	JList jlist;
	JScrollPane js;
	JDBC DB;
	
	MenuListToDelete(){
		setFrameAndComponent();
		addComponent();
		addActionToComponent();	
		jf.addComponentListener(this);
	}

	void setFrameAndComponent() {
		DB = new JDBC();
		jf = new JFrame("Menu Index");
		back = new JButton("back");
		Done = new JButton("Done");
		
		try {
			jlist = new JList(DB.getRestName());
			jlist.setVisibleRowCount(10);
			jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			js = new JScrollPane(jlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(back);
		jf.add(Done);
		jf.add(js);
		
		jlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {
					try {
						String restName = null, restAddress = null,temp;
						temp=(String) jlist.getSelectedValue();
						
						for(int i=1;i<temp.length();i++) {
							restAddress = temp.substring(temp.indexOf(" ")+i);
							restName = temp.substring(0,temp.indexOf(" ")+i);
							if(Character.isDigit(restAddress.charAt(0))==true)
								break;
						}
						
						
					//	restAddress = temp.substring(temp.indexOf(" ")+1);
					//	restName = temp.substring(0,temp.indexOf(" "));
						
						DB.deleteRestaurant(restName, restAddress);
						
						jf.dispose();
						new ManagerInterface();
						
						JOptionPane.showMessageDialog(jf, "The selected restaurant is deleted");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
		});
	}
	
	void addActionToComponent() {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new ManagerInterface();
			}
		});
		
		Done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new ManagerInterface();
			}
		});

		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		Done.setBounds(jf.getWidth()/10,jf.getHeight()/5*3,jf.getWidth()/2, jf.getHeight()/10);
		back.setBounds(jf.getWidth()/6*4,jf.getHeight()/5*3,jf.getWidth()/5, jf.getHeight()/10);
	//	jlist.setBounds(jf.getWidth()/10,jf.getHeight()/10,jf.getWidth()/2, jf.getHeight()/2);
		js.setBounds(jf.getWidth()/10,jf.getHeight()/10,jf.getWidth()/2, jf.getHeight()/2);
		
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

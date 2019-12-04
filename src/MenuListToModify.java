import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuListToModify implements ComponentListener {
	
	JFrame jf;
	JButton back;
//	JButton Done;
	JList jlist;
	JScrollPane js;
	JDBC DB;
	
	MenuListToModify(){
		setFrameAndComponent();
		addComponent();
		addActionToComponent();	
		jf.addComponentListener(this);
	}

	void setFrameAndComponent() {
		DB = new JDBC();
		jf = new JFrame("Modify Menu Index");
		back = new JButton("back");
//		Done = new JButton("Done");
		
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
//		jf.add(Done);
		jf.add(js);
		
		jlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {
					String temp, restAddress=null;
					temp = (String) jlist.getSelectedValue();
		//			restAddress = tmp.substring(tmp.indexOf(" ")+1);
					/*
					for(int i=1;i<temp.length();i++) {
						restAddress = temp.substring(temp.indexOf(" ")+i);
						
						if(Character.isDigit(restAddress.charAt(0))==true)
							break;
					}
					
					*/
					for(int i=0;i<temp.length();i++) {
						if(Character.isDigit(temp.charAt(i))==true) {
							restAddress = temp.substring(0,i-1);
							break;
						}
					}
					
					jf.dispose();
					
					new editMenu(restAddress);
				}
				
			}
			
		});
	}
	
	void addActionToComponent() {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new Login();
			}
		});
/*		
		Done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					
					String restAddress=JOptionPane.showInputDialog("Input user address");
					
					jf.dispose();
					new MenuIndexOrderByDist(DB.getRestNameOrderByDist(restAddress));
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
	*/	
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
//		Done.setBounds(jf.getWidth()/10,jf.getHeight()/5*3,jf.getWidth()/2, jf.getHeight()/10);
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

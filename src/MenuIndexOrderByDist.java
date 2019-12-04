import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuIndexOrderByDist implements ComponentListener {
	
	JFrame jf;
	JButton back;
	JButton sortByDist;
	JList jlist;
	JScrollPane js;
	JDBC DB;
	DefaultListModel model;
	
	MenuIndexOrderByDist(DefaultListModel model){
		this.model = model;
		setFrameAndComponent();
		addComponent();
		addActionToComponent();	
		jf.addComponentListener(this);
	}

	void setFrameAndComponent() {
		DB = new JDBC();
		jf = new JFrame("Menu Index");
		back = new JButton("back");
		sortByDist = new JButton("order restaurants by name");
		
		jlist = new JList(model);
		jlist.setVisibleRowCount(10);
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		js = new JScrollPane(jlist);
	
		
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(back);
		jf.add(sortByDist);
		jf.add(js);
		
		jlist.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if(!e.getValueIsAdjusting()) {
					try {
						String restAddress,temp;
						temp=(String) jlist.getSelectedValue();
						restAddress = temp.substring(temp.indexOf(" ")+1);
						temp =DB.getRestOpen_Time(restAddress)+ DB.displayMenu(restAddress);
						jf.dispose();
						new restMenu(temp);
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
				new Login();
			}
		});
		
		sortByDist.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new MenuIndex();
			}
		});
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		sortByDist.setBounds(jf.getWidth()/10,jf.getHeight()/5*3,jf.getWidth()/2, jf.getHeight()/10);
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

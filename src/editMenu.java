import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class editMenu implements ComponentListener {
	
	JFrame jf;
	JButton back;
	JButton Done;
	JList jlist;
	JScrollPane js;
	JDBC DB;
	String restAddress;
	
	editMenu(String restAddress){
		this.restAddress = restAddress;
		setFrameAndComponent();
		addComponent();
		addActionToComponent();	
		jf.addComponentListener(this);
	}

	void setFrameAndComponent() {
		DB = new JDBC();
		jf = new JFrame("Modify Menu");
		back = new JButton("back");
		Done = new JButton("add new food");
		
		try {
			jlist = new JList(DB.getMenu(restAddress));
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
					jf.dispose();
					String itemInfor = (String)jlist.getSelectedValue();
					new UpdateOrDelete(restAddress, itemInfor);
//		new restMenu(temp);
				}
				
			}
			
		});
	}
	
	void addActionToComponent() {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new MenuListToModify();
			}
		});
		
		Done.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					jf.dispose();
					new updateMenu(restAddress);
				
			}
		});
		
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		Done.setBounds(jf.getWidth()/10,jf.getHeight()/5*3,jf.getWidth()/2, jf.getHeight()/10);
		back.setBounds(jf.getWidth()/6*4,jf.getHeight()/5*3,jf.getWidth()/5, jf.getHeight()/10);
	//	jlist.setBounds(jf.getWidth()/10,jf.getHeight()/10,jf.getWidth()/2, jf.getHeight()/2);
		js.setBounds(jf.getWidth()/10,jf.getHeight()/10,jf.getWidth(), jf.getHeight()/2);
		
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

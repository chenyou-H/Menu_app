import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class restMenu implements ComponentListener {
	
	JFrame jf;
	JButton back;

	JScrollPane js;
	JTextArea jmenu;
	String menu;
	
	JDBC DB;


	
	restMenu(String menu){
		this.menu=menu;
		setFrameAndComponent();
		addComponent();
		addActionToComponent();	
		jf.addComponentListener(this);
	}

	void setFrameAndComponent() {
		DB = new JDBC();
		jf = new JFrame("Menu");
		back = new JButton("back");
		jmenu = new JTextArea(menu);
		js = new JScrollPane(jmenu);
	
	
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void addComponent() {
		jf.add(back);
		jf.add(js);
	}
	
	void addActionToComponent() {
		back.addActionListener(new ActionListener() {
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
		back.setBounds(jf.getWidth()/5*3,jf.getHeight()/5*3,jf.getWidth()/5, jf.getHeight()/10);
		js.setBounds(0,0,jf.getWidth(), jf.getHeight()/2);
		
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

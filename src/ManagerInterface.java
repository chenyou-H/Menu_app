import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ManagerInterface implements ComponentListener {
	JFrame jf;
	JButton back;
	JButton newMenu;
	JButton editMenu;
	JButton deleteMenu;
	int w =400;
	int l=400;
	
	ManagerInterface(){
		setFrameAndComponent();
		addComponent();
		addActionToComponent();	
		jf.addComponentListener(this);
	}
	
	void setFrameAndComponent() {
		jf = new JFrame("ManagerSide");
		back = new JButton("back");
		newMenu = new JButton("New Restaurant");
		editMenu = new JButton("Edit Restaurant");
		deleteMenu = new JButton("Delete Restaurant");
		
		jf.setSize(400,400);
		jf.setLayout(null);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//	back.setBounds(250,250,jf.getWidth()/5, jf.getHeight()/10);
	//	newMenu.setBounds(w/8, l/5, w/5*2, l/10);
	//	editMenu.setBounds(w/8, l/5*2, w/5*2, l/10);
	//	deleteMenu.setBounds(w/8, l/5*3, w/5*2, l/10);
	}
	
	void addComponent() {
		jf.add(back);
		jf.add(newMenu);
		jf.add(editMenu);
		jf.add(deleteMenu);
	}
	
	void addActionToComponent() {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				new Login();
			}
		});
		
		newMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();
				new inputRestInfor();
			}
			
		});
		
		deleteMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();
				new MenuListToDelete();
			}
			
		});
		
		editMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();
				new MenuListToModify();
			}
			
		});
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		w=jf.getWidth();
		l=jf.getHeight();
		back.setBounds(w/5*3,l/5*3,w/5, l/10);
		newMenu.setBounds(w/8, l/5, w/5*2, l/10);
		editMenu.setBounds(w/8, l/5*2, w/5*2, l/10);
		deleteMenu.setBounds(w/8, l/5*3, w/5*2, l/10);
	}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}

	@Override
	public void componentHidden(ComponentEvent e) {}
	
}

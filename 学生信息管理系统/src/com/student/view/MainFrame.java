package com.student.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.model.Admin;
import com.student.model.Stu;
import com.student.model.Teacher;
import com.student.model.UserType;
import com.student.sql.TimeSql;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;

public class MainFrame extends JFrame {
	private JDesktopPane desktopPane;
	private JPanel contentPane;
	public 	static UserType userType;
	public  static Object userObject;
	private JTextField userTextField;
	private JTextField timeTextField;
	/**
	 * Launch the application.
	 */
	
	
	  
	/**
	 * Create the frame.
	 */
	public MainFrame(UserType userType, Object userObject ) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(Color.ORANGE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		this.userType = userType;
		this.userObject = userObject;
		
		setTitle("\u6821\u56ED\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				int result = 	JOptionPane.showConfirmDialog(null,"确认退出","确认",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE);
				if(result ==JOptionPane.OK_OPTION ) {
					System.exit(0);
				}
			}
		});
		setBounds(100, 100, 884, 519);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u754C\u9762");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPassWord(e);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae3) {
				exit(ae3);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u9000\u51FA.png")));
		menu.add(mntmNewMenuItem);
		
		JMenuItem menuItem_5 = new JMenuItem("\u91CD\u65B0\u767B\u5F55");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartFrame(e);
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menu.add(menuItem_5);
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ManageStudentFrame().setVisible(true);
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u7528\u6237\u5217\u8868.png")));
		menu_1.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentMessage(e);
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_1.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem_8 = new JMenuItem("\u6210\u7EE9\u67E5\u8BE2");
		menuItem_8.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5E74\u9F84.png")));
		menu_1.add(menuItem_8);
		
		JMenu menu_2 = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
		menu_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage(e);
			}
		});
		menu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				classAddAction(ae);
			}
		});
		menuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u73ED\u7EA7\u5217\u8868");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				AddSeachManage(ae1);
			}
		});
		menuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		menu_2.add(menuItem_2);
		
		JMenu mnNewMenu = new JMenu("\u6821\u56ED\u7BA1\u7406");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6559\u804C\u5DE5\u7BA1\u7406");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherFrame().setVisible(true);
			}
		});
		menuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u73ED\u7EA7\u7BA1\u7406.png")));
		mnNewMenu.add(menuItem_7);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u51FA\u7EB3\u7BA1\u7406");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u65B0\u4EBA\u8BFE\u7A0B.png")));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u8BFE\u8868\u67E5\u8BE2");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem menuItem_9 = new JMenuItem("\u5B66\u751F\u6210\u7EE9\u5F55\u5165");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		menuItem_9.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		mnNewMenu.add(menuItem_9);
		
		JMenuItem menuItem_6 = new JMenuItem("\u6743\u9650\u5206\u914D");
		menuItem_6.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u804C\u79F0\u8BC4\u5B9A.png")));
		mnNewMenu.add(menuItem_6);
		
		JMenuItem menuItem_10 = new JMenuItem("\u5B66\u751F\u4EE5\u53CA\u73ED\u7EA7\u7BA1\u7406");
		menuItem_10.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5E74\u9F84.png")));
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manage(e);
			}
		});
		mnNewMenu.add(menuItem_10);
		
		JMenu menu_3 = new JMenu("\u5E2E\u52A9");
		menu_3.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menuBar.add(menu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUs(e);
			}
		});
		menuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		menu_3.add(menuItem_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u5B66\u751F.png")));
		
		userTextField = new JTextField();
		userTextField.setEditable(false);
		userTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u5F55\u7BA1\u7406\u7CFB\u7EDF\r\n");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/images/\u6821\u56ED.png")));
		lblNewLabel.setFont(new Font("仿宋", Font.PLAIN, 40));
		
		JButton btnNewButton = new JButton("\u7B7E\u5230");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(e);
			}
		});
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(804, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(userTextField)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(662, Short.MAX_VALUE)
					.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(219, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(userTextField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(445)
					.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
			
		if("管理员".equals(userType.getName())) {
			Admin admin = (Admin)userObject;
			userTextField.setText(admin.getUserName());
		}else if("教师".equals(userType.getName())) {
			Teacher tea = (Teacher)userObject;
			userTextField.setText(tea.getUserName());
		}else {
			Stu Stud = (Stu)userObject;
			userTextField.setText(Stud.getUserName());
		}
		getContentPane().setLayout(groupLayout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}
	
	protected void refresh(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timeTextField.setText(sdf.format(date));
		TimeSql timeSql = new TimeSql();
		if(timeSql.register(userType, userObject)) {
			  MsgBox.showInfo("签到成功");
		}else {
			MsgBox.showInfo("签到失败");
		}
	}
	protected void Manage(ActionEvent e) {
		// TODO Auto-generated method stub
			new ManageStudentFrameEx().setVisible(true);
	}

	protected void AddStudentMessage(ActionEvent e) {
		// TODO Auto-generated method stub
		if("管理员".equals(userType.getName())) {
		new AddStudentFrame().setVisible(true);
		}else {
			MsgBox.showInfo("管理员并未为你分配权限，无法进入该界面");
			return;
		}
	}
	protected void AddSeachManage(ActionEvent e) {
		// TODO Auto-generated method stub
		ManageClassFrame manageframe = new ManageClassFrame();
		manageframe.setVisible(true);
	
	}

	protected void classAddAction(ActionEvent e) {
		// TODO Auto-generated method stub
		if("管理员".equals(userType.getName())) {
		AddClassFrame csm = new AddClassFrame();
		csm.setVisible(true);
		}else {
			MsgBox.showInfo("管理员并未为你分配权限，无法进入该界面");
			return;
		}
	}

	protected void restartFrame(ActionEvent e) {
		// TODO Auto-generated method stub
		new LoginFrame().setVisible(true);
		this.dispose();
	}

	protected void exit(ActionEvent ae3) {
		// TODO Auto-generated method stub
			System.exit(0);
	}

	protected void editPassWord(ActionEvent e) {
		// TODO Auto-generated method stub
		new EditPassWordFrame().setVisible(true);
	}

	protected void aboutUs(ActionEvent e) {
		// TODO Auto-generated method stub
		String Info = "欢迎反馈使用中的任何问题(2901570623@qq.com)";
		String[] buttons= {"现在去反馈","不了,谢谢"};
		int ref = JOptionPane.showOptionDialog(this, Info, "关于我们", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, (new ImageIcon(LoginFrame.class.getResource("/images/\u767B\u5F55.png"))), buttons, null);
		if(ref == 0) {
				try {
					URI url  = new URI("https://mail.qq.com/");
					Desktop.getDesktop().browse(url);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}else {
			//不反馈
		}
	}
}


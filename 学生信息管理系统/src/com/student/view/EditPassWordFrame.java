package com.student.view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.factory.StringUtil;
import com.student.model.Admin;
import com.student.model.Stu;
import com.student.model.Teacher;
import com.student.model.UserType;
import com.student.sql.AdminSql;
import com.student.sql.StuSql;
import com.student.sql.TeacherSql;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class EditPassWordFrame extends JFrame {

	private JPanel contentPane;
	private  static JTextField userNameTextField;
	private static  JTextField oldPassWordTextField;
	private static JTextField NewPassWordTextField;
	private static JTextField comfirmPassWordTextField;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { +EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EditPassWordFrame frame = new
	 * EditPassWordFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public EditPassWordFrame() {
		setResizable(false);
		setFont(new Font("微软雅黑", Font.BOLD, 14));
				
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4FEE\u6539\u5BC6\u7801\u529F\u80FD\u5B8C\u5584\u4E2D");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u8054\u7CFB\u6211\u4EEC");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAction(e);
			}
		});
		menu.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237");
		label.setIcon(new ImageIcon(EditPassWordFrame.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		userNameTextField = new JTextField();
		userNameTextField.setEditable(false);
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u65E7\u5BC6\u7801");
		lblNewLabel.setIcon(new ImageIcon(EditPassWordFrame.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		oldPassWordTextField = new JTextField();
		oldPassWordTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_1.setIcon(new ImageIcon(EditPassWordFrame.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		
		NewPassWordTextField = new JTextField();
		NewPassWordTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u5B9A\u5BC6\u7801");
		lblNewLabel_2.setIcon(new ImageIcon(EditPassWordFrame.class.getResource("/images/\u4FEE\u6539\u5BC6\u7801.png")));
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		
		comfirmPassWordTextField = new JTextField();
		comfirmPassWordTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae1) {
				//设置新密码
				subPassWord(ae1);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ResetAction(ae);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(comfirmPassWordTextField)
								.addComponent(NewPassWordTextField)
								.addComponent(oldPassWordTextField)
								.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(94)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addGap(742))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(oldPassWordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(NewPassWordTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comfirmPassWordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap(34, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(132, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(77))
		);
		contentPane.setLayout(gl_contentPane);
		if("管理员".equals(MainFrame.userType.getName())) {
				Admin admin = (Admin)MainFrame.userObject;
				userNameTextField.setText(admin.getUserName());
		}else if("教师".equals(MainFrame.userType.getName())) {
				Teacher teacher = (Teacher)MainFrame.userObject;
				userNameTextField.setText(teacher.getUserName());
		}else {
				Stu stu = (Stu)MainFrame.userObject;
				userNameTextField.setText(stu.getUserName());
		}
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}
	protected void subPassWord(ActionEvent ae1) {
		// TODO Auto-generated method stub
		String oldPassWord = oldPassWordTextField.getText().toString();
		String NewPassWord = NewPassWordTextField.getText().toString();
		String comfirmPassWord = comfirmPassWordTextField.getText().toString();
		
		if(StringUtil.isEmpty(oldPassWord)) {
			MsgBox.showInfo("请填写旧密码");
			return;
		}
		if(StringUtil.isEmpty(NewPassWord)) {
			MsgBox.showInfo("请填写新密码");
			return;
		}
		if(StringUtil.isEmpty(comfirmPassWord)) {
			MsgBox.showInfo("请填写确认密码");
			return;
		}
		if(!NewPassWord.equals(comfirmPassWord)) {
			MsgBox.showInfo("两次填写的密码不一致");
			return;
		}
		if("管理员".equals(MainFrame.userType.getName())) {
			AdminSql adminsql = new  AdminSql();
			Admin adminTemp = new Admin();
			Admin adminThisTemp = (Admin)MainFrame.userObject;
			adminTemp.setId(adminThisTemp.getId());
			adminTemp.setUserName(adminThisTemp.getUserName());
			adminTemp.setPassWord(oldPassWord);
			MsgBox.showInfo(adminsql.Edit(adminTemp, NewPassWord));
			adminsql.closeSql();
			return;
		}
		if("教师".equals(MainFrame.userType.getName())) {
			TeacherSql teacherSql = new TeacherSql();
			Teacher teacherTemp = new Teacher();
			Teacher teacherThisTemp  = (Teacher)MainFrame.userObject;
			teacherTemp.setId(teacherThisTemp.getId());
			teacherTemp.setUserName(teacherThisTemp.getUserName());
			teacherTemp.setPassWord(oldPassWord);
			MsgBox.showInfo(teacherSql.Edit(teacherTemp, NewPassWord));
			teacherSql.closeSql();
			return;
		}
		if("学生".equals(MainFrame.userType.getName())){
			StuSql stusql = new StuSql();
			Stu stuTemp = new Stu();
			Stu stuThisTemp =  (Stu)MainFrame.userObject;
			stuTemp.setId(stuThisTemp.getId());
			stuTemp.setUserName(stuThisTemp.getUserName());
			stuTemp.setPassWord(oldPassWord);
			MsgBox.showInfo(stusql.Edit(stuTemp, NewPassWord));
			stusql.closeSql();
			return;
		}
	}
	protected void ResetAction(ActionEvent e) {
		// TODO Auto-generated method stub
		oldPassWordTextField.setText("");
		NewPassWordTextField.setText("");
		comfirmPassWordTextField.setText("");
	}
	protected void createAction(ActionEvent e) {
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

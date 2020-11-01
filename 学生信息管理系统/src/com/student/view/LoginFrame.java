package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.factory.StringUtil;
import com.student.factory.SwingUtils;
import com.student.model.Admin;
import com.student.model.Stu;
import com.student.model.Teacher;
import com.student.model.UserType;
import com.student.sql.AdminSql;
import com.student.sql.StuSql;
import com.student.sql.TeacherSql;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;

public class LoginFrame extends JFrame {
	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passWordTextField;
	private JComboBox userTypeComboBox;
	private JComboBox dataCombobox; 
	private JButton LoginButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setBackground(Color.GREEN);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images/\u767B\u5F55.png")));

		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 355);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u6821\u56ED\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("΢���ź�", Font.BOLD, 16));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		label_1.setFont(new Font("΢���ź�", Font.BOLD, 14));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6 \u7801");
		label_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u5BC6\u7801.png")));
		label_2.setFont(new Font("΢���ź�", Font.BOLD, 14));
		
		passWordTextField = new JPasswordField();
		passWordTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u6570\u636E\u4E2D\u5FC3");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		lblNewLabel.setFont(new Font("΢���ź�", Font.BOLD, 14));
		
		JComboBox dataComboBox = new JComboBox();
		dataComboBox.setFont(new Font("����", Font.PLAIN, 14));
		dataComboBox.setModel(new DefaultComboBoxModel(new String[] {"demo"}));
		
		JLabel userType = new JLabel("\u7528\u6237\u6027\u8D28");
		userType.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u5E2E\u52A9.png")));
		userType.setFont(new Font("΢���ź�", Font.BOLD, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setFont(new Font("����", Font.BOLD, 12));
		 LoginButton = new JButton("\u767B\u5F55");
		LoginButton.addActionListener(new ActionListener() {
			//��¼����
			public void actionPerformed(ActionEvent e) {
				LoginAction(e);
			}
		});

		LoginButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u767B\u5F55.png")));
		LoginButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		this.getRootPane().setDefaultButton(LoginButton);
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));

		JButton reSetButton = new JButton("\u91CD\u7F6E");
		reSetButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u91CD\u7F6E.png")));
		reSetButton.addActionListener(new ActionListener() {
			//���ý���
			public void actionPerformed(ActionEvent Ex) {
				reSetValue(Ex);
			}
		});
		reSetButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addComponent(userType)
						.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(reSetButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(userNameTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addComponent(passWordTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addComponent(dataComboBox, Alignment.LEADING, 0, 100, Short.MAX_VALUE))
								.addGap(149)))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(126)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(163, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(dataComboBox, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(passWordTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userType, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginButton)
						.addComponent(reSetButton))
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ĵ�С
		Dimension frameSize=this.getSize();//�����this���滻�� ��������֣���ͬ
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//����λ��
	}
	protected void LoginAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String passWord = passWordTextField.getText().toString();
		UserType selectedItem = (UserType) userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)) {
				MsgBox.showInfo("�û�������Ϊ��");
				return;
		}
		if(StringUtil.isEmpty(passWord)) {
				MsgBox.showInfo("���벻Ϊ��");
				return;
		}
		Admin admin  =null ;
		Teacher teacher = null;
		Stu stu = null;
		if("����Ա".equals(selectedItem.getName())) {
			//ϵͳ����Ա��¼
			Admin adminTemp = new Admin();
			adminTemp.setUserName(userName);
			adminTemp.setPassWord(passWord);
			
			AdminSql adminsql = new AdminSql();
			admin  = adminsql.adminLogin(adminTemp);
			if(admin == null) {
				MsgBox.showInfo("�û�����������������,���߼���û������Ƿ���ȷ");
			}
			MsgBox.showInfo("��ӭ:"+selectedItem.getName()+admin.getUserName()+"��¼��ϵͳ");
			this.dispose();
			MainFrame mainFrame = new MainFrame(selectedItem,admin);
			mainFrame.setVisible(true);
			return;
		}else 
			if("��ʦ".equals(selectedItem.getName())) {
			//��ʦ��¼
			Teacher teacherTemp = new Teacher();
			teacherTemp.setUserName(userName);
			teacherTemp.setPassWord(passWord);
			TeacherSql teachersql = new TeacherSql();
			teacher  = teachersql.teacherLogin(teacherTemp);
			teachersql.closeSql();
			if(teacher == null) {
				MsgBox.showInfo("�û�����������������,���߼���û������Ƿ���ȷ");
			}
			MsgBox.showInfo("��ӭ:"+selectedItem.getName()+teacher.getUserName()+"��¼��ϵͳ");
			this.dispose();
			MainFrame mainFrame = new MainFrame(selectedItem,teacher);
			mainFrame.setVisible(true);
			return;
		}
			
			else{
			//ѧ����¼
			Stu stuTemp = new Stu();
			stuTemp.setUserName(userName);
			stuTemp.setPassWord(passWord);
			StuSql stusql = new StuSql();
			stu  = stusql.StuLogin(stuTemp);
			stusql.closeSql();
			if(stu == null) {
				MsgBox.showInfo("�û�����������������,���߼���û������Ƿ���ȷ");
			}
			MsgBox.showInfo("��ӭ:"+selectedItem.getName()+stu.getUserName()+"��¼��ϵͳ");
			this.dispose();
			MainFrame mainFrame = new MainFrame(selectedItem,stu);
			mainFrame.setVisible(true);
			return;
			}
	}

	protected void reSetValue(ActionEvent ex) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passWordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}

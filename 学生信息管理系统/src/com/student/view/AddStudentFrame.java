package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.factory.StringUtil;
import com.student.model.ClassMessage;
import com.student.model.StudentMessage;
import com.student.sql.ClassSql;
import com.student.sql.StuSql;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class AddStudentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField timeTextField;
	private JComboBox ClassComboBox;
	private JComboBox infoComboBox;
	private JComboBox sexComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrame frame = new AddStudentFrame();
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
	public AddStudentFrame() {
		setResizable(false);
		setTitle("\u5B66\u751F\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 354, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAction(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u6DFB\u52A0.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				reSet(ae);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u91CD\u7F6E.png")));
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u4FE1\u606F\r\n");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u73ED\u7EA7\u5217\u8868.png")));
		
		ClassComboBox = new JComboBox();
		ClassComboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		ClassComboBox.setModel(new DefaultComboBoxModel(new String[] {}));
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u6027\u522B");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u6027\u522B.png")));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u8BC4\u4EF7");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u5173\u4E8E\u6211\u4EEC.png")));
		
		infoComboBox = new JComboBox();
		infoComboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		infoComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4F18\u79C0", "\u826F\u597D"}));
		
		JLabel label_2 = new JLabel("\u63D0\u4EA4\u65F6\u95F4");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/\u5E2E\u52A9.png")));
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		
		sexComboBox = new JComboBox();
		sexComboBox.setFont(new Font("宋体", Font.PLAIN, 12));
		sexComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(ClassComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(timeTextField, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(infoComboBox, Alignment.LEADING, 0, 111, Short.MAX_VALUE)
							.addComponent(sexComboBox, Alignment.LEADING, 0, 111, Short.MAX_VALUE)
							.addComponent(userNameTextField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
					.addGap(52))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(sexComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(infoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(ClassComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		setClassItem();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		timeTextField.setText(sdf.format(new Date()));
		contentPane.setLayout(gl_contentPane);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}

	protected void reSet(ActionEvent e) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		timeTextField.setText("");
		ClassComboBox.setSelectedIndex(0);
		infoComboBox.setSelectedIndex(0);
	}

	protected void AddAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String sex = sexComboBox.getSelectedItem().toString();
		String StudentName = userNameTextField.getText().toString();
		ClassMessage sm =(ClassMessage)ClassComboBox.getSelectedItem();
		String infoText = (String) infoComboBox.getSelectedItem();
		if(StringUtil.isEmpty(StudentName)) {
			MsgBox.showInfo("学生姓名不能为空");
			return;
		}
		StuSql stusql = new StuSql();
		StudentMessage student = new StudentMessage();
		student.setId(new Random().nextInt(1000));
		student.setStudentName(StudentName);
		student.setClassName(sm.getName());
		student.setSex(sex);
		student.setInfo(infoText);
		student.setTime(timeTextField.getText().toString());
		if(stusql.AddStudent(student)) {
			MsgBox.showInfo("学生信息添加成功");
		}else {
			MsgBox.showInfo("学生信息添加失败");
		}
	}
	public void setClassItem() {
		ClassSql classsql = new ClassSql();
		//数据库拿班级信息
		List<ClassMessage> classList = classsql.getClassList(new ClassMessage());
		for(ClassMessage cm : classList) {
			ClassComboBox.addItem(cm);
		}
	}
}

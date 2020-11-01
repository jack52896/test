package com.student.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.factory.StringUtil;
import com.student.model.TeacherMessage;
import com.student.sql.TeacherSql;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddTeacherFrame extends JFrame {

	private JPanel contentPane;
	private JTextField TeacherNameTextField;
	private JTextField AgeTextField;
	private JComboBox FormComboBox;
	private JComboBox AreaComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrame frame = new AddTeacherFrame();
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
	public AddTeacherFrame() {
		setResizable(false);
		setTitle("\u804C\u5DE5\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 371, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		
		TeacherNameTextField = new JTextField();
		TeacherNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E74\u9F84");
		
		AgeTextField = new JTextField();
		AgeTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u804C\u52A1");
		
		 FormComboBox = new JComboBox();
		FormComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u8BED\u6587\u8001\u5E08", "\u6570\u5B66\u8001\u5E08", "\u82F1\u8BED\u8001\u5E08", "\u5730\u7406\u8001\u5E08", "\u653F\u6CBB\u8001\u5E08"}));
		
		JLabel lblNewLabel_3 = new JLabel("\u6237\u7C4D\u6240\u5728\u5730");
		
		 AreaComboBox = new JComboBox();
		AreaComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6C5F\u897F", "\u5176\u4ED6"}));
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAction(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addGap(62)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(TeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(AgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(AreaComboBox, 0, 57, Short.MAX_VALUE)
										.addComponent(FormComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(108)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(TeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(AgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(FormComboBox, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}

	protected void AddAction(ActionEvent e) {
		// TODO Auto-generated method stub
		String TeacherName = TeacherNameTextField.getText().toString();
		String Age = AgeTextField.getText().toString();
		String Form = FormComboBox.getSelectedItem().toString();
		String Area = AreaComboBox.getSelectedItem().toString();
		if(StringUtil.isEmpty(TeacherName)) {
			MsgBox.showInfo("姓名不能为空");
			return;
		}
		if(StringUtil.isEmpty(Age)) {
			MsgBox.showInfo("年龄不能为空");
			return;
		}
		TeacherSql teachersql = new TeacherSql();
		TeacherMessage teachermessage = new TeacherMessage();
		teachermessage.setId(new Random().nextInt(1000));
		teachermessage.setName(TeacherName);
		teachermessage.setAge(Age);
		teachermessage.setForm(Form);
		teachermessage.setArea(Area);
		if(teachersql.addTeacher(teachermessage)) {
			MsgBox.showInfo("添加成功");
		}else {
			MsgBox.showInfo("添加失败");
		}
	}
}

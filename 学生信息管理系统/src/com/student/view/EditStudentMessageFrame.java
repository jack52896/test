package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.factory.StringUtil;
import com.student.model.StudentMessage;
import com.student.sql.StuSql;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/*
 * authon �����
 * Date 2020/10/13
 * result ���ݵ�ɾ������ˣ�����ˣ��޸ĸ���,��������
 */
public class EditStudentMessageFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField classNameTextField;
	private JTextField sexTextField;
	private JTextField infoTextField;
	private JTextField timeTextField;
	private JTextField endTimeTextField;
	private JCheckBox aduitChckbxNewCheckBox;
	private static String endTimeText;
	private static boolean tool;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudentMessageFrame frame = new EditStudentMessageFrame();
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
	public EditStudentMessageFrame(Object[] obj) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 995, 541);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aduitChckbxNewCheckBox.isSelected()) {
				Save(e);
			}else {
				MsgBox.showInfo("����δ��˲������޸�");
			}
			}
		});
		btnSave.setFont(new Font("����", Font.PLAIN, 13));
		menuBar.add(btnSave);
		
		JButton btnNewButton = new JButton("aduit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aduit(e);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UnAduit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					UnAduit(e);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete(e);
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 12));
		menuBar.add(btnNewButton_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Id");
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u751F\u59D3\u540D");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		classNameTextField = new JTextField();
		classNameTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5728\u73ED\u7EA7");
		
		sexTextField = new JTextField();
		sexTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5B66\u751F\u6027\u522B");
		
		infoTextField = new JTextField();
		infoTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5B66\u751F\u8BC4\u4EF7");
		
		timeTextField = new JTextField();
		timeTextField.setEditable(false);
		timeTextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u767B\u8BB0\u65F6\u95F4");
		
		aduitChckbxNewCheckBox = new JCheckBox("");
		
		JLabel lblNewLabel_6 = new JLabel("\u5BA1\u6838\u72B6\u6001");
		
		endTimeTextField = new JTextField();
		endTimeTextField.setEditable(false);
		endTimeTextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\u6700\u540E\u4FEE\u6539\u65F6\u95F4");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(338)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(endTimeTextField)
						.addComponent(aduitChckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(timeTextField)
						.addComponent(infoTextField)
						.addComponent(sexTextField)
						.addComponent(classNameTextField)
						.addComponent(nameTextField)
						.addComponent(idTextField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addContainerGap(362, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(classNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(sexTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(infoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(aduitChckbxNewCheckBox)
						.addComponent(lblNewLabel_6))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(endTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(89, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		idTextField.setText(obj[0].toString());
		nameTextField.setText(obj[1].toString());
		classNameTextField.setText(obj[2].toString());
		sexTextField.setText(obj[3].toString());
		infoTextField.setText(obj[4].toString());
		timeTextField.setText(obj[5].toString());
		endTimeTextField.setText(endTimeText);
		
		
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//��ȡ��Ļ�Ĵ�С
		Dimension frameSize=this.getSize();//�����this���滻�� ��������֣���ͬ
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//����λ��
	}
	protected void Delete(ActionEvent e) {
		// TODO Auto-generated method stub
		StudentMessage studentmessage = new StudentMessage();
		String idText = idTextField.getText();
		int id = Integer.valueOf(idText);
		studentmessage.setId(id);
		if(aduitChckbxNewCheckBox.isSelected()) {
			MsgBox.showInfo("�Ѿ������ɵĵ����޷�ɾ��");
		}else {
			StuSql stusql = new StuSql();
			String nameText = nameTextField.getText();
			studentmessage.setStudentName(nameText);
			if(stusql.delete(studentmessage)) {
				MsgBox.showInfo("ɾ���ɹ�");
				
			}else {
				MsgBox.showInfo("ɾ��ʧ��");
			}
		}
	}

	protected void UnAduit(ActionEvent e) {
		// TODO Auto-generated method stub
		if(aduitChckbxNewCheckBox.isSelected()) {
			tool = false;
			aduitChckbxNewCheckBox.setSelected(tool);
		}else {
			MsgBox.showInfo("δ��˵ĵ����޷������");
		}
	}

	protected void Aduit(ActionEvent e) {
		// TODO Auto-generated method stub
		if(aduitChckbxNewCheckBox.isSelected()) {
			MsgBox.showInfo("��ѧ����Ϣ�Ѿ������ϣ��޷������");
		}else {
			tool = true;
			aduitChckbxNewCheckBox.setSelected(tool);
			MsgBox.showInfo("�����,��˳ɹ�");
		}
	}

	protected void Save(ActionEvent e) {
		// TODO Auto-generated method stub
		StudentMessage sm  = new StudentMessage();
		String idText = idTextField.getText();
		int id = Integer.valueOf(idText);
		sm.setId(id);
		String nameText = nameTextField.getText();
		String classNameText = classNameTextField.getText();
		String sexText = sexTextField.getText();
		String infoText = infoTextField.getText();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		sm.setStudentName(nameText);
		sm.setClassName(classNameText);
		sm.setSex(sexText);
		sm.setInfo(infoText);
		sm.setTime(sdf.format(new Date()));
		StuSql stusql = new StuSql();
		
		if(stusql.upDate(sm)) {
			MsgBox.showInfo("��Ϣ�޸ı���ɹ�");
			endTimeTextField.setText(sdf.format(new Date()));
			new ManageStudentFrameEx().setTable(new StudentMessage());
			endTimeText = sdf.format(new Date());
		}else {
			MsgBox.showInfo("��Ϣ����ʧ��");
		}
	}
}

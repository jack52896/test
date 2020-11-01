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
import com.student.sql.ClassSql;

import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;

public class AddClassFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ClassNameTextField;
	private JTextField ClassMessageTextField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField createDateTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddClassFrame frame = new AddClassFrame();
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
	public AddClassFrame() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddClassFrame.class.getResource("/images/\u641C\u7D22.png")));
		setTitle("\u73ED\u7EA7\u6DFB\u52A0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		label.setFont(new Font("微软雅黑", Font.BOLD, 14));
		label.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/\u73ED\u7EA7\u540D\u79F0.png")));
		
		ClassNameTextField = new JTextField();
		ClassNameTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
		lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/\u73ED\u7EA7\u4ECB\u7ECD.png")));
		
		ClassMessageTextField = new JTextField();
		ClassMessageTextField.setColumns(10);
		
		btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClass(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/\u786E\u8BA4.png")));
		btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValue(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/\u91CD\u7F6E.png")));
		
		lblNewLabel_1 = new JLabel("\u767B\u8BB0\u65E5\u671F");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblNewLabel_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/\u8BFE\u7A0B\u5217\u8868.png")));
		
		createDateTextField = new JTextField();
		createDateTextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
									.addGap(38))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(createDateTextField)
									.addComponent(ClassNameTextField, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
								.addComponent(ClassMessageTextField))))
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(ClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(ClassMessageTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(createDateTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
		contentPane.setLayout(gl_contentPane);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		createDateTextField.setText(sdf.format(new Date()));
	}

	protected void reSetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		ClassNameTextField.setText("");
		ClassMessageTextField.setText("");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		createDateTextField.setText(sdf.format(new Date()));
	}

	protected void AddClass(ActionEvent e) {
		// TODO Auto-generated method stub
		//抓取用户填入的字符
		String ClassNameText = ClassNameTextField.getText().toString();
		String ClassMessageText = ClassMessageTextField.getText().toString();
		String createDateText = createDateTextField.getText().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		//判断是否填入空值
		if(StringUtil.isEmpty(ClassNameText)) {
			MsgBox.showInfo("请填写班级名称");
		}
		ClassSql classsql = new ClassSql();
		ClassMessage clm  = new ClassMessage();
		clm.setId(new Random().nextInt(1000));
		clm.setName(ClassNameText);
		clm.setInfo(ClassMessageText);
		clm.setCreateDate(sdf.format(new Date()));
		if(classsql.AddClass(clm)) {
			MsgBox.showInfo("班级添加成功");
		}else {
			MsgBox.showInfo("班级添加失败");
		}
	}
}

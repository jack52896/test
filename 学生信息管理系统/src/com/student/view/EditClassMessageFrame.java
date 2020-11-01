package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.student.factory.MsgBox;
import com.student.model.ClassMessage;
import com.student.model.StudentMessage;
import com.student.sql.ClassSql;
import com.student.sql.StuSql;

import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class EditClassMessageFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField infoTextField;
	private JTextField timeTextField;
	private JTextField endTimeTextField;
	private JCheckBox chckbxNewCheckBox;
	private static boolean tool;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditClassMessageFrame frame = new EditClassMessageFrame();
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
	public EditClassMessageFrame(Object[] obj) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 995, 541);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
					save(e);
				}else {
					MsgBox.showInfo("未审核的单据不允许修改");
				}
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aduit\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aduit(e);
			}
		});
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("UnAduit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnAduit(e);
			}
		});
		menuBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!chckbxNewCheckBox.isSelected()) {
					delete(e);
				}else {
					MsgBox.showInfo("已经审核的单据不允许删除");
				}
			}
		});
		menuBar.add(btnNewButton_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u7F16\u53F7");
		
		idTextField = new JTextField();
		idTextField.setEditable(false);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
		
		infoTextField = new JTextField();
		infoTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\u767B\u8BB0\u65F6\u95F4");
		
		timeTextField = new JTextField();
		timeTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BA1\u6838\u72B6\u6001");
		
		chckbxNewCheckBox = new JCheckBox("");
		
		JLabel lblNewLabel_4 = new JLabel("\u6700\u540E\u4FEE\u6539\u65F6\u95F4");
		
		endTimeTextField = new JTextField();
		endTimeTextField.setEditable(false);
		endTimeTextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(357)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
								.addGap(88))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGap(51)))
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(endTimeTextField)
							.addComponent(chckbxNewCheckBox, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(infoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(210, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(infoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addComponent(lblNewLabel_2))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(timeTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(chckbxNewCheckBox))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_4)
						.addComponent(endTimeTextField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		idTextField.setText(obj[0].toString());
		nameTextField.setText(obj[1].toString());
		infoTextField.setText(obj[2].toString());
		timeTextField.setText(obj[3].toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		endTimeTextField.setText(sdf.format(new Date()));
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}
	protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		String idText = idTextField.getText();
		int id = Integer.valueOf(idText);
		ClassMessage clm = new ClassMessage();
		ClassSql classsql =new ClassSql();
		clm.setId(id);
		if(classsql.delete(clm)) {
			MsgBox.showInfo("单据删除成功");
		}else {
			MsgBox.showInfo("单据删除失败");
		}
	}

	protected void save(ActionEvent e) {
		// TODO Auto-generated method stub
		String idText = idTextField.getText();
		int id = Integer.valueOf(idText);
		String nameText = nameTextField.getText();
		String infoText = infoTextField.getText();
		ClassMessage sm = new ClassMessage();
		sm.setId(id);
		sm.setName(nameText);
		sm.setInfo(infoText);
		ClassSql classsql = new ClassSql();
		if(classsql.upDate(sm)) {
			MsgBox.showInfo("单据信息保存成功");
		}else {
			MsgBox.showInfo("单据信息保存失败");
		}
	}

	protected void UnAduit(ActionEvent e) {
		if(chckbxNewCheckBox.isSelected()) {
			tool=false;
			chckbxNewCheckBox.setSelected(tool);
			MsgBox.showInfo("反审核成功");
		}else {
			MsgBox.showInfo("未审核的单据无法反审核");
		}
	}
	protected void Aduit(ActionEvent e) {
		// TODO Auto-generated method stub
		if(chckbxNewCheckBox.isSelected()) {
			MsgBox.showInfo("该单据已经审核，无法再次审核");
		}else {
			tool = true;
			chckbxNewCheckBox.setSelected(tool);
			MsgBox.showInfo("已审核,审核成功");
		}
	}
}

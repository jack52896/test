package com.student.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.student.model.ClassMessage;
import com.student.sql.ClassSql;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ManageClassFrame extends JFrame {
	private JTextField seachClassNameTextField;
	private JTable table;
	private JTextField currentDateTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClassFrame frame = new ManageClassFrame();
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
	public ManageClassFrame() {
		setResizable(false);
		setTitle("\u73ED\u7EA7\u5217\u8868\u67E5\u8BE2");
		setBounds(100, 100, 849, 615);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		seachClassNameTextField = new JTextField();
		seachClassNameTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassMessage clm = new ClassMessage();
				clm.setName(seachClassNameTextField.getText().toString());
				setTable(clm);
				select(e);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("\u5F53\u524D\u67E5\u8BE2\u65E5\u671F");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		currentDateTextField = new JTextField();
		currentDateTextField.setEditable(false);
		currentDateTextField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(scrollPane))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(473)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(currentDateTextField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(103)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(seachClassNameTextField, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addGap(81)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(88)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(seachClassNameTextField, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 367, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(currentDateTextField, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("宋体", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u8BC4\u4F30", "\u8BE5\u73ED\u7EA7\u4FE1\u606F\u63D0\u4EA4\u65F6\u95F4"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(138);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
		setTable(new ClassMessage());
	}
	
	protected void select(ActionEvent e) {
		// TODO Auto-generated method stub
		SimpleDateFormat  sdf  =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		currentDateTextField.setText(sdf.format(new Date()));
	}
	public void setTable(ClassMessage classmessage) {
		//设置table属性
		DefaultTableModel dfb = (DefaultTableModel)  table.getModel();
		dfb.setRowCount(0);
		ClassSql classsql = new ClassSql();
		List<ClassMessage> classList = classsql.getClassList(classmessage);
		for(ClassMessage cm: classList) {
			Vector  v = new Vector();
			v.add(cm.getId());
			v.add(cm.getName());
			v.add(cm.getInfo());
			v.add(cm.getCreateDate());
			dfb.addRow(v);
		}
		classsql.closeSql();
	}
}

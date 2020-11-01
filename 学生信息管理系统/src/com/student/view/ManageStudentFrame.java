package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.student.model.ClassMessage;
import com.student.model.StudentMessage;
import com.student.sql.ClassSql;
import com.student.sql.StuSql;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ManageStudentFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JComboBox ClassNameComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentFrame frame = new ManageStudentFrame();
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
	public ManageStudentFrame() {
		setResizable(false);
		setTitle("\u5B66\u751F\u5217\u8868");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 673, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u59D3\u540D");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentMessage sm = new StudentMessage();
				sm.setStudentName(textField.getText().toString());
				sm.setClassName(ClassNameComboBox.getSelectedItem().toString());
				setTable(sm);
				
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		 ClassNameComboBox = new JComboBox();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(lblNewLabel)
					.addGap(26)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ClassNameComboBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(126))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(41, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addComponent(ClassNameComboBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u5B66\u751F\u59D3\u540D", "\u5B66\u751F\u6240\u5C5E\u73ED\u7EA7", "\u6027\u522B", "\u5B66\u751F\u8BC4\u4EF7", "\u4FE1\u606F\u767B\u8BB0\u65F6\u95F4"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(138);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		setTable(new StudentMessage());
		AddClassItem();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}
	public void setTable(StudentMessage studentmessage) {
		DefaultTableModel dfb = (DefaultTableModel)  table.getModel();
		dfb.setRowCount(0);
		StuSql stusql = new StuSql();
		List<StudentMessage> stuList = stusql.getStudentList(studentmessage);
		for(StudentMessage sm: stuList) {
			Vector  v = new Vector();
			v.add(sm.getId());
			v.add(sm.getStudentName());
			v.add(sm.getClassName());
			v.add(sm.getSex());
			v.add(sm.getInfo());
			v.add(sm.getTime());
			dfb.addRow(v);
		}
		stusql.closeSql();
	}
	public void AddClassItem() {
		ClassSql  classsql = new ClassSql();
		List<ClassMessage> ClassList = classsql.getClassList(new ClassMessage());
		for(ClassMessage cm : ClassList) {
			ClassNameComboBox.addItem(cm);
		}
	}
}

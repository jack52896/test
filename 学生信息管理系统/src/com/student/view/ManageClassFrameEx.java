package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.student.factory.MsgBox;
import com.student.model.ClassMessage;
import com.student.sql.ClassSql;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButton;

public class ManageClassFrameEx extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuBar menuBar;
	private JRadioButton rdbtnNewRadioButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageClassFrameEx frame = new ManageClassFrameEx();
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
	public ManageClassFrameEx() {
		setResizable(false);
		setTitle("\u73ED\u7EA7\u4FE1\u606F\u4FEE\u6539");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 854, 524);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddAction(e);
			}
		});
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(e);
			}
		});
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		menuBar.add(btnNewButton_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectItem = table.getSelectedRow();
			
			Object oa = table.getValueAt(selectItem, 0);
			Object ob = table.getValueAt(selectItem, 1);
			Object oc = table.getValueAt(selectItem, 2);
			Object od = table.getValueAt(selectItem, 3);
	
			Object[] obj = new Object[] {oa,ob,oc,od};
			
			if(e.getClickCount() == 2) {
				new EditClassMessageFrame(obj).setVisible(true);
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		
		rdbtnNewRadioButton = new JRadioButton("\u5237\u65B0\u65F6\u95F4\u6233");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				select(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(rdbtnNewRadioButton))
		);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u73ED\u7EA7\u4FE1\u606F", "\u4FE1\u606F\u767B\u8BB0\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(121);
		scrollPane.setViewportView(table);
		setTable(new ClassMessage());
		contentPane.setLayout(gl_contentPane);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}

	
	protected void edit(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectItem = table.getSelectedRow();
			
			Object oa = table.getValueAt(selectItem, 0);
			Object ob = table.getValueAt(selectItem, 1);
			Object oc = table.getValueAt(selectItem, 2);
			Object od = table.getValueAt(selectItem, 3);
		
			Object obj[] = new Object[] {oa,ob,oc,od};
			if(table.isRowSelected(selectItem)) {
				new EditClassMessageFrame(obj).setVisible(true);
			}
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void AddAction(ActionEvent e) {
		// TODO Auto-generated method stub
		new AddClassFrame().setVisible(true);
	}

	protected void select(ActionEvent e) {
		// TODO Auto-generated method stub
		if(rdbtnNewRadioButton.isSelected()) {
			setTable(new ClassMessage());
		}
	}

	public void setTable(ClassMessage classmessage) {
		DefaultTableModel dfb = (DefaultTableModel)  table.getModel();
		dfb.setRowCount(0);
		ClassSql classsql = new ClassSql();
		List<ClassMessage> ClassList = classsql.getClassList(classmessage);
		for(ClassMessage clm : ClassList) {
			Vector v = new Vector();
			v.add(clm.getId());
			v.add(clm.getName());
			v.add(clm.getInfo());
			v.add(clm.getCreateDate());
			dfb.addRow(v);
		}
	}
}

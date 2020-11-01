package com.student.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.student.factory.MsgBox;
import com.student.model.StudentMessage;
import com.student.sql.StuSql;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JRadioButton;

public class ManageStudentFrameEx extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JRadioButton rdbtnNewRadioButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentFrameEx frame = new ManageStudentFrameEx();
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
	public ManageStudentFrameEx() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1055, 564);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("\u65B0\u589E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddStudentFrame().setVisible(true);
			}
		});
		menuBar.add(btnNewButton);
		
		JButton EditNewButton = new JButton("\u4FEE\u6539");
		menuBar.add(EditNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete(e);
			}
		});
		menuBar.add(btnNewButton_1);
		EditNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(e);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectitem = table.getSelectedRow();
			
			Object oa = model.getValueAt(selectitem, 0);
			Object ab = model.getValueAt(selectitem, 1);
			Object oc = model.getValueAt(selectitem, 2);
			Object od = model.getValueAt(selectitem, 3);
			Object oe = model.getValueAt(selectitem, 4);
			Object of = model.getValueAt(selectitem, 5);
			
			Object[] obj = new Object[] {oa,ab,oc,od,oe,of};
			if(e.getClickCount()==2) {
			new EditStudentMessageFrame(obj).setVisible(true);
			
			}}});
		
		JScrollPane scrollPane = new JScrollPane();
		
		 rdbtnNewRadioButton = new JRadioButton("刷新时间戳");
		 rdbtnNewRadioButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		select(e);
		 	}
		 });
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 1041, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnNewRadioButton)
					.addContainerGap())
		);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"\u5B66\u751F\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u6240\u5728\u73ED\u7EA7", "\u6027\u522B", "\u5B66\u751F\u8BC4\u4EF7", "\u5B66\u751F\u4FE1\u606F\u767B\u8BB0\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		setTable(new StudentMessage());
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的大小
		Dimension frameSize=this.getSize();//这里的this可替换成 窗体的名字，下同
		this.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);//设置位置
	}
		protected void delete(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();	
		int selectItem[] = table.getSelectedRows();
		int select = table.getSelectedRow();
		String obj = table.getValueAt(select, 0).toString();
		int id = Integer.valueOf(obj);
		for(int i = 0; i< selectItem.length;i++) {	
			model.removeRow(selectItem[i]);
		}
		StudentMessage sm = new StudentMessage();
		sm.setId(id);
		StuSql stusql = new StuSql();
		if(stusql.delete(sm)) {
			MsgBox.showInfo("删除成功");
			setTable(new StudentMessage());
		}else {
			MsgBox.showInfo("删除失败");
		}
	}

		protected void select(ActionEvent e) {
		// TODO Auto-generated method stub
		if(rdbtnNewRadioButton.isSelected()) {
			setTable(new StudentMessage());
		}
	}

		protected void edit(ActionEvent e) {
		// TODO Auto-generated method stub
		try {	
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int selectitem = table.getSelectedRow();
			
			Object oa = model.getValueAt(selectitem, 0);
			Object ab = model.getValueAt(selectitem, 1);
			Object oc = model.getValueAt(selectitem, 2);
			Object od = model.getValueAt(selectitem, 3);
			Object oe = model.getValueAt(selectitem, 4);
			Object of = model.getValueAt(selectitem, 5);
			
			Object[] obj = new Object[] {oa,ab,oc,od,oe,of};
			if(table.isRowSelected(selectitem)) {
			new EditStudentMessageFrame(obj).setVisible(true);}
		}catch(Exception ae) {
			ae.printStackTrace();
			MsgBox.showInfo("您未选中任何一项,请选中后再进行操作");
			}
		}
		public void setTable(StudentMessage studentmessage) {
			DefaultTableModel dfb = (DefaultTableModel)  table.getModel();
			dfb.setRowCount(0);
			StuSql stusql = new StuSql();
			List<StudentMessage> StudentList = stusql.getStudentList(studentmessage);
			for(StudentMessage sm : StudentList) {
				Vector v = new Vector();
				v.add(sm.getId());
				v.add(sm.getStudentName());
				v.add(sm.getClassName());
				v.add(sm.getSex());
				v.add(sm.getInfo());
				v.add(sm.getTime());
				dfb.addRow(v);
			}
		}
}

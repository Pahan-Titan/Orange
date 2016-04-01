package ua.kurs.kp;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class Window {

	private JFrame frmOrange;
	private JTable table1;
	private JTable table2;
	private JTextField txtQun;
	private JTextField txtFullName;
	private JTextField txtMobilePhone;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField textField_1;
	private int id = 0;
	
	
	//загружаем данные из БД используя метод
	String fruitBuy[][] = DataBase.loadData("fruit", "fruit", "quantity_buy");
	String countryBuy[][] = DataBase.loadData("country", "country", "quantity_buy");
	String fruitBox[] = DataBase.loadData("fruit", "fruit");
	String countryBox[] = DataBase.loadData("country", "country");
	String fruitSumm[][] = DataBase.loadData("fruit", "price", "storage_time");
	String countryDistance[][] = DataBase.loadData("country", "country", "distance");
/*	String fruitStorage[] = DataBase.loadData("fruit", "storage_time");
	String fruitPrice[] = DataBase.loadData("fruit", "price");
*/
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frmOrange.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		DataBase.addData("name", "phone", "email", "fruit", "organization", "country", "addres", 15);
	}

	public Window() {
		initialize();
	}

	private void initialize() {
		//Создание таблицы
		frmOrange = new JFrame();
		frmOrange.setTitle("Orange+");
		frmOrange.setBounds(100, 100, 745, 417);
		frmOrange.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel2 = new JPanel(null);
		
					/**************** Первая вкладка ****************/
		//иницыализацыя первой вкладки
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		//создание вкладок
		JPanel panel1 = new JPanel(null);
		tabbedPane.addTab("ТOP", panel1);

		//создание таблиц и применение моделей
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 11, 322, 183);
		panel1.add(scrollPane1);
		table1 = new JTable();
		table1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table1.setBounds(10, 11, 322, 317);
		table1.setModel(new DefaultTableModel(
			fruitBuy,
			new String[] {
				"Fruit", "Sold"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table1.getColumnModel().getColumn(0).setResizable(false);
		table1.getColumnModel().getColumn(0).setPreferredWidth(150);
		table1.getColumnModel().getColumn(0).setMinWidth(150);
		table1.getColumnModel().getColumn(1).setResizable(false);
		scrollPane1.setViewportView(table1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(372, 11, 322, 183);
		panel1.add(scrollPane2);
		table2 = new JTable();
		table2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table2.setBounds(10, 11, 322, 317);
		table2.setModel(new DefaultTableModel(
			countryBuy,
			new String[] {
				"Country", "Buy"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table2.getColumnModel().getColumn(0).setResizable(false);
		table2.getColumnModel().getColumn(0).setPreferredWidth(150);
		table2.getColumnModel().getColumn(0).setMinWidth(150);
		table2.getColumnModel().getColumn(1).setResizable(false);
		scrollPane2.setViewportView(table2);
		
					/**************** Вторая вкладка ****************/
		
		tabbedPane.addTab("Order", panel2);
		
		txtQun = new JTextField();
		txtQun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQun.setBounds(193, 40, 31, 20);
		panel2.add(txtQun);
		
		JLabel lblPriceFor = new JLabel("Price for  1 ton:");
		lblPriceFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPriceFor.setBounds(10, 42, 104, 17);
		panel2.add(lblPriceFor);
		
		final JLabel label1 = new JLabel();
		label1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label1.setBounds(112, 42, 51, 17);
		panel2.add(label1);
		
		JLabel lblFor = new JLabel("For");
		lblFor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFor.setBounds(167, 42, 27, 17);
		panel2.add(lblFor);
		
		JLabel lblTon = new JLabel("ton:");
		lblTon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTon.setBounds(234, 42, 39, 17);
		panel2.add(lblTon);
		
		final JLabel label3 = new JLabel("  ---");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label3.setBounds(265, 43, 39, 17);
		panel2.add(label3);
		
		JLabel lblStorageTime = new JLabel("Storage time:");
		lblStorageTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStorageTime.setBounds(10, 70, 89, 17);
		panel2.add(lblStorageTime);
		
		final JLabel label4 = new JLabel("");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label4.setBounds(98, 70, 44, 17);
		panel2.add(label4);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDistance.setBounds(382, 40, 65, 17);
		panel2.add(lblDistance);
		
		final JLabel label5 = new JLabel("");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label5.setBounds(447, 40, 65, 17);
		panel2.add(label5);
		
		JLabel lblDeliveryTime = new JLabel("Delivery time:");
		lblDeliveryTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeliveryTime.setBounds(382, 98, 89, 17);
		panel2.add(lblDeliveryTime);
		
		JLabel label7 = new JLabel("   ---");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label7.setBounds(481, 98, 39, 17);
		panel2.add(label7);
		
		JLabel label_1 = new JLabel("day");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(522, 98, 39, 17);
		panel2.add(label_1);
		
		JLabel lblDeliveryPrice = new JLabel("Delivery price:");
		lblDeliveryPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeliveryPrice.setBounds(382, 126, 89, 17);
		panel2.add(lblDeliveryPrice);
		
		JLabel label8 = new JLabel("   ---");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label8.setBounds(470, 126, 62, 17);
		panel2.add(label8);
		
		JButton btnNewButton = new JButton("Count up");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 134, 89, 23);
		panel2.add(btnNewButton);
		
		JLabel lblSumma = new JLabel("summa:");
		lblSumma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSumma.setBounds(123, 140, 58, 17);
		panel2.add(lblSumma);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(188, 140, 85, 17);
		panel2.add(label);
		
		txtFullName = new JTextField();
		txtFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFullName.setColumns(10);
		txtFullName.setBounds(76, 228, 243, 20);
		panel2.add(txtFullName);
		
		JLabel lblClient = new JLabel("Client:");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClient.setBounds(10, 201, 89, 17);
		panel2.add(lblClient);
		
		txtMobilePhone = new JTextField();
		txtMobilePhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMobilePhone.setColumns(10);
		txtMobilePhone.setBounds(76, 259, 243, 20);
		panel2.add(txtMobilePhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(76, 290, 243, 20);
		panel2.add(txtEmail);
		
		JLabel lblFullName = new JLabel("Full name:");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(10, 229, 71, 17);
		panel2.add(lblFullName);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhone.setBounds(10, 259, 65, 17);
		panel2.add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 290, 65, 17);
		panel2.add(lblEmail);
		
		JLabel lblOrganization = new JLabel("Organization:");
		lblOrganization.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrganization.setBounds(382, 229, 89, 17);
		panel2.add(lblOrganization);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(470, 228, 221, 20);
		panel2.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBounds(448, 259, 243, 20);
		panel2.add(textField_1);
		
		JLabel lblAddres = new JLabel("Addres:");
		lblAddres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddres.setBounds(382, 259, 65, 17);
		panel2.add(lblAddres);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountry.setBounds(382, 11, 65, 17);
		panel2.add(lblCountry);
		
		JLabel lblFruit = new JLabel("Fruit:");
		lblFruit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFruit.setBounds(10, 13, 65, 17);
		panel2.add(lblFruit);
		
		JButton btnNewButton_1 = new JButton("To order");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(515, 291, 89, 23);
		panel2.add(btnNewButton_1);
		
		JLabel lblDeliveryMethod = new JLabel("Delivery method:");
		lblDeliveryMethod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeliveryMethod.setBounds(382, 70, 114, 17);
		panel2.add(lblDeliveryMethod);
		
		final JComboBox comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox1.setModel(new DefaultComboBoxModel(fruitBox));
		comboBox1.setBounds(50, 11, 175, 20);
		panel2.add(comboBox1);
		
		final JComboBox comboBox2 = new JComboBox();
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox2.setModel(new DefaultComboBoxModel(countryBox));
		comboBox2.setBounds(447, 13, 200, 20);
		panel2.add(comboBox2);
		
		final JComboBox comboBox3 = new JComboBox();
		comboBox3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox3.setModel(new DefaultComboBoxModel(new String[] {"Fura", "Aircraft", "Ship"}));
		comboBox3.setBounds(496, 68, 121, 20);
		panel2.add(comboBox3);
		
		GroupLayout groupLayout = new GroupLayout(frmOrange.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		frmOrange.getContentPane().setLayout(groupLayout);
		
		//слушатель comboBox
		ActionListener fruitListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	int id = 0;
		    	while (fruitBuy[id][0] !=null && fruitBuy[id][1] !=null){
			    	if (fruitBuy[id][0].equals(comboBox1.getSelectedItem())){
			    		label1.setText(fruitSumm[id][0] + "$");
			    		label4.setText(fruitSumm[id][1] + " day");
			    	}
			    	id++;
		    	}
			}
		};
		
		ActionListener countryListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	id = 0;
		    	while (countryDistance[id][1] !=null){
			    	if (countryDistance[id][0].equals(comboBox2.getSelectedItem())){
			    		label5.setText(countryDistance[id][1] + " km");
			    	}
			    	id++;
		    	}
			}
		};
		
		///////////////////////////////////
		
/*		ActionListener textListener = new ActionListener() {
			public void textValueChanged(TextEvent e) {
				if (txtQun.getText() != null) label3.setText(Integer.toString(Integer.parseInt(txtQun.getText())* Integer.parseInt(fruitSumm[id][0])));
			}
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		};*/
		
		comboBox1.addActionListener(fruitListener);
		comboBox2.addActionListener(countryListener);
		comboBox3.addActionListener(fruitListener);
		txtQun.addActionListener(textListener);
	}
}

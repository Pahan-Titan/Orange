package ua.kurs.kp;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class Window {

	private JFrame frmOrange;
	private JTable table1;
	private JTable table2;
	private JTextField txtQun;
	private JTextField txtFullName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtOrganization;
	private int price;
	private int summ;
	private int time_storage;
	private int time_delivery;
	
	//загружаем данные из БД используя метод
	String fruitBuy[][] = DataBase.loadData("fruit", "fruit", "quantity_buy");
	String countryBuy[][] = DataBase.loadData("country", "country", "quantity_buy");
	String fruitBox[] = DataBase.loadData("fruit", "fruit");
	String countryBox[] = DataBase.loadData("country", "country");
	String deliveryBox[] = DataBase.loadData("delivery", "metod");
	String fruitSumm[][] = DataBase.loadData("fruit", "price", "storage_time");
	String countryDistance[][] = DataBase.loadData("country", "country", "distance");
	String delivery[][] = DataBase.loadData("delivery", "metod", "price_for_km", "speed");
	
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
	}

	public Window() {
		initialize();
	}

	private void initialize() {
		//Создание таблицы
		frmOrange = new JFrame();
		frmOrange.setTitle("Orange+");
		frmOrange.setBounds(100, 100, 745, 417);
		frmOrange.setLocationRelativeTo(null);
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
		
		JTextPane txtpnThisProgramWas = new JTextPane();
		txtpnThisProgramWas.setForeground(SystemColor.textText);
		txtpnThisProgramWas.setEnabled(false);
		txtpnThisProgramWas.setBackground(SystemColor.controlHighlight);
		txtpnThisProgramWas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnThisProgramWas.setText("This program was developed by students of the Chernihiv National Technological University for the course project.\r\nNot yavlyaetsya commercial offer. All rights reserved.\r\nFor cooperation to contact the sponsors.");
		txtpnThisProgramWas.setBounds(10, 226, 684, 51);
		panel1.add(txtpnThisProgramWas);
		
		JButton btnNewButton_2 = new JButton("Author");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Author:\n"
						+ "Kravchenko Pavel\n"
						+ "Makarovec Anna\n");
			}
		});
		btnNewButton_2.setBounds(10, 294, 86, 23);
		panel1.add(btnNewButton_2);
		
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
		
		final JLabel label3 = new JLabel("");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label3.setBounds(265, 43, 107, 17);
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
		label5.setBounds(447, 40, 150, 17);
		panel2.add(label5);
		
		JLabel lblDeliveryTime = new JLabel("Delivery time:");
		lblDeliveryTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeliveryTime.setBounds(382, 98, 89, 17);
		panel2.add(lblDeliveryTime);
		
		final JLabel label7 = new JLabel("");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label7.setBounds(481, 98, 150, 17);
		panel2.add(label7);
		
		JLabel lblDeliveryPrice = new JLabel("Delivery price:");
		lblDeliveryPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDeliveryPrice.setBounds(382, 126, 89, 17);
		panel2.add(lblDeliveryPrice);
		
		final JLabel label8 = new JLabel("");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label8.setBounds(481, 126, 161, 17);
		panel2.add(label8);
		
		JLabel lblSumma = new JLabel("summa:");
		lblSumma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSumma.setBounds(123, 140, 58, 17);
		panel2.add(lblSumma);
		
		final JLabel label = new JLabel("");
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
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(76, 259, 243, 20);
		panel2.add(txtPhone);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(448, 259, 243, 20);
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
		lblEmail.setBounds(382, 259, 65, 17);
		panel2.add(lblEmail);
		
		JLabel lblOrganization = new JLabel("Organization:");
		lblOrganization.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrganization.setBounds(382, 229, 89, 17);
		panel2.add(lblOrganization);
		
		txtOrganization = new JTextField();
		txtOrganization.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtOrganization.setColumns(10);
		txtOrganization.setBounds(470, 228, 221, 20);
		panel2.add(txtOrganization);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountry.setBounds(382, 11, 65, 17);
		panel2.add(lblCountry);
		
		JLabel lblFruit = new JLabel("Fruit:");
		lblFruit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFruit.setBounds(10, 13, 65, 17);
		panel2.add(lblFruit);
		
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
		comboBox3.setModel(new DefaultComboBoxModel(deliveryBox));
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
		    	while (id<10){
			    	if (fruitBuy[id][0].equals(comboBox1.getSelectedItem())){
			    		label1.setText(fruitSumm[id][0] + "$");
			    		label4.setText(fruitSumm[id][1] + " day");
			    		time_storage = Integer.parseInt(fruitSumm[id][1]);
			    		if (txtQun.getText().equals(""));
			    		else{
				            String temp = label1.getText();
				            summ = Integer.parseInt(txtQun.getText())*Integer.parseInt(temp.substring(0,temp.length()-1));
							label3.setText(summ + "$");
			    		}
			    	}
			    	id++;
		    	}
			}
		};
		
		ActionListener countryListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	int id = 0;
		    	while (countryDistance[id][1] !=null){
			    	if (countryDistance[id][0].equals(comboBox2.getSelectedItem())){
			    		label5.setText(countryDistance[id][1] + " km");
			    	}
			    	id++;
		    	}
			}
		};
		
		ActionListener deliveryListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	int id = 0;
		    	while (id<3){
			    	if (delivery[id][0].equals(comboBox3.getSelectedItem())){
			    		float price_for_km = Float.parseFloat(delivery[id][1]);
			    		int speed = Integer.parseInt(delivery[id][2]);
			    		if (label5.getText().equals("")) label8.setText(price_for_km + "$");
			    		else{
		    			String temp = label5.getText();
		    			time_delivery = Integer.parseInt(temp.substring(0, temp.length()-3)) / speed / 24;
		    			if (time_delivery == 0) time_delivery = 1;
		    			label7.setText(time_delivery + " day");
		    			price = (int) (Integer.parseInt(temp.substring(0, temp.length()-3)) * price_for_km);
		    			label8.setText(price + "$");
			    		}
			    	}
			    	id++;
		    	}
			}
		};
		
		DocumentListener listener = new DocumentListener()
		{
			 public void setSumm() {
		            String temp = label1.getText();
		            summ = Integer.parseInt(txtQun.getText())*Integer.parseInt(temp.substring(0,temp.length()-1));
					label3.setText(summ + "$");
				}
		    public void insertUpdate(DocumentEvent event) { setSumm(); }
			public void removeUpdate(DocumentEvent event) {}
		    public void changedUpdate(DocumentEvent event) { setSumm(); }
		};
		
		comboBox1.addActionListener(fruitListener);
		comboBox2.addActionListener(countryListener);
		comboBox3.addActionListener(deliveryListener);
		txtQun.getDocument().addDocumentListener(listener);
		
		JButton btnNewButton = new JButton("Count up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (label3.getText() != null && label8.getText() != null){
				label.setText(Integer.toString(price + summ) + "$");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(10, 134, 89, 23);
		panel2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("To order");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (label.getText().equals("") || label.getText().equals("0$")){
					JOptionPane.showMessageDialog(null,
					 "Count the summ.",
					 "Error!",
					JOptionPane.WARNING_MESSAGE);
					if (txtFullName.getText().equals("") || txtPhone.getText().equals("") || txtEmail.getText().equals("") || txtOrganization.getText().equals("")){
						JOptionPane.showMessageDialog(null,
						"Fill in all the fields.",
						"Error!",
						JOptionPane.WARNING_MESSAGE);
						if (time_storage < time_delivery+2){
							JOptionPane.showMessageDialog(null,
							"Time storage of fruits less time delivery.",
							"Error!",
							JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else{
					DataBase.addData(txtFullName.getText(), txtPhone.getText(), txtEmail.getText(), (String) comboBox2.getSelectedItem(), txtOrganization.getText(), (String) comboBox1.getSelectedItem());
					DataBase.updateData("fruit", "fruit", "quantity_buy", (String) comboBox1.getSelectedItem(), Integer.parseInt(txtQun.getText()));
					DataBase.updateData("country", "country", "quantity_buy", (String) comboBox2.getSelectedItem(), Integer.parseInt(txtQun.getText()));
					JOptionPane.showMessageDialog(null,
						    "Your order is accepted.");
					
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(316, 294, 89, 23);
		panel2.add(btnNewButton_1);
	}
}

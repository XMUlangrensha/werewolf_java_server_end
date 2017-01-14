package com.langrensha.server;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaServer extends JFrame {

	private static final long serialVersionUID = -901894596867783417L;
	private TextField ipField;
	private TextField portField;
	private TextArea outputArea;
	private TextField idField;

	private Room room;

	public JavaServer() {
		String serverIP = null;
		try {
			InetAddress myComputer = InetAddress.getLocalHost();
			serverIP = myComputer.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		// 布局
		setLayout(new BorderLayout());
		ipField = new TextField(serverIP);
		portField = new TextField("8765");
		ipField.setEditable(false);
		portField.setEditable(false);
		outputArea = new TextArea();
		outputArea.setEditable(false);
		Panel panel = new Panel();
		panel.add(new JLabel("IP:"));
		panel.add(ipField);
		panel.add(new JLabel(" Port:"));
		panel.add(portField);
		add(panel, BorderLayout.NORTH);

		idField = new TextField(10);
		Button button = new Button("yes");
		panel = new Panel();
		panel.add(idField);
		panel.add(button);
		button.addActionListener(l);
		// add(panel, BorderLayout.SOUTH);
		add(outputArea, BorderLayout.CENTER);

		setSize(400, 400);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// game.exitGame();
				System.exit(0);
			}
		});

		// 开启游戏池
		room = new Room(outputArea);
		Thread thead = new Thread(room);
		thead.start();

	}

	private ActionListener l = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int id = Integer.valueOf(idField.getText());
			// game.setTurnId(id);
			System.out.println("确定" + id);
		}
	};

}

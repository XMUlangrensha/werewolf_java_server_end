package com.langrensha.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import com.langrensha.model.Player;

public class ClientFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	String serverIP = "127.0.0.1";
	String myName = "";
	String other;
	// Vector<String> options = new Vector<String>();
	String[] items = { "竞选警长", "发言完毕", "投票", "(警长授权)", "丘比特连情侣", "猎人报复",
			"预言家验人", "盗贼换牌", "女巫救人", "女巫毒人", "狼人杀人" };
	private JTextArea outputArea;
	private JavaClient client;
	JList list;
	private JTextField field1;
	private JTextField field2;
	JButton submitBtn = new JButton("send");

	public ClientFrame(boolean isOwner, String other) {
		// options.addElement("竞选警长");
		// options.addElement("发言完毕");
		// options.addElement("投票");
		// options.addElement("(警长授权)");
		// options.addElement("丘比特连情侣");
		// options.addElement("猎人报复");
		// options.addElement("预言家验人");
		// options.addElement("盗贼换牌");
		// options.addElement("女巫救or毒");
		// options.addElement("狼人杀人");
		initLayout(isOwner, other);
		client = new JavaClient(outputArea, submitBtn);
		client.start(serverIP, myName, isOwner, other);
	}

	public void run() {
		new Thread(client).run();
	}

	private void initLayout(boolean isOwner, String other) {
		/* 布局 */
		setLayout(new BorderLayout());
		final JTextField serverIPField = new JTextField(serverIP);
		final JTextField nameField = new JTextField(2);
		final JTextField otherField = new JTextField(1);
		final JTextArea inputArea = new JTextArea(2, 20);
		outputArea = new JTextArea(10, 30);
		field1 = new JTextField(5);
		field2 = new JTextField(5);

		final JButton setupBtn = new JButton("setup");
		outputArea.setEditable(false);

		Panel panel = new Panel(new GridLayout(5, 2, 0, 3));
		panel.add(new JLabel("Server IP："));
		panel.add(serverIPField);
		panel.add(new JLabel("Your name："));
		panel.add(nameField);
		// authority/room number
		panel.add(new JLabel("Your authority："));
		final JRadioButton ownerRadio = new JRadioButton("房主");
		final JRadioButton guestRadio = new JRadioButton("房客");
		ButtonGroup group = new ButtonGroup();
		group.add(ownerRadio);
		group.add(guestRadio);
		Panel radioPanel = new Panel();
		radioPanel.add(ownerRadio);
		radioPanel.add(guestRadio);
		panel.add(radioPanel);
		panel.add(new JLabel("others："));
		panel.add(otherField);
		panel.add(setupBtn);
		// add(panel, BorderLayout.NORTH);

		panel = new Panel();

		list = new JList<String>(items);
		panel.add(list);
		panel.add(field1);
		panel.add(field2);
		// panel.add(new JLabel("输入："));
		// panel.add(inputArea);
		panel.add(submitBtn);
		add(panel, BorderLayout.SOUTH);

		add(new JScrollPane(outputArea), BorderLayout.CENTER);

		serverIPField.setText(serverIP);
		for (int i = 0; i < 3; i++) {
			char c = 'a';
			c = (char) (c + (int) (Math.random() * 26));
			myName += c;
		}
		nameField.setText(myName);
		if (isOwner)
			ownerRadio.setSelected(true);
		else
			guestRadio.setSelected(true);
		otherField.setText(other);
		/* 设置按钮 */
		setupBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				serverIP = serverIPField.getText().toString();
				String myName = nameField.getText().toString();
				String other = otherField.getText().toString();
				if (ownerRadio.isSelected())
					client.start(serverIP, myName, true, other);
				else if ((guestRadio.isSelected()))
					client.start(serverIP, myName, false, other);
				serverIPField.setEditable(false);
				nameField.setEditable(false);
				setupBtn.setEnabled(false);
			}
		});

		setupBtn.setEnabled(false);

		submitBtn.addActionListener(listener);
	}

	private ActionListener listener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = (String) list.getSelectedValue();
			String value1 = field1.getText().toString();
			String value2 = field2.getText().toString();
			System.out.println(msg + "," + value1);
			if (msg == null)
				JOptionPane.showConfirmDialog(ClientFrame.this, "事件不完全！", "注意",
						JOptionPane.CANCEL_OPTION);
			else {
				if (msg.equals(items[0])) {
					if (value1.equals("1"))
						client.sendElectionAction(true);
					else
						client.sendElectionAction(false);
				} else if (msg.equals(items[1])) {
					client.sendSpeechOver();
				} else if (msg.equals(items[2])) {
					int toVoteId = Integer.valueOf(value1);
					client.sendVoteAction(toVoteId);
				} else if (msg.equals(items[3])) {// 警长
					int newSheriffId = Integer.valueOf(value1);
					client.sendSheriffAction(newSheriffId);
				} else if (msg.equals(items[4])) {// 丘比特
					int firstId = Integer.valueOf(value1);
					int secondId = Integer.valueOf(value2);
					client.sendCupidAction(firstId, secondId);
				} else if (msg.equals(items[5])) {// 猎人
					int toHuntId = Integer.valueOf(value1);
					client.sendHuntAction(toHuntId);
				} else if (msg.equals(items[6])) {// 预言家
					int toSeeId = Integer.valueOf(value1);
					client.sendSeerAction(toSeeId);
				} else if (msg.equals(items[7])) {// 盗贼
					int roleIndex = Integer.valueOf(value1);
					client.sendThiefAction(roleIndex);
				} else if (msg.equals(items[8])) {// 女巫
					int playerId = Integer.valueOf(value1);
					client.sendWitchSaveAction(playerId);
				} else if (msg.equals(items[9])) {// 女巫
					int playerId = Integer.valueOf(value1);
					client.sendWitchPoisonAction(playerId);
				} else if (msg.equals(items[10])) {// 狼人
					int toKillId = Integer.valueOf(value1);
					client.sendWolfAction(toKillId);
				}
			}
		}
	};
}

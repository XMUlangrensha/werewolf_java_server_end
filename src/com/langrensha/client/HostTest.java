package com.langrensha.client;


import javax.swing.JFrame;

public class HostTest {

	static int width = 360;
	static int height = 400;
	static int count = 6;

	public static void main(String[] args) {
		createHost();
	}

	public static void createHost() {
		ClientFrame c = new ClientFrame(true, "" + count);
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setBounds((int) (Math.random() * 1000), 100, width, height);
		c.setVisible(true);
		c.run();
	}

	
}

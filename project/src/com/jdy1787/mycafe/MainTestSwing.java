package com.jdy1787.mycafe;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jdy1787.mycafe.controller.UserController;
import com.jdy1787.mycafe.dto.UserDTO;
import com.jdy1787.mycafe.service.UserService;

public class MainTestSwing extends JFrame implements ActionListener {
	// 이벤트 리스너에 대한 개념을 알자
	private JTextField textFieldId;
	private JPasswordField textFieldPw;
	private JLabel labelTitle;
	private JLabel labelId;
	private JLabel labelPw;
	private JLabel isLogin;

	private JButton button1;
	private JButton button2;
	private JButton myInfoButton;
	
	private Image cloth1;

	
	static String id;
	static String pw;
	UserController userController = new UserController();

	public MainTestSwing() {
		initData();
		setInitLayout();
		addEventListener();
	}
	
	




	public JTextField getTextFieldId() {
		return textFieldId;
	}


	public void setTextFieldId(JTextField textFieldId) {
		this.textFieldId = textFieldId;
	}


	private void initData() {
		setSize(900, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelId = new JLabel("아이디입력 :");
		labelId.setSize(100, 30);
		labelPw = new JLabel("비밀번호 :");
		labelPw.setSize(100, 30);
		textFieldId = new JTextField("", 20);
		textFieldId.setSize(100, 30);
		textFieldPw = new JPasswordField("", 20);
		textFieldPw.setSize(100, 30);
		button1 = new JButton("login");
		button1.setSize(80, 30);
		button2 = new JButton("회원가입");
		button2.setSize(90, 30);
		myInfoButton = new JButton("내정보");
		myInfoButton.setSize(0, 0);
		
		isLogin = new JLabel();
		isLogin.setSize(0, 0);
		
		ImageIcon cloth = new ImageIcon("images/1.png");
		Image cloth1;
	}

	private void setInitLayout() {
		setLayout(null);

		button1.setLocation(610, 99);
		add(button1);

		button2.setLocation(605, 150);
		add(button2);
		
		isLogin.setLocation(520, 100);
		add(isLogin);

		myInfoButton.setLocation(700, 99);
		add(myInfoButton);

		textFieldId.setLocation(480, 100);
		add(textFieldId);

		textFieldPw.setLocation(480, 150);
		add(textFieldPw);

		labelId.setLocation(400, 100);
		add(labelId);

		labelPw.setLocation(400, 150);
		add(labelPw);

		setVisible(true);
	}

	private void addEventListener() {
		// ColorChangeFrame은 다형성이 적용되어서
		// ActionListener 타입으로도 바라볼수 있다.
		button1.addActionListener(this);
		button2.addActionListener(this);
		myInfoButton.addActionListener(this);
	}

	public void login() {

	}

	// code test
	public static void main(String[] args) {

		new MainTestSwing();
	}// end of main

	// actionPerformed 호출되어짐
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button1 && !textFieldId.getText().equals("") && textFieldPw.getText() != null) {
			System.out.println("로그인완료");
			id = textFieldId.getText();
			pw = textFieldPw.getText();
			UserDTO result = userController.requstUserLogin(id, pw);
			
			
			if (result.getId() != 0) {
				this.remove(textFieldId);
				this.remove(textFieldPw);
				button1.setSize(0, 0);
				button2.setSize(0, 0);
				labelId.setSize(0, 0);
				labelPw.setSize(0, 0);
				isLogin.setText(textFieldId.getText()+"님 반갑습니다.");
				isLogin.setSize(150, 30);
				myInfoButton.setSize(90, 30);

			}

		}
		if (e.getSource() == button2) {
			new JoinSwing();
		}

		if (e.getSource() == myInfoButton) {
			new MyInfo();
			dispose();
		}
		

	}
	class MyPanel extends JPanel {
		public MyPanel() {
			setContentPane(new MyPanel()); 
			setSize(250,200);
			setFocusable(true);
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(cloth1, 100, 100, 200, 200, this);
			g.drawRect(90,90,50,50);


		}
	}

}// end of class

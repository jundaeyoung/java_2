package com.jdy1787.mycafe;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jdy1787.mycafe.controller.UserController;
import com.jdy1787.mycafe.dto.UserDTO;
import com.jdy1787.mycafe.service.UserService;

public class MyInfo extends JFrame implements ActionListener {
	// 이벤트 리스너에 대한 개념을 알자
	private JLabel labelTitle;
	private JLabel isLogin;
	private TextArea textArea;
	UserController userController = new UserController();
	MainTestSwing main = new MainTestSwing();
	UserDTO dto = userController.requstUserLogin(main.id, main.pw);

	public MyInfo() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(900, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelTitle = new JLabel("회원정보");
		labelTitle.setSize(300, 100);

		isLogin = new JLabel();
		isLogin.setSize(150, 30);

		textArea = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textArea.setEditable(false);
		textArea.setSize(500, 500);
	}

	private void setInitLayout() {
		setLayout(null);
		labelTitle.setLocation(100, 10);
		labelTitle.setFont(new Font("Serif", Font.BOLD, 30));
		add(labelTitle);

		isLogin.setLocation(520, 100);
		isLogin.setText(main.id + "님 반갑습니다.");
		add(isLogin);

		textArea.setLocation(200, 300);
		add(textArea);
		textArea.append(dto.toString());
		setVisible(true);
	}

	private void addEventListener() {
		// ColorChangeFrame은 다형성이 적용되어서
		// ActionListener 타입으로도 바라볼수 있다.
	}

	public void login() {

	}

	// code test
	public static void main(String[] args) {

		new MyInfo();
	}// end of main

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}// end of class

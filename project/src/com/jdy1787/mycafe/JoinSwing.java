package com.jdy1787.mycafe;

import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jdy1787.mycafe.controller.UserController;
import com.jdy1787.mycafe.dto.UserDTO;
import com.jdy1787.mycafe.service.UserService;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class JoinSwing extends JFrame implements ActionListener {
	// 이벤트 리스너에 대한 개념을 알자
	private JTextField textFieldName;
	private JTextField textFieldId;
	private JPasswordField textFieldPw;
	private JPasswordField checktextFieldPw;
	private JTextField textFieldEmail;
	private JTextField textFieldAddress;
	private JTextField textFieldTel;
	private JLabel labelName;
	private JLabel labelId;
	private JLabel labelPw;
	private JLabel labelPwCheck;
	private JLabel labelEmail;
	private JLabel labelAddress;
	private JLabel labelTel;
	private JButton button1;
	private JButton button2;
	UserController userController = new UserController();
	UserService userService = new UserService();

	public JoinSwing() {
		initData();
		setInitLayout();
		addEventListener();
	}

	private void initData() {
		setSize(680, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelName = new JLabel("이름 입력 :");
		labelName.setSize(100, 30);

		labelId = new JLabel("아이디 입력 :");
		labelId.setSize(100, 30);

		labelPw = new JLabel("비밀번호 :");
		labelPw.setSize(100, 30);

		labelPwCheck = new JLabel("비밀번호 확인 :");
		labelPwCheck.setSize(100, 30);

		labelEmail = new JLabel("email :");
		labelEmail.setSize(100, 30);

		labelAddress = new JLabel("주소 :");
		labelAddress.setSize(100, 30);

		labelTel = new JLabel("전화 번호 :");
		labelTel.setSize(100, 30);

		textFieldName = new JTextField("", 20);
		textFieldName.setSize(100, 30);

		textFieldId = new JTextField("", 20);
		textFieldId.setSize(100, 30);

		textFieldPw = new JPasswordField("", 20);
		textFieldPw.setSize(100, 30);

		checktextFieldPw = new JPasswordField("", 20);
		checktextFieldPw.setSize(100, 30);

		textFieldEmail = new JTextField("", 20);
		textFieldEmail.setSize(100, 30);

		textFieldAddress = new JTextField("", 20);
		textFieldAddress.setSize(100, 30);

		textFieldTel = new JTextField("", 20);
		textFieldTel.setSize(100, 30);

		button1 = new JButton("회원가입 완료");
		button1.setSize(120, 30);

		button2 = new JButton("ID 중복체크");
		button2.setSize(120, 25);

	}

	private void setInitLayout() {
		setLayout(null);

		labelName.setLocation(180, 10);
		add(labelName);

		labelId.setLocation(180, 60);
		add(labelId);

		labelPw.setLocation(180, 110);
		add(labelPw);

		labelPwCheck.setLocation(180, 160);
		add(labelPwCheck);

		labelEmail.setLocation(180, 210);
		add(labelEmail);

		labelAddress.setLocation(180, 260);
		add(labelAddress);

		labelTel.setLocation(180, 310);
		add(labelTel);

		textFieldName.setLocation(280, 10);
		add(textFieldName);

		textFieldId.setLocation(280, 60);
		add(textFieldId);

		textFieldPw.setLocation(280, 110);
		add(textFieldPw);

		checktextFieldPw.setLocation(280, 160);
		add(checktextFieldPw);

		textFieldEmail.setLocation(280, 210);
		add(textFieldEmail);

		textFieldAddress.setLocation(280, 260);
		add(textFieldAddress);

		textFieldTel.setLocation(280, 310);
		add(textFieldTel);

		button1.setLocation(500, 360);
		add(button1);

		button2.setLocation(420, 60);
		add(button2);

		setVisible(true);
	}

	private void addEventListener() {
		// ColorChangeFrame은 다형성이 적용되어서
		// ActionListener 타입으로도 바라볼수 있다.
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	// code test
	public static void main(String[] args) {

		new JoinSwing();
	}// end of main

	// actionPerformed 호출되어짐
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.button1) {
			String name = textFieldName.getText();
			String user_id = textFieldId.getText();
			String password = textFieldPw.getText();
			String email = textFieldEmail.getText();
			String address = textFieldAddress.getText();
			String tel = textFieldTel.getText();

			if (textFieldPw.getText().equals(checktextFieldPw.getText())) {

				int result = userController.requestJoin(name, user_id, password, email, address, tel);

				System.out.println(result);
				dispose();
			} else {
				JOptionPane.showMessageDialog(this.getContentPane(), "비밀번호가 일치하지 않습니다.");

			}
		}

		if (e.getSource() == this.button2) {
			String id = textFieldId.getText();

			String result = userController.requestUserSelect(id);

			if (id.equals(result)) {
				JOptionPane.showMessageDialog(this.getContentPane(), "아이디가 중복됩니다.");
				System.out.println("아이디중복");
			} else {
				JOptionPane.showMessageDialog(this.getContentPane(), "사용가능한 아이디입니다.");
			}
		}

	}

}// end of class

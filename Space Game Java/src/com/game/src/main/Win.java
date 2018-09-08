package com.game.src.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Win extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win frame = new Win();
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
	public Win() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Desktop\\Earth.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBackToEarth = new JLabel("Back to Earth");
		lblBackToEarth.setForeground(new Color(25, 25, 112));
		lblBackToEarth.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 47));
		lblBackToEarth.setBounds(21, 0, 423, 149);
		contentPane.add(lblBackToEarth);
		
		JLabel lblYouWon = new JLabel("YOU WON");
		lblYouWon.setBackground(new Color(135, 206, 235));
		lblYouWon.setForeground(Color.BLUE);
		lblYouWon.setFont(new Font("Algerian", Font.ITALIC, 78));
		lblYouWon.setBounds(65, 185, 359, 91);
		contentPane.add(lblYouWon);
	}
}

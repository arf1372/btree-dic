package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.BoxLayout;

import dictionary.Dictionary;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.StringWriter;

import javax.swing.JList;

public class Graphics extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Dictionary dict;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graphics frame = new Graphics();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(System.err);
					System.exit(-1);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public Graphics() throws Exception {
		try {
			dict = ((Dictionary) (new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(new File(
							".//data//dictionary.dict"))))).readObject());
		} catch (ClassNotFoundException | IOException e) {
			StringBuffer buf = new StringBuffer();
			for (StackTraceElement str : e.getStackTrace())
				buf.append(str.toString() + "\n\t");
			JOptionPane.showMessageDialog(
					null,
					"STH GOES WRONG!!!\n\n" + e.getMessage() + "\n\n"
							+ buf.toString(), "Errors Acoure!",
					JOptionPane.ERROR_MESSAGE);
			 throw e;
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void inputMethodTextChanged(InputMethodEvent event) {
				list.setListData(dict.lookup(((JTextField) event.getSource())
						.getText()));
			}

			@Override
			public void caretPositionChanged(InputMethodEvent event) {
			}
		});
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		list = new JList();
		list.setEnabled(false);
		contentPane.add(list, BorderLayout.CENTER);
	}
}

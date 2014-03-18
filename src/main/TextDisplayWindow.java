package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.TextArea;

@SuppressWarnings("serial")
public class TextDisplayWindow extends JFrame {

	private JPanel contentPane;

	private TextArea textArea_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TextDisplayWindow(String title) {
		setBounds(100, 100, 537, 654);
		contentPane = new JPanel();
		this.setTitle(title);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{166, 100, 0};
		gbl_contentPane.rowHeights = new int[]{243, 100, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 8;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textArea_1 = new TextArea();
		scrollPane.setViewportView(textArea_1);
		

	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public TextArea getTextArea() {
		return textArea_1;
	}
}

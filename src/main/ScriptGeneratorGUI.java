package main;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Component;

import javax.swing.Box;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class ScriptGeneratorGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	JLabel Section1Title;
	JButton btnChooseCsv;
	JLabel csvLabel;
	JButton btnChooseScript;
	JLabel scriptFile;
	JButton btnGenerateText;
	JLabel dotTextLabel;
	JSeparator separator;
	JLabel Section2Title;
	JButton btnGenerateScript;
	JLabel dotScriptLabel;
	JButton btnPreview;
	JTextArea textArea;
	ScriptWindowView view;
	private JLabel csvLabel_1;
	private JLabel scriptFile_1;
	private JTextArea textArea_1;
	private JCheckBox chckbxNewCheckBox;
	private JTextField txtEnterdynamicnametxt;
/*
	  Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScriptGeneratorGUI frame = new ScriptGeneratorGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	/* * Create the frame.
	 */
	public ScriptGeneratorGUI() {
		
		setTitle("Dynamic Text Generator 1.2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 728);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmHelpYoutubeLinks = new JMenuItem("Help Youtube Links");
		mntmHelpYoutubeLinks.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
					view.loadHelpLinksSelected();

			}
		});
		mnNewMenu.add(mntmHelpYoutubeLinks);
		
		JMenuItem mntmHelpTextDocument = new JMenuItem("Help Text Document");
		mntmHelpTextDocument.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				view.loadHelpTextSelected();
			}
		});
		mnNewMenu.add(mntmHelpTextDocument);
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30, 0, 0, 30, 30, 200, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Section1Title_1 = new JLabel("Load Excel & Script File to Generate Text Document");
		GridBagConstraints gbc_Section1Title_1 = new GridBagConstraints();
		gbc_Section1Title_1.gridwidth = 2;
		gbc_Section1Title_1.anchor = GridBagConstraints.NORTH;
		gbc_Section1Title_1.insets = new Insets(0, 0, 5, 5);
		gbc_Section1Title_1.gridx = 1;
		gbc_Section1Title_1.gridy = 0;
		contentPane.add(Section1Title_1, gbc_Section1Title_1);
		
		
		csvLabel_1 = DefaultComponentFactory.getInstance().createLabel("New .csv File");
		GridBagConstraints gbc_csvLabel_1 = new GridBagConstraints();
		gbc_csvLabel_1.anchor = GridBagConstraints.WEST;
		gbc_csvLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_csvLabel_1.gridx = 2;
		gbc_csvLabel_1.gridy = 1;
		contentPane.add(csvLabel_1, gbc_csvLabel_1);
		
		JButton btnChooseCsv_1 = new JButton("Choose  .csv  File");
		btnChooseCsv_1.setToolTipText("<html> Select .csv to use as <br>reference. Dynamic Text Generator <br> \r\n will use .csv to create <br> output, row by row. </html>");
		btnChooseCsv_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					view.csvFileSelected();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnChooseCsv_1 = new GridBagConstraints();
		gbc_btnChooseCsv_1.anchor = GridBagConstraints.EAST;
		gbc_btnChooseCsv_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseCsv_1.gridx = 1;
		gbc_btnChooseCsv_1.gridy = 1;
		contentPane.add(btnChooseCsv_1, gbc_btnChooseCsv_1);

		
		JButton btnChooseScript_1 = new JButton("Choose .script File");
		btnChooseScript_1.setToolTipText("<html> Choose .script file <br>to use to compile text/.csv <br>document..script file specifies <br>instruction for one paragraph <br>of text. Each paragraph corres- <br>ponds to a row (in order!) <br>in the .csv. </html>");
		btnChooseScript_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					view.loadScriptSelected();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnChooseScript_1 = new GridBagConstraints();
		gbc_btnChooseScript_1.anchor = GridBagConstraints.EAST;
		gbc_btnChooseScript_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnChooseScript_1.gridx = 1;
		gbc_btnChooseScript_1.gridy = 2;
		contentPane.add(btnChooseScript_1, gbc_btnChooseScript_1);
		
		scriptFile_1 = DefaultComponentFactory.getInstance().createLabel("New .script File");
		GridBagConstraints gbc_scriptFile_1 = new GridBagConstraints();
		gbc_scriptFile_1.anchor = GridBagConstraints.WEST;
		gbc_scriptFile_1.insets = new Insets(0, 0, 5, 5);
		gbc_scriptFile_1.gridx = 2;
		gbc_scriptFile_1.gridy = 2;
		contentPane.add(scriptFile_1, gbc_scriptFile_1);
		
		JButton btnGenerateText_1 = new JButton("Generate 1 Text File");
		btnGenerateText_1.setToolTipText("Click to make ONE text file with ALL output.");
		btnGenerateText_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					boolean textFile = true;
					boolean consolidatedFile = true;
					view.generateScript(textFile,consolidatedFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateText_1 = new GridBagConstraints();
		gbc_btnGenerateText_1.anchor = GridBagConstraints.WEST;
		gbc_btnGenerateText_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateText_1.gridx = 1;
		gbc_btnGenerateText_1.gridy = 3;
		contentPane.add(btnGenerateText_1, gbc_btnGenerateText_1);
		
		JButton btnGenerateCsvFile = new JButton("Generate CSV File");
		btnGenerateCsvFile.setToolTipText("<html>Click to generate .csv file, <br> it's rows correspond to the <br> original .csv file's rows.</html>");
		btnGenerateCsvFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean textFile = false;
					boolean consolidatedFile = true;
					view.generateScript(textFile,consolidatedFile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateCsvFile = new GridBagConstraints();
		gbc_btnGenerateCsvFile.anchor = GridBagConstraints.WEST;
		gbc_btnGenerateCsvFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateCsvFile.gridx = 2;
		gbc_btnGenerateCsvFile.gridy = 3;
		contentPane.add(btnGenerateCsvFile, gbc_btnGenerateCsvFile);
		
		JButton btnNewButton_1 = new JButton("Generate N Text Files");
		btnNewButton_1.setToolTipText("Click to make a text file for each row in the .csv");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				boolean textFile = true;
				boolean consolidatedFile = false;
				try {
					view.generateScript(textFile,consolidatedFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		txtEnterdynamicnametxt = new JTextField();
		txtEnterdynamicnametxt.setToolTipText("<html>Enter name of title. <br>To retrieve values from <br> the .csv enter columnn number <br>inbetween the '#' symbol <br> i.e. report#1#</html>");
		txtEnterdynamicnametxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.textFieldPressed();
			}
		});
		txtEnterdynamicnametxt.setText("<Insert title for N files>");
		GridBagConstraints gbc_txtEnterdynamicnametxt = new GridBagConstraints();
		gbc_txtEnterdynamicnametxt.insets = new Insets(0, 0, 5, 5);
		gbc_txtEnterdynamicnametxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterdynamicnametxt.gridx = 2;
		gbc_txtEnterdynamicnametxt.gridy = 4;
		contentPane.add(txtEnterdynamicnametxt, gbc_txtEnterdynamicnametxt);
		txtEnterdynamicnametxt.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridheight = 2;
		gbc_horizontalStrut.gridwidth = 4;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 5;
		contentPane.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel Section2Title_1 = new JLabel("Generate and Preview New Script File");
		GridBagConstraints gbc_Section2Title_1 = new GridBagConstraints();
		gbc_Section2Title_1.gridwidth = 2;
		gbc_Section2Title_1.insets = new Insets(0, 0, 5, 5);
		gbc_Section2Title_1.gridx = 1;
		gbc_Section2Title_1.gridy = 6;
		contentPane.add(Section2Title_1, gbc_Section2Title_1);
		
		JButton btnPreview_1 = new JButton("Preview");
		btnPreview_1.setToolTipText("<html>Select to output a same row of <br>given .csv and .script selection.</html>");
		btnPreview_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					view.previewScriptSpecification();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnPreview_1 = new GridBagConstraints();
		gbc_btnPreview_1.anchor = GridBagConstraints.WEST;
		gbc_btnPreview_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPreview_1.gridx = 1;
		gbc_btnPreview_1.gridy = 7;
		contentPane.add(btnPreview_1, gbc_btnPreview_1);
		
		chckbxNewCheckBox = new JCheckBox("Skip first row");
		chckbxNewCheckBox.setToolTipText("<html>MAKE SURE TO SELECT <br>IF FIRST ROW OF CSV <br> IS NOT DATA (i.e. labels)</html>");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 7;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JButton btnGenerateScript_1 = new JButton("Generate .script File");
		btnGenerateScript_1.setToolTipText("<html>Write contents of text <br>area to .script file for use <br>with this program.</html>");
		btnGenerateScript_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					view.saveScriptSpecification();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateScript_1 = new GridBagConstraints();
		gbc_btnGenerateScript_1.anchor = GridBagConstraints.WEST;
		gbc_btnGenerateScript_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenerateScript_1.gridx = 1;
		gbc_btnGenerateScript_1.gridy = 9;
		contentPane.add(btnGenerateScript_1, gbc_btnGenerateScript_1);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.setToolTipText("Clear text area.\r\n");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				view.refreshScriptPreview();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 9;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	public void setView(ScriptWindowView newView){
		  view=newView;
	}

	public JLabel getCsvLabel_1() {
		return csvLabel_1;
	}
	public JLabel getScriptFile_1() {
		return scriptFile_1;
	}
	public JTextArea getTextArea_1() {
		return textArea_1;
	}
	public JCheckBox getChckbxNewCheckBox() {
		return chckbxNewCheckBox;
	}
	public JTextField getNameOfNTextFiles() {
		return txtEnterdynamicnametxt;
	}
}

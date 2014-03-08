<<<<<<< HEAD
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
		
		setTitle("Dynamic Text Generator 1.1");
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
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30, 0, 30, 30, 200, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Section1Title_1 = new JLabel("Load Excel & Script File to Generate Text Document");
		GridBagConstraints gbc_Section1Title_1 = new GridBagConstraints();
		gbc_Section1Title_1.gridwidth = 2;
		gbc_Section1Title_1.anchor = GridBagConstraints.NORTH;
		gbc_Section1Title_1.insets = new Insets(0, 0, 5, 5);
		gbc_Section1Title_1.gridx = 1;
		gbc_Section1Title_1.gridy = 0;
		contentPane.add(Section1Title_1, gbc_Section1Title_1);
		
		
		csvLabel_1 = new JLabel("New .csv File");
		GridBagConstraints gbc_csvLabel_1 = new GridBagConstraints();
		gbc_csvLabel_1.anchor = GridBagConstraints.WEST;
		gbc_csvLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_csvLabel_1.gridx = 2;
		gbc_csvLabel_1.gridy = 1;
		contentPane.add(csvLabel_1, gbc_csvLabel_1);
		
		
		JButton btnChooseCsv_1 = new JButton(" Choose  .csv  File");
		btnChooseCsv_1.setToolTipText("Select .csv to use as reference. Dynamic Text Generator \n will use .csv to create output, row by row.");
		btnChooseCsv_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					view.csvFileSelected();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
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
		btnChooseScript_1.setToolTipText("Choose .script file to use to compile text/.csv document.\r\n.script file specifies instruction for one paragraph of text.\r\nEach paragraph corresponds to a row (in order!) in the .csv.\r\n");
		btnChooseScript_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					view.loadScriptSelected();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
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
		
		scriptFile_1 = new JLabel("New .script File");
		GridBagConstraints gbc_scriptFile_1 = new GridBagConstraints();
		gbc_scriptFile_1.anchor = GridBagConstraints.WEST;
		gbc_scriptFile_1.insets = new Insets(0, 0, 5, 5);
		gbc_scriptFile_1.gridx = 2;
		gbc_scriptFile_1.gridy = 2;
		contentPane.add(scriptFile_1, gbc_scriptFile_1);
		
		JButton btnGenerateText_1 = new JButton("Generate Text File");
		btnGenerateText_1.setToolTipText("Make sure you have selected .csv & .script file.\r\nClick 'Generate Text File' to make text file \r\nthat contains the output.");
		btnGenerateText_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					boolean textFile = true;
					view.generateScript(textFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
		btnGenerateCsvFile.setToolTipText("Make sure you have selected .csv & .script file.\r\nClick 'Generate CSV File' to make .csv file \r\nthat contains the output.");
		btnGenerateCsvFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean textFile = false;
					view.generateScript(textFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateCsvFile = new GridBagConstraints();
		gbc_btnGenerateCsvFile.anchor = GridBagConstraints.EAST;
		gbc_btnGenerateCsvFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateCsvFile.gridx = 2;
		gbc_btnGenerateCsvFile.gridy = 3;
		contentPane.add(btnGenerateCsvFile, gbc_btnGenerateCsvFile);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridheight = 2;
		gbc_horizontalStrut.gridwidth = 4;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 4;
		contentPane.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel Section2Title_1 = new JLabel("Generate and Preview New Script File");
		GridBagConstraints gbc_Section2Title_1 = new GridBagConstraints();
		gbc_Section2Title_1.gridwidth = 2;
		gbc_Section2Title_1.insets = new Insets(0, 0, 5, 5);
		gbc_Section2Title_1.gridx = 1;
		gbc_Section2Title_1.gridy = 5;
		contentPane.add(Section2Title_1, gbc_Section2Title_1);
		
		JButton btnPreview_1 = new JButton("Preview");
		btnPreview_1.setToolTipText("Select to output a same row of \r\ngiven .csv and .script selection.");
		btnPreview_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					view.previewScriptSpecification();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnPreview_1 = new GridBagConstraints();
		gbc_btnPreview_1.anchor = GridBagConstraints.WEST;
		gbc_btnPreview_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPreview_1.gridx = 1;
		gbc_btnPreview_1.gridy = 6;
		contentPane.add(btnPreview_1, gbc_btnPreview_1);
		
		chckbxNewCheckBox = new JCheckBox("Skip first row");
		chckbxNewCheckBox.setToolTipText("MAKE SURE TO SELECT \r\nIF FIRST ROW OF CSV\r\nIS NOT DATA");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 6;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JButton btnGenerateScript_1 = new JButton("Generate .script File");
		btnGenerateScript_1.setToolTipText("Write contents of text area\r\nto .script file for use with \r\nthis program.");
		btnGenerateScript_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					view.saveScriptSpecification();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateScript_1 = new GridBagConstraints();
		gbc_btnGenerateScript_1.anchor = GridBagConstraints.WEST;
		gbc_btnGenerateScript_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenerateScript_1.gridx = 1;
		gbc_btnGenerateScript_1.gridy = 8;
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
		gbc_btnNewButton.gridy = 8;
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
}
=======
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
		
		setTitle("Dynamic Text Generator 1.1");
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
		gbl_contentPane.rowHeights = new int[] {30, 30, 30, 30, 0, 30, 30, 200, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
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
		
		JButton btnChooseCsv_1 = new JButton(" Choose  .csv  File");
		btnChooseCsv_1.setToolTipText("Select .csv to use as reference. Dynamic Text Generator \n will use .csv to create output, row by row.");
		btnChooseCsv_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					view.csvFileSelected();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
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
		btnChooseScript_1.setToolTipText("Choose .script file to use to compile text/.csv document.\r\n.script file specifies instruction for one paragraph of text.\r\nEach paragraph corresponds to a row (in order!) in the .csv.\r\n");
		btnChooseScript_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					view.loadScriptSelected();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
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
		
		JButton btnGenerateText_1 = new JButton("Generate Text File");
		btnGenerateText_1.setToolTipText("Make sure you have selected .csv & .script file.\r\nClick 'Generate Text File' to make text file \r\nthat contains the output.");
		btnGenerateText_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					boolean textFile = true;
					view.generateScript(textFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
		btnGenerateCsvFile.setToolTipText("Make sure you have selected .csv & .script file.\r\nClick 'Generate CSV File' to make .csv file \r\nthat contains the output.");
		btnGenerateCsvFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					boolean textFile = false;
					view.generateScript(textFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateCsvFile = new GridBagConstraints();
		gbc_btnGenerateCsvFile.anchor = GridBagConstraints.EAST;
		gbc_btnGenerateCsvFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateCsvFile.gridx = 2;
		gbc_btnGenerateCsvFile.gridy = 3;
		contentPane.add(btnGenerateCsvFile, gbc_btnGenerateCsvFile);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.gridheight = 2;
		gbc_horizontalStrut.gridwidth = 4;
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 4;
		contentPane.add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel Section2Title_1 = new JLabel("Generate and Preview New Script File");
		GridBagConstraints gbc_Section2Title_1 = new GridBagConstraints();
		gbc_Section2Title_1.gridwidth = 2;
		gbc_Section2Title_1.insets = new Insets(0, 0, 5, 5);
		gbc_Section2Title_1.gridx = 1;
		gbc_Section2Title_1.gridy = 5;
		contentPane.add(Section2Title_1, gbc_Section2Title_1);
		
		JButton btnPreview_1 = new JButton("Preview");
		btnPreview_1.setToolTipText("Select to output a same row of \r\ngiven .csv and .script selection.");
		btnPreview_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					view.previewScriptSpecification();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnPreview_1 = new GridBagConstraints();
		gbc_btnPreview_1.anchor = GridBagConstraints.WEST;
		gbc_btnPreview_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnPreview_1.gridx = 1;
		gbc_btnPreview_1.gridy = 6;
		contentPane.add(btnPreview_1, gbc_btnPreview_1);
		
		chckbxNewCheckBox = new JCheckBox("Skip first row");
		chckbxNewCheckBox.setToolTipText("MAKE SURE TO SELECT \r\nIF FIRST ROW OF CSV\r\nIS NOT DATA");
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 6;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JButton btnGenerateScript_1 = new JButton("Generate .script File");
		btnGenerateScript_1.setToolTipText("Write contents of text area\r\nto .script file for use with \r\nthis program.");
		btnGenerateScript_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					view.saveScriptSpecification();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGenerateScript_1 = new GridBagConstraints();
		gbc_btnGenerateScript_1.anchor = GridBagConstraints.WEST;
		gbc_btnGenerateScript_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnGenerateScript_1.gridx = 1;
		gbc_btnGenerateScript_1.gridy = 8;
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
		gbc_btnNewButton.gridy = 8;
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
}
>>>>>>> 50449ff1e48a7f941f5ef1bc54501ac8cdae3266

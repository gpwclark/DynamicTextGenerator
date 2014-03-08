package main;

import java.awt.Component;
import java.awt.Dimension;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import au.com.bytecode.opencsv.CSVWriter;


public class Controller {
	ScriptGeneratorModel model;
	ScriptWindowView view;
	ScriptGeneratorGUI gui;
	boolean errorWindowDisplayed = false;
		public Controller(ScriptGeneratorModel newModel, ScriptWindowView newView){
			model=newModel;
			view=newView;
		}
		
	public void setGui(ScriptGeneratorGUI newGui){
		gui=newGui;
	}
	public void selectFile() throws FileNotFoundException {
		//done through JfileChooser I guess
		model.loadCSV();
		String fileNameOfCsv = "whaaat"; //means nothing now
		view.displayPreviewSelection(fileNameOfCsv);
		
	}
	public void loadScript() throws FileNotFoundException {
		//done through FileChooser I guess
		model.loadScript();
		String fileNameOfScript = "whaaat"; // means nothing now
		view.displayPreviewSelection(fileNameOfScript);
		
	}
	public void generateText(boolean generateFullScriptWithTextFile, boolean textFile) throws IOException {
		errorWindowDisplayed = false;
		if(model.hasCsvAndScript()){
		int matrixIndex=0;
		if(view.getCheckBox().isSelected()){
			matrixIndex=1;
		}
		gui.getTextArea_1().setText("");
			while(matrixIndex<model.getCsvMatrix().size()){
				
	 			int scriptIndex=0;
	 			String currentScript = "";
				while(scriptIndex<model.getScript().size()){
					String currentLine = model.getScript().get(scriptIndex);
					currentLine = currentLine.trim();
	 				if(isIntChecker(currentLine)){
	 					
	 					currentScript=currentScript + model.getCsvElement(matrixIndex, Integer.parseInt(currentLine)-1) + " ";
	 				
	 				}else{
	 					if(currentLine.charAt(0) == '_'){
	 						currentScript = currentScript + dynamicOutputHandler(currentLine,matrixIndex) + " ";
	 					}else if(currentLine.charAt(0) == '*'){
	 						//TODO setting up functionality
	 						int colNumber = getColumnNumber(currentLine);
	 						currentScript = currentScript + model.getCsvElement(matrixIndex, colNumber-1) + " ";
	 					}else{
	 						currentScript = currentScript + currentLine + " ";
	 					}
	 					
	 				}
	 				scriptIndex++;
	 			}
				String currentText = gui.getTextArea_1().getText();
				gui.getTextArea_1().setText(currentText + currentScript + System.getProperty("line.separator") + System.getProperty("line.separator"));
				if(!generateFullScriptWithTextFile){
//					System.out.println("AHHHH");
					break;
				}
				matrixIndex++;
			}
			if(textFile && generateFullScriptWithTextFile){
				saveTextDoc(gui.getTextArea_1().getText());
			}if(!textFile && generateFullScriptWithTextFile){
				saveCsvDoc(gui.getTextArea_1().getText());
			}
		}else{
			displayErrorWindow("ERROR: Must load a .csv and a .script files");
		}
			
			
	}
	
	private String dynamicOutputHandler(String currentLine,int matrixIndex){
		int valueToSearchWith = 0;
		try{
			valueToSearchWith = Integer.parseInt(model.getCsvElement(matrixIndex, getColumnNumber(currentLine)-1));
		}catch(NumberFormatException e){
			if(!errorWindowDisplayed){
				displayErrorWindow("Error: Check CSV File, finding String and expecting number");
				errorWindowDisplayed = true;
			}
		}
		
		int index=0;
		while(currentLine.charAt(index)!=' '){
			index++;
		}
		index++;
		currentLine = currentLine.substring(index);
		
		String delims = "[_]+";
		String[] tokens = currentLine.split(delims);
		
		//tokens has the string

		int j=0;
		while(j<tokens.length){
//			System.out.println(tokens[j]);
			if(isIntChecker(tokens[j])){
				if(Integer.parseInt(tokens[j])==valueToSearchWith){
					return tokens[j+1];
				}
			}
			j++;
		}
		return " [**ERROR::MATCH NOT FOUND**] ";
	}

	private boolean isIntChecker(String stringToCheck){
		boolean isInt;
		try{
			 Integer.parseInt(stringToCheck);
			 isInt=true;
			} catch (NumberFormatException e) {
			  isInt=false;
			}
		return isInt;
	}
	public int getColumnNumber(String currentLine){
		int index=0;
		String value="";
		while((index<currentLine.length())&&(currentLine.charAt(index)!=' ')){ 
			char currentCharacter = currentLine.charAt(index); 
			if(currentCharacter=='_' || currentCharacter=='*'){}
			else{
				value+=currentCharacter;
			}
//			System.out.println("index: " + index);
		index++;
		}
		
		return(Integer.parseInt(value));
	}

	public void saveScript(String[] scriptContents) throws IOException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"SCRIPT Files", "script"		);
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showSaveDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File fileName = new File(chooser.getSelectedFile() + ".script") ;
			BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			int i=0;
			while(i<scriptContents.length){
				outFile.write(scriptContents[i]+ "\n");
				i++;
			}
			outFile.flush();
			outFile.close();
		}
	}
	
	public void saveTextDoc(String textContents) throws IOException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"TEXT Files", "txt"		);
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showSaveDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			File fileName = new File(chooser.getSelectedFile() + ".txt") ;
			BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			outFile.write(textContents);
			outFile.flush();
			outFile.close();
		}
	}
	
	public void saveCsvDoc(String textContents) throws IOException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"CSV Files", "csv"		);
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showSaveDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
//			File fileName = new File(chooser.getSelectedFile() + ".csv") ;
			CSVWriter writer2 = new CSVWriter(new FileWriter(chooser.getSelectedFile() + ".csv"), '\t');
			
			
		    
			String delims = "[\\r\\n]+";
			String[] tokens = textContents.split(delims);

		    String[] wrap = new String[1]; //probably saving on GC

		    for (String s: tokens) {
		      wrap[0]=s;
		      writer2.writeNext(wrap);
		    }
		    writer2.close();
			
			
//			outFile.write(textContents);
//			outFile.flush();
//			outFile.close();
		}
	}
	
	public void refreshPreview() {
		view.clearpreview();
		
	}
	public void displayErrorWindow(String error){
		final JFrame parent = new JFrame();
		parent.getContentPane().setPreferredSize(new Dimension(500, 200));
		JLabel label = new JLabel();
		label.setText(error);
		parent.add(label);
		parent.setSize(100,100);
		parent.pack();
		parent.setVisible(true);
	}
	public void csvNameChange(String newName) {
		view.csvNameChange(newName);
	}
	public void scriptNameChange(String newName) {
		view.scriptNameChange(newName);	
	}
	public JCheckBox getCheckBox(){
		return view.getCheckBox();
	}
	
	public void loadHelpLinksWindow() {

		try {
			TextDisplayWindow frame = new TextDisplayWindow("Help Links Window");
			String text = ScriptGeneratorModel.getHelpLinks(frame);
			frame.getTextArea().setText(text);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}



}

public void loadHelpTextWindow() {

		try {
			TextDisplayWindow frame = new TextDisplayWindow("Help Doc Window");
			frame.getTextArea().setText(ScriptGeneratorModel.getHelpText(frame));
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}



}
	
	
}

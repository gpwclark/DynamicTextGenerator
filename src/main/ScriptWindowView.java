package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

/*
 * This class is the nuts and bolts for how the GUI interfaces with the rest of the program. Any time a change occurs,
 * the View sends the information and, on some occasions, gets output and displays it to the viewer.
*/public class ScriptWindowView {
	
	ScriptWindowViewObserver observer;
	Controller controller;
	ScriptGeneratorGUI gui;
	//Constructor
	public ScriptWindowView(ScriptWindowViewObserver newObserver){
		observer=newObserver;
		
	}
	public void setGui(ScriptGeneratorGUI newGui){
		gui=newGui;
	}
	public void setController(Controller newController){
		controller=newController;
	}
	
	public void csvFileSelected() throws FileNotFoundException{
		observer.fileSelectionFire();
		
	}
	public void loadScriptSelected() throws FileNotFoundException{
		observer.scriptSelectionFire();
	}
	public void generateScript(boolean textFile,boolean consolidated) throws IOException{
		observer.generateScriptFire(textFile,consolidated);
	}
	public void saveScriptSpecification() throws IOException{
		
		String[] lines = gui.getTextArea_1().getText().split("\\n");
		observer.saveScriptFire(lines);
	}
	
	public void previewScriptSpecification() throws IOException{
		observer.previewScriptFile();
	}
	public void refreshScriptPreview(){
		observer.refreshPreviewFire();
	}

	public void clearpreview() {
		gui.getTextArea_1().setText("");
	}
	public void csvNameChange(String newName) {
		gui.getCsvLabel_1().setText(newName);
	}
	public void scriptNameChange(String newName) {
		gui.getScriptFile_1().setText(newName);
		
	}
	public JCheckBox getCheckBox(){
		return gui.getChckbxNewCheckBox();
	}
	
	public void loadHelpLinksSelected() {
		observer.HelpLinksSelectedFire();
		
	}
	public void loadHelpTextSelected() {
		observer.HelpTextSelectedFire();
	}
	public JTextField getNameOfNTextFiles() { //TODO
		return gui.getNameOfNTextFiles();
	}
	public void textFieldPressed() {
		observer.textFieldPressedFire();
		
	}

	
}

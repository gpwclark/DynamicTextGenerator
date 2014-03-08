package main;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ScriptWindowViewObserver {
	Controller controller;
	
	public void setController(Controller newController) {
		controller = newController;
		
	}
	
	public void fileSelectionFire() throws FileNotFoundException {
		controller.selectFile();
		
	}

	public void scriptSelectionFire() throws FileNotFoundException {
		controller.loadScript();
		
	}

	public void generateScriptFire(boolean textFile) throws IOException {
		boolean generateFullScriptWithTextFile = true;
		controller.generateText(generateFullScriptWithTextFile,textFile);
		
	}

	public void saveScriptFire(String[] scriptContents) throws IOException {
		controller.saveScript(scriptContents);
		
	}

	public void previewScriptFile() throws IOException {
		boolean generateOneLineOfScriptOutputInPreview=true;
		//Ignore next step, value of above boolean is for communicative value, the binary logic of the 
		//function requires I make one false.
		generateOneLineOfScriptOutputInPreview=!generateOneLineOfScriptOutputInPreview;
		controller.generateText(generateOneLineOfScriptOutputInPreview,true);
		
	}

	public void refreshPreviewFire() {
		controller.refreshPreview();
		
	}
	
	public void HelpLinksSelectedFire() {
		// TODO Auto-generated method stub
		controller.loadHelpLinksWindow();
		
	}

	public void HelpTextSelectedFire() {
		// TODO Auto-generated method stub
		controller.loadHelpTextWindow();
	}


	
	
	
	
}

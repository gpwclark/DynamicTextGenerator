package main;

import java.awt.EventQueue;
/**
 * @author gpwclark 
 * @email gpwclark at <gmail> dot com
 * Dynamic Text From CSV Generator
 *
 */

public class Main {
	public static void main(String[] args){
	final ScriptWindowView myview;
	ScriptWindowViewObserver observer;
	observer = new ScriptWindowViewObserver();
	myview = new ScriptWindowView(observer);
			
		final Controller mycontroller;
		ScriptGeneratorModel mymodel;

		mymodel = new ScriptGeneratorModel();
		mycontroller = new Controller(mymodel,myview);
		observer.setController(mycontroller);
		mymodel.setController(mycontroller);
		myview.setController(mycontroller);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScriptGeneratorGUI frame = new ScriptGeneratorGUI();
					frame.setVisible(true);
					frame.setView(myview);
					myview.setGui(frame);
					mycontroller.setGui(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
	}
}

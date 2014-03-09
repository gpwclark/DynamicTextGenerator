<<<<<<< HEAD
package main;

import java.awt.EventQueue;

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


>>>>>>> 50449ff1e48a7f941f5ef1bc54501ac8cdae3266

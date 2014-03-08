<<<<<<< HEAD
package main;

import java.awt.Component;
//import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import au.com.bytecode.opencsv.CSVReader;

import java.io.InputStream;
//import java.net.URL;

public class ScriptGeneratorModel {
	Controller controller;
	File script;
	int rowsInCsv;
	String csvFileName;
	boolean hasCsv=false;
	boolean hasScript=false;
	CSVReader reader;
	List<String[]> csvMatrix;
	ArrayList<String> scriptList = new ArrayList<String>();
	
	
	public void setController(Controller newController){
		controller=newController;
	}
	
	public boolean hasCsvAndScript(){
		if(hasCsv=true && hasScript==true){
			return true;
		}else{
			return false;
		}
		
	}

	public void loadCSV() throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"CSV Files", "csv"		);
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showOpenDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			String newName = chooser.getSelectedFile().getName();
			setCsv(chooser.getSelectedFile());
	//		System.out.println("You chose to open this file: " + newName);   
			setCsvFileName(newName);
			hasCsv=true;
		}
	}
	
	public void setCsv(File newFile) throws FileNotFoundException {
		reader=new CSVReader(new FileReader(newFile));
	    try {
	    	csvMatrix = reader.readAll(); 
	    	int i=0;
	    	while(i<csvMatrix.size()){
	    		int j=0;
	    		while(j<csvMatrix.get(i).length){
//	    			System.out.print(csvMatrix.get(i)[j] + " - " + i + "," + j + " :: " );
	    			j++;
	    		}
//	    		System.out.println(" ");
//	    		System.out.println(" ");
	    		i++;
	    	}
		}catch (IOException e) {e.printStackTrace();}
	    
	}
	
	public List<String[]> getCsvMatrix(){
		return csvMatrix;
	}
	
	public String getCsvElement(int i, int j){
//		System.out.println("row: "+ i + " :: " + "col: " + j);
		return getCsvMatrix().get(i)[j];
	}
	
	public void loadScript() throws FileNotFoundException {
		//TODO load script into script array
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"SCRIPT Files", "script");
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showOpenDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			String newName = chooser.getSelectedFile().getName();
	//		System.out.println("You chose to open this file: " + newName);   
			setScriptFileName(newName);
			setScript(chooser.getSelectedFile());
			hasScript=true;
		}
		
	}

	public void setScript(File newScript) throws FileNotFoundException{
		script=newScript;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(script);
		//scanner.useDelimiter("line.separator");
		scriptList = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String tempVar = scanner.nextLine();
//			System.out.println(tempVar);
			scriptList.add(tempVar);
		}
	}
	public ArrayList<String> getScript(){
		return scriptList; 
	}

	public void setCsvFileName(String newFileName){
		controller.csvNameChange(newFileName);
	}
	public void setScriptFileName(String newFileName){
		controller.scriptNameChange(newFileName);
	}

	public static String getFileByName(String fileName) throws IOException{
		fileName = "/" + fileName;
		InputStream is = ScriptGeneratorModel.class.getResourceAsStream(fileName);
		
		//InputStream input = new URL("/docs/HELP.txt").openStream();
		//InputStream ins = ScriptGeneratorModel.class.getClassLoader().getResourceAsStream("/docs/HELP.txt");
		byte[] b = new byte[is.available()];
		is.read(b);
		String text = new String(b);
		//BufferedReader reader = new BufferedReader(input);
		//String line = br.readLine();
		//StringBuilder helpText = new StringBuilder();
		
//        while (line != null) {
//            helpText.append(line);
//            helpText.append(System.lineSeparator());
//            line = br.readLine();
//        }
//
//		return helpText.toString();
		return text.toString();
	}
	
}
=======
package main;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import au.com.bytecode.opencsv.CSVReader;
import java.io.InputStream;

public class ScriptGeneratorModel {
	Controller controller;
	File script;
	int rowsInCsv;
	String csvFileName;
	boolean hasCsv=false;
	boolean hasScript=false;
	CSVReader reader;
	List<String[]> csvMatrix;
	ArrayList<String> scriptList = new ArrayList<String>();
	
	
	public void setController(Controller newController){
		controller=newController;
	}
	
	public boolean hasCsvAndScript(){
		if(hasCsv=true && hasScript==true){
			return true;
		}else{
			return false;
		}
		
	}

	public void loadCSV() throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"CSV Files", "csv"		);
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showOpenDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			String newName = chooser.getSelectedFile().getName();
			setCsv(chooser.getSelectedFile());
	//		System.out.println("You chose to open this file: " + newName);   
			setCsvFileName(newName);
			hasCsv=true;
		}
	}
	
	public void setCsv(File newFile) throws FileNotFoundException {
		reader=new CSVReader(new FileReader(newFile));
	    try {
	    	csvMatrix = reader.readAll(); 
	    	int i=0;
	    	while(i<csvMatrix.size()){
	    		int j=0;
	    		while(j<csvMatrix.get(i).length){
//	    			System.out.print(csvMatrix.get(i)[j] + " - " + i + "," + j + " :: " );
	    			j++;
	    		}
//	    		System.out.println(" ");
//	    		System.out.println(" ");
	    		i++;
	    	}
		}catch (IOException e) {e.printStackTrace();}
	    
	}
	
	public List<String[]> getCsvMatrix(){
		return csvMatrix;
	}
	
	public String getCsvElement(int i, int j){
//		System.out.println("row: "+ i + " :: " + "col: " + j);
		return getCsvMatrix().get(i)[j];
	}
	
	public void loadScript() throws FileNotFoundException {
		//TODO load script into script array
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"SCRIPT Files", "script");
		chooser.setFileFilter(filter);
		Component parent = null;
		int returnVal = chooser.showOpenDialog(parent);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			String newName = chooser.getSelectedFile().getName();
	//		System.out.println("You chose to open this file: " + newName);   
			setScriptFileName(newName);
			setScript(chooser.getSelectedFile());
			hasScript=true;
		}
		
	}

	public void setScript(File newScript) throws FileNotFoundException{
		script=newScript;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(script);
		//scanner.useDelimiter("line.separator");
		scriptList = new ArrayList<String>();
		while(scanner.hasNextLine()){
			String tempVar = scanner.nextLine();
//			System.out.println(tempVar);
			scriptList.add(tempVar);
		}
	}
	public ArrayList<String> getScript(){
		return scriptList; 
	}

	public void setCsvFileName(String newFileName){
		controller.csvNameChange(newFileName);
	}
	public void setScriptFileName(String newFileName){
		controller.scriptNameChange(newFileName);
	}

	public static String getHelpText(TextDisplayWindow window) throws IOException{
		InputStream ins = ScriptGeneratorModel.class.getClassLoader().getResourceAsStream("/HELP.txt");
		byte[] b = new byte[ins.available()];
		ins.read(b);
		String text = new String(b);
		StringBuilder helpText = new StringBuilder();

	            helpText.append(text);
	        
		
		return helpText.toString();
	}
	
	public static String getHelpLinks(TextDisplayWindow window) throws IOException{
		InputStream ins = ScriptGeneratorModel.class.getClassLoader().getResourceAsStream("/links.txt");
		byte[] b = new byte[ins.available()];
		ins.read(b);
		String text = new String(b);
		StringBuilder helpText = new StringBuilder();

	            helpText.append(text);
	        
		
		return helpText.toString();
	}
	
	
}
>>>>>>> 50449ff1e48a7f941f5ef1bc54501ac8cdae3266

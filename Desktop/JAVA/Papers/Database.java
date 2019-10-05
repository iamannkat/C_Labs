import java.util.Scanner;

import javax.print.DocFlavor.STRING;
import javax.print.attribute.HashDocAttributeSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;

public class Database 
{
	private ArrayList<Entry> paperList = new ArrayList<Entry>();

	public void createDB(String filename) throws FileNotFoundException{
		HashMap<String,Entry>  List = new HashMap<String,Entry>();

		Scanner input = new Scanner(new FileInputStream(filename)); 
		
		while(input.hasNextLine()){
			String title = input.nextLine();
			//System.out.println("the title is : " +title);
			
			String names = input.nextLine();
			//System.out.println("the names are:  " +names);

			String conf = input.nextLine();
			//System.out.println("the conf is :  " + conf);
			
			String date = input.nextLine();
			//System.out.println("the date is :  "+ date); 
			
			String[] name = names.split(",");
			//System.out.println(name[0]);
			//System.out.println(name[1]);
			String name1 = name[0];
			String name2 = name[1];
			
			Researcher r1 = new Researcher(name1);
			Researcher r2 = new Researcher(name2);
			Conference conference = new Conference(conf);
			Paper p1 = new Paper(title,date,conf);
		
			p1.addAuthor(r1);
			p1.addAuthor(r2);
			r1.addPaper(p1);
			r2.addPaper(p1);
			conference.addPaper(p1);
			
			paperList.add(r1);
			paperList.add(r2);
			paperList.add(conference);
			paperList.add(p1);

			List.put(name1,r1);
			List.put(name2,r2);
			List.put(conf,conference);
			
			p1.addText(name1); p1.addText(name2); p1.addText(conf); p1.addText(title); p1.addText(date);
			r1.addText(name1); r1.addText(title);
			r2.addText(name2); r2.addText(title); 
			conference.addText(conf);
		}
		input.close();
		
	}
	public void printDB(){
		for (Entry x: paperList){
			x.display(); 
		}
	}
	
	public static void main(String[] args){
		//Import file from command line.
		Database myDatabase = new Database();
		try{
			if (0 < args.length) {
				String filename = args[0];
				myDatabase.createDB(filename);
				myDatabase.printDB();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Yo, I didn't find the file. Try again and peace out!");
			System.exit(0);
		}
	}
	
}

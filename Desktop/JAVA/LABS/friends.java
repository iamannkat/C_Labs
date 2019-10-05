import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

class FriendList
{
	public static HashMap<String,ArrayList<String>> readInput(String filename) throws FileNotFoundException{
		//Scanner input = null;
		Scanner input = new Scanner(new FileInputStream(filename)); 
		HashMap<String,ArrayList<String>> myFriends= new HashMap<String,ArrayList<String>>();
		while (input.hasNextLine()){
			String line = input.nextLine();
			String[] friends = line.split("\t");
			String name = friends[0];
			String name2 = friends[1];
			if (myFriends.containsKey(name)){
				myFriends.get(name).add(friends[1]);
			}else{
				ArrayList<String> friendList = new ArrayList<String>();
				friendList.add(friends[1]);
				myFriends.put(name,friendList);	
			}
			//here
			if (myFriends.containsKey(name2)){
				myFriends.get(name2).add(friends[0]);
			}else{
				ArrayList<String> friendList = new ArrayList<String>();
				friendList.add(friends[0]);
				myFriends.put(name2,friendList);	
			}
		}
		input.close();
		return myFriends;
	}
	
	public static void writeOutput(String filename,HashMap<String,ArrayList<String>> allfriends) throws FileNotFoundException{
		PrintWriter output = new PrintWriter(new FileOutputStream(filename));
		//allfriends.keySet();
		for (String x: allfriends.keySet()){
			output.print(x+": ");
			for (String z: allfriends.get(x)){
				output.print(z+" ");
			}
			output.print("\n");
		}
		output.close();
		
	}
	public static void main(String[] args){
		FriendList friend = new FriendList();
		try
		{
			friend.writeOutput("output.txt", friend.readInput("input.txt"));	
		}catch(FileNotFoundException e)
		{	
			System.out.println("you fucked up!");
			System.exit(0);		
		}
		
	}
}

import java.util.ArrayList;

class Paper extends Entry
{
	private String title;
	private String year;
	private ArrayList<Researcher> authorList = new ArrayList<Researcher>();
	private String conf;
	
	public Paper(String title, String year,String conf){
		this.title = title;
		this.year = year;
		this.conf = conf;
	}
	
	public void addAuthor(Researcher r){
		authorList.add(r);
	}
	
	public String toString(){
		return  "'"+ title + "'" + ". " + authorList.get(0)+", " + authorList.get(1)+ ", "+ conf + " " + year ; 

	}
	
	public void display(){
		System.out.println("Paper: " +"'" + title + "'"); 
		System.out.print("Authors: ");
		for (int i=0; i< authorList.size(); i++){
			Researcher a = authorList.get(i);
			System.out.print(a+ ", ");
		}
		System.out.println();
		System.out.println("Conference: "+ conf + " " + year);
		System.out.println();

	}
} 
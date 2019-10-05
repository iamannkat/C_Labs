import java.util.ArrayList;

class Conference extends Entry
{
	private String name;
	private ArrayList<Paper> paperList = new ArrayList<Paper>();
	
	public Conference(String name){
		this.name = name;
	}

	public void addPaper(Paper c){
		paperList.add(c);
	}
	
	public String toString(){
		return name;
	}
	
	public void display(){
		System.out.println("Conference: " + name);
		System.out.println("Papers: ");
		for (int i=0; i< paperList.size(); i++){
			Paper p = paperList.get(i);
			System.out.println("\t"+p);
			System.out.println(); 
		}
	}
}
import java.util.ArrayList;

class Researcher extends Entry
{
	private String name;
	private ArrayList<Paper> paperList = new ArrayList<Paper>();
	
	public Researcher(String name){
		this.name = name;
	}
	
	public void addPaper(Paper p){
		paperList.add(p);
	}
	
	public String toString(){
		return name;
	}
	
	public void display(){
		System.out.println("Researcher: " + name);
		System.out.println("Papers: ");
		for (int i=0; i< paperList.size(); i++){
			Paper p = paperList.get(i);
			System.out.println("\t" + p);
			System.out.println();
		}
	}
}
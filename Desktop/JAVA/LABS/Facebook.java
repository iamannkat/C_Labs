
import java.util.ArrayList;
class Post
{
	private String username;
	private String text;
	private int shares;

	public Post(String username, String text){
		this.username = username;
		this.text = text;
	}

	public String toString(){
		return username + ": " + " " + text;
	}

	public void display(){
		System.out.println(toString());
		System.out.println(shares + " Shares" + "\n");
	}

	public void setShares(int s){
		this.shares = s;
	}

	public int getShares(){
		return shares;
	}
}

class VideoPost extends Post
{
	private String video;

	public VideoPost(String username , String text , String video){
		super(username,text);
		this.video = video;
	}

	public String toString(){
		return (super.toString() + " " + video);
	}
} 

class SharedPost extends Post
{
	private Post original;
	

	public SharedPost(String username, String text, Post original){
		super(username,text);
		this.original = original;
		original.setShares(original.getShares() + 1);
	}

	public SharedPost(String username, Post original){
		super(username, "");
		this.original = original;
		original.setShares(original.getShares() + 1);
	}
	public String toString(){
		return (super.toString() + " " + "Shared: " + original +"\n");
	}	
}

class FaceBook
{
	public static void displayPosts(ArrayList<Post> posts){
		for (Post x: posts){
			x.display();
		}
		
	}

	public static void main(String[] args){
		ArrayList<Post> posts = new ArrayList<Post>();
		posts.add(new Post("Helen", "Hello World!"));
		posts.add(new VideoPost("Frank" , "Funny!", "Cat video"));
		posts.add(new SharedPost("George" , "LOL!!!", posts.get(1)));
		posts.add(new SharedPost("Henry" , posts.get(1)));
		displayPosts(posts);
		
	}
}


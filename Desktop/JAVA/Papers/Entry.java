 import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;

abstract class Entry
{
	private HashMap<String,Integer> tokenMap = new HashMap<String,Integer>();

	public HashMap<String,Integer> getTokenMap(){
		return tokenMap;
	}

	public void addText(String text){
		text.toLowerCase();
		String words[] = text.split(" ");
		int k =1;
		//int all = 0;
		for (int i =0; i<words.length; i++){
			if (tokenMap.containsKey(words[i])){
				tokenMap.put(words[i], tokenMap.get(words[i]) + k);
			}else{
				tokenMap.put(words[i], k);
			}
		}
	}

	public Collection<Integer> getTokens(){
		return tokenMap.values();
		/**for (String key: tokenMap.keySet()){
			String[] keys = new String[key];
		}**/
	}
	public abstract void display();
	
}
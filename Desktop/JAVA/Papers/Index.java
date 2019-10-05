import java.util.HashMap;
import java.util.HashSet;

class Index extends Entry
{
    private HashMap<String,HashSet<Entry>> index = new HashMap<String,HashSet<Entry>>();

    public void indexDB(Database data){ 
        for(String key: data.TokenMap.keySet()){
            
        }
    }
}

import java.util.HashMap;

public class LRUCacheV1 {
    
    private HashMap<Integer, Integer> mem;
    private HashMap<Integer, Integer> lruKeyCountMap;
    private int lastInsertedKey;
    private int capacity;
    
    public LRUCacheV1(int capacity) {
        this.capacity = capacity;
        mem = new HashMap<Integer,Integer>(capacity);
        lruKeyCountMap = new HashMap<Integer,Integer>();
    }
    
    public int get(int key) {
        //return mem.get(key) == null ? -1 : mem.get(key);
        if(mem.containsKey(key)) {
            //System.out.println("lrukey" + LRUKey);
            if(!lruKeyCountMap.containsKey(key)) {
	        	lruKeyCountMap.put(key,1);
	        }
	        else {
            	lruKeyCountMap.put(key,lruKeyCountMap.get(key) + 1 );
	        }
            //System.out.println( mem.get(key));
            return mem.get(key);
        }
        else {
            //System.out.println(-1);
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(mem.size() == capacity && !mem.containsKey(key)) {
            mem.remove(getLRUKey());
            //System.out.println("deleted " + get(getLRUKey()) + "lrukey " + getLRUKey());
        }
        mem.put(key,value);
        lastInsertedKey = key;
    }
    
    private int getLRUKey() {
        if(lruKeyCountMap.size() == 0) {
            return lastInsertedKey;
        }
    	class hmComp implements Comparator<Map.Entry<Integer,Integer>> {
            public int compare(Map.Entry<Integer, Integer> o1,
                    Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        }
    	ArrayList list = new ArrayList( lruKeyCountMap.entrySet() );
    	Collections.sort(list, new hmComp());
    	int lruKey = ((Map.Entry<Integer, Integer>)list.get(0)).getKey();
    	return lruKey;
    }
}

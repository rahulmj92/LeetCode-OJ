import java.util.*;

public class LRUCacheV2 {
    
    private HashMap<Integer, Integer> mem;
    private ArrayList<Integer> lruKeyOrder;
    private int capacity;
    
    public LRUCacheV2(int capacity) {
        this.capacity = capacity;
        mem = new HashMap<Integer,Integer>(capacity);
        lruKeyOrder = new ArrayList<Integer>();
    }
    
    public int get(int key) {
        //return mem.get(key) == null ? -1 : mem.get(key);
        if(mem.containsKey(key)) {
            rearrangeKeyAccessOrder(key);
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
        	int LRUKey = getnRemLRUKey();
            mem.remove(LRUKey);
            //System.out.println("deleted " + get(LRUKey) + " :: lrukey " + LRUKey);
        }
        rearrangeKeyAccessOrder(key);
        mem.put(key,value);
    }
    
    private int getnRemLRUKey() {
    	//int size = lruKeyOrder.size();
    	int lruKey = lruKeyOrder.get(0);
    	lruKeyOrder.remove(0);
    	return lruKey;
    }
    
    private void rearrangeKeyAccessOrder(int key){
        lruKeyOrder.remove((Integer )key);
        lruKeyOrder.add(key);
    	//System.out.println("rearranged list : " + lruKeyOrder.toString());
    }
}

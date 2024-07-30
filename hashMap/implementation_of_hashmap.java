package hashMap;

import java.util.LinkedList;

public class implementation_of_hashmap {


    public static class MyHashMap<K , V>{
        public static final int DEFAULT_CAPACITY = 4;
        public static final float DEFAULT_LOAD_FACTOR = 0.75f;

        private class Node{
            K key;
            V value;

            Node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }

        private LinkedList<Node> [] buckets;
        private int n;

        
        
        
        private void initBuckets(int N){
            buckets = new LinkedList[N];
            for(int i = 0; i < buckets.length ; i++){
                buckets[i] = new LinkedList<>();
            }
        }
        
        private int searchInBucket(LinkedList<Node> ll ,K key){
            for(int i = 0 ; i < ll.size() ; i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }
        
        public MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }
        private int hashFunc(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }
        public int size(){
            return n;
        }
        private void rehash(){

            LinkedList<Node>[] oldBucket = buckets;
            initBuckets(oldBucket.length * 2);
            n =0;
            for(var bucket : oldBucket){
                for(var node : bucket){
                    put(node.key, node.value);
                }
            }

        }

        public int capacity(){
            return buckets.length;
        }
        public float loadFactor(){
            return ((n * 1.0f) / buckets.length);
        }

        public void put(K key , V value){
            int bi = hashFunc(key);

            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket , key);
            if(ei == -1){
                Node node = new Node(key , value);
                currBucket.add(node);
                n++;
            }else {
                Node cuurNode = currBucket.get(ei);
                cuurNode.value = value;
            }

            if(n >= buckets.length * DEFAULT_LOAD_FACTOR){
                rehash();
            }
        }

        public V get(K key){
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket , key);
            if(ei == -1) return null;
            return currBucket.get(ei).value;
        }

        public V remove(K key){
            int bi = hashFunc(key);
            LinkedList<Node> currBucket = buckets[bi];
            int ei = searchInBucket(currBucket , key);
            if(ei == -1) return null;
            Node currNode = currBucket.get(ei);
            n--;
            return currBucket.remove(ei).value;
        }

    }
    



    public static void main(String[] args) {
        MyHashMap<String , Integer> mh = new MyHashMap<>();
        System.out.println("Testing add");
        mh.put("a", 1);
        mh.put("b", 2);
        mh.put("c", 3);
        mh.put("d", 4);
        mh.put("e", 5);
        mh.put("f", 6);
        mh.put("g", 7);
        mh.put("h", 8);
        mh.put("i", 9);
        System.out.println("Testing remove");
        // System.out.println(mh.remove("c"));
        System.out.println("Testing size");
        System.out.println(mh.size());
        System.out.println("Testing get");
        System.out.println("get " + mh.get("a"));
        System.out.println("get " + mh.get("b"));
        System.out.println("get " + mh.get("c"));
        System.out.println("get " + mh.get("d"));
        System.out.println("get " + mh.get("e"));
        System.out.println("get " + mh.get("f"));
        System.out.println("get " + mh.get("g"));
        System.out.println("get " + mh.get("h"));
        System.out.println("get " + mh.get("i"));

        System.out.println("Testing update");
        System.out.println(mh.get("a"));
    }
}
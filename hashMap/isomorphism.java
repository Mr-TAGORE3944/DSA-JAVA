package hashMap;

import java.util.HashMap;
import java.util.HashSet;

public class isomorphism {
    

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character , Character > mp = new HashMap<>();
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(mp.size() == 0) mp.put(s.charAt(i), t.charAt(i));
            else{
                // if(mp.get(s.charAt(i)) != t.charAt(i)) return false;
                if(mp.containsKey(s.charAt(i))){
                    if(mp.get(s.charAt(i)) != t.charAt(i)) return false;
                }
                else if(hs.add(t.charAt(i))) return false;
                else{
                    mp.put(s.charAt(i), t.charAt(i));
                    hs.add(t.charAt(i));
                }
            }
        }
        return true;
    }
}

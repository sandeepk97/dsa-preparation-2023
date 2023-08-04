import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day17 {
	
// 	DAY 17
// Design HashMap
// TODO

// Ransom Note
class q2 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        
        for (int i=0;i<ransomNote.length();i++) {
            ch1[ransomNote.charAt(i) - 'a']++;
        }
        
        for (int i=0;i<magazine.length();i++) {
            ch2[magazine.charAt(i) - 'a']++;
        }
        
        for (int i=0;i<26;i++) {
            if (ch1[i] > ch2[i])
                return false;
        }
        
        return true;
    }
}

// Contains Duplicate
// Contains Duplicate II
// Jewels and Stones
// Unique Number of Occurrences
class q6 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int num: arr) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> s = new HashSet<>(hm.values());
        return s.size() == hm.size();
    }
}
}

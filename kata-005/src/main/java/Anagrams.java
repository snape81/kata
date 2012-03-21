import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

public class Anagrams {

    /**
     * You need to read the wordlist common-passwords.txt containing one word per line, find all the
     * anagram of the given word (the word itself excluded) and return a set of the words found
     *
     * @param word the word you have to find the anagrams
     * @return a Set<String> with the anagrams found
     */

    public Set<String> findAnagrams(String word) {
        Set<String> resultSet = new TreeSet<String>();
        try {
            Properties prop = new Properties();
            
            prop.load(this.getClass().getResourceAsStream("common-passwords.txt"));

            HashMap<Character,Integer> wordAnalysysMap = getAnalysysMap(word);

            for (Object key : prop.keySet()) {
                String chiaveAttuale = (String) key;
                if (chiaveAttuale.length() == word.length() ) {
                    HashMap<Character,Integer> currentAnalysysMap = getAnalysysMap(chiaveAttuale);
                    if(!word.equals(chiaveAttuale) && hashEqualsWord(wordAnalysysMap,currentAnalysysMap)) {
                        resultSet.add(chiaveAttuale);
                    }
                }
            }
            
        } catch (IOException ignore) {
        }

        return resultSet;
    }

    private HashMap<Character,Integer> getAnalysysMap(String word) {
        HashMap<Character,Integer> mappaToFill = new HashMap<Character, Integer>();
        for(int i = 0; i < word.length(); i++) {
            int charCounter = 0;
            if (!mappaToFill.containsKey(word.charAt(i))) {
                for(int j = i; j<word.length(); j++) {
                    if (word.charAt(j) == word.charAt(i)) {
                        charCounter++;
                    }
                }
                mappaToFill.put(word.charAt(i),charCounter);
            }
        }
        return mappaToFill;
    }
    


    private boolean hashEqualsWord(HashMap<Character,Integer> hashMap1,HashMap<Character,Integer> hashMap2) {
        for (Character character : hashMap1.keySet()) {
            if (!hashMap2.containsKey(character)) {
               return false;
            } else {
                if (!hashMap1.get(character).equals(hashMap2.get(character))) {
                   return false;
                }
            }
        }
        return true;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
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
            InputStream in = ClassLoader.getSystemResourceAsStream("common-passwords.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
            HashMap<Character,Integer> wordAnalysysMap = getAnalysysMap(word);

            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.length() == word.length() ) {
                    HashMap<Character,Integer> currentAnalysysMap = getAnalysysMap(strLine);
                    if(!word.equals(strLine) && hashEqualsWord(wordAnalysysMap,currentAnalysysMap)) {
                        resultSet.add(strLine);
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

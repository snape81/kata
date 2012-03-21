import java.util.Comparator;

public class SoftwareVersionComparator implements Comparator<String> {

    /**
     * Compares two software version strings. Software versions are made of
     * a maximum of 5 integers separated by dots. For example these are all
     * allowed version numbers:
     *
     * <ul>
     *     <li>3</li>
     *     <li>1.9.2</li>
     *     <li>3.0.678.34.9</li>
     * </ul>
     *
     * @param version1 first version String
     * @param version2 second version String
     * @return a negative integer if version1 is smaller than version2,
     *         zero if version1 equals version2, a positive integer
     *         if version1 is greater than version 2
     */
    @Override
    public int compare(String version1, String version2) {
       if (version1.equals(version2)) return 0;
       String[] version1Array = version1.split("\\.");
       String[] version2Array = version2.split("\\.");
       int length = version1Array.length < version2Array.length ? version1Array.length : version2Array.length;
       for (int i=0; i<length; i++) {
           if (!version1Array[i].equals(version2Array[i])) {
               if ((Integer.valueOf(version1Array[i])) < (Integer.valueOf(version2Array[i]))) {
                       return -1;
               } else {
                   return 1;
               }
              
          } 
       }
      if (version1Array.length<version2Array.length) {
          return -1;
      } else {
          return 1;
      }
    }


}

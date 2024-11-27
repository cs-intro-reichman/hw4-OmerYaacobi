import javax.print.DocFlavor.STRING;

/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        char [] arr3 = {'a'};
        char [] arr4 = {'l','e','m','o','n'};
        char[] arr5 = "You are a wizard Harry.".toCharArray();
        char [] empty = {};

        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(equals(arr1, arr2));
        System.out.println(equals(arr1, arr1));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
        System.out.println(hashCode(arr3));
        System.out.println(hashCode(arr4));
        System.out.println(indexOf(arr5, 'w'));
        System.out.println(indexOf(arr5, 'w', 5));
        System.out.println(indexOf(arr5, 'w' , 12));
        System.out.println(indexOf(arr5, 'g'));
        System.out.println(indexOf(empty, 'w'));
        System.out.println(lastIndexOf(arr5, 'r'));
        System.out.println(lastIndexOf(arr5, 'B'));
        
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
    String str = new String (arr);
   char c = str.charAt(index);
        return c;
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        String str1 = new String (arr1);
        String str2 = new String (arr2);
        if (str1.equals(str2)) {
            return true;
        }
        else {
        return false;
        }
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {

        String str = new String(arr);
        return str.indexOf(ch);
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        
        String str = new String(arr);
        str = str.substring(fromIndex);
        if (str.indexOf(ch) == -1) {
            return -1;
        }
        return (str.indexOf(ch) + fromIndex);
        
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        // Replace the following statement with your code
        int n = arr.length;
        char [] arrRev = new char[n];
        for (int i = 0; i < n; i++){
        arrRev [i] = arr [n - i - 1];
        }
        String rev = new String(arrRev);
        if (rev.indexOf(ch) == -1) {
            return -1;
        }
        return (rev.length() - rev.indexOf(ch) - 1);
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        // Replace the following statement with your code
        int n = arr1.length;
        int m = arr2.length;
        char [] con = new char[n + m];
        for (int i = 0; i < n; i++){
            con [i] = arr1 [i];
        }
        for (int i = 0; i < m; i++){
            con [n+i] = arr2 [i];
        }
        return con;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        String str = new String(arr);
        str = str.substring(beginIndex, endIndex);
        char [] subbed = str.toCharArray();
        return subbed;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {
        // Replace the following statement with your code
        if (arr == null) {
            return 0;
        }
        double n = arr.length;
        long sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr [i] * Math.pow(7 , n - 1 - i);
           
        }
        return sum;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        // Replace the following statement with your code
        if (str1.equals(str2) == true){
        return 0;}
        if (str1.length() == 0 || str2.length() == 0){
            return -2;
        }
        
        char [] arr1 = str1.toCharArray();
        char [] arr2 = str2.toCharArray();
        int n = arr1.length;
        int m = arr2.length;
        int minLength = Math.min(n, m);
        for (int i = 0; i < minLength; i++){
            if (charAt(arr1, i) != charAt(arr2, i)){
                return charAt(arr1, i) < charAt(arr2, i) ? -1 : 1;
            }
        }
        if (n < m) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

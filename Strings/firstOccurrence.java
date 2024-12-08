public class FirstOccurrence {

    public static int firstOccurrence(String haystack, String needle) {
        // Use the indexOf method to find the index of the first occurrence of needle in
        // haystack
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        int index = firstOccurrence(haystack, needle);
        System.out.println("The index of the first occurrence is: " + index); // Output: 2
    }
}

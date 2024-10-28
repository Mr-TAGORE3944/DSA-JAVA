public class IntegerToRoman {
    public String intToRoman(int num) {
        // Define Roman numeral values and their corresponding symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();

        // Build the Roman numeral string
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }
        
        return roman.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman converter = new IntegerToRoman();
        int number = 1994; // Should return "MCMXCIV"
        String romanNumeral = converter.intToRoman(number);
        System.out.println("The Roman numeral for " + number + " is: " + romanNumeral);
    }
}

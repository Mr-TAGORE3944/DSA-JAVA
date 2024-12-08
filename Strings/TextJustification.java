import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static List<String> justifyText(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int lineLength = words[index].length();
            int last = index + 1;

            // Determine how many words can fit in the current line
            while (last < words.length) {
                if (lineLength + words[last].length() + 1 > maxWidth)
                    break;
                lineLength += words[last].length() + 1;
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;

            // If this line is the last line or only one word fits, left-justify
            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i < last - 1)
                        line.append(" ");
                }
                while (line.length() < maxWidth)
                    line.append(" ");
            } else {
                // Fully justify the line
                int totalSpaces = maxWidth - lineLength + (numberOfWords - 1);
                int spaceBetweenWords = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int i = index; i < last - 1; i++) {
                    line.append(words[i]);
                    for (int j = 0; j <= spaceBetweenWords + (i - index < extraSpaces ? 1 : 0); j++) {
                        line.append(" ");
                    }
                }
                line.append(words[last - 1]);
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
        int maxWidth = 16;

        List<String> justifiedText = justifyText(words, maxWidth);
        for (String line : justifiedText) {
            System.out.println("\"" + line + "\"");
        }
    }
}

class WordEncoder {
    String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            result.append(sb);
            if (i < words.length - 1)
                result.append(" ");
        }
        return result.toString();
    }
}
public class Word {
    public static void main(String[] args) {
        WordEncoder obj = new WordEncoder();
        System.out.println(obj.reverseEachWord("hello club"));
    }
}
import java.util.*;
class WordFrequency {
    void printFilteredWordFrequency(String feedback) {
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");
        String[] words = feedback.split("\\s+");
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            boolean stop = false;
            for (String sw : stopWords) {
                if (word.equals(sw)) {
                    stop = true;
                    break;
                }
            }
            if (!stop)
                map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : list)
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
public class Frequency {
    public static void main(String[] args) {
        WordFrequency obj = new WordFrequency();
        obj.printFilteredWordFrequency(
            "The mentor was great, the session was great and clear."
        );
    }
}
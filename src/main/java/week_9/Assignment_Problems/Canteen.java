import java.util.HashMap;
public class Canteen {
    static void mostPopular(String[] orders) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String item : orders) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        String popular = orders[0];
        int maxCount = map.get(popular);
        for (String item : orders) {
            if (map.get(item) > maxCount) {
                popular = item;
                maxCount = map.get(item);
            }
        }
        System.out.println("(" + popular + ", " + maxCount + ")");
    }
    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };
        mostPopular(orders);
    }
}
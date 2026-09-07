class MovieTicket {
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}
public class Movie {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public"))
            return "ALLOWED";

        if (fieldModifier.equals("private"))
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("default"))
            return accessorContext.equals("SAME_CLASS") ||
                   accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";

        if (fieldModifier.equals("protected"))
            return accessorContext.equals("SAME_CLASS") ||
                   accessorContext.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";

        return "DENIED";
    }
    static String summarizeBatch(String[][] attempts) {
        int a = 0, d = 0;
        for (String[] x : attempts) {
            if (classifyAccess(x[0], x[1]).equals("ALLOWED"))
                a++;
            else
                d++;
        }
        return "Allowed: " + a + " | Denied: " + d;
    }
    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        String[][] x = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeBatch(x));
    }
}
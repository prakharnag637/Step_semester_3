class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}
public class Membership {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public"))
            return "ALLOWED";
        if (fieldModifier.equals("private"))
            return accessorContext.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("default"))
            return (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        if (fieldModifier.equals("protected"))
            return (accessorContext.equals("SAME_CLASS") ||
                    accessorContext.equals("SAME_PACKAGE")) ? "ALLOWED" : "DENIED";
        return "DENIED";
    }
    static String summarizeByModifier(String[][] attempts) {
        String[] mods = {"private", "default", "protected", "public"};
        String result = "";
        for (String mod : mods) {
            int allowed = 0, denied = 0;
            for (String[] a : attempts) {
                if (a[0].equals(mod)) {
                    if (classifyAccess(a[0], a[1]).equals("ALLOWED"))
                        allowed++;
                    else
                        denied++;
                }
            }
            if (!result.equals(""))
                result += " | ";

            result += mod + ": " + allowed + " allowed / " + denied + " denied";
        }
        return result;
    }
    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(attempts));
    }
}
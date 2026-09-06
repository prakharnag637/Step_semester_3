class ISBN {
    String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() < 3)
            return code.toUpperCase();
        String pub = code.substring(0, 3).toUpperCase();
        return pub + code.substring(3);
    }
    String validateAndFormat(String code) {
        if (code.length() != 13)
            return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i)))
                return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i)))
                return "Invalid: body must contain only digits";
        }
        String pub = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(pub);
        sb.append("] YEAR: ");
        sb.append(year);
        sb.append(" | CATALOG: ");
        sb.append(catalog);
        return sb.toString();
    }
}
public class Library {
    public static void main(String[] args) {
        ISBN obj = new ISBN();
        String code = obj.normalizeCode(" pen2026004251 ");
        System.out.println(obj.validateAndFormat(code));
        code = obj.normalizeCode("12N2026004251");
        System.out.println(obj.validateAndFormat(code));
    }
}
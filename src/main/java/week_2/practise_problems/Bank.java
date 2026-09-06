class Transaction {
    String normalizeReference(String raw) {
        String ref = raw.trim();
        if (ref.length() < 3)
            return ref.toUpperCase();
        String code = ref.substring(0, 3).toUpperCase();
        return code + ref.substring(3);
    }
    String validateAndFormat(String reference) {
        if (reference.length() != 14)
            return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i)))
                return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i)))
                return "Invalid: body must contain only digits";
        }
        String bank = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String seq = reference.substring(9, 14);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(bank);
        sb.append("] DATE: ");
        sb.append(date.substring(0, 2));
        sb.append("/");
        sb.append(date.substring(2, 4));
        sb.append("/");
        sb.append(date.substring(4, 6));
        sb.append(" | SEQ: ");
        sb.append(seq);
        return sb.toString();
    }
}
public class Bank {
    public static void main(String[] args) {
        Transaction obj = new Transaction();
        String ref = obj.normalizeReference(" hdf03022600042 ");
        System.out.println(obj.validateAndFormat(ref));
        ref = obj.normalizeReference("12F03022600042");
        System.out.println(obj.validateAndFormat(ref));
    }
}
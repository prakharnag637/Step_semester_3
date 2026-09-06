class PinValidator {
    void checkPinLength(String pin) {
        if (pin.length() != 4)
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        else
            System.out.println("PIN length OK.");
    }
}

public class ATM {
    public static void main(String[] args) {
        PinValidator obj = new PinValidator();

        obj.checkPinLength("482");
        obj.checkPinLength("4820");
    }
}
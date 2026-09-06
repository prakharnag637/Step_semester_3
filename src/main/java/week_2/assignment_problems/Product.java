class Inventory {
    void parseInventoryRecord(String csvLine) {
        String[] data = csvLine.split(",");
        if (data.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.println("Product: " + data[0] +
                           " | SKU: " + data[1] +
                           " | Qty: " + data[2]);
    }
}
public class Product {
    public static void main(String[] args) {
        Inventory obj = new Inventory();
        obj.parseInventoryRecord("Wireless Mouse,WM-2201,150");
        obj.parseInventoryRecord("Wireless Mouse,150");
    }
}
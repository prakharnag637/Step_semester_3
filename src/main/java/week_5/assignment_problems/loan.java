class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = bookIds.clone();
    }
    public String[] getBookIds() {
        return bookIds.clone();
    }
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] ids = bookIds.clone();
        ids[index] = newId;
        return new LoanReceipt(memberId, ids);
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;
    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds,
                                    String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}
class CirculationLedger {
    static String branchCode;
    static {
        branchCode = "PTL-001";
    }
    static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0;
        int referenceOnly = 0, regular = 0;
        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt)
                referenceOnly++;
            else
                regular++;
        }
        return processed + " processed | " + nullSkipped +
               " null skipped | " + referenceOnly +
               " reference-only | " + regular + " regular";
    }
}
public class loan {
    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-100", "BK-101"}
        );
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);
        LoanReceipt corrected =
                r.withCorrectedBookId(1, "BK-102");
        for (String id : r.getBookIds())
            System.out.print(id + " ");
        System.out.println();
        for (String id : corrected.getBookIds())
            System.out.print(id + " ");
        System.out.println();
        LoanReceipt[] receipts = {
            new ReferenceOnlyLoanReceipt(
                    "LIB-001",
                    new String[]{"BK-200"},
                    "Reading Room 3"
            ),
            null,
            new LoanReceipt(
                    "LIB-002",
                    new String[]{"BK-201"}
            )
        };
        System.out.println(
                CirculationLedger.processNightlyCirculation(receipts)
        );
    }
}
class PayrollAccount {
    private double basicSalary;
    private double bonus;
    PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Invalid basic salary");
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }
    void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: invalid amount");
        } else {
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }
    void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: invalid percentage");
        } else {
            basicSalary -= basicSalary * percent / 100;
            System.out.println("Tax deducted: " + percent + "%");
        }
    }
    double getNetSalary() {
        return basicSalary + bonus;
    }
}
public class Payroll {
    public static void main(String[] args) {
        PayrollAccount p = new PayrollAccount(50000);
        p.creditBonus(5000);
        p.deductTax(10);
        System.out.println("Net salary: Rs " + p.getNetSalary());
    }
}
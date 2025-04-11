public class EMICalculator {
    public static void main(String[] args) {
        // Input variables
        double principal = 170000; // Loan amount
        double annualInterestRate = 9; // Annual interest rate in percentage
        int months = 12; // Loan tenure in months

        // Call methods to calculate EMI and Bullet Repayment
        //calculateEMI(principal, annualInterestRate, months);
        calculateBulletRepayment(principal, annualInterestRate, months);
    }

    // Method to calculate and print EMI details
    public static void calculateEMI(double principal, double annualInterestRate, int months) {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) /
                (Math.pow(1 + monthlyInterestRate, months) - 1);
        double totalPayment = emi * months;

        System.out.printf("Option 1 - EMI (Monthly Payment): ₹%.2f%n", emi);
        System.out.printf("  - Total Payment (EMI * Months): ₹%.2f%n", totalPayment);
    }

    // Method to calculate and print Bullet Repayment details
    public static void calculateBulletRepayment(double principal, double annualInterestRate, int months) {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        double monthlyInterest = principal * monthlyInterestRate;
        double totalBulletRepayment = (monthlyInterest * months) + principal;

        System.out.printf("Option 2 - Bullet Repayment:%n");
        System.out.printf("  - Monthly Interest Payment: ₹%.2f%n", monthlyInterest);
        System.out.printf("  - Final Lump Sum Payment After %d Months: ₹%.2f%n", months, principal);
        System.out.printf("  - Total Payment (Interest + Principal): ₹%.2f%n", totalBulletRepayment);
    }
}

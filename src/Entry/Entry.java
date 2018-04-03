package Entry;

import Calculate.Calculate;

public class Entry
{
    private double principle;
    private double minPayment;
    private double interest;
    private int iterations;
    private String endDate;

    public Entry(double principle, double minPayment, double interest)
    {
        this.principle = principle;
        this.minPayment = minPayment;
        this.interest = interest;
        iterations = 0;
        endDate = "";
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getMinPayment() {
        return minPayment;
    }

    public void setMinPayment(double minPayment) {
        this.minPayment = minPayment;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public static void createEntry(String[] entryString)
    {
        Entry entry = new Entry(Double.parseDouble(entryString[0]), Double.parseDouble(entryString[1]), Double.parseDouble(entryString[2]));
        Calculate.getInitialDebtEntries().add(entry);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "principle=" + principle +
                ", minPayment=" + minPayment +
                ", interest=" + interest +
                ", iterations=" + iterations +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}

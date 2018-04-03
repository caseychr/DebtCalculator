package Calculate;

import Entry.Entry;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;

public abstract class Calculate
{

    private static double totalEndDate;
    private static double totalPrinciplePaid;
    private static double totalInterestPaid;
    private static ArrayList<Entry> initialDebtEntries = new ArrayList<>();

    public static double getTotalEndDate() {
        return totalEndDate;
    }

    public static void setTotalEndDate(double totalEndDate) {
        Calculate.totalEndDate = totalEndDate;
    }

    public static ArrayList<Entry> getInitialDebtEntries()
    {
        return initialDebtEntries;
    }

    public static void getCompletionDate(Entry entry)
    {
        int iterations = entry.getIterations();
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int year = date.getYear();

        iterations += month;
        int addYears = iterations/12;
        year += addYears;

        String monthString = null;
        int addMonths = iterations%12;
        monthString = intToMonth(addMonths);
        if(monthString.equals("DECEMBER"))
            year -= 1;

        entry.setEndDate(monthString+" "+year);
    }

    private static String getCompletionDate(int iteration)
    {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int year = date.getYear();

        iteration += month;
        int addYears = iteration/12;
        year += addYears;

        String monthString = null;
        int addMonths = iteration%12;
        monthString = intToMonth(addMonths);
        if(monthString.equals("DECEMBER"))
            year -= 1;

        return monthString+" "+year;
    }

    public static double getTotalPrinciplePaid() {
        return totalPrinciplePaid;
    }

    public static double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    public abstract void calculate();
    public abstract void printResults();
    public abstract void execute();

    public static void printResults(ArrayList<Entry> debts)
    {
        double totalMinPayment = 0;
        System.out.println("Regular Debt Payoff Results: ");
        //getInitialEntries().sort(Calculate.BY_PRINCIPLE);
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat dfInt = new DecimalFormat("#.####");
        for(int i=0;i<debts.size();i++)
        {
            System.out.println("Entry "+i+" Principle: "+df.format(debts.get(i).getPrinciple())+" Minimum Payment: "+
                    df.format(debts.get(i).getMinPayment())+" Interest Rate: "+
                    dfInt.format(debts.get(i).getInterest())+" Iterations: "+debts.get(i).getIterations()+
                    " End Date: "+debts.get(i).getEndDate());
            totalMinPayment += debts.get(i).getMinPayment();
        }
        //System.out.println("Total amount paid: "+df.format(getTotalAmountPaid()));
        System.out.println("Total debt payoff end date: "+debts.get(debts.size()-1).getEndDate());
    }

    public static String intToMonth(int month)
    {
        String monthString = null;
        switch(month)
        {
            case 1:monthString = "JANUARY";
                break;
            case 2:monthString = "FEBRUARY";
                break;
            case 3:monthString = "MARCH";
                break;
            case 4:monthString = "APRIL";
                break;
            case 5:monthString = "MAY";
                break;
            case 6:monthString = "JUNE";
                break;
            case 7:monthString = "JULY";
                break;
            case 8:monthString = "AUGUST";
                break;
            case 9:monthString = "SEPTEMBER";
                break;
            case 10:monthString = "OCTOBER";
                break;
            case 11:monthString = "NOVEMBER";
                break;
            case 0:monthString = "DECEMBER";
                break;

        }
        return monthString;
    }

    public static String getTotalDebtPayoffEndDate(ArrayList<Entry> debts)
    {
        int maxIteration = 0;
        for(Entry entry:debts)
        {
            if(entry.getIterations()>maxIteration)
                maxIteration = entry.getIterations();
        }
        String completeDateString = getCompletionDate(maxIteration);
        return completeDateString;
    }

    public static String calculateTotalTimeDebtPayoff(ArrayList<Entry> debts)
    {
        String time;
        int maxIteration = 0;
        for(Entry entry:debts)
        {
            if(entry.getIterations()>maxIteration)
                maxIteration = entry.getIterations();
        }
        int years = maxIteration/12;
        int months = maxIteration%12;
        return years+" years "+months+" months";
    }

    public static Comparator<Entry> BY_PRINCIPLE = new Comparator<Entry>() {
        @Override
        public int compare(Entry o1, Entry o2)
        {
            return Double.compare(o1.getPrinciple(), o2.getPrinciple());
        }

    };

    public static Comparator<Entry> BY_INTEREST = new Comparator<Entry>() {
        @Override
        public int compare(Entry e1, Entry e2)
        {
            return Double.compare(e2.getInterest(), e1.getInterest());
        }
    };
}

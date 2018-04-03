package Calculate;

import Entry.Entry;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegularCalculate extends Calculate
{
    private static double regularTotalAmountPaid;
    private static ArrayList<Entry> regularCalculateEntries = new ArrayList<>();

    public static double getRegularTotalAmountPaid() {
        return regularTotalAmountPaid;
    }

    public static void setRegularTotalAmountPaid(double regularTotalAmountPaid) {
        RegularCalculate.regularTotalAmountPaid = regularTotalAmountPaid;
    }

    public static ArrayList<Entry> getRegularCalculateEntries() {
        return regularCalculateEntries;
    }

    @Override
    public void calculate()
    {
        //double total = 0;
        int exit = 0;
        int count = 0;
        do
        {
            exit = 0;
            for(int i=0;i<getRegularCalculateEntries().size();i++)
            {
                double accrue = 0;
                getRegularCalculateEntries().get(i).setPrinciple(getRegularCalculateEntries().get(i).getPrinciple() +
                        (getRegularCalculateEntries().get(i).getPrinciple() * getRegularCalculateEntries().get(i).getInterest()/12));
                if(getRegularCalculateEntries().get(i).getPrinciple()==0){}
                else if(getRegularCalculateEntries().get(i).getPrinciple()>0 && getRegularCalculateEntries().get(i).getMinPayment() >= getRegularCalculateEntries().get(i).getPrinciple())
                {
                    accrue = getRegularCalculateEntries().get(i).getPrinciple();
                    setRegularTotalAmountPaid(getRegularTotalAmountPaid() + accrue);
                    //total += accrue;
                    //System.out.println("Accrue "+ accrue);
                    double leftover = getRegularCalculateEntries().get(i).getMinPayment() - accrue;
                    //System.out.println("Leftover "+leftover);
                    if(leftover>0 && getRegularCalculateEntries().get(i) != getRegularCalculateEntries().get(getRegularCalculateEntries().size()-1))
                    {
                        //System.out.println("LEFTOVER\nBefore "+getRegularCalculateEntries().get(i));

                        getRegularCalculateEntries().get(i).setPrinciple(getRegularCalculateEntries().get(i).getPrinciple() - leftover);
                        //System.out.println("After "+getRegularCalculateEntries().get(i));
                        accrue += leftover;
                    }
                    /*else if(entries.get(i+1) == entries.get(entries.size()-1) && leftover >= entries.get(i+1).getPrinciple())
                    {
                        entries.get(i+1).setPrinciple(0);
                        System.out.println(entries.get(i+1));
                    }*/
                    getRegularCalculateEntries().get(i).setPrinciple(0);
                    //System.out.println(getRegularCalculateEntries().get(i));
                }
                else
                {
                    accrue = getRegularCalculateEntries().get(i).getMinPayment();
                    getRegularCalculateEntries().get(i).setPrinciple(getRegularCalculateEntries().get(i).getPrinciple() - getRegularCalculateEntries().get(i).getMinPayment());
                    //System.out.println(getRegularCalculateEntries().get(i));
                    //total += accrue;
                    setRegularTotalAmountPaid(getRegularTotalAmountPaid() + accrue);
                }
                //System.out.println("Total "+total);
                //System.out.println("Total "+getRegularTotalAmountPaid());

            }
            count++;

            for(int i=0;i<getRegularCalculateEntries().size();i++)
            {
                if(getRegularCalculateEntries().get(i).getPrinciple()>0)
                    exit++;
                else if(getRegularCalculateEntries().get(i).getPrinciple()==0 && getRegularCalculateEntries().get(i).getIterations()==0)
                    getRegularCalculateEntries().get(i).setIterations(count);
            }
        }while(exit != 0);

        System.out.println("Done");
        for(Entry entry:getRegularCalculateEntries())
        {
            Calculate.getCompletionDate(entry);
            //System.out.println(entry);
        }
    }

    @Override
    public void printResults()
    {
        System.out.println("Regular Debt Payoff Results: ");
        //Calculate.getInitialDebtEntries().sort(Calculate.BY_PRINCIPLE);
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat dfInt = new DecimalFormat("#.####");
        for(int i=0;i<Calculate.getInitialDebtEntries().size();i++)
        {
            System.out.println("Entry "+i+" Principle: "+df.format(getInitialDebtEntries().get(i).getPrinciple())+" Minimum Payment: "+
                    df.format(getInitialDebtEntries().get(i).getMinPayment())+" Interest Rate: "+dfInt.format(getRegularCalculateEntries().get(i).getInterest())+" Iterations: "+
                    getRegularCalculateEntries().get(i).getIterations()+" End Date: "+getRegularCalculateEntries().get(i).getEndDate());
        }
        System.out.println("Total Amount Paid: "+df.format(getRegularTotalAmountPaid()));
        System.out.println("Total Debt payoff Date: "+getTotalDebtPayoffEndDate(getRegularCalculateEntries()));
        System.out.println("How long with it take? "+calculateTotalTimeDebtPayoff(getRegularCalculateEntries()));
    }

    @Override
    public void execute()
    {
        for(Entry entry:Calculate.getInitialDebtEntries())
        {
            Entry newE = new Entry(entry.getPrinciple(), entry.getMinPayment(), entry.getInterest());
            getRegularCalculateEntries().add(newE);
        }
        calculate();
        printResults();
    }
}

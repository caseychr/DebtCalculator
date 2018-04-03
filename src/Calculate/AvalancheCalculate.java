package Calculate;

import Entry.Entry;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AvalancheCalculate extends Calculate
{
    private ArrayList<Entry> avalancheCalculateEntries = new ArrayList<>();
    private static double avalancheTotalAmountPaid;

    public ArrayList<Entry> getAvalancheCalculateEntries() {
        return avalancheCalculateEntries;
    }

    public static double getAvalancheTotalAmountPaid() {
        return avalancheTotalAmountPaid;
    }

    public static void setAvalancheTotalAmountPaid(double avalancheTotalAmountPaid) {
        AvalancheCalculate.avalancheTotalAmountPaid = avalancheTotalAmountPaid;
    }

    @Override
    public void calculate()
    {
        //double total = 0;
        double extraAmount = 0;
        int exit = 0;
        int count = 0;
        getAvalancheCalculateEntries().get(0).setMinPayment(getAvalancheCalculateEntries().get(0).getMinPayment() + extraAmount);
        do
        {
            exit = 0;
            for(int i=0;i<getAvalancheCalculateEntries().size();i++)
            {
                double accrue = 0;
                getAvalancheCalculateEntries().get(i).setPrinciple(getAvalancheCalculateEntries().get(i).getPrinciple() +
                        (getAvalancheCalculateEntries().get(i).getPrinciple() * getAvalancheCalculateEntries().get(i).getInterest()/12));
                if(getAvalancheCalculateEntries().get(i).getPrinciple()==0)
                {
                    if(getAvalancheCalculateEntries().get(i) != getAvalancheCalculateEntries().get(getAvalancheCalculateEntries().size()-1))
                    {
                        getAvalancheCalculateEntries().get(i + 1).setMinPayment(getAvalancheCalculateEntries().get(i + 1).getMinPayment() + getAvalancheCalculateEntries().get(i).getMinPayment());
                        getAvalancheCalculateEntries().get(i).setMinPayment(0);
                    }
                }
                else if(getAvalancheCalculateEntries().get(i).getPrinciple()>0 && getAvalancheCalculateEntries().get(i).getMinPayment() >= getAvalancheCalculateEntries().get(i).getPrinciple())
                {
                    accrue = getAvalancheCalculateEntries().get(i).getPrinciple();
                    setAvalancheTotalAmountPaid(getAvalancheTotalAmountPaid() + accrue);
                    //total += accrue;
                    //System.out.println("Accrue "+ accrue);
                    double leftover = getAvalancheCalculateEntries().get(i).getMinPayment() - accrue;
                    //System.out.println("Leftover "+leftover);
                    if(leftover>0 && getAvalancheCalculateEntries().get(i) != getAvalancheCalculateEntries().get(getAvalancheCalculateEntries().size()-1))
                    {
                        //System.out.println("LEFTOVER\nBefore "+getSnowballCalculateEntries().get(i));

                        getAvalancheCalculateEntries().get(i).setPrinciple(getAvalancheCalculateEntries().get(i).getPrinciple() - leftover);
                        //System.out.println("After "+getSnowballCalculateEntries().get(i));
                        accrue += leftover;
                    }
                    /*else if(entries.get(i+1) == entries.get(entries.size()-1) && leftover >= entries.get(i+1).getPrinciple())
                    {
                        entries.get(i+1).setPrinciple(0);
                        System.out.println(entries.get(i+1));
                    }*/
                    if(getAvalancheCalculateEntries().get(i) != getAvalancheCalculateEntries().get(getAvalancheCalculateEntries().size()-1))
                    {
                        getAvalancheCalculateEntries().get(i + 1).setMinPayment(getAvalancheCalculateEntries().get(i + 1).getMinPayment() + getAvalancheCalculateEntries().get(i).getMinPayment());
                        getAvalancheCalculateEntries().get(i).setMinPayment(0);
                    }
                    getAvalancheCalculateEntries().get(i).setPrinciple(0);
                    //System.out.println(getSnowballCalculateEntries().get(i));
                }
                else
                {
                    accrue = getAvalancheCalculateEntries().get(i).getMinPayment();
                    getAvalancheCalculateEntries().get(i).setPrinciple(getAvalancheCalculateEntries().get(i).getPrinciple() - getAvalancheCalculateEntries().get(i).getMinPayment());
                    //System.out.println(getSnowballCalculateEntries().get(i));
                    setAvalancheTotalAmountPaid(getAvalancheTotalAmountPaid() + accrue);
                    //total += accrue;
                }
                //System.out.println("Total "+total);
                //System.out.println("Total "+getSnowBallTotalAmountPaid());

            }
            count++;

            for(int i=0;i<getAvalancheCalculateEntries().size();i++)
            {
                if(getAvalancheCalculateEntries().get(i).getPrinciple()>0)
                    exit++;
                else if(getAvalancheCalculateEntries().get(i).getPrinciple()==0 && getAvalancheCalculateEntries().get(i).getIterations()==0)
                    getAvalancheCalculateEntries().get(i).setIterations(count);
            }
        }while(exit != 0);

        System.out.println("Done");
        for(Entry entry:getAvalancheCalculateEntries())
        {
            Calculate.getCompletionDate(entry);
            //System.out.println(entry);
        }
    }

    @Override
    public void printResults()
    {
        System.out.println("Debt Avalanche Payoff Results: ");
        Calculate.getInitialDebtEntries().sort(Calculate.BY_INTEREST);
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat dfInt = new DecimalFormat("#.####");
        System.out.println();
        for(int i=0;i<Calculate.getInitialDebtEntries().size();i++)
        {
            System.out.println("Entry "+i+" Principle: "+df.format(getInitialDebtEntries().get(i).getPrinciple())+" Minimum Payment: "+
                    df.format(getInitialDebtEntries().get(i).getMinPayment())+" Interest Rate: "+dfInt.format(getAvalancheCalculateEntries().get(i).getInterest())+" Iterations: "+
                    getAvalancheCalculateEntries().get(i).getIterations()+" End Date: "+getAvalancheCalculateEntries().get(i).getEndDate());
        }
        System.out.println("Total Amount Paid: "+df.format(getAvalancheTotalAmountPaid()));
        System.out.println("Total Debt payoff Date: "+getTotalDebtPayoffEndDate(getAvalancheCalculateEntries()));
        System.out.println("How long with it take? "+calculateTotalTimeDebtPayoff(getAvalancheCalculateEntries()));
    }

    @Override
    public void execute() 
    {
        for(Entry entry:Calculate.getInitialDebtEntries())
        {
            Entry newE = entry;
            getAvalancheCalculateEntries().add(newE);
        }
        getAvalancheCalculateEntries().sort(BY_INTEREST);
        calculate();
        printResults();
    }
}

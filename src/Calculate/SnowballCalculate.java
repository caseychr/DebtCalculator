package Calculate;

import Entry.Entry;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SnowballCalculate extends Calculate
{
    private static double snowBallTotalAmountPaid;
    private static ArrayList<Entry> snowballCalculateEntries = new ArrayList<>();

    public static double getSnowBallTotalAmountPaid() {
        return snowBallTotalAmountPaid;
    }

    public static void setSnowBallTotalAmountPaid(double snowBallTotalAmountPaid) {
        SnowballCalculate.snowBallTotalAmountPaid = snowBallTotalAmountPaid;
    }

    public static ArrayList<Entry> getSnowballCalculateEntries() {
        return snowballCalculateEntries;
    }

    @Override
    public void calculate()
    {
        //double total = 0;
        double extraAmount = 440;
        int exit = 0;
        int count = 0;
        getSnowballCalculateEntries().get(0).setMinPayment(getSnowballCalculateEntries().get(0).getMinPayment() + extraAmount);
        do
        {
            exit = 0;
            for(int i=0;i<getSnowballCalculateEntries().size();i++)
            {
                double accrue = 0;
                getSnowballCalculateEntries().get(i).setPrinciple(getSnowballCalculateEntries().get(i).getPrinciple() +
                        (getSnowballCalculateEntries().get(i).getPrinciple()*getSnowballCalculateEntries().get(i).getInterest()/12));
                if(getSnowballCalculateEntries().get(i).getPrinciple()==0)
                {
                    if(getSnowballCalculateEntries().get(i) != getSnowballCalculateEntries().get(getSnowballCalculateEntries().size()-1))
                    {
                        //NEW
                        /*for(int j=0;j<getSnowballCalculateEntries().size();j++)
                        {
                            if(getSnowballCalculateEntries().get(i).getPrinciple()>0)
                            {
                                getSnowballCalculateEntries().get(i + 1).setMinPayment(getSnowballCalculateEntries().get(i + 1).getMinPayment() +
                                        getSnowballCalculateEntries().get(i).getMinPayment());
                                break;
                            }
                        }*/
                        getSnowballCalculateEntries().get(i + 1).setMinPayment(getSnowballCalculateEntries().get(i + 1).getMinPayment() + getSnowballCalculateEntries().get(i).getMinPayment());
                        getSnowballCalculateEntries().get(i).setMinPayment(0);
                    }
                }
                else if(getSnowballCalculateEntries().get(i).getPrinciple()>0 && getSnowballCalculateEntries().get(i).getMinPayment() >= getSnowballCalculateEntries().get(i).getPrinciple())
                {
                    accrue = getSnowballCalculateEntries().get(i).getPrinciple();
                    setSnowBallTotalAmountPaid(getSnowBallTotalAmountPaid() + accrue);
                    //total += accrue;
                    //System.out.println("Accrue "+ accrue);
                    double leftover = getSnowballCalculateEntries().get(i).getMinPayment() - accrue;
                    //System.out.println("Leftover "+leftover);
                    if(leftover>0 && getSnowballCalculateEntries().get(i) != getSnowballCalculateEntries().get(getSnowballCalculateEntries().size()-1))
                    {
                        //System.out.println("LEFTOVER\nBefore "+getSnowballCalculateEntries().get(i));

                        getSnowballCalculateEntries().get(i).setPrinciple(getSnowballCalculateEntries().get(i).getPrinciple() - leftover);
                        //System.out.println("After "+getSnowballCalculateEntries().get(i));
                        accrue += leftover;
                    }
                    /*else if(entries.get(i+1) == entries.get(entries.size()-1) && leftover >= entries.get(i+1).getPrinciple())
                    {
                        entries.get(i+1).setPrinciple(0);
                        System.out.println(entries.get(i+1));
                    }*/
                    if(getSnowballCalculateEntries().get(i) != getSnowballCalculateEntries().get(getSnowballCalculateEntries().size()-1))
                    {
                        getSnowballCalculateEntries().get(i + 1).setMinPayment(getSnowballCalculateEntries().get(i + 1).getMinPayment() + getSnowballCalculateEntries().get(i).getMinPayment());
                        getSnowballCalculateEntries().get(i).setMinPayment(0);
                    }
                    getSnowballCalculateEntries().get(i).setPrinciple(0);
                    //System.out.println(getSnowballCalculateEntries().get(i));
                }
                else
                {
                    accrue = getSnowballCalculateEntries().get(i).getMinPayment();
                    getSnowballCalculateEntries().get(i).setPrinciple(getSnowballCalculateEntries().get(i).getPrinciple() - getSnowballCalculateEntries().get(i).getMinPayment());
                    //System.out.println(getSnowballCalculateEntries().get(i));
                    setSnowBallTotalAmountPaid(getSnowBallTotalAmountPaid() + accrue);
                    //total += accrue;
                }
                //System.out.println("Total "+total);
                //System.out.println("Total "+getSnowBallTotalAmountPaid());

            }
            count++;

            for(int i=0;i<getSnowballCalculateEntries().size();i++)
            {
                if(getSnowballCalculateEntries().get(i).getPrinciple()>0)
                    exit++;
                else if(getSnowballCalculateEntries().get(i).getPrinciple()==0 && getSnowballCalculateEntries().get(i).getIterations()==0)
                    getSnowballCalculateEntries().get(i).setIterations(count);
            }
        }while(exit != 0);

        System.out.println("Done");
        for(Entry entry:getSnowballCalculateEntries())
        {
            Calculate.getCompletionDate(entry);
            //System.out.println(entry);
        }
    }

    @Override
    public void printResults() {
        System.out.println("Debt Snowball Payoff Results: ");
        Calculate.getInitialDebtEntries().sort(Calculate.BY_PRINCIPLE);
        DecimalFormat df = new DecimalFormat("#.##");
        DecimalFormat dfInt = new DecimalFormat("#.####");
        System.out.println();
        for(int i=0;i<Calculate.getInitialDebtEntries().size();i++)
        {
            System.out.println("Entry "+i+" Principle: "+df.format(getInitialDebtEntries().get(i).getPrinciple())+" Minimum Payment: "+
                    df.format(getInitialDebtEntries().get(i).getMinPayment())+" Interest Rate: "+dfInt.format(getSnowballCalculateEntries().get(i).getInterest())+" Iterations: "+
                    getSnowballCalculateEntries().get(i).getIterations()+" End Date: "+getSnowballCalculateEntries().get(i).getEndDate());
        }
        System.out.println("Total Amount Paid: "+df.format(getSnowBallTotalAmountPaid()));
        System.out.println("Total Debt payoff Date: "+getTotalDebtPayoffEndDate(getSnowballCalculateEntries()));
        System.out.println("How long with it take? "+calculateTotalTimeDebtPayoff(getSnowballCalculateEntries()));
    }

    @Override
    public void execute()
    {
        for(Entry entry:Calculate.getInitialDebtEntries())
        {
            Entry newE = new Entry(entry.getPrinciple(), entry.getMinPayment(), entry.getInterest());
            getSnowballCalculateEntries().add(newE);
        }
        getSnowballCalculateEntries().sort(BY_PRINCIPLE);
        calculate();
        printResults();
    }
}

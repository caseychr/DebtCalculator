package Tests;

import Calculate.*;
import Entry.Entry;
import Files.ReadFile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class AvalancheDebtCalculator_Tests
{
    public ArrayList<Entry> testEntriesAL = new ArrayList<>();

    /*@Before
    public void setup()
    {
        Calculate.getInitialDebtEntries().clear();
        RegularCalculate.getRegularCalculateEntries().clear();
        Calculate.setTotalAmountPaid(0);
    }

    @Test
    public void entriesAreOrderedByTheWayTheyWereReadFromFile()
    {
        String fileName = "C:\\Users\\mcasey\\IdeaProjects\\DebtCalculator\\src\\Tests\\fourEntries.csv";
        Entry testEntry_1 = new Entry(532.15, 32.05, .068);
        Entry testEntry_2 = new Entry(40540.53, 1004.45, .05);
        Entry testEntry_3 = new Entry(1253.02, 43.04, .04);
        Entry testEntry_4 = new Entry(85.44, 12.32, .06);
        testEntriesAL.add(testEntry_1);testEntriesAL.add(testEntry_2);
        testEntriesAL.add(testEntry_3);testEntriesAL.add(testEntry_4);

        ReadFile.readFile(fileName);

        for(int i=0;i<testEntriesAL.size();i++)
        {
            Assert.assertEquals(testEntriesAL.get(i).getPrinciple(), Calculate.getInitialDebtEntries().get(i).getPrinciple(), 0);
            Assert.assertEquals(testEntriesAL.get(i).getMinPayment(), Calculate.getInitialDebtEntries().get(i).getMinPayment(), 0);
            Assert.assertEquals(testEntriesAL.get(i).getInterest(), Calculate.getInitialDebtEntries().get(i).getInterest(), 0);
            Assert.assertEquals(testEntriesAL.get(i).getIterations(), Calculate.getInitialDebtEntries().get(i).getIterations(), 0);
            Assert.assertEquals(testEntriesAL.get(i).getEndDate(), Calculate.getInitialDebtEntries().get(i).getEndDate());
        }
    }

    @Test
    public void oneEntryIsCalculatedWithCalculator_NoInterest()
    {
        Entry testEntry_1 = new Entry(500, 25, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple(), 0);
        Assert.assertEquals(25, testEntry_1.getMinPayment(), 0);
        Assert.assertEquals(20, testEntry_1.getIterations(), 0);
        Assert.assertEquals(500, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void oneEntryIsCalculatedWithCalculator_NoInterest_UnevenMinimumPayment()
    {
        Entry testEntry_1 = new Entry(513, 25, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple(), 0);
        Assert.assertEquals(25, testEntry_1.getMinPayment(), 0);
        Assert.assertEquals(21, testEntry_1.getIterations(), 0);
        Assert.assertEquals(513, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void oneEntryIsCalculatedWithCalculator_YesInterest()
    {
        Entry testEntry_1 = new Entry(500, 50, .05);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple(), 0);
        Assert.assertEquals(50, testEntry_1.getMinPayment(), 0);
        Assert.assertEquals(15, testEntry_1.getIterations());
        Assert.assertEquals(710.5359102943163, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void oneEntryIsCalculatedWithCalculator_YesInterest_UnevenMinimumPayment()
    {
        Entry testEntry_1 = new Entry(510, 50, .05);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple(), 0);
        Assert.assertEquals(50, testEntry_1.getMinPayment(), 0);
        Assert.assertEquals(15, testEntry_1.getIterations());
        Assert.assertEquals(731.32519208843, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twoEntriesIsCalculatedWithCalculator_NoInterest()
    {
        Entry testEntry_1 = new Entry(300, 20, 0);
        Entry testEntry_2 = new Entry(500, 25, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple()+testEntry_2.getPrinciple(), 0);
        Assert.assertEquals(45, testEntry_1.getMinPayment()+testEntry_2.getMinPayment(), 0);
        Assert.assertEquals(20, testEntry_2.getIterations());
        Assert.assertEquals(800, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twoEntriesIsCalculatedWithCalculator_NoInterest_UnevenMinimumPayment()
    {
        Entry testEntry_1 = new Entry(308, 20, 0);
        Entry testEntry_2 = new Entry(518, 25, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple()+testEntry_2.getPrinciple(), 0);
        Assert.assertEquals(45, testEntry_1.getMinPayment()+testEntry_2.getMinPayment(), 0);
        Assert.assertEquals(21, testEntry_2.getIterations());
        Assert.assertEquals(826, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twoEntriesIsCalculatedWithCalculator_YesInterest()
    {
        Entry testEntry_1 = new Entry(300, 20, .03);
        Entry testEntry_2 = new Entry(500, 50, .05);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple()+testEntry_2.getPrinciple(), 0);
        Assert.assertEquals(70, testEntry_1.getMinPayment()+testEntry_2.getMinPayment(), 0);
        Assert.assertEquals(15, testEntry_2.getIterations());
        Assert.assertEquals(1115.0945673341676, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twoEntriesIsCalculatedWithCalculator_YesInterest_UnevenMinimumPayment()
    {
        Entry testEntry_1 = new Entry(305, 20, .03);
        Entry testEntry_2 = new Entry(515, 50, .05);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);

        RegularCalculate.calculate();

        Assert.assertEquals(0, testEntry_1.getPrinciple()+testEntry_2.getPrinciple(), 0);
        Assert.assertEquals(70, testEntry_1.getMinPayment()+testEntry_2.getMinPayment(), 0);
        Assert.assertEquals(15, testEntry_2.getIterations());
        Assert.assertEquals(1155.5799628838856, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void eightEntriesIsCalculatedWithCalculator_NoInterest()
    {
        Entry testEntry_1 = new Entry(50, 5, 0);Entry testEntry_2 = new Entry(100, 10, 0);
        Entry testEntry_3 = new Entry(150, 15, 0);Entry testEntry_4 = new Entry(300, 30, 0);
        Entry testEntry_5 = new Entry(500, 50, 0);Entry testEntry_6 = new Entry(1000, 100, 0);
        Entry testEntry_7 = new Entry(5000, 500, 0);Entry testEntry_8 = new Entry(20000, 2000, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
        {
            Assert.assertEquals(0, entry.getPrinciple(), 0);
            Assert.assertEquals(entry.getPrinciple() * 0.1, entry.getMinPayment(), 0);
            Assert.assertEquals(10, testEntry_2.getIterations());
        }
        Assert.assertEquals(27100, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void eightEntriesIsCalculatedWithCalculator_NoInterest_UnevenMinimumPayment()
    {
        double amountPaidExpected = 0;
        Entry testEntry_1 = new Entry(55, 5, 0);Entry testEntry_2 = new Entry(105, 10, 0);
        Entry testEntry_3 = new Entry(165, 15, 0);Entry testEntry_4 = new Entry(310, 30, 0);
        Entry testEntry_5 = new Entry(515, 50, 0);Entry testEntry_6 = new Entry(1150, 100, 0);
        Entry testEntry_7 = new Entry(5125, 500, 0);Entry testEntry_8 = new Entry(22520, 2000, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        for(Entry entry:RegularCalculate.getRegularCalculateEntries())
            amountPaidExpected += entry.getPrinciple();

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
            Assert.assertEquals(0, entry.getPrinciple(), 0);
        Assert.assertEquals(11, testEntry_1.getIterations());Assert.assertEquals(11, testEntry_2.getIterations());
        Assert.assertEquals(11, testEntry_3.getIterations());Assert.assertEquals(11, testEntry_4.getIterations());
        Assert.assertEquals(11, testEntry_5.getIterations());Assert.assertEquals(12, testEntry_6.getIterations());
        Assert.assertEquals(11, testEntry_7.getIterations());Assert.assertEquals(12, testEntry_8.getIterations());
        Assert.assertEquals(amountPaidExpected, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void eightEntriesIsCalculatedWithCalculator_YesInterest()
    {
        double amountPaidExpected = 0;
        Entry testEntry_1 = new Entry(50, 5, .05);Entry testEntry_2 = new Entry(100, 10, .05);
        Entry testEntry_3 = new Entry(150, 15, .04);Entry testEntry_4 = new Entry(300, 30, .06);
        Entry testEntry_5 = new Entry(500, 50, .06);Entry testEntry_6 = new Entry(1000, 100, .04);
        Entry testEntry_7 = new Entry(5000, 500, .07);Entry testEntry_8 = new Entry(20000, 2000, .03);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        for(Entry entry:RegularCalculate.getRegularCalculateEntries())
            amountPaidExpected += entry.getPrinciple();

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
            Assert.assertEquals(0, entry.getPrinciple(), 0);
        Assert.assertEquals(15, testEntry_1.getIterations());Assert.assertEquals(15, testEntry_2.getIterations());
        Assert.assertEquals(14, testEntry_3.getIterations());Assert.assertEquals(16, testEntry_4.getIterations());
        Assert.assertEquals(16, testEntry_5.getIterations());Assert.assertEquals(14, testEntry_6.getIterations());
        Assert.assertEquals(18, testEntry_7.getIterations());Assert.assertEquals(13, testEntry_8.getIterations());
        Assert.assertEquals(36004.73649816506, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void eightEntriesIsCalculatedWithCalculator_YesInterest_UnevenMinimumPayment()
    {
        double amountPaidExpected = 0;
        Entry testEntry_1 = new Entry(56, 5, .05);Entry testEntry_2 = new Entry(105, 10, .05);
        Entry testEntry_3 = new Entry(164, 15, .04);Entry testEntry_4 = new Entry(325, 30, .06);
        Entry testEntry_5 = new Entry(514, 50, .06);Entry testEntry_6 = new Entry(1254, 100, .04);
        Entry testEntry_7 = new Entry(5153, 500, .07);Entry testEntry_8 = new Entry(20200, 2000, .03);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        for(Entry entry:RegularCalculate.getRegularCalculateEntries())
            amountPaidExpected += entry.getPrinciple();

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
            Assert.assertEquals(0, entry.getPrinciple(), 0);
        Assert.assertEquals(17, testEntry_1.getIterations());Assert.assertEquals(16, testEntry_2.getIterations());
        Assert.assertEquals(15, testEntry_3.getIterations());Assert.assertEquals(19, testEntry_4.getIterations());
        Assert.assertEquals(17, testEntry_5.getIterations());Assert.assertEquals(18, testEntry_6.getIterations());
        Assert.assertEquals(19, testEntry_7.getIterations());Assert.assertEquals(13, testEntry_8.getIterations());
        Assert.assertEquals(37471.85707105789, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twentyEntriesIsCalculatedWithCalculator_NoInterest()
    {
        Entry testEntry_1 = new Entry(50, 5, 0);Entry testEntry_2 = new Entry(100, 10, 0);
        Entry testEntry_3 = new Entry(150, 15, 0);Entry testEntry_4 = new Entry(300, 30, 0);
        Entry testEntry_5 = new Entry(500, 50, 0);Entry testEntry_6 = new Entry(1000, 100, 0);
        Entry testEntry_7 = new Entry(5000, 500, 0);Entry testEntry_8 = new Entry(20000, 2000, 0);
        Entry testEntry_9 = new Entry(50, 5, 0);Entry testEntry_10 = new Entry(100, 10, 0);
        Entry testEntry_11 = new Entry(150, 15, 0);Entry testEntry_12 = new Entry(300, 30, 0);
        Entry testEntry_13 = new Entry(500, 50, 0);Entry testEntry_14 = new Entry(1000, 100, 0);
        Entry testEntry_15 = new Entry(5000, 500, 0);Entry testEntry_16 = new Entry(20000, 2000, 0);
        Entry testEntry_17 = new Entry(50, 5, 0);Entry testEntry_18 = new Entry(100, 10, 0);
        Entry testEntry_19 = new Entry(150, 15, 0);Entry testEntry_20 = new Entry(300, 30, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_9);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_10);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_11);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_12);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_13);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_14);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_15);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_16);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_17);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_18);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_19);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_20);

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
        {
            Assert.assertEquals(0, entry.getPrinciple(), 0);
            Assert.assertEquals(entry.getPrinciple() * 0.1, entry.getMinPayment(), 0);
            Assert.assertEquals(10, testEntry_2.getIterations());
        }
        Assert.assertEquals(54800, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twentyEntriesIsCalculatedWithCalculator_NoInterest_UnevenMinimumPayment()
    {
        Entry testEntry_1 = new Entry(55, 5, 0);Entry testEntry_2 = new Entry(105, 10, 0);
        Entry testEntry_3 = new Entry(155, 15, 0);Entry testEntry_4 = new Entry(305, 30, 0);
        Entry testEntry_5 = new Entry(505, 50, 0);Entry testEntry_6 = new Entry(1005, 100, 0);
        Entry testEntry_7 = new Entry(5005, 500, 0);Entry testEntry_8 = new Entry(20005, 2000, 0);
        Entry testEntry_9 = new Entry(55, 5, 0);Entry testEntry_10 = new Entry(105, 10, 0);
        Entry testEntry_11 = new Entry(155, 15, 0);Entry testEntry_12 = new Entry(305, 30, 0);
        Entry testEntry_13 = new Entry(505, 50, 0);Entry testEntry_14 = new Entry(1005, 100, 0);
        Entry testEntry_15 = new Entry(5005, 500, 0);Entry testEntry_16 = new Entry(20005, 2000, 0);
        Entry testEntry_17 = new Entry(55, 5, 0);Entry testEntry_18 = new Entry(105, 10, 0);
        Entry testEntry_19 = new Entry(155, 15, 0);Entry testEntry_20 = new Entry(305, 30, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_9);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_10);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_11);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_12);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_13);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_14);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_15);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_16);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_17);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_18);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_19);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_20);

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
            Assert.assertEquals(0, entry.getPrinciple(), 0);
        Assert.assertEquals(54900, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twentyEntriesIsCalculatedWithCalculator_YesInterest()
    {
        Entry testEntry_1 = new Entry(50, 5, .04);Entry testEntry_2 = new Entry(100, 10, .05);
        Entry testEntry_3 = new Entry(150, 15, .05);Entry testEntry_4 = new Entry(300, 30, .04);
        Entry testEntry_5 = new Entry(500, 50, .05);Entry testEntry_6 = new Entry(1000, 100, .03);
        Entry testEntry_7 = new Entry(5000, 500, .06);Entry testEntry_8 = new Entry(20000, 2000, .02);
        Entry testEntry_9 = new Entry(50, 5, .04);Entry testEntry_10 = new Entry(100, 10, .05);
        Entry testEntry_11 = new Entry(150, 15, .07);Entry testEntry_12 = new Entry(300, 30, .06);
        Entry testEntry_13 = new Entry(500, 50, .05);Entry testEntry_14 = new Entry(1000, 100, .08);
        Entry testEntry_15 = new Entry(5000, 500, .063);Entry testEntry_16 = new Entry(20000, 2000, .07);
        Entry testEntry_17 = new Entry(50, 5, .05);Entry testEntry_18 = new Entry(100, 10, .05);
        Entry testEntry_19 = new Entry(150, 15, .03);Entry testEntry_20 = new Entry(300, 30, .05);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_9);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_10);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_11);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_12);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_13);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_14);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_15);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_16);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_17);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_18);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_19);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_20);

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
            Assert.assertEquals(0, entry.getPrinciple(), 0);
        Assert.assertEquals(14, testEntry_1.getIterations());Assert.assertEquals(15, testEntry_2.getIterations());
        Assert.assertEquals(15, testEntry_3.getIterations());Assert.assertEquals(14, testEntry_4.getIterations());
        Assert.assertEquals(15, testEntry_5.getIterations());Assert.assertEquals(13, testEntry_6.getIterations());
        Assert.assertEquals(16, testEntry_7.getIterations());Assert.assertEquals(12, testEntry_8.getIterations());
        Assert.assertEquals(14, testEntry_9.getIterations());Assert.assertEquals(15, testEntry_10.getIterations());
        Assert.assertEquals(18, testEntry_11.getIterations());Assert.assertEquals(16, testEntry_12.getIterations());
        Assert.assertEquals(15, testEntry_13.getIterations());Assert.assertEquals(21, testEntry_14.getIterations());
        Assert.assertEquals(17, testEntry_15.getIterations());Assert.assertEquals(18, testEntry_16.getIterations());
        Assert.assertEquals(15, testEntry_17.getIterations());Assert.assertEquals(15, testEntry_18.getIterations());
        Assert.assertEquals(13, testEntry_19.getIterations());Assert.assertEquals(15, testEntry_20.getIterations());
        Assert.assertEquals(81443.87252497043, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void twentyEntriesIsCalculatedWithCalculator_YesInterest_UnevenMinimumPayment()
    {
        Entry testEntry_1 = new Entry(55, 5, .04);Entry testEntry_2 = new Entry(105, 10, .05);
        Entry testEntry_3 = new Entry(155, 15, .05);Entry testEntry_4 = new Entry(305, 30, .04);
        Entry testEntry_5 = new Entry(505, 50, .05);Entry testEntry_6 = new Entry(1005, 100, .03);
        Entry testEntry_7 = new Entry(5005, 500, .06);Entry testEntry_8 = new Entry(20005, 2000, .02);
        Entry testEntry_9 = new Entry(55, 5, .04);Entry testEntry_10 = new Entry(105, 10, .05);
        Entry testEntry_11 = new Entry(155, 15, .07);Entry testEntry_12 = new Entry(305, 30, .06);
        Entry testEntry_13 = new Entry(505, 50, .05);Entry testEntry_14 = new Entry(1005, 100, .08);
        Entry testEntry_15 = new Entry(5005, 500, .063);Entry testEntry_16 = new Entry(20005, 2000, .07);
        Entry testEntry_17 = new Entry(55, 5, .05);Entry testEntry_18 = new Entry(105, 10, .05);
        Entry testEntry_19 = new Entry(155, 15, .03);Entry testEntry_20 = new Entry(305, 30, .05);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_9);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_10);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_11);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_12);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_13);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_14);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_15);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_16);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_17);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_18);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_19);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_20);

        RegularCalculate.calculate();

        for(Entry entry:Calculate.getInitialDebtEntries())
            Assert.assertEquals(0, entry.getPrinciple(), 0);
        Assert.assertEquals(15, testEntry_1.getIterations());Assert.assertEquals(16, testEntry_2.getIterations());
        Assert.assertEquals(15, testEntry_3.getIterations());Assert.assertEquals(14, testEntry_4.getIterations());
        Assert.assertEquals(15, testEntry_5.getIterations());Assert.assertEquals(13, testEntry_6.getIterations());
        Assert.assertEquals(16, testEntry_7.getIterations());Assert.assertEquals(12, testEntry_8.getIterations());
        Assert.assertEquals(15, testEntry_9.getIterations());Assert.assertEquals(16, testEntry_10.getIterations());
        Assert.assertEquals(19, testEntry_11.getIterations());Assert.assertEquals(17, testEntry_12.getIterations());
        Assert.assertEquals(15, testEntry_13.getIterations());Assert.assertEquals(22, testEntry_14.getIterations());
        Assert.assertEquals(17, testEntry_15.getIterations());Assert.assertEquals(18, testEntry_16.getIterations());
        Assert.assertEquals(17, testEntry_17.getIterations());Assert.assertEquals(16, testEntry_18.getIterations());
        Assert.assertEquals(13, testEntry_19.getIterations());Assert.assertEquals(15, testEntry_20.getIterations());
        Assert.assertEquals(81676.20673794905, Calculate.getTotalAmountPaid(), 0);
    }

    @Test
    public void retrieveDebtPayOffEndDate()
    {
        String endDateExpected = "JANUARY 2019";
        Entry testEntry_1 = new Entry(50, 5, 0);Entry testEntry_2 = new Entry(100, 10, 0);
        Entry testEntry_3 = new Entry(150, 15, 0);Entry testEntry_4 = new Entry(300, 30, 0);
        Entry testEntry_5 = new Entry(500, 50, 0);Entry testEntry_6 = new Entry(1000, 100, 0);
        Entry testEntry_7 = new Entry(5000, 500, 0);Entry testEntry_8 = new Entry(20000, 2000, 0);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        RegularCalculate.calculate();

        String endDate = Calculate.getTotalDebtPayoffEndDate(RegularCalculate.getRegularCalculateEntries());

        Assert.assertEquals(endDateExpected, endDate);
    }

    @Test
    public void retrieveTotalAmountPaid_PrinciplePaid_AndInterestPaid()
    {
        double principleExpected = 0;
        double interestExpected = 0;
        Entry testEntry_1 = new Entry(56, 5, .05);Entry testEntry_2 = new Entry(105, 10, .05);
        Entry testEntry_3 = new Entry(164, 15, .04);Entry testEntry_4 = new Entry(325, 30, .06);
        Entry testEntry_5 = new Entry(514, 50, .06);Entry testEntry_6 = new Entry(1254, 100, .04);
        Entry testEntry_7 = new Entry(5153, 500, .07);Entry testEntry_8 = new Entry(20200, 2000, .03);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        for(Entry entry:Calculate.getInitialDebtEntries())
            Calculate.setTotalAmountPaid(Calculate.getTotalAmountPaid() + entry.getPrinciple());

        RegularCalculate.calculate();

        Assert.assertEquals(principleExpected, Calculate.getTotalPrinciplePaid(), 0);
        Assert.assertEquals(interestExpected, Calculate.getTotalInterestPaid(), 0);
    }

    @Test
    public void retrieveHowMuchTimeToTotallyPayOffDebt()
    {
        double timeExpected = 0;
        Entry testEntry_1 = new Entry(56, 5, .05);Entry testEntry_2 = new Entry(105, 10, .05);
        Entry testEntry_3 = new Entry(164, 15, .04);Entry testEntry_4 = new Entry(325, 30, .06);
        Entry testEntry_5 = new Entry(514, 50, .06);Entry testEntry_6 = new Entry(1254, 100, .04);
        Entry testEntry_7 = new Entry(5153, 500, .07);Entry testEntry_8 = new Entry(20200, 2000, .03);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_1);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_2);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_3);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_4);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_5);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_6);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_7);
        RegularCalculate.getRegularCalculateEntries().add(testEntry_8);

        for(Entry entry:Calculate.getInitialDebtEntries())
            Calculate.setTotalAmountPaid(Calculate.getTotalAmountPaid() + entry.getPrinciple());

        RegularCalculate.calculate();
        double time = Calculate.calculateTotalTimeDebtPayoff(Calculate.getInitialDebtEntries());

        Assert.assertEquals(timeExpected, time, 0);
    }*/
}

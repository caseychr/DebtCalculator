package Tests;


import Files.ReadFile;
import Entry.Entry;
import Calculate.Calculate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class ReadFromFile_Tests
{
    ArrayList<Entry> testEntryAL = new ArrayList<>();

    @Before
    public void setup()
    {
        testEntryAL.clear();
        Calculate.getInitialDebtEntries().clear();
    }

    @Test
    public void oneEntryCreatedFromFileRead()
    {
        String fileName = "C:\\Users\\mcasey\\IdeaProjects\\DebtCalculator\\src\\Tests\\oneEntry.csv";
        Entry testEntry_1 = new Entry(532.15, 32.05, .068);
        testEntryAL.add(testEntry_1);

        ReadFile.readFile(fileName);

        Assert.assertEquals(testEntryAL.get(0).getPrinciple(), Calculate.getInitialDebtEntries().get(0).getPrinciple(), 0);
        Assert.assertEquals(testEntryAL.get(0).getMinPayment(), Calculate.getInitialDebtEntries().get(0).getMinPayment(), 0);
        Assert.assertEquals(testEntryAL.get(0).getInterest(), Calculate.getInitialDebtEntries().get(0).getInterest(), 0);
        Assert.assertEquals(testEntryAL.get(0).getIterations(), Calculate.getInitialDebtEntries().get(0).getIterations(), 0);
        Assert.assertEquals(testEntryAL.get(0).getEndDate(), Calculate.getInitialDebtEntries().get(0).getEndDate());
    }

    @Test
    public void twoEntriesCreatedFromFileRead()
    {
        String fileName = "C:\\Users\\mcasey\\IdeaProjects\\DebtCalculator\\src\\Tests\\twoEntries.csv";
        Entry testEntry_1 = new Entry(532.15, 32.05, .068);
        Entry testEntry_2 = new Entry(40540.53, 1004.45, .05);
        testEntryAL.add(testEntry_1);testEntryAL.add(testEntry_2);

        ReadFile.readFile(fileName);

        for(int i=0;i<testEntryAL.size();i++)
        {
            Assert.assertEquals(testEntryAL.get(i).getPrinciple(), Calculate.getInitialDebtEntries().get(i).getPrinciple(), 0);
            Assert.assertEquals(testEntryAL.get(i).getMinPayment(), Calculate.getInitialDebtEntries().get(i).getMinPayment(), 0);
            Assert.assertEquals(testEntryAL.get(i).getInterest(), Calculate.getInitialDebtEntries().get(i).getInterest(), 0);
            Assert.assertEquals(testEntryAL.get(i).getIterations(), Calculate.getInitialDebtEntries().get(i).getIterations(), 0);
            Assert.assertEquals(testEntryAL.get(i).getEndDate(), Calculate.getInitialDebtEntries().get(i).getEndDate());
        }

    }

    @Test
    public void fourEntriesCreatedFromFileRead()
    {
        String fileName = "C:\\Users\\mcasey\\IdeaProjects\\DebtCalculator\\src\\Tests\\fourEntries.csv";
        Entry testEntry_1 = new Entry(532.15, 32.05, .068);
        Entry testEntry_2 = new Entry(40540.53, 1004.45, .05);
        Entry testEntry_3 = new Entry(1253.02, 43.04, .04);
        Entry testEntry_4 = new Entry(85.44, 12.32, .06);
        testEntryAL.add(testEntry_1);testEntryAL.add(testEntry_2);
        testEntryAL.add(testEntry_3);testEntryAL.add(testEntry_4);

        ReadFile.readFile(fileName);

        for(int i=0;i<testEntryAL.size();i++)
        {
            Assert.assertEquals(testEntryAL.get(i).getPrinciple(), Calculate.getInitialDebtEntries().get(i).getPrinciple(), 0);
            Assert.assertEquals(testEntryAL.get(i).getMinPayment(), Calculate.getInitialDebtEntries().get(i).getMinPayment(), 0);
            Assert.assertEquals(testEntryAL.get(i).getInterest(), Calculate.getInitialDebtEntries().get(i).getInterest(), 0);
            Assert.assertEquals(testEntryAL.get(i).getIterations(), Calculate.getInitialDebtEntries().get(i).getIterations(), 0);
            Assert.assertEquals(testEntryAL.get(i).getEndDate(), Calculate.getInitialDebtEntries().get(i).getEndDate());
        }
    }

    @Test
    public void twentyEntriesCreatedFromFileRead()
    {
        String fileName = "C:\\Users\\mcasey\\IdeaProjects\\DebtCalculator\\src\\Tests\\twentyEntries.csv";
        Entry testEntry_1 = new Entry(532.15, 32.05, .068);
        Entry testEntry_2 = new Entry(40540.53, 1004.45, .05);
        Entry testEntry_3 = new Entry(1253.02, 43.04, .04);
        Entry testEntry_4 = new Entry(85.44, 12.32, .06);
        Entry testEntry_5 = new Entry(532.15, 32.05, .068);
        Entry testEntry_6 = new Entry(40540.53, 1004.45, .05);
        Entry testEntry_7 = new Entry(1253.02, 43.04, .04);
        Entry testEntry_8 = new Entry(85.44, 12.32, .06);
        Entry testEntry_9 = new Entry(532.15, 32.05, .064);
        Entry testEntry_10 = new Entry(40540.53, 1004.45, .05);
        Entry testEntry_11 = new Entry(8542.02, 135.04, .04);
        Entry testEntry_12 = new Entry(85.44, 12.32, .06);
        Entry testEntry_13 = new Entry(532.15, 32.05, .068);
        Entry testEntry_14 = new Entry(40540.53, 1004.45, .05);
        Entry testEntry_15 = new Entry(1253.02, 43.04, .043);
        Entry testEntry_16 = new Entry(853.44, 46.32, .064);
        Entry testEntry_17 = new Entry(435.84, 32.05, .068);
        Entry testEntry_18 = new Entry(1240.53, 50.15, .052);
        Entry testEntry_19 = new Entry(124.03, 7.80, .047);
        Entry testEntry_20 = new Entry(8.40, 1.4, .03);
        testEntryAL.add(testEntry_1);testEntryAL.add(testEntry_2);
        testEntryAL.add(testEntry_3);testEntryAL.add(testEntry_4);
        testEntryAL.add(testEntry_5);testEntryAL.add(testEntry_6);
        testEntryAL.add(testEntry_7);testEntryAL.add(testEntry_8);
        testEntryAL.add(testEntry_9);testEntryAL.add(testEntry_10);
        testEntryAL.add(testEntry_11);testEntryAL.add(testEntry_12);
        testEntryAL.add(testEntry_13);testEntryAL.add(testEntry_14);
        testEntryAL.add(testEntry_15);testEntryAL.add(testEntry_16);
        testEntryAL.add(testEntry_17);testEntryAL.add(testEntry_18);
        testEntryAL.add(testEntry_19);testEntryAL.add(testEntry_20);

        ReadFile.readFile(fileName);

        for(int i=0;i<testEntryAL.size();i++)
        {
            Assert.assertEquals(testEntryAL.get(i).getPrinciple(), Calculate.getInitialDebtEntries().get(i).getPrinciple(), 0);
            Assert.assertEquals(testEntryAL.get(i).getMinPayment(), Calculate.getInitialDebtEntries().get(i).getMinPayment(), 0);
            Assert.assertEquals(testEntryAL.get(i).getInterest(), Calculate.getInitialDebtEntries().get(i).getInterest(), 0);
            Assert.assertEquals(testEntryAL.get(i).getIterations(), Calculate.getInitialDebtEntries().get(i).getIterations(), 0);
            Assert.assertEquals(testEntryAL.get(i).getEndDate(), Calculate.getInitialDebtEntries().get(i).getEndDate());
        }
    }
}

package Tests;

import Calculate.Calculate;
import Entry.Entry;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Calculate_Tests
{
    @Test
    public void calculateDateFromIterations()
    {
        Entry entry = new Entry(522, 32, .05);
        entry.setIterations(52);

        Calculate.getCompletionDate(entry);

        Assert.assertEquals("JULY 2022", entry.getEndDate());
    }

    /*@Test
    public void printResults()
    {
        ArrayList<Entry> entries = new ArrayList<>();
        Entry testEntry_1 = new Entry(505, 32.05, .068);
        Entry testEntry_2 = new Entry(40540.53, 1004.45, .05);
        entries.add(testEntry_1);entries.add(testEntry_2);
        testEntry_1.setIterations(13);testEntry_2.setIterations(21);
        testEntry_1.setEndDate("APRIL 2019");testEntry_2.setEndDate("DECEMBER 2019");
        Calculate.setTotalAmountPaid(40540+505);
        Calculate.getTotalEndDate();

        Calculate.printResults();
    }*/
}

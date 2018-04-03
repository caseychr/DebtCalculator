import Calculate.*;
import Entry.Entry;
import Files.ReadFile;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //Main m = new Main();
        String filename = "C:\\Users\\mcasey\\IdeaProjects\\DebtCalculator\\src\\Files\\numbers.csv";
        ReadFile.readFile(filename);
        //for(Entry entry:Calculate.getInitialDebtEntries())
          //  System.out.println(entry);

        RegularCalculate r = new RegularCalculate();
        r.execute();
        SnowballCalculate s = new SnowballCalculate();
        s.execute();
        AvalancheCalculate a = new AvalancheCalculate();
        a.execute();

    }
}

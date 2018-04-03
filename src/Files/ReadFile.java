package Files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import Entry.Entry;

public class ReadFile
{
    public static void readFile(String fileName)
    {
        final String separator = ",";
        BufferedReader br;
        FileReader reader;

        try
        {
            reader = new FileReader(fileName);
            br = new BufferedReader(reader);
            String variableReader;
            while((variableReader = br.readLine()) != null)
            {
                String[] entry = variableReader.split(separator);
                Entry.createEntry(entry);
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

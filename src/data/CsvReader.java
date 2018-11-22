package data;

import com.sun.istack.internal.NotNull;
import domain.Company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

public class CsvReader {

    @NotNull
    private final String mDelimeter;
    @NotNull
    private final String mFileName;

    private BufferedReader mBufferedReader;
    private Company mCurrentCompany;

    public CsvReader(String delimeter, String fileName) {
        mDelimeter = delimeter;
        mFileName = fileName;
    }

    @NotNull
    private BufferedReader getBufferedReader() throws FileNotFoundException {
        if (mBufferedReader == null) {
            return new BufferedReader(new FileReader(mFileName));
        }

        return mBufferedReader;
    }

    private Company readNextCompany() throws IOException, ParseException {
        BufferedReader reader = getBufferedReader();

        String line = reader.readLine();

        if (line == null) {
            return null;
        }

        return CompanyCsvParser.parse(line, mDelimeter);
    }

    private boolean hasNextCompany() throws ParseException {
        try {
            mCurrentCompany = readNextCompany();
        } catch (IOException e) {
            e.printStackTrace();
            mCurrentCompany = null;
        }

        return mCurrentCompany != null;
    }

    public Iterator<Company> startIteration() throws ParseException {
        if (mBufferedReader != null) {
            stopIteration();
        }

        return new CsvIterator();
    }

    public void stopIteration() {
        if (mBufferedReader != null) {
            try {
                mBufferedReader.close();
                mBufferedReader = null;
            } catch (IOException e) {
                e.printStackTrace();
                mBufferedReader = null;
            }
        }
    }

    private class CsvIterator implements Iterator<Company>  {

        @Override
        public boolean hasNext()  {
            boolean temp = false;
            try {
                temp = hasNextCompany();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return temp;
        }

        @Override
        public Company next() {
            return mCurrentCompany;
        }
    }
}

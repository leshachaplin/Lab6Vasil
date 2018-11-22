package presentation;

import com.thoughtworks.xstream.XStream;
import data.CsvReader;
import domain.usecase.UseCase;

import java.text.ParseException;

public class VasilenkoLab6 {

    /*
    - Каждый UseCase в своем классе
    - парсер из csv в Company
    - xml & json writer
     */

    public static void main(String[] args) {
        UseCase useCase = new UseCase();
        CsvReader reader = new CsvReader("\\|", "input.txt");

        try {
            useCase.writeXmlFile(useCase.findCompanyByShortName(reader.startIteration(), "PEN"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.stopIteration();
        }
    }
}



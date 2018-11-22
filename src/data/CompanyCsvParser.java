package data;

import domain.Company;

import java.text.ParseException;
import java.util.Date;

public class CompanyCsvParser {

    public static Company parse(String src, String delimeter) {
        String[] components = src.split(delimeter);

        Company company = new Company();

        company.setName(components[0]);
        company.setShortName(components[1]);
        Date date = null;
        try {
            date = DateUtils.parseDate(components[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        company.setDate(date);
        company.setAddress(components[3]);
        try {
            date = DateUtils.parseDate(components[4]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        company.setDateFoundation(date);
        company.setEmployeesCount(Integer.parseInt(components[5]));
        company.setAuditor(components[6]);
        company.setPhone(components[7]);
        company.setEmail(components[8]);
        company.setBranch(components[9]);
        company.setActivity(components[10]);
        company.setLink(components[11]);

        return company;
    }
}

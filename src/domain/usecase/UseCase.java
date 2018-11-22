package domain.usecase;

import com.thoughtworks.xstream.XStream;
import domain.Company;
import presentation.VasilenkoLab6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UseCase {

 //   public static class FindCompanyByShortName {
        public Company findCompanyByShortName(Iterator<Company> iterator, String shortName) {
            while (iterator.hasNext()) {
                Company company = iterator.next();
                if (shortName.equals(company.getShortName())) {
                    return company;
                }
            }

            return null;
        }

        public void writeXmlFile(Company company) {

            try {
                File file = new File("E://JavaProgramming/VasilenkoLab6");
                File file2 = new File(file, "Output.txt");
                XStream xStream = new XStream();
                xStream.alias("Company", Company.class);
                FileWriter writer = new FileWriter(file2);
                String xml = xStream.toXML(company);
                writer.write(xml);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 //   }

        public static class FindCompaniesByBranch {
            public List<Company> findCompaniesByBranch(Iterator<Company> iterator, String branch) {
                List<Company> result = new ArrayList<>();

                while (iterator.hasNext()) {
                    Company company = iterator.next();
                    if (branch.equals(company.getBranch())) {
                        result.add(company);
                    }
                }

                return result;
            }
        }

        public static class FindCompaniesByActivity {
            public List<Company> findCompaniesByActivity(Iterator<Company> iterator, String activity) {
                List<Company> result = new ArrayList<>();

                while (iterator.hasNext()) {
                    Company company = iterator.next();
                    if (activity.equals(company.getActivity())) {
                        result.add(company);
                    }
                }

                return result;
            }
        }

        public static class FindCompaniesByFoundation {
            public List<Company> findCompaniesByFoundation(Iterator<Company> iterator, Date dateFrom, Date dateTo) {
                List<Company> result = new ArrayList<>();

                while (iterator.hasNext()) {
                    Company company = iterator.next();
                    Date date = company.getDateFoundation();
                    if (date.after(dateFrom) && date.before(dateTo)) {
                        result.add(company);
                    }
                }

                return result;
            }
        }

        public static class FindCompaniesByEmployeesCount {
            public List<Company> findCompaniesByEmployeesCount(Iterator<Company> iterator, int from, int to) {
                List<Company> result = new ArrayList<>();

                while (iterator.hasNext()) {
                    Company company = iterator.next();
                    int count = company.getEmployeesCount();
                    if (count >= from && count <= to) {
                        result.add(company);
                    }
                }

                return result;
            }
        }
    }


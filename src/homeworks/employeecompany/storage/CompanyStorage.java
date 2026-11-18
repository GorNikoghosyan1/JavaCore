package homeworks.employeecompany.storage;

import homeworks.employeecompany.model.Company;

public class CompanyStorage {
    private Company[] companies = new Company[10];
    private int size = 0;

    public void add(Company company) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getCompanyID().equalsIgnoreCase(company.getCompanyID())) {
                System.out.println("Company with ID " + company.getCompanyID() + " already exists.");
                return;
            }
        }
        if (size == companies.length) {
            extend();
        }
        companies[size++] = company;
        System.out.println("Company successfully added!");
        System.out.println();
    }

    private void extend() {
        Company[] temp = new Company[companies.length + 10];
        System.arraycopy(companies, 0, temp, 0, companies.length);
        companies = temp;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.println(companies[i]);
        }
    }

    public Company getById(String id) {
        for (int i = 0; i < size; i++) {
            if (companies[i].getCompanyID().equalsIgnoreCase(id)) {
                return companies[i];
            }
        }
        return null;
    }

    public void printAllCompanies() {
        for (int i = 0; i < size; i++) {
            System.out.println(companies[i].getCompanyID() + " - " + companies[i].getName() + " - " + companies[i].getCountry());
            System.out.println();
        }
    }
}

package homeworks.employeecompany.model;

import java.util.Objects;

public class Company {
    private String name;
    private String companyID;
    private String industry;
    private String country;

    public Company(String name, String companyID, String industry, String country) {
        this.name = name;
        this.companyID = companyID;
        this.industry = industry;
        this.country = country;
    }

    public Company() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Company ID: " + companyID + "\n"
                + "Industry: " + industry + "\n"
                + "Country: " + country + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyID, company.companyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyID);
    }
}

package net.ourahma.mcpserver.tools;

import jdk.jfr.Description;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public class StockTools {
    private List<Company> companies = List.of(
            new Company("Maroc Telecom","Telecom",3.6,10600,"Maroc"),
            new Company("OCP","Extraction minière",5.6,20600,"Maroc")
    );
    @Tool(description = "Get All companies")
    public List<Company> getAllCompanies() {
        return this.companies;
    }

    @Tool
    public void setAllCompanies(List<Company> companies) {
        this.companies = companies;
    }
    @Tool
    public Company getCompanyByName(String name) {
        return this.companies.stream().filter(c -> c.name().equals(name)).findFirst().orElseThrow(()->new RuntimeException("Company not found"));
    }
    @Tool
    public Stock getStockByCompanyName(String name) {
        return new Stock(name,LocalDate.now(),300 + Math.random()*300);
    }

}


record Company(
        String name,String activity,
        @Description("The turnover In Millard MAD")
        double turnover,
        int employesCount,
        String country){}

record Stock(String companyName, LocalDate date, double stock){}
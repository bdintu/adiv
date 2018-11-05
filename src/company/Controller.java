package company;

import main.Main;

public class Controller {

    public void createSeeker(company.Model company_input) {
        Main.companys.add(company_input);
    }
}
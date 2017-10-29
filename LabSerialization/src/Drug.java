import java.io.Serializable;
import java.util.Scanner;

public class Drug implements Serializable {
    private String number_of_pharmacy;
    private String name_of_medicine;
    private String quntity_packages;
    private String cost_of_one_package;
    private String date_of_receipt;
    private String date_of_expiration;
	
    public static Drug read(Scanner fin) {
        Drug drug = new Drug();
        drug.number_of_pharmacy = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        drug.name_of_medicine = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        drug.quntity_packages = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        drug.cost_of_one_package = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        drug.date_of_receipt = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        drug.date_of_expiration = fin.nextLine();

        return drug;
    }
	
    public Drug() { }

    public String toString() {
        return "Drug" + "|" +
                number_of_pharmacy + "|" +
                name_of_medicine + "|" +
                quntity_packages + "|" +
                cost_of_one_package + "|" +
                date_of_receipt + "|" +
                date_of_expiration;
    }
}

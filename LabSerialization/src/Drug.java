import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;

public class Drug implements Serializable {
    private int number_of_pharmacy;
    private String name_of_medicine;
    private int quntity_packages;
    private int cost_of_one_package;
    protected Calendar date_of_receipt;
    protected Calendar date_of_expiration;
	
    public static Drug read(Scanner fin) throws ParseException {
        Drug drug = new Drug();

        drug.number_of_pharmacy = Integer.parseInt(fin.nextLine());
        if (!fin.hasNextLine()) return null;
        drug.name_of_medicine = fin.nextLine();
        if (!fin.hasNextLine()) return null;
        drug.quntity_packages = Integer.parseInt(fin.nextLine());
        if (!fin.hasNextLine()) return null;
        drug.cost_of_one_package = Integer.parseInt(fin.nextLine());
        if (!fin.hasNextLine()) return null;
        Calendar date_receipt = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        date_receipt.setTime(sdf.parse(fin.nextLine()));
        drug.date_of_receipt = date_receipt;
        if (!fin.hasNextLine()) return null;
        Calendar date_expiration = Calendar.getInstance();
        date_expiration.setTime(sdf.parse(fin.nextLine()));
        drug.date_of_expiration = date_expiration;

        return drug;
    }
	
    public Drug() { }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        return number_of_pharmacy + "|" +
                name_of_medicine + "|" +
                quntity_packages + "|" +
                cost_of_one_package + "|" +
                sdf.format(date_of_receipt.getTime()) + "|" +
                sdf.format(date_of_expiration.getTime());
    }
}

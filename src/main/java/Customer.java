import java.util.Iterator;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String printNormalStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String res = "Rental record for " + getName() + "\n";
        Iterator<Rental> iterator = rentals.iterator();
        while(iterator.hasNext()) {
            double thisAmount = 0;
            Rental each = iterator.next();

            //determine amounts for each line
            switch(each.getB().get_price_Code()) {
                case Book.CHILDRENS:
                    thisAmount += 1.5;
                    if(each.getD() > 3)
                        thisAmount += (each.getD() - 3) * 1.5;
                    break;
                case Book.COMEDY:
                    thisAmount += 2;
                    if(each.getD() > 2)
                        thisAmount += (each.getD() - 2) * 1.5;
                    break;
                case Book.NEW_RELEASE:
                    thisAmount += each.getD() * 3;
                    break;
            }
            
            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if ((each.getB().get_price_Code() == Book.NEW_RELEASE) && (each.getD() > 1)) frequentRenterPoints++;

            //show figures for this rental
            res += "\t" + each.getB().get_title() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        res += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        res += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return res;
    }

    public String printHtmlStatement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String res = "<h1> Rental record for <b>" + getName() + "</b></h1><p>";
        Iterator<Rental> iterator = rentals.iterator();
        while(iterator.hasNext()) {
            double thisAmount = 0;
            Rental each = iterator.next();

            //determine amounts for each line
            switch(each.getB().get_price_Code()) {
                case Book.CHILDRENS:
                    thisAmount += 1.5;
                    if(each.getD() > 3)
                        thisAmount += (each.getD() - 3) * 1.5;
                    break;
                case Book.COMEDY:
                    thisAmount += 2;
                    if(each.getD() > 2)
                        thisAmount += (each.getD() - 2) * 1.5;
                    break;
                case Book.NEW_RELEASE:
                    thisAmount += each.getD() * 3;
                    break;
            }

            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if ((each.getB().get_price_Code() == Book.NEW_RELEASE) && (each.getD() > 1)) frequentRenterPoints++;

            //show figures for this rental
            res += "\t" + each.getB().get_title() + "\t" + String.valueOf(thisAmount) + "<br>";
            totalAmount += thisAmount;
        }
        //add footer lines
        res += "</p><p>Amount owed is <b>" + String.valueOf(totalAmount) + "</b></p>";
        res += "<p>You earned <b>" + String.valueOf(frequentRenterPoints) + "</b> frequent renter points</p>";
        return res;
    }
}

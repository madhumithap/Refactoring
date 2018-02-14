
public class Rental {
    //This variable stores book rented by the customer
    private Book b;

    //This variable stores number of days rented
    private int d;

    public Rental(Book b, int d) {
        this.b = b;
        this.d = d;
    }

    public Book getB() {
        return b;
    }

    public int getD() {
        return d;
    }
}

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTests {

    @Test
    public void testShouldPrintNormalStatementIfNoBooksRented() throws Exception {
        Customer customer = new Customer("Sarah");

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForChildrens() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Tinkle", Book.CHILDRENS);
        Rental firstRental = new Rental(book, 1);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tTinkle\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForNewRelease() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Origin", Book.NEW_RELEASE);
        Rental firstRental = new Rental(book, 1);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tOrigin\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForThrillerBooks() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Da Vinci Code", Book.THRILLER);
        Rental firstRental = new Rental(book, 2);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tDa Vinci Code\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForChildrensBookRentedMoreThanThresholdDays() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Tinkle", Book.CHILDRENS);
        Rental firstRental = new Rental(book, 4);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tTinkle\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForThrillerBooksRentedMoreThanThresholdDays() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Da Vinci Code", Book.THRILLER);
        Rental firstRental = new Rental(book, 4);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tDa Vinci Code\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForNewReleaseBooksRentedMoreThanThresholdDays() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Origin", Book.NEW_RELEASE);
        Rental firstRental = new Rental(book, 3);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tOrigin\t9.0\n" +
                "Amount owed is 9.0\n" +
                "You earned 2 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForMultipleRentals() throws Exception {
        Customer customer = new Customer("Sarah");
        Book origin = new Book("Origin", Book.NEW_RELEASE);
        Rental firstRental = new Rental(origin, 10);
        customer.addRental(firstRental);

        Book daVinciCode = new Book("Da Vinci Code", Book.THRILLER);
        Rental secondRental = new Rental(daVinciCode, 2);
        customer.addRental(secondRental);

        Book tinkle = new Book("Tinkle", Book.CHILDRENS);
        Rental thirdRental = new Rental(tinkle, 5);
        customer.addRental(thirdRental);


        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tOrigin\t30.0\n" +
                "\tDa Vinci Code\t2.0\n" +
                "\tTinkle\t4.5\n" +
                "Amount owed is 36.5\n" +
                "You earned 4 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintNormalStatementForInvalidBookGenre() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Tinkle", 3);
        Rental firstRental = new Rental(book, 1);
        customer.addRental(firstRental);

        String normalStatement = customer.printNormalStatement();

        assertEquals("Rental record for Sarah\n" +
                "\tTinkle\t0.0\n" +
                "Amount owed is 0.0\n" +
                "You earned 1 frequent renter points", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementIfNoBooksRented() throws Exception {
        Customer customer = new Customer("Sarah");

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p></p><p>" +
                "Amount owed is <b>0.0</b></p><p>You earned <b>0</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForChildrens() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Tinkle", Book.CHILDRENS);
        Rental firstRental = new Rental(book, 1);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tTinkle\t1.5<br></p><p>" +
                "Amount owed is <b>1.5</b></p><p>You earned <b>1</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForNewRelease() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Origin", Book.NEW_RELEASE);
        Rental firstRental = new Rental(book, 1);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tOrigin\t3.0<br></p><p>" +
                "Amount owed is <b>3.0</b></p><p>You earned <b>1</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForThrillerBooks() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Da Vinci Code", Book.THRILLER);
        Rental firstRental = new Rental(book, 2);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tDa Vinci Code\t2.0<br></p><p>" +
                "Amount owed is <b>2.0</b></p><p>You earned <b>1</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForChildrensBookRentedMoreThanThresholdDays() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Tinkle", Book.CHILDRENS);
        Rental firstRental = new Rental(book, 4);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tTinkle\t3.0<br></p><p>" +
                "Amount owed is <b>3.0</b></p><p>You earned <b>1</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForThrillerBooksRentedMoreThanThresholdDays() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Da Vinci Code", Book.THRILLER);
        Rental firstRental = new Rental(book, 4);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tDa Vinci Code\t5.0<br></p><p>" +
                "Amount owed is <b>5.0</b></p><p>You earned <b>1</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForNewReleaseBooksRentedMoreThanThresholdDays() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Origin", Book.NEW_RELEASE);
        Rental firstRental = new Rental(book, 3);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tOrigin\t9.0<br></p><p>" +
                "Amount owed is <b>9.0</b></p><p>You earned <b>2</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForMultipleRentals() throws Exception {
        Customer customer = new Customer("Sarah");
        Book origin = new Book("Origin", Book.NEW_RELEASE);
        Rental firstRental = new Rental(origin, 10);
        customer.addRental(firstRental);

        Book daVinciCode = new Book("Da Vinci Code", Book.THRILLER);
        Rental secondRental = new Rental(daVinciCode, 2);
        customer.addRental(secondRental);

        Book tinkle = new Book("Tinkle", Book.CHILDRENS);
        Rental thirdRental = new Rental(tinkle, 5);
        customer.addRental(thirdRental);


        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>" +
                "\tOrigin\t30.0<br>" +
                "\tDa Vinci Code\t2.0<br>" +
                "\tTinkle\t4.5<br></p>" +
                "<p>Amount owed is <b>36.5</b></p>" +
                "<p>You earned <b>4</b> frequent renter points</p>", normalStatement);
    }

    @Test
    public void testShouldPrintHtmlStatementForInvalidBookGenre() throws Exception {
        Customer customer = new Customer("Sarah");
        Book book = new Book("Tinkle", 3);
        Rental firstRental = new Rental(book, 1);
        customer.addRental(firstRental);

        String normalStatement = customer.printHtmlStatement();

        assertEquals("<h1> Rental record for <b>Sarah</b></h1><p>\tTinkle\t0.0<br></p><p>" +
                "Amount owed is <b>0.0</b></p><p>You earned <b>1</b> frequent renter points</p>", normalStatement);
    }
}

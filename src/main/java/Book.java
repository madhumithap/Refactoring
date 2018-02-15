
public class Book {
    public static final int CHILDRENS = 2;
    public static final int THRILLER = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _price_Code;

    public Book(String _title, int _price_Code) {
        this._title = _title;
        this._price_Code = _price_Code;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public void set_price_Code(int _price_Code) {
        this._price_Code = _price_Code;
    }

    public String get_title() {
        return _title;
    }

    public int get_price_Code() {
        return _price_Code;
    }
}

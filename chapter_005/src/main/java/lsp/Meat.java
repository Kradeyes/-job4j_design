package lsp;

import java.util.Calendar;
import java.util.Date;

public class Meat extends Food {
    public Meat(String name, Calendar expireDate, Calendar createDate,
                double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}

package lsp;

import java.util.Calendar;
import java.util.Date;

public class Milk extends Food {
    public Milk(String name, Calendar expireDate, Calendar createDate,
                double price, double discount) {
        super(name, expireDate, createDate, price, discount);
    }
}

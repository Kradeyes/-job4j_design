package lsp;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Storage> storageList = List.of(new Trash(), new Shop(), new Warehouse());
        List<Food> foods = List.of(
                new Food("Milk", new GregorianCalendar(2017, Calendar.JANUARY, 25),
                        new GregorianCalendar(2017, Calendar.JANUARY, 1), 100.0, 10.0),
                  new Food("Bread", new GregorianCalendar(2021, Calendar.FEBRUARY, 18),
                          new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 100.0, 0.1),
                new Food("Meat", new GregorianCalendar(2021, Calendar.APRIL, 18),
                        new GregorianCalendar(2021, Calendar.FEBRUARY, 1), 100.0, 0.1));
        ControlQuality controlQuality = new ControlQuality(storageList);
        controlQuality.acceptAll(foods);
        var temp = controlQuality.getStorageList();
        Storage storageTrash = temp.get(0);
        Storage storageShop = temp.get(1);
        Storage storageWarehouse = temp.get(2);
        System.out.println(storageTrash.toString() + " Trash");
        System.out.println(storageShop.toString() + " Shop with discount");
        System.out.println(storageWarehouse.toString() + " Warehouse");
    }
}

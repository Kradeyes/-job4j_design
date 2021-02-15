package lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> warehouse = new ArrayList<>();

    @Override
    public boolean accept(Food food, double qualityPercent) {
        boolean rsl = false;
        if (qualityPercent < 25.0) {
            rsl = warehouse.add(food);
        }
        return rsl;
    }

    /*
    Only for Test
    */
    @Override
    public String toString() {
        return warehouse.get(0).getName();
    }
}

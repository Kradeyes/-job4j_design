package lsp;

import java.util.*;

public class Shop implements  Storage {
     private List<Food> shop = new ArrayList<>();

    @Override
    public boolean accept(Food food, double qualityPercent) {
        boolean rsl = false;
        if (qualityPercent >= 25.0 && qualityPercent < 75.0) {
            rsl = shop.add(food);
        } else if (qualityPercent >= 75.0 && qualityPercent < 100.0) {
            food.setPrice(food.getPrice() - (food.getPrice() * food.getDiscount()));
            rsl = shop.add(food);
        }
        return rsl;
    }

    @Override
    public List<Food> getAll() {
        List<Food> copy = shop;
        shop.clear();
        return copy;
    }

    /*
       Only for Test
       */
    @Override
    public String toString() {
        return shop.get(0).getName() + " " + shop.get(0).getPrice();
    }
}

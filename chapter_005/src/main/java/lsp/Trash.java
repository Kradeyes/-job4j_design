package lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    private List<Food> trash = new ArrayList<>();

    @Override
    public boolean accept(Food food, double qualityPercent) {
        boolean rsl = false;
        if (qualityPercent >= 100.0) {
            rsl = trash.add(food);
        }
        return rsl;
    }

    @Override
    public List<Food> getAll() {
        List<Food> copy = new ArrayList<>(trash);
        trash.clear();
        return copy;
    }

    /*
        Only for Test
        */
    @Override
    public String toString() {
        return trash.get(0).getName();
    }
}

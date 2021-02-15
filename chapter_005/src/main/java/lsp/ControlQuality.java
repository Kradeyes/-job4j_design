package lsp;

import java.util.GregorianCalendar;
import java.util.List;

public class ControlQuality {
  private final List<Storage> storageList;

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void accept(Food food) {
        double qualityPercent = findPercent(food);
        for (Storage storage: storageList) {
          storage.accept(food, qualityPercent);
        }
    }

    public void acceptAll(List<Food> foods) {
        foods.forEach(this::accept);
        }

    public List<Storage> getStorageList() {
        return storageList;
    }

    public double findPercent(Food food) {
        long create = food.getCreateDate().getTimeInMillis();
        long now = new GregorianCalendar().getTimeInMillis();
        long expire = food.getExpireDate().getTimeInMillis();
        long current = now - create;
        long max = expire - create;
        return (current * 100) / max;
    }
}

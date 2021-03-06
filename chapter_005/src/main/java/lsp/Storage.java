package lsp;

import java.util.List;

public interface Storage {
      boolean accept(Food food, double qualityPercent);

      List<Food> getAll();
}

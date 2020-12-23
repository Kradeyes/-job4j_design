package kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return searchValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return searchValue(value, comparator);
    }

    private <T> T searchValue(List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        for (T x:value) {
            result = comparator.compare(result, x) >= 0 ? result : x;
        }
        return result;
    }
}

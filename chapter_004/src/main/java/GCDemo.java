import java.util.LinkedList;
import java.util.List;

public class GCDemo {

    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static long info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        return  totalMemory - freeMemory;
    }

    public static void main(String[] args) {
        long memoryOccWithoutObj = info();
        System.out.println(memoryOccWithoutObj);
        User user = new User();
        long memoryOfEmptyObj = info() - memoryOccWithoutObj;
        System.out.println(memoryOfEmptyObj);
        for (int i = 0; i < 1000; i++) {
            new User(i, "N" + i);
        }
        long memoryOccByAllObj = info() -  memoryOccWithoutObj;
        System.out.println(memoryOccByAllObj);
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Testdrive {
        public static boolean generateBy(String origin, String line) {
            boolean rsl = true;
            Set<String> withOutDub = Arrays.stream(origin.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "")
                    .toLowerCase()
                    .split(" ")).collect(Collectors.toSet());
            String[] sentence = line.replaceAll("(?U)[^\\p{L}\\p{N}\\s]+", "")
                    .toLowerCase()
                    .split(" ");
            for (String x: sentence) {
        if (!withOutDub.contains(x)) {
            rsl = false;
            break;
        }
    }
            return rsl;
}
}
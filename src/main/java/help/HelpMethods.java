package help;

import java.util.stream.Stream;

public class HelpMethods {
    @SafeVarargs
    private static <T> Stream<T> getStream(T... vals) {
        return Stream.of(vals);
    }
}

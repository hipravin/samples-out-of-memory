package hipravin.samples.oom;

import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OomSamples {

    @Test
    void testInfiniteList() {
        IntStream.generate(() -> 1).boxed().collect(Collectors.toList());
    }

    @Test
    void testInfiniteIntern() {
        for(;;) {
            UUID.randomUUID().toString().intern();
        }
    }
}

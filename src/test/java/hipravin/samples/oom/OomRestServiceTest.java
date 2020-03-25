package hipravin.samples.oom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OomRestServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    //run with VW arguments:
    //-Xmx50m  -XX:+HeapDumpOnOutOfMemoryError
    //On my machine oom is thrown after 75900 requests
    public void testPingInfiniteOom() throws Exception {

        AtomicLong counter = new AtomicLong();

        for(;;) {
            ResponseEntity<String> ping  = testRestTemplate.getForEntity("http://localhost:" + port + "/api/ping", String.class);
            if(counter.incrementAndGet() % 100 ==0 ) {
                System.out.println(ping.getBody());
                System.out.println(counter.get());
            }
        }
    }
}
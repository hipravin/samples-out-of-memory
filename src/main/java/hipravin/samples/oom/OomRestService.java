package hipravin.samples.oom;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class OomRestService {
    private final Logger log = LoggerFactory.getLogger(OomRestService.class);

    @GetMapping("/ping")
    public String ping(HttpServletRequest request) {
        log.trace("req from {}, session id {}", request.getRemoteHost(), request.getSession().getId());
        return "pong";
    }
}

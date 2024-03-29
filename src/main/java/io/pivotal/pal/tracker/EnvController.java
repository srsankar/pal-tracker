package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private String port;
    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceAddr;


    public EnvController(@Value("${port:9999}") String port, @Value("${MEMORY_LIMIT:200}") String memoryLimit, @Value("${CF_INSTANCE_INDEX:NOT SET}") String cfInstanceIndex, @Value("${CF_INSTANCE_ADDR:UNKNOWN}") String cfInstanceAddr ){
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;

    }

    @GetMapping("/env")
    public Map getEnv() {
        Map<String, String> env = new HashMap<>();

        env.put("PORT", port);
        env.put("MEMORY_LIMIT", memoryLimit);
        env.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return env;

    }
}

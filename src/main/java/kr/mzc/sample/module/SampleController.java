package kr.mzc.sample.module;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/")
    public String root() {
        JSONObject j = new JSONObject();
        j.put("Hello", "World");
        return j.toString();
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}

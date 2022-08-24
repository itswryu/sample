package kr.mzc.sample.module;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/")
    public String root() {
        JSONObject j = new JSONObject();
        j.put("Hello", "World");
        j.put("build-info", sampleService.getBuildInfo());

        return j.toString();
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}

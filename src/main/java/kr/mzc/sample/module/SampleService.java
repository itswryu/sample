package kr.mzc.sample.module;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    @Autowired
    BuildProperties buildProp;

    @Bean
    public JSONObject getBuildInfo() {
        JSONObject buildInfo = new JSONObject();
        buildInfo.put("name", buildProp.getName());
        buildInfo.put("group", buildProp.getGroup());
        buildInfo.put("artifact", buildProp.getArtifact());
        buildInfo.put("version", buildProp.getVersion());
        buildInfo.put("time", buildProp.getTime());

        return buildInfo;
    }
}

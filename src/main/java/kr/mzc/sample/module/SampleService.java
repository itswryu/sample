package kr.mzc.sample.module;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;

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

    @Bean
    public JSONObject getServerInfo() {
        JSONObject buildInfo = new JSONObject();
        try {
            buildInfo.put("hostname", java.net.InetAddress.getLocalHost().getHostName());
        } catch (Exception e){
            buildInfo.put("hostname", "Unknown");
        }
        try {
            buildInfo.put("ip", java.net.InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e){
            buildInfo.put("ip", "Unknown");
        }

        return buildInfo;
    }
}

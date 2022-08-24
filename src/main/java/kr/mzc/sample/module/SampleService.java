package kr.mzc.sample.module;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
        ZonedDateTime utcZoned = ZonedDateTime.parse(buildProp.getTime().toString());
        ZoneId kstZone = ZoneId.of("Asia/Seoul");
        ZonedDateTime kstZoned = utcZoned.withZoneSameInstant(kstZone);
        LocalDateTime kstLocal = kstZoned.toLocalDateTime();
        buildInfo.put("time", kstLocal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

        return buildInfo;
    }

    @Bean
    public JSONObject getServerInfo() {
        JSONObject serverInfo = new JSONObject();
        try {
            serverInfo.put("hostname", java.net.InetAddress.getLocalHost().getHostName());
        } catch (Exception e){
            serverInfo.put("hostname", "Unknown");
        }
        try {
            serverInfo.put("ip", java.net.InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e){
            serverInfo.put("ip", "Unknown");
        }

        return serverInfo;
    }
}

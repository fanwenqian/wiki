package com.fan.wiki.init;

import com.fan.wiki.constant.GlobalConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

/**
 * 启动成功时打印内容
 *
 * @author fan.wenqian
 * @date 2022-05-19
 */
@Component
@Order(1)
@Slf4j
public class SuccessCommandLineRunner implements CommandLineRunner {

    @Resource
    ResourceLoader resourceLoader;
    @Resource
    private Environment env;

    @Override
    public void run(String... args) throws Exception {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        System.out.println(GlobalConst.Console.LINE);
        try {
            org.springframework.core.io.Resource resource = resourceLoader.getResource("classpath:success.txt");
            is = resource.getInputStream();
            isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (Exception e) {
            System.out.println("启动成功，如果您想自定义启动成功标识，您可以在工程src/resources下创建success.txt文件，并写入启动成功输出的信息");
        } finally {
            if (br != null) {
                br.close();
            }
            if (isr != null) {
                isr.close();
            }
            if (is != null) {
                is.close();
            }
        }
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        if(!StringUtils.hasText(port)) {
            port = "8080";
        }
        String path = env.getProperty("server.servlet.context-path");
        if(!StringUtils.hasText(path)) {
            path = "";
        }
        System.out.printf("Local服务地址: http://localhost:%s%s%n", port, path);
        System.out.printf("External服务地址: http://%s:%s%s%n", ip, port, path);
        System.out.println(GlobalConst.Console.LINE);
    }
}

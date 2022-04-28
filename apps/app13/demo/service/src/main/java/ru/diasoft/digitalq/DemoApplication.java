package ru.diasoft.digitalq;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import lombok.Generated;

@EnableDiscoveryClient
@EnableCaching
@SpringBootApplication(scanBasePackages = {"ru.diasoft.micro", "ru.diasoft.digitalq"})
@Generated
@SuppressWarnings({"java:S4604"})
public class DemoApplication {

    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    @SuppressWarnings({"java:S1148", "Diasoft-Java-Custom:FindReflectionCheck"})
    public static void main(String[] args) throws UnknownHostException {
        try {
            Environment env = SpringApplication.run(DemoApplication.class, args).getEnvironment();
            int port = StringUtils.isBlank(env.getProperty("server.port")) ?
                    80 : Integer.parseInt(env.getProperty("server.port"));
            String contextPath = env.getProperty("server.servlet.context-path");
            contextPath = StringUtils.isBlank(contextPath) ? "/" : contextPath;
            String kafkaInfo = env.getProperty("spring.kafka.bootstrap-servers");
            logger.debug(
                    "\n----------------------------------------------------------\n\t"
                            + "Application {} is running! Access URLs:\n\t"
                            + "Local: \t\thttp://127.0.0.1:{}{}\n\t"
                            + "External: \thttp://{}:{}{}\n\t"
                            + "Kafka host and port: {}"
                            + "\n----------------------------------------------------------\n",
                    env.getProperty("spring.application.name"),
                    port,
                    contextPath,
                    InetAddress.getLocalHost().getHostAddress(),
                    port,
                    contextPath,
                    kafkaInfo != null ? kafkaInfo : "undefined");

        } catch (RuntimeException ex) {
            if (!ex.getClass().getSimpleName().contains("SilentExitException")) {
                ex.printStackTrace();
            }
            throw ex;
        }
    }

}

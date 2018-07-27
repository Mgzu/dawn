package org.dawn;

import org.dawn.utils.SpringBeanUtil;
import org.dawn.utils.WebSocketUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Dawn 启动类
 *
 * @author mgzu
 * @date 2018/7/11
 */
@SpringBootApplication
@MapperScan("org.dawn.mapper")
public class DawnApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(DawnApplication.class, args);
        SpringBeanUtil.setApplicationContext(app);
        // 更改 WebSocketMessageBroker 聚合信息记录时间，30 minutes -> 1 minutes
        WebSocketUtil.setWebSocketMessageBrokerLoggingPeriod(60 * 1000);
    }
}

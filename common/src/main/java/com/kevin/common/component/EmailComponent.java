package com.kevin.common.component;

import com.kevin.common.config.ThreadPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author:Kevin
 * @Date:Created in 15:13 2021/4/25
 */
@Component
public class EmailComponent {

    private static Logger logger = LoggerFactory.getLogger(EmailComponent.class);

    @Async(ThreadPoolConfig.EXECUTOR_NAME)
    public boolean sendEmail(String to, String from, String subject, String content) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("enter send email");
        return true;
    }
}

package com.kevin.common.config;

import com.kevin.common.util.ContextCopyingDecorator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author:Kevin
 * @Date:Created in 15:00 2021/4/25
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig implements AsyncConfigurer {
    public static final int cpuNum = Runtime.getRuntime().availableProcessors();
    public static final String EXECUTOR_NAME = "taskExecutor";
    /**
     * 线程池配置
     *
     * @return
     */
    @Bean(EXECUTOR_NAME)
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(cpuNum);
        taskExecutor.setTaskDecorator(new ContextCopyingDecorator());
        taskExecutor.setMaxPoolSize(cpuNum * 2);
        taskExecutor.setQueueCapacity(2);
        taskExecutor.setAwaitTerminationSeconds(60);
        taskExecutor.setKeepAliveSeconds(60);
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setThreadNamePrefix("thread-pool-");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }

}

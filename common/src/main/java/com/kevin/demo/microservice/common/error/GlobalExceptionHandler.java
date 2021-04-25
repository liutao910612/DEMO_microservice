package com.kevin.demo.microservice.common.error;

import com.kevin.util.web.ResponseBuilder;
import com.kevin.util.web.RestfulResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * global exception handler
 * @Author:Kevin
 * @Date:Created in 14:03 2021/4/25
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public RestfulResponse handlerException(Exception exception){
        logger.error("Internal service exception",exception);
        return ResponseBuilder.buildFailResponse(buildErrorMessage(exception));
    }

    private String buildErrorMessage(Exception exception){
        StringBuilder msg = new StringBuilder();
        msg.append(exception.getMessage()).append("\n");
        StackTraceElement[] stackTraceElements = exception.getStackTrace();
        for (int i = 0; i <stackTraceElements.length ; i++) {
            msg.append(stackTraceElements[i]).append("\n");
        }
        return msg.toString();
    }
}

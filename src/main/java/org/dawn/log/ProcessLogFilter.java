package org.dawn.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.sql.Date;
import java.text.DateFormat;

/**
 * 系统日志过滤器
 *
 * @author mgzu
 * @date 2018/7/19
 */
public class ProcessLogFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent event) {
        LoggerMessage loggerMessage = new LoggerMessage(event.getMessage(),
                DateFormat.getDateTimeInstance().format(new Date(event.getTimeStamp())), event.getThreadName(),
                event.getLoggerName(), event.getLevel().levelStr);
        LoggerQueue.getInstance().push(loggerMessage);
        return FilterReply.ACCEPT;
    }
}
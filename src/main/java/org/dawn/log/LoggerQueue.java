package org.dawn.log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 日志队列
 *
 * @author mgzu
 * @date 2018/7/19
 */
public class LoggerQueue {

    /**
     * 队列大小
     * 默认为 10000
     */
    public static final int QUEUE_MAX_SIZE = 10000;
    private static LoggerQueue alarmMessageQueue = new LoggerQueue();
    //
    /**
     * blockingQueue
     * 用于记录进程内的日志
     */
    private BlockingQueue<LoggerMessage> blockingQueue = new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

    private LoggerQueue() {
    }

    public static LoggerQueue getInstance() {
        return alarmMessageQueue;
    }

    /**
     * 消息入队
     * 队列满了就抛出异常，不阻塞
     *
     * @param log 日志
     * @return boolean
     */
    public boolean push(LoggerMessage log) {
        return this.blockingQueue.add(log);
    }

    /**
     * 消息出队
     *
     * @return LoggerMessage
     */
    public LoggerMessage poll() {
        LoggerMessage result = null;
        try {
            result = this.blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
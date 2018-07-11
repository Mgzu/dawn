package org.dawn.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.socket.config.WebSocketMessageBrokerStats;
import org.springframework.web.socket.messaging.SubProtocolWebSocketHandler;

public class WebScoketUtil {

	public static int getCurrentWsSubjectNumber()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException,
			InstantiationException, InvocationTargetException, NoSuchMethodException {
		// get WebSocketMessageBrokerStats
		WebSocketMessageBrokerStats brokerStats = (WebSocketMessageBrokerStats) SpringBeanUtil
				.getBean("webSocketMessageBrokerStats");
		// get SubProtocolWebSocketHandler
		Field messageBrokerField = WebSocketMessageBrokerStats.class.getDeclaredField("webSocketHandler");
		messageBrokerField.setAccessible(true);
		SubProtocolWebSocketHandler webSocketHandler = (SubProtocolWebSocketHandler) messageBrokerField
				.get(brokerStats);
		// get stats instance
		Field statsField = SubProtocolWebSocketHandler.class.getDeclaredField("stats");
		statsField.setAccessible(true);
		Object statsInstance = statsField.get(webSocketHandler);
		// get webSocket
		Field webSocketField = statsInstance.getClass().getDeclaredField("webSocket");
		webSocketField.setAccessible(true);
		AtomicInteger webSocket = (AtomicInteger) webSocketField.get(statsInstance);
		return webSocket.get();
	}

	public static void setWebSocketMessageBrokerLoggingPeriod(long time) {
		WebSocketMessageBrokerStats brokerStats = (WebSocketMessageBrokerStats) SpringBeanUtil
				.getBean("webSocketMessageBrokerStats");
		brokerStats.setLoggingPeriod(time);
	}
}

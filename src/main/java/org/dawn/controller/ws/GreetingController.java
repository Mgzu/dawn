package org.dawn.controller.ws;

import java.lang.reflect.InvocationTargetException;

import org.dawn.dto.Greeting;
import org.dawn.dto.HelloMessage;
import org.dawn.utils.WebSocketUtil;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		int number = 0;
		try {
			number = WebSocketUtil.getCurrentWebSocketSubjects();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!", number);
	}
}

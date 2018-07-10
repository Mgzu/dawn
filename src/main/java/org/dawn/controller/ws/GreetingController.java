package org.dawn.controller.ws;

import org.dawn.dto.Greeting;
import org.dawn.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		// Thread.sleep(1000); // 模拟延迟
		// 暂未找到获取当前 WS 所有用户的方法
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!", "1");
	}
}

package org.dawn.controller.rest;

import java.lang.reflect.InvocationTargetException;

import org.dawn.dto.RestDto;
import org.dawn.utils.WebSocketUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MessageController {

	@RequestMapping("number")
	public Object home() {
		int number = 0;
		try {
			number = WebSocketUtil.getCurrentWebSocketSubjects();
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return new RestDto(number);
	}
}

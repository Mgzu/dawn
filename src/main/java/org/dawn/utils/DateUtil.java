package org.dawn.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author mgzu
 * @date 2018/7/11
 */
public class DateUtil {

	/**
	 * 获取下一天。
	 *
	 * @param date
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		return calendar.getTime();
	}

}

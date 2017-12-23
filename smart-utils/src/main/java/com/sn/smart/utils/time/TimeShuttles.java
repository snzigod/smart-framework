package com.sn.smart.utils.time;

import java.util.Calendar;
import java.util.Date;

/**
 * 时光穿梭机
 * 
 * @author gxzhou2
 *
 */
public class TimeShuttles {

	/**
	 * 时光穿梭类型
	 * 
	 * @author gxzhou2
	 *
	 */
	public enum TimeShuttleType {
		/**
		 * 日
		 */
		DAY,
		/**
		 * 月
		 */
		MONTH,
		/**
		 * 年
		 */
		YEAR,
		/**
		 * 周
		 */
		WEEK,
		/**
		 * 季
		 */
		SEASON;
	}

	/**
	 * 获取最早时间
	 * 
	 * @param date
	 *            待穿梭时间
	 * @param timeShuttleType
	 *            时光穿梭类型
	 * @return 最早时间
	 */
	public static Date getStartTime(Date date, TimeShuttleType timeShuttleType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getMinimum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getMinimum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getMinimum(Calendar.SECOND));
		switch (timeShuttleType) {
		case MONTH:
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getMinimum(Calendar.DAY_OF_MONTH));
			break;
		case YEAR:
			calendar.set(Calendar.DAY_OF_YEAR, calendar.getMinimum(Calendar.DAY_OF_YEAR));
			break;
		case WEEK:
			calendar.set(Calendar.DAY_OF_WEEK, calendar.getMinimum(Calendar.DAY_OF_WEEK));
			break;
		case SEASON:
			calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) / 3) * 3);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getMinimum(Calendar.DAY_OF_MONTH));
			break;
		default:
		}
		return calendar.getTime();
	}

	/**
	 * 获取最晚时间
	 * 
	 * @param date
	 *            待穿梭时间
	 * @param timeShuttleType
	 *            时光穿梭类型
	 * @return 最晚时间
	 */
	public static Date getEndTime(Date date, TimeShuttleType timeShuttleType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, calendar.getMaximum(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.MINUTE, calendar.getMaximum(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, calendar.getMaximum(Calendar.SECOND));
		switch (timeShuttleType) {
		case MONTH:
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			break;
		case YEAR:
			calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
			break;
		case WEEK:
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			break;
		case SEASON:
			calendar.set(Calendar.MONTH, (calendar.get(Calendar.MONTH) / 3) * 3 + 2);
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			break;
		default:
		}
		return calendar.getTime();
	}

}

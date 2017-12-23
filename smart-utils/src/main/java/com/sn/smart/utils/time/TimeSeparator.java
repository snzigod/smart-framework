package com.sn.smart.utils.time;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间分片器
 * 
 * @author gxzhou2
 *
 */
public class TimeSeparator {

	/**
	 * 时间类型
	 * 
	 * @author gxzhou2
	 *
	 */
	public enum TimeRangeType {
		/**
		 * 秒
		 */
		SECOND("yyyyMMdd HH:mm:ss"),
		/**
		 * 分
		 */
		MINUTE("yyyyMMdd HH:mm"),
		/**
		 * 时
		 */
		HOUR("yyyyMMdd HH"),
		/**
		 * 日
		 */
		DAY("yyyyMMdd"),
		/**
		 * 月
		 */
		MONTH("yyyyMM"),
		/**
		 * 年
		 */
		YEAR("yyyy");

		private String value;

		TimeRangeType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * 根据开始结束时间获取时间段
	 * 
	 * @param dateStart
	 *            开始时间
	 * @param dateEnd
	 *            结束时间
	 * @param timeType
	 *            时间类型
	 * @return 时间段
	 */
	public static List<Date> getTimeList(Date dateStart, Date dateEnd, TimeRangeType timeType) {
		List<Date> dateList = new ArrayList<Date>();
		dateList.add(dateStart);
		Calendar calendarStart = Calendar.getInstance();
		calendarStart.setTime(dateStart);
		Calendar calendarEnd = Calendar.getInstance();
		if (timeType == TimeRangeType.SECOND) {
			calendarEnd.setTime(dateEnd);
		} else {
			calendarEnd.setTime(dateEnd);
		}
		while (dateEnd.after(calendarStart.getTime())) {
			switch (timeType) {
			case MINUTE:
				calendarStart.add(Calendar.MINUTE, 1);
				break;
			case HOUR:
				calendarStart.add(Calendar.HOUR, 1);
				break;
			case DAY:
				calendarStart.add(Calendar.DAY_OF_MONTH, 1);
				break;
			case MONTH:
				calendarStart.add(Calendar.MONTH, 1);
				break;
			case YEAR:
				calendarStart.add(Calendar.YEAR, 1);
				break;
			default:
				calendarStart.add(Calendar.SECOND, 1);
			}
			if (calendarStart.getTime().after(calendarEnd.getTime())) {
				break;
			}
			dateList.add(calendarStart.getTime());
		}
		return dateList;
	}

}

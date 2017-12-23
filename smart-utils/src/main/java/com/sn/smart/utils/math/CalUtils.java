package com.sn.smart.utils.math;

import java.math.BigDecimal;

/**
 * 运算工具
 * 
 * @author gxzhou2
 *
 */
public class CalUtils {

	/**
	 * 默认值
	 */
	private final static Integer DFBD = 0;

	/**
	 * 获取合法BigDecimal
	 * 
	 * @param bd
	 * @return
	 */
	public static BigDecimal getBigDecimal(BigDecimal bd) {
		return getBigDecimal(bd, DFBD);
	}

	/**
	 * 获取合法BigDecimal
	 * 
	 * @param bd
	 * @return
	 */
	public static BigDecimal getBigDecimal(Integer bd) {
		return getBigDecimal(bd, DFBD);
	}

	/**
	 * 获取合法BigDecimal
	 * 
	 * @param bd
	 * @return
	 */
	public static BigDecimal getBigDecimal(String bd) {
		return getBigDecimal(bd, DFBD);
	}

	/**
	 * 获取合法BigDecimal
	 * 
	 * @param bd
	 * @param dfdb
	 * @return
	 */
	public static BigDecimal getBigDecimal(BigDecimal bd, Integer dfdb) {
		if (bd == null) {
			return new BigDecimal(dfdb);
		} else {
			return bd;
		}
	}

	/**
	 * 获取合法BigDecimal
	 * 
	 * @param bd
	 * @param dfdb
	 * @return
	 */
	public static BigDecimal getBigDecimal(Integer bd, Integer dfdb) {
		if (bd == null) {
			return new BigDecimal(dfdb);
		} else {
			return new BigDecimal(bd);
		}
	}

	/**
	 * 获取合法BigDecimal
	 * 
	 * @param bd
	 * @param dfdb
	 * @return
	 */
	public static BigDecimal getBigDecimal(String bd, Integer dfdb) {
		if (bd == null) {
			return new BigDecimal(dfdb);
		} else {
			return new BigDecimal(bd);
		}
	}

	/**
	 * 获取合法BigDecimal汇总
	 * 
	 * @param bds
	 * @return
	 */
	public static BigDecimal getSumBigDecimal(BigDecimal... bds) {
		BigDecimal sum = new BigDecimal(DFBD);
		for (BigDecimal bd : bds) {
			sum = sum.add(getBigDecimal(bd));
		}
		return sum;
	}

}

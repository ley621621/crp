/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: DateUtil.java 
 *
 * @Date:  2016年8月30日  下午3:52:51
 *
 * @Package com.dossp.mcprc.cnm.common.util
 */


package com.dossp.crp.common.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年8月30日 下午3:52:51
 * </p>
 * 描述：
 *
 */

public final class DateUtil {
	
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date now() {
		return DateTime.now().toDate();
	}
	
	/**
	 * 根据格式来格式化字符串为日期类型
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseDate(String dateStr, String formatStr) {
		if(StringUtils.isBlank(dateStr) || StringUtils.isBlank(formatStr)) {
			return null;
		}
		DateTimeFormatter format = DateTimeFormat.forPattern(formatStr);
		DateTime dateTime = DateTime.parse(dateStr, format); 
		return dateTime.toDate();
	}
	
	/**
	 * 根据格式来格式化日期
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static String formateDate(Date date, String formatStr) {
		if(StringUtils.isBlank(formatStr)) {
			return null;
		}
		DateTimeFormatter format = DateTimeFormat.forPattern(formatStr);
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(format);
	}
	
	/**
	 * 根据格式来格式化当前日期
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static String formateLocaleDate(String formatStr) {
		Date date = new Date();
		return formateDate(date, formatStr);
	}
	
	/**
	 * 格式化字符串为本地日期类型
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseLocalDate(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd");
	}
	
	/**
	 * 格式化字符串为本地日期时间类型
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date parseLocalTime(String dateStr) {
		return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取当前年
	 * @return
	 */
	public static String currentYear() {
		return String.valueOf(DateTime.now().getYear());
	}
	/**
	 * 获取当前月
	 * @return
	 */
	public static String currentMonth() {
		return String.valueOf(DateTime.now().getMonthOfYear());
	}
	/**
	 * 获取下一个月
	 * @param formatStr
	 * @return
	 */
	public static String nextMonth(String formatStr){
		DateTime date = DateTime.now().plusMonths(1);
		return formateDate(date.toDate(), formatStr);
	}
	
	/**
	 * 获取当前日
	 * @return
	 */
	public static String currentDay() {
		return String.valueOf(DateTime.now().getDayOfMonth());
	}
	
	/**
	 * 获取上一年
	 * @return
	 */
	public static String prevYear() {
		return String.valueOf(DateTime.now().minusYears(1).getYear());
	}
	
	/**
	 * 获取下一年
	 * @return
	 */
	public static String nextYear() {
		return String.valueOf(DateTime.now().plusYears(1).getYear());
	}
	
	/**
	 * 获取指定天的前一天
	 * @param dateStr 日期字符串
	 * @param formatStr 传入的日期格式
	 * @param formatStrResult 返回的日期格式
	 * @return
	 */
	public static String prevDay(String dateStr, String formatStr, String formatStrResult) {
		
		DateTimeFormatter format = DateTimeFormat.forPattern(formatStr);
		DateTime date = DateTime.parse(dateStr, format).minusDays(1);
		return formateDate(date.toDate(), formatStrResult);
	}
	
	/**
	 * 获取指定天的下一个月
	 * @param dateStr 日期字符串
	 * @param formatStr 传入的日期格式
	 * @param formatStrResult 返回的日期格式
	 * @return
	 */
	public static String dayNextMonth(String dateStr, String formatStr, String formatStrResult) {
		
		DateTimeFormatter format = DateTimeFormat.forPattern(formatStr);
		DateTime date = DateTime.parse(dateStr, format).plusMonths(1);
		return formateDate(date.toDate(), formatStrResult);
	}
	
	/**
	 * 获取指定天的下一个月
	 * @param dateStr 日期字符串
	 * @param formatStr 传入的日期格式
	 * @param formatStrResult 返回的日期格式
	 * @return
	 */
	public static String dayMonth(String dateStr, String formatStr, String formatStrResult) {
		
		DateTimeFormatter format = DateTimeFormat.forPattern(formatStr);
		DateTime date = DateTime.parse(dateStr, format);
		return formateDate(date.toDate(), formatStrResult);
	}
	
	public static void main(String[] args) {
		System.out.println(prevDay("2016-1-1", "yyyy-MM-dd", "yyyy-MM"));
		System.out.println(dayNextMonth("2015-12-21", "yyyy-MM-dd", "yyyy-MM"));
		System.out.println(nextMonth("yyyy-MM-dd"));
	}

}

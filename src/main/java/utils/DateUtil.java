package utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 对按指定格式对日期进行转换
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger("csworkorderLog");

    /**
     * 默认的日期格式
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final int FMT_DATE_YYYY = 0;
    public static final int FMT_DATE_YYYYMMDD = 1;
    public static final int FMT_DATE_YYYYMMDD_HHMMSS = 2;
    public static final int FMT_DATE_HHMMSS = 3;
    public static final int FMT_DATE_HHMM = 4;
    public static final int FMT_DATE_SPECIAL = 5;
    /**
     * 日期转换格式：MM-dd
     */
    public static final int FMT_DATE_MMDD = 6;
    public static final int FMT_DATE_YYYYMMDDHHMM = 7;
    public static final int FMT_DATE_MMDD_HHMM = 8;
    public static final int FMT_DATE_MMMDDD = 9;
    public static final int FMT_DATE_YYYYMMDDHHMM_NEW = 10;
    public static final int FMT_DATE_YYYY_MM_DD = 11;
    public static final int FMT_DATE_YYYYMMDDHHMMSS = 12;
    public static final int FMT_DATE_YYMMDD = 13;
    public static final int FMT_DATE_YYMMDDHH = 14;
    public static final int FMT_DATE_MMDD_HHMM_CH = 15;

    /**
     * @add by wangmeng 添加日期转换格式MMdd
     */
    public static final int FMT_DATE_MMdd = 16;

    /** 静态常量值 用于获取 某一个日期的 年 月 日 时 分 秒 标识 **/
    public static final int GET_TIME_OF_YEAR = 100;// 获得 日期的年份
    public static final int GET_TIME_OF_MONTH = 200;// 获得 日期的月份
    public static final int GET_TIME_OF_DAY = 300;// 获取 日期的天
    public static final int GET_TIME_IF_HOUR = 400;// 获取日期的小时
    public static final int GET_TIME_OF_MINUTE = 500;
    public static final int GET_TIME_OF_SECOND = 600;

    // 一天的毫秒数
    public static final long MS_ONE_DAY = 24*60*60*1000L;
    public static final String H_24_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String H_24_FORMAT_2 = "yyyy年MM月dd日 HH:mm:ss";
    public static final String H_24_FORMAT_MS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String H_24_FORMAT_MM = "yyyy-MM-dd HH:mm";

    // 一小时的毫秒数
    public static final long MS_ONE_HOUSE = 60*60*1000L;

    /**
     * 时间中文单位
     */
    private static final String[] TIME_ZH_UNIT = new String[] { "年", "月", "天", "时", "分", "秒", "毫秒" };

    /**
     * 单位时间的毫秒数 与TIME_ZH_UNIT对应并且配合使用
     */
    private static final long[] UNIT_TIME_MILLIS = new long[] { 365 * MS_ONE_DAY, 30 * MS_ONE_DAY, MS_ONE_DAY,
            MS_ONE_HOUSE, 60 * 1000L, 1000L, 1 };

    public static int TIME_UNIT_YEAR = 0;

    public static int TIME_UNIT_MONTH = 1;

    public static int TIME_UNIT_DAY = 2;

    public static int TIME_UNIT_HOUR = 3;

    public static int TIME_UNIT_MINUTE = 4;

    public static int TIME_UNIT_SECONDS = 5;

    public static int TIME_UNIT_MILLIS = 6;

    /**
     * 按自定义日期格式格式化日期
     *
     * @param target
     * @param format
     * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
     */
    public static String formatDate(Date target, String format) {

        if (target == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(target);
    }

    /**
     * 按默认日期格式 格式化日期
     *
     * @param target
     * @return 格式化后的日期字符串，如果传入的日期对象为NULL，返回空字符串
     */
    public static String formatDate(Date target) {

        return formatDate(target, DEFAULT_DATE_FORMAT);
    }

    /**
     * 将字符串格式化为日期对象
     *
     * @param date
     * @param format
     * @return 如果date为空或格式不标准，返回NULL，否则返回对应的日期对象
     */
    public static Date formatToDate(String date, String format) {

        try {
            if (StringUtils.isBlank(date)) {
                return null;
            }

            SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
            return new Date(sorceFmt.parse(date).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date formatToDate(String date, int nFmt) {

        String format = DEFAULT_DATE_FORMAT;
        switch (nFmt) {
            default:
            case FMT_DATE_YYYY:
                format = "yyyy";
                break;
            case FMT_DATE_YYYYMMDD:
                format = "yyyy-MM-dd";
                break;
            case FMT_DATE_YYYYMMDD_HHMMSS:
                format = "yyyy-MM-dd HH:mm:ss";
                break;
            case FMT_DATE_HHMM:
                format = "HH:mm";
                break;
            case FMT_DATE_HHMMSS:
                format = "HH:mm:ss";
                break;
            case FMT_DATE_SPECIAL:
                format = "yyyyMMdd";
                break;
            case FMT_DATE_MMDD:
                format = "MM-dd";
                break;
            case FMT_DATE_MMdd:
                format = "MMdd";
                break;
            case FMT_DATE_YYYYMMDDHHMM:
                format = "yyyy-MM-dd HH:mm";
                break;
            case FMT_DATE_MMDD_HHMM:
                format = "MM-dd HH:mm";
                break;
            case FMT_DATE_MMMDDD:
                format = "MM月dd日";
                break;
            case DateUtil.FMT_DATE_YYYYMMDDHHMM_NEW:
                format = "yyyyMMddHHmm";
                break;
            case DateUtil.FMT_DATE_YYYY_MM_DD:
                format = "yyyy年MM月dd日";
                break;
            case DateUtil.FMT_DATE_YYYYMMDDHHMMSS:
                format = "yyyyMMddHHmmss";
                break;
            case FMT_DATE_YYMMDD:
                format = "yyMMdd";
                break;
            case FMT_DATE_YYMMDDHH:
                format = "yyyyMMddHH";
                break;
            case FMT_DATE_MMDD_HHMM_CH:
                format = "MM月dd日HH时mm分";
                break;
        }

        return formatToDate(date, format);
    }

    /**
     * 将字符串格式化为日期对象
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Timestamp formatToTimestamp(String dateStr, String format) {
        if(dateStr==null||format==null) return null;
        try {
            SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
            return new Timestamp(sorceFmt.parse(dateStr).getTime()); // 一天的时间24*3600*1000
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将Timestamp对象格式化
     *
     * @param time
     * @param format
     * @return 格式化后的日期字符串，如果传入的Timestamp对象为NULL，返回空字符串
     */
    public static String formatTimestamp(Timestamp time, String format) {

        if (time == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(time);
    }


    public static Date getYesterDay() {

        return dateAddDays(new Date(), -1);
    }

    /**
     * 明天
     * @return
     */
    public static Date getTomorrow(){

        return dateAddDays(new Date(), 1);
    }

    public static Date getFirstTimeInDay(Date dateTime) {

        String simpleString = formatDate(dateTime, "yyyyMMdd");
        return formatToDate(simpleString, "yyyyMMdd");
    }

    public static long formatDayTime(String day){
        return formatToDate(day, "yyyyMMdd").getTime();
    }

    /**
     * 对日期增加指定的数目
     * @param date
     * @param field
     * @param addNum
     * @return
     */
    public static Date dateAdd(Date date, int field, int addNum){

        try{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(field, addNum);
            return calendar.getTime();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 增加指定天数
     * @param date
     * @param addDays
     * @return
     */
    public static Date dateAddDays(Date date, int addDays) {

        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE, addDays);
            return cal.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 增加x小时
     * @param date
     * @param hour
     * @return
     */
    public static Date dateAddHours(Date date, int hour){

        if(date == null){
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);

        return calendar.getTime();
    }

    public static Date getFirstDayOfWeek(Date date) {

        Date newDate = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            newDate = cal.getTime();
        } catch (Exception e) {
            return null;
        }
        return newDate;
    }
    public static Date getFirstDayOfMonth(Date date) {

        Date newDate = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setFirstDayOfWeek(Calendar.MONDAY);
            cal.setTime(date);
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
            newDate = cal.getTime();
        } catch (Exception e) {
            return null;
        }
        return newDate;
    }
    public static void main(String[] args) {
        Date d = new Date();
        Date d2 = dateAddDays(d,-3);
        System.out.println("d2:"+formatDate(d2));
        System.out.println(formatDate(getFirstDayOfWeek(d)));
        System.out.println(formatDate(getFirstDayOfWeek(d2)));


        System.out.println("==============================");
        Date d3 = new Date();
        Date d4 = dateAddDays(d3,-31);
        System.out.println("d4:"+formatDate(d4));
        System.out.println(formatDate(getFirstDayOfMonth(d3)));
        System.out.println(formatDate(getFirstDayOfMonth(d4)));
    }

    public static Timestamp getCurrentTimestamp() {

        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获得一个date 类型的 某个 特殊的 内容 比如 返回 时间的 年 、月、日、时、分、秒
     *
     * @param date
     * @param flag
     * @return
     */
    public static String getPartTime(Date date, int flag) {

        if (date == null) {
            return "";
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int result = 0;
        switch (flag) {
            case GET_TIME_OF_YEAR:
                result = cal.get(Calendar.YEAR);
                break;

            case GET_TIME_OF_MONTH:
                result = cal.get(Calendar.MONTH) + 1;
                break;

            case GET_TIME_OF_DAY:
                result = cal.get(Calendar.DAY_OF_MONTH);
                break;

            case GET_TIME_IF_HOUR:
                result = cal.get(Calendar.HOUR_OF_DAY);
                break;

            case GET_TIME_OF_MINUTE:
                result = cal.get(Calendar.MINUTE);
                break;

            case GET_TIME_OF_SECOND:
                result = cal.get(Calendar.SECOND);
                break;

            default:// 注意默认返回一个时间的年份
                result = cal.get(Calendar.YEAR);
                break;

        }
        return String.valueOf(result);
    }

    public static String formatNowTime(int nFmt) {

        Calendar cal = Calendar.getInstance();

        return formatDate(cal.getTime(), nFmt);
    }

    public static String formatDate(Date date, int nFmt) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat fmtDate = new SimpleDateFormat();
        switch (nFmt) {
            default:
            case FMT_DATE_YYYY:
                fmtDate.applyLocalizedPattern("yyyy");
                break;
            case FMT_DATE_YYYYMMDD:
                fmtDate.applyPattern("yyyy-MM-dd");
                break;
            case FMT_DATE_YYYYMMDD_HHMMSS:
                fmtDate.applyPattern("yyyy-MM-dd HH:mm:ss");
                break;
            case FMT_DATE_HHMM:
                fmtDate.applyPattern("HH:mm");
                break;
            case FMT_DATE_HHMMSS:
                fmtDate.applyPattern("HH:mm:ss");
                break;
            case FMT_DATE_SPECIAL:
                fmtDate.applyPattern("yyyyMMdd");
                break;
            case FMT_DATE_MMDD:
                fmtDate.applyPattern("MM-dd");
                break;
            case FMT_DATE_MMdd:
                fmtDate.applyPattern("MMdd");
                break;
            case FMT_DATE_YYYYMMDDHHMM:
                fmtDate.applyPattern("yyyy-MM-dd HH:mm");
                break;
            case FMT_DATE_MMDD_HHMM:
                fmtDate.applyPattern("MM-dd HH:mm");
                break;
            case FMT_DATE_MMMDDD:
                fmtDate.applyPattern("MM月dd日");
                break;
            case DateUtil.FMT_DATE_YYYYMMDDHHMM_NEW:
                fmtDate.applyPattern("yyyyMMddHHmm");
                break;
            case DateUtil.FMT_DATE_YYYY_MM_DD:
                fmtDate.applyPattern("yyyy年MM月dd日");
                break;
            case DateUtil.FMT_DATE_YYYYMMDDHHMMSS:
                fmtDate.applyPattern("yyyyMMddHHmmss");
                break;
            case FMT_DATE_YYMMDD:
                fmtDate.applyPattern("yyMMdd");
                break;
            case FMT_DATE_YYMMDDHH:
                fmtDate.applyPattern("yyyyMMddHH");
                break;
            case FMT_DATE_MMDD_HHMM_CH:
                fmtDate.applyPattern("MM月dd日HH时mm分");
                break;
        }
        return fmtDate.format(date);
    }

    public static Timestamp getToday(Timestamp ts) {

        try {
            String dateStr = formatDate(ts, FMT_DATE_YYYYMMDD);
            SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
            return new Timestamp(fmtDate.parse(dateStr).getTime());
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将日期按照指定的天数增加或者减少，并转换为需要的日期格式
     *
     * @param sourceFormat
     *            原始日期格式
     * @param date2Get
     *            需要转换成的日期
     *            需要转换的格式
     * @return date2Get 成功：转换后的日期，失败：null
     */

    public static Date getIntervalDateFormat(String date2Get, String sourceFormat, int days) {

        try {
            SimpleDateFormat sorceFmt = new SimpleDateFormat(sourceFormat);
            Date date = new Date(sorceFmt.parse(date2Get).getTime() + days * 86400000L); // 一天的时间24*3600*1000
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获得当前时间的n天前或后
     *
     * @param origin
     * @param intervals
     * @return
     */
    public static Date getIntervalDate(Date origin, long intervals) {

        return new Date(origin.getTime() + intervals * 86400000);
    }

    /**
     * 获得指定时间间隔的timestamp
     *
     * @param ts
     * @param minutes
     * @return
     */
    public static Timestamp getIntervalTimestamp(Timestamp ts, int minutes) {

        return new Timestamp(ts.getTime() + minutes * 60 * 1000L);
    }

    /**
     * 获得指定时间间隔之前的timestamp
     * @param ts
     * @param minutes
     * @return
     */
    public static Timestamp getBeforeIntervalTimestamp(Timestamp ts, int minutes) {

        return new Timestamp(ts.getTime() - minutes * 60 * 1000L);
    }

    @SuppressWarnings("deprecation")
    public static Date transToQueryDate(Date date) {

        Calendar c = new GregorianCalendar();// 新建日期对象
        c.set(date.getYear() + 1900, date.getMonth(), date.getDate(), 0, 0, 0);
        return c.getTime();
    }

    /**
     * 返回两个时间间隔的分钟数
     *
     * @param from
     * @param to
     * @return
     */
    public static long getDiffMinutes(Date from, Date to) {

        return Math.abs((to.getTime() - from.getTime()) / (60 * 1000));
    }

    public static long getDiffHours(Date time1, Date time2) {

        return Math.abs(time1.getTime() - time2.getTime()) / (60 * 60 * 1000);
    }
    /**
     * 获得两个时间之内的秒数
     *
     * @param from
     * @param to
     * @return
     */
    public static long getDiffSecs(Date from, Date to) {
        return Math.abs((to.getTime() - from.getTime()) / ( 1000));
    }
    /**
     * 获得两个时间之内的毫秒数
     *
     * @param from
     * @param to
     * @return
     */
    public static long getDiffMsecs(Timestamp from, Timestamp to) {

        return to.getTime() - from.getTime();
    }

    /**
     * 获得两个时间之间的天数
     *
     * @param from
     * @param to
     * @return
     */
    public static int getDiffDays(Date from, Date to) {

        return (int) (getDiffMinutes(from, to) / 1440);
    }

    public static boolean isBetween(Date date, Date start, Date end) {

        boolean isBetween = date.compareTo(start) >= 0 && date.getTime() <= (end.getTime() + 999);
        return isBetween;
    }

    public static boolean isToday(Date start) {

        long beginOfToday = getBeginOfToday().getTime();
        long endOfToday = getEndOfToday().getTime();
        boolean result = start.getTime() >= beginOfToday && start.getTime() <= endOfToday;
        return result;
    }

    /**
     * 获得某天的开始时间
     *
     * @param date
     * @return
     */
    public static Date getBeginOfDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得某天的结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 得到今天凌晨
     *
     * @return
     */
    public static Timestamp getBeginOfToday() {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 00:00:00";
        Date date = null;
        try {
            date = form.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 得到今天结束
     *
     * @return
     */
    public static Timestamp getEndOfToday() {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 23:59:59";
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 获得某个时间n天前的时间
     * @param date
     * @param n
     * @return
     */
    public static Date getDateBeforeN(Date date, int n){

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, -n);

        return cal.getTime();
    }

    /**
     * 得到N天前的凌晨（开始）
     *
     * @return
     */
    public static Timestamp getBeginOfDayBeforeN(int n) {
        return getBeginOfDayBeforeN(null, n);
    }

    public static Timestamp getBeginOfDayBeforeN(Timestamp time, int n) {
        if (time == null) {
            time = new Timestamp(System.currentTimeMillis());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - n);
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 00:00:00";
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 得到N天前的结束
     *
     * @return
     */
    public static Timestamp getEndOfDayBeforeN(int n) {
        return getEndOfDayBeforeN(null, n);
    }

    public static Timestamp getEndOfDayBeforeN(Timestamp time, int n) {
        if (time == null) {
            time = new Timestamp(System.currentTimeMillis());
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - n);
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = form.format(cal.getTime()) + " 23:59:59";
        Date date;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return new Timestamp(date.getTime());
    }

    public static boolean isYesterday(Date start) {

        Date today = getBeginOfToday();
        Date yesterday = getIntervalDate(today, -1);
        return start.getTime() >= yesterday.getTime() && start.getTime() < today.getTime();
    }

    public static String formatTime(Date target) {

        if (target == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(target);
    }

    public static String formatTime(Timestamp target) {

        if (target == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(target);
    }

    public static String formatTime(Timestamp target, String format) {

        if (target == null) {
            return "";
        }
        return new SimpleDateFormat(format).format(target);
    }

    /**
     * @author wangmeng 比较两个时间，if: firstDate before nextDate return true; else:
     *         return true;
     * @param firstDate
     * @param nextDate
     * @return
     */
    public static boolean compareDate(Date firstDate, Date nextDate) {

        if (firstDate.before(nextDate)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取距离现在相差N个月的时间
     *
     * @param monthes
     * @return
     */
    public static Timestamp getTimestampByMonth(int monthes) {

        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, monthes);
        return new Timestamp(lastDate.getTimeInMillis());
    }

    /**
     * 获取距离制定时间相差N个月的时间
     *
     * @param monthes
     * @return
     */
    public static Timestamp getTimestampByMonth(Timestamp timestamp, int monthes) {

        Calendar lastDate = Calendar.getInstance();
        lastDate.setTime( new Date( timestamp.getTime() ) );
        lastDate.add(Calendar.MONTH, monthes);
        return new Timestamp(lastDate.getTimeInMillis());
    }

    /**
     * 获取距离现在相差N个月的时间
     *
     * @param monthes
     * @return
     */
    public static Date getDateByMonth(int monthes) {

        Calendar nowDate = Calendar.getInstance();
        nowDate.add(Calendar.MONTH, monthes);
        return new Date(nowDate.getTimeInMillis());
    }

    public static Date getNextMonthDate(Date currentDate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, 1);
        Date nextMonthDate = cal.getTime();

        return nextMonthDate;
    }

    /**
     * 计算2时间之前的间隔的日期并返回
     * @param begin
     * @param end
     * @return
     */
    public static List<String> getDateRange(Date begin, Date end, String format) {
        List<String> dateList = new ArrayList<String>();
        Calendar beginCalendar = new GregorianCalendar();
        beginCalendar.setTime(begin);
        beginCalendar.set(Calendar.HOUR_OF_DAY, 0);
        beginCalendar.set(Calendar.MINUTE, 0);
        beginCalendar.set(Calendar.MILLISECOND, 0);

        while (beginCalendar.getTime().getTime() <= end.getTime()) {
            String date = formatDate(beginCalendar.getTime(), format);
            dateList.add(date);

            beginCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        return dateList;
    }

    public static Timestamp getTimestamp(String str, String format) {
        SimpleDateFormat sorceFmt = new SimpleDateFormat(format);
        try {
            return new Timestamp(sorceFmt.parse(str).getTime());
        } catch (ParseException e) {
            logger.debug("DateUtils getTimestamp error, str:{}, format:{}", str, format);
        }
        return null;
    }


    /**
     * 获得日期所在周的开始时间
     * @param date
     * @return
     */
    public static Date getWeekStart(Date date) {

        Calendar cal = Calendar.getInstance();// 获得日历实例
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得周几
        if (dayOfWeek == Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, -6);
        } else {
            cal.add(Calendar.DAY_OF_MONTH, 2 - dayOfWeek);
        }
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获得日期所在周的结束时间
     * @param date
     * @return
     */
    public static Date getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得周几
        if (dayOfWeek != Calendar.SUNDAY) {
            cal.add(Calendar.DAY_OF_MONTH, 8 - dayOfWeek);
        }
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 获得某一天的开始
     * @param date
     * @return
     */
    public static Date getDayStart(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    /**
     * 获得某一天的结束时间
     * @param date
     * @return
     */
    public static  Date getDayEnd(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }

    /**
     * 获得某个日期所在月的开始
     * @param date
     * @return
     */
    public static Date getMonthStart(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    /**
     * 获得某个日期所在月的结束
     * @param date
     * @return
     */
    public static Date getMonthEnd(Date date){

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);

        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return calendar.getTime();
    }

    /**
     * 获得当前月的开始时间
     * @return
     */
    public static Date getCurrentMonthStart(){

        return getMonthStart(new Date());
    }

    /**
     * 获得当前月分的结束时间
     * @return
     */
    public static Date getCurrentMonthEnd(){
        return getMonthEnd(new Date());
    }

    /**
     * 获得上个月的开始时间
     * @return
     */
    public static Date getPrevMonthStart(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        return getMonthStart(calendar.getTime());
    }

    /**
     * 获得上个月结束时间
     * @return
     */
    public static Date getPrevMonthEnd(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        return getMonthEnd(calendar.getTime());
    }

    /**
     * 获取N个月前的时间
     * @return
     */
    public static Timestamp getTimeBeforeNMonth(int n){
        if(n <=0 ){
            throw new IllegalArgumentException("parameter 'n' must be a positive number");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -n);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 起止时间参数
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param days      希望间隔的天数
     * @return mutablePair: left->startTime, right->endTime
     */
    public static MutablePair<Timestamp, Timestamp> handleStartAndEndTime(String startTime, String endTime, int days) {
        MutablePair<Timestamp, Timestamp> mutablePair = new MutablePair();
        if (StringUtils.isEmpty(startTime) && StringUtils.isEmpty(endTime)) {
            mutablePair.setLeft(getBeginOfDayBeforeN(days - 1));
            mutablePair.setRight(getEndOfToday());
        } else if (StringUtils.isEmpty(startTime) && StringUtils.isNotEmpty(endTime)) {
            mutablePair.setRight(formatToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss"));
            mutablePair.setLeft(new Timestamp(dateAddDays(mutablePair.getRight(), 1-days).getTime()));
        } else if (StringUtils.isNotEmpty(startTime) && StringUtils.isEmpty(endTime)) {
            mutablePair.setLeft(formatToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss"));
            mutablePair.setRight(new Timestamp(dateAddDays(mutablePair.getLeft(), days-1).getTime()));
        } else {
            Timestamp tmpStartTime = formatToTimestamp(startTime, "yyyy-MM-dd HH:mm:ss");
            Timestamp tmpEndTime = formatToTimestamp(endTime, "yyyy-MM-dd HH:mm:ss");
            if (tmpEndTime.getTime() - tmpStartTime.getTime() >= days * MS_ONE_DAY) {
                tmpStartTime = new Timestamp(dateAddDays(tmpEndTime, 1-days).getTime());
            }
            mutablePair.setLeft(tmpStartTime);
            mutablePair.setRight(tmpEndTime);
        }
        return mutablePair;
    }

    /**
     * 获取当前时间之后的n秒
     * @param n
     * @return
     */
    public static Timestamp getNextNSecond(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, n);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获得某个域的值
     * @param date
     * @param field Calendar 定义的字段域
     * @return
     */
    public static Integer getField(Date date, int field){

        if(date == null){
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar.get(field);
    }

    /**
     * 将指定毫秒数的时长转化为中文描述，如：1时20分30秒
     *
     * @param millis 毫秒数
     * @param maxUnit 开始时间单位，默认为小时
     * @param minUnit 结束时间单位，默认为秒
     * @return
     */
    public static String transformMillsToZH(Long millis, Integer maxUnit, Integer minUnit) {
        if (null == maxUnit) {
            maxUnit = TIME_UNIT_HOUR;
        }
        if (null == minUnit) {
            minUnit = TIME_UNIT_SECONDS;
        }
        if (maxUnit < 0 || maxUnit > UNIT_TIME_MILLIS.length - 1) {
            throw new IllegalArgumentException("invalid maxUnit");
        }
        if (minUnit < 0 || minUnit > UNIT_TIME_MILLIS.length - 1) {
            throw new IllegalArgumentException("invalid minUnit");
        }
        if (maxUnit > minUnit) {
            throw new IllegalArgumentException("the index of maxUnit can not greater than minUnit");
        }
        if (null == millis || millis <= 0) {
            return "0"+TIME_ZH_UNIT[minUnit];
        }
        if (millis < UNIT_TIME_MILLIS[minUnit]) {
            return "";
        }
        return innerTransformMillsToZH(millis,maxUnit,minUnit);

    }

    private static String innerTransformMillsToZH(Long mills, int curUnit, int minUnit) {
        if (curUnit > minUnit) {
            return "";
        }
        StringBuilder resultSB = new StringBuilder();
        if (mills >= UNIT_TIME_MILLIS[curUnit]) {
            resultSB.append(mills / UNIT_TIME_MILLIS[curUnit]).append(TIME_ZH_UNIT[curUnit]);
        }
        long remainMills = mills % UNIT_TIME_MILLIS[curUnit];
        if (remainMills > 0) {
            resultSB.append(innerTransformMillsToZH(remainMills, curUnit + 1, minUnit));
        }
        return resultSB.toString();
    }

    /**
     * 获取昨天指定时间的日期时间
     * @param time 时间点，格式：HH:mm:ss
     * @return
     */
    public static Timestamp getYesterdaySpecificTimestamp(String time) {
        Date yesterday = getYesterDay();
        String date = formatDate(yesterday, FMT_DATE_YYYYMMDD);
        String dateTimeStr = date + " " + time;
        return formatToTimestamp(dateTimeStr, H_24_FORMAT_MM);
    }

    /**
     * 获取昨天指定时间的日期时间
     * @param time 时间点，格式：HH:mm:ss
     * @return
     */
    public static Timestamp getTodaySpecificTimestamp(String time) {
        String date = formatDate(new Date(), FMT_DATE_YYYYMMDD);
        String dateTimeStr = date + " " +  time;
        return formatToTimestamp(dateTimeStr, H_24_FORMAT_MM);
    }
}


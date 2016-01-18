package com.wangfei.simplebook.utils;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/12
 * Email : wangfeijn@163.com
 */
public class DateUtils {
    /**
     * 根据毫秒数返回
     * @param time
     * @return
     */
    public static String getDataString(long time){
        String str=null;
        long currentDay=1000*60*60*24*14;
        if(time<currentDay){
            str="当天";
        }else if(time>=currentDay&&time<currentDay*2){
            str="一天前";
        }else if(time>=currentDay*2&&time<currentDay*3){
            str="两天前";
        }else{
            str="数天前";
        }
        return str;
    }
}

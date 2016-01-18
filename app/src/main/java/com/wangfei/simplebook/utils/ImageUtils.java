package com.wangfei.simplebook.utils;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/11
 * Email : wangfeijn@163.com
 */
public class ImageUtils {
    /**
     * 返回头像的地址
     * @param uId
     * @param picName
     * @return
     */
    public  static String getUserImageUrl(String uId,String picName ){
        String a=uId.substring(0,uId.length()-4);
        return "http://pic.qiushibaike.com/system/avtnew/"+a+"/"+uId+"/thumb/"+picName;
    }

   public static String getImageUrl(String imageUrl, String imageType){
       //内容图片获取(+图片名从数字开始去掉后4位+图片名从数字开始数全部+"/"+"/"+small或者medium+"/"+图片名)
       //====图片Url=http://pic.qiushibaike.com/system/pictures/7128/71288069/small/app71288069.jpg
       //app114646386.jpg
       String subStr1 = imageUrl.substring(3,8);
       String subStr2 = imageUrl.substring(3,12);
       String url = "http://pic.qiushibaike.com/system/pictures/"+subStr1+"/"+subStr2+"/"+imageType+"/"+imageUrl;
       return url;
   }
}

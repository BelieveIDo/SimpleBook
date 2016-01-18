package com.wangfei.simplebook.utils;

import com.wangfei.simplebook.domain.Recommand;
import com.wangfei.simplebook.domain.RecommandBean;
import com.wangfei.simplebook.domain.VideoBean;
import com.wangfei.simplebook.domain.VideoCommentBean;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/11
 * Email : wangfeijn@163.com
 */
public class HttpUtils {

    public interface VedioService{
        @GET("/article/list/video")
        Call<VideoBean> getVideo(@Query("page") int page);


        @GET("/article/list/{type}")
        Call<Recommand> getData(@Path("type") String type, @Query("page") int page);

        @GET("/article/{id}/comments")
        Call<VideoCommentBean> getComments(@Path("id") int id ,@Query("page") int page);

        @GET("/article/{id}/comments")
        Call<RecommandBean> getReComments(@Path("id") String id ,@Query("page") int page);
    }
    private static VedioService vedioService;
    static{
        vedioService=new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create()).build().create(VedioService.class);
    }

    public static VedioService getVedioService() {
        return vedioService;
    }

}

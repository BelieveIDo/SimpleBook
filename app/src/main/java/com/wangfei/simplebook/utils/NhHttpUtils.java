package com.wangfei.simplebook.utils;

import com.wangfei.simplebook.domain.PicBean;
import com.wangfei.simplebook.domain.PicCommentBen;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by 24054 on 2016/1/11.
 */
public class NhHttpUtils {
    public interface Service{
        //获取数据
        @GET("/article/list/{type}")
        Call<PicBean> getPic(@Path("type") String type,@Query("page") int page);
        //获取评论数据
        @GET("/article/{id}/comments")
        Call<PicCommentBen> getPicComment(@Path("id") int id,@Query("page") int page);
    }
    public static Service service;
    static {
        service = new Retrofit.Builder().
                baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Service.class);
    }
    public static Service getService(){
        return service;
    }
}


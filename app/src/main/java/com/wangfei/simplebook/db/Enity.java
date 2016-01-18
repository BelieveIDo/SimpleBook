package com.wangfei.simplebook.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Administrator on 2016/1/13.
 */
@Table(name = "Enity")
public class Enity extends Model {


    @Column(name = "format")
    public String format;

    @Column(name = "content")
    public String content;
    @Column(name = "comments_count")
    public int comments_count;


//    public String getFormat() {
//        return format;
//    }
//
//    public String getContent() {
//        return content;
//    }
//    public int getComments_count() {
//        return comments_count;
//    }
}

package com.wangfei.simplebook.domain;

import java.util.List;

/**
 * Created By: AndroidStudio [FR]
 * Author : WangFei [FR]
 * Date :  2016/1/12
 * Email : wangfeijn@163.com
 */
public class VideoDetailBean {

    private VideoBean.ItemsEntity itemsEntity;
    private List<VideoCommentBean.ItemsEntity> commentList;

    public VideoBean.ItemsEntity getItemsEntity() {
        return itemsEntity;
    }

    public void setItemsEntity(VideoBean.ItemsEntity itemsEntity) {
        this.itemsEntity = itemsEntity;
    }

    public List<VideoCommentBean.ItemsEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<VideoCommentBean.ItemsEntity> commentList) {
        this.commentList = commentList;
    }
}

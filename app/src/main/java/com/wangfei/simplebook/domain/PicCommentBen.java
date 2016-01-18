package com.wangfei.simplebook.domain;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by 24054 on 2016/1/12.
 */
public class PicCommentBen {

    /**
     * count : 50
     * items : [{"liked":false,"floor":1,"created_at":1452569567,"content":"一楼哈哈哈哈","like_count":0,"user":{"last_visited_at":1402854412,"created_at":1402854412,"last_device":"android_3.0.0","state":"active","role":"n","login":"为啥都是不合法啊","id":16981039,"icon":"20141114120409.jpg"},"id":347421743}]
     * total : 63
     * page : 1
     * err : 0
     */

    private int count;
    private int total;
    private int page;
    private int err;
    /**
     * liked : false
     * floor : 1
     * created_at : 1452569567
     * content : 一楼哈哈哈哈
     * like_count : 0
     * user : {"last_visited_at":1402854412,"created_at":1402854412,"last_device":"android_3.0.0","state":"active","role":"n","login":"为啥都是不合法啊","id":16981039,"icon":"20141114120409.jpg"}
     * id : 347421743
     */

    private List<ItemsEntity> items;

    public static PicCommentBen objectFromData(String str) {

        return new Gson().fromJson(str, PicCommentBen.class);
    }

    public static PicCommentBen objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), PicCommentBen.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getErr() {
        return err;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public static class ItemsEntity {
        private boolean liked;
        private int floor;
        private int created_at;
        private String content;
        private int like_count;
        /**
         * last_visited_at : 1402854412
         * created_at : 1402854412
         * last_device : android_3.0.0
         * state : active
         * role : n
         * login : 为啥都是不合法啊
         * id : 16981039
         * icon : 20141114120409.jpg
         */

        private UserEntity user;
        private int id;

        public static ItemsEntity objectFromData(String str) {

            return new Gson().fromJson(str, ItemsEntity.class);
        }

        public static ItemsEntity objectFromData(String str, String key) {

            try {
                JSONObject jsonObject = new JSONObject(str);

                return new Gson().fromJson(jsonObject.getString(str), ItemsEntity.class);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isLiked() {
            return liked;
        }

        public int getFloor() {
            return floor;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getContent() {
            return content;
        }

        public int getLike_count() {
            return like_count;
        }

        public UserEntity getUser() {
            return user;
        }

        public int getId() {
            return id;
        }

        public static class UserEntity {
            private int last_visited_at;
            private int created_at;
            private String last_device;
            private String state;
            private String role;
            private String login;
            private int id;
            private String icon;

            public static UserEntity objectFromData(String str) {

                return new Gson().fromJson(str, UserEntity.class);
            }

            public static UserEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), UserEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setRole(String role) {
                this.role = role;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public void setId(int id) {
                this.id = id;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getLast_device() {
                return last_device;
            }

            public String getState() {
                return state;
            }

            public String getRole() {
                return role;
            }

            public String getLogin() {
                return login;
            }

            public int getId() {
                return id;
            }

            public String getIcon() {
                return icon;
            }
        }
    }
}

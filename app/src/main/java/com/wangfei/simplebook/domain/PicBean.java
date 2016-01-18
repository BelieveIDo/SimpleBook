package com.wangfei.simplebook.domain;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 24054 on 2016/1/11.
 */
public class PicBean {

    /**
     * count : 30
     * err : 0
     * items : [{"format":"image","image":"app114643330.jpg","published_at":1452488702,"tag":"","user":{"avatar_updated_at":1444977336,"last_visited_at":1399213916,"created_at":1399213916,"state":"active","last_device":"android_2.8.3","role":"n","login":"只爱斜阳烟柳","id":16032253,"icon":"20151016063536.jpg"},"image_size":{"s":[220,99,4172],"m":[441,198,12497]},"id":114643330,"votes":{"down":-127,"up":4004},"created_at":1452484573,"content":"说的好\u2014\u2014\u2014\u2014\u2014\u2014\u2014\u2014","state":"publish","comments_count":166,"allow_comment":true,"share_count":109,"type":"hot"}]
     * total : 300
     * page : 1
     * refresh : 300
     */

    private int count;
    private int err;
    private int total;
    private int page;
    private int refresh;
    /**
     * format : image
     * image : app114643330.jpg
     * published_at : 1452488702
     * tag :
     * user : {"avatar_updated_at":1444977336,"last_visited_at":1399213916,"created_at":1399213916,"state":"active","last_device":"android_2.8.3","role":"n","login":"只爱斜阳烟柳","id":16032253,"icon":"20151016063536.jpg"}
     * image_size : {"s":[220,99,4172],"m":[441,198,12497]}
     * id : 114643330
     * votes : {"down":-127,"up":4004}
     * created_at : 1452484573
     * content : 说的好————————
     * state : publish
     * comments_count : 166
     * allow_comment : true
     * share_count : 109
     * type : hot
     */
    @SerializedName("items")
    private List<ItemsEntity> items;

    public static PicBean objectFromData(String str) {

        return new Gson().fromJson(str, PicBean.class);
    }

    public static PicBean objectFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);

            return new Gson().fromJson(jsonObject.getString(str), PicBean.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setErr(int err) {
        this.err = err;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public int getErr() {
        return err;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getRefresh() {
        return refresh;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }
    public static class ItemsEntity implements Serializable {
        private boolean support;
        private boolean unsupport;
        private boolean comment;
        private boolean shary;

        public boolean isSupport() {
            return support;
        }

        public void setSupport(boolean support) {
            this.support = support;
        }

        public boolean isUnsupport() {
            return unsupport;
        }

        public void setUnsupport(boolean unsupport) {
            this.unsupport = unsupport;
        }

        public boolean isComment() {
            return comment;
        }

        public void setComment(boolean comment) {
            this.comment = comment;
        }

        public boolean isShary() {
            return shary;
        }

        public void setShary(boolean shary) {
            this.shary = shary;
        }
        private String format;
        private String image;
        private int published_at;
        private String tag;
        /**
         * avatar_updated_at : 1444977336
         * last_visited_at : 1399213916
         * created_at : 1399213916
         * state : active
         * last_device : android_2.8.3
         * role : n
         * login : 只爱斜阳烟柳
         * id : 16032253
         * icon : 20151016063536.jpg
         */

        private UserEntity user;
        private ImageSizeEntity image_size;
        private int id;
        /**
         * down : -127
         * up : 4004
         */

        private VotesEntity votes;
        private int created_at;
        private String content;
        private String state;
        private int comments_count;
        private boolean allow_comment;
        private int share_count;
        private String type;

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

        public void setFormat(String format) {
            this.format = format;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setPublished_at(int published_at) {
            this.published_at = published_at;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public void setUser(UserEntity user) {
            this.user = user;
        }

        public void setImage_size(ImageSizeEntity image_size) {
            this.image_size = image_size;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setVotes(VotesEntity votes) {
            this.votes = votes;
        }

        public void setCreated_at(int created_at) {
            this.created_at = created_at;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public void setAllow_comment(boolean allow_comment) {
            this.allow_comment = allow_comment;
        }

        public void setShare_count(int share_count) {
            this.share_count = share_count;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFormat() {
            return format;
        }

        public String getImage() {
            return image;
        }

        public int getPublished_at() {
            return published_at;
        }

        public String getTag() {
            return tag;
        }

        public UserEntity getUser() {
            return user;
        }

        public ImageSizeEntity getImage_size() {
            return image_size;
        }

        public int getId() {
            return id;
        }

        public VotesEntity getVotes() {
            return votes;
        }

        public int getCreated_at() {
            return created_at;
        }

        public String getContent() {
            return content;
        }

        public String getState() {
            return state;
        }

        public int getComments_count() {
            return comments_count;
        }

        public boolean isAllow_comment() {
            return allow_comment;
        }

        public int getShare_count() {
            return share_count;
        }

        public String getType() {
            return type;
        }

        public static class UserEntity implements Serializable {
            private int avatar_updated_at;
            private int last_visited_at;
            private int created_at;
            private String state;
            private String last_device;
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

            public void setAvatar_updated_at(int avatar_updated_at) {
                this.avatar_updated_at = avatar_updated_at;
            }

            public void setLast_visited_at(int last_visited_at) {
                this.last_visited_at = last_visited_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public void setState(String state) {
                this.state = state;
            }

            public void setLast_device(String last_device) {
                this.last_device = last_device;
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

            public int getAvatar_updated_at() {
                return avatar_updated_at;
            }

            public int getLast_visited_at() {
                return last_visited_at;
            }

            public int getCreated_at() {
                return created_at;
            }

            public String getState() {
                return state;
            }

            public String getLast_device() {
                return last_device;
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

        public static class ImageSizeEntity implements  Serializable {
            private List<Integer> s;
            private List<Integer> m;

            public static ImageSizeEntity objectFromData(String str) {

                return new Gson().fromJson(str, ImageSizeEntity.class);
            }

            public static ImageSizeEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), ImageSizeEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }
            public void setS(List<Integer> s) {
                this.s = s;
            }

            public void setM(List<Integer> m) {
                this.m = m;
            }

            public List<Integer> getS() {
                return s;
            }

            public List<Integer> getM() {
                return m;
            }
        }

        public static class VotesEntity implements Serializable {
            private int down;
            private int up;

            public static VotesEntity objectFromData(String str) {

                return new Gson().fromJson(str, VotesEntity.class);
            }

            public static VotesEntity objectFromData(String str, String key) {

                try {
                    JSONObject jsonObject = new JSONObject(str);

                    return new Gson().fromJson(jsonObject.getString(str), VotesEntity.class);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                return null;
            }

            public void setDown(int down) {
                this.down = down;
            }

            public void setUp(int up) {
                this.up = up;
            }

            public int getDown() {
                return down;
            }

            public int getUp() {
                return up;
            }
        }
    }
}

package com.chaossnow.ms.pojo;

/**
 * @author chaos
 * @ClassName Good
 * @date 2022年07月31日 15:40
 * @Version 1.0
 */
public class Good {
    private int userId;
    private int id;
    private String title;
    private String introduce;


    @Override
    public String toString() {
        return "Good{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public Good() {
    }

    public Good(int userId, int id, String title, String introduce) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.introduce = introduce;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}

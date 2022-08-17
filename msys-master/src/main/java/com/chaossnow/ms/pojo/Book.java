package com.chaossnow.ms.pojo;


public class Book {

  private long id;
  private String cover;
  private String title;
  private String author;
  private String date;
  private String press;
  private String abs;
  private long cid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }


  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }


  public String getAbs() {
    return abs;
  }

  public void setAbs(String abs) {
    this.abs = abs;
  }


  public long getCid() {
    return cid;
  }

  public void setCid(long cid) {
    this.cid = cid;
  }

  public Book() {
  }

  public Book(long id, String cover, String title, String author, String date, String press, String abs, long cid) {
    this.id = id;
    this.cover = cover;
    this.title = title;
    this.author = author;
    this.date = date;
    this.press = press;
    this.abs = abs;
    this.cid = cid;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", cover='" + cover + '\'' +
            ", title='" + title + '\'' +
            ", author='" + author + '\'' +
            ", date='" + date + '\'' +
            ", press='" + press + '\'' +
            ", abs='" + abs + '\'' +
            ", cid=" + cid +
            '}';
  }
}

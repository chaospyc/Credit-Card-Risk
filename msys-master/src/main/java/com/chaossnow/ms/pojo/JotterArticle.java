package com.chaossnow.ms.pojo;


import java.sql.Timestamp;

public class JotterArticle {

  private long id;
  private String articleTitle;
  private String articleContentHtml;
  private String articleContentMd;
  private String articleAbstract;
  private String articleCover;
  private java.sql.Timestamp articleDate;

  public JotterArticle() {
  }

  public JotterArticle(long id, String articleTitle, String articleContentHtml, String articleContentMd, String articleAbstract, String articleCover, Timestamp articleDate) {
    this.id = id;
    this.articleTitle = articleTitle;
    this.articleContentHtml = articleContentHtml;
    this.articleContentMd = articleContentMd;
    this.articleAbstract = articleAbstract;
    this.articleCover = articleCover;
    this.articleDate = articleDate;
  }

  @Override
  public String toString() {
    return "JotterArticle{" +
            "id=" + id +
            ", articleTitle='" + articleTitle + '\'' +
            ", articleContentHtml='" + articleContentHtml + '\'' +
            ", articleContentMd='" + articleContentMd + '\'' +
            ", articleAbstract='" + articleAbstract + '\'' +
            ", articleCover='" + articleCover + '\'' +
            ", articleDate=" + articleDate +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getArticleTitle() {
    return articleTitle;
  }

  public void setArticleTitle(String articleTitle) {
    this.articleTitle = articleTitle;
  }


  public String getArticleContentHtml() {
    return articleContentHtml;
  }

  public void setArticleContentHtml(String articleContentHtml) {
    this.articleContentHtml = articleContentHtml;
  }


  public String getArticleContentMd() {
    return articleContentMd;
  }

  public void setArticleContentMd(String articleContentMd) {
    this.articleContentMd = articleContentMd;
  }


  public String getArticleAbstract() {
    return articleAbstract;
  }

  public void setArticleAbstract(String articleAbstract) {
    this.articleAbstract = articleAbstract;
  }


  public String getArticleCover() {
    return articleCover;
  }

  public void setArticleCover(String articleCover) {
    this.articleCover = articleCover;
  }


  public java.sql.Timestamp getArticleDate() {
    return articleDate;
  }

  public void setArticleDate(java.sql.Timestamp articleDate) {
    this.articleDate = articleDate;
  }

}

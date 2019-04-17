package com.news.newsapp.Model;

public class NewsDto {

    String title;
    String description;
    String url;
    String image;
    String content;
    String time;
    String source;

    public NewsDto(String title,String description, String url, String image, String content,
                           String time, String source){
        this.title=title;
        this.description=description;
        this.url=url;
        this.image=image;
        this.content=content;
        this.time=time;
        this.source=source;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

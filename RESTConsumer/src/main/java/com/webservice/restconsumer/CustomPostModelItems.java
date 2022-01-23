/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

/**
 *
 * @author Vaughn
 */

public class CustomPostModelItems {
    private int postID;
    private int userID;
    private String name;
    private String title;
    private String body;

    public CustomPostModelItems(int postID, int userID, String name, String title, String body) {
        this.postID = postID;
        this.userID = userID;
        this.name = name;
        this.title = title;
        this.body = body;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

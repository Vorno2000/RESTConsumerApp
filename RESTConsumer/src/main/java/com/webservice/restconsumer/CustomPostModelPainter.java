/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Vaughn
 */

/**
 * Post Information Painter can be used as a Cell Renderer for JList
 * Allows to paint the Posts Information
 */

public class CustomPostModelPainter extends JLabel implements ListCellRenderer{
    private int postID;
    private int userID;
    private String userName;
    private String title;
    private String body;
    
    public CustomPostModelPainter() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        CustomPostModelItems item = (CustomPostModelItems) value;
        
        this.postID = item.getPostID();
        this.userID = item.getUserID();
        this.userName = item.getName();
        this.title = item.getTitle();
        this.body = item.getBody();
        
        
        //insert <br> every 30 characters - works most, but not all times
        String parsedBody = body.replaceAll("..................."
                + "...........","$0<br>");
        
        if(postID != -1)
            this.setText("<html>("+userID+")"+userName+"<br>("+postID+")"+title+"<br><br>"+parsedBody+"</html>");
        else
            this.setText("<html><br><br></html>");
        
        if(isSelected) {
            setBackground(Color.BLACK);
            setForeground(Color.WHITE);
        }
        
        if(!isSelected) {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        
        if(!cellHasFocus || postID == -1) 
            setBorder(BorderFactory.createEmptyBorder());
        else 
            setBorder(BorderFactory.createLineBorder(Color.RED));
        
        
        return this;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
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

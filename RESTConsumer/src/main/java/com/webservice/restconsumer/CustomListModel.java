/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

import javax.swing.DefaultListModel;

/**
 *
 * @author Vaughn
 */

/**
 * Used as a Customized List Model for the "Information" JList
 * JList can be used to display Post information & User Information
 */

public class CustomListModel extends DefaultListModel {
    public CustomListModel() {
        
    }
    
    public void addPost(int postID, int userID, String name, String title, String body) {
        CustomPostModelItems newPost = new CustomPostModelItems(postID, userID, name, title, body);
        
        addElement(newPost);
    }
    
    public void addUser(int userID, String name, String userName, String email, Address address, String phone, String website, Company company) {
        CustomUserModelItems newUser = new CustomUserModelItems(userID, name, userName, email, address, phone, website, company);
        
        addElement(newUser);
    }
    
    public String getNameAtIndex(int index) {
        CustomPostModelItems currentPost = (CustomPostModelItems) this.getElementAt(index);
        
        return currentPost.getName();
    }
}

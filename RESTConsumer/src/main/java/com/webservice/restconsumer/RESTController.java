/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Vaughn
 */

/**
 * The MVC Controller which acts as the connection between theModel and theView
 * Holds the ActionListeners and controls the view and data stored in model
 */

public class RESTController {
    private RESTView theView;
    private RESTModel theModel;
    
    public RESTController(RESTView theView, RESTModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.setVisible(true);
        
        this.theView.retrieveAllDataListener(new RetrieveDataListener());
        this.theView.showAllPostsListener(new AllPostsListener());
        this.theView.resetListener(new ResetListener());
        this.theView.searchPostListener(new SearchPostListener());
        this.theView.userInformationListener(new userInformationListener());
        this.theView.allUserInformationListener(new allUserInformationListener());
        this.theView.infoListDeselectListener(new infoDeselectListener());
        this.theView.usersListDeselectListener(new usersDeselectListener());
    }
    
    class RetrieveDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = theModel.retrieveData();
            if(message.contains("Success")) {
                theView.setSuccessfulMessage(message);
                
                for(int i = 0; i < theModel.getUsers().size(); i++) {
                    theView.addUserName(theModel.getUsers().get(i).getName());
                }
            }
            else
                theView.setErrorMessage(message);
        }
    }
    
    class AllPostsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!theModel.getPosts().isEmpty()) {
                theView.clearPostsList();
                
                for(Post p: theModel.getPosts()) {
                    theView.addPosts(p.getId(), p.getUserID(), theModel.getNameFromID(p.getUserID()),
                            p.getTitle(), p.getBody());
                }
                theView.setSuccessfulMessage("All Posts Shown");
            }
            else
                theView.setErrorMessage("No Data Retrieved Yet");
        }
    }
    
    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.reset();
            theView.clearPostsList();
            theView.clearUsersList();
            
            theView.setSuccessfulMessage("Reset Complete");
        }
    }
    
    class SearchPostListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(theModel.getUsers().isEmpty()) {
                theView.setErrorMessage("No Data Retrieved Yet");
                return;
            }
            
            String selected_user = "";
            
            if(!theView.getUsersList().isSelectionEmpty())
                selected_user = (String) theView.getUsersList().getSelectedValue();
            else if(!theView.getInfoList().isSelectionEmpty()) {
                Object selected_UserOrPostObj = theView.getInfoList().getSelectedValue();
                
                if(selected_UserOrPostObj instanceof CustomPostModelItems) {
                    CustomPostModelItems selected_UserOrPost = CustomPostModelItems.class.cast(selected_UserOrPostObj);
                    selected_user = selected_UserOrPost.getName();
                } else if (selected_UserOrPostObj instanceof CustomUserModelItems) {
                    CustomUserModelItems selected_UserOrPost = CustomUserModelItems.class.cast(selected_UserOrPostObj);
                    selected_user = selected_UserOrPost.getName();
                }
                
                theView.getUsersList().setSelectedValue(selected_user, true);
            }
            else {
                theView.setErrorMessage("<html>Select A User Or Post<br>To Search Post</html>");
                return;
            }
            
            int userID = -1;

            for(User u : theModel.getUsers()) {
                if(u.getName().equals(selected_user)) {
                    userID = u.getId();
                }
            }

            theView.clearPostsList();
            for(Post p : theModel.getPosts()) {
                if(p.getUserID() == userID) {
                    theView.addPosts(p.getId(), p.getUserID(), selected_user, p.getTitle(), p.getBody());
                }
            }
            theView.setSuccessfulMessage("<html>All Posts Shown For<br>"+selected_user+"</html>");
        }
    }
    
    class allUserInformationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!theModel.getUsers().isEmpty()) {
                theView.clearPostsList();
                
                for(User u: theModel.getUsers()) {
                    theView.addUsers(u.getId(), u.getName(), u.getUsername(), u.getEmail(), u.getAddress(),
                            u.getPhone(), u.getWebsite(), u.getCompany());
                }
                theView.setSuccessfulMessage("All Users Shown");
            }
            else
                theView.setErrorMessage("No Data Retrieved Yet");
        }
    }
    
    class userInformationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(theModel.getUsers().isEmpty()) {
                theView.setErrorMessage("No Data Retrieved Yet");
                return;
            }
            
            String selected_user = "";
            
            if(!theView.getUsersList().isSelectionEmpty())
                selected_user = (String) theView.getUsersList().getSelectedValue();
            else if(!theView.getInfoList().isSelectionEmpty()) {
                Object selected_UserOrPostObj = theView.getInfoList().getSelectedValue();
                
                if(selected_UserOrPostObj instanceof CustomPostModelItems) {
                    CustomPostModelItems selected_UserOrPost = CustomPostModelItems.class.cast(selected_UserOrPostObj);
                    selected_user = selected_UserOrPost.getName();
                } else if (selected_UserOrPostObj instanceof CustomUserModelItems) {
                    CustomUserModelItems selected_UserOrPost = CustomUserModelItems.class.cast(selected_UserOrPostObj);
                    selected_user = selected_UserOrPost.getName();
                }
                
                theView.getUsersList().setSelectedValue(selected_user, true);
            }
            else {
                theView.setErrorMessage("<html>Select A User Or Post<br>To Search User</html>");
                return;
            }
            
            theView.clearPostsList();
            for(User u : theModel.getUsers()) {
                if(u.getName().equals(selected_user)) {
                    theView.addUsers(u.getId(), u.getName(), u.getUsername(), u.getEmail(), u.getAddress(), u.getPhone(), 
                            u.getWebsite(), u.getCompany());
                    
                    theView.setSuccessfulMessage("<html>Showing Info For<br>"+selected_user+"</html>");
                    return;
                }
            }
        }
    }
    
    class infoDeselectListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting()) {
                theView.getUsersList().clearSelection();
                
                Object temp_modelObj = theView.getInfoList().getSelectedValue();
                
                if(temp_modelObj instanceof CustomPostModelItems) {
                    CustomPostModelItems temp_model = CustomPostModelItems.class.cast(temp_modelObj);
                    if(temp_model == null || temp_model.getName().isEmpty())
                        theView.getInfoList().clearSelection();
                }
                else if(temp_modelObj instanceof CustomUserModelItems) {
                    CustomUserModelItems temp_model = CustomUserModelItems.class.cast(temp_modelObj);
                    if(temp_model == null || temp_model.getName().isEmpty())
                        theView.getInfoList().clearSelection();
                }
            }
        }
    }
    
    class usersDeselectListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if(e.getValueIsAdjusting()) {
                theView.getInfoList().clearSelection();
            }
        }
    }
}
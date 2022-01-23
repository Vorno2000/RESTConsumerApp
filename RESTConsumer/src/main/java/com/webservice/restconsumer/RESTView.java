/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Vaughn
 */

/**
 * The MVC view which acts as the GUI view and controlled by the controller
 * The controller manipulates the view and displays data from model
 * Layout using Netbeans GUI Builder and the rest was Manual
 */
public class RESTView extends javax.swing.JFrame {
    private CustomListModel listModel;
    private CustomPostModelPainter post_painter;
    private CustomUserModelPainter user_painter;
    private DefaultListModel usersListModel;
    
    public RESTView() {
        initComponents();               //system    
        initCustomComponents();         //manual
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Users_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Users_List = new javax.swing.JList<>();
        Users_label1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Info_List = new javax.swing.JList<>();
        SearchUsersPostsBTN = new javax.swing.JButton();
        AllPostsBTN = new javax.swing.JButton();
        UsersInformationBTN = new javax.swing.JButton();
        Error_Label = new javax.swing.JLabel();
        RetrieveDataBTN = new javax.swing.JButton();
        ResetBTN = new javax.swing.JButton();
        AllUsersInformationBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(830, 620));

        Users_label.setFont(new java.awt.Font("Dialog", 0, 27)); // NOI18N
        Users_label.setText("Users:");

        jScrollPane1.setViewportView(Users_List);

        Users_label1.setFont(new java.awt.Font("Dialog", 0, 27)); // NOI18N
        Users_label1.setText("Information:");

        jScrollPane2.setViewportView(Info_List);

        SearchUsersPostsBTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        SearchUsersPostsBTN.setText("Search User's Posts");

        AllPostsBTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        AllPostsBTN.setText("Show All Posts");

        UsersInformationBTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        UsersInformationBTN.setText("Search User's Info");

        Error_Label.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Error_Label.setForeground(new java.awt.Color(255, 0, 0));
        Error_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Error_Label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        RetrieveDataBTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        RetrieveDataBTN.setText("Retrieve All Data");

        ResetBTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ResetBTN.setText("Reset");

        AllUsersInformationBTN.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        AllUsersInformationBTN.setText("Search All Users Info");

        jLabel1.setText("Post Information:");

        jLabel2.setText("User Information:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Users_label, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Users_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(AllPostsBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(UsersInformationBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SearchUsersPostsBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Error_Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(AllUsersInformationBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(RetrieveDataBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(ResetBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Users_label, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Users_label1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AllPostsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(SearchUsersPostsBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AllUsersInformationBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(UsersInformationBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(Error_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RetrieveDataBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void initCustomComponents() {
        usersListModel = new DefaultListModel();
        listModel = new CustomListModel();
        post_painter = new CustomPostModelPainter();
        user_painter = new CustomUserModelPainter();
        
        Users_List.setModel(usersListModel);
        Users_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Info_List.setModel(listModel);
        Info_List.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    public void setSuccessfulMessage(String message) {
        Error_Label.setForeground(Color.GREEN);
        Error_Label.setText(message);
    }
    
    public void setErrorMessage(String message) {
        Error_Label.setForeground(Color.RED);
        Error_Label.setText(message);
    }
    
    public void addUserName(String name) {
        if(!usersListModel.contains(name))
            usersListModel.addElement(name);
    }
    
    public void addPosts(int postID, int userID, String name, String title, String body) {
        Info_List.setCellRenderer(post_painter);
        listModel.addPost(postID, userID, name, title, body);
        listModel.addPost(-1,-1,"","","");
    }
    
    public void addUsers(int userID, String name, String userName, String email, Address address, String phone, String website, Company company) {
        Info_List.setCellRenderer(user_painter);
        listModel.addUser(userID, name, userName, email, address, phone, website, company);
        listModel.addUser(-1, "", "", "", null, "", "", null);
    }
    
    public void clearPostsList() {
        listModel.clear();
    }
    
    public void clearUsersList() {
        usersListModel.clear();
    }
    
    public JList getUsersList() {
        return Users_List;
    }
    
    public JList getInfoList() {
        return Info_List;
    }
    
    
    //actionListeners
    void retrieveAllDataListener(ActionListener listenerForRetrieveData) {
        RetrieveDataBTN.addActionListener(listenerForRetrieveData);
    }
    
    void resetListener(ActionListener listenerForReset) {
        ResetBTN.addActionListener(listenerForReset);
    }
    
    void showAllPostsListener(ActionListener listenerForAllPosts) {
        AllPostsBTN.addActionListener(listenerForAllPosts);
    }
    
    void searchPostListener(ActionListener listenerForSearchPost) {
        SearchUsersPostsBTN.addActionListener(listenerForSearchPost);
    }
    
    void allUserInformationListener(ActionListener listenerForAllUserInformation) {
        AllUsersInformationBTN.addActionListener(listenerForAllUserInformation);
    }
    
    void userInformationListener(ActionListener listenerForUserInformation) {
        UsersInformationBTN.addActionListener(listenerForUserInformation);
    }
    
    void infoListDeselectListener(ListSelectionListener listenerForInfoDeselect) {
        Info_List.addListSelectionListener(listenerForInfoDeselect);
    }
    
    void usersListDeselectListener(ListSelectionListener listenerForUsersDeselect) {
        Users_List.addListSelectionListener(listenerForUsersDeselect);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllPostsBTN;
    private javax.swing.JButton AllUsersInformationBTN;
    private javax.swing.JLabel Error_Label;
    private javax.swing.JList<String> Info_List;
    private javax.swing.JButton ResetBTN;
    private javax.swing.JButton RetrieveDataBTN;
    private javax.swing.JButton SearchUsersPostsBTN;
    private javax.swing.JButton UsersInformationBTN;
    private javax.swing.JList<String> Users_List;
    private javax.swing.JLabel Users_label;
    private javax.swing.JLabel Users_label1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

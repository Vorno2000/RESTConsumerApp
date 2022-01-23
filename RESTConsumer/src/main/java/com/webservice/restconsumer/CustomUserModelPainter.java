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
 * See CustomPostModelPainter.java for information as they're the same
 * Cell Renderer for Users Information
 */

public class CustomUserModelPainter extends JLabel implements ListCellRenderer{
    private int userID;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    
    public CustomUserModelPainter() {
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        CustomUserModelItems item = (CustomUserModelItems) value;
        
        this.userID = item.getUserID();
        this.name = item.getName();
        this.userName = item.getUserName();
        this.email = item.getEmail();
        this.address = item.getAddress();
        this.phone = item.getPhone();
        this.website = item.getWebsite();
        this.company = item.getCompany();
        
        if(userID != -1) {
            this.setText("<html>("+userID+")"+name+"<br>Username: "+userName+"<br>Email: "+email+"<br>Address:<br>&emsp; Street: "+address.getStreet()+
                    "<br>&emsp; Suite: "+address.getSuite()+"<br>&emsp; City: "+address.getCity()+"<br>&emsp; Zipcode: "+address.getZipcode()+"<br>GEO: <br>"+
                    "&emsp; Latitude: "+address.getGeo().getLatitude()+"<br>&emsp; Longitude: "+address.getGeo().getLongitude()+"<br>Phone Number: "+
                    phone+"<br>Website: "+website+"<br>Company:<br>&emsp; Name: "+company.getName()+"<br>&emsp; Catch-Phrase: "+company.getCatchPhrase()+
                    "<br>&emsp; BS: "+company.getBs());
        }
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
        
        if(!cellHasFocus || userID == -1) 
            setBorder(BorderFactory.createEmptyBorder());
        else 
            setBorder(BorderFactory.createLineBorder(Color.RED));
        
        
        return this;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String get_Name() {
        return name;
    }

    public void set_Name(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

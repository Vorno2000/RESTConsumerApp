/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webservice.restconsumer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Vaughn
 */

/**
 * The MVC model which acts as the data carrier and connection setup
 * Holds the data which controller can pass to the view
 */

public class RESTModel {
    private ArrayList<Post> posts;
    private ArrayList<User> users;
    private String errorStatus = "";
    
    private static HttpURLConnection connection;
    
    private BufferedReader reader;
    private String line;
    private StringBuffer responseContent;
    private URL url;
    
    public RESTModel() {
        posts = new ArrayList<>();
        users = new ArrayList<>();
    }
    
    public String retrieveData() {
        errorStatus = "";
        
        if(posts.isEmpty() || users.isEmpty()) {
            retrievePosts();
            retrieveUsers();
            
            if(errorStatus.isEmpty()) errorStatus = "Successfully Retrieved Data";
        }
        else
            errorStatus = "Already Retrieved Data";
        
        return errorStatus;
    }
    
    public void retrievePosts() {
        //sourced with adjustments - https://www.youtube.com/watch?v=qzRKa8I36Ww
        
        try {
            responseContent = new StringBuffer();
            url = new URL("https://jsonplaceholder.typicode.com/posts");
            connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            
            if(status > 299) {      //error
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                errorStatus = "Error Retrieving Posts";
            } 
            else {                  //success
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }
            
            parsePosts(responseContent.toString());
            reader.close();
            
        } catch(MalformedURLException e) {
            errorStatus = "Error Retrieving Posts";
            System.err.println(errorStatus+": "+e);
        } catch(IOException e) {
            errorStatus = "Error Retrieving Posts";
            System.err.println(errorStatus+": "+e);
        } finally {
            connection.disconnect();
        }
    }
    
    public void retrieveUsers() {
        try {
            responseContent = new StringBuffer();
            url = new URL("https://jsonplaceholder.typicode.com/users");
            connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            
            int status = connection.getResponseCode();
            
            if(status > 299) {      //error
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                if(errorStatus.isEmpty()) errorStatus = "Error Retrieving Users";
                else errorStatus += " + Users";
            } 
            else {                  //success
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
            }
            
            parseUsers(responseContent.toString());
            reader.close();
            
        } catch(MalformedURLException e) {
            if(errorStatus.isEmpty()) errorStatus = "Error Retrieving Users";
            else errorStatus += " + Users";
            
            System.err.println(errorStatus+": "+e);
        } catch(IOException e) {
            if(errorStatus.isEmpty()) errorStatus = "Error Retrieving Users";
            else errorStatus += " + Users";
            
            System.err.println(errorStatus+": "+e);
        } finally {
            connection.disconnect();
        }
    }
    
    public void parsePosts(String responseBody) {
        JSONArray json_posts = new JSONArray(responseBody);
        
        for(int i = 0; i < json_posts.length(); i++) {
            JSONObject json_post = json_posts.getJSONObject(i);
            
            int userID = json_post.getInt("userId");
            int id = json_post.getInt("id");
            String title = json_post.getString("title");
            String body = json_post.getString("body");
            
            Post newPost = new Post(userID, id, title, body);
            posts.add(newPost);
        }
    }
    
    public void parseUsers(String responseBody) {
        JSONArray json_users = new JSONArray(responseBody);
        
        for(int i = 0; i < json_users.length(); i++) {
            JSONObject json_user = json_users.getJSONObject(i);
            
            int id = json_user.getInt("id");
            String name = json_user.getString("name");
            String username = json_user.getString("username");
            String email = json_user.getString("email");
            
            JSONObject json_address = json_user.getJSONObject("address");
            JSONObject json_geo = json_address.getJSONObject("geo");
            
            Geo geo = new Geo(json_geo.getDouble("lat"), json_geo.getDouble("lng"));
            Address address = new Address(json_address.getString("street"), json_address.getString("suite"),
                    json_address.getString("city"), json_address.getString("zipcode"), geo);
            
            String phone = json_user.getString("phone");
            String website = json_user.getString("website");
            
            JSONObject json_company = json_user.getJSONObject("company");
            
            Company company = new Company(json_company.getString("name"), json_company.getString("catchPhrase"), 
                    json_company.getString("bs"));
            
            User user = new User(id, name, username, email, address, phone, website, company);
            
            users.add(user);
        }
    }
    
    public String getNameFromID(int userID) {
        for(User u : users) {
            if(u.getId() == userID)
                return u.getName();
        }
        
        return null;
    }
    
    public void reset() {
        posts.clear();
        users.clear();
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}

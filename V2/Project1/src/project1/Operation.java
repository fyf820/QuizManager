/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import project1.Post;
import project1.postdb;
/**
 *
 * @author fyf08
 */
public class Operation {
    private postdb database;
    
    public Operation(postdb database){
        this.database = database;
    }
    
    public void store(String body,String subject,String dependon){
        database.reply(body,subject,dependon);
    }
    
    public void store(String body,String subject){
        database.addPost(body,subject);
    }
    
    public void initCounter(){
        database.initCounter();
    }
    
    public Post retrieve(){
        Post p = database.getPost();
        return p;
    }
    
    public boolean isexist(){
        if(database.getCounter()<database.getSize()){
            return true;
        }
        return false;
    }
    
}

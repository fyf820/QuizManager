/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import project1.Operation;
import project1.postdb;
/**
 *
 * @author fyf08
 */
public class Addpost {
    private String body;
    private String subject;
    private String dependon;
    private postdb database;
    private Operation add;
    
    public Addpost(String body, String subject, String dependon, postdb database){
        this.body = body;
        this.subject = subject;
        this.dependon = dependon;
        this.database = database;
        add = new Operation(database);
    }
    
    public Addpost(String body, String subject, postdb database){
        this.body = body;
        this.subject = subject;
        this.database = database;
        add = new Operation(database);
    }
    
    public void addThread(){
        add.store(body,subject);
    }
    
    public void reply(){
        add.store(body, subject, dependon);
    }
}

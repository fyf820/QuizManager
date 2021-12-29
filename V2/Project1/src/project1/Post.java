/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author fyf08
 */
public class Post {
    private String body;
    private String subject;
    private String dependon;
    
    public String getBody(){
        return body;
    }
    
    public void setBody(String body){
        this.body = body;
    }
    
    public String getSubject(){
        return subject;
    }
    
    public void setSubject(String subject){
        this.subject = subject;
    }
    
    public String getDependon(){
        return dependon;
    }
    
    public void setDependon(String dependon){
        this.dependon = dependon;
    }
}

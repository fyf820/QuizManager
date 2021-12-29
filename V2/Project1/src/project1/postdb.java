/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.util.Vector;
import project1.Post;
/**
 *
 * @author fyf08
 */
public class postdb {
    private Vector<Post> database = new Vector();
    private int retCounter;
    
    public static void main(String args[]){
        postdb pdb= new postdb();
    }
    
    public void addPost(String body, String subject){
        Post posts = new Post();
        posts.setBody(body);
        posts.setSubject(subject);
        database.add(posts);
    }
    
    public void reply(String body, String subject, String dependon){
        Post posts = new Post();
        posts.setBody(body);
        posts.setSubject(subject);
        posts.setDependon(dependon);
        database.add(posts);
    }
    
    public void initCounter(){
        retCounter = 0;
    }
    
    public Post getPost(){
        retCounter++;
        return database.get(retCounter-1);
    }
    
    public int getSize(){
        return database.size();
    }
    
    public int getCounter(){
        return retCounter;
    }
    
}

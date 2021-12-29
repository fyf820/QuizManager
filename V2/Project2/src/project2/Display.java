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
public class Display {
    private postdb database;
    private Operation ret;
    
    public Display(postdb database){
        this.database = database;
        ret = new Operation(database);
    }
    
    public void printPost(){
        ret.initCounter();
        while(ret.isexist()){
            System.out.println(ret.retrieve());
        }
    }
}

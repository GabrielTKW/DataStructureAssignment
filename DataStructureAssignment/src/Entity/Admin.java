/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Gab
 */
public class Admin extends User{
    private String position;
    
    public Admin(String userID,String username,String icNo,String password,String position){
        super(userID,username,icNo,password);
        this.position = position;
    }
    
    public Admin(){
        
    }
}

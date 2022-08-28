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
public class Patient extends User {
    private int age;
    private double weight;
    private String address;
    
    public Patient(){}
    
    public Patient(String userID,String username,String icNo,String password,int age , double weight , String address){
        super(userID,username,icNo,password);
        this.age = age;
        this.weight = weight; 
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}

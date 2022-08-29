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
public class CartItem {
    private String cartItemID;
    private int qty;
    private Combination combination;
    private Patient patient;
    private Payment payment;
    
    public CartItem(){}
    
    public CartItem(String cartItemID,int qty,Combination combination,Patient patient,Payment payment){
        this.cartItemID = cartItemID;
        this.combination = combination;
        this.patient = patient;
        this.qty = qty;
        this.payment=payment;
                
    }

    public String getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(String cartItemID) {
        this.cartItemID = cartItemID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Combination getCombination() {
        return combination;
    }

    public void setCombination(Combination combination) {
        this.combination = combination;
    }

  

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
            
}

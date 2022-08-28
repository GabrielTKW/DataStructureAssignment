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
public class Delivery {
    private String dID;
    private String dStatus;
    private String dComment;
    private Payment payment;
    
    public Delivery(){
        
    }
    
    public Delivery(String dID,String dStatus,String dComment,Payment payment){
        this.dID = dID;
        this.dStatus=dStatus;
        this.dComment=dComment;
        this.payment = payment;
    }

    public String getdID() {
        return dID;
    }

    public void setdID(String dID) {
        this.dID = dID;
    }

    public String getdStatus() {
        return dStatus;
    }

    public void setdStatus(String dStatus) {
        this.dStatus = dStatus;
    }

    public String getdComment() {
        return dComment;
    }

    public void setdComment(String dComment) {
        this.dComment = dComment;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
    
    
}

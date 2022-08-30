package Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Payment {
    private String paymentID;
    private String paymentMethod;
    private LocalDateTime paymentTime;

    public Payment(){
        
    }
    
    public Payment(String paymentID,String paymentMethod,LocalDateTime paymentTime){
        this.paymentID = paymentID;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
    }
    
    
    public String getPaymentID() {
        return paymentID;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
    
    public String getDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return paymentTime.format(formatter); 
    }
    
    
}

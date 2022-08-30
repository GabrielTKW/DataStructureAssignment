/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Entity.Medicine;
import Entity.Payment;
import adt.ArrayList;
import adt.ArrayStack;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Benjamin Choong
 */
public class JMPayment {
    public static void main(String[] args) {
        ArrayList<Medicine> medArrList = new ArrayList<Medicine>();
        ArrayStack<Medicine> medArrStack = new ArrayStack<Medicine>();
        ArrayStack<Payment> paymentArrStack = new ArrayStack<Payment>();
        paymentInitialize(paymentArrStack);
//        displayPaymentRecords(paymentArrStack);
                paymentMenu(medArrStack, paymentArrStack);
    }
    
    public static void paymentInitialize(ArrayStack<Payment> paymentArrStack) {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = ldt.format(format);   
        LocalDateTime ldt2 = LocalDateTime.parse(formatDateTime, format);
        paymentArrStack.push(new Payment("P001", "TnG", ldt2));
        paymentArrStack.push(new Payment("P002", "Credit/Debit Card", ldt2));
        paymentArrStack.push(new Payment("P003", "Online Banking", ldt2));
    }
    
    public static void displayPaymentRecords(ArrayStack<Payment> paymentArrStack){
        for(int i=0; i<=paymentArrStack.getTopIndex(); i++){
            System.out.println(paymentArrStack.peek(i).getPaymentMethod()); 
        }
    }
    
    public static void paymentMenu(ArrayStack<Medicine> medArrStack, ArrayStack<Payment> paymentArrStack) {
        
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = ldt.format(format);   
        LocalDateTime ldt2 = LocalDateTime.parse(formatDateTime, format);
        
        medArrStack.push(new Medicine("M001", "Panadol", 100.00, "Pain Killer"));
        medArrStack.push(new Medicine("M002", "Pan", 200.00, "A"));
        medArrStack.push(new Medicine("M003", "nadol", 80.00, "B"));
        medArrStack.push(new Medicine("M004", "Pol", 50.00, "AAA"));
        medArrStack.push(new Medicine("M005", "Po", 90.00, "BBB"));
        
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        
        String itemName = "Product 1";
        double price = 123.00;
        double deliveryFee = 5.00;
        boolean amountCorrect = false;
        double totalPrice = 0;
        
        int paymentMethod;
        double paymentAmount;
        char confirmPayment;
        
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("| Item Name\t  Unit Price\t\t  Quantity\t\t    Item Subtotal\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        
        for(int i=0; i<=medArrStack.getTopIndex(); i++){
            System.out.printf("| %-15s %-23s %-25s %-20.2f|\n", medArrStack.peek(i).getmID(), medArrStack.peek(i).getmName(), medArrStack.peek(i).getmDesc(), medArrStack.peek(i).getmPrice());
            totalPrice += medArrStack.peek(i).getmPrice();
        }

//        for(int i=0; i<=paymentArrStack.getLength(); i++){
//            System.out.printf("| %-15s %-23s %-25s %-20.2f|\n", paymentArrStack.peek(i).getPaymentID(), paymentArrStack.peek(i).getPaymentMethod(), paymentArrStack.peek(i).getDate(), price);
//            totalPrice += price;
//        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("|\t\t\t\t\t\t\t    Total : %-20.2f|", totalPrice);
        System.out.println("\n-----------------------------------------------------------------------------------------\n");
        
        System.out.println("Select a payment method :");
        System.out.println("----------------------------");
        System.out.println("1. Touch N Go");
        System.out.println("2. Online Banking");
        System.out.println("3. Credit/Debit Card");
        System.out.println("4. Cancel\n");
        
        System.out.print("Your choice : ");
        paymentMethod = sc.nextInt();
        System.out.println("");
        
        if(paymentMethod == 1 || paymentMethod == 2 || paymentMethod == 3){
            do{
                System.out.print("Enter amount to pay : ");
                paymentAmount = sc.nextDouble();
                
                if(paymentAmount != totalPrice){
                    System.out.println("You have given a wrong amount. You have to pay RM"+totalPrice);
                    System.out.println("");
                }
                else{
                    amountCorrect = true;
                }
            }while(!amountCorrect);
            System.out.println("Payment Success!");
            
        }
        else if(paymentMethod == 4){
            System.out.println("Cancelled");
        }
    }
}

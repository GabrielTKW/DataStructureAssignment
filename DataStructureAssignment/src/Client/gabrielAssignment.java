/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;
import Entity.CartItem;
import Entity.Combination;
import Entity.Medicine;
import Entity.Patient;
import Entity.Payment;
import Entity.Symptom;
import adt.ArrayStack;
import java.util.Scanner;

/**
 *
 * @author Gab
 */
public class gabrielAssignment {
    
    
    public static void main(String[] args) {
        //declare a normal profile
        Patient patient1 = new Patient("P00001");
        Patient patient2 = new Patient("P00002");
        Medicine medicine = new Medicine("M00001" , "Carrot" ,30, "Eat every 3 days");
        Symptom symptom = new Symptom("S0001","Cough","Cough multiple times a day");
        Combination combination = new Combination("C0001",symptom,medicine);
        
        
        CartItem cartItem = new CartItem(1,combination , patient1 ,new Payment() );
        CartItem cartItem2 = new CartItem(4,combination , patient1 ,new Payment() );
        
        //create ArrayStack 
        ArrayStack<CartItem> cartArrS = new ArrayStack<CartItem>();
        cartArrS.push(cartItem);
        cartArrS.push(cartItem2);
        
        displayAllPatient(cartArrS,patient1);
        
        
        
    }
    
    public static void addToCart(ArrayStack<CartItem> cartArrS){
        Scanner sc = new Scanner(System.in);  
        //Get user profile 
        //Get item qty , combination
        
        
        //check whether the user profile has the same combination , 
            //if have then add qty to there 
            
        //add to cart 
            //generate new cartID 
            
            
        char confirm ;
            
        
        //ask for whether add to cart
        do{
        System.out.println("Confirm Add to Cart? (Y/N)");
        // reading a character   
         confirm = sc.next().charAt(0);  
         confirm = Character.toUpperCase(confirm);
         
         if(confirm != 'Y' && confirm!= 'N'){
             System.out.println("Invalid Input Please Enter Again!");
         }
         
        }while(confirm != 'Y' && confirm!= 'N');
        
        //if add to cart (Get combination array)
        
    }
    
    public static void displayAllPatient(ArrayStack<CartItem> cartArrS,Patient patient){
        
        int count =0;
        
        System.out.println("==================================================");
        for(int i = 0 ; i < cartArrS.getTopIndex()+1;i++){
            //print all value 
            CartItem localCartItem = cartArrS.peek(i);
            
            if(patient.getUserID().equals(localCartItem.getPatient().getUserID())){
                
                System.out.println("==============================================");
                System.out.println("No|CartItemID|Medicine        |Qty|Patient   |");
                System.out.println("==============================================");
                System.out.printf("%d |%-10s|%-16s|%-3d|%-10s|\n",i , localCartItem.getCartItemID(),localCartItem.getCombination().getMedicine().getmName(),localCartItem.getQty(),localCartItem.getPatient().getUserID());
                count++;
            }
        }
        
        if(count==0){
            System.out.println("\n\n-------ALERT-------");
            System.out.println("Sorry , you do not have any medicine in cart for current moment!");
            System.out.println("-------ALERT-------\n\n");
        }
        else{
            System.out.println("==============================================");
        }
    }
    
    public static void deleteCartItem(ArrayStack<CartItem> cartArrS, CartItem cartItem ){
        for(int i = 0 ; i < cartArrS.getTopIndex()+1;i++){
            CartItem localCartItem = cartArrS.peek(i);
            
            if (localCartItem.getCartItemID().equals( cartItem.getCartItemID())){
                //delete the cartItem
                cartArrS.pop();
            }
           
        }
        
        
    }
    
    
    
}

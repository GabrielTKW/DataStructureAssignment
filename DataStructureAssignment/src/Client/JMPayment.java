package Client;

import Entity.CartItem;
import Entity.Combination;
import Entity.Delivery;
import Entity.Medicine;
import Entity.Patient;
import Entity.Payment;
import Entity.Symptom;
import adt.ArrayList;
import adt.ArrayQueue;
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

        //declare a normal profile (GABRIEL)
        Patient patient1 = new Patient("P00001");
        Patient patient2 = new Patient("P00002");
        Medicine medicine = new Medicine("M00001", "Carrot", 30, "Eat every 3 days");
        Symptom symptom = new Symptom("S0001", "Cough", "Cough multiple times a day");
        Combination combination = new Combination("C0001", symptom, medicine);

        CartItem cartItem = new CartItem(1, combination, patient2, new Payment());
        CartItem cartItem2 = new CartItem(4, combination, patient2, new Payment());
        CartItem cartItem3 = new CartItem(6, combination, patient1, new Payment());

        //create ArrayStack 
        ArrayStack<CartItem> cartArrS = new ArrayStack<CartItem>();
        cartArrS.push(cartItem);
        cartArrS.push(cartItem2);
        cartArrS.push(cartItem3);

        //---------------------------------------------------------------------------------
        //Declare object class
        Payment p = new Payment();
        Delivery del = new Delivery();

        //Declare Array Stack
        ArrayStack<Medicine> medArrStack = new ArrayStack<Medicine>();
        ArrayStack<Payment> paymentArrStack = new ArrayStack<Payment>();

        //Declare Array Queue
        ArrayQueue<Delivery> delLQueue = new ArrayQueue<Delivery>();

        //Declare methods
        paymentInitialize(paymentArrStack, p, delLQueue);
//        makePayment(medArrStack, paymentArrStack, p, delLQueue);
        paymentMenu(medArrStack, paymentArrStack, p, delLQueue, patient1, cartArrS);

    }

    public static void paymentInitialize(ArrayStack<Payment> paymentArrStack, Payment p, ArrayQueue<Delivery> delLQueue) {
        Payment p1 = new Payment("PM000001", "TnG", p.setLocalDateTime());
        Payment p2 = new Payment("PM000002", "Credit/Debit Card", p.setLocalDateTime());
        Payment p3 = new Payment("PM000003", "Online Banking", p.setLocalDateTime());
        
        paymentArrStack.push(p1);
        paymentArrStack.push(p2);
        paymentArrStack.push(p3);

        delLQueue.enqueue(new Delivery("DEL", "Delivring", p1));
        delLQueue.enqueue(new Delivery("DEL", "Deliveng", p2));
        delLQueue.enqueue(new Delivery("DEL", "Deliing", p3));
        
    }

    public static void displayPaymentRecords(ArrayStack<Payment> paymentArrStack) {
        for (int i = -1; i <= paymentArrStack.getTopIndex(); i++) {
            System.out.println(paymentArrStack.peek(i).getPaymentMethod());
        }
    }

    //add customer new payments into ArrayStack using push();
    public static void makePayment(ArrayStack<Medicine> medArrStack, ArrayStack<Payment> paymentArrStack, Payment p, ArrayQueue<Delivery> delLQueue) {

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
        String paymentMethodChosen = null;
        double paymentAmount;
        char confirmPayment;
        int afterPaymentChoice;

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("| Item Name\t  Unit Price\t\t  Quantity\t\t    Item Subtotal\t|");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i <= medArrStack.getTopIndex(); i++) {
            System.out.printf("| %-15s %-23s %-25s %-20.2f|\n", medArrStack.peek(i).getmID(), medArrStack.peek(i).getmName(), medArrStack.peek(i).getmDesc(), medArrStack.peek(i).getmPrice());
            totalPrice += medArrStack.peek(i).getmPrice();
        }
//        for (int i = 0; i <= paymentArrStack.getTopIndex(); i++) {
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

        if (paymentMethod == 1) {
            paymentMethodChosen = "Touch N Go";
            do {
                System.out.print("Enter amount to pay : ");
                paymentAmount = sc.nextDouble();

                if (paymentAmount != totalPrice) {
                    System.out.println("You have given a wrong amount. You have to pay RM" + totalPrice);
                    System.out.println("");
                } else {
                    amountCorrect = true;
                }
            } while (!amountCorrect);
        } else if (paymentMethod == 2) {
            paymentMethodChosen = "Online Banking";
            do {
                System.out.print("Enter amount to pay : ");
                paymentAmount = sc.nextDouble();

                if (paymentAmount != totalPrice) {
                    System.out.println("You have given a wrong amount. You have to pay RM" + totalPrice);
                    System.out.println("");
                } else {
                    amountCorrect = true;
                }
            } while (!amountCorrect);
        } else if (paymentMethod == 3) {
            paymentMethodChosen = "Credit/Debit Card";
            do {
                System.out.print("Enter amount to pay : ");
                paymentAmount = sc.nextDouble();

                if (paymentAmount != totalPrice) {
                    System.out.println("You have given a wrong amount. You have to pay RM" + totalPrice);
                    System.out.println("");
                } else {
                    amountCorrect = true;
                }
            } while (!amountCorrect);
        } else {
            System.out.println("Cancelled");
        }

        if (amountCorrect) {
            System.out.println("Payment Success!\n");
            p = new Payment("P", paymentMethodChosen, p.setLocalDateTime());
            paymentArrStack.push(p);

            //Display receipt after payment
            paymentReceipt(medArrStack, paymentMethodChosen, totalPrice);
            delLQueue.enqueue(new Delivery("DEL", "Delivering", p));
            System.out.println("\n1. View delivery details");
            System.out.println("2. Back to homepage");
            System.out.print("Your choice : ");
            afterPaymentChoice = sc.nextInt();

            if (afterPaymentChoice == 1) {
                displayDelivery(delLQueue, paymentArrStack, p);
            } else if (afterPaymentChoice == 2) {
                System.out.println("Homepage");
            } else {
                System.out.println("Invalid input. Please enter between 1 to 2 only.");
            }

        }
    }

    public static void paymentReceipt(ArrayStack<Medicine> medArrStack, String paymentMethodChosen, double totalPrice) {
        int qty = 5;

        System.out.println("==========================================================================================");
        System.out.println("||\t\t\t\t\tReceipt\t\t\t\t\t\t||");
        System.out.println("||\t\t\t\t\t\t\t\t\t\t\t||");
        System.out.println("||\t\t\t\t\t\t\t\t\t\t\t||");
        System.out.println("|| Item Name\t  Unit Price\t\t  Quantity\t\t    Item Subtotal\t||");
        System.out.println("==========================================================================================");
        for (int i = 0; i <= medArrStack.getTopIndex(); i++) {
            System.out.printf("|| %-15s %-23s %-25s %-19.2f||\n", medArrStack.peek(i).getmID(), medArrStack.peek(i).getmName(), medArrStack.peek(i).getmDesc(), medArrStack.peek(i).getmPrice());
        }
        System.out.println("==========================================================================================");
        System.out.printf("|| Total number of medicine purchased : %-48d||\n", qty);
        System.out.printf("|| Total amount paid : RM%-63.2f||\n", totalPrice);
        System.out.printf("|| Paid using : %-72s||\n", paymentMethodChosen);
        System.out.println("||\t\t\t\t\t\t\t\t\t\t\t||");
        System.out.println("||\t\t\t\t      End Of Receipt\t\t\t\t\t||");
        System.out.println("==========================================================================================");

    }

    //Display payment history for customer (Display from newest payment record to oldest payment record) - LIFO
    public static void paymentHistory(ArrayStack<Payment> paymentArrStack, Patient patient, ArrayStack<CartItem> cartArrS) {
        double totalPrice = 150;
        boolean found = false;
        System.out.println("\t\tYour Payment History");
        System.out.println("===================================================");
        for (int i = 0; i < paymentArrStack.getTopIndex() + 1; i++) {
            if (patient.getUserID().equals(cartArrS.peek(i).getPatient().getUserID())) {
                if (cartArrS.peek(i).getPayment() != null) {
                    System.out.println("Payment ID : " + paymentArrStack.peek(i).getPaymentID());
                    System.out.println("Payment Total : RM" + totalPrice);
                    System.out.println("Payment Date : " + paymentArrStack.peek(i).getDate());
                    System.out.println("---------------------------------------------------");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("You did not make any payment before.");
        }
    }

    public static void deletePaymentRecord() {
        
    }

    public static void displayAllPayment(ArrayStack<Payment> paymentArrStack) {
        double price = 120;
        double totalPrice = 0;
        for (int i = 0; i <= paymentArrStack.getTopIndex(); i++) {
            System.out.printf("| %-15s %-23s %-25s %-20.2f|\n", paymentArrStack.peek(i).getPaymentID(), paymentArrStack.peek(i).getPaymentMethod(), paymentArrStack.peek(i).getDate(), price);
            totalPrice += price;
        }
    }

    public static void displayDelivery(ArrayQueue<Delivery> delLQueue, ArrayStack<Payment> paymentArrStack, Payment p) {
        if (delLQueue.isEmpty()) {
            System.out.println("You do not have any delivery because you did not make any payment yet.");
        } 
        else {
//            for (int i = 0; i < delLQueue.getBackIndex(); i++) {
//                System.out.println(delLQueue.getIterator().next().getdID());
//                System.out.println(delLQueue.getIterator().next().getdStatus());
//                System.out.println(delLQueue.getIterator().next().getPayment().getDate());
//                System.out.println(delLQueue.getIterator().next().getPayment().getPaymentMethod());
//                System.out.println(delLQueue.getIterator().next().getPayment().getPaymentTime());
//                System.out.println("");
//            }

//              System.out.println(delLQueue.getFront().getdID());
//              System.out.println(delLQueue.getFront().getdStatus());
//              System.out.println(delLQueue.getFront().getPayment().getPaymentMethod());
        }
    }

    public static void paymentMenu(ArrayStack<Medicine> medArrStack, ArrayStack<Payment> paymentArrStack, Payment p, ArrayQueue<Delivery> delLQueue, Patient patient, ArrayStack<CartItem> cartArrS) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("|\t\tChoose what you want to do\t\t  |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|\t1.  Make Payment                                  |");
            System.out.println("|\t2.  Payment History                               |");
            System.out.println("|\t3.  Display delivery details                      |");
            System.out.println("|\t3.  Display all payment                           |");
            System.out.println("|\t5.  Back to homepage                              |");
            System.out.println("-----------------------------------------------------------");
            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();
            System.out.println("");

            if (choice == 1) {
                makePayment(medArrStack, paymentArrStack, p, delLQueue);
            } else if (choice == 2) {
                paymentHistory(paymentArrStack, patient, cartArrS);
            } else if (choice == 3) {
                displayDelivery(delLQueue, paymentArrStack, p);
            } else if (choice == 4) {
                displayAllPayment(paymentArrStack);
            } else if (choice == 5) {
                System.out.println("Back to homepage");
            } else {
                System.out.println("Invalid input. 1 and 2 only.");
            }
        } while (choice != 3);
    }
}

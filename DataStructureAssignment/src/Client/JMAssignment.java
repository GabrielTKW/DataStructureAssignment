package Client;

import Entity.Symptom;
import java.util.ArrayList;
import java.util.Scanner;

public class JMAssignment {

    public static void main(String[] args) {
        Symptom symptom = new Symptom();
        ArrayList<Symptom> symptomArrayList = new ArrayList<Symptom>();
        symptomInitialize(symptomArrayList);
        symptomMenu(symptomArrayList);
//        adminDisplaySymptomList(symptomArrayList);
    }

    /**
     * ************************ ADMIN SIDE FUNCTION
     * ******************************
     */
    public static void symptomMenu(ArrayList<Symptom> symptomArrayList) {
        Scanner s = new Scanner(System.in);
        int choice;

        do {
            System.out.println("-----------------------------------------------------------");
            System.out.println("|\t\tChoose what you want to do\t\t  |");
            System.out.println("-----------------------------------------------------------");
            System.out.println("|\t1.  Display Symptom                               |");
            System.out.println("|\t2.  Add Symptom                                   |");
            System.out.println("|\t3.  Edit Symptom                                  |");
            System.out.println("|\t4.  Delete Symptom                                |");
            System.out.println("|\t5.  Symptom Report                                |");
            System.out.println("|\t6.  Back                                          |");
            System.out.println("-----------------------------------------------------------");
            System.out.print("\nEnter your choice : ");
            choice = s.nextInt();

            switch (choice) {
                case 1:
                    displaySymptomList(symptomArrayList);
                    break;
                case 2:
                    addSymptom(symptomArrayList);
                    break;
                case 3:
                    editSymptom(symptomArrayList);
                    break;
                case 4:
                    deleteSymptom(symptomArrayList);
                    break;
                case 5: //displaySymptomList(symptomArrayList);
                case 6:
                    break;
                default:
                //System.out.println(ANSI_RED + "\t\t\t\t\tPlease enter from 1 to 6 only.\n" + ANSI_RESET);
            }
        } while (choice != 6);
    }

    public static void symptomInitialize(ArrayList<Symptom> symptomArrayList) {
        symptomArrayList.add(new Symptom("SYM001", "Fever", "High Body Temperature Fever"));
        symptomArrayList.add(new Symptom("SYM002", "Flu", "Flu symptom etc"));
        symptomArrayList.add(new Symptom("SYM003", "Headache", "Your head hurts etc"));
        symptomArrayList.add(new Symptom("SYM004", "Flu", "symptom etc"));
    }

    // ONLY ADMIN CAN ACCESS THIS FUNCTION
    public static void addSymptom(ArrayList<Symptom> symptomArrayList) {
        Scanner sc = new Scanner(System.in);
        String sID;
        String sName;
        String sDesc;
        char continueAdd;

        do {
            System.out.println("Enter Symptom ID : ");
            sID = sc.nextLine();

            System.out.println("Enter Symptom Name : ");
            sName = sc.nextLine();

            System.out.println("Enter Symptom Description : ");
            sDesc = sc.nextLine();

            symptomArrayList.add(new Symptom(sID, sName, sDesc));

            System.out.println("Do you want to continue adding? (Y/N) : ");
            continueAdd = sc.next().trim().charAt(0);
            sc.nextLine();
        } while (continueAdd == 'y' || continueAdd == 'Y');
    }

    //ONLY ADMIN CAN ACCESS THIS FUNCTION
    public static void editSymptom(ArrayList<Symptom> symptomArrayList) {
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        String sID;
        char continueEdit = 0;
        boolean found = false;

        do {
            System.out.print("Enter Service ID to edit(Type XXX to quit) : ");
            sID = sc.nextLine();
            sID = sID.toUpperCase();

            if (sID.equalsIgnoreCase("XXX")) {
                System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                break;
            }

            for (int i = 0; i < symptomArrayList.size(); i++) {
                if (symptomArrayList.get(i).getSID().compareTo(sID) == 0) {
                    found = true;
                    System.out.println("\n1 Record Found!");
                    System.out.println("---------------------------------------------------------------------------------");
                    System.out.println("| Symptom ID\t  Symptom\t\tSymptom Description\t\t        |");
                    System.out.println("---------------------------------------------------------------------------------");

                    System.out.printf("| %-15s %-21s %-35s     |\n", symptomArrayList.get(i).getSID(), symptomArrayList.get(i).getSName(), symptomArrayList.get(i).getSDesc());

                    System.out.println("---------------------------------------------------------------------------------\n");

                    System.out.println("Choose which to edit");
                    System.out.println("---------------------------");
                    System.out.println("1.Change Car Owner Name");
                    System.out.println("2.Change Car Owner HP No.");
                    System.out.println("3.Change Car Number Plate");
                    System.out.println("4.Change Car Name");
                    System.out.println("5.Change Car Type");
                }
            }

            //Ask admin want to continue edit records or not
            System.out.print("Do you want to continue edit? : ");
            continueEdit = sc.next().trim().charAt(0);
            sc.nextLine();
        } while (continueEdit == 'y' || continueEdit == 'Y');
        symptomArrayList.get(1).setSName("HELLOWORLD");
    }

    // ONLY ADMIN CAN ACCESS THIS FUNCTION
    public static void deleteSymptom(ArrayList<Symptom> symptomArrayList) {
        symptomArrayList.remove(2);
    }

    /**
     * ************************ CUSTOMER SIDE FUNCTION
     * ******************************
     */
    // FOR CUSTOMER SIDE
    public static void displaySymptomList(ArrayList<Symptom> symptomArrayList) {
        System.out.println("\t\t\tHealth Assessment\n");
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("| No.|\tSymptom\t\t\t\tSymptom Description\t\t   |");
        System.out.println("----------------------------------------------------------------------------");

        //display all the symptom
        for (int i = 0; i < symptomArrayList.size(); i++) {
            System.out.printf("|%2d. |  %-31s %-30s     |\n", i + 1, symptomArrayList.get(i).getSName(), symptomArrayList.get(i).getSDesc());
        }
        System.out.println("----------------------------------------------------------------------------\n");

        Scanner sc = new Scanner(System.in);
        System.out.print("What symptom do you have? : ");
        int symptom = sc.nextInt();

        System.out.println(symptomArrayList.get(symptom - 1).getSName());
    }

    public static void adminDisplaySymptomList(ArrayList<Symptom> symptomArrayList) {
        int i = 0;
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("| Symptom ID\t  Symptom\t\tSymptom Description\t\t        |");
        System.out.println("---------------------------------------------------------------------------------");

        System.out.printf("| %-15s %-21s %-35s     |\n", symptomArrayList.get(i).getSID(), symptomArrayList.get(i).getSName(), symptomArrayList.get(i).getSDesc());

        System.out.println("---------------------------------------------------------------------------------");
    }
}

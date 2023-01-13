package Nokia;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;

public class Nokia {
    Scanner scan = new Scanner(System.in);
    //To return to previous menu
    //when the user type (back) we call the previous menu in the condition statement
    // if (userInput.equalsIgnoreCase("back")) previousMenu();

    public String errorMessage(String message){
        return message;
    }
    public void menu(){
        System.out.println("""
                    WELCOME!!
                      
                    Enter:
                    1  --> Phonebook
                    2  --> Messages
                    3  --> Chat
                    4  --> Call Register
                    5  --> Tones
                    6  --> Settings
                    7  --> Call divert
                    8  --> Games
                    9  --> Calculator
                    10 --> Reminders
                    11 --> Clock
                    12 --> Profiles
                    13 --> Sim Services
                """);
        int userChoice = scan.nextInt();

        switch (userChoice){
            case 1: phonebook(); break;
//            case 2: message(); break;
//            case 3: chat(); break;
//            case 4: callRegister(); break;
//            case 5: tones(); break;
//            case 6: settings(); break;
//            case 7: callDivert(); break;
//            case 8: games(); break;
//            case 9: calculator(); break;
//            case 10: reminders(); break;
//            case 11: clock(); break;
//            case 12: profiles(); break;
//            case 13: simServices(); break;
            default: errorMessage("Invalid Input! Try Again"); menu();
        }
    }
    public void phonebook(){
        ArrayList <String> phonebook = new ArrayList<String>();
        System.out.println("""
                Enter:
                1  --> Search
                2  --> Service Nos.
                3  --> Add Name
                4  --> Erase
                5  --> Edit
                6  --> Assign tone
                7  --> Send birthday card
                8  --> Options
                9  --> Speed dials
                10 --> Voice tags
                back --> Return to previous menu
                """);


        String userPhonebookChoice = scan.next();

        switch (userPhonebookChoice){
            case "1":
                System.out.println("""
                Type a name to search:
                or 'back' to return to previous menu
                """);
                String nameToSearch = scan.next();
                phonebookBackMethod(nameToSearch);
                if (!nameToSearch.equalsIgnoreCase("back")) {

                    if (phonebook.isEmpty()){
                        System.out.println("No contact in phonebook");
                    }
                    else {
                        System.out.println(phonebook.contains(nameToSearch) ? nameToSearch + " is in contact" :  nameToSearch + " is not in contact");
                    }
                    System.out.println("Type back to return to previous menu");
                    nameToSearch = scan.next();
                    phonebookBackMethod(nameToSearch);
                    break;
                }
                break;

            case "2":
                System.out.println("""
                Type a service Number:
                or 'back' to return to previous menu
                """);
                String serviceNo = scan.next();
                phonebookBackMethod(serviceNo);
                if (!serviceNo.equalsIgnoreCase("back")) {
                    System.out.println("Service No entered.");
                    System.out.println();
                    System.out.println("Type back to return to previous menu");
                    serviceNo = scan.next();
                    phonebookBackMethod(serviceNo);
                    break;
                }
                break;

            case "3":
                System.out.println("Add Name");
                String nameToAdd = scan.next();
                phonebook.add(nameToAdd);
                System.out.println(nameToAdd+" has been added successfully!");
                System.out.println("Type 'back' to return to previous menu");
                nameToAdd = scan.next();
                phonebookBackMethod(nameToAdd);
                break;

            case "4":
                System.out.println("""
                        Type erase to erase all contact Or
                        Type back to return to previous menu
                        """);
                String eraseOption = scan.next();
                switch (eraseOption){
                    case "erase": phonebook.clear(); break;
                    case "back" : phonebookBackMethod(eraseOption);break;
                    default:
                        errorMessage("!!ERROR 41Ten!! Invalid input! Try Again");
                        phonebook();
                        break;
                }

            case "5":
                if (phonebook.isEmpty()){
                    System.out.println("No contact in phonebook\nType back to return to previous menu");
                    String option = scan.next();
                    phonebookBackMethod(option);
                }else {
                    //List the contacts for the user
                    for (String j : phonebook){
                        System.out.println(j);
                    }
                    //Prompt user to edit contact if they wish to
                    System.out.println("Which name do you wish to edit? ");
                    String contactToEdit = scan.next();
                    if (phonebook.contains(contactToEdit)){
                        phonebook.remove(contactToEdit);
                        System.out.println("Enter new name");
                        contactToEdit = scan.nextLine();
                        phonebook.add(contactToEdit);
                        System.out.println("Contact Edited Successfully");
                        System.out.println();
                        phonebook();
                    }
                }

        }

    }

    public void phonebookBackMethod(String variableParameter){
        if (variableParameter.equalsIgnoreCase("back")){
            phonebook();
        }

    }

}

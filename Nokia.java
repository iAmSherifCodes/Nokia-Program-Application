package Nokia;

import java.util.ArrayList;
import java.util.Scanner;

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
                if (nameToSearch.equalsIgnoreCase("back")){
                    phonebook();
                    break;
                }else {
                    System.out.println(phonebook.contains(nameToSearch) ? "The" + nameToSearch + "is in contact" : "The" + nameToSearch + "is not in contact");
                    System.out.println("Type back to return to previous menu");
                    nameToSearch = scan.next();
                    if (nameToSearch.equalsIgnoreCase("back")){
                        phonebook();
                        break;
                    }
                }
                break;
            case "2":
                System.out.println("""
                Type a service Number:
                or 'back' to return to previous menu
                """);
                String serviceNo = scan.next();
                if (serviceNo.equalsIgnoreCase("back")){
                    phonebook();
                    break;
                }else {
                    System.out.println("Service No entered.");
                    System.out.println();
                    System.out.println("Type back to return to previous menu");
                    serviceNo = scan.next();
                    if (serviceNo.equalsIgnoreCase("back")){
                        phonebook();
                        break;
                    }
                }
                break;

        }

    }
}

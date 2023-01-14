package Nokia;

import java.util.ArrayList;
import java.util.Scanner;

public class Nokia {
    ArrayList<String> contacts = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    //To return to previous menu
    //when the user type (back) we call the previous menu in the condition statement
    // if (userInput.equalsIgnoreCase("back")) previousMenu();

    public void addToArray(String element){
        contacts.add(element);
    }
    public void addToArray(int index, String element){
        contacts.add(index, element);
    }
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
        ArrayList<String> contacts = new ArrayList<String>();
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
       // userPhonebookChoice = scan.nextLine();

        switch (userPhonebookChoice){
            case "1":
                System.out.println("""
                Type a name to search:
                or
                """);
                String nameToSearch = scan.nextLine();
               // nameToSearch = scan.nextLine();
                previousMenuPrompt();
                phonebookBackMethod(nameToSearch);
                if (!nameToSearch.equalsIgnoreCase("back")) {

                    if (contacts.isEmpty()){
                        System.out.println("No contact in phonebook");
                    }
                    else {
                        System.out.println(contacts.contains(nameToSearch) ? nameToSearch + " is in contact" :  nameToSearch + " is not in contact");
                    }
                    previousMenuPrompt();
                    nameToSearch = scan.nextLine();
                    nameToSearch = scan.nextLine();
                    phonebookBackMethod(nameToSearch);
                    break;
                }
                break;

            case "2":
                System.out.println("Type a service Number: Or");
                previousMenuPrompt();
                String serviceNo = scan.nextLine();
                serviceNo = scan.nextLine();
                phonebookBackMethod(serviceNo);
                if (!serviceNo.equalsIgnoreCase("back")) {
                    System.out.println("Service No entered.");
                    System.out.println();
                    previousMenuPrompt();
                    serviceNo = scan.next();
                    phonebookBackMethod(serviceNo);
                    break;
                }
                break;

            case "3":
                System.out.println("Add Name");
                String nameToAdd = scan.nextLine();
                nameToAdd = scan.nextLine();
                //addToArray(nameToAdd);
                addToArray(nameToAdd);
                System.out.println(nameToAdd+" has been added successfully!");
                previousMenuPrompt();
                nameToAdd = scan.nextLine();
                nameToAdd = scan.nextLine();
                phonebookBackMethod(nameToAdd);
                break;

            case "4":
                System.out.println("""
                        Type erase to erase all contact Or
                        """);
                previousMenuPrompt();
                String eraseOption = scan.nextLine();
                eraseOption = scan.nextLine();
                switch (eraseOption){
                    case "erase": contacts.clear(); break;
                    case "back" : phonebookBackMethod(eraseOption);break;
                    default:
                        errorMessage("!!ERROR 41Ten!! Invalid input! Try Again");
                        phonebook();
                        break;
                }
                break;

            case "5":
                if (contacts.isEmpty()){
                    System.out.println("No contact in phonebook");
                    previousMenuPrompt();
                    String option = scan.nextLine();
                    option = scan.nextLine();
                    phonebookBackMethod(option);
                    break;
                }else {
                    //List the contacts for the user
                    for (int j =0; j < contacts.size() ; j++ ){
                        contacts.get(j);
                    }
                    //Prompt user to edit contact if they wish to
                    System.out.println("Which name do you wish to edit? ");
                    String contactToEdit = scan.nextLine();
                    contactToEdit = scan.nextLine();
                    if (contacts.contains(contactToEdit)){
                        contacts.remove(contactToEdit);
                        System.out.println("Enter new name");
                        contactToEdit = scan.nextLine();
                        contactToEdit = scan.nextLine();
                        contacts.add(contactToEdit);
                        System.out.println("Contact Edited Successfully");
                        System.out.println();
                        phonebook();
                    }
                }
                break;

            case "6":
                System.out.println("Congratulation! Tone Assigned");
                previousMenuPrompt();
                String choice = scan.nextLine();
                choice =scan.nextLine();
                phonebookBackMethod(choice);
                break;

            case "7":
                System.out.println("Enter receipient name: or");
                previousMenuPrompt();
                String reciepint = scan.nextLine();
                reciepint = scan.nextLine();
                phonebookBackMethod(reciepint);
                if(!reciepint.equalsIgnoreCase("back")){
                    System.out.println("Birthday Card Sent! to "+ reciepint);
                    previousMenuPrompt();
                    reciepint = scan.nextLine();
                    reciepint = scan.nextLine();
                    phonebookBackMethod(reciepint);
                    break;
                }

                break;

            case "8":
                System.out.println("Omo you don enter options o");
                previousMenuPrompt();
                choice = scan.nextLine();
                choice = scan.nextLine();
                phonebookBackMethod(choice);
                break;

            case "9":
                System.out.println("Enter Speed Dial number");
                int speedDial = scan.nextInt();
                System.out.printf("%d has been added to speed dial", speedDial);
                previousMenuPrompt();
                choice = scan.nextLine();
                choice = scan.nextLine();
                phonebookBackMethod(choice);
                break;

            case "10":
                System.out.println("You've added a voice tag!");
                previousMenuPrompt();
                System.out.println("1");
                choice = scan.nextLine();
                choice = scan.nextLine();
                phonebookBackMethod(choice);
                break;

            default:
                errorMessage("Invalid Input Or");
                previousMenuPrompt();
                choice = scan.nextLine();
                choice = scan.nextLine();
                phonebookBackMethod(choice);
                break;
        }

    }

    public void previousMenuPrompt(){
        System.out.println("Type back to return to previous menu");
    }
    public void phonebookBackMethod(String variableParameter){
        if (variableParameter.equalsIgnoreCase("back")){
            phonebook();
        }

    }

}

package Nokia;

import java.util.ArrayList;
import java.util.Scanner;

public class Nokia {
    private ArrayList<String> contacts = new ArrayList<>();

    private ArrayList<String> messagesDraft = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public void errorMessage(String message){
        System.out.println(message);
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
            case 2: message(); break;
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
      //  ArrayList<String> contacts = new ArrayList<>();
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
        scan.nextLine();
       // userPhonebookChoice = scan.nextLine();

        switch (userPhonebookChoice){
            case "1":
                previousMenuPrompt("name to search:");
                String nameToSearch = scan.nextLine();
//                nameToSearch = scan.nextLine();
                phonebookBackMethod(nameToSearch);
                if (!nameToSearch.equalsIgnoreCase("back")) {

                    if (this.contacts.isEmpty()){
                        System.out.println("No contact in phonebook");
                        System.out.println();
                    }
                    else {
                        System.out.println(this.contacts.contains(nameToSearch) ? nameToSearch + " is in contact" :  nameToSearch + " is not in contact");
                    }
                    previousMenuPrompt();
                    nameToSearch = scan.next();
                    phonebookBackMethod(nameToSearch);
                    break;
                }
                break;

            case "2":
                previousMenuPrompt("service Number:");
                String serviceNo = scan.nextLine();
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
                //addToArray(nameToAdd);
                addToContacts(nameToAdd);
                System.out.println(nameToAdd+" has been added successfully!");
                System.out.println(this.contacts);
                previousMenuPrompt();
                nameToAdd = scan.next();
                phonebookBackMethod(nameToAdd);
                break;

            case "4":
                previousMenuPrompt("erase to erase all contact");
                String eraseOption = scan.nextLine();
                switch (eraseOption){
                    case "erase":
                        contacts.clear();
                        System.out.println("All contacts erased");
                        System.out.println();
                        previousMenuPrompt();
                        eraseOption = scan.next();
                        phonebookBackMethod(eraseOption);
                        break;
                    case "back" :
                        phonebookBackMethod(eraseOption);
                        previousMenuPrompt();
                        eraseOption = scan.next();
                        phonebookBackMethod(eraseOption);
                        break;

                    default:
                        errorMessage("!!ERROR 41Ten!! Invalid input! Try Again");
                        phonebook();
                        break;
                }
                break;

            case "5":
                if (this.contacts.isEmpty()){
                    System.out.println("No contact in phonebook");
                    System.out.println();
                    previousMenuPrompt();
                    String option = scan.nextLine();
                    phonebookBackMethod(option);
                }else {
                    //List the contacts for the user
                    for (String contact : this.contacts) {
                        System.out.println("- " + contact);
                    }
                    System.out.println();
                    //Prompt user to edit contact if they wish to
                    System.out.println("Which name do you wish to edit? ");
                    String contactToEdit = scan.nextLine();
                    if (contacts.contains(contactToEdit)){
                        contacts.remove(contactToEdit);
                        System.out.println("Enter new name");
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
                previousMenuPrompt("receipient name");
                String receipient = scan.nextLine();
                receipient = scan.nextLine();
                phonebookBackMethod(receipient);
                if(!receipient.equalsIgnoreCase("back")){
                    System.out.println("Birthday Card Sent to "+ receipient);
                    previousMenuPrompt();
                    receipient = scan.next();
                    phonebookBackMethod(receipient);
                }

                break;

            case "8":
                System.out.println("""
                        1 --> Type of view
                        2 --> Memory Status
                        """);
                choice = scan.nextLine();
                choice = scan.nextLine();
                switch (choice) {
                    case "1" -> {
                        System.out.println("Type of view");
                        previousMenuPrompt();
                        choice = scan.next();
                        phonebookBackMethod(choice);
                    }
                    case "2" -> {
                        System.out.println("Memory status");
                        previousMenuPrompt();
                        choice = scan.next();
                        phonebookBackMethod(choice);
                    }
                    case "back" -> {
                        phonebookBackMethod(choice);
                        previousMenuPrompt();
                        choice = scan.next();
                        phonebookBackMethod(choice);
                    }
                }
                break;

            case "9":
                System.out.println("Enter Speed Dial number");
                int speedDial = scan.nextInt();
                System.out.printf("%d has been added to speed dial ", speedDial);
                previousMenuPrompt();
                choice = scan.next();
                phonebookBackMethod(choice);
                break;

            case "10":
                System.out.println("You've added a voice tag!");
                previousMenuPrompt();
                choice = scan.next();
                phonebookBackMethod(choice);
                break;
            case "back":
                menu();
                break;

            default:
                errorMessage("Invalid Input! Try Again"); phonebook();
                break;
        }

    }



    private void addToContacts(String nameToAdd) {
        this.contacts.add(nameToAdd);
    }


    public void previousMenuPrompt(String prompt){
        System.out.printf("Type a %s or back to return to previous menu",prompt);
        System.out.println();
    }
    public void previousMenuPrompt(){
        System.out.println("Type back to return to previous menu");
        System.out.println();
    }
    public void phonebookBackMethod(String variableParameter){
        if (variableParameter.equalsIgnoreCase("back")){
            phonebook();
        }

    }

    public void messageBackMethod(String variableParameter){
        if (variableParameter.equalsIgnoreCase("back")){
            message();
        }

    }


    public void message(){
        System.out.println("""
                Enter:
                1  --> Write messages
                2  --> Inbox
                3  --> Outbox
                4  --> Draft
                5  --> Picture messages
                6  --> Templates
                7  --> Smileys
                8  --> Messages settings
                9  --> Info Service
                10  --> Voice mailbox number
                11 --> Service command editor
                back --> Return to previous menu
                """);


        String userMessageChoice = scan.next();
        scan.nextLine();

        switch (userMessageChoice){
            case "1":
                previousMenuPrompt("Message");
                String userMessage = scan.nextLine();
//                nameToSearch = scan.nextLine();
                messageBackMethod(userMessage);
                if (!userMessage.equalsIgnoreCase("back")) {
                    this.messagesDraft.add(userMessage);

                    System.out.println();
                    System.out.println("Your message has been added to draft");
                    System.out.println();

//                    if (this.messagesDraft.isEmpty()){
//                        System.out.println("No contact in phonebook");
//                        System.out.println();
//                    }
//                    else {
//                        System.out.println(this.messagesDraft.contains(userMessage) ? userMessage + " is in contact" :  userMessage + " is not in contact");
//                    }
                    previousMenuPrompt();
                    userMessage = scan.next();
                    messageBackMethod(userMessage);
                }
                break;

            case "2":
                System.out.println("Inbox is empty! ");
                previousMenuPrompt();
                String userInboxChoice = scan.next();
                messageBackMethod(userInboxChoice);
//                if (!serviceNo.equalsIgnoreCase("back")) {
//                    System.out.println("Service No entered.");
//                    System.out.println();
//                    previousMenuPrompt();
//                    serviceNo = scan.next();
//                    phonebookBackMethod(serviceNo);
//                    break;
//                }
                break;

            case "3":
                System.out.println("Outbox is empty! ");
                previousMenuPrompt();
                String userOutboxChoice = scan.next();
                messageBackMethod(userOutboxChoice);
                break;

            case "4":
                previousMenuPrompt("view to view all messages in draft");
                String userDraftChoice = scan.nextLine();
                switch (userDraftChoice){
                    case "view":
                        if (this.messagesDraft.isEmpty()){
                            System.out.println("No message stored yet! ");
                            System.out.println();
                            previousMenuPrompt();
                            String c = scan.nextLine();
                            messageBackMethod(c);
                        }else {
                            //List all messages for the user
                            for (int message = 0 ; message < messagesDraft.size(); message++) {
                                System.out.println(message+1 + " - " + messagesDraft.get(message));
                            }
                            previousMenuPrompt();
                            String c = scan.nextLine();
                            messageBackMethod(c);
                        }
                        break;

                    case "back":
                        message();
                        break;

                    default:
                        errorMessage("!!ERROR 41Ten!! Invalid input! Try Again");
                        message();
                        break;
                }
                break;

            case "5":
                System.out.println("No picture message available");
                previousMenuPrompt();
                String pictureTemp = scan.next();
                messageBackMethod(pictureTemp);
                break;

            case "6":
                System.out.println("No templates available");
                previousMenuPrompt();
                String template = scan.next();
                messageBackMethod(template);
                break;

            case "7":
                System.out.println("Smileys");
                String smileys[] = new String[5];
                smileys[0] = "❤     😁       😍       💕       🥶       ‍🫡      😥       🙄       😶       🤩"; smileys[1] = "😊     🥰       🥲       🙂       🤔       😔       🤤       😛       🥱       😯"; smileys[2] = "🫥     😏       😮       😪       👌       😦       😤       😖       😲       🙃"; smileys[3] ="😴      😜       😒       😕       😒       🥴       🤪       🥵       ‍💨      😩"; smileys[4]= "☹️     😞       😢       😧       🤯       😰       🥶       😵       😠       😎";
                for(String smiley : smileys){
                    System.out.println(smiley);
                }
                previousMenuPrompt();
                String smileyChoice = scan.next();
                messageBackMethod(smileyChoice);
                break;

            case "8":
                messageSettings();
//                    previousMenuPrompt();
//                    String rec = scan.next();
//                    messageBackMethod(rec);
                break;

            case "9":
                System.out.println("Info service unavailable");
                previousMenuPrompt();
                String ifsChoice = scan.next();
                messageBackMethod(ifsChoice);
                break;

            case "10":
                System.out.println("Voice mailbox number empty! ");
                previousMenuPrompt();
                String vmnChoice = scan.next();
                messageBackMethod(vmnChoice);
                break;

            case "11":
                System.out.println("Service command editor ");
                previousMenuPrompt();
                String smeChoice = scan.next();
                messageBackMethod(smeChoice);
                break;
            case "back":
                menu();
                break;

            default:
                errorMessage("Invalid Input! Try Again"); message();
                break;
        }
    }


    public void messageSettings(){
        System.out.println("""
                Enter:
                1  --> Set 1°
                2  --> Common°
                back --> Return to previous menu
                """);

        String messageSettingsChoice = scan.next();
        scan.nextLine();

        switch (messageSettingsChoice){
            case "1":
                System.out.println("""
                Enter:
                1    -->   Message center number
                2    -->   Message sent as
                3    -->   Message Validity
                back --> Return to previous menu
                """);

                String msChoice = scan.next();
                if (msChoice.equalsIgnoreCase("1")){
                    System.out.println("Message center empty! ");
                    previousMenuPrompt();
                    String mcnChoice = scan.next();
                    messageBackMethod(mcnChoice);
                }
                if (msChoice.equalsIgnoreCase("2")){
                    System.out.println("Message sent as >>> ... DONE! ");
                    previousMenuPrompt();
                    String msaChoice = scan.next();
                    messageBackMethod(msaChoice);
                }
                if (msChoice.equalsIgnoreCase("3")){
                    System.out.println("Message validity is NULL! ");
                    previousMenuPrompt();
                    String mvChoice = scan.next();
                    messageBackMethod(mvChoice);
                }
                break;
            case "2":
                System.out.println("""
                Enter:
                1  --> Delivery reports
                2  --> Reply visa same centre
                3  --> Character support
                back --> Return to previous menu
                """);

                String mssChoice = scan.next();
                switch (mssChoice) {
                    case ("1") :
                        System.out.println("Delivery report Empty! ");
                        previousMenuPrompt();
                        String drChoice = scan.next();
                        messageBackMethod(drChoice);
                        break;

                    case ("2") :
                        System.out.println("Reply via same centre Empty! ");
                        previousMenuPrompt();
                        String rvscChoice = scan.next();
                        messageBackMethod(rvscChoice);
                        break;
                    case ("3"):
                        System.out.println("Character? No Support! Sorry ");
                        previousMenuPrompt();
                        String csChoice = scan.next();
                        messageBackMethod(csChoice);
                        break;
                    case ("back"):
                        messageBackMethod(mssChoice);
                        break;

                    default:
                        errorMessage("Invalid Input! Try again");
                        messageSettings();
                        break;
                }
    }

}}

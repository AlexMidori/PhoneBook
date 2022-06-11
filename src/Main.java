import java.util.Scanner;

public class Main extends Process {

    private static Scanner scanner = new Scanner(System.in);
    private static Process process = new Process();

    public static void main(String[] args) {
        boolean quit = false;
        Introduction();

        while (!quit) {
            menu();

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\n| Goodbye");
                    quit = true;
                    break;

                case 1:
                    process.printContacts();
                    break;

                case 2:
                    process.addNewContact();
                    break;

                case 3:
                    removeContact();
                    break;

                case 4:
                    searchContact();
                    break;

                default:
                    System.out.println("| Please chose again");
            }
        }
    }

    private static void removeContact() {
        System.out.println("| Enter the Name you want to remove: ");
        String lname = scanner.nextLine();
        Contact otherContact = process.searchContact(lname);
        if (otherContact == null) {

            System.out.println("| Contact does not exist");
            return;
        } else {
            process.removeContact(otherContact);

        }

    }

    private static void searchContact() {
        System.out.println("| Enter the last Name you want to search");
        String lname = scanner.nextLine();
        Contact extContact = process.searchContact(lname);
        if (extContact == null) {
            System.out.println("| Contact does not exist.");
            return;
        }
        System.out.println("| Name  :" + extContact.getLName() + ",");


    }

    private static void Introduction() {
        System.out.println("            W e l c o m e !");
    }

    private static void menu() {
        System.out.println("| _________________________________|");
        System.out.println("|  Press the number of your choice |");
        System.out.println("|    0: Exit.                      |\n" +
                           "|    1: Display Contact            |\n" +
                           "|    2: Add a New Contact          |\n" +
                           "|    3: Remove Contact             |\n" +
                           "|    4: Search Contact             |\n");
    }
}

 
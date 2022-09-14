import java.util.Scanner;

public class AppCli {
    private static Scanner scanner = new Scanner(System.in);

    public static void execute() {
        int option = 0;

        while (option != 3) {
            option = getMainMenuOption();

            switch (option) {

                // [1] Mechanic submenu
                case 1:
                    System.out.println("MECHANIC SUBMENU");
                    break;

                // [2] Vehicle submenu
                case 2:
                    System.out.println("VEHICLE SUBMENU");
                    break;

                // [3] Exit
                case 3:
                    System.out.println("Program CLOSED. See you later!");
                    break;

                // Invalid options main menu
                default:
                    System.out.println("\n*-*-*- WARNING! *-*-*-*-*\nINVALID option. Try again\n*-*-*-*-*-*-*-*-*-*-*-*-*\n");
            }
        }
    }

    private static int getMainMenuOption() {
        System.out.println("===== MAIN MENU - MECHANICAL WORKSHOP =====\n");
        System.out.println("\t[1] Mechanic Submenu");
        System.out.println("\t[2] Vehicle Submenu");
        System.out.println("\t[3] Exit");

        System.out.print("\nSelect one option: ");
        return scanner.nextInt();
    }
}

package services;

import entities.Mechanic;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MechanicService {
    private static final Scanner scanner = new Scanner(System.in);

    private List<Mechanic> mechanics = new LinkedList<>();

    private Mechanic getCpfData() {
        System.out.println("\nFill the personal identification document:");
        System.out.print(" 1. CPF: ");
        String cpf = scanner.nextLine();
        return new Mechanic(cpf);
    }

    public Mechanic getMechanicData(Mechanic mechanicToValidate) {
        System.out.println("\nFill mechanic data:");

        System.out.print(" 2. Mechanic's name: ");
        String name = scanner.nextLine();

        System.out.print(" 3. Mechanic's Birth Date (\"dd/MM/yyyy\"): ");
        String birthDate = scanner.nextLine();

        System.out.print(" 4. Mechanic's gender: ");
        String gender = scanner.nextLine();

        System.out.print(" 5. Mechanic salary: ");
        Double salary = scanner.nextDouble();

        List<String> emails = new ArrayList<>();
        char answerEmail = 'y';
        while (answerEmail != 'n') {
            System.out.print(" 6. Mechanic email: ");
            String email = scanner.nextLine();
            emails.add(email);

            System.out.print("   Do you want add another email (y/n)? ");
            answerEmail = scanner.nextLine().charAt(0);
        }

        List<String> telephones = new ArrayList<>();
        char answerTelephones = 'y';
        while (answerTelephones != 'n') {
            System.out.print(" 6. Mechanic's telephone number: ");
            String telephone = scanner.nextLine();
            emails.add(telephone);

            System.out.print("   Do you want add another telephone number (y/n)? ");
            answerTelephones = scanner.nextLine().charAt(0);
        }
        String cpf = mechanicToValidate.getCpf();
        return new Mechanic(cpf, name, birthDate, gender, salary, emails, telephones);
    }

    private boolean mechanicCpfIsNull(Mechanic mechanicDocumentCpf) {
        return mechanicDocumentCpf.getCpf().isEmpty();
    }

    public int mechanicPosition(Mechanic mechanicToFind) {
        int position = 0;
        for (Mechanic mechanic: mechanics) {
            if (mechanic.equals(mechanicToFind))
                return position;
            position++;
        }
        return -1;
    }

    public void mechanicToAdd() {
        Mechanic mechanicCpf = getCpfData();
        if (mechanicCpfIsNull(mechanicCpf))
            System.out.println("\nThere is a null mechanic's document CPF field. Please fill the input fields with a valid data.");
        else {
            int checkPosition = mechanicPosition(mechanicCpf);

            if (checkPosition != -1)
                System.out.println("\nThe mechanic exists in the system. Try again.");
            else {
                Mechanic mechanic = getMechanicData(mechanicCpf);
                addMechanic(mechanic);
                System.out.println("\nMechanic successfully added to the system!");
            }
        }
    }
    public void mechanicToUpdate() {
        Mechanic mechanicCpf = getCpfData();
        if (mechanicCpfIsNull(mechanicCpf))
            System.out.println("\nThere is a null mechanic's document CPF field. Please fill the input fields with a valid data.");
        else {
            int checkPosition = mechanicPosition(mechanicCpf);

            if (checkPosition != -1)
                System.out.println("\nThe mechanic exists in the system. Try again.");
            else {
                Mechanic mechanic = getMechanicData(mechanicCpf);
                updateMechanic(checkPosition, mechanic);
                System.out.println("\nMechanic successfully updated in the system!");
            }
        }
    }

    public void mechanicToFind() {
        if (mechanics.isEmpty())
            System.out.println("\nThere is no mechanics on the system.");
        else {
            Mechanic mechanicCpf = getCpfData();
            if (mechanicCpfIsNull(mechanicCpf))
                System.out.println("\nThere is a null mechanic's document CPF field. Please fill the input fields with a valid data.");
            else {
                int checkPosition = mechanicPosition(mechanicCpf);
                if (checkPosition == -1)
                    System.out.println("\nThe mechanic exists in the system. Try again.");
                else {
                    System.out.println(findMechanic(checkPosition));
                }
            }
        }
    }

    public void mechanicToRemove() {
        if (mechanics.isEmpty())
            System.out.println("\nThere is no mechanics on the system.");
        else {
            Mechanic mechanicCpf = getCpfData();
            if (mechanicCpfIsNull(mechanicCpf))
                System.out.println("\nThere is a null mechanic's document CPF field. Please fill the input fields with a valid data.");
            else {
                int checkPosition = mechanicPosition(mechanicCpf);
                if (checkPosition == -1)
                    System.out.println("\nThe mechanic exists in the system. Try again.");
                else {
                    removeMechanic(checkPosition);
                    System.out.println("\nMechanic successfully removed in the system!");
                }
            }
        }
    }

    public int countMechanics() {
        return mechanics.size();
    }

    public void addMechanic(Mechanic mechanic) {
        mechanics.add(mechanic);
    }

    public void updateMechanic(int position, Mechanic mechanic) {
        mechanics.set(position, mechanic);
    }

    public void findAll() {
        if (mechanics.isEmpty())
            System.out.println("\nThere is no mechanic on the system.");
        else {
            System.out.println("\nThere is [" + countMechanics() + "] mechanics in the system");
            mechanics.forEach(System.out::println);
        }
    }

    public Mechanic findMechanic(int mechanicPosition) {
        return mechanics.get(mechanicPosition);
    }

    public void removeMechanic(int mechanicPosition) {
        mechanics.remove(mechanicPosition);
    }
}


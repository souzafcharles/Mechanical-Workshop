package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Mechanic {
    private String cpf;
    private String name;
    private String birthDate;
    private String gender;
    private Double salary;
    private List<String> emails = new ArrayList<>();
    private List<String> telephones  = new ArrayList<>();

    public Mechanic() {
    }

    public Mechanic(String cpf) {
        this.cpf = cpf;
    }

    public Mechanic(String cpf, String name, String birthDate, String gender, Double salary, List<String> emails, List<String> telephones) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
        this.emails = emails;
        this.telephones = telephones;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic mechanic = (Mechanic) o;
        return cpf.equals(mechanic.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    public String listEmails() {
        StringBuilder result = new StringBuilder();

        for (String email : emails) {
            result.append("\n\t- ").append(email);
        }
        return result.toString();
    }

    public String listTelephoneNumbers() {
        StringBuilder result = new StringBuilder();

        for (String telephone : telephones) {
            result.append("\n\t- ").append(telephone);
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "CPF: " + cpf + "\tName: " + name +
                "\n   Birth date: " + birthDate +
                "\n   Gender: " + gender +
                "\n   Salary: $" + String.format("%.2f", salary) +
                "\n   Emails:" + listEmails() +
                "\n   Phone numbers:" + listTelephoneNumbers() +
                "\n\n-----------------------------";
    }
}

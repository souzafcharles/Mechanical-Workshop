package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Mechanic {
    private String CPF;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private Double salary;
    private List<String> emails;
    private List<String> telephones;

    public Mechanic() {
    }

    public Mechanic(String CPF, String name, LocalDate birthDate, String gender, Double salary) {
        this.CPF = CPF;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
    }

    public Mechanic(String CPF, String name, LocalDate birthDate, String gender, Double salary, List<String> emails, List<String> telephones) {
        this.CPF = CPF;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.salary = salary;
        this.emails = emails;
        this.telephones = telephones;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
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
        return CPF.equals(mechanic.CPF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF);
    }

    @Override
    public String toString() {
        return "CPF: " + CPF + "\tName: " + name +
                "\n   Birth date: " + birthDate +
                "\n   Gender: " + gender +
                "\n   Salary: $" + String.format("%.2f", salary) +
                "\n   Emails:" + emails +
                "\n   Phone numbers:" + telephones;
    }
}

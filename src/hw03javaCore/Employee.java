package hw03javaCore;

import java.time.LocalDate;
import java.util.Comparator;

public class Employee {
    private String fio;
    private LocalDate birthDate;
    private String post;
    private int salary;

    public Employee(String fio, LocalDate birthDate
            , String post, int salary) {
        this.fio = fio;
        this.birthDate = birthDate;
        this.post = post;
        this.salary = salary;
    }

    public String getFio(){
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }

    public String getPost(){
        return post;
    }

    public void setPost(String post){
        this.post = post;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int allowancedSalary){
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee " + fio + ", birthDate: " + birthDate +
                ", post: " + post + ", salary: " + salary + "\n";
    }

    public static Comparator<Employee> birthDateCompare() {
        return Comparator.comparing(employee -> employee.birthDate);
    }

    public void addSalary(int allowance) {
        salary += allowance;
    }
}

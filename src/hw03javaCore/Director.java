package hw03javaCore;

import java.time.LocalDate;
import java.util.ArrayList;

public class Director extends Employee{
    public Director(String fio, LocalDate birthDate, String post, int salary) {
        super(fio, birthDate, post, salary);
    }

    public static void addSalary(ArrayList<Employee> employees, int allowance) {
        for (Employee employee : employees) {
            if (!(employee instanceof Director)) {
                employee.addSalary(allowance);
            }
        }
    }
}

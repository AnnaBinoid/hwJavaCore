package hw03javaCore;

/**
 * 01. Написать прототип компаратора - метод внутри класса сотрудника,
 * сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд,
 * без использования условного оператора.
 * 02. Опишите класс руководителя, наследник от сотрудника.
 * Перенесите статический метод повышения зарплаты в класс руководителя,
 * модифицируйте метод таким образом, чтобы он мог поднять заработную
 * плату всем, кроме руководителей.
 * В основной программе создайте руководителя и поместите его в общий
 * массив сотрудников. Повысьте зарплату всем сотрудникам и проследите,
 * чтобы зарплата руководителя не повысилась.
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static hw03javaCore.Employee.birthDateCompare;

public class Main03 {
    public static void main(String[] args) {
        Employee veider = new Employee("Dart Veider"
                , LocalDate.of(2000, 3, 13)
                ,"manager"
                , 35000);
        Employee mol = new Employee("Dart Mol"
                , LocalDate.of(1900, 8, 20)
                ,"manager"
                , 36000);
        Employee tiranus = new Employee("Dart Tiranus"
                , LocalDate.of(1880, 1, 1)
                ,"manager"
                , 25000);
        Director sidius = new Director("Dart Palpatin Sidius"
                , LocalDate.of(1000, 7, 13)
                ,"Lord of the Sith"
                , 1_000_000);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(veider);
        employees.add(mol);
        employees.add(tiranus);
        employees.add(sidius);

        System.out.println(employees.toString());
        Collections.sort(employees, birthDateCompare());
        System.out.println(employees.toString());
        Director.addSalary(employees, 5000);
        System.out.println(employees.toString());

    }
}

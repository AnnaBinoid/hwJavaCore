package hw04javaCore;

/**
 * 01. В класс покупателя добавить перечисление с гендерами,
 * добавить в покупателя свойство «пол» со значением созданного перечисления.
 * Добавить геттеры, сеттеры.
 *
 * 02. Добавить в основную программу перечисление с праздниками
 * (нет праздника, Новый Год, 8 марта, 23 февраля), написать метод,
 * принимающий массив покупателей, поздравляющий всех сотрудников
 * с Новым Годом, женщин с 8 марта, а мужчин с 23 февраля, если
 * сегодня соответствующий день.
 * ( Сделала поздравляющий покупателей. )
 */

import hw04javaCore.Customer;
import hw04javaCore.Item;
import hw04javaCore.Order;
import hw04javaCore.exeptions.AmountException;
import hw04javaCore.exeptions.CustomerException;
import hw04javaCore.exeptions.ProductException;

import java.util.Arrays;


public class Shop {
    private final static Customer[] people = {
            new Customer("Ivan", 20, "+1-222-333-44-55", Gender.MALE),
            new Customer("Petr", 30, "+2-333-444-55-66", Gender.MALE),
            new Customer("Klava", 40, "911", Gender.FEMALE),
    };
    private final static Item[] items = {
            new Item("Ball", 100),
            new Item("Sandwich", 1000),
            new Item("Table", 10000),
            new Item("Car", 100000),
            new Item("Rocket", 10000000)
    };
    private static Order[] orders = new Order[5];

    private static final Holidays today = Holidays.MARCH_8;

    private static boolean isInArray(Object[] arr, Object o) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i].equals(o)) return true;
        return false;
    }

    public static Order buy(Customer who, Item what, int howMuch) {
        if (!isInArray(people, who))
            throw new CustomerException("Unknown customer: " + who);
        if (!isInArray(items, what))
            throw new ProductException("Unknown item: " + what);
        if (howMuch < 0 || howMuch > 100)
            throw new AmountException("Incorrect amount: " + howMuch);
        return new Order(who, what, howMuch);
    }

    /**
     * Метод happyHolidays принимает массив покупателей, поздравляет всех покупателей
     *  * с Новым Годом, женщин с 8 марта, а мужчин с 23 февраля, если
     *  * сегодня соответствующий день.
     * @param customers
     */
    public static void happyHolidays(Customer[] customers){
        for (int i = 0; i < customers.length; i++) {
             switch (today) {
                 case NEW_YEAR:
                     System.out.printf("Happy Ney Year, %s!\n", customers[i].getName());
                    break;
                 case FEBRUARY_23:
                     if (customers[i].getGender() == Gender.MALE)
                         System.out.printf("Happy February 23-rd, dear %s!\n", customers[i].getName());
                     break;
                 case MARCH_8:
                     if (customers[i].getGender() == Gender.FEMALE)
                         System.out.printf("Happy March 8th, dear %s!\n", customers[i].getName());
                     break;
                 default:
                     System.out.println(customers[i].getName() + ", celebrate this morning!");
                     }
             }

    }


    public static void main(String[] args) {
        Object[][] info = {
                {people[0], items[0], 1}, //good
                {people[1], items[1], -1}, //bad amount -1
                {people[0], items[2], 150}, //bad amount >100

        //        {people[1], new Item("Flower", 10), 1}, //no item
        //        {new Customer("Fedor", 40, "+3-444-555-66-77", Gender.MALE), items[3], 1}, //no customer
        };
//        int capacity = 0;
//        int i = 0;
//        while (capacity != orders.length - 1 || i != info.length) {
//            try {
//                orders[capacity] = buy((Customer) info[i][0], (Item) info[i][1], (int) info[i][2]);
//                capacity++;
//            } catch (ProductException e) {
//                e.printStackTrace();
//            } catch (AmountException e) {
//                orders[capacity++] = buy((Customer) info[i][0], (Item) info[i][1], 1);
//            } catch (CustomerException e) {
//                throw new RuntimeException(e);
//            } finally {
//                System.out.println("Orders made: " + capacity);
//            }
//            ++i;
//        }
        happyHolidays(people);
    }
}

package hw04javaCore;

/**
 * 01.
 * В класс покупателя добавить перечисление с гендерами,
 * добавить в покупателя свойство «пол» со значением
 * созданного перечисления. Добавить геттеры, сеттеры.
 */

public class Customer {

    private String name;
    private int age;
    private String phone;
    private Gender gender;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Customer(String name, int age, String phone, Gender gender) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Customer{name='" + name + '\'' +
                ", age=" + age + ", phone='" + phone + "'}";
    }

}

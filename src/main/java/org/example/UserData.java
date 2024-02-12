package org.example;

/**
 * Класс верных данных пользователя
 */

public class UserData {
    protected String surname;
    protected String name;
    protected String patronymic;
    protected String birthdate;
    protected long phoneNumber;
    protected char gender;

    public UserData(String surname, String name, String patronymic, String birthdate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String
    toString() {
        return "<"+surname + "> <" + name + "> <" + patronymic + "> <" + birthdate +
                "> <" + phoneNumber + "> <" + gender+"> \n";
    }

}

package task6;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person();
        person.setHobbies("Football");
        person.setHobbies("Hiking");
        person.setLanguages("French","A1");
        person.setLanguages("Japanese","B1");
        person.setCars("Mazda");
        person.setCars("Renault");
        Converter converter = new Converter();
        converter.convert(person);

    }
}

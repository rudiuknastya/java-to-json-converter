package task6;

import java.util.*;
public class Person {
    private String name = "Alex";
    private int age = 23;
    private boolean married = true;
    private List<String> hobbies = new ArrayList<>();
    private Map<String, String>languages = new HashMap<>();
    private char sex = 'm';
    private Set<String> cars = new TreeSet<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public void setHobbies(String hobbie) {
        hobbies.add(hobbie);
    }

    public void setLanguages(String key, String value) {
        languages.put(key,value);
    }

    public void setCars(String car) {
       cars.add(car);
    }
}

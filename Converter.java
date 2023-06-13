package task6;

import java.lang.reflect.Field;
import java.util.*;

public class Converter {
    String json = "{";
    public void convert(Person person) throws IllegalAccessException {
        Field[] allFields = Person.class.getDeclaredFields();
        for(Field f : allFields){
            f.setAccessible(true);
            if(f.getType().toString().toLowerCase().contains("boolean")){
                json += "\""+ f.getName() +"\" : " + f.get(person) +",";
            } else if(f.getType().toString().contains("List")){
                convertList(f,person);

            } else if (f.getType().toString().contains("Map")) {
                convertMap(f,person);
            } else{
                json += "\""+ f.getName() +"\" : " + "\""+ f.get(person) +"\",";
            }

        }
        if(json.charAt(json.length()-1) == ','){
            json = json.substring(0, json.length() - 1);
        }
        json += "}";
        System.out.println(json);
    }
    private void convertList(Field f, Person person) throws IllegalAccessException {
        json += "\""+ f.getName() +"\" : [ ";
        List list = (List)f.get(person);
        for(int i = 0; i < list.size(); i++){
            if(i == list.size() -1){
                json += "\"" + list.get(i) + "\" ],";
            }else{
                json += "\"" + list.get(i) + "\", ";
            }
        }
    }
    private void convertMap(Field f, Person person) throws IllegalAccessException{
        json += "\""+ f.getName() +"\" : { ";
        Map map = (Map)f.get(person);
        Set keys = map.keySet();
        Iterator iterator = keys.iterator();
        int i = 0;
        int size = map.size();
        while(iterator.hasNext()){
            Object ob = iterator.next();
            if(i == size-1){
                json += "\"" + ob + "\" : " + "\"" + map.get(ob) + "\" },";
            } else {
                json += "\"" + ob + "\" : " + "\"" + map.get(ob) + "\", ";
            }
            i++;
        }
    }
}

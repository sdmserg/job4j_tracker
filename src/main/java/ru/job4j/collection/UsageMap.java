package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sdmserg2021@gmail.com", "Petrov Sergei Viktorovich");
        map.put("ivanovk@yandex.ru", "Ivanov Konstantin Sergeevich");
        map.put("petrodm@yeandex.ru", "Petrov Dmitry Alexandrovich");
        map.put("smirnova@gmail.com", "Smirnova tatiana Sergeevna");
        map.put("lebedev@yandex.ru", "Lebedev Georgy Alexeevich");
        map.put("avgorbuneva@yeandex.ru", "Gorbuneva Anna Vasilievna");
        map.put("petrodm@yeandex.ru", "Golubev Alexei Sergeevich");
        map.put("smirnova@gmail.com", "Michalkova Daria Ivanovna");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

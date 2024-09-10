package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                result = index;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"Wildberries", "Ozon", "YandexMarket", "SberMarket"};
        try {
            int index = indexOf(value, "Amazon");
            System.out.println("Index of element is: " + index);
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}

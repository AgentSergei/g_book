import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {

        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Анна", "803-148-11");
		addContact(phoneBook, "Анна", "803-348-12");
        addContact(phoneBook, "Дана", "703-348-13");
		addContact(phoneBook, "Дана", "703-348-14");
        addContact(phoneBook, "Жанна", "403-348-15");


        // Выводим телефонов по убыванию числа
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        // Если контакт с таким именем уже существует, добавляем новый номер телефона к списку
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            // Иначе создаем новую запись в телефонной книге
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для вывода телефонной книги, отсортированной по убыванию числа
    // телефонов
    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        // Создаем список записей, сортируем его по количеству номеров телефонов
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Выводим отсортированные записи
        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            String name = entry.getKey();
            List<String> phoneNumbers = entry.getValue();
            System.out.println(name + ": " + phoneNumbers);
        }
    }
}

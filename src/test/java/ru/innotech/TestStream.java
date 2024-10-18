package ru.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.innotech.testdata.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestStream {
    @Test
    @DisplayName("Удаление из листа <String> всех дубликатов")
    public void testRemoveDuplicateString() {
        List<String> lst1 = new ArrayList<>(List.of("Привет", "Пока", "Здравствуйте", "Пока"));
        List<String> lst2 = new ArrayList<>(List.of("Привет", "Пока", "Здравствуйте"));
        lst1 = ExampleStream.removeDuplicate(lst1);
        Assertions.assertEquals(lst1, lst2);
    }

    @Test
    @DisplayName("Удаление из листа <Integer> всех дубликатов")
    public void testRemoveDuplicateInteger() {
        List<Integer> lst1 = new ArrayList<>(List.of(1, 2, 2, 3));
        List<Integer> lst2 = new ArrayList<>(List.of(1, 2, 3));
        lst1 = ExampleStream.removeDuplicate(lst1);
        Assertions.assertEquals(lst1, lst2);
    }

    @Test
    @DisplayName("Поиск в списке целых чисел 3-е наибольшее число(список > 2)")
    public void findThird() {
        List<Integer> lst1 = new ArrayList(List.of(5, 2, 10, 9, 4, 3, 10, 1, 13));
        Assertions.assertEquals(ExampleStream.findThird(lst1), 10);
    }

    @Test
    @DisplayName("Поиск в списке целых чисел 3-е наибольшее число(список <= 2)")
    public void findThirdSmall() {
        List<Integer> lst1 = new ArrayList(List.of(5, 7));
        Assertions.assertEquals(ExampleStream.findThird(lst1), null);
    }

    @Test
    @DisplayName("Поиск в списке целых чисел 3-е наибольшее уникальное число(уникальный список > 2)")
    public void findThirdUnique() {
        List<Integer> lst1 = new ArrayList(List.of(5, 2, 10, 9, 4, 3, 10, 1, 13));
        Assertions.assertEquals(ExampleStream.findThirdUnique(lst1), 9);
    }

    @Test
    @DisplayName("Поиск в списке целых чисел 3-е наибольшее уникальное число(уникальный список <= 2)")
    public void findThirdSmallUnique() {
        List<Integer> lst1 = new ArrayList(List.of(5, 7, 7));
        Assertions.assertEquals(ExampleStream.findThirdUnique(lst1), null);
    }

    @Test
    @DisplayName("Список имен 3 самых старших сотрудников с должностью Инженер")
    public void getOlderThirdEmployee() {
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("Григорий", 29, "Инженер"));
        employees1.add(new Employee("Василий", 46, "Продавец"));
        employees1.add(new Employee("Иван", 30, "Менеджер"));
        employees1.add(new Employee("Илья", 50, "Инженер"));
        employees1.add(new Employee("Кирилл", 25, "Менеджер"));
        employees1.add(new Employee("Владислав", 44, "Инженер"));
        employees1.add(new Employee("Михаил", 42, "Инженер"));
        Assertions.assertEquals(ExampleStream.olderThirdEmployee(employees1), List.of("Илья", "Владислав", "Михаил"));
    }

    @Test
    @DisplayName("Средний возраст сотрудников с должностью Инженер")
    public void getAvgEngineerEmployee() {
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("Григорий", 29, "Инженер"));
        employees1.add(new Employee("Василий", 46, "Продавец"));
        employees1.add(new Employee("Иван", 30, "Менеджер"));
        employees1.add(new Employee("Илья", 50, "Инженер"));
        employees1.add(new Employee("Кирилл", 25, "Менеджер"));
        employees1.add(new Employee("Владислав", 44, "Инженер"));
        employees1.add(new Employee("Михаил", 42, "Инженер"));
        Assertions.assertEquals(ExampleStream.avgEngineerEmployee(employees1), 41.25);
    }

    @Test
    @DisplayName("Самое длинное слово в списке")
    public void testLongestWord() {
        List<String> slst = new ArrayList<>(List.of("Машина", "Квартира", "Дом"));
        Assertions.assertEquals(ExampleStream.longestWord(slst), "Квартира");
    }

    @Test
    @DisplayName("Хеш-мапы (слово - сколько раз оно встречается)")
    public void testNumberOfWords() {
        String str = "привет пока кто дай привет дай пока дай ноль";
        Map<String, Integer> h = new HashMap<>();
        h.put("привет", 2);
        h.put("пока", 2);
        h.put("кто", 1);
        h.put("дай", 3);
        h.put("ноль", 1);
        Assertions.assertEquals(ExampleStream.numberOfWords(str), h);
    }

    @Test
    @DisplayName("Сортировка в порядке увеличения длины слова и алфавитном порядке")
    public void testSortingString() {
        List<String> lsts = new ArrayList(List.of("печенье", "круасан", "варенье", "молоко", "чай", "мёд"));
        List<String> lstres = new ArrayList(List.of("мёд", "чай", "молоко", "варенье", "круасан", "печенье"));
        Assertions.assertEquals(ExampleStream.sortingString(lsts), lstres);
    }

    @Test
    @DisplayName("Самое длинное слово в двумерном массиве строк")
    public void testLongestWordArray() {
        String[][] arrstr = new String[2][5];
        arrstr[0][0] = "Это просто пример";
        arrstr[0][1] = "Кто всё это придумал";
        arrstr[0][2] = "А как быть";
        arrstr[0][3] = "Может пора уже спать";
        arrstr[0][4] = "Зелёный цвет пахнет радугой";
        arrstr[1][0] = "Вот это поворот";
        arrstr[1][1] = "Нас ждут приключения";
        arrstr[1][2] = "У нас точно больше ничего нет";
        arrstr[1][3] = "Хорошо в деревне летом";
        arrstr[1][4] = "Утки летят на север";
        Assertions.assertEquals(ExampleStream.longestWord(arrstr), "приключения");
    }

}

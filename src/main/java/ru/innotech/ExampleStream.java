package ru.innotech;

import ru.innotech.testdata.Employee;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ExampleStream {
    public static <T> List<T> removeDuplicate(List<T> lst) {  // удаление из листа всех дубликатов
        return lst.stream()
                .distinct()
                .toList();
    }

    public static Integer findThird(List<Integer> lst) {  // поиск в списке целых чисел 3-е наибольшее число
        return lst.stream()
                .sorted(Comparator.reverseOrder()) // сортировка списка в обратном порядке
                .skip(2)    // исключение из потока первых двух записей
                .findFirst()    // первый элемент из потока
                .orElse(null);
    }

    public static Integer findThirdUnique(List<Integer> lst) {  // поиск в списке целых чисел 3-е наибольшее уникальное число
        return lst.stream()
                .distinct()
                .sorted(Comparator.reverseOrder()) // сортировка списка в обратном порядке
                .skip(2)    // исключение из потока первых двух записей
                .findFirst()    // первый элемент из потока
                .orElse(null);
    }

    public static List<String> olderThirdEmployee(List<Employee> lst) { //  получение списка имен 3 самых старших сотрудников с должностью Инженер
        return lst.stream()
                .filter(x-> x.getEmployee() == "Инженер")   // оставляем в потоке только инженеров
                .sorted(Comparator.comparing(Employee::getAge).reversed())  // сортировка по возрасту сотрудников в порядке убывания
                .limit(3)   // оставим только три первых элемента в потоке
                .map(Employee::getName) // оставляем только имена сотрудников
                .toList();
    }

    public static double avgEngineerEmployee(List<Employee> lst) { //  средний возраст сотрудников с должностью Инженер
        return lst.stream()
                .filter(x-> x.getEmployee() == "Инженер")   // оставляем в потоке только инженеров
                .mapToInt(Employee::getAge) // оставляем только возраст сотрудников и преобразуем в поток примитивного типа int
                .average()
                .orElse(0);
    }

    public static String longestWord(List<String> lst) {    // самое длинное слово в списке
        return lst.stream()
                .max(Comparator.comparingInt(String::length))// максимальная по длине строка
                .get();
    }

    public static Map<String, Integer> numberOfWords(String str) {  // хеш-мапы, в которой будут храниться пары: слово - сколько раз оно встречается во входной строке
        return Arrays.stream(str.split(" "))
                .collect(() -> new HashMap<>(), (wmap, e)-> wmap.put(e, wmap.get(e)==null ? 1 : wmap.get(e)+1), (wmap, e)-> wmap.putAll(e)); // допустим ли тренарный оператор с точки зрения функционального программирования...
    }

    public static List<String> sortingString(List<String> lst) {    // сортировка в порядке увеличения длины слова и алфавитном порядке
        return lst.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())) // сначала сортировка по длине, затем по алфавиту
                .peek(System.out::println)  // вывод в консоль
                .toList();
    }

    public static String longestWord(String[][] lst) { // массив строк, в каждой из которых лежит набор из 5 строк, разделенных пробелом, найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них
        return Arrays.stream(lst)
                .flatMap(Arrays::stream)    // преобразуем в поток второй уровень массива
                .map(s->s.split(" "))   // разбиваем каждую строку на слова
                .flatMap(Arrays::stream)    // преобразуем в поток
                .max(Comparator.comparingInt(String::length))   // максимальная по длине строка
                .get();
    }
}

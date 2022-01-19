package com.sbrf.reboot.collections;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsTest {


    /*
     * Задача.
     * Имеется список лучших студентов вуза.
     *
     * 1. Иванов
     * 2. Петров
     * 3. Сидоров
     *
     * В новом семестре по результатам подсчетов оценок в рейтинг на 1 место добавился новый студент - Козлов.
     * Теперь в рейтинге участвуют 4 студента.
     * (Предполагаем что в рейтинг можно попасть только получив достаточное количество балов, что бы занять 1 место).
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете для текущего хранения и использования списка студентов?
     *
     ОТВЕТ: LinkedList так как при добалении в начало в данной коллекции минимльная сложность по времени
     *
     * Проинициализируйте students, добавьте в нее 4 фамилии студентов что бы тест завершился успешно.
     */
    @Test
    public void addStudentToRating() {
        List<String> students = new LinkedList<>();

        students.add("Козлов");
        students.add("Иванов");
        students.add("Петров");
        students.add("Сидоров");

        assertEquals(4, students.size());
    }

    /*
     * Задача.
     * Вы коллекционируете уникальные монеты.
     * У вас имеется специальный бокс с секциями, куда вы складываете монеты в хаотичном порядке.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения монет в боксе.
     *
     ОТВЕТ: HashSet, так как используются уникальные монеты и при этом не имеет значения, как именно друг относительно
     друга они будут расположены
     *
     * Проинициализируйте moneyBox, добавьте в нее 10 монет что бы тест завершился успешно.
     */
    @Test
    public void addMoneyToBox() {

        Set<Integer> moneyBox = new HashSet<>();

        moneyBox.add(1);
        moneyBox.add(2);
        moneyBox.add(3);
        moneyBox.add(4);
        moneyBox.add(5);
        moneyBox.add(6);
        moneyBox.add(7);
        moneyBox.add(8);
        moneyBox.add(9);
        moneyBox.add(10);

        assertEquals(10, moneyBox.size());
    }

    /*
     * Задача.
     * Имеется книжная полка.
     * Периодически вы берете книгу для чтения, затем кладете ее на свое место.
     *
     * Вопрос.
     * Какую коллекцию из Collections framework вы предпочтете использовать для хранения книг.
     *
     ОТВЕТ: ArrayList, так как мы знаем, отуда берем книгу и куда потом ставим
     *
     * Проинициализируйте bookshelf, добавьте в нее 3 книги что бы тест завершился успешно.
     */
    @Test
    public void addBookToShelf() {
        class Book {
        }

        List<Book> bookshelf = new ArrayList<>();

        bookshelf.add(new Book());
        bookshelf.add(new Book());
        bookshelf.add(new Book());

        assertEquals(3, bookshelf.size());
    }

    /*
     * Задача на 5+.
     * Имеется книжная полка.
     * Вы подходите к шкафу и хотите взять конкретную книгу конкретного автора при условии, что авторы уникальны, а
     * названия нет (разные авторы могут написать книги с одинаковым названием) так же, у одного автора книг может быть
     * несколько, но один автор не может написать несколько книг с одинаковым названием
     *
     * Вопрос.
     * Какой интерфейс из Collections framework вы предпочтете использовать для хранения книг.
     *
     ОТВЕТ: HashMap, так как у нас есть необходимость поиска книг по автору уникальному автору и названию
     *
     * Проинициализируйте bookcase, добавьте в него 2х авторов и пронициализируйте booksByTolstoy и booksByLondon. В
     * переменную booksByTolstoy необходимо добавить 2 книги, а в переменную booksByLondon - одну, чтобы тесты
     * завершились корректно
     */

    @Test
    public void addBookToSCase() {
        class Book {
        }

        Map<String, HashMap<String, Book>> bookcase = new HashMap<>();
        HashMap<String, Book> booksByTolstoy = new HashMap<>();
        HashMap<String, Book> booksByLondon = new HashMap<>();

        booksByTolstoy.put("Анна Каренина", new Book());
        booksByTolstoy.put("Война и мир", new Book());
        booksByLondon.put("Белый клык", new Book());

        bookcase.put("Лев Толстой", booksByTolstoy);
        bookcase.put("Джек Лондон", booksByLondon);

        assertEquals(2, bookcase.size());
        assertEquals(1, booksByLondon.size());
        assertEquals(2, booksByTolstoy.size());
    }
}

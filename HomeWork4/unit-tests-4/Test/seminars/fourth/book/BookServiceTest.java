package seminars.fourth.book;

/*
Задание 1. Ответьте письменно на вопросы:
1) Почему использование тестовых заглушек может быть полезным при написании модульных тестов?
Ответ: это облегчает тестирование модулей, которые зависят от других модулей

2) Какой тип тестовой заглушки следует использовать, если вам нужно проверить, что метод был вызван
с определенными аргументами?
Ответ: mock

3) Какой тип тестовой заглушки следует использовать, если вам просто нужно вернуть определенное
значение или исключение в ответ на вызов метода?
Ответ: stub

4) Какой тип тестовой заглушки вы бы использовали для имитации взаимодействия с внешним API или
базой данных?
Ответ: mock

Задание 2. У вас есть класс BookService, который использует интерфейс BookRepository для получения
информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService, используя
Mockito для создания мок-объекта BookRepository.
 */

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.fourth.book.*;

public class BookServiceTest {
    BookRepository bookRepositoryMock;
    BookService bookService;

    /**
     * Начальная часть для каждого теста - создаем чистый BookService и mock для репозитория
     */
    @BeforeEach
    public void startUp() {
        bookRepositoryMock = mock(InMemoryBookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    /**
     * Тест метода findBookById
     */
    @Test
    public void BookServiceFindBookByIdTest() {
        // задаем поведение мока
        when(bookRepositoryMock.findById("2")).thenReturn(new Book("100", "Some Book", "Some Writer"));
        when(bookRepositoryMock.findAll()).thenCallRealMethod();
        when(bookRepositoryMock.findById("5")).thenThrow(new RuntimeException("Invalid book id"));

        // тестируем BookService
        bookService.findBookById("1");
        bookService.findBookById("1");
        bookService.findBookById("2");
        bookService.findBookById("3");

        // проверяем количество запуска метода с конкретными параметрами
        verify(bookRepositoryMock, times(2)).findById("1");
        verify(bookRepositoryMock, times(1)).findById("2");
        verify(bookRepositoryMock, times(1)).findById("3");
        verify(bookRepositoryMock, never()).findById("5");
    }

    /**
     * Тест для метода findAllBooks
     */
    @Test
    public void BookServiceFindAllBooksTest() {
        // задаем поведение
        when(bookRepositoryMock.findById("1")).thenCallRealMethod();
        // вызываем метод
        bookService.findAllBooks();
        // проверяем запуск метода мока
        verify(bookRepositoryMock, times(1)).findAll();

    }
}

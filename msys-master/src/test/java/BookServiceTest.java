import com.chaossnow.ms.pojo.Book;
import com.chaossnow.ms.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author chaos
 * @ClassName BookServiceTest
 * @date 2022年08月07日 22:20
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void getBookService() {
       List<Book> bookList = bookService.listBooks();
       for(Book book:bookList){
           System.out.println(book.toString());
       }
    }

    @Test
    public void getBookService1() {
        Book book = bookService.bookByTitle("三体");
        System.out.println(book.toString());
    }
}

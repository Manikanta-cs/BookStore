package net.codejava.javaee.bookstore;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BookDAOTest {
	
	private static BookDAO bookDAO;
	
	@BeforeAll
	static void init() {
		String url="jdbc:mysql://localhost:3306/bookstore";
    	String username="root";
    	String password="Manikanta123";
    	bookDAO = new BookDAO(url,username,password);
	}

	@Test
	void testConnection() throws SQLException {
		bookDAO.connect();
	}
	
	@Test
	void testInsertBook() throws SQLException {
		Book book = new Book("test", "test", 100);
		bookDAO.insertBook(book);
		List<Book> listAllBooks = bookDAO.listAllBooks();
		assertTrue(listAllBooks.size() > 0);
	}
	
	@Test
	void testDeleteBook() throws SQLException {
		List<Book> listAllBooks = bookDAO.listAllBooks();
		if (listAllBooks.size() > 0) {
			bookDAO.deleteBook(listAllBooks.get(0));
			List<Book> listAllBooks2 = bookDAO.listAllBooks();
			assertTrue(listAllBooks.size() == listAllBooks2.size() + 1);
		}
	}

}

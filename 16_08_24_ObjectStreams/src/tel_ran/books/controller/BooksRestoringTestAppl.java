package tel_ran.books.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import tel_ran.books.entities.Book;

public class BooksRestoringTestAppl {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<Book> books= new ArrayList<>();
		try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("books"))) {
			while (true) {
				Book book = (Book) input.readObject();
				books.add(book);
			}
		} catch (EOFException e) {
			
		}
		System.out.println(books);
	}

}

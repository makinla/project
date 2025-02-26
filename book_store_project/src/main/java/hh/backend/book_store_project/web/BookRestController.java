package hh.backend.book_store_project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.backend.book_store_project.domain.Book;
import hh.backend.book_store_project.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/booklistrest")
    public @ResponseBody List<Book> getAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/booklistrest/{id}")
    public @ResponseBody Optional<Book> getBookByIdRest(@PathVariable (name = "id") long bookId) {
        return bookRepository.findById(bookId);
    }

}

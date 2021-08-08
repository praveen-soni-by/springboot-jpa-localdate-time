package com.syscho.boot.controller;

import com.syscho.boot.service.command.BookCommand;
import com.syscho.boot.service.query.BookQuery;
import com.syscho.boot.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookQuery bookQuery;
    private final BookCommand bookCommand;

    @GetMapping("/{id}")
    public BookVO getById(@PathVariable("id") int id) {
        return bookQuery.findById(id);
    }

    @GetMapping("/title/{title}}")
    public List<BookVO> getByTitle(@PathVariable("title") String title) {
        return bookQuery.findByTitle(title);
    }

    @GetMapping("/byAuthorAndTitle}")
    public List<BookVO> findByTitleAndAuthor(@RequestBody BookVO bookVO) {
        return bookQuery.findByTitleAndAuthor(bookVO);
    }

    @GetMapping
    public List<BookVO> getAll() {
        return bookQuery.findAll();
    }

    @PostMapping
    public void save(@RequestBody BookVO payload) {
        bookCommand.save(payload);
    }

    @PutMapping
    public BookVO update(@RequestBody BookVO payload) {
        return bookCommand.update(payload);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") int id) {
        return bookCommand.deleteById(id);
    }
}

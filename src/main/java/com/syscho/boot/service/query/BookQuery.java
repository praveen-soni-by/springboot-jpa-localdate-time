package com.syscho.boot.service.query;

import com.syscho.boot.exception.NoDataFoundException;
import com.syscho.boot.repository.BookRepository;
import com.syscho.boot.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookQuery {

    private final BookRepository bookRepository;

    public BookVO findById(int id) {
        return bookRepository.findById(id)
                .map(BookVO::new)
                .orElseThrow(() -> new NoDataFoundException(String.valueOf(id)));
    }

    public List<BookVO> findAll() {
        return bookRepository.findAll().stream()
                .map(BookVO::new)
                .collect(Collectors.toList());
    }


    public List<BookVO> findByTitle(String title) {
        return bookRepository.findByTitleContaining(title).stream()
                .map(BookVO::new)
                .collect(Collectors.toList());
    }

    public List<BookVO> findByTitleAndAuthor(BookVO bookVO) {
        return bookRepository.findByTitleAndAuthor(bookVO.getTitle(), bookVO.getAuthor()).stream()
                .map(BookVO::new)
                .collect(Collectors.toList());
    }
}

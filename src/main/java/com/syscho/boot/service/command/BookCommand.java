package com.syscho.boot.service.command;

import com.syscho.boot.model.BookDO;
import com.syscho.boot.repository.BookRepository;
import com.syscho.boot.vo.BookVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookCommand {

    private final BookRepository bookRepository;

    @Transactional
    public String deleteById(int id) {
        return bookRepository.deleteById(id);
    }


    @Transactional
    public void save(BookVO bookVO) {
        BookDO bookDO = new BookDO();
        if (bookRepository.findByTitleContaining(bookVO.getTitle())
                .stream()
                .noneMatch(bookDO1 -> bookDO1.getTitle().equals(bookVO.getTitle()))) {
            throw new RuntimeException("Book Already Exist with title " + bookVO.getTitle());
        }
        BeanUtils.copyProperties(bookVO, bookDO);
        bookDO.setCreateTimeStamp(LocalDateTime.now());
        bookDO.setUpdatedTimeStamp(LocalDateTime.now());
        bookRepository.save(bookDO);
    }

    @Transactional
    public BookVO update(BookVO bookVO) {
        Optional<BookDO> optionalBookDO = bookRepository.findByTitleContaining(bookVO.getTitle())
                .stream()
                .filter(bookDO1 -> bookDO1.getTitle().equals(bookVO.getTitle()))
                .findFirst();

        bookVO.setUpdatedTimeStamp(LocalDateTime.now());
        bookVO.setCreateTimeStamp(LocalDateTime.now());
        if (optionalBookDO.isPresent()) {
            BookDO oldBookVo = optionalBookDO.get();
            bookVO.setCreateTimeStamp(null == oldBookVo.getCreateTimeStamp() ? LocalDateTime.now() : oldBookVo.getCreateTimeStamp());
            bookVO.setId(oldBookVo.getId());
        }
        BookDO bookDO = new BookDO();
        BeanUtils.copyProperties(bookVO, bookDO);
        bookRepository.save(bookDO);
        return bookVO;
    }
}

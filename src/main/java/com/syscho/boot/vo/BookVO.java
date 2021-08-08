package com.syscho.boot.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.syscho.boot.model.BookDO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BookVO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int height;
    private String publisher;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate publishDate;
    private LocalDateTime createTimeStamp;
    private LocalDateTime updatedTimeStamp;
    public BookVO(BookDO bookDO) {
        this.id = bookDO.getId();
        this.title = bookDO.getTitle();
        this.author = bookDO.getAuthor();
        this.genre = bookDO.getGenre();
        this.height = bookDO.getHeight();
        this.publisher = bookDO.getPublisher();
        this.publishDate = bookDO.getPublishDate();
        this.createTimeStamp = bookDO.getCreateTimeStamp();
        this.updatedTimeStamp = bookDO.getUpdatedTimeStamp();
    }
}

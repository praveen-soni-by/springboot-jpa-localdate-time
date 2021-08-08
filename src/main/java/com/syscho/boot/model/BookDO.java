package com.syscho.boot.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BOOKS")
public class BookDO {
    private int id;
    @Id
    private String title;
    private String author;
    private String genre;
    private int height;
    private String publisher;
    @Column(columnDefinition = "DATE")
    private LocalDate publishDate;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createTimeStamp;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedTimeStamp;
}

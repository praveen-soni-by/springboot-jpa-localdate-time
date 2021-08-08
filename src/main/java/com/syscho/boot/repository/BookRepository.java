package com.syscho.boot.repository;

import com.syscho.boot.model.BookDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookDO, String> {

    Optional<BookDO> findById(int id);

    List<BookDO> findByTitleContaining(String title);

    String deleteById(int id);

    List<BookDO> findByTitleAndAuthor(String title, String author);
}

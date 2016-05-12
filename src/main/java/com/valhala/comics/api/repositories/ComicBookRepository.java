package com.valhala.comics.api.repositories;

import com.valhala.comics.api.models.ComicBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComicBookRepository extends JpaRepository<ComicBook, Long> {

    List<ComicBook> findAll();

}

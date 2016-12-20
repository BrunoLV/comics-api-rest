package com.valhala.comics.api.service;

import com.valhala.comics.api.models.ComicBook;
import com.valhala.comics.api.repositories.ComicBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ComicBookService {

	@Autowired
	private ComicBookRepository repository;

	@Transactional(propagation = Propagation.REQUIRED)
	public ComicBook save(ComicBook comicBook) {
		ComicBook comic = repository.save(comicBook);
		return comic;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Long id) {
		repository.delete(id);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ComicBook findById(Long id) {
		return repository.findOne(id);
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ComicBook> findAll() {
		return repository.findAll();
	}

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Boolean alreadyExist(Long id) {
		return this.repository.exists(id);
	}

	public ComicBookRepository getRepository() {
		return repository;
	}

	public void setRepository(ComicBookRepository repository) {
		this.repository = repository;
	}

}

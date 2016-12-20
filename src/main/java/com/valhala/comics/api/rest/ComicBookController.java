package com.valhala.comics.api.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.valhala.comics.api.exceptions.ComicsConflictException;
import com.valhala.comics.api.exceptions.ComicsNoContentException;
import com.valhala.comics.api.exceptions.ComicsNotFoundException;
import com.valhala.comics.api.exceptions.ComicsValidationException;
import com.valhala.comics.api.models.ComicBook;
import com.valhala.comics.api.service.ComicBookService;
import com.valhala.comics.api.wrappers.Error;

@RestController
@RequestMapping("/comicbook")
public class ComicBookController {

	@Autowired
	private ComicBookService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Validated ComicBook comicBook, BindingResult errors,
			UriComponentsBuilder uriComponentsBuilder) {
		if (errors.hasErrors()) {
			throw new ComicsValidationException(errors);
		} // fim do bloco if
		if (comicBook.getId() != null) {
			Boolean exist = this.service.alreadyExist(comicBook.getId());
			if (exist) {
				throw new ComicsConflictException(comicBook.getId());
			} // fim do bloco if
		} // fim do bloco if
		this.service.save(comicBook);

		HttpHeaders headers = new HttpHeaders();
		URI locationUri = uriComponentsBuilder.path("/comicbook/").path(String.valueOf(comicBook.getId())).build()
				.toUri();
		headers.setLocation(locationUri);
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(headers, HttpStatus.CREATED);
		return responseEntity;
	} // fim do método save

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public ComicBook update(@PathVariable("id") Long id, @RequestBody ComicBook comicBook) {
		ComicBook book = this.service.findById(id);
		if (book == null) {
			throw new ComicsNotFoundException(id);
		} // fim do bloco if
		book.setTitulo(comicBook.getTitulo());
		book.setSubTitulo(comicBook.getSubTitulo());
		book.setEdicao(comicBook.getEdicao());
		book.setAnoPublicacao(comicBook.getAnoPublicacao());
		book.setValor(comicBook.getValor());
		book.setPaginas(comicBook.getPaginas());
		this.service.save(book);
		return book;
	} // fim do método update

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable("id") Long id) {
		Boolean exists = this.service.alreadyExist(id);
		if (!exists) {
			throw new ComicsNotFoundException(id);
		} // fim do bloco if
		service.delete(id);
	} // fim do método delete

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public ComicBook findById(@PathVariable("id") Long id) {
		ComicBook book = service.findById(id);
		if (book == null) {
			throw new ComicsNotFoundException(id);
		} // fim do bloco if
		return book;
	} // fim do método findById

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseStatus(value = HttpStatus.OK)
	public List<ComicBook> findAll() {
		List<ComicBook> comics = service.findAll();
		if (CollectionUtils.isEmpty(comics)) {
			throw new ComicsNoContentException();
		} // fim do bloco if
		return comics;
	} // fim do método findAll

	@ExceptionHandler(ComicsNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Error handleComicsNotFound(ComicsNotFoundException e) {
		Long id = e.getComicId();
		return new Error(1, "Comic id " + id + " not found.");
	} // fim do método handleComicsNotFound

	@ExceptionHandler(ComicsNoContentException.class)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public Error handleComicsNoContent(ComicsNoContentException e) {
		return new Error(2, "No content to the search.");
	} // fim do método handleComicsNoContent

	@ExceptionHandler(ComicsConflictException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public Error handleComicsConflict(ComicsConflictException e) {
		Long id = e.getComicId();
		return new Error(3, "Comic id " + id + " already exists.");
	} // fim do método handleComicsConflict

	@ExceptionHandler(ComicsValidationException.class)
	@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
	public Error handleComicsValidation(ComicsConflictException e) {
		Long id = e.getComicId();
		return new Error(4, "Comic id " + id + " already exists.");
	} // fim do método handleComicsValidation

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Error handleComicsValidation(Exception e) {
		return new Error(5, e.getMessage());
	} // fim do método handleComicsValidation

	public ComicBookService getService() {
		return service;
	}

	public void setService(ComicBookService service) {
		this.service = service;
	}

} // fim da classe ComicBookController
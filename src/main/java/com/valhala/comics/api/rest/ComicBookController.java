package com.valhala.comics.api.rest;

import com.valhala.comics.api.models.ComicBook;
import com.valhala.comics.api.service.ComicBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.rmi.activation.Activatable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comicbook")
public class ComicBookController {

    @Autowired
    private ComicBookService service;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@RequestBody @Validated ComicBook comicBook, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.unprocessableEntity().body(bindingResult.getAllErrors().stream().map(o -> o.getDefaultMessage()).collect(Collectors.toList()));
        }
        ComicBook comic = service.save(comicBook);
        return ResponseEntity.ok().body(comic);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findById(@PathVariable("id") Long id) {
        ComicBook book = service.findById(id);
        if (book == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(book);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity findAll() {
        List comics = service.findAll();
        if (CollectionUtils.isEmpty(comics)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(comics);
    }

    public ComicBookService getService() {
        return service;
    }

    public void setService(ComicBookService service) {
        this.service = service;
    }

}

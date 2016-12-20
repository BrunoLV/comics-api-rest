package com.valhala.comics.api.exceptions;

public class ComicsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Long comicId;

	public ComicsNotFoundException(Long comicId) {
		this.comicId = comicId;
	}

	public Long getComicId() {
		return comicId;
	}

}

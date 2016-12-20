package com.valhala.comics.api.exceptions;

public class ComicsConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long comicId;

	public ComicsConflictException(Long comicId) {
		super();
		this.comicId = comicId;
	}

	public Long getComicId() {
		return comicId;
	}

}

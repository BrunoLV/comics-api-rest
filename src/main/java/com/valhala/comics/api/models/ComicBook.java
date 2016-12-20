package com.valhala.comics.api.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class ComicBook implements Serializable {

	private static final long serialVersionUID = -3352321795715258487L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "{field.titulo.obrigatorio}")
	private String titulo;

	private String subTitulo;

	@NotNull(message = "{field.paginas.obrigatorio}")
	private Integer paginas;

	@NotNull(message = "{field.edicao.obrigatorio}")
	private Short edicao;

	@NotNull(message = "{field.anoPublicacao.obrigatorio}")
	private Short anoPublicacao;

	@NotNull(message = "{field.valor.obrigatorio}")
	private BigDecimal valor;

	public ComicBook() {
		super();
	}

	public ComicBook(String subTitulo, Integer paginas, Short edicao, Short anoPublicacao, BigDecimal valor) {
		super();
		this.subTitulo = subTitulo;
		this.paginas = paginas;
		this.edicao = edicao;
		this.anoPublicacao = anoPublicacao;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public void setSubTitulo(String subTitulo) {
		this.subTitulo = subTitulo;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

	public Short getEdicao() {
		return edicao;
	}

	public void setEdicao(Short edicao) {
		this.edicao = edicao;
	}

	public Short getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Short anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}

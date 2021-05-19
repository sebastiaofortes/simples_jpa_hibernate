package com.sebastiaofortes.jpa.jpa_hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Caso você precise ou queira que o nome da classe ou atributos sejam diferentes, 
// você pode customizar com as anotações @Table e @Column:

@Entity
// @Table(name = "cliente")
public class Cliente {
   
  @Id
  // @Table(name = "cliente")
  @GeneratedValue(strategy = GenerationType.IDENTITY) // o atributo id é possuí auo incremento no BD
  private Integer id;
   
  public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

private String nome;

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}
 
  // getters e setters omitidos
 
}

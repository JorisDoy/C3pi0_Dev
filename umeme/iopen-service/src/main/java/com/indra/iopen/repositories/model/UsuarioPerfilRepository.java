package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.UsuarioPerfil;
import com.indra.iopen.model.UsuarioPerfilPK;

public interface UsuarioPerfilRepository extends CrudRepository<UsuarioPerfil, UsuarioPerfilPK>{

	UsuarioPerfil findUsuarioPerfilById(UsuarioPerfilPK id);
}

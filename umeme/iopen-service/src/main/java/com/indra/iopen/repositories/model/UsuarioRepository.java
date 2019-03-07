package com.indra.iopen.repositories.model;

import org.springframework.data.repository.CrudRepository;
import com.indra.iopen.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findUsuarioByNomUsr(String nomUsr);
	
}

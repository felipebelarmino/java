package br.com.zup.apirestloteria.rest.api.repository;

import br.com.zup.apirestloteria.rest.api.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioModel, Integer> {}

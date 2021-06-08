package org.generation.blogPessoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository<Usuario> extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByUsuario(String usuario);

	public Object save(org.generation.blogPessoal.model.Usuario usuario);
}

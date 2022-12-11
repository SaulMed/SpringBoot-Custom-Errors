package mx.springboot.error.app.services;

import java.util.List;
import java.util.Optional;

import mx.springboot.error.app.domain.User;

public interface IUserService {

	public List<User> listar();
	public User obtenerPorId(Integer id);
	public Optional<User> obtenerPorIdOptional(Integer id);
	
}

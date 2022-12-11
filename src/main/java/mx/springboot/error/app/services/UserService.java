package mx.springboot.error.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.springboot.error.app.domain.User;

@Service
public class UserService implements IUserService{

	private List<User> lista;
	
	public UserService() {
		this.lista = Arrays.asList(
				new User(1,"Saul","Medina"),
				new User(2,"Jorge","Perez"),
				new User(3,"Ultra","Lord"),
				new User(4,"Paco","Rodriguez")
				);
	}
	
	@Override
	public List<User> listar() {
		return lista;
	}

	@Override
	public User obtenerPorId(Integer id) {
		User resultado = null;
		for(User usuario: this.lista) {
			if(usuario.getId().equals(id)) {
				resultado = usuario;
				break;
			}
		}
		return resultado;
	}

	@Override
	public Optional<User> obtenerPorIdOptional(Integer id) {
		User usuario = this .obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}
	
	
	
}

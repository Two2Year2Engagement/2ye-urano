package hello;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Authorities, Long>{
	  public Authorities findByUsername(String username);
}

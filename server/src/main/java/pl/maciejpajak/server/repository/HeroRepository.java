package pl.maciejpajak.server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.maciejpajak.server.model.Hero;

@RepositoryRestResource(collectionResourceRel = "heroes", path = "heroes")
public interface HeroRepository extends CrudRepository<Hero, Long> {

}

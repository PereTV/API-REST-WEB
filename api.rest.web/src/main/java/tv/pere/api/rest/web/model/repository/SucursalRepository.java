package tv.pere.api.rest.web.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tv.pere.api.rest.web.model.domain.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

}
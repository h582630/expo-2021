package expo2021.prosjektexpo2021.v2.dao;

import expo2021.prosjektexpo2021.v2.models.Stand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("postgres")
public interface StandRepository extends CrudRepository<Stand, Integer> {


}

package org.launchcode.models.data;

import org.launchcode.models.forms.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface CheeseDao extends CrudRepository<Cheese, Integer> {

}

package org.launchcode.models.data;

import org.launchcode.models.forms.Cheese;
import org.launchcode.models.forms.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface MenuDao extends CrudRepository <Menu, Integer> {

}


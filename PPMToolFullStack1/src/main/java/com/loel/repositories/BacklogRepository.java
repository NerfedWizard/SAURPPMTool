<<<<<<< HEAD
package com.loel.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loel.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog,Long>{
	
	Backlog findByProjectIdentifier(String projectIdentifier);
	
}
=======
package com.loel.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loel.domain.Backlog;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog,Long>{
	
	Backlog findByProjectIdentifier(String projectIdentifier);
	
}
>>>>>>> bb5f7472f599139ed6a3b9bc2ea695cff829329c
    
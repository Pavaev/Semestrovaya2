package project.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.Complaint;

/**
 * Created by Daniel Shchepetov on 14.04.2016.
 */

    @Repository
    public interface ComplaintRepository  extends CrudRepository<Complaint, Integer> {
    Page<Complaint> findAll(Pageable pageable);
}



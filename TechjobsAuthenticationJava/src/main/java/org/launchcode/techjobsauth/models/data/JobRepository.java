package org.launchcode.techjobsauth.models.data;

import jakarta.transaction.Transactional;
import org.launchcode.techjobsauth.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface JobRepository extends CrudRepository<Job, Integer> {
}

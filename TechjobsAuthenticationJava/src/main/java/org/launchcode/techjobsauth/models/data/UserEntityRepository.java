package org.launchcode.techjobsauth.models.data;

import org.launchcode.techjobsauth.models.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findByUserName(String username);

}

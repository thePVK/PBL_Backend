package com.example.pbl_api.repository;

import com.example.pbl_api.model.OptionGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionGroupRepository extends CrudRepository<OptionGroup,Integer> {
}

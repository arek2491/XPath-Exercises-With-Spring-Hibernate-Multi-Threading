package com.xpath.lotto.repository;

import com.xpath.lotto.domain.Numbers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface NumbersRepository extends CrudRepository<Numbers, Integer> {

    @Override
    List<Numbers> findAll();
}

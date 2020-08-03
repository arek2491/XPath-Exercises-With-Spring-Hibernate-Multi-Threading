package com.xpath.lotto.service;

import com.xpath.lotto.domain.Numbers;
import com.xpath.lotto.repository.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbService {

    @Autowired
    private NumbersRepository repository;

    public void saveNumbers(Numbers numbers) {
        repository.save(numbers);
    }

    public List<Numbers> getAllNumbers() {
        return repository.findAll();
    }
}

package com.xpath.lotto.controller;

import com.xpath.lotto.domain.Numbers;
import com.xpath.lotto.executor.NumbersExecutor;
import com.xpath.lotto.repository.NumbersRepository;
import com.xpath.lotto.saving.SaveNumbersToList;
import com.xpath.lotto.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class NumbersController {

    @Autowired
    private DbService service;

    @Autowired
    private SaveNumbersToList save;


    @GetMapping("/getNumbers")
    @Transactional
    public @ResponseBody List<Numbers> getNumbers() {
        Numbers numbers = new Numbers();
        NumbersExecutor executor = new NumbersExecutor();
        ArrayList<Integer> theList = executor.execute();

        save.saveNumbers(theList, numbers);
        service.saveNumbers(numbers);

        return service.getAllNumbers();
    }
}

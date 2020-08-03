package com.xpath.lotto.saving;

import com.xpath.lotto.domain.Numbers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SaveNumbersToList {

    public void saveNumbers(ArrayList<Integer> theList, Numbers numbers) {

        numbers.setNum1(theList.get(0));
        numbers.setNum2(theList.get(1));
        numbers.setNum3(theList.get(2));
        numbers.setNum4(theList.get(3));
        numbers.setNum5(theList.get(4));
    }
}

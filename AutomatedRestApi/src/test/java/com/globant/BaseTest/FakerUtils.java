package com.globant.BaseTest;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.Builder;
import lombok.Getter;
import java.util.Locale;

@Getter
public class FakerUtils {

    public static FakeValuesService getFaker () {

        FakeValuesService faker = new FakeValuesService(
                new Locale("en-US"), new RandomService());

        return faker;
    }

}

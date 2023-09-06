package com.in28minutes.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue fitlering() {

        SomeBean bean = new SomeBean("value1", "value1", "value1");

        MappingJacksonValue jacksonValue = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        jacksonValue.setFilters(filters);

        return jacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue fitlering_list() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value1", "value1"),
                new SomeBean("value1", "value1", "value1"),
                new SomeBean("value1", "value1", "value1"));

        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        jacksonValue.setFilters(filters);
        return jacksonValue;
    }
}

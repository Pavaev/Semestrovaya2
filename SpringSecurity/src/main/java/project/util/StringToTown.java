package project.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import project.model.Town;
import project.repo.TownRepository;


@Component
public class StringToTown implements Converter<String, Town> {

    @Autowired
    private TownRepository townRepo;

    @Override
    public Town convert(String s) {
        if (s.equals("Не указано")) {
            return null;
        }
        return townRepo.findOne(Integer.parseInt(s));
    }
}



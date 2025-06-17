package com.eryckavel.spring_boot_3.mapper.custom;

import com.eryckavel.spring_boot_3.dto.v2.PersonDTOV2;
import com.eryckavel.spring_boot_3.model.Person;
import com.eryckavel.spring_boot_3.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person entity){
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setBirthDay(new Date());
        dto.setAdress(entity.getAdress());
        dto.setGender(entity.getGender());
        return dto;
    }

    public Person convertDTOToEntity(PersonDTOV2 dto){
        Person entity = new Person();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
//        entity.setBirthDay(new Date());
        entity.setAdress(dto.getAdress());
        entity.setGender(dto.getGender());
        return entity;
    }

}

package com.eryckavel.spring_boot_3.dto.v1;

import com.eryckavel.spring_boot_3.serializer.GenderSerializer;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id" , "firstName", "adress", "lastName", "gender"})
//@JsonFilter("PersonFilter")
public class PersonDTO implements Serializable {

    private Long id;
    //@JsonProperty("first_name")
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
//    private String phoneNumber;
    private String adress;
//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private Date birthDay;
    //@JsonIgnore
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;
//    private String sensitiveData;

    public PersonDTO() {
    }

    public PersonDTO(Long id, String firstName, String lastName, String adress, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName) && Objects.equals(adress, personDTO.adress) && Objects.equals(gender, personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adress, gender);
    }
}

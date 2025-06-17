package com.eryckavel.spring_boot_3.dto.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDTOV2 implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDay;
    private String adress;
    private String gender;

    public PersonDTOV2() {
    }

    public PersonDTOV2(Long id, String firstName, String lastName, Date birthDay, String adress, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
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

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTOV2 that = (PersonDTOV2) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(birthDay, that.birthDay) && Objects.equals(adress, that.adress) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDay, adress, gender);
    }
}

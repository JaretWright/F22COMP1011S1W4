package com.example.f22comp1011s1w1;

import java.time.LocalDate;
import java.time.Period;

public class Artist {
    private String firstName, lastName;
    private LocalDate birthday;

    public Artist(String firstName, String lastName, LocalDate birthday) {
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * This method assumes artist names only contain letters or spaces
     * @param firstName
     */
    public void setFirstName(String firstName) {
        if (firstName.matches("[a-zA-Z\\s]*"))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("First name must only contain letters or spaces");
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.matches("[a-zA-Z\\s]*"))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("last name must only contain letters or spaces");
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("birthday can not be in the future");
        else
            this.birthday = birthday;
    }

    public String toString()
    {
        return String.format("%s %s - age: %d years",firstName, lastName, Period.between(birthday,LocalDate.now()).getYears());
    }
}

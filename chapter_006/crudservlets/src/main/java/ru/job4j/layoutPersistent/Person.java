package ru.job4j.layoutPersistent;

import java.io.Serializable;

public class Person implements Serializable {

    private int id;

    private String name;

    private String family;

    private String sex;

    private String description;

    public Person(int id, String name, String family, String sex, String description) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.sex = sex;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getSex() {
        return sex;
    }

    public String getDescription() {
        return description;
    }

    public boolean equals(Person p) {
        boolean result = false;
        if (this.id == p.getId() && this.name.equals(p.getName()) && this.family.equals(p.getFamily())) {
            result = true;
        }
        return result;
    }

    public boolean checkID(int id) {
        if (id==this.id) {
            return true;
        } else {
            return false;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

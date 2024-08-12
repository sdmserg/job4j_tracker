package ru.job4j.pojo;

import java.util.Date;
import java.util.Objects;

public class Licence {
    private String owner;

    private String model;

    private String code;

    private Date created;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Licence licence = (Licence) o;
        return Objects.equals(owner, licence.owner)
               && Objects.equals(model, licence.model)
               && Objects.equals(code, licence.code)
               && Objects.equals(created, licence.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, model, code, created);
    }
}

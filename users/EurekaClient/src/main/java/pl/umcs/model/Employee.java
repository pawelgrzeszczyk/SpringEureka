package pl.umcs.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;


import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=AUTO)
    private long id;
    private String name;
    private String stature;
    private int deskID;
    private int numberOfDays;

    @JsonIgnore
    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Position> positions = Lists.newArrayList();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStature() {
        return stature;
    }

    public void setStature(String stature) {
        this.stature = stature;
    }

    public int getDeskID() {
        return deskID;
    }

    public void setDeskID(int deskID) {
        this.deskID = deskID;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stature='" + stature + '\'' +
                ", deskID=" + deskID +
                ", numberOfDays=" + numberOfDays +
                ", positions=" + positions +
                ", positionsThisMonth=" + positions +
                '}';
    }
}

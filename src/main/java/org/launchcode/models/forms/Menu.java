package org.launchcode.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @ManyToMany
    private List<Cheese> cheeses;      //TODO was private, is it ok that i changed it for access?

    public Menu(int id, String name, List<Cheese> cheeses) {
        this.id = id;
        this.name = name;
        this.cheeses = cheeses;
    }

    public Menu() {}

    //TODO review below item
    public void addItem(Cheese item) {cheeses.add(item);}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }
}
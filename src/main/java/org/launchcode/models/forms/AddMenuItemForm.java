package org.launchcode.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class AddMenuItemForm {

    @NotNull
    private int menuId;

    @NotNull
    private int cheeseId;

    private Iterable<Cheese> cheeses;

    private Menu menu;

    public AddMenuItemForm(Iterable<Cheese> cheeses, Menu menu) {

        this.cheeses = cheeses;
        this.menu = menu; }

    public AddMenuItemForm() { }

    public int getMenuId () { return menuId; }

    public void setMenuId(int menuId) { this.menuId = menuId; }

    public int getCheeseId() { return cheeseId; }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public Menu getMenu() {
        return menu;
    }

    public Iterable<Cheese> getCheeses() {
        return cheeses;
    }

}

package org.launchcode.controllers;

import org.launchcode.models.data.CategoryDao;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.launchcode.models.forms.Category;
import org.launchcode.models.forms.Cheese;
import org.launchcode.models.forms.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(value="")
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @Autowired
    CheeseDao cheeseDao;

    /*TODO Write Handler method index that uses menuDao to retrieve all menus and
    display them in a list*/

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Menus");

        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddMenu(Model model) {
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());

        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddMenuForm(@ModelAttribute @Valid Menu menu,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "menu/add";

        } else {
            menuDao.save(menu);

            //model.addAttribute("singleJob", new Job());
            return "redirect:menu/view";
        }
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
//    @ResponseBody
    @ModelAttribute
    public String menuView(Model model, @PathVariable("id") Integer id) {

        Menu menu = menuDao.findOne(id);
        List<Cheese> cheeses = menu.getCheeses();
        model.addAttribute("name", cheeses);
        model.addAttribute("title", menu.getName());
//      model.addAttribute(new Menu());
        return "menu/view";
    }

    @RequestMapping(value = "menu/add-item", method = RequestMethod.GET)
    public class displayAddMenuItem(Model model, int id){

        Menu menu = menuDao.findOne(id);
        List<Cheese> cheeses = menu.getCheeses();
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Add item to menu: " + menu.getName());
        menuDao.save(menu);

        return "redirect:/view?id="menu.getId();
    }

    @RequestMapping(value = "menu/add-item", method = RequestMethod.POST)
    public String processAddMenuItem (@ModelAttribute("form") @Valid Menu menu, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add item to menu: " + menu.getName());
            return "menu/add-item";
        }
        else {
            menu = menuDao.findOne(Id);
            List<Cheese> cheeses = menu.getCheeses();
            model.addAttribute("cheeses", cheeses);
            model.addAttribute("title", "Add item to menu: " + menu.getName());
            menuDao.save(menu);
        }
        return "menu/add-item";
    }
}

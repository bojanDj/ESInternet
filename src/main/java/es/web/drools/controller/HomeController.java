/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.web.drools.controller;


import es.web.drools.dbo.Internet;
import java.security.Principal;
import java.util.ArrayList;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Bojan
 */
@Controller
@RequestMapping
public class HomeController {
    
    Internet i;
    FactHandle fh;
    
    @Autowired
    private KieSession session;
    
    @Autowired
    private KieSession session2;
    
    @GetMapping(value = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    
    @GetMapping(value = "/")
    public ModelAndView defaul() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView start(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("start");
        i = new Internet();
        i.setSpeed(0);
                System.out.println(i);

        return modelAndView;
    }
    
    @RequestMapping(value = "/devices", method = RequestMethod.POST)
    public ModelAndView devices(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("users");
        
        i.setUsers(internet.getUsers());

        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @ModelAttribute(name = "internet")
    private Internet getInternet(Model model) {
        return new Internet();
    }
    
    @RequestMapping(value = "/devices4K", method = RequestMethod.POST)
    public ModelAndView devices4K(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("devices");
        
        i.setDevices(internet.getDevices());

        modelAndView.addObject("internet", i);
        
        if (i.getDevices() == 0) modelAndView = new ModelAndView("redirect:/gamers");
        
        return modelAndView;
    }
    
    @GetMapping(value = "/devices4K")
    public ModelAndView devices4KG(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("devices");
        
        i.setDevices(internet.getDevices());

        modelAndView.addObject("internet", i);
        
        if (i.getDevices() == 0) modelAndView = new ModelAndView("redirect:/gamers");
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/gamers", method = RequestMethod.POST)
    public ModelAndView gamers(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("devices4K");
        
        i.setDevices4K(internet.getDevices4K());

        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/gamers", method = RequestMethod.GET)
    public ModelAndView gamersG(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("devices4K");
        
        i.setDevices4K(internet.getDevices4K());

        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/remote", method = RequestMethod.POST)
    public ModelAndView remote(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("gamers");
        
        i.setGamers(internet.getGamers());

        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/cloud", method = RequestMethod.POST)
    public ModelAndView cloud(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("cloud");
        
        i.setRemoteWorkers(internet.getRemoteWorkers());
        
        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/rural", method = RequestMethod.POST)
    public ModelAndView rural(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("rural");
        
        i.setCloud(internet.getCloud());
        
        modelAndView.addObject("internet", i);
                
        return modelAndView;
    }
    
    @RequestMapping(value = "/cable", method = RequestMethod.POST)
    public ModelAndView cable(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("cable");
        
        i.setRural(internet.isRural());
        
        fh = session.insert(i);
        session.fireAllRules();
        
        modelAndView.addObject("internet", i);
        
        if (i.getSpeed() > 500) modelAndView = new ModelAndView("redirect:/fiber");
        if (!i.isRural()) modelAndView = new ModelAndView("redirect:/result");
                
        return modelAndView;
    }
    
    @RequestMapping(value = "/dsl", method = RequestMethod.POST)
    public ModelAndView dsl(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("dsl");
                
        i.setCabel(internet.isCabel());
        
        modelAndView.addObject("internet", i);
        
        if (i.isCabel() && i.getSpeed() < 500) modelAndView = new ModelAndView("redirect:/result");
        if (i.getSpeed() > 200) modelAndView = new ModelAndView("redirect:/fiber");
        return modelAndView;
    }
    
    @RequestMapping(value = "/fiber", method = RequestMethod.POST)
    public ModelAndView fiber(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("fiber");
        
        i.setDsl(internet.isDsl());
        
        modelAndView.addObject("internet", i);
        
        if (i.getSpeed() < 100) modelAndView = new ModelAndView("redirect:/result");
        
        return modelAndView;
    }
    
    @GetMapping(value = "/fiber")
    public ModelAndView fiberG(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("fiber");
        
        if (i.getSpeed() < 100) modelAndView = new ModelAndView("redirect:/result");
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/fiberprice", method = RequestMethod.POST)
    public ModelAndView fiberprice(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("fiberprice");
        
        i.setFiber(internet.isFiber());
        
        modelAndView.addObject("internet", i);
        
        if (i.isFiber()) modelAndView = new ModelAndView("redirect:/result");
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ModelAndView result(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("result");
        
        i.setPrice(internet.isPrice());
        
        double speed = i.getSpeed();
        System.out.println("Rules not fired... " + i);
        
        session.update(fh, i);
        session.fireAllRules();
        
        System.out.println("Rules fired... " + i);
        i.setSpeed(speed);
        
        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @GetMapping(value = "/result")
    public ModelAndView resultG(@ModelAttribute("internet") Internet internet) {
        ModelAndView modelAndView = new ModelAndView("result");
        
        double speed = i.getSpeed();
        System.out.println("Rules not fired... Internet" + i);
        
        session.update(fh, i);
        session.fireAllRules();
        
        System.out.println("Rules fired... Internet" + i);
        i.setSpeed(speed);
        
        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
    
    @GetMapping(value = "/res/{cabel}/{cloud}/{devices}/{devices4K}/{dsl}/{fiber}/{gamers}/{price}/{remote}/{rural}/{users}")
    public ModelAndView resu(@PathVariable(name = "cabel") boolean cabel,
                             @PathVariable(name = "cloud") Long cloud,
                             @PathVariable(name = "devices") Long devices,
                             @PathVariable(name = "devices4K") Long devices4K,
                             @PathVariable(name = "dsl") boolean dsl,
                             @PathVariable(name = "fiber") boolean fiber,
                             @PathVariable(name = "gamers") Long gamers,
                             @PathVariable(name = "price") Long price,
                             @PathVariable(name = "remote") Long remote,
                             @PathVariable(name = "rural") boolean rural,
                             @PathVariable(name = "users") Long users) {
        ModelAndView modelAndView = new ModelAndView("res/result");
        Internet i = new Internet();
        	
        i.setCabel(false);
        i.setCloud(1);
        i.setDevices(7);
        i.setDevices4K(1);
        i.setDsl(true);
        i.setFiber(false);
        i.setGamers(0);
        i.setPrice(true);
        i.setRemoteWorkers(1);
        i.setRural(false);
        i.setUsers(3);
        
        session.insert(i);
        session.fireAllRules();
        System.out.println("Rules fired... Internet speed: " + i.getSpeed() + " Internet type: " + i.getType());
        modelAndView.addObject("internet", i);
        
        return modelAndView;
    }
}

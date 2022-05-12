package br.com.spring.study.springwebmvc.controller;

import br.com.spring.study.springwebmvc.model.Jedi;
import br.com.spring.study.springwebmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class JediController {

    @Autowired
    private JediRepository jediRepository;

    @GetMapping("/jedi")
    public ModelAndView jedi(){
        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("jedi");
        modelAndView.addObject("allJedi", jediRepository. findAll());
        return modelAndView;
    }

    @GetMapping("/new-jedi")
    public ModelAndView newJedi(){

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("jedi", new Jedi());

        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam(name = "name") final String name){

        final ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(name);

        modelAndView.addObject("jedi", jediRepository.findByNameContainingIgnoreCase(name));

        return modelAndView;
    }

    @PostMapping("/jedi")
    public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result, RedirectAttributes attributes){

        if (result.hasErrors()){
            return "new-jedi";
        }

        jediRepository.save(jedi);

        attributes.addFlashAttribute("message", "Jedi cadastrado com sucesso");
        return "redirect:jedi";
    }

    @GetMapping("/jedi/{id}/delete")
    public String deleteJedi(@PathVariable("id") final Long id, RedirectAttributes redirectAttributes) {

        final Optional<Jedi> jedi = jediRepository.findById(id);

        jediRepository.delete(jedi.get());

        redirectAttributes.addFlashAttribute("message", "Jedi removido com sucesso.");

        return "redirect:/jedi" ;
    }

    @GetMapping("/jedi/{id}/update")
    public String updateJedi(@PathVariable("id") final Long id, Model model) {

        final Optional<Jedi> jedi = jediRepository.findById(id);

        model.addAttribute("jedi", jedi.get());

        return "edit-jedi";
    }
}

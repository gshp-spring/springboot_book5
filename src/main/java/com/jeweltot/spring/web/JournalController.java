package com.jeweltot.spring.web;

import com.jeweltot.spring.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JournalController
{
    private static final String VIEW_INDEX = "index";

    @Autowired
    JournalRepository journalRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView)
    {
        modelAndView.setViewName(VIEW_INDEX);
        modelAndView.addObject("journal", journalRepository.findAll());

        return modelAndView;
    }
}

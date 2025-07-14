package com.eazybytes.eazyschool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.eazybytes.eazyschool.model.*;
import com.eazybytes.eazyschool.repository.*;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EazyClassRepository eazyClassRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(final Model model) {
        final List<EazyClass> eazyClasses = this.eazyClassRepository.findAll();
        final ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("eazyClasses", eazyClasses);
        modelAndView.addObject("eazyClass", new EazyClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(final Model model, @Valid @ModelAttribute("eazyClass") final EazyClass eazyClass,
            final Errors errors) {

        if (errors.hasErrors()) {
            AdminController.log.error("Class form validation failed due to: {}", errors.toString());
            final ModelAndView modelAndView = new ModelAndView("classes.html");
            modelAndView.addObject("eazyClasses", this.eazyClassRepository.findAll());
            return modelAndView;
        }
        this.eazyClassRepository.save(eazyClass);
        final ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    // Enhance this later for Large Scale Applications
    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(final Model model, @RequestParam final int id) {
        final Optional<EazyClass> eazyClass = this.eazyClassRepository.findById(id);
        for (final Person person : eazyClass.get().getPersons()) {
            person.setEazyClass(null);
            this.personRepository.save(person);
        }
        this.eazyClassRepository.deleteById(id);
        return new ModelAndView("redirect:/admin/displayClasses");
    }

    @GetMapping("/displayStudents")
    public ModelAndView displayStudents(final Model model, @RequestParam final int classId, final HttpSession session,
            @RequestParam(value = "error", required = false) final String error) {
        final ModelAndView modelAndView = new ModelAndView("students.html");
        final Optional<EazyClass> eazyClass = this.eazyClassRepository.findById(classId);
        modelAndView.addObject("eazyClass", eazyClass.get());
        modelAndView.addObject("person", new Person());
        session.setAttribute("eazyClass", eazyClass.get());
        if (error != null) {
            final String errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(final Model model, @ModelAttribute("person") final Person person,
            final HttpSession session) {
        final ModelAndView modelAndView = new ModelAndView();
        final EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
        final Person personEntity = this.personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId()
                    + "&error=true");
            return modelAndView;
        }
        personEntity.setEazyClass(eazyClass);
        this.personRepository.save(personEntity);
        eazyClass.getPersons().add(personEntity);
        this.eazyClassRepository.save(eazyClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + eazyClass.getClassId());
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(final Model model, @RequestParam final int personId, final HttpSession session) {
        final EazyClass eazyClass = (EazyClass) session.getAttribute("eazyClass");
        final Optional<Person> person = this.personRepository.findById(personId);
        person.get().setEazyClass(null);
        eazyClass.getPersons().remove(person.get());
        final EazyClass eazyClassSaved = this.eazyClassRepository.save(eazyClass);
        session.setAttribute("eazyClass", eazyClassSaved);
        final ModelAndView modelAndView = new ModelAndView(
                "redirect:/admin/displayStudents?classId=" + eazyClass.getClassId());
        return modelAndView;
    }

    // Courses Management Section

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(final Model model) {
        final List<Courses> courses = this.coursesRepository.findAll(Sort.by("name").ascending());
        final ModelAndView modelAndView = new ModelAndView("courses_secure.html");
        modelAndView.addObject("courses", courses);
        modelAndView.addObject("course", new Courses());
        return modelAndView;
    }

    @PostMapping("/addNewCourse")
    public ModelAndView addNewCourse(final Model model, @ModelAttribute("course") final Courses course) {
        final ModelAndView modelAndView = new ModelAndView();
        this.coursesRepository.save(course);
        modelAndView.setViewName("redirect:/admin/displayCourses");
        return modelAndView;
    }

    @GetMapping("/viewStudents")
    public ModelAndView viewStudents(final Model model, @RequestParam final int id, final HttpSession session,
            @RequestParam(required = false) final String error) {
        final ModelAndView modelAndView = new ModelAndView("course_students.html");
        final Optional<Courses> courses = this.coursesRepository.findById(id);
        modelAndView.addObject("courses", courses.get());
        modelAndView.addObject("person", new Person());
        session.setAttribute("courses", courses.get());
        if (error != null) {
            final String errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudentToCourse")
    public ModelAndView addStudentToCourse(final Model model, @ModelAttribute("person") final Person person,
            final HttpSession session) {
        final ModelAndView modelAndView = new ModelAndView();
        final Courses courses = (Courses) session.getAttribute("courses");
        final Person personEntity = this.personRepository.readByEmail(person.getEmail());
        if (personEntity == null || !(personEntity.getPersonId() > 0)) {
            modelAndView.setViewName("redirect:/admin/viewStudents?id=" + courses.getCourseId()
                    + "&error=true");
            return modelAndView;
        }
        personEntity.getCourses().add(courses);
        courses.getPersons().add(personEntity);
        this.personRepository.save(personEntity);
        session.setAttribute("courses", courses);
        modelAndView.setViewName("redirect:/admin/viewStudents?id=" + courses.getCourseId());
        return modelAndView;
    }

    @GetMapping("/deleteStudentFromCourse")
    public ModelAndView deleteStudentFromCourse(final Model model, @RequestParam final int personId,
            final HttpSession session) {
        final Courses courses = (Courses) session.getAttribute("courses");
        final Optional<Person> person = this.personRepository.findById(personId);
        person.get().getCourses().remove(courses);
        courses.getPersons().remove(person.get());
        this.personRepository.save(person.get());
        session.setAttribute("courses", courses);
        final ModelAndView modelAndView = new ModelAndView("redirect:/admin/viewStudents?id=" + courses.getCourseId());
        return modelAndView;
    }

}

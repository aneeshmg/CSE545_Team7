package com.sbs.sbsgroup7.api;

import com.sbs.sbsgroup7.DataSource.AppointmentRepository;
import com.sbs.sbsgroup7.model.Appointment;
import com.sbs.sbsgroup7.model.User;
import com.sbs.sbsgroup7.service.AppointmentService;
import com.sbs.sbsgroup7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("/user")
//@RestController
@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService=userService;
    }

    @Autowired
    private AppointmentService AppointmentService;



    @RequestMapping("/appointment")
    public String appointment() {
        return "appointment";
    }

    @PostMapping("/add")
    public void addUser(@NotNull @Validated @RequestBody User user){
        userService.add(user);
    }

    @PutMapping ("/update")
    public void update(@NotNull @Validated @RequestBody User user){
        userService.update(user);
    }

//    @GetMapping(path = "/{id}")
//    public User getUserById(@PathVariable("id") String id) {
//        return userService.findById(id);
//    }

    @DeleteMapping(path="/remove/{id}")
    public void deleteUserById(@PathVariable("id") String id){
        userService.delete(id);
    }

    @GetMapping(path = "/")
    public List<User> getAllUsers(){
        return userService.findAll();
    }
//    public String getAllUsers(Model model) {
//        model.addAttribute("name", "John");
//        return "index";
//    }

    @DeleteMapping(path="/removeAll")
    public void deleteAll(){
        userService.deleteAll();
    }

    @GetMapping("/createAppointment")
    public String createAccount(Model model){
        model.addAttribute("scheduleapp", new Appointment());
        return "appointment";
    }

    @PostMapping("/createAppointment")
    public void createAppointment(@ModelAttribute("schedulAapp") Appointment appointment){
        User user = userService.getLoggedUser();
        AppointmentService.createAppointment(user, appointment);
    }


}

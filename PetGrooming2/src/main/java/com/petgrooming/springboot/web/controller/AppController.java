package com.petgrooming.springboot.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.petgrooming.springboot.web.model.Appointment;
import com.petgrooming.springboot.web.model.AvailableDog;
import com.petgrooming.springboot.web.model.Client;
import com.petgrooming.springboot.web.model.GroomingOption;
import com.petgrooming.springboot.web.model.TimeSlot;
import com.petgrooming.springboot.web.service.AppointmentService;
import com.petgrooming.springboot.web.service.AvailableDogService;
import com.petgrooming.springboot.web.service.ClientService;
import com.petgrooming.springboot.web.service.GroomingOptionService;
import com.petgrooming.springboot.web.service.TimeSlotService;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
    ClientService clientService;
	
	@Autowired
	AvailableDogService availableDogService;
	
	@Autowired
	GroomingOptionService groomingOptionService;
	
	@Autowired
	TimeSlotService timeSlotService;
	
	@Autowired
	AppointmentService appointmentService;
     
    @Autowired
    MessageSource messageSource;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView registration(ModelMap model) {
    	Client client = new Client();
    	model.addAttribute(client);
        return new ModelAndView("registration");
    }
 
    /*
     * This method will register a new Client.
     */
    @RequestMapping(params = {"register"}, method = RequestMethod.POST)
    public String registerClien(HttpServletRequest request,
			HttpServletResponse response, Client client, Model model)
    {
    	if(clientService.isNewClient(client)) {
    		clientService.saveNewClient(client);
    		model.addAttribute(client);
    		return "redirect:book";
    	}else {
    		return "registration";
    	}     
    }
 
    /*
     * This method will be called on form submission, handling POST request for
     * saving Client in database. It also validates the user input
     */
    @RequestMapping(params = { "login" }, method = RequestMethod.POST)
    public String loginClient(HttpServletRequest request,
			HttpServletResponse response, Client client) {
    	
    	if(!clientService.isNewClient(client)) {
    		return "redirect:book";
    	}else {
    		return "registration";
    	}
    }
    
    @RequestMapping(value="/book", method = RequestMethod.GET)
    public String bookAppointment(ModelMap model, Client client) {
    	System.out.println("in method");
    	System.out.println("client: -> "+client.toString());
    	Appointment appointment = new Appointment();
    	appointment.setClient(clientService.findClientById(client.getId()));
    	model.addAttribute(appointment);
    	List<GroomingOption> groomingOptionList = groomingOptionService.getGroomingOptions();
    	List <AvailableDog> availableDogList = availableDogService.findAllDogs();
    	List<TimeSlot> timeslotList = timeSlotService.findAllTimeSlots();
    	System.out.println("timeeeee" +timeslotList.get(1));
    	model.addAttribute(groomingOptionList);
    	model.addAttribute(availableDogList);
    	model.addAttribute(timeslotList);
    	return "bookAppointment";
    }
    
    @RequestMapping(value = "appointmentSave", method = RequestMethod.POST)
    public String appointmentSave(Appointment appointment)
    {
    	System.out.println("in save appointment");
    	appointmentService.saveAppointment(appointment);
    	
    	return "home";   
    }

}

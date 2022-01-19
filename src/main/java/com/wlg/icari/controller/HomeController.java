package com.wlg.icari.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlg.icari.entities.Participant;
import com.wlg.icari.services.ParticipantService;

import com.razorpay.*;

@Controller
public class HomeController 
{
	
	@Autowired
	private ParticipantService participantService;
	
	@GetMapping({"","/","/index","/home"})
	public String getHome()
	{
		return "index";
	}
	
	@GetMapping({"/confReg"})
	public String getConfReg(Model m)
	{
		m.addAttribute("confRegData", new Participant());
		return "conference-registration";
	}
	
	@GetMapping({"/paperPubReg"})
	public String getPaperPubReg()
	{
		return "paper-publishing-registration";
	}
	
	@PostMapping("/process")
	public String addConfParticipant(@Valid @ModelAttribute("confRegData") Participant participant, BindingResult bindingResult, Model m)
	{
		if(bindingResult.hasErrors())
		{
			return "conference-registration";
		}
		Participant p = this.participantService.addParticipant(participant);
		if(p == null)
		{
			m.addAttribute("status", false);
		}
		else
		{
			m.addAttribute("status", true);
		}
		return "conference-registration";
	}
	
//	@PostMapping("/createConfOrder")
//	@ResponseBody
//	public String createConfOrder(@RequestBody Map<String, Object> data) throws Exception
//	{
//		int amount = Integer.parseInt(data.get("amount").toString());
//		 client = new RazorpayClient("rzp_test_EJZbjY3c7c2HlH", "aPEqj6tNFnbuJhK5fVJS1PzW");
//		JSONObject ob = new JSONObject();
//		ob.put("amount", amount*100);
//		ob.put("currency", "INR");
//		ob.put("receipt", "txn_235425");
//		
//		Order order = client.Orders.create(ob);
//		System.out.println(order);
//		return order.toString();
//	}
}

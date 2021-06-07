package com.techouts.bookStoreController;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techouts.bookStore.Model.UserInfo;
import com.techouts.bookStoreDao.Operations;

@Controller
public class RegistrationController {
	@Autowired
	Operations operations;// =new Operations();

	@RequestMapping("/regist")
	public String login(Model m) {
		m.addAttribute("command", new UserInfo());
		// System.out.println("hey brother");
		return "register";
	}

	@RequestMapping("/register")
	public ModelAndView register(@RequestParam("firstName") String name, @RequestParam("lastName") String lname,
			@RequestParam("phoneNumber") int phone, @RequestParam("emailId") String mail,
			@RequestParam("gender") String gender, @RequestParam("location") String loc,
			@RequestParam("password") String pass, @RequestParam("repassword") String repass) {

		String fname = name;
		String lName = lname;
		int phoneNumber = phone;
		String mailid = mail;
		String gen = gender;
		String location = loc;
		String password=pass;
		String repassw=repass;
		System.out.println(loc);
		System.out.println(mailid);
		//m.addAttribute("command", new Registration());
		
		if(password.equals(repassw)){
			operations.registerUser(fname, lName, phoneNumber, mailid, gen, location, password, repassw);
		//m.addAttribute("command", operations);
		ModelAndView mv = new ModelAndView("registerview", "reg", operations);
		// System.out.println("hi friends");
		return mv;
		}
		else
		{
			ModelAndView modelAndView= new ModelAndView("reregister");
			return modelAndView;
		}
	}
	@RequestMapping("/loginToShop")
	public String loginToShop() {
		//m.addAttribute("command", new UserInfo());
		//System.out.println("hello world");
		return "reshop";
	}
	@RequestMapping("/login")
	public String log()
	{
		return "hellocustom";
	}
	/*@RequestMapping("/HomeLogin")
	public String logH(Model m) {
		m.addAttribute("command", new UserInfo());
		System.out.println("hello world");
		return "Login";
	}
*/
	/*@RequestMapping("/log")
	public ModelAndView login(@RequestParam("phoneNumber") int number, @RequestParam("password") String pass) {
		System.out.println(number);
		boolean b = operations.getUser(number, pass);
		System.out.println(b);

		try {
			if (b == false) {
				System.err.println("false");
				ModelAndView andView = new ModelAndView("error");
				return andView;
			}
			if (b == true) {
				ModelAndView andView = new ModelAndView("reshop");
				return andView;

			}

		} catch (Exception e) {
			System.out.println("error");*/
	@RequestMapping("/log")
	public String logon(@RequestParam("username") int number,@RequestParam("password") String pass,Model m)
	{
		
		System.out.println(number);
		

			// System.out.println("error");

		

		return "reshop";

	}
	@RequestMapping("/check")
	public String checkOut(Model m) throws SerialException, IOException, SQLException {
		// operations.addCart(bookId);
		//List<ActionAndAdventures> li = operations.addCart(bookId);

		//m.addAttribute("command", li);
		//m.addAttribute("command" ,new UserInfo());
		
		//List<ActionAndAdventures> li = operations.action();

		//m.addAttribute("command", li);
		System.out.println("come on");
		return "checks";

		// return null;
	}
	@RequestMapping("/reshop")
	public String reShop(Model m)
	{
		return "reshop";
	}
	


}

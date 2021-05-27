package com.techouts.bookStoreController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.techouts.bookStore.Model.ActionAndAdventures;
import com.techouts.bookStore.Model.GenralStudies;
import com.techouts.bookStore.Model.HistoricalFiction;
import com.techouts.bookStore.Model.Horror;
import com.techouts.bookStore.Model.RomCom;
import com.techouts.bookStore.Model.ScienceFiction;
import com.techouts.bookStore.Model.Thriller;
import com.techouts.bookStore.Model.UserInfo;
import com.techouts.bookStoreDao.Operations;

@Controller
public class BookStoreController {
	// BookStorePdpDao bp=new BookStorePdpDao();
	@Autowired
	Operations operations;// =new Operations();
	@Autowired
	ModelAndView mav;

	@RequestMapping("/ActAndAdv")
	public String act(Model m) throws SerialException, IOException, SQLException {
		/*
		 * List<ActionAndAdventure> act = operations.action(); for
		 * (ActionAndAdventure actionAndAdventure : act) {
		 * System.out.println(actionAndAdventure.getBookAuthor()); }
		 * //m.addAttribute("command", new UserInfo());
		 * System.out.println("hello world"); ModelAndView andView = new
		 * ModelAndView("ActionView"); return andView;
		 */
		List<ActionAndAdventures> li = operations.action();

		m.addAttribute("command", li);
		// System.out.println("hello world");
		return "action";
	}

	@RequestMapping("/sciencefiction")
	public String scienceF(Model m) throws SerialException, SQLException, IOException {
		List<ScienceFiction> li = operations.getSfiction();
		m.addAttribute("command", li);
		System.out.println("hello world");
		return "sci";
	}

	@RequestMapping("/horror")
	public String horror(Model m) throws SerialException, SQLException, IOException {
		List<Horror> li = operations.getHorror();
		m.addAttribute("command", li);
		System.out.println("hello world");
		return "hor";
	}

	@RequestMapping("/thriller")
	public String thriller(Model m) throws SerialException, SQLException, IOException {
		List<Thriller> li = operations.getThriller();
		m.addAttribute("command", li);
		System.out.println("hello world");
		return "thrill";
	}

	@RequestMapping("/romcom")
	public String romCom(Model m) throws SerialException, SQLException, IOException {
		List<RomCom> li = operations.getRomCom();
		m.addAttribute("command", li);
		System.out.println("hello world");
		return "rom";
	}

	@RequestMapping("/general")
	public String general(Model m) throws SerialException, SQLException, IOException {
		List<GenralStudies> li = operations.getGeneralStudies();
		m.addAttribute("command", li);
		System.out.println("hello world");
		return "gen";
	}

	@RequestMapping("/historicalfiction")
	public String historicalF(Model m) throws SerialException, SQLException, IOException {
		List<HistoricalFiction> li = operations.getHistoricalFiction();
		m.addAttribute("command", li);
		System.out.println("hello world");
		return "hisF";
	}

	@RequestMapping(value = "/buyBook/{bookId}", method = RequestMethod.GET)
	public String saleAction(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<ActionAndAdventures> i = operations.pdpAct(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/addCart/{bookId}", method = RequestMethod.GET)
	public String Actioncart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<ActionAndAdventures> li = operations.addCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	@RequestMapping(value = "/HbuyBook/{bookId}", method = RequestMethod.GET)
	public String Historysales(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<HistoricalFiction> i = operations.pdpHistoricalFiction(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/HaddCart/{bookId}", method = RequestMethod.GET)
	public String Historycart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<HistoricalFiction> li = operations.historyCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	@RequestMapping(value = "/HobuyBook/{bookId}", method = RequestMethod.GET)
	public String horrorsales(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<Horror> i = operations.pdpHorrror(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/HoaddCart/{bookId}", method = RequestMethod.GET)
	public String horrorCart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<Horror> li = operations.horrorCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	@RequestMapping(value = "/TbuyBook/{bookId}", method = RequestMethod.GET)
	public String thrillerSales(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<Thriller> i = operations.pdpThriller(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/TaddCart/{bookId}", method = RequestMethod.GET)
	public String thrillerCart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<Thriller> li = operations.thrillerCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	@RequestMapping(value = "/RobuyBook/{bookId}", method = RequestMethod.GET)
	public String romComSales(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<RomCom> i = operations.pdpActRomCom(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/RoaddCart/{bookId}", method = RequestMethod.GET)
	public String romComCart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<RomCom> li = operations.romcomCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	@RequestMapping(value = "/SbuyBook/{bookId}", method = RequestMethod.GET)
	public String scienceFictionSales(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<ScienceFiction> i = operations.pdpScienceFiction(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/SaddCart/{bookId}", method = RequestMethod.GET)
	public String scienceFictionCart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<ScienceFiction> li = operations.scienceFictionCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	@RequestMapping(value = "/GbuyBook/{bookId}", method = RequestMethod.GET)
	public String genralsales(@PathVariable int bookId, Model m) throws SerialException, SQLException, IOException {
		System.out.println(bookId);

		List<GenralStudies> i = operations.pdpGeneral(bookId);
		m.addAttribute("command", i);
		System.out.println(i.toString());
		/*
		 * for(ActionAndAdventure a:i) { System.out.println(a.getBookName()); }
		 */
		// System.out.println(i);
		return "sale";
	}

	@RequestMapping(value = "/GaddCart/{bookId}", method = RequestMethod.GET)
	public String genralCart(@PathVariable int bookId, Model m) {
		// operations.addCart(bookId);
		List<GenralStudies> li = operations.generalCart(bookId);

		m.addAttribute("comm", li);

		return "cart";

		// return null;
	}
	
	
}

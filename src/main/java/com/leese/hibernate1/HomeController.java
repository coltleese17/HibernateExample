package com.leese.hibernate1;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		//get the list of books from the dao
		List<Book> books = DAO.getAllBooks();
		
		//add this list to model
		model.addAttribute("bookList", books);
		
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, HttpServletRequest request) {
		//System.out.println(request.getQueryString());
		
		
		Book book = new Book();
		book.setTitle(request.getParameter("title"));
		book.setAuthor(request.getParameter("author"));
		book.setPublisher(request.getParameter("publisher"));
		book.setSales(Integer.parseInt(request.getParameter("sales")));
		
		DAO.addBook(book);
		
		model.addAttribute("author", request.getParameter("author"));
		model.addAttribute("title", request.getParameter("title"));
		model.addAttribute("publisher", request.getParameter("publisher"));
		model.addAttribute("sales", request.getParameter("sales"));
		return "add";
	}
	
	@RequestMapping(value = "/delete", method= RequestMethod.GET)
	public String delete(Model model, HttpServletRequest request) {
		
		//THIS ALSO DELETES THE BOOK
		Book deletedBook = DAO.deleteBook(Integer.parseInt(request.getParameter("bookRank")));
		//DAO.deleteBook(Integer.parseInt(request.getParameter("rank")));
		//<!--   <td><a href="<c:url value='/delete/${book[status.index].rank}' />" >Delete</a></td> -->
		model.addAttribute("author", deletedBook.getAuthor());
		model.addAttribute("title", deletedBook.getTitle());
		model.addAttribute("publisher", deletedBook.getPublisher());
		model.addAttribute("sales", deletedBook.getSales());
		
		return "delete";
	}
	/*
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(Model model, HttpServletRequest request) {
        
        DAO.deleteBook(Integer.parseInt(request.getParameter("rank")));
        model.addAttribute("rank", Integer.parseInt(request.getParameter("rank")));
        return "delete";
    }
	*/
	
}

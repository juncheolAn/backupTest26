package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Book;
import ksmart.project.test26.service.BookDao;

@Controller
public class BookController{
	@Autowired
	private BookDao bookdao;
	@RequestMapping(value="/book/bookList")
	public String bookList(Model model) {
		List<Book> list = bookdao.selectBookList();
		model.addAttribute("list",list);
		return "book/bookList";
	}
	
	// book/bookUpdate����  get ������� ȣ���Ͽ� �Ѹ� ����Ʈ ���
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.GET)
	public String bookSelectOne(Model model, @RequestParam(value="book_id", required=true) int book_id) {
		List<Book> list = bookdao.getBook(book_id);
		model.addAttribute("list", list);
		return "book/bookUpdate";
	}
	
	// book/bookUpdate���� post ������� ȣ�� 
	@RequestMapping(value="/book/bookUpdate", method = RequestMethod.POST)
	public String bookUpdate(Book book) {
		bookdao.updateBook(book);
		return "redirect:/book/bookList";
	}
	
	// book INSERT �Էºκ�
	@RequestMapping(value="book/bookInsert", method = RequestMethod.GET)
	public String bookInsert() {
		return "book/bookInsert";
	}
	
	// book INSERT
	@RequestMapping(value="book/bookInsert", method = RequestMethod.POST)
	public String bookInsert(Book book) {
		bookdao.insertBook(book);
		return "redirect:book/bookList";
	}
	
	// book DELETE
	@RequestMapping(value="book/bookDelete", method = RequestMethod.GET)
	   public String bookDelete(@RequestParam(value="book_id", required=true) int book_id) {
	      bookdao.deleteBook(book_id);
	      return "redirect:book/bookList";
	}
}

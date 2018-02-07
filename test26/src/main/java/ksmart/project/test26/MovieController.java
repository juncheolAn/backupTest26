package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Movie;
import ksmart.project.test26.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	//��ȭ ����Ʈ 
	@RequestMapping(value="/movie/movieList")
	public String movieList(Model model) {
		List<Movie> list = movieService.movieList();
		model.addAttribute("list", list);
		return "movie/movieList";
	}
	//��ȭ �߰� ó�� ��û
	@RequestMapping(value="/movie/insertMovie", method = RequestMethod.POST)
	public String insertMovie(Movie movie) {
		System.out.println(movie);
		movieService.insertMovie(movie);		
		return "redirect:/movie/movieList";		
	}
	//��ȭ �߰� �� ��û
	@RequestMapping(value="/movie/insertMovie", method = RequestMethod.GET)
	public String insertMovie() {
		System.out.println("MovieController.java insertMovie() insertMovie.jsp ������ �̵� GET ���");
		return "movie/insertMovie";
	}
	//��ȭ ���� ó�� ��û
	@RequestMapping(value="/movie/updateMovie", method = RequestMethod.POST)
	public String updateMovie(Movie movie) {
		movieService.updateMovie(movie);
		return "redirect:/movie/movieList";		
	}
	//��ȭ ���� �� ��û
	@RequestMapping(value="/movie/updateMovie", method = RequestMethod.GET)
	public String updateMovie(Model model, @RequestParam(value="movieId", required=true) int movieId) {
		Movie movie = movieService.selectOneForUpdateMovie(movieId);
		model.addAttribute("movie",movie);
		return "movie/updateMovie";
	}
	//��ȭ ���� ��û
	@RequestMapping(value="movie/deleteMovie", method = RequestMethod.GET)
	   public String deleteMovie(@RequestParam(value="movieId", required=true) int movieId) {
	      movieService.deleteMovie(movieId);
	      return "redirect:/movie/movieList";
	}

}
package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

@Service
@Transactional
public class MovieService {
	@Autowired
	private MovieDao movieDao;
	//��ȭ ����Ʈ
	public List<Movie> movieList() {
		List<Movie> list = movieDao.selectMovieList();		
		return list;
	}
	//��ȭ �߰� ó�� ��û
	public int insertMovie(Movie movie) {		
		int row = movieDao.insertMovie(movie);		
		return row;		
	}
	//��ȭ ���� ó�� ��û	
	public Movie selectOneForUpdateMovie(int movieId) {
		Movie movie = movieDao.getMovie(movieId);
		return movie;		
	}
	//��ȭ ���� �� ��û	
	public int updateMovie(Movie movie) {
		int row = movieDao.updateMovie(movie);
		return row;
	}
	//��ȭ ���� ��û	
	   public int deleteMovie(int movieId) {
	      int row = movieDao.deleteMovie(movieId);
	      return row;
	}

}
	
	


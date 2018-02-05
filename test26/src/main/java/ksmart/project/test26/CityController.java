package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityDao;

@Controller
public class CityController {
	@Autowired
	private CityDao cityDao;
	//���� ����Ʈ 
	@RequestMapping(value="/city/cityList")
	public String cityList(Model model) {
		List<City> list = cityDao.selectCityList();
		model.addAttribute("list", list);
		return "city/cityList";
	}
	//���� �߰� ó�� ��û
	@RequestMapping(value="/city/insertCity", method = RequestMethod.POST)
	public String insertCity(City city) {
		System.out.println(city);
		cityDao.insertCity(city);		
		return "redirect:/city/cityList";		
	}
	//���� �߰� �� ��û
	@RequestMapping(value="/city/insertCity", method = RequestMethod.GET)
	public String insertCity() {
		System.out.println("CityController.java insertCity() insertCity.jsp ������ �̵� GET ���");
		return "city/insertCity";
	}
	//���� ���� ó�� ��û
	@RequestMapping(value="/city/updateCity", method = RequestMethod.POST)
	public String updateCity(City city) {
		cityDao.updateCity(city);
		return "redirect:/city/cityList";		
	}
	//���� ���� �� ��û
	@RequestMapping(value="/city/updateCity", method = RequestMethod.GET)
	public String updateCity(Model model, @RequestParam(value="cityId", required=true) int cityId) {
		City city = cityDao.getCity(cityId);
		model.addAttribute("city",city);
		return "city/updateCity";
	}
	//���� ���� ��û
	@RequestMapping(value="city/deleteCity", method = RequestMethod.GET)
	   public String bookDelete(@RequestParam(value="cityId", required=true) int cityId) {
	      cityDao.deleteCity(cityId);
	      return "redirect:/city/cityList";
	}

}
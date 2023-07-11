package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.xml.UserVOXML;

@RestController
@RequestMapping("/users")
public class RestfulUserController {	
	private final UserService userService;
	
	//Constructor Injection
	public RestfulUserController(UserService userService) {
		System.out.println(">>>> RestfulUserController 생성자 호출됨 ");
		this.userService = userService;
	}

//	@RequestMapping(value="/users",
//			                 method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping
	public List<UserVO> getUserList() {
		List<UserVO> userList = userService.getUserList();
		return userList;
	}
	
//	@RequestMapping(value="/users/{id}",
//			                    method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping("/{userId}")
	public UserVO getUser(@PathVariable("userId") String id) {
		UserVO user = userService.getUser(id);
		return user;
	}
		
//	@RequestMapping(value="/users",
//			                 method=RequestMethod.POST,
//			                 headers = {"Content-type=application/json"})
	@PostMapping
	public Boolean insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
//	@RequestMapping(value="/users",
//			                 method=RequestMethod.PUT,
//			                headers = {"Content-type=application/json"})
	@PutMapping("/{userId}")
	public Boolean updateUser(@PathVariable("userId") String id, @RequestBody UserVO userInfo) {
		UserVO user = userService.getUser(id);
		if (user != null) {
			userService.updateUser(userInfo);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/users/{id}",
			         method=RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable String id) {
		if (id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		} else {		
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/usersXml", method=RequestMethod.GET, produces = { "application/xml"})
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}	
}

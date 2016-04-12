package com.mySSM.controller;

import com.mySSM.common.util.JsonUtil;
import com.mySSM.model.Score;
import com.mySSM.model.User;
import com.mySSM.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	private static Logger logger=LoggerFactory.getLogger(UserLoginController.class);
	private static  final String SUCCESS="success";
	@Autowired
	private UserService userService;
	
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false) Integer id, 
			Map<String, Object> map,HttpServletRequest request){
		request.setAttribute("name", "request");
		//System.out.println("modelAttribute method");
		map.put("date", new Date());
		map.put("name", "zhongcy");
		//System.out.println(map.get("date"));
		//System.out.println("request中的name:"+request.getAttribute("name"));
	}
	
	@RequestMapping("/userLogin.do")
	public String userLogin(HttpServletResponse response,
			@RequestParam(value="userName") String userName,@RequestParam("password") String password){
		try {
			boolean result=userService.loginSuccess(userName, password);
			logger.error("result="+result);
			if(result) JsonUtil.success(response, true);
			else JsonUtil.success(response, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/toMain.do/{username}")
	@ResponseBody
	public String redirectMain(@PathVariable("username") String username,HttpServletResponse response){
		logger.error("username="+username);
		logger.error("登陆成功");
		return "redirect:/user/main.jsp";
	}
	
	@RequestMapping("/testRestful.do/{id}")
	public String testRestful(@PathVariable("id") Integer id){
		System.out.println(id);
		return "redirect:/user/main.jsp";
	}
	
	@RequestMapping("/testMap")
	public String testMap(Map<String,Object> map){
		map.put("key", "value");
		return "success";
	}
	
	@RequestMapping("/getUserInfo")
	public String getUserInfo (@RequestParam("username") String username,Map map){
		User user=userService.getUserById(username);
		System.out.println("获取的user："+user);
		map.put("user", user);
		Score score=userService.getScoreById(Integer.parseInt(username));
		map.put("score", score);
		map.put("userId", username);
		return SUCCESS;
	}
	
	@RequestMapping("/testTransaction")
	@Transactional
	public String updateUserInfo(){
		User user=new User();
		user.setUserId(2);
		user.setName("钟乘永222"+new Date());
		userService.updateByPrimaryKeySelective(user);
		System.out.println("进入下一个操作");
		throw new RuntimeException();
//		return null;
	}
	
	@RequestMapping(value="/testFileupload.do",headers = "content-type=multipart/*",method=RequestMethod.POST)
	public String testFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("desc") String desc,HttpSession  session) throws IOException{
		if(!file.isEmpty()){
//			 URL url = ClassLoader.getSystemClassLoader().getResource("./files"); 
//		       File fileUrl =new File(url.getPath()); 
//		       File parentFile =new File(fileUrl.getParent()); 
//		       System.out.println("webRoot:"+parentFile.getParent());
			ServletContext servletContext=session.getServletContext();
			servletContext.getContextPath();
			System.out.println(servletContext.getContextPath());
			System.out.println(servletContext.getRealPath("/files/abc.txt"));
			System.out.println("desc: " + desc);
			System.out.println("OriginalFilename: " + file.getOriginalFilename());
			System.out.println("InputStream: " + file.getInputStream());
			String fileNameString=file.getOriginalFilename();
			File outputFile=new File("C:/Users/zcy/git/mySSM/mySSM/src/main/webapp/files/"+fileNameString);
			OutputStream os=new FileOutputStream(outputFile);
			InputStream inputStream=file.getInputStream();
			int temp;
			while((temp=inputStream.read())!=-1){
				os.write(temp);
			}
			os.flush();
			os.close();
			inputStream.close();
		}
		return SUCCESS;
	}
	
	@RequestMapping("/testFileDownload")
	public ResponseEntity<byte[]> testFileDownload(HttpSession  session) throws IOException{
		byte[] body=null;
		ServletContext servletContext=session.getServletContext();
		InputStream in=servletContext.getResourceAsStream("/files/abc.txt");
		body=new byte[in.available()];
		in.read(body);
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Disposition","attachment;filename=abc.txt");
		HttpStatus status=HttpStatus.OK;
		ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(body, headers, status);
		return response;
	}

}

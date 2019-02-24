package com.safetia.nothwind.Controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.fabric.Response;
import com.safetia.nothwind.dto.ReplyDTO;
import com.safetia.nothwind.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	 @Inject
	 private ReplyService service;
	 
	 
	 @RequestMapping("/test")
	 public String test() {
		 return "test";
	 }
	
	 
	 @RequestMapping(value="", method= RequestMethod.POST)
	 public ResponseEntity<String> register(@RequestBody ReplyDTO dto){
		 ResponseEntity<String> entity = null;
		 try {
			 service.addReply(dto);
			 entity = new ResponseEntity<String>("SUCESS",HttpStatus.OK);
		 }catch (Exception e) {
			// TODO: handle exception
			 entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}

		 return entity ;
	 }
	 
	 @RequestMapping(value="/all/{bno}" , method=RequestMethod.GET)
	 public ResponseEntity<List<ReplyDTO>> list(@PathVariable("bno") int bno){
		 ResponseEntity<List<ReplyDTO>>  entity = null;
		 try {
			entity = new ResponseEntity<List<ReplyDTO>>(service.listReply(bno), HttpStatus.OK); 
		 }catch(Exception e) {
				entity = new ResponseEntity<List<ReplyDTO>>(HttpStatus.BAD_REQUEST);
		 }
		 return entity ;
	 }
	 
	 

}
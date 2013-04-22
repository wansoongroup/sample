package controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;

import models.Task;

import play.db.DB;
import play.mvc.Controller;
import play.mvc.Result;

public class EBeanSampleApp extends Controller {
	
	private static long id = 10;
	public static Result list() {

		// get default datasource
		//DataSource ds = DB.getDataSource();
		
		String id = request().getQueryString("id");
		System.out.println("id : " + id);
		
		if(!StringUtils.isEmpty(id)) {
			long no = Long.parseLong(id);
			
			Task task = Task.find.byId(no);
			System.out.println("task no(" + no + ")" + task);
		}
		
		PagingList<Task> pagingList = Task.find
				.where("name like '%test%'")
				.orderBy("id desc")
				.findPagingList(5);

		List<Task> list = pagingList.getPage(4).getList();
		int totalCount = pagingList.getTotalRowCount();
		
		System.out.println("totalCount : " + totalCount);
		
		for (Task task2 : list) {
			System.out.println("name : " + task2.name);
		}
				
		return ok("EBean Sample");
	}
	
	public static Result save() {

		id++;
		
		String username = request().getQueryString("username");
		
		System.out.println("userName : " + username);
		
		Task task = new Task();
		
		System.out.println("save id : " + id);
		task.id = id; 
		task.name = username;
		task.dueDate = new Date();
		task.done = false;
		
		task.save();
		
		return ok("save Task");
	}
	
	
}

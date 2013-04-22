package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.*;
import play.data.format.*;

import play.db.ebean.Model;

/**
 * Task
 * @author WanSoon Park
 */
@Entity
public class Task extends Model {
	
	private static final long serialVersionUID = -4221090378804325362L;

	@Id
	@Constraints.Min(10)
	public Long id;
	
	@Constraints.Required
	public String name;

	public boolean done;
	
	@Formats.DateTime(pattern="dd/MM/yyyy")
	public Date dueDate = new Date();
	
	public static Finder<Long, Task> find = new Finder<Long, Task>(Long.class, Task.class);
}

package com.glaucuslogistics.assignment.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.glaucuslogistics.assignment.model.ErrorMessage;
import com.glaucuslogistics.assignment.model.Student;
import com.glaucuslogistics.assignment.model.database.DatabaseServices;

/**
 * Handles all the requests made on 
 * http://localhost:8080/assignment/webapi/students/
 * @author Shravan
 *
 */

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

	/**
	 * Lists all Student Class object in JSON Format
	 * <br>URI : http://localhost:8080/assignment/webapi/students/
	 * <br>Method : GET
	 * @return List of Student instances in JSON format
	 */
	
	@GET
	public List<Student> getAllStudents() {
		return DatabaseServices.getAllStudents();
	}
	
	
	/**
	 * Gives total count of Student instance
	 * <br>URI : http://localhost:8080/assignment/webapi/students/count
	 * <br>Method : GET
	 * @return Total count of Student instance
	 */
	
	@GET
	@Path("/count")
	public int getCount() {
		return DatabaseServices.getAllStudents().size();
	}
	
	
	/**
	 * Retrieves the Student instance associated with the given 
	 * {entityid} in JSON format.<br>URI : http://localhost:8080/assignment/webapi/students/{entityid}
	 * 		 <br>along with JSON Object
	 * <br>Method : GET
	 * @param id Primary key of Student instance
	 * @return Student instance in JSON format, else throws Instance Not Found Exception
	 */
	
	@GET
	@Path("/{studentId}")
	public Student getStudent(@PathParam("studentId") long id) { 
		Student student = DatabaseServices.getInfo(id); 
		if(student == null) {
			/**
			 * Throws exception in JSON format 
			 * if no Student instance related
			 * to {studentId} is found
			 */
			ErrorMessage errorMessage = new ErrorMessage("Instance Not Found",404,"Shravanchaudhary.github.io");
			Response response = Response.status(Status.NOT_FOUND)
					.entity(errorMessage)
					.build();
			throw new WebApplicationException(response);
		}
		return student;
	}
	
	
	/**
	 * Creates a new Student instance and returns it in JSON format
	 * <br>URI : http://localhost:8080/assignment/webapi/students/
	 * 		 <br>along with JSON Object
	 * <br>Method : POST
	 * @param student Student object in JSON format
	 * @return Student object in JSON format, else Throws Cannot Add Duplicate Values Exception
	 */
	
	@POST
	public Student insertStudent(Student student) {
		Student responseStudent = null;
		try {
			responseStudent = DatabaseServices.insertInfo(student);
		}catch(Exception c) {
			/**
			 * Throws exception in JSON format 
			 * if no Duplicate instance is inserted
			 */
			ErrorMessage errorMessage = new ErrorMessage("Cannot Add Duplicate Values",406,"Shravanchaudhary.github.io");
			Response response = Response.status(Status.NOT_ACCEPTABLE)
					.entity(errorMessage)
					.build();
			throw new WebApplicationException(response);
		}
		return responseStudent;
	}
	
	
	/**
	 * Updates an existing Student instance associated with the given id 
	 * with the provided Student instance in JSON format,
	 * and returns the updated Student instance in JSON format
	 * <br>URI : http://localhost:8080/assignment/webapi/students/{entityid}
	 * 		 <br>along with JSON Object
	 * <br>Method : PUT
	 * @param id  {entityid} as path parameter
	 * @param student Given Student instance in JSON format
	 * @return Updated Student instance in JSON format, else throws Instance Not found Exception
	 */
	
	@PUT
	@Path("/{studentId}")
	public Student updateStudent(@PathParam("studentId") long id, Student student) {
		student.setId(id);
		Student responseStudent = null;
		try {
			responseStudent = DatabaseServices.updateInfo(student);
		}catch (Exception e) {
			/**
			 * Throws exception in JSON format 
			 * if no Student instance related
			 * to {studentId} is found
			 */
			ErrorMessage errorMessage = new ErrorMessage("Instance Not found",404,"Shravanchaudhary.github.io");
			Response response = Response.status(Status.NOT_FOUND)
					.entity(errorMessage)
					.build();
			throw new WebApplicationException(response);
		}
		return responseStudent;
	} 
	 
	
	/**
	 * Deletes the Student instance associated with the given id 
	 * and returns deleted Student instance
	 * <br>URI : http://localhost:8080/assignment/webapi/students/{entityid}
	 * <br>Method : DELETE
	 * @param id {entityid} as path parameter
	 * @return Deleted instance in JSON format, else throws Instance Not found Exception
	 */
	
	@DELETE
	@Path("/{studentId}")
	public Student deleteStudent(@PathParam("studentId") long id) { 
		Student responseStudent = null;
		try {
			responseStudent = DatabaseServices.deleteInfo(id);
		}catch (Exception e) {
			/**
			 * Throws exception in JSON format 
			 * if no Student instance related
			 * to {studentId} is found
			 */
			ErrorMessage errorMessage = new ErrorMessage("Instance Not found",404,"Shravanchaudhary.github.io");
			Response response = Response.status(Status.NOT_FOUND)
					.entity(errorMessage)
					.build();
			throw new WebApplicationException(response);
		}
		return responseStudent;
	}
}


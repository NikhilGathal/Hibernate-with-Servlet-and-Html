package studentm2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentm2withhtml.dao.StudentDao;
import studentm2withhtml.dto.Student;

public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		StudentDao studentdao = new StudentDao();
		List<Student> students = studentdao.getAllStudents();
		boolean value = false;
		String studentpassword = null;
		
		for(Student student:students)
		{
			if(email.equals(student.getEmail()))
			{
				value = true;
				studentpassword = student.getPassword();
				break;
			}
		}
		
		if(value == true)
		{
			if(password.equals(studentpassword))
			{
//				PrintWriter printwriter = (resp.getWriter());
//				printwriter.print("Login Successfully");
//				
//				RequestDispatcher dispatcher = req.getRequestDispatcher("select.html");
//				dispatcher.forward(req, resp);
				
				resp.sendRedirect("https://www.naukri.com/mnjuser/profile?id=&altresid");
			}
			else 
			{
//				PrintWriter printwriter = (resp.getWriter());
//				printwriter.print("Sorry Invalid Password");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
			}
		}
		else 
		{
//			PrintWriter printwriter = (resp.getWriter());
//			printwriter.print("Sorry Invalid Email");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
	}
}

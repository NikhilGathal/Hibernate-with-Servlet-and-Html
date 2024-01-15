package studentm2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.Dispatcher;
import studentm2withhtml.dao.StudentDao;
import studentm2withhtml.dto.Student;

public class SignupServelt extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Reached Signup");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		Student student = new Student();
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPhone(phone);
		student.setPassword(password);
		
		StudentDao studentdao = new StudentDao();
		studentdao.saveStudent(student);
		
		PrintWriter printwriter = (res.getWriter());
		printwriter.print("SIGNEDUP SUCCESSFULLY");
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("login.html");
		dispatcher.forward(req, res);
		
		
	}

}

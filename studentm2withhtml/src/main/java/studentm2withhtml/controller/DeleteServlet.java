package studentm2withhtml.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentm2withhtml.dao.StudentDao;
import studentm2withhtml.dto.Student;

public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		StudentDao studentdao = new StudentDao();
		Student student = studentdao.deleteStudentById(id);
		if (student != null) {
			// id present means deleted data
			PrintWriter printwriter = (resp.getWriter());
			printwriter.print("Data deleted successfully");
		} else {
			PrintWriter printwriter = (resp.getWriter());
			printwriter.print("Sorry id not present");
		}
	}

}

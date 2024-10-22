package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.nhacungcap;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

import dao.nhaCungCapDao;
import daoimpl.nhaCungcapDaoImpl;

/**
 * Servlet implementation class nhaCungCapController
 */
public class nhaCungCapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/quanlydienthoaixxx")
	private DataSource dataSource;
	private nhaCungCapDao nhacungcapDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nhaCungCapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		nhacungcapDao= new nhaCungcapDaoImpl(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<nhacungcap>list=nhacungcapDao.listNCC();
		request.setAttribute("listncc", list);
		
		request.getRequestDispatcher("/view/nhacungcap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

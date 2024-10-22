package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.dienthoai;
import models.nhacungcap;

import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.text.html.parser.DTD;

import dao.dienthoaiDao;
import dao.nhaCungCapDao;
import daoimpl.dienthoaiDaoImpl;
import daoimpl.nhaCungcapDaoImpl;

/**
 * Servlet implementation class dienthoaiController
 */
public class dienthoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/quanlydienthoaixxx")
	private DataSource dataSource;
	private dienthoaiDao dtDao;
	private nhaCungCapDao nccDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dienthoaiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		dtDao = new dienthoaiDaoImpl(dataSource);
		nccDao = new nhaCungcapDaoImpl(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "add":
				List<nhacungcap> list = nccDao.listNCC();
				request.setAttribute("listncc", list);
				request.getRequestDispatcher("/view/adddienthoai.jsp").forward(request, response);
				break;

			case "update":
				
				int id=Integer.parseInt(request.getParameter("id"));
				
				dienthoai dtU= dtDao.dt(id);
				request.setAttribute("dtU", dtU);
				
				List<nhacungcap> listz = nccDao.listNCC();
				request.setAttribute("listncc", listz);
				
				request.getRequestDispatcher("/view/Updatedienthoai.jsp").forward(request, response);
				break;
				
			case "delete":
				int idD=Integer.parseInt(request.getParameter("id"));
				boolean deleteResult=dtDao.deleteDienThoai(idD);
				if(deleteResult) {
					System.out.println("xoa thanh cong");
					List<dienthoai> listDt = dtDao.getAll();
					request.setAttribute("listDt", listDt);
					
					request.getRequestDispatcher("/view/dienthoai.jsp").forward(request, response);
				}
				else {
					System.out.println("xoa k thanh cong");
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		} else {

			List<dienthoai> listDt = dtDao.getAll();
			request.setAttribute("listDt", listDt);

			request.getRequestDispatcher("/view/dienthoai.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action=request.getParameter("action");
		
		
		if(action!=null) {
			switch (action) {
			case "update": 
				String ten = request.getParameter("ten");
				int nam = Integer.parseInt(request.getParameter("nam"));
				String cauhinh = request.getParameter("cauhinh");
				int mancc = Integer.parseInt(request.getParameter("mancc"));
				
				int id =Integer.parseInt(request.getParameter("id"));
				dienthoai dt = new dienthoai(id,ten, nam, cauhinh, nccDao.getidNCC(mancc));
				
				boolean resultUpdate = dtDao.updateDienThoai(dt);
				if (resultUpdate) {
					System.out.println("capnhat thanh cong");
					List<dienthoai> listDt = dtDao.getAll();
					request.setAttribute("listDt", listDt);
					
					request.getRequestDispatcher("/view/dienthoai.jsp").forward(request, response);
				} else {
					System.out.println("capnhat k thanh cong");
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		}
		else {
			
			String ten = request.getParameter("ten");
			int nam = Integer.parseInt(request.getParameter("nam"));
			String cauhinh = request.getParameter("cauhinh");
			int mancc = Integer.parseInt(request.getParameter("mancc"));
			
			dienthoai dt = new dienthoai(ten, nam, cauhinh, nccDao.getidNCC(mancc));
			
			boolean resultAdd = dtDao.addDienThoai(dt);
			if (resultAdd) {
				System.out.println("Them thanh cong");
				List<dienthoai> listDt = dtDao.getAll();
				request.setAttribute("listDt", listDt);
				
				request.getRequestDispatcher("/view/dienthoai.jsp").forward(request, response);
			} else {
				System.out.println("them k thanh cong");
			}
		}
		

	}

}

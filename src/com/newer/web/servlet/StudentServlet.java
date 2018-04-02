package com.newer.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import com.newer.bean.Student;
import com.newer.dao.StudentDao;
import com.newer.util.StringUtils;

@WebServlet("/student")
public class StudentServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Map<String, Object> maps=new HashMap<>();
		
		req.setCharacterEncoding("utf-8");
		String sname=req.getParameter("sname");		
		if(!StringUtils.isEmpty(sname)) {
			maps.put("sname", "%"+sname+"%");
		}
		
		String cid=req.getParameter("cid");
		if(!StringUtils.isEmpty(cid)) {
			maps.put("cid", cid);
		}
		
		String sdate=req.getParameter("sdate");
		if(!StringUtils.isEmpty(sdate)) {
			Date startDate=Date.valueOf(sdate);
			maps.put("sdate", startDate);
		}
		
		String edate=req.getParameter("edate");
		if(!StringUtils.isEmpty(edate)) {
			Date endDate=Date.valueOf(edate);
			maps.put("edate", endDate);
		}
		
		StudentDao dao=new StudentDao();
		
		List<Student> list=dao.findByParams(maps);
		
		req.setAttribute("list", list);
		req.setAttribute("maps", maps);
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
		
		
		
		
		
	}

}

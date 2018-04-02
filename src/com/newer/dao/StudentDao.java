package com.newer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.newer.bean.ClassInfo;
import com.newer.bean.Student;
import com.newer.util.ConnectionUtil;

public class StudentDao {
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	/*
	 * 条件查询所有学生信息
	 */
	public List<Student> findByParams(Map<String,Object> maps){
		
		
		List<Student> list=new ArrayList<>();
		String sql="select sid,sname,ssex,sbirthday,s.cid,"
				+ "cname from t_student s left join t_class "
				+ "c on s.cid=c.cid where 1=1 ";
		//用于放置参数的集合
		List paramList=new ArrayList<>();
		
		if(maps.get("sname")!=null) {
			sql+=" and sname like ?";
			paramList.add(maps.get("sname"));
		}
		
		if(maps.get("cid")!=null) {
			sql+=" and c.cid=?";
			paramList.add(maps.get("cid"));
			System.out.println(maps.get("cid"));
		}
		
		if(maps.get("sdate")!=null) {
			sql+=" and sbirthday>?";
			paramList.add(maps.get("sdate"));
		}
		
		if(maps.get("edate")!=null) {
			sql+=" and sbirthday<?";
			paramList.add(maps.get("edate"));
		}
		
		System.out.println(sql);
		try {
			conn=ConnectionUtil.getConnection();
			
			pst=conn.prepareStatement(sql);
			
			for(int i=0;i<paramList.size();i++) {
				System.out.println(paramList.get(i));
				pst.setObject(i+1, paramList.get(i));
			}
			
			rs=pst.executeQuery();
			
			while(rs.next()) {
				Student student=new Student();
				student.setSid(rs.getInt(1));
				student.setSname(rs.getString(2));
				student.setSsex(rs.getString(3));
				student.setSbirthday(rs.getDate(4));
				
				ClassInfo classInfo=new ClassInfo();
				classInfo.setCid(rs.getString(5));
				classInfo.setCname(rs.getString(6));
				
				student.setSclass(classInfo);
				list.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

}

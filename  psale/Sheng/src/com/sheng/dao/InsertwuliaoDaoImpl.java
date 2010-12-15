package com.sheng.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.sheng.po.Addwuliao;
import com.sheng.util.Jdbcutil;
/*
 * ÃÌº”ŒÔ¡œ
 * **/
public class InsertwuliaoDaoImpl implements InsertwuliaoDAO {
	public boolean addwuliao(Addwuliao aw) {
		// TODO Auto-generated method stub
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		boolean flag=false;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("insert addwuliao(inname,innum,inprice,inuserid,indate)values(?,?,?,?,?)");
			pm.setString(1, aw.getInname());
			pm.setString(2, aw.getInnum());
			pm.setString(3, aw.getInprice());
			pm.setString(4, aw.getInuserid());
			pm.setString(5, aw.getIndate());
			pm.execute();
			flag=true;
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			flag=false;
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return flag;
	}
}

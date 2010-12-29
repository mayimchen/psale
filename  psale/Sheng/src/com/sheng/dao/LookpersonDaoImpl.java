package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sheng.po.Outwuliao;
import com.sheng.util.Jdbcutil;

public class LookpersonDaoImpl implements LookpersonDAO {

	public List<Outwuliao> getpersonout(String userid,Timestamp startdate,Timestamp enddate) {
		// TODO Auto-generated method stub
		
		List<Outwuliao> ls=new ArrayList<Outwuliao>();
		Jdbcutil jdbc=new Jdbcutil();
		Connection conn=null;
		PreparedStatement pm=null;
		ResultSet rs=null;
		try{
			conn=jdbc.getConnection();
			pm=conn.prepareStatement("select * from delwuliao where outuserid=? and outdate between ? and ?");
			pm.setString(1, userid);
			pm.setTimestamp(2, startdate);
			pm.setTimestamp(3, enddate);
			rs=pm.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Outwuliao ow=new Outwuliao();
					ow.setMaori(rs.getDouble("maori"));
					ow.setPurchaser(rs.getString("purchaser"));
					ow.setOutname(rs.getString("outname"));
					ow.setOutnum(rs.getInt("outnum"));
					ow.setOutprice(rs.getDouble("outprice"));
					ow.setOutuserid(rs.getString("outuserid"));
					ow.setOutdate(rs.getString("outdate").substring(0, 19));
					ow.setPid(rs.getString("pid"));
					ls.add(ow);
				}
			}
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}catch(Exception e){
			e.printStackTrace();
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}finally{
			jdbc.close(rs);
			jdbc.close(pm);
			jdbc.close(conn);
		}
		return ls;
	}

}

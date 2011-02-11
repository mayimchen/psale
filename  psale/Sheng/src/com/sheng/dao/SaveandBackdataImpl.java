package com.sheng.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sheng.datasource.Pool;

public class SaveandBackdataImpl implements SaveandBackdata {

	public boolean save() {
		// TODO Auto-generated method stub
		boolean forward=false;
		Connection conn=null;
		PreparedStatement pm1=null;
		PreparedStatement pm2=null;
		try{
			conn=Pool.getConnection();
			pm1=conn.prepareStatement("select * into outfile 'c:\\\\saveadd.sql' from addwuliao");
			pm2=conn.prepareStatement("select * into outfile 'c:\\\\savedel.sql' from delwuliao");
			forward=pm1.execute();
			forward=pm2.execute();
			Pool.close(pm2);
			Pool.close(pm1);
			Pool.close(conn);
		}catch(Exception e){
			System.out.println("数据库已做过备份,如果需要继续备份，可以考虑移走以前备份，然后继续备份");
			Pool.close(pm2);
			Pool.close(pm1);
			Pool.close(conn);
		}finally{
			Pool.close(pm2);
			Pool.close(pm1);
			Pool.close(conn);
		}
		return forward;
	}

}

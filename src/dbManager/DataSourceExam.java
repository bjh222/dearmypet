package dbManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import org.apache.commons.dbcp2.BasicDataSource;

import dbManager.DatabaseManager;

public class DataSourceExam {
	/*
	DAO�� ���� ��� �޼ҵ尡 Connection�� �ʿ��ϱ� ������ DatabaseManager��ü�� �����ؾ� �ϹǷ� instance������ �����ؼ� ����Ѵ�.
	DatabaseManager dbMgr = DatabaseManager.getInstance();
	-> �Ź� �޼ҵ峻���� ���������� ���� ����� �ʿ䰡 ����.
	 */
	public void usingBasicDataSource2() throws SQLException{
		DatabaseManager dbMgr = DatabaseManager.getInstance();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = dbMgr.getConnection();
			pstmt = conn.prepareStatement("Select * From zipcode");
			rset = pstmt.executeQuery();
			while(rset.next()){
				System.out.println(rset.getInt(1) + ", " + rset.getString(2) + ", " + rset.getString(3));
			}
		} finally {
			dbMgr.close(conn, pstmt, rset);
		}
	}

	public static void main(String[] args) throws SQLException {
		DataSourceExam exam = new DataSourceExam();
		exam.usingBasicDataSource2();
	}
}
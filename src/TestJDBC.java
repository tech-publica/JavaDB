import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.dgs.sportClub.AbstractReservationDAO;
import com.dgs.sportClub.data.DataException;
import com.dgs.sportClub.data.jdbc.ReservationDAOJdbc;
import com.dgs.sportClub.domain.Reservation;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUser="sa";
		String jdbcPass= "sqlserver";

		String jdbcURL 
		= "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=SportClub_LAM";

		System.out.println("Connection to Database...");
		try(Connection con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass))
		{
			AbstractReservationDAO dao = new ReservationDAOJdbc(con);
			Iterable<Reservation> res = dao.reservationByFieldAndTime(5, new Date(2019,7,1,0,0,0), new Date(2019,7,3,0,0,0));
			for(Reservation r: res) {
				System.out.println(r.getIdPrenotazione()+ "  " + r.getIdCampo());
			}
			System.out.println("fatto");
		} catch (DataException  | SQLException e) {
			e.printStackTrace();
		}

		//		Connection con = null; 
		//		try {
		//			con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
		//
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		} finally {
		//			if(con!=null)
		//				try{
		//					con.close();
		//				} catch (SQLException e) {
		//					e.printStackTrace();
		//				}	
	}		

}

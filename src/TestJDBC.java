import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
		= "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=Olympia";

		System.out.println("Connection to Database...");
		try(Connection con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass))
		{
			AbstractReservationDAO dao = new ReservationDAOJdbc(con);
			LocalDateTime start = LocalDateTime.of(2019, 6, 1, 9,0);
			LocalDateTime end =   LocalDateTime.of(2019, 6, 1, 22,0);
			System.out.println(start);
			System.out.println(end);
			Iterable<Reservation> res = dao.reservationByFieldAndTime(5, start, end);
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

package org.eclipse.rcpl.ip2location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.rcpl.libs.db.H2DB;

/**
 * You need the file ip2location_db5 from ip2location.com. Place it in this
 * package.
 * 
 * It should be ignored by Git as it is a large file!
 * 
 * 
 * @author ramin
 *
 */
public class Ip2LocationImport {

	private static List<IPEntry> ipEntries;

	private H2DB h2;

	/**
	 * @param h2
	 */
	public Ip2LocationImport(H2DB h2) {
		super();
		this.h2 = h2;
	}

	public static void main(String[] args) {

		Ip2LocationImport test = new Ip2LocationImport(new H2DB("wrs"));

		try {
			test.dropTable();
			test.createTable();
			test.importCVS();
			test.h2.getConnection().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void importCVS() {
		PreparedStatement insertPreparedStatement = null;

		String insertQuery = "INSERT INTO ip2location_db5 (IP_FROM, IP_TO, LATITUDE, LONGITUDE, COUNTRY_CODE, COUNTRY_NAME, REGION_NAME, CITY_NAME, POST_CODE)"

				+ "VALUES (?,?,?,?,?,?,?,?,?);";

		try {
			insertPreparedStatement = h2.getConnection().prepareStatement(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int i = 0;
		for (IPEntry entry : getIpEntries()) {
			try {

				insertPreparedStatement.setLong(1, entry.getIp_from());
				insertPreparedStatement.setLong(2, entry.getIp_to());
				insertPreparedStatement.setDouble(3, entry.getLatitude());
				insertPreparedStatement.setDouble(4, entry.getLongitude());
				insertPreparedStatement.setString(5, entry.getCountry_code());
				insertPreparedStatement.setString(6, entry.getCountry_name());
				insertPreparedStatement.setString(7, entry.getRegion_name());
				insertPreparedStatement.setString(8, entry.getCity_name());
				insertPreparedStatement.setString(9, entry.getPostCode());

				entry.getCity_name();
				entry.getPostCode();
				entry.getRegion_name();

				insertPreparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			i++;
			if (i % 10000 == 0) {
				System.out.println("db: " + i);
			}
		}

		try {
			insertPreparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dropTable() throws SQLException {
		Statement stmt = h2.getConnection().createStatement();
		String dropQ = "DROP TABLE IF EXISTS ip2location_db5";
		stmt.executeUpdate(dropQ);
		stmt.close();
	}

	private void createTable() throws SQLException {
		Statement stmt = h2.getConnection().createStatement();

		String sql = "CREATE TABLE IF NOT EXISTS ip2location_db5 ("

				+ "IP_FROM BIGINT UNSIGNED,"

				+ "IP_TO BIGINT UNSIGNED,"

				+ "LATITUDE     DOUBLE,"

				+ "LONGITUDE    DOUBLE,"

				+ "COUNTRY_CODE CHAR(2),"

				+ "COUNTRY_NAME VARCHAR(64),"

				+ "REGION_NAME  VARCHAR(128),"

				+ "CITY_NAME    VARCHAR(128),"

				+ "POST_CODE    VARCHAR(128))"

		; // ,"

//					+ "INDEX idx_ip_from (ip_from),"
//
//					+ "INDEX idx_ip_to (ip_to),"
//
//					+ "INDEX idx_ip_from_to (ip_from, ip_to))";

		stmt.executeUpdate(sql);
		stmt.close();
	}

	private List<IPEntry> getIpEntries() {
		if (ipEntries == null) {
			ipEntries = new ArrayList<IPEntry>();
//			if (!load()) {
			readDb();
//			}
		}
		return ipEntries;
	}

	private void readDb() {

		InputStream is = getClass().getResourceAsStream("IP2LOCATION-LITE-DB9.CSV");

		Reader r = new InputStreamReader(is);
		try (BufferedReader br = new BufferedReader(r)) {
			String line;
			int i = 0;

			while ((line = br.readLine()) != null) {
				i++;
				createEntry(line);
				if (i % 100000 == 0) {
					System.out.println(i);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		ipEntries.sort(new Comparator<IPEntry>() {

			@Override
			public int compare(IPEntry o1, IPEntry o2) {
				return (int) (o1.getIp_from() - o2.getIp_from());
			}
		});

	}

	private void createEntry(String line) {
		try {
			IPEntry entry = new IPEntry();

			StringTokenizer st = new StringTokenizer(line, "\"");

			String s = st.nextToken().replaceAll("\"", "");
			long ipFrom = Long.valueOf(s).longValue();

			s = getNextToken(st);
			long ipTo = Long.valueOf(s).longValue();

			s = getNextToken(st);
			String countryCode = s;

			s = getNextToken(st);
			String countryName = s;

			s = getNextToken(st);
			String region = s;

			s = getNextToken(st);
			String city = s;

			s = getNextToken(st);
			double latitude = Double.valueOf(s).doubleValue();

			s = getNextToken(st);
			double longitude = Double.valueOf(s).doubleValue();

			// String postCode = st.nextToken();

			entry.setCity_name(city);
			entry.setCountry_code(countryCode);
			entry.setIp_from(ipFrom);
			entry.setIp_to(ipTo);
			entry.setLatitude(latitude);
			entry.setLongitude(longitude);
			entry.setRegion_name(region);
			entry.setCountry_name(countryName);
			if (entry.getLatitude() != 0 || entry.getLongitude() != 0) {
				ipEntries.add(entry);
			}

		} catch (Exception ex) {
			System.out.println("!");
		}
	}

	private String getNextToken(StringTokenizer tok) {
		String s = tok.nextToken().replaceAll("\"", "");
		if (",".equals(s)) {
			s = tok.nextToken().replaceAll("\"", "");
		}
		return s;
	}
}

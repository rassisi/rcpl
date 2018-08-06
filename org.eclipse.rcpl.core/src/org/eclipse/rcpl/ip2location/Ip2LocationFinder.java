package org.eclipse.rcpl.ip2location;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.rcpl.Rcpl;
import org.eclipse.rcpl.libs.db.H2DB;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author ramin
 *
 */
public class Ip2LocationFinder {

	private H2DB h2;

	public Ip2LocationFinder() {
		super();
		this.h2 = Rcpl.UIC.getH2DB();
	}

	public Ip2LocationFinder(H2DB h2) {
		super();
		this.h2 = h2;
	}

	public static void main(String[] args) {

		Ip2LocationFinder test = new Ip2LocationFinder(new H2DB("wrs"));

		try {

			test.findMyIPAddress();

//			test.findLocation("85.13.145.39");

			List<IPEntry> entries = test.findLocation(test.findMyIPAddress());
			for (IPEntry entry : entries) {
				System.out.println(longToIp(entry.getIp_from()));
				System.out.println(longToIp(entry.getIp_to()));
				System.out.println(entry.getLatitude());
				System.out.println(entry.getLongitude());
				System.out.println(entry.getCountry_code());
				System.out.println(entry.getCountry_name());
				System.out.println(entry.getRegion_name());
				System.out.println(entry.getCity_name());
				System.out.println(entry.getPostCode());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<IPEntry> findMyLocation() throws SQLException {
		return findLocation(findMyIPAddress());
	}

	public List<IPEntry> findLocation(String ipAddress) throws SQLException {

		List<IPEntry> result = new ArrayList<IPEntry>();

		long longIp = ipToLong(ipAddress);
		String sql = "select * from ip2location_db5 where (ip_from <= ?) and (?<=ip_to)";

		PreparedStatement stm = h2.getConnection().prepareStatement(sql);

		stm.setLong(1, longIp);
		stm.setLong(2, longIp);

		ResultSet selectRS = stm.executeQuery();

		while (selectRS.next()) {

			IPEntry entry = new IPEntry();
			entry.setIp_from(selectRS.getLong(1));
			entry.setIp_to(selectRS.getLong(2));
			entry.setLatitude(selectRS.getDouble(3));
			entry.setLongitude(selectRS.getDouble(4));
			entry.setCountry_code(selectRS.getString(5));
			entry.setCountry_name(selectRS.getString(6));
			entry.setRegion_name(selectRS.getString(7));
			entry.setCity_name(selectRS.getString(8));
			entry.setPostCode(selectRS.getString(9));
			result.add(entry);
		}

		return result;

	}

	/**
	 * covert the ip address from dot formatted to decimal
	 *
	 * @param ipAddress ip address dot format;
	 * @return ip address in decimal format.
	 */
	public static long ipToLong(String ipAddress) {
		long result = 0;
		String[] ipAddressInArray = ipAddress.split("\\.");
		for (int i = 3; i >= 0; i--) {
			long ip = Long.parseLong(ipAddressInArray[3 - i]);
			// left shifting 24,16,8,0 and bitwise OR
			// 1. 192 << 24
			// 1. 168 << 16
			// 1. 1 << 8
			// 1. 2 << 0
			result |= ip << (i * 8);

		}
		return result;
	}

	private static final Pattern IPV4_PATTERN = Pattern.compile(
			"^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
	private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
	private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern
			.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

	public static boolean isIPv4Address(final String input) {
		return IPV4_PATTERN.matcher(input).matches();
	}

	public static boolean isIPv6StdAddress(final String input) {
		return IPV6_STD_PATTERN.matcher(input).matches();
	}

	public static boolean isIPv6HexCompressedAddress(final String input) {
		return IPV6_HEX_COMPRESSED_PATTERN.matcher(input).matches();
	}

	public static boolean isIPv6Address(final String input) {
		return isIPv6StdAddress(input) || isIPv6HexCompressedAddress(input);
	}

	public static boolean isIPAddress(final String hostname) {
		return hostname != null && (isIPv4Address(hostname) || isIPv6Address(hostname));
	}

	/**
	 * covert the ip address from decimal to dot formatted
	 *
	 * @param ip ip address decimal format;
	 * @return ip address in dot format.
	 */
	public static String longToIp(long ip) {
		StringBuilder sb = new StringBuilder(15);
		for (int i = 0; i < 4; i++) {
			// 1. 2
			// 2. 1
			// 3. 168
			// 4. 192
			sb.insert(0, Long.toString(ip & 0xff));

			if (i < 3) {
				sb.insert(0, '.');
			}

			// 1. 192.168.1.2
			// 2. 192.168.1
			// 3. 192.168
			// 4. 192
			ip = ip >> 8;

		}

		return sb.toString();
	}

	/**
	 * @return
	 */
	public String findMyIPAddress() {
		Document doc;
		try {
			doc = Jsoup.connect("https://whatismyipaddress.com/").timeout(10000).get();
			Elements el = doc.select("div#section_left");
			Element e = el.select("a").get(0);
			return (e.text());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}

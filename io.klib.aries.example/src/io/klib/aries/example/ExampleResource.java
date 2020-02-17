package io.klib.aries.example;

//Imports for SQL connection

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import org.osgi.service.jaxrs.whiteboard.propertytypes.JaxrsResource;

import com.mysql.jdbc.Driver;

@Component(property = { JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=.default)",
		JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true" }, service = ExampleResource.class)
@JaxrsResource
public class ExampleResource {

	private static final String DBUSER = "DBUSER";
	private static final String DBPASSWORD = "DBPASSWORD";
	private static final String DBDATABASE = "DBDATABASE";
	private static final String DBURL = "DBURL";

	@GET
	@Path("/sql")
	public String getSQL() {

		final String dbUser = (System.getenv(DBUSER) == null) ? System.getProperty(DBUSER, "root")
				: System.getenv(DBUSER);
		final String dbPassword = (System.getenv(DBPASSWORD) == null) ? System.getProperty(DBPASSWORD, "lmao")
				: System.getenv(DBPASSWORD);
		final String dbDatabase = (System.getenv(DBDATABASE) == null) ? System.getProperty(DBDATABASE, "test")
				: System.getenv(DBDATABASE);
		final String dbUrl = (System.getenv(DBURL) == null) ? System.getProperty(DBURL, "localhost:3306")
				: System.getenv(DBURL);

		final String composedUrl = "jdbc:mysql://" + dbUser + ":" + dbPassword + "@" + dbUrl + "/" + dbDatabase;

		Statement stmt = null;
		Connection con = null;

		try {
			Driver driver = new Driver();
			Properties properties = new Properties();
			con = driver.connect(composedUrl, properties);
			stmt = con.createStatement();

			StringBuilder str = new StringBuilder();

			ResultSet rs = stmt.executeQuery("SELECT * FROM klib");
			while (rs.next()) {
				int id = rs.getInt("id");
				String role = rs.getString("role");
				String name = rs.getString("name");
				// System.out.println("\tid= " + id + "\trole = " + role + "\tname = " + name);
				str.append("id= " + id + "role = " + role + "name = " + name + "</br>");
			}
			String result = str.toString();
			con.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// return "SQLException";
			return e.toString();
		}
	}

}
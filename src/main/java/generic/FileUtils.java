package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.jdbc.Driver;


/**
 * This class contains all the methodss to read the data
 * @author RUTHUPARNA
 *
 */
public class FileUtils {

	public static Connection con = null;
	
	/**
	 * this method is used to read the data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyData(String key) throws IOException
	{
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream(AutoConstant.propertyFilePath);
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * this method is used get the data from the exelfile
	 * @param name
	 * @param r
	 * @param c
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String excelData(String name, int r, int c) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(AutoConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet(name);
		Row row = sh.getRow(r);
		Cell cell = row.getCell(c);
		String value = cell.getStringCellValue();
		
		return value;		
	}
	
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(AutoConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		short cell = sh.getRow(1).getLastCellNum();
		
		
		Object obj[] [] = new Object[row] [cell];
		
		for(int i=0; i<row;i++)
		{
			for(int j=0; j<cell;j++)
			{
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);				
			}
		}
		return obj;
	}
	
	/**
	 * This method is used to connect with database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getCon() throws SQLException
	{
		Driver driverref = new Driver();
		DriverManager.registerDriver(driverref);
		con = DriverManager.getConnection(AutoConstant.dbURL, AutoConstant.dbuname, AutoConstant.dbpasswd);
		return con;
	}
	
	/**
	 * this method is usd to read the data from database
	 * @param query
	 * @param expdata
	 * @param x
	 * @return
	 * @throws SQLException
	 */
	public String getDatafrmDb(String query, String expdata, int x) throws SQLException
	{
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		
		
		while (res.next()) 
		{
			String actual = res.getString(x);
			
			if(actual.equals(expdata))
			{
				break;
			}
			else
			{
				Reporter.log("Invalid data");
			}
		}
		return expdata;
	}
	
	/**
	 * this method is used to close the database connection	
	 * @throws SQLException
	 */
	public void closeCon() throws SQLException
	{
		con.close();
	}
}

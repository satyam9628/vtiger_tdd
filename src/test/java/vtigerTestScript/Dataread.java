package vtigerTestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataread {

	public static void main(String[] args) throws IOException {
		Dataread read=new Dataread();
		read.information();
	}
	public  void information() throws IOException {




		InputStream is=new FileInputStream(System.getProperty("user.dir")+"\\"+"src\\main\\resources\\dataprovider\\Book1.xlsx");
		XSSFWorkbook bk= new XSSFWorkbook(is);
		XSSFSheet shet=bk.getSheet("Sheet1");
		for(int i=0; i<=shet.getLastRowNum(); i++) {
			XSSFRow rowObj=shet.getRow(i) ;
			for(int j=0; j<=rowObj.getLastCellNum()-1; j++) {
				XSSFCell cellObj=rowObj.getCell(j);
				String getfirstrowfirstcelldata=null;
				if(cellObj.getCellType()==CellType.STRING) {
					getfirstrowfirstcelldata	=cellObj.getStringCellValue();	
				}else {
					Double data =cellObj.getNumericCellValue();
					int dataValue	= data.intValue();
					getfirstrowfirstcelldata=  Integer.toString(dataValue);
				}
				System.out.print( getfirstrowfirstcelldata + " ");
			}
			System.out.println("");
		}
	}

}

package DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SauceLabs.testData.Xls_Reader;

public class ExcelDataSupplier {

    public static ArrayList<Object[]> loginData() {
        ArrayList<Object[]> data = new ArrayList<Object[]>();

        String sheetname = "Sheet2";
        Xls_Reader reader = new Xls_Reader("./src/test/java/com/SauceLabs/testData/Book2.xlsx");
        int rowCount = reader.getRowCount(sheetname);

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
            String userName = reader.getCellData(sheetname, "username", rowNum);
            String paSSWord = reader.getCellData(sheetname, "password", rowNum);

            Object ob[] = {userName, paSSWord};
            data.add(ob);

        }
        return data;
    }

    @DataProvider(name = "SauceLabloginData")
    public Iterator<Object[]> getTestData() {
        ArrayList<Object[]> testdata = loginData();
        return testdata.iterator(); //get value one by one sequentially
    }
}
	
		
	
	




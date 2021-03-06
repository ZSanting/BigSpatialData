/**   
* @Title: DataImport.java 
* @Package edu.jxust.BigSpatialData 
* @Description: TODO 
* @author 张炫铤  
* @date 2017年2月8日 下午2:32:19 
* @version V1.0   
*/
package edu.jxust.BigSpatialData;

import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.log4j.BasicConfigurator;

import edu.jxust.Common.HBaseHelper;

/** 
* @ClassName: DataImport 
* @Description: TODO
* @author 张炫铤
* @date 2017年2月8日 下午2:32:19 
*  
*/
public class DataImport {

	/** 
	* @Title: main 
	* @Description: TODO
	* @param args
	* @throws 
	*/
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		String header = "G:\\MyFile\\研究生\\论文\\云计算\\测试数据\\AREALM_header.csv";
		String data = "G:\\MyFile\\研究生\\论文\\云计算\\测试数据\\AREALM.csv";
		CsvFileOpera csv=new CsvFileOpera(header,data);
		HConnection connection = HBaseHelper.getConnection("master", "2181");
		HTableInterface dtSpatialData = connection.getTable("SpatialData");
		csv.importData(dtSpatialData, "\\\t", "\\\t");
		connection.close();
	}

}

package com.simian.medallion.mobile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class Running {
	
	public void run() throws Exception{
		SimpleDateFormat sdfFrom = new SimpleDateFormat("MM/dd/yy");
		SimpleDateFormat sdfTo = new SimpleDateFormat("yyyy-MM-dd");
		
		File folder = new File("/home/elvino/workspaces/springboots/saham/master/all3year");
		FileWriter fw = new FileWriter("/home/elvino/workspaces/springboots/saham/master/all3year.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		Map<String, String> stocks = new HashMap<String, String>();
		
		for (File f : folder.listFiles()) {
			BufferedReader br = new BufferedReader(new FileReader(f)); 
			String st; 
			while ((st = br.readLine()) != null) {
				if (st.startsWith("<date>")) continue;
				String[] array =  st.split(",");
				String strDate = array[0];
				String strCode = array[1];
				String strClose = array[5];
				if (strCode.endsWith("-W")) continue;
				
				stocks.put(strCode, "insert into public.product(id, code, name) values(nextval('SEQ_PRODUCT'), '"+strCode+"', '"+strCode+"');");
				
				String formattedDate =  sdfTo.format(sdfFrom.parse(strDate));
				String sql = "insert into public.nav(id, \"date\", price, product_code) values(nextval('SEQ_NAV'), '"+formattedDate+"', "+strClose+", '"+strCode+"');";
				bw.write(sql+"\n");
//				System.out.println(sql);
			} 
			bw.flush();
			br.close();
		}
		bw.close();
		
		for (String stock : stocks.values()) {
			System.out.println(stock);
		}
	}

	public static void main(String[] args) throws Exception{
		Running running = new Running();
		running.run();
	}
}

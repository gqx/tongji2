package excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ExcelPre2007Util extends BaseExcel{
	
	FileInputStream fIn;
	HSSFWorkbook readWorkBook;
	HSSFSheet readSheet;
	


	public ExcelPre2007Util(String filePath) {
		this.xlsFile = filePath;
		myCity = new MyCity();
	}


	public void initRead() {
		try {
			fIn = new FileInputStream(xlsFile);
			readWorkBook = new HSSFWorkbook(fIn);
			readSheet = readWorkBook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readXls() {
		initRead();
		java.util.Iterator<Row> rowIterator = readSheet.rowIterator();
		HSSFRow readRow;


		String currentSchool = "";
		String currentClass = "";
		int ASum = 0;
		int BSum = 0;
		int CSum = 0;
		int sum = 0;
		double[] score = new double[courseSum];
		double[] hegeLine = new double[courseSum];
		
		//先读出各科的合格线
		readRow = (HSSFRow) rowIterator.next();
		for(int i  = 0;i < courseSum;i++){
			hegeLine[i] = readRow.getCell(2+i).getNumericCellValue();
		}
		boolean start = true;
		while (rowIterator.hasNext()) {
			readRow = (HSSFRow) rowIterator.next();
			String newSchool = readRow.getCell(0).getStringCellValue();
			String newClass = readRow.getCell(1).getStringCellValue();
			if (start) {
				currentSchool = newSchool;
				currentClass = newClass;
				MySchool tempSchool = new MySchool();
				tempSchool.setName(currentSchool);
				myCity.addToMySchool(tempSchool);
				start = false;
			}
			
			
			if (!newSchool.equals(currentSchool) || !newClass.equals(currentClass)) {
				MyClass tempClass = new MyClass();
				tempClass.setName(currentClass);
				tempClass.setSchool(currentSchool);
				tempClass.setASum(ASum);
				tempClass.setBSum(BSum);
				tempClass.setCSum(CSum);
				tempClass.setSum(sum);
				myCity.getMySchoolList().get(myCity.getMySchoolList().size()-1).addToMyClass(tempClass);
				if (!newSchool.equals(currentSchool)) {
					MySchool tempSchool = new MySchool();
					tempSchool.setName(newSchool);
					myCity.addToMySchool(tempSchool);
				}
				currentSchool = newSchool;
				currentClass = newClass;
				ASum = 0;
				BSum = 0;
				CSum = 0;
				sum = 0;
			}
			
			for(int i  = 0;i < courseSum;i++){
				score[i] = readRow.getCell(2+i).getNumericCellValue();
			}
			
			if(upperLine(score,ALine)){
				ASum++;
			}
			if(upperLine(score,BLine)){
				BSum++;
			}
			if(upperLine(score,hegeLine)){
				CSum++;
			}
			
			sum++;
		
		}
		MyClass tempClass = new MyClass();
		tempClass.setName(currentClass);
		tempClass.setSchool(currentSchool);
		tempClass.setASum(ASum);
		tempClass.setBSum(BSum);
		tempClass.setCSum(CSum);
		tempClass.setSum(sum);
		myCity.getMySchoolList().get(myCity.getMySchoolList().size()-1).addToMyClass(tempClass);
		
		
	}
	
	/**
	 * 计算score[]中的分数是否都大于line[]中的分数线
	 * @param score
	 * @param line
	 * @return
	 */
	public boolean upperLine(double[] score,double[] line){
		for(int i = 0;i < score.length;i++){
			if(!moreThan(score[i],line[i],true)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 计算score[]中的分数是否都大于line
	 * @param score
	 * @param line
	 * @return
	 */
	public boolean upperLine(double[] score,double line){
		for(double s : score){
			if(!moreThan(s,line,true)){
				return false;
			}
		}
		return true;
	}

	/**
	 * 计算num是否大于(大于等于)line
	 * @param num
	 * @param line
	 * @param equalLine
	 * @return
	 */
	public boolean moreThan(double num,double line,boolean equalLine){
		if(equalLine){
			if(num >= line) return true;
		}else{
			if(num > line) return true;
		}
		return false;
	}
	
	public void writeXls() {
		ArrayList<MySchool> schoolListWrite = myCity.getMySchoolList();
		HSSFWorkbook workbook = new HSSFWorkbook(); // 产生工作簿对象

		createClassData(schoolListWrite, workbook);
		createSchoolData(schoolListWrite, workbook);

		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(xlsFile);
			workbook.write(fOut);
			fOut.flush();
			fOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("文件生成...");
	}

	public void createClassData(ArrayList<MySchool> schoolListWrite,HSSFWorkbook workbook) {
		String A = "A类"+ALine+"以上";
		String B = "B类"+BLine+"以上";
		String C = "C类 ";
		String[] tableHead = new String[] { "学校", "班级",A,B,C};
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "按班级统计");

		HSSFRow headRow = sheet.createRow(0);
		for (int i = 0; i < tableHead.length; i++) {
			setRowData(headRow, i, tableHead[i]);
		}

		int i = 1;
		for (MySchool mySchool : schoolListWrite) {
			for (MyClass myClass : mySchool.getMyClassList()) {
				HSSFRow row = sheet.createRow(i);
				setRowData(row, 0, myClass.getSchool());
				setRowData(row, 1, myClass.getName());
				setRowData(row, 2, getScale(myClass.getAPersent()*100, 2)+"%("+myClass.getASum()+"人)");
				setRowData(row, 3, getScale(myClass.getBPersent()*100, 2)+"%("+myClass.getBSum()+"人)");
				setRowData(row, 4, getScale(myClass.getCPersent()*100, 2)+"%("+myClass.getCSum()+"人)");

				i++;
			}
		}
	}
	
	public void createSchoolData(ArrayList<MySchool> schoolListWrite,HSSFWorkbook workbook) {
		String A = "A类"+ALine+"以上";
		String B = "B类"+BLine+"以上";
		String C = "C类"+CLine+"以上";
//		String[] tableHead = new String[] { "学校", "平均分", "及格率", "优秀率", "0-40",
//				"40-50", "50-60", "60-70", "70-80", "80-90", "90-100",A,B,C,D,E };
		String[] tableHead = new String[] { "学校", A,B,C};
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(1, "按学校统计");

		// 产生一行
		HSSFRow headRow = sheet.createRow(0);
		for (int i = 0; i < tableHead.length; i++) {
			setRowData(headRow, i, tableHead[i]);
		}

		int i = 1;
		for (MySchool mySchool : schoolListWrite) {
			mySchool.preCalculate();
			HSSFRow row = sheet.createRow(i);
			setRowData(row, 0, mySchool.getName());
			setRowData(row, 1, getScale(mySchool.getAPersent()*100,2) +"%("+mySchool.getASum()+"人)");
			setRowData(row, 2, getScale(mySchool.getBPersent()*100,2) +"%("+mySchool.getBSum()+"人)");
			setRowData(row, 3, getScale(mySchool.getCPersent()*100,2) +"%("+mySchool.getCSum()+"人)");
			i++;
		}
		
		String[] schoolData = myCity.getCityData();
		HSSFRow row = sheet.createRow(i);
		setRowData(row, 0, "总计");
		for(int j = 0; j < schoolData.length;j++){
			setRowData(row, j+1, schoolData[j]);
		}
	}
	
	private void setRowData(HSSFRow row, int cellIndex, String value) {
		// 产生一个单元格
		HSSFCell cell = row.createCell(cellIndex);
		// 设置单元格内容为字符串型
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		// 为了能在单元格中写入中文，设置字符编码为UTF_16。
		// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		// 往第一个单元格中写入信息
		cell.setCellValue(value);
	}
	public String getScale(double num, int scale){
		return new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}
}

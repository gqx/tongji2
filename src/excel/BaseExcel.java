package excel;

public class BaseExcel {
	protected String xlsFile; // 产生的Excel文件的名称
	protected int courseSum;
	protected MyCity myCity;
	protected int ALine;
	protected int BLine;
	protected int CLine;
	
	public void setLine(int ALine, int BLine,int CLine,int courseSum){
		this.ALine = ALine;
		this.BLine = BLine;
		this.CLine = CLine;
		this.courseSum = courseSum;
	}

	public MyCity getMyCity() {
		return myCity;
	}


	public void setMyCity(MyCity myCity) {
		this.myCity = myCity;
	}
	
	public void readXls(){};
	public void writeXls(){};
}

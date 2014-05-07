package excel;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MyCity {
	private ArrayList<MySchool> mySchoolList;
	private int ASum;
	private int BSum;
	private int CSum;
	private double APersent;
	private double BPersent;
	private double CPersent;
	private int sum;
	
	public MyCity(){
		sum = 0;
		ASum = 0;
		BSum = 0;
		CSum = 0;
		APersent = 0;
		BPersent = 0;
		CPersent = 0;
		mySchoolList = new ArrayList<MySchool>();
	}
	
	public void preCalculate(){
		sum = 0;
		ASum = 0;
		BSum = 0;
		CSum = 0;
		APersent = 0;
		BPersent = 0;
		CPersent = 0;
		for(MySchool mySchool:mySchoolList){
			ASum += mySchool.getASum();
			BSum += mySchool.getBSum();
			CSum += mySchool.getCSum();
			sum += mySchool.getSum();
		}
	}
	
	public void addToMySchool(MySchool mySchool){
		this.mySchoolList.add(mySchool);
	}

	public ArrayList<MySchool> getMySchoolList() {
		return mySchoolList;
	}

	public void setMySchoolList(ArrayList<MySchool> mySchoolList) {
		this.mySchoolList = mySchoolList;
	}

	public int getASum() {
		return ASum;
	}

	public void setASum(int aSum) {
		ASum = aSum;
	}

	public int getBSum() {
		return BSum;
	}

	public void setBSum(int bSum) {
		BSum = bSum;
	}

	public int getCSum() {
		return CSum;
	}

	public void setCSum(int cSum) {
		CSum = cSum;
	}

	public double getAPersent() {
		APersent = (double)ASum/(double)sum;
		return APersent;
	}

	public void setAPersent(double aPersent) {
		APersent = aPersent;
	}

	public double getBPersent() {
		BPersent = (double)BSum/(double)sum;
		return BPersent;
	}

	public void setBPersent(double bPersent) {
		BPersent = bPersent;
	}

	public double getCPersent() {
		CPersent = (double)CSum/(double)sum;
		return CPersent;
	}

	public void setCPersent(double cPersent) {
		CPersent = cPersent;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	public String[] getCityData(){
		String APersent = getScale(getAPersent()*100,2)+"%("+getASum()+"»À)";
		String BPersent = getScale(getBPersent()*100,2)+"%("+getBSum()+"»À)";
		String CPersent = getScale(getCPersent()*100,2)+"%("+getCSum()+"»À)";
		String[] result={APersent,BPersent,CPersent };
		return result;
	}
	
	public String getScale(double num, int scale){
		return new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}
	
}

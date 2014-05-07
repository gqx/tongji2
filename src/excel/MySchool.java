package excel;

import java.util.ArrayList;

public class MySchool {
	private String name;
	private ArrayList<MyClass> myClassList;
	private int ASum;
	private int BSum;
	private int CSum;
	private double APersent;
	private double BPersent;
	private double CPersent;
	private int sum;
	
	public MySchool(){
		sum = 0;
		ASum = 0;
		BSum = 0;
		CSum = 0;
		APersent = 0;
		BPersent = 0;
		CPersent = 0;
		myClassList = new ArrayList<MyClass>();
	}
	
	public void addToMyClass(MyClass myClass){
		this.myClassList.add(myClass);
	}

	public void preCalculate(){
		sum = 0;
		ASum = 0;
		BSum = 0;
		CSum = 0;
		APersent = 0;
		BPersent = 0;
		CPersent = 0;
		for(MyClass myClass:myClassList){
			ASum += myClass.getASum();
			BSum += myClass.getBSum();
			CSum += myClass.getCSum();
			sum += myClass.getSum();
		}
	}
	
	public ArrayList<MyClass> getMyClassList() {
		return myClassList;
	}

	public void setMyClassList(ArrayList<MyClass> myClassList) {
		this.myClassList = myClassList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
}

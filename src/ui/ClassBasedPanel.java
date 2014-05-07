package ui;
import com.cloudgarden.layout.AnchorConstraint;
import com.cloudgarden.layout.AnchorLayout;

import java.awt.Dimension;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import excel.MyCity;
import excel.MyClass;
import excel.MySchool;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ClassBasedPanel extends javax.swing.JPanel {
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private String[] tableHead = new String[] { "学校", "班级","A类","B类","C类"};
    private String[][] tableContent;
	/**
	* Auto-generated main method to display this 
	* JPanel inside a new JFrame.
	*/
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new ClassBasedPanel());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public ClassBasedPanel() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			AnchorLayout thisLayout = new AnchorLayout();
			this.setLayout(thisLayout);
			setPreferredSize(new Dimension(400, 300));
			{
				jScrollPane1 = new JScrollPane();
				this.add(jScrollPane1, new AnchorConstraint(1, 1001, 1001, 1, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
				jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 300));
				{
					TableModel jTable1Model = new DefaultTableModel(tableContent,tableHead);
					jTable1 = new JTable();
					jScrollPane1.setViewportView(jTable1);
					jTable1.setModel(jTable1Model);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setData(MyCity myCity){
		ArrayList<MySchool> schoolList = myCity.getMySchoolList();
		int length = 0;
		for(MySchool mySchool:schoolList){
			length+=mySchool.getMyClassList().size();
		}
		
		tableContent = new String[length][5];
		int i = 0;
		for(MySchool mySchool:schoolList){
			for(MyClass myClass : mySchool.getMyClassList()){
				
				tableContent[i][0] = myClass.getSchool();
				tableContent[i][1] = myClass.getName();
				tableContent[i][2] = getScale(myClass.getAPersent()*100,2)+"%("+myClass.getASum()+"人)";
				tableContent[i][3] = getScale(myClass.getBPersent()*100,2)+"%("+myClass.getBSum()+"人)";
				tableContent[i][4] = getScale(myClass.getCPersent()*100,2)+"%("+myClass.getCSum()+"人)";
				i++;
			}
		}
		TableModel jTable1Model = 
			new DefaultTableModel(
					tableContent,
					tableHead);
		jTable1.setModel(jTable1Model);
	}
	
	public String getScale(double num, int scale){
		return new BigDecimal(num).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
	}

}

package ui;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import com.cloudgarden.layout.AnchorConstraint;
import excel.BaseExcel;
import excel.ExcelPost2007Util;
import excel.ExcelPre2007Util;


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
public class MainFrame extends javax.swing.JFrame {
	private JPanel jPanel1;
	private JTextField filePathText;
	private JLabel jLabel2;
	private JSpinner BSpinner;
	private JLabel jLabel3;
	private JLabel jLabel5;
	private JTabbedPane jTabbedPane1;
	private ClassBasedPanel classPanel;
	private SchoolBasedPanel schoolPanel;
	private JSpinner jSpinner1;
	private JLabel jLabel1;
	private JSpinner CSpinner;
	private JSpinner ASpinner;
	private JButton chooseFileButton;
	private JButton calculateButton;
	private String filePath;
	private JButton exportButton;
	private SpinnerListModel ASpinnerModel;
	private SpinnerListModel BSpinnerModel;
	private SpinnerListModel CSpinnerModel;
	private SpinnerListModel KeMuSpinnerModel;
	BaseExcel excel;
	private int FULLSCORE = 150;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setTitle("分数统计工具(全科)");
				inst.setResizable(false);
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();

				jPanel1.setLayout(null);
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setPreferredSize(new java.awt.Dimension(740, 512));
				{
					jTabbedPane1 = new JTabbedPane();
					classPanel = new ClassBasedPanel();
					// classPanel.setData(null);
					schoolPanel = new SchoolBasedPanel();
					// schoolPanel.setData(null);
					jTabbedPane1.add("按班级统计", classPanel);
					classPanel.setPreferredSize(new java.awt.Dimension(712, 300));
					jTabbedPane1.add("按学校统计", schoolPanel);
					jPanel1.add(jTabbedPane1, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTabbedPane1.setBounds(11, 136, 717, 332);
				}
				{
					exportButton = new JButton();
					jPanel1.add(exportButton, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					exportButton.setName("exportButton");
					exportButton.setBounds(333, 477, 85, 29);
					exportButton.setText("保    存");
					exportButton.addActionListener(new saveActionListener());
				}
				{
					calculateButton = new JButton();
					jPanel1.add(calculateButton, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					calculateButton.setText("开始计算");
					calculateButton.setName("calculateButton");
					calculateButton.setPreferredSize(new java.awt.Dimension(87, 25));
					calculateButton.setBounds(530, 14, 91, 29);
					calculateButton.addActionListener(new calculateActionListener());
				}
				{
					chooseFileButton = new JButton();
					jPanel1.add(chooseFileButton, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					chooseFileButton.setText("选择文件");
					chooseFileButton.setName("chooseFileButton");
					chooseFileButton.setPreferredSize(new java.awt.Dimension(87, 25));
					chooseFileButton.setBounds(428, 14, 91, 29);
					chooseFileButton.addActionListener(new choosFileActionListener());
				}
				
				{
					filePathText = new JTextField();
					jPanel1.add(filePathText, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					filePathText.setPreferredSize(new java.awt.Dimension(302, 24));
					filePathText.setBounds(108, 16, 315, 27);
				}
				{
					String[] Alist = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						Alist[i] = i + "";
					}
					ASpinnerModel = new SpinnerListModel(Alist);
					ASpinnerModel.setValue("85");
					ASpinner = new JSpinner();
					jPanel1.add(ASpinner, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					ASpinner.setModel(ASpinnerModel);
					ASpinner.setBounds(347, 83, 45, 25);
				}
				{
					jLabel3 = new JLabel();
					jPanel1.add(jLabel3, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel3.setText("A类分数线:");
					jLabel3.setName("jLabel3");
					jLabel3.setBounds(271, 86, 70, 17);
				}
				{
					String[] Blist = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						Blist[i] = i + "";
					}
					BSpinnerModel = new SpinnerListModel(Blist);
					BSpinnerModel.setValue("70");
					BSpinner = new JSpinner();
					jPanel1.add(BSpinner, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					BSpinner.setModel(BSpinnerModel);
					BSpinner.setBounds(508, 83, 46, 25);
				}
				{
					jLabel2 = new JLabel();
					jPanel1.add(jLabel2, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel2.setText("B类分数线:");
					jLabel2.setName("jLabel2");
					jLabel2.setBounds(432, 87, 68, 17);
				}
				{
					String[] Clist = new String[FULLSCORE+1];
					for (int i = 0; i <= FULLSCORE; i++) {	
						Clist[i] = i + "";
					}
					CSpinnerModel = new SpinnerListModel(Clist);
					CSpinnerModel.setValue("60");
					CSpinner = new JSpinner();
//					jPanel1.add(CSpinner, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					CSpinner.setModel(CSpinnerModel);
					CSpinner.setPreferredSize(new java.awt.Dimension(44, 22));
					CSpinner.setBounds(540, 92, 46, 25);
				}
				{
					jLabel5 = new JLabel();
//					jPanel1.add(jLabel5, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel5.setText("C类分数线:");
					jLabel5.setName("jLabel5");
					jLabel5.setPreferredSize(new java.awt.Dimension(71, 15));
					jLabel5.setBounds(466, 96, 74, 17);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("科目数量:");
					jLabel1.setName("jLabel1");
					jLabel1.setBounds(109, 87, 69, 16);
				}
				{
					String[] kemulist = new String[101];
					for (int i = 0; i <= 20; i++) {	
						kemulist[i] = i + "";
					}
					KeMuSpinnerModel = new SpinnerListModel(kemulist);
					KeMuSpinnerModel.setValue("2");
					jSpinner1 = new JSpinner();
					jPanel1.add(jSpinner1, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jSpinner1.setModel(KeMuSpinnerModel);
					jSpinner1.setBounds(185, 83, 46, 25);
				}
			}
			pack();
			this.setSize(756, 552);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	class choosFileActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MyFileChooser mfc = new MyFileChooser();
					mfc.setAcceptAllFileFilterUsed(false);
					// 添加excel文件的过滤器
					mfc.addChoosableFileFilter(new ExcelFileFilter2());
					mfc.showOpenDialog(null);
				}
			});
		}
	}
	
	class calculateActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (filePath != null && !filePath.equals("")) {
				String prefix = filePath.substring(filePath.lastIndexOf(".") + 1);
				int courseSum = Integer.parseInt(jSpinner1.getValue().toString());
				int ALine = Integer.parseInt(ASpinner.getValue().toString());
				int BLine = Integer.parseInt(BSpinner.getValue().toString());
				int CLine = Integer.parseInt(CSpinner.getValue().toString());
				
				if (prefix.equals("xlsx")) {
					excel = new ExcelPost2007Util(filePath);
					excel.setLine(ALine, BLine, CLine,courseSum);
					excel.readXls();
					classPanel.setData(excel.getMyCity());
					schoolPanel.setData(excel.getMyCity());
				} else if (prefix.equals("xls")) {
					excel = new ExcelPre2007Util(filePath);
					excel.setLine(ALine, BLine, CLine,courseSum);
					excel.readXls();
					classPanel.setData(excel.getMyCity());
					schoolPanel.setData(excel.getMyCity());
				}
			}
			
			
		}
	}
	
	public class MyFileChooser extends JFileChooser {
		public void approveSelection() {
			filePath = getSelectedFile().getPath();
			File file = new File(filePath);
			if (file.exists()) {
				super.approveSelection();
				filePathText.setText(file.getAbsolutePath());
			} else {
				JOptionPane.showMessageDialog(null, "你选择的文件不存在，请重新选择！");
			}
		}
	}
	
	private static class ExcelFileFilter2 extends FileFilter {

		public boolean accept(File file) {

			// 首先判断该目录下的某个文件是否是目录，如果是目录则返回true，即可以显示在目录下。
			if (file.isDirectory()) {
				return true;
			} 

			String fileName = file.getName();
			int index = fileName.lastIndexOf('.');

			if (index > 0 && index < fileName.length() - 1) {
				String extension = fileName.substring(index + 1).toLowerCase();
				if (extension.equals("xlsx") || extension.equals("xls"))
					return true;
			}
			return false;
		}

		public String getDescription() {			
				return "Microsoft Excel文件(*.xlsx, *.xls)";
		}
	}
	
	class saveActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					MySaveFileChooser mfc = new MySaveFileChooser();
					mfc.setAcceptAllFileFilterUsed(false);
					// 添加excel文件的过滤器
					mfc.addChoosableFileFilter(new ExcelFileFilter("xlsx"));
					// 添加excel文件的过滤器
					mfc.addChoosableFileFilter(new ExcelFileFilter("xls"));
					mfc.showSaveDialog(null);
				}
			});
		}
	}
	
	public class MySaveFileChooser extends JFileChooser {
		public void approveSelection() {
			if (excel.getMyCity().getMySchoolList() != null) {

				filePath = getSelectedFile().getPath();
				File file = new File(filePath);
				if (file.exists()) {
					JOptionPane.showMessageDialog(null, "文件已存在，请重新选择！");

				} else {					
					super.approveSelection();
					try {
						int courseSum = Integer.parseInt(jSpinner1.getValue().toString());
						int ALine = Integer.parseInt(ASpinner.getValue().toString());
						int BLine = Integer.parseInt(BSpinner.getValue().toString());
						int CLine = Integer.parseInt(CSpinner.getValue().toString());
						
						if (getFileFilter().getDescription().equals("Microsoft Excel文件(*.xlsx)")) {
							filePath+=".xlsx";
							file = new File(filePath);
							file.createNewFile();
							ExcelPost2007Util postExcel = new ExcelPost2007Util(filePath);	
							postExcel.setMyCity(excel.getMyCity());
							postExcel.setLine(ALine, BLine, CLine, courseSum);
							postExcel.writeXls();
						} else if (getFileFilter().getDescription().equals("Microsoft Excel文件(*.xls)")) {
							filePath+=".xls";
							file = new File(filePath);
							file.createNewFile();
							ExcelPre2007Util preExcel = new ExcelPre2007Util(filePath);
							preExcel.setMyCity(excel.getMyCity());
							preExcel.setLine(ALine, BLine, CLine, courseSum);
							preExcel.writeXls();
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	private static class ExcelFileFilter extends FileFilter {

		String ext;

		// 构造方法的参数是我们需要过滤的文件类型。比如excel文件就是 xls,exe文件是exe.
		ExcelFileFilter(String ext) {
			this.ext = ext;
		}

		/*
		 * 这个方法就是重写 FileFilter 类的方法，参数是File对象，一般这个参数是如何传入的我们可以不用关心。
		 * 他返回一个布尔型。如果为真表示该文件符合过滤设置，那么就会显示在当前目录下，如果为假就会被过滤掉。
		 */
		public boolean accept(File file) {

			// 首先判断该目录下的某个文件是否是目录，如果是目录则返回true，即可以显示在目录下。
			if (file.isDirectory()) {
				return true;
			}

			/*
			 * 获得某个文件的文件名，然后使用lastIndexOf()来获得这个文件名字符串中'.'这个字符最后一次出现的位置。
			 * 并且通过它返回的一个整型来判断该文件是否符合*.*这中文件+文件名的格式，
			 * 如果不符合那么就不显示这个文件。如果符合，那么就将'.'字符后面的字符串提取出来与过滤的文件名相比较，
			 * 如果相等则符合该文件格式，并显示出来。如果不相等那么就将其过滤掉。
			 */
			String fileName = file.getName();
			int index = fileName.lastIndexOf('.');

			if (index > 0 && index < fileName.length() - 1) {
				String extension = fileName.substring(index + 1).toLowerCase();
				if (extension.equals(ext))
					return true;
			}
			return false;
		}

		/*
		 * 这个方法也是重写FileFilter的方法，作用是在过滤名那里显示出相关的信息。
		 * 这个与我们过滤的文件类型想匹配，通过这些信息，可以让用户更清晰的明白需要过滤什么类型的文件。
		 */
		public String getDescription() {

			if (ext.equals("xls")) {
				return "Microsoft Excel文件(*.xls)";
			}
			if (ext.equals("xlsx")) {
				return "Microsoft Excel文件(*.xlsx)";
			}
			return "";
		}
	}

}

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
				inst.setTitle("����ͳ�ƹ���(ȫ��)");
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
					jTabbedPane1.add("���༶ͳ��", classPanel);
					classPanel.setPreferredSize(new java.awt.Dimension(712, 300));
					jTabbedPane1.add("��ѧУͳ��", schoolPanel);
					jPanel1.add(jTabbedPane1, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jTabbedPane1.setBounds(11, 136, 717, 332);
				}
				{
					exportButton = new JButton();
					jPanel1.add(exportButton, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					exportButton.setName("exportButton");
					exportButton.setBounds(333, 477, 85, 29);
					exportButton.setText("��    ��");
					exportButton.addActionListener(new saveActionListener());
				}
				{
					calculateButton = new JButton();
					jPanel1.add(calculateButton, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					calculateButton.setText("��ʼ����");
					calculateButton.setName("calculateButton");
					calculateButton.setPreferredSize(new java.awt.Dimension(87, 25));
					calculateButton.setBounds(530, 14, 91, 29);
					calculateButton.addActionListener(new calculateActionListener());
				}
				{
					chooseFileButton = new JButton();
					jPanel1.add(chooseFileButton, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					chooseFileButton.setText("ѡ���ļ�");
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
					jLabel3.setText("A�������:");
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
					jLabel2.setText("B�������:");
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
					jLabel5.setText("C�������:");
					jLabel5.setName("jLabel5");
					jLabel5.setPreferredSize(new java.awt.Dimension(71, 15));
					jLabel5.setBounds(466, 96, 74, 17);
				}
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1, new AnchorConstraint(0, 0, 0, 0, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL, AnchorConstraint.ANCHOR_REL));
					jLabel1.setText("��Ŀ����:");
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
					// ���excel�ļ��Ĺ�����
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
				JOptionPane.showMessageDialog(null, "��ѡ����ļ������ڣ�������ѡ��");
			}
		}
	}
	
	private static class ExcelFileFilter2 extends FileFilter {

		public boolean accept(File file) {

			// �����жϸ�Ŀ¼�µ�ĳ���ļ��Ƿ���Ŀ¼�������Ŀ¼�򷵻�true����������ʾ��Ŀ¼�¡�
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
				return "Microsoft Excel�ļ�(*.xlsx, *.xls)";
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
					// ���excel�ļ��Ĺ�����
					mfc.addChoosableFileFilter(new ExcelFileFilter("xlsx"));
					// ���excel�ļ��Ĺ�����
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
					JOptionPane.showMessageDialog(null, "�ļ��Ѵ��ڣ�������ѡ��");

				} else {					
					super.approveSelection();
					try {
						int courseSum = Integer.parseInt(jSpinner1.getValue().toString());
						int ALine = Integer.parseInt(ASpinner.getValue().toString());
						int BLine = Integer.parseInt(BSpinner.getValue().toString());
						int CLine = Integer.parseInt(CSpinner.getValue().toString());
						
						if (getFileFilter().getDescription().equals("Microsoft Excel�ļ�(*.xlsx)")) {
							filePath+=".xlsx";
							file = new File(filePath);
							file.createNewFile();
							ExcelPost2007Util postExcel = new ExcelPost2007Util(filePath);	
							postExcel.setMyCity(excel.getMyCity());
							postExcel.setLine(ALine, BLine, CLine, courseSum);
							postExcel.writeXls();
						} else if (getFileFilter().getDescription().equals("Microsoft Excel�ļ�(*.xls)")) {
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

		// ���췽���Ĳ�����������Ҫ���˵��ļ����͡�����excel�ļ����� xls,exe�ļ���exe.
		ExcelFileFilter(String ext) {
			this.ext = ext;
		}

		/*
		 * �������������д FileFilter ��ķ�����������File����һ�������������δ�������ǿ��Բ��ù��ġ�
		 * ������һ�������͡����Ϊ���ʾ���ļ����Ϲ������ã���ô�ͻ���ʾ�ڵ�ǰĿ¼�£����Ϊ�پͻᱻ���˵���
		 */
		public boolean accept(File file) {

			// �����жϸ�Ŀ¼�µ�ĳ���ļ��Ƿ���Ŀ¼�������Ŀ¼�򷵻�true����������ʾ��Ŀ¼�¡�
			if (file.isDirectory()) {
				return true;
			}

			/*
			 * ���ĳ���ļ����ļ�����Ȼ��ʹ��lastIndexOf()���������ļ����ַ�����'.'����ַ����һ�γ��ֵ�λ�á�
			 * ����ͨ�������ص�һ���������жϸ��ļ��Ƿ����*.*�����ļ�+�ļ����ĸ�ʽ��
			 * �����������ô�Ͳ���ʾ����ļ���������ϣ���ô�ͽ�'.'�ַ�������ַ�����ȡ��������˵��ļ�����Ƚϣ�
			 * ����������ϸ��ļ���ʽ������ʾ����������������ô�ͽ�����˵���
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
		 * �������Ҳ����дFileFilter�ķ������������ڹ�����������ʾ����ص���Ϣ��
		 * ��������ǹ��˵��ļ�������ƥ�䣬ͨ����Щ��Ϣ���������û���������������Ҫ����ʲô���͵��ļ���
		 */
		public String getDescription() {

			if (ext.equals("xls")) {
				return "Microsoft Excel�ļ�(*.xls)";
			}
			if (ext.equals("xlsx")) {
				return "Microsoft Excel�ļ�(*.xlsx)";
			}
			return "";
		}
	}

}

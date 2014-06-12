import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

public class TeremCalcGui {

	private JFrame frame;
	private JTextField txtStartDate;
	private JTextField txtEndDate;
	private JTextField txtSum;
	private JTextField txtFFTeremResult;
	private JTextField txtRunStatus;
	private JTextField txtDirectResult;
	private JTextField txtFFcbsResult;
	private JTextField txtChromeTeremResult;
	private JTextField txtIETeremResult;
	private JTextField txtChromecbsResult;
	private JTextField txtIEcbsResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//System.out.println("Starting");
					TeremCalcGui window = new TeremCalcGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeremCalcGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final String CBSResult = "";
		final String TeremResult = "" ;
		final String DirectResult = "" ;
		
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnTeremCalc = new JButton("Calculate Using www.terem.co.il");
		btnTeremCalc.setBounds(0, 86, 508, 23);
		btnTeremCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String StartDate = txtStartDate.getText();
				String EndDate = txtEndDate.getText();
				String TotalSum = txtSum.getText();
				Object[] options = {"FireFox", "Crome", "Internet Explorer"};
				int t = JOptionPane.showOptionDialog(frame,"With what browser do you want to run the Calculation ","Browser selection",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
				txtRunStatus.setText("Starting www.terem.co.il Calculation");
				txtRunStatus.update(txtRunStatus.getGraphics());
				System.out.println( "Outside t = " + t);
				String Result = WebSiteTest.TeremApptest(t, StartDate, EndDate, TotalSum, TeremResult);
				switch (t) {
			    case 0: {
			    	txtFFTeremResult.setText(Result);
			        break;
			    	}
			    case 1: {
			    	txtChromeTeremResult.setText(Result);
			        break;
			    	}
			    case 2: {
			    	txtIETeremResult.setText(Result);
			        break;
			    	}
				}//txtChromeTeremResult
		        //txtFFTeremResult.setText(Result);
		        txtRunStatus.setText("Finished www.terem.co.il Calculation");
		        }
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnTeremCalc);
		
		JLabel lblStartdate = new JLabel("StartDate");
		lblStartdate.setBounds(10, 11, 70, 14);
		frame.getContentPane().add(lblStartdate);
		
		JLabel lblEnddate = new JLabel("EndDate");
		lblEnddate.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblEnddate);
		
		JLabel lblSum = new JLabel("Sum");
		lblSum.setBounds(10, 61, 46, 14);
		frame.getContentPane().add(lblSum);
		
		txtStartDate = new JTextField();
		txtStartDate.setText("20/05/2000");
		txtStartDate.setBounds(90, 8, 111, 20);
		frame.getContentPane().add(txtStartDate);
		txtStartDate.setColumns(10);
		
		txtEndDate = new JTextField();
		txtEndDate.setText("14/03/2014");
		txtEndDate.setBounds(90, 33, 111, 20);
		frame.getContentPane().add(txtEndDate);
		txtEndDate.setColumns(10);
		
		txtSum = new JTextField();
		txtSum.setText("1000");
		txtSum.setBounds(90, 58, 111, 20);
		frame.getContentPane().add(txtSum);
		txtSum.setColumns(10);
		
		JLabel lblTeremCalcResult = new JLabel("Terem Calc Result is : ");
		lblTeremCalcResult.setBounds(10, 257, 116, 14);
		frame.getContentPane().add(lblTeremCalcResult);
		
		JLabel lblDirectCalcResult = new JLabel("Direct Calc Result is : ");
		lblDirectCalcResult.setBounds(10, 284, 116, 14);
		frame.getContentPane().add(lblDirectCalcResult);
		
		JLabel lblCurrentMadad = new JLabel("Current Madad : ");
		lblCurrentMadad.setBounds(10, 344, 104, 14);
		frame.getContentPane().add(lblCurrentMadad);
		
		JLabel lblNewLabel = new JLabel("Past Madad : ");
		lblNewLabel.setBounds(10, 369, 116, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtFFTeremResult = new JTextField();
		txtFFTeremResult.setBounds(184, 251, 86, 20);
		frame.getContentPane().add(txtFFTeremResult);
		txtFFTeremResult.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("David", Font.PLAIN, 20));
		lblStatus.setBounds(317, 11, 70, 14);
		frame.getContentPane().add(lblStatus);
		
		txtRunStatus = new JTextField();
		txtRunStatus.setBounds(217, 33, 291, 20);
		frame.getContentPane().add(txtRunStatus);
		txtRunStatus.setColumns(10);
		
		JButton btnDirectCalc = new JButton("Direct Calculation");
		btnDirectCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Direct Calculation");
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
				Date date = new Date();
				String currentdate = dateFormat.format(date);
				String Madadcurrentdate = currentdate.substring(0, 6);
				//download XML file from site
				//String XML = "http://www.cbs.gov.il/reader/pirsum_madad/indices_heb.xml";
				String XML = "http://www.cbs.gov.il/reader/pirsum_madad/indicesM.xml?ok_to_load=TRUE&StartDate=199701&EndDate=201404";
				//http://www.cbs.gov.il/reader/?MIval=%2Fprices_db%2FPriceInd_M_OneSeries_OneBase_H.html&Separated=11120010&MyCode=11120010&BasePeriods=28%2F09%2F1951&DataType=Ind&Years_1=1951&Years_2=2014&Months_1=9&Months_2=4&Subjects=38&MyPeriod=m&Radio1=1_3&FileType=1
				
				File tempFile;
				try {
					tempFile = File.createTempFile(currentdate, ".xml");
					System.out.println("Temp file : " + tempFile.getAbsolutePath());
					URL website = new URL(XML);
					org.apache.commons.io.FileUtils.copyURLToFile(website, tempFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDirectCalc.setBounds(0, 122, 508, 23);
		frame.getContentPane().add(btnDirectCalc);
		
		JButton btnCBSCalc = new JButton("Calculate Using www.cbs.gov.il");
		btnCBSCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Starting www.cbs.gov.il Calculation");
				String StartDate = txtStartDate.getText();
				String EndDate = txtEndDate.getText();
				String TotalSum = txtSum.getText();
				//String Zero = "0";
				txtRunStatus.setText("Starting www.cbs.gov.il Calculation");
				txtRunStatus.update(txtRunStatus.getGraphics());
				Object[] options = {"FireFox", "Crome", "Internet Explorer"};
				int t = JOptionPane.showOptionDialog(frame,"With what browser do you want to run the Calculation ","Browser selection",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
				String Result = WebSiteTest.ExtApptest(t, StartDate, EndDate, TotalSum, CBSResult);
				/*WebDriver driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get("http://www.cbs.gov.il/reader/?MIval=%2Fprices_db%2FMachshevon_4_H.html&MD=a&MySubject=37&MyCode=11120010");
				//enter start date
				WebElement queryStartDateDay = driver.findElement(By.name("Days_1"));
				WebElement queryStartDateMonth = driver.findElement(By.name("Months_1"));
				WebElement queryStartDateYear = driver.findElement(By.name("Years_1"));
				String MiniCalcStartDateDay = MiniCalcStartDate.substring(0, 2);
				String MiniCalcStartDateMonth = MiniCalcStartDate.substring(3, 5);
				String MiniCalcStartDateYear = MiniCalcStartDate.substring(6, 10);
				if(MiniCalcStartDateDay.charAt(0) == Zero.charAt(0)){
					MiniCalcStartDateDay = MiniCalcStartDate.substring(1, 2);
				}
		        new Select (queryStartDateDay).selectByValue(MiniCalcStartDateDay);
		        
				if(MiniCalcStartDateMonth.charAt(0) == Zero.charAt(0)){
					MiniCalcStartDateMonth = MiniCalcStartDateMonth.substring(1, 2);
				}
		        new Select (queryStartDateMonth).selectByValue(MiniCalcStartDateMonth);
		        new Select (queryStartDateYear).selectByValue(MiniCalcStartDateYear);
		        
		        //enter end date
		        WebElement queryEndDateDay = driver.findElement(By.name("Days_2"));
				WebElement queryEndDateMonth = driver.findElement(By.name("Months_2"));
				WebElement queryEndDateYear = driver.findElement(By.name("Years_2"));
				String MiniCalcEndDateDay = MiniCalcEndDate.substring(0, 2);
				String MiniCalcEndDateMonth = MiniCalcEndDate.substring(3, 5);
				String MiniCalcEndDateYear = MiniCalcEndDate.substring(6, 10);
				if(MiniCalcEndDateDay.charAt(0) == Zero.charAt(0)){
					MiniCalcEndDateDay = MiniCalcEndDateDay.substring(1, 2);
				}
		        new Select (queryEndDateDay).selectByValue(MiniCalcEndDateDay);
		        
				if(MiniCalcEndDateMonth.charAt(0) == Zero.charAt(0)){
					MiniCalcEndDateMonth = MiniCalcEndDateMonth.substring(1, 2);
				}
		        new Select (queryEndDateMonth).selectByValue(MiniCalcEndDateMonth);
		        new Select (queryEndDateYear).selectByValue(MiniCalcEndDateYear);
		        //enter sum
		        WebElement queryTotalSum = driver.findElement(By.name("ssum"));
		        queryTotalSum.sendKeys(new String[]{MiniCalcTotalSum});
		        
		        //press submit button from miniCalcSubmitButton
		        WebElement querySubmitButton = driver.findElement(By.className("kaftor"));
		        querySubmitButton.click();
		        
		        final String CBSResult = driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/b/font")).getText();
		        txtcbsResult.setText(CBSResult);
		        driver.quit();*/
		        System.out.println("Finished www.cbs.gov.il Calculation");
		        switch (t) {
			    case 0: {
			    	txtFFcbsResult.setText(Result);
			        break;
			    	}
			    case 1: {
			    	txtChromecbsResult.setText(Result);
			        break;
			    	}
			    case 2: {
			    	txtIEcbsResult.setText(Result);
			        break;
			    	}
				}//txtChromeTeremResult
		        //txtcbsResult.setText(CBSResult);
			}
		});
		btnCBSCalc.setBounds(0, 156, 508, 23);
		frame.getContentPane().add(btnCBSCalc);
		
		txtDirectResult = new JTextField();
		txtDirectResult.setBounds(184, 278, 86, 20);
		frame.getContentPane().add(txtDirectResult);
		txtDirectResult.setColumns(10);
		
		JLabel lblWwwcbsgovilResultIs = new JLabel("www.cbs.gov.il Result is : ");
		lblWwwcbsgovilResultIs.setBounds(10, 313, 164, 14);
		frame.getContentPane().add(lblWwwcbsgovilResultIs);
		
		txtFFcbsResult = new JTextField();
		txtFFcbsResult.setBounds(184, 307, 86, 20);
		frame.getContentPane().add(txtFFcbsResult);
		txtFFcbsResult.setColumns(10);
		
		txtChromeTeremResult = new JTextField();
		txtChromeTeremResult.setBounds(280, 251, 86, 20);
		frame.getContentPane().add(txtChromeTeremResult);
		txtChromeTeremResult.setColumns(10);
		
		txtIETeremResult = new JTextField();
		txtIETeremResult.setColumns(10);
		txtIETeremResult.setBounds(381, 251, 86, 20);
		frame.getContentPane().add(txtIETeremResult);
		
		JLabel lblFirefox = new JLabel("FireFox");
		lblFirefox.setBounds(184, 230, 86, 20);
		frame.getContentPane().add(lblFirefox);
		
		JLabel lblChrome = new JLabel("Chrome");
		lblChrome.setBounds(280, 230, 86, 20);
		frame.getContentPane().add(lblChrome);
		
		JLabel lblIe = new JLabel("IE");
		lblIe.setBounds(381, 230, 86, 20);
		frame.getContentPane().add(lblIe);
		
		txtChromecbsResult = new JTextField();
		txtChromecbsResult.setColumns(10);
		txtChromecbsResult.setBounds(280, 307, 86, 20);
		frame.getContentPane().add(txtChromecbsResult);
		
		txtIEcbsResult = new JTextField();
		txtIEcbsResult.setColumns(10);
		txtIEcbsResult.setBounds(381, 307, 86, 20);
		frame.getContentPane().add(txtIEcbsResult);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}

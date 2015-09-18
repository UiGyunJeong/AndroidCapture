import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class Gui extends JFrame {
	
	final static int WIDTH = 500;
	final static int HEIGHT = 300;

	public Gui(){
		super ("No Pain but CAPTURE! for Android");
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		//make Outer layout
		JPanel pOut = new JPanel(new BorderLayout());
		pOut.setBorder(new LineBorder(new Color(0,0,0),2));
		
		getContentPane().add(pOut);
		setSize(WIDTH, HEIGHT);
		
		
		
		//make inner layout
		JPanel pIn = new JPanel(new MigLayout("", "[]", "[][][][]"));
		pOut.add(pIn, BorderLayout.CENTER);
		pIn.setBorder(new LineBorder(new Color(0,0,255),2));
				
		
		
		//make FileName panel in Inner layout
		JPanel pUpper = new JPanel(new MigLayout("", "[grow][][][grow]", "[grow]"));
		pUpper.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
		pIn.add(pUpper, "wrap");
		pUpper.setBorder(new LineBorder(new Color(0, 100, 0), 2));
		
		JLabel lFileName = new JLabel("파일이름 : ");
		JTextField TFileName = new JTextField(15);
		JCheckBox CFileName = new JCheckBox("넘버링");
		JSpinner SFileName = new JSpinner();
		
		pUpper.add(lFileName, "alignx right");
		pUpper.add(TFileName, "alignx left");
		pUpper.add(CFileName, "alignx right,gapx 40");
		pUpper.add(SFileName);

		
		
		//make Location Save panel in Inner layout
		JPanel pMiddle = new JPanel(new MigLayout());
		pMiddle.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
		pIn.add(pMiddle, "wrap");
		pMiddle.setBorder(new LineBorder(new Color(100, 0, 0), 2));
		
		JLabel lSaveLoc = new JLabel("저장위치");
		JTextField TSaveLoc = new JTextField(40);
		JButton BSaveLoc = new JButton("찾기");
		
		pMiddle.add(lSaveLoc, "wrap");
		pMiddle.add(TSaveLoc);
		pMiddle.add(BSaveLoc);
		
		
		//make Save Button panel in Inner layout
		JPanel pDown = new JPanel(new MigLayout());
		pDown.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
		pIn.add(pDown, "wrap");
		pDown.setBorder(new LineBorder(new Color(100, 0, 0), 2));
		
		JButton bOpen = new JButton("저장폴더 열기");
		JButton bCapture = new JButton("캡쳐");
		
		pDown.add(bOpen);
		pDown.add(bCapture);
	}
	
}

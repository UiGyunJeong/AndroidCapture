import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
	String SAVELOC = "C:\\";

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
		JPanel pIn = new JPanel(new MigLayout("", "[]", "[][][]"));
		pOut.add(pIn, BorderLayout.CENTER);
		pIn.setBorder(new LineBorder(new Color(0,0,255),2));
				
		
		
		//make FileName panel in Inner layout
		JPanel pUpper = new JPanel(new MigLayout("", "[grow][][][grow]", "[grow]"));
		pUpper.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
		pIn.add(pUpper, "wrap");
		pUpper.setBorder(new LineBorder(new Color(0, 100, 0), 2));
		
		JLabel lFileName = new JLabel("파일이름 : ");
		JTextField tFileName = new JTextField("default", 15);
		JCheckBox cFileName = new JCheckBox("넘버링");
		JSpinner sFileName = new JSpinner();
		
		sFileName.setEnabled(false);
		cFileName.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED ){
					sFileName.setEnabled(true);
				}else{
					sFileName.setEnabled(false);
				}
			}
		});
		
		pUpper.add(lFileName, "alignx right");
		pUpper.add(tFileName, "alignx left");
		pUpper.add(cFileName, "alignx right,gapx 40");
		pUpper.add(sFileName);

		
		
		//make Location Save panel in Inner layout
		JPanel pMiddle = new JPanel(new MigLayout());
		pMiddle.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
		pIn.add(pMiddle, "wrap");
		pMiddle.setBorder(new LineBorder(new Color(100, 0, 0), 2));
		
		JLabel lSaveLoc = new JLabel("저장위치");
		JTextField tSaveLoc = new JTextField(40);
		JButton bSaveLoc = new JButton("찾기");
		
		tSaveLoc.setText(SAVELOC);
		bSaveLoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveFile = new JFileChooser(SAVELOC);
				saveFile.showSaveDialog(null);
				SAVELOC = saveFile.getCurrentDirectory().getAbsolutePath();
				
			}
		});
		
		
		pMiddle.add(lSaveLoc, "wrap");
		pMiddle.add(tSaveLoc);
		pMiddle.add(bSaveLoc);
		
		
		
		//make Save Button panel in Inner layout
		JPanel pDown = new JPanel(new MigLayout("", "[grow][][]", "[grow,bottom]"));
		pDown.setPreferredSize(new Dimension(WIDTH, HEIGHT/3));
		pIn.add(pDown, "wrap");
		pDown.setBorder(new LineBorder(new Color(100, 0, 0), 2));
		
		JButton bOpen = new JButton("저장폴더 열기");
		JButton bCapture = new JButton("캡쳐");
		
		bOpen.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser saveFile = new JFileChooser(SAVELOC);
				saveFile.showOpenDialog(null);
				
			}
		});
		
		bCapture.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CapturedImage cap = new CapturedImage(cFileName.isSelected(), tFileName.getText(), sFileName.getValue().toString(), tSaveLoc.getText());
			}
		});
		
		
		pDown.add(bOpen, "cell 1 0");
		pDown.add(bCapture, "cell 2 0");
	}
	
}

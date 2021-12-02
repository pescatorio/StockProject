package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import DAO.ProductDetailDAO;
import VO.ProductVO;

public class ProductPane extends JPanel implements ActionListener{
	private JPanel jp[]=new JPanel[6];
	private JLabel jl[]=new JLabel[5];
	private JTextField tf[]=new JTextField[5];
	private JButton okb;
	private JButton rsb;
	
	String[]caption={"��ǰ���̵� : ","��ǰ�� : ","��������̵� : ","���� : ","���� ����� : "};
	
	public ProductPane(){
		setLayout(new GridLayout(6,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		int i;
		for(i=0;i<size;i++){
			jp[i] = new JPanel();
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
		}
		
		jp[size]=new JPanel();
		okb = new JButton("��ǰ����ϱ�");
		okb.addActionListener(this);
		rsb = new JButton("�ٽþ���");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		ProductVO pvo = null;
		ProductDetailDAO pdvo = null;
		int tmpPid = Integer.parseInt(tf[0].getText());
		int tmpMid = Integer.parseInt(tf[2].getText());
		if(ae_type.equals(okb.getText())){
			try{
				pvo = new ProductVO(tmpPid,tf[1].getText()
						,tmpMid,tf[3].getText(),tf[4].getText());
				pdvo = new ProductDetailDAO();
				pdvo.AddProduct(pvo);
			}catch(Exception e){
				System.out.println("e=["+e+"]");
			}
			if(pdvo!=null){
				JOptionPane.showMessageDialog(this,tf[0].getText()+"��ǰ�� ���������� �߰��Ǿ����ϴ�.");
		}//if
		}else if(ae_type.equals(rsb.getText())){
			int size = caption.length;
			for(int i =0; i<size;i++){
				if(tf[i]!=null)
				tf[i].setText(null);
			}
		}
	}
}
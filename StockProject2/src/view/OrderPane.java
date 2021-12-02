package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import DAO.MyOrderDAO;
import DAO.ProductDetailDAO;
import VO.MyOrderVO;
import VO.ProductVO;

public class OrderPane extends JPanel implements ActionListener{
	private JPanel jp[] = new JPanel[7];
	private JLabel jl[] = new JLabel[6];
	private JTextField tf[] = new JTextField[6];
	private JButton rsb;	//�ֹ��ϱ�
	private JButton okb;	//��ǰ��ȸ�ϱ�
	ProductVO pvo = new ProductVO();
	ProductDetailDAO pdao = new ProductDetailDAO();
	String[] caption = {"��ǰ���̵� : ","��ǰ�� : ","������ : ","��ǰ���� : ","���� ����� : ","���ַ� : "};
	
	public OrderPane(){
		setLayout(new GridLayout(9,1));
		EtchedBorder eb = new EtchedBorder();
		setBorder(eb);
		
		int size = caption.length;
		
		for(int i=0;i<size;i++){
			jl[i] = new JLabel(caption[i]);
			tf[i] = new JTextField(15);
			jp[i] = new JPanel();
			jp[i].add(jl[i]);
			jp[i].add(tf[i]);
			add(jp[i]);
			tf[i].setEditable(false);
			if(i==0||i==5)
				tf[i].setEditable(true);
		}
		jp[size] = new JPanel();
		okb = new JButton("��ǰ��ȸ");
		okb.addActionListener(this);
		rsb=new JButton("�����ϱ�");
		rsb.addActionListener(this);
		rsb.setEnabled(false);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		MyOrderVO mvo;
		ProductVO pvo;
		MyOrderDAO mdvo = new MyOrderDAO();
		ProductDetailDAO pdvo = new ProductDetailDAO();
		
		int tmpPid = Integer.parseInt((tf[0].getText()));	//product_id�� int������ ��ȯ�ϴ� �ӽú���
		
		if(ae_type.equals(okb.getText())){
			pvo = new ProductVO();
			try{
				if(tmpPid!=0){
					pvo = mdvo.getProductCheck(tmpPid);
				}
			}catch(Exception e){
				System.out.println("e=["+e+"]");
			}
			if(pvo!=null){
				tf[0].setText(pvo.getProduct_id()+"");
				tf[1].setText(pvo.getProduct_name());
				tf[2].setText(pvo.getManufacturer_id()+"");
				tf[3].setText(pvo.getPrice_number());
				tf[4].setText(pvo.getStock());
				rsb.setEnabled(true);
			}else{
				JOptionPane.showMessageDialog(this, "��ǰ���̵� �������� �ʽ��ϴ�.");
				int size = caption.length;
				for(int i=0;i<size;i++){
					tf[i].setText(null);
				}
			}
		}else if(ae_type.equals(rsb.getText())){
			mvo = new MyOrderVO();
			int tmpMid = Integer.parseInt(tf[2].getText());
			int tmpOn = Integer.parseInt(tf[5].getText());
			mdvo.getOrder(tmpPid, tmpMid , tmpOn);
			JOptionPane.showMessageDialog(this,"���ְ� �Ϸ�Ǿ����ϴ�.");
			
			int size = caption.length;
			for(int i =0; i<size;i++){
				if(tf[i]!=null)
				tf[i].setText(null);
			}
		}
	}
	
}
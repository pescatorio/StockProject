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
	private JButton rsb;	//주문하기
	private JButton okb;	//제품조회하기
	ProductVO pvo = new ProductVO();
	ProductDetailDAO pdao = new ProductDetailDAO();
	String[] caption = {"제품아이디 : ","제품명 : ","제조사 : ","제품가격 : ","현재 재고수 : ","발주량 : "};
	
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
		okb = new JButton("제품조회");
		okb.addActionListener(this);
		rsb=new JButton("발주하기");
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
		
		int tmpPid = Integer.parseInt((tf[0].getText()));	//product_id를 int형으로 변환하는 임시변수
		
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
				JOptionPane.showMessageDialog(this, "제품아이디가 존재하지 않습니다.");
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
			JOptionPane.showMessageDialog(this,"발주가 완료되었습니다.");
			
			int size = caption.length;
			for(int i =0; i<size;i++){
				if(tf[i]!=null)
				tf[i].setText(null);
			}
		}
	}
	
}

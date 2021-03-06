package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import DAO.MyOrderDAO;
import VO.MyOrderVO;

public class IsStockedPane extends JPanel implements ActionListener{
	private JPanel jp[] = new JPanel[7];
	private JLabel jl[] = new JLabel[6];
	private JTextField tf[] = new JTextField[6];
	private JButton rsb;	//주문하기
	private JButton okb;	//제품조회하기
	String[] caption = {"주문아이디 : ","제품아이디 : ","제조사아이디 : ","주문량 : ","주문일 : ","입고여부(전[0]/후[1]) : "};
	
	public IsStockedPane(){
		setLayout(new GridLayout(8,1));
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
				
		}
		tf[0].setEditable(true);
		jp[size] = new JPanel();
		okb = new JButton("주문조회");
		okb.addActionListener(this);
		rsb=new JButton("입고처리");
		rsb.addActionListener(this);
		rsb.setEnabled(false);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();
		MyOrderVO mvo = new MyOrderVO();
		MyOrderDAO mdao = new MyOrderDAO();
		
		int tmpOid = Integer.parseInt((tf[0].getText()));	//order_id를 int형으로 변환하는 임시변수
		
		if(ae_type.equals(okb.getText())){
			try{
				if(tmpOid!=0){
					mvo = mdao.getMyOrder(tmpOid);
				}
			}catch(Exception e){
				System.out.println("e=["+e+"]");
			}
			if(mvo!=null){
				tf[0].setText(mvo.getOrder_id()+"");
				tf[1].setText(mvo.getProuct_id()+"");
				tf[2].setText(mvo.getManufacturer_id()+"");
				tf[3].setText(mvo.getOrder_number()+"");
				tf[4].setText(mvo.getOrder_date());
				tf[5].setText(mvo.getIsStocked());
				tf[5].setEditable(true);
				rsb.setEnabled(true);
				
			}else{
				JOptionPane.showMessageDialog(this, "주문아이디가 존재하지 않습니다.");
				int size = caption.length;
				for(int i=0;i<size;i++){
					tf[i].setText(null);
					tf[5].setEditable(false);
				}
			}
		}else if(ae_type.equals(rsb.getText())){
			int tmpPid = Integer.parseInt((tf[1].getText()));
			String tmpIsStocked = tf[5].getText();
			String stock =null;
			int tmpStock = 0;
			
			
			if(tmpIsStocked.equals("0")||tmpIsStocked.equals("1")){
				int result= mdao.isStocked(tmpOid, tmpIsStocked);
				//재고수를 저장하는 임시변수
				if(result>0){
					if(tmpIsStocked.equals("1")){
						try {
							stock = mdao.getProductStock(tmpPid);
							tmpStock = Integer.parseInt(stock);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("tmpStock : "+tmpStock);
						tmpStock = Integer.parseInt(tf[3].getText())+tmpStock;
						mdao.setStock(tmpPid, tmpStock);
						JOptionPane.showMessageDialog(this,"입고처리가 완료되었습니다.");
					}
				}else{
					JOptionPane.showMessageDialog(this,"입고처리가  실패하였습니다.");
				}
			}else{
				JOptionPane.showMessageDialog(this, "입고전:0/ 입고후:1을 입력해주세요.");
			}
			
			int size = caption.length;
			for(int i =0; i<size;i++){
				if(tf[i]!=null)
				tf[i].setText(null);
				tf[5].setEditable(false);
			}
		}
	}
	
}
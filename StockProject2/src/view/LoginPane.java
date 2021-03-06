package view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;//dao랑 연결
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import DAO.AdminDAO;
import VO.AdminVO;


public class LoginPane extends JPanel implements ActionListener{
	private JPanel jp[] = new JPanel[4];
	private JLabel jl[] = new JLabel[2];
	private JTextField tf[] = new JTextField[2];
	private JButton okb;
	private JButton rsb;
	String[]caption={"아이디", "비밀번호"}; 
	
	 public LoginPane(){
		setLayout(new GridLayout(4,1));
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
	okb = new JButton("로그인");
	okb.addActionListener(this);
	rsb = new JButton("취소");
	rsb.addActionListener(this);
	jp[size].add(okb);
	jp[size].add(rsb);
	add(jp[size]); 
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String ae_type = ae.getActionCommand();
		AdminVO avo;
		AdminDAO advo; 
		int tmpId= Integer.parseInt( tf[0].getText());  
		String tmpPassword = tf[1].getText(); 
		
		if(ae_type.equals(okb.getText())){
			avo = new AdminVO();
			advo = new AdminDAO();
			
			try{
				avo=advo.getAdmin(tmpId); 
				int avoid = avo.getId();
				String avoPassword = avo.getPassword();
				boolean avoIsadmin = avo.getIsAdmin();
				if(tmpId==avoid&&tmpPassword.equals(avoPassword)&&avoIsadmin==true){
					JOptionPane.showMessageDialog(this,tf[0].getText()+"님의 로그인이 성공하였습니다.");
					
				} else if(avoIsadmin!=true){
					JOptionPane.showMessageDialog(null,"님은 관리자가 아닙니다.");
				}else if(tmpId!=avoid&&tmpPassword.equals(avoPassword) || tmpId==avoid&&!tmpPassword.equals(avoPassword)){
					JOptionPane.showMessageDialog(this,tf[0].getText()+"님의 아이디와 비밀번호가 맞지않습니다.");
				}
			
			}catch(Exception e){
				System.out.println("e: "+ e);
				JOptionPane.showMessageDialog(this,tf[1].getText()+"로그인 실패.");	
			}
		}	else if(ae_type.equals(rsb.getText())){
			int size = caption.length;
			for(int i =0; i<size;i++){
				if(tf[i]!=null)
				tf[i].setText(null);
			}
		}
	}	
}	

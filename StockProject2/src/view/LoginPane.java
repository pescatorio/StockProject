package view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;//dao�� ����
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
	String[]caption={"���̵�", "��й�ȣ"}; 
	
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
	okb = new JButton("�α���");
	okb.addActionListener(this);
	rsb = new JButton("���");
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
					JOptionPane.showMessageDialog(this,tf[0].getText()+"���� �α����� �����Ͽ����ϴ�.");
					
				} else if(avoIsadmin!=true){
					JOptionPane.showMessageDialog(null,"���� �����ڰ� �ƴմϴ�.");
				}else if(tmpId!=avoid&&tmpPassword.equals(avoPassword) || tmpId==avoid&&!tmpPassword.equals(avoPassword)){
					JOptionPane.showMessageDialog(this,tf[0].getText()+"���� ���̵�� ��й�ȣ�� �����ʽ��ϴ�.");
				}
			
			}catch(Exception e){
				System.out.println("e: "+ e);
				JOptionPane.showMessageDialog(this,tf[1].getText()+"�α��� ����.");	
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
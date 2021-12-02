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

import DAO.ManufacturerListDAO;
import VO.ManufacturerVO;



public class ManufacturerPane extends JPanel implements ActionListener {
	private JPanel jp[]=new JPanel[5];
	private JLabel jl[]=new JLabel[3];
	private JTextField tf[]=new JTextField[3];
	private JButton okb;
	private JButton rsb;
	
	String[]caption={"��������̵�: ","����ó : ","������� : "};
	
	public ManufacturerPane() {
		setLayout(new GridLayout(5,1));
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
		okb = new JButton("�����ϱ�");
		okb.addActionListener(this);
		rsb = new JButton("�ٽþ���");
		rsb.addActionListener(this);
		jp[size].add(okb);
		jp[size].add(rsb);
		add(jp[size]);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String ae_type = ae.getActionCommand();//� ��ư�� ���ȴ��� �� �� �ֵ��� ��ư ���� ����
		ManufacturerVO mvo= null;
		ManufacturerListDAO mdao=null;
		int tmpMid = Integer.parseInt(tf[0].getText());
		if(ae_type.equals(okb.getText())){
			try{
				mvo = new ManufacturerVO(tmpMid,tf[1].getText(),tf[2].getText());
				mdao = new ManufacturerListDAO();
				mdao.ManufacturerListregiste(mvo);
			}catch(Exception e){
				System.out.println("e=["+e+"]");
			}
			if(mdao != null){
				JOptionPane.showMessageDialog(this, "���������� �߰��Ǿ����ϴ�.");
			}
		}else if(ae_type.equals(rsb.getText())){
			int size = caption.length;
			for(int i =0; i<size;i++){
				if(tf[i]!=null)
				tf[i].setText(null);
			}
		}
	}
}
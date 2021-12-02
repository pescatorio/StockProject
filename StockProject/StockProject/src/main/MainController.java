package main;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.IsStockedPane;
import view.LoginPane;
import view.ManufacturerPane;
import view.OrderListPane;
import view.OrderPane;
import view.ProductListPane;
import view.ProductPane;


public class MainController extends JFrame{
	private JTabbedPane tp;
	private LoginPane lp;			//�α����г�
	private ProductPane pp;			//��ǰ�����г�
	private OrderPane op;			//�ֹ��г�
	private IsStockedPane isp; 		//�԰��г�
	private ProductListPane plp;	//��ǰ����Ʈ�г�
	private ManufacturerPane mp;	//�������г�
	private OrderListPane olp;		//�ֹ�����Ʈ�г�
	
	
	
	public MainController(){
		tp = new JTabbedPane();
		lp = new LoginPane();
		pp = new ProductPane();
		op = new OrderPane();
		isp = new IsStockedPane();
		plp = new ProductListPane();
		mp = new ManufacturerPane();
		olp = new OrderListPane();
		
		
		tp.addTab("�α���",lp);
		tp.addTab("��ǰ",pp);
		tp.addTab("����", op);
		tp.addTab("�԰�",isp);	
		tp.addTab("������", mp);
		tp.addTab("��ǰ����Ʈ", plp);
		tp.addTab("�ֹ�����Ʈ", olp);
	

		getContentPane().add(tp);
		setTitle("��ǰ���ֽý���(1��)");
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainController();
	}

}
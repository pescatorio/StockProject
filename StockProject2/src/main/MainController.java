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
	private LoginPane lp;			//로그인패널
	private ProductPane pp;			//제품관리패널
	private OrderPane op;			//주문패널
	private IsStockedPane isp; 		//입고패널
	private ProductListPane plp;	//제품리스트패널
	private ManufacturerPane mp;	//제조사패널
	private OrderListPane olp;		//주문리스트패널
	
	
	
	public MainController(){
		tp = new JTabbedPane();
		lp = new LoginPane();
		pp = new ProductPane();
		op = new OrderPane();
		isp = new IsStockedPane();
		plp = new ProductListPane();
		mp = new ManufacturerPane();
		olp = new OrderListPane();
		
		
		tp.addTab("로그인",lp);
		tp.addTab("제품",pp);
		tp.addTab("발주", op);
		tp.addTab("입고",isp);	
		tp.addTab("제조사", mp);
		tp.addTab("제품리스트", plp);
		tp.addTab("주문리스트", olp);
	

		getContentPane().add(tp);
		setTitle("제품발주시스템(1팀)");
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainController();
	}

}

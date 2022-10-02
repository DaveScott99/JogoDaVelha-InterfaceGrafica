package application;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Program extends JFrame {

	JButton[] bt = new JButton[9];
	JLabel placar = new JLabel("PLACAR");
	JLabel px = new JLabel("X = 0");
	JLabel po = new JLabel("O = 0");
	JButton novoJogo = new JButton("Novo Jogo");
	JButton zerarPlacar = new JButton("Zerar Placar");
	int PX = 0;
	int PO = 0;
	boolean xo = false;
	boolean[] click = new boolean[9];
	
	public Program() {
		setVisible(true);
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(3);
		setLayout(null);
		setBounds(250, 100, 700 ,500);
		
		int cont = 0;
		
		for (int i = 0; i < 3; i++) {
			
			for (int j = 0; j < 3; j++) {
				bt[cont] = new JButton();
				add(bt[cont]);
				bt[cont].setBounds((100 * i) + 50, (100 * j) + 95, 95, 95);
				add(placar);
				add(px);
				add(po);
				add(novoJogo);
				add(zerarPlacar);
				
				placar.setBounds(450,50,200,50);
				placar.setFont(new Font("Arial", Font.BOLD, 30));
				
				px.setBounds(440,100,150,50);
				px.setFont(new Font("Arial", Font.BOLD, 25));
				
				po.setBounds(530,100,150,50);
				po.setFont(new Font("Arial", Font.BOLD, 25));
				
				novoJogo.setBounds(430,200,180,50);
				novoJogo.setFont(new Font("Arial", Font.BOLD, 20));
				
				zerarPlacar.setBounds(430,250,180,50);
				zerarPlacar.setFont(new Font("Arial", Font.BOLD, 20));
				
				novoJogo.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						limpar();
					}
					
				});
				
				zerarPlacar.addActionListener(new java.awt.event.ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						PO = 0;
						PX = 0;
						atualizar();
					}
					
				});
				
				
				
				bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
				cont++;
			}
			
		}
		
		for (int i =0; i < 9; i++) {
			click[i] = false;
		}
		
		bt[0].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[0] == false) {
					click[0] = true;
					mudar(bt[0]);
				}
			}
			
		});
		
		bt[1].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[1] == false) {
					click[1] = true;
					mudar(bt[1]);
				}
			}
			
		});
		
		bt[2].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[2] == false) {
					click[2] = true;
					mudar(bt[2]);
				}
			}
			
		});
		
		bt[3].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[3] == false) {
					click[3] = true;
					mudar(bt[3]);
				}
			}
			
		});
		
		bt[4].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[4] == false) {
					click[4] = true;
					mudar(bt[4]);
				}
			}
			
		});
		
		bt[5].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[5] == false) {
					click[5] = true;
					mudar(bt[5]);
				}
			}
			
		});
		
		bt[6].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[6] == false) {
					click[6] = true;
					mudar(bt[6]);
				}
			}
			
		});
		
		bt[7].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[7] == false) {
					click[7] = true;
					mudar(bt[7]);
				}
			}
			
		});
		
		bt[8].addActionListener(new java.awt.event.ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (click[8] == false) {
					click[8] = true;
					mudar(bt[8]);
				}
			}
			
		});
	}
	
	public void mudar(JButton btn) {
		if (xo) {
			btn.setText("O");
			xo = false;
		}
		else {
			btn.setText("X");
			xo = true;
		}
		
		ganhou();
	}
	
	public void atualizar() {
		px.setText("X " + PX);
		po.setText("O " + PO);
	}
	
	public void ganhou() {
		
		int cont = 0;
		for (int i = 0; i < 9; i++) {
			if (click[i] == true) {
				cont++;
			}
		}
		
		if ((bt[0].getText() == "X" && bt[1].getText() == "X" && bt[2].getText() == "X") ||
			(bt[3].getText() == "X" && bt[4].getText() == "X" && bt[5].getText() == "X") ||
			(bt[6].getText() == "X" && bt[7].getText() == "X" && bt[8].getText() == "X") ||
			(bt[0].getText() == "X" && bt[3].getText() == "X" && bt[6].getText() == "X") ||
			(bt[1].getText() == "X" && bt[4].getText() == "X" && bt[7].getText() == "X") ||
			(bt[2].getText() == "X" && bt[5].getText() == "X" && bt[8].getText() == "X") ||
			(bt[0].getText() == "X" && bt[4].getText() == "X" && bt[8].getText() == "X") ||
			(bt[6].getText() == "X" && bt[4].getText() == "X" && bt[2].getText() == "X")) {
			
			JOptionPane.showMessageDialog(null, "X ganhou!");
			PX++;
			atualizar();
			limpar();
		}
		else if ((bt[0].getText() == "O" && bt[1].getText() == "O" && bt[2].getText() == "O") ||
				(bt[3].getText() == "O" && bt[4].getText() == "O" && bt[5].getText() == "O") ||
				(bt[6].getText() == "O" && bt[7].getText() == "O" && bt[8].getText() == "O") ||
				(bt[0].getText() == "O" && bt[3].getText() == "O" && bt[6].getText() == "O") ||
				(bt[1].getText() == "O" && bt[4].getText() == "O" && bt[7].getText() == "O") ||
				(bt[2].getText() == "O" && bt[5].getText() == "O" && bt[8].getText() == "O") ||
				(bt[0].getText() == "O" && bt[4].getText() == "O" && bt[8].getText() == "O") ||
				(bt[6].getText() == "O" && bt[4].getText() == "O" && bt[2].getText() == "O")) {
				
				JOptionPane.showMessageDialog(null, "O ganhou!");
				PO++;
				atualizar();
				limpar();
		}
		else if(cont == 9){
			JOptionPane.showMessageDialog(null, "EMPATE!");
			limpar();
		}
		
	}
	
	public void limpar() {
		for (int i = 0; i < 9; i++) {
			bt[i].setText("");
			click[i] = false;
		}
	}

	public static void main(String[] args) {
		
		new Program();
		
	}
	
	
}

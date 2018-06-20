import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class zapiszodczyt {
	static JButton[][] tablicaprzyciskow;
	static JButton[][] tablicaprzyciskow1;
	static int wys;
	static int szer;
	
	
	public zapiszodczyt() {	}
	
	
	void zapisz(JButton[][] tablicaprzyciskow, JButton[][] tablicaprzyciskow1, int wys, int szer) throws IOException {
		int pusto = 0;
		int statek = 1;
		int trafiony = 2;
		int pudlo = 3;
		File statekkomp = new File("statek komp.txt");
		FileWriter fw = new FileWriter(statekkomp, true);
		PrintWriter pw = new PrintWriter(statekkomp);
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {				
				boolean hyc = false;
				if(tablicaprzyciskow1[a][b].getBackground()==Color.GREEN) {
					pw.println(statek);
					hyc = true;		
				}else if((tablicaprzyciskow1[a][b].getBackground()==Color.BLACK) || (tablicaprzyciskow1[a][b].getBackground()==Color.GRAY)) {
					pw.println(trafiony);
					hyc = true;	
				}else if(tablicaprzyciskow1[a][b].getBackground()==Color.RED) {
					pw.println(pudlo);
					hyc = true;
				}else {
					pw.println(pusto);	
				}
			}
		}
		pw.close();
		fw.close();
		
		
		File statekgracz = new File("statek gracz.txt");
		FileWriter fww = new FileWriter(statekgracz, true);
		PrintWriter pww = new PrintWriter(statekgracz);
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {
				boolean hyc = false;
				if(tablicaprzyciskow[a][b].getBackground()==Color.GREEN) {
					pww.println(statek);
					hyc = true;
				}
				else if((tablicaprzyciskow[a][b].getBackground()==Color.BLACK) || (tablicaprzyciskow[a][b].getBackground()==Color.GRAY)) {
					pww.println(trafiony);
					hyc = true;
				}
				else if(tablicaprzyciskow[a][b].getBackground()==Color.RED) {
					pww.println(pudlo);
					hyc = true;
				}else {
					pww.println(pusto);	
				}
			}
		}
		pww.close();
		fww.close();
		
		File wymiary = new File("wymiary.txt");
		FileWriter fwww = new FileWriter(wymiary, true);
		PrintWriter pwww = new PrintWriter(wymiary);
		
		pwww.print(wys+" ");
		pwww.print(szer);
		
		pwww.close();
		fwww.close();
	}
	
	
	void odczyt() throws IOException {
		File wymiary = new File("wymiary.txt");
		Scanner in = new Scanner(wymiary);
		wys = in.nextInt();
		szer = in.nextInt();
		in.close();
		
		tablicaprzyciskow = new JButton[wys+1][szer+1];
		tablicaprzyciskow1 = new JButton[wys+1][szer+1];
		
		File statekkomp = new File("statek komp.txt");
		FileWriter fw = new FileWriter(statekkomp, true);
		Scanner inn = new Scanner(statekkomp);
		
		
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {
				if(inn.hasNextInt()) {
				int aa = inn.nextInt();
				System.out.println(aa);
				tablicaprzyciskow1[a][b] = new JButton();
				if(aa==0) {
					tablicaprzyciskow1[a][b].setBackground(null);
				}
				if(aa==1) {
					tablicaprzyciskow1[a][b].setBackground(Color.GREEN);
				}
				if(aa==2) {
					tablicaprzyciskow1[a][b].setBackground(Color.BLACK);
				}
				if(aa==3) {
					tablicaprzyciskow1[a][b].setBackground(Color.RED);				
				}
			}}
		}
		
		inn.close();
		fw.close();
		
		
		File statekgracz = new File("statek gracz.txt");
		FileWriter fww = new FileWriter(statekgracz, true);
		Scanner innn = new Scanner(statekgracz);
		
		
		for(int a=0;a<wys+1;a++) {
			for(int b=0;b<szer+1;b++) {
				if(innn.hasNextInt()) {
				int aa = innn.nextInt();
				tablicaprzyciskow[a][b] = new JButton();
				if(aa==0) {
					tablicaprzyciskow[a][b].setBackground(null);
				}
				if(aa==1) {
					tablicaprzyciskow[a][b].setBackground(Color.GREEN);
				}
				if(aa==2) {
					tablicaprzyciskow[a][b].setBackground(Color.BLACK);
				}
				if(aa==3) {
					tablicaprzyciskow[a][b].setBackground(Color.RED);				
				}
			}}
		}
		innn.close();
		fww.close();
		
	}
	
	
	
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;


public class menu {
int kamil = 2;	
static boolean wczyt = false;
	
	public menu()  {
		//tworzenie jframe
		JFrame start = new JFrame("statki");
		start.setSize(500, 400);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start.setVisible(true);
		
		//tworzenie komponentow
		JLabel gra = new JLabel("GRA");
		JLabel photo = new JLabel();
		JLabel statki = new JLabel("STATKI");
		JButton nowagra = new JButton("NOWA GRA");
		JButton wczytajgre = new JButton("WCZYTAJ GRE");

		
		//komponenty pod wczytanie gry
		JSlider[] przesuwaki = new JSlider[5];
		String[] nazwystatkow = new String[5];
		nazwystatkow[0] = "5-masztowiec:";
		nazwystatkow[1] = "4-masztowiec:";
		nazwystatkow[2] = "3-masztowiec:";
		nazwystatkow[3] = "2-masztowiec:";
		nazwystatkow[4] = "1-masztowiec:";
		
		//dodawanie obrazka w menu
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("seconddraft.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
		ImageIcon iconLogo = new ImageIcon(dimg);
		photo.setIcon(iconLogo);
		photo.setBorder(BorderFactory.createEmptyBorder());
		//obrazek dodany
		
		
		//JPanel i dokladne dodawanie za pomoca GridbagCointrains
	
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints ogranicznik = new GridBagConstraints();
		//odstepy miedzy elementami
		ogranicznik.insets = new Insets(-100, 10, 10, 10);
		ogranicznik.gridx = 0;
		ogranicznik.gridy = 0;
		panel.add(gra, ogranicznik);
		ogranicznik.gridx = 1;
		panel.add(photo, ogranicznik);
		ogranicznik.gridx = 2;
		panel.add(statki, ogranicznik);
		ogranicznik.gridy = 1;
		ogranicznik.gridx = 0;
		panel.add(nowagra, ogranicznik);
		ogranicznik.gridx = 2;
		panel.add(wczytajgre, ogranicznik);
		
		panel.setVisible(true);
		
		start.add(panel);
		start.pack();
		
		
		//nowa gra
		nowagra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				przygotowanie nowa = new przygotowanie(start, panel);
			}
			
			
		});
		
		wczytajgre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int wys = 0;
				int szer = 0;
				File wymiary = new File("wymiary.txt");
				Scanner in;
				try {
					in = new Scanner(wymiary);				
					wys = in.nextInt();
					szer = in.nextInt();
					in.close();					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				wczyt = true;
				
			
			
			plansza wczytane = new plansza (start, panel, wys, szer, przesuwaki, nazwystatkow);
			
			
			}
			
		});
		
		
	}

}

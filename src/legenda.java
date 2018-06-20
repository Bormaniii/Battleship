import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

public class legenda {

	public legenda() {
		
		JFrame legend = new JFrame("Legenda");
		legend.setSize(200, 100);
		legend.setLocation(100, 100);
		JPanel panel = new JPanel(new GridLayout(3, 2));
		JLabel pudlo = new JLabel("- Pudlo");
		JLabel trafiony = new JLabel("- Trafiony");
		JLabel statek = new JLabel("- Statek");
		JButton pudlo1 = new JButton();
		JButton trafiony1 = new JButton();
		JButton statek1 = new JButton();
		pudlo1.setBackground(Color.BLACK);
		trafiony1.setBackground(Color.RED);
		statek1.setBackground(Color.GREEN);
		
		panel.add(pudlo1);
		panel.add(pudlo);
		panel.add(trafiony1);
		panel.add(trafiony);
		panel.add(statek1);
		panel.add(statek);
		
		panel.setVisible(true);
		legend.add(panel);
		legend.setVisible(true);
		
	}
}

package es.pmkirsten.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;

import es.pmkirsten.engine.WifiKeyEngine;

public class WifiKeyGUI {

	private JFrame frame;
	private final WifiKeyEngine wke = new WifiKeyEngine();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WifiKeyGUI window = new WifiKeyGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WifiKeyGUI() {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.wke.run();
		this.frame = new JFrame();
		this.frame.setTitle("Wifi Key");
		this.frame.setBounds(100, 100, 450, 300);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Est\u00E1s conectado a:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		this.frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(this.wke.getSSID());
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_1.setForeground(Color.BLUE);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		this.frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		this.frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(this.wke.getWifiKey());
		lblNewLabel_3.setFont(new Font("SansSerif", Font.PLAIN, 35));
		lblNewLabel_3.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		this.frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
	}

}

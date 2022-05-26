package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controllers.MainController;
import controllers.SecondaryController;

// Cette classe contient les composants de l'interface graphique de l'application
@SuppressWarnings("serial")
public class MainUI extends JFrame {

	// Un tableau qui contient tous les boutons de la calculatrice
	public JButton buttons[] = new JButton[20];

	// Un champs de text pour écrire une expression
	public JTextField input = new JTextField();

	// Une méthode qui initialise les composants de l'interface graphique
	private void initComponents() {

		// Le layout de la fenêtre
		this.setLayout(new BorderLayout(0, 2));
		// Le font à utiliser par tous les composants
		Font font = new Font("Monospaced", Font.BOLD, 16);

		// Initialisation de tous les boutons
		buttons[0]  = new JButton("MS");
		buttons[1]  = new JButton("MR");
		buttons[2]  = new JButton("(");
		buttons[3]  = new JButton(")");
		buttons[4]  = new JButton("7");
		buttons[5]  = new JButton("8");
		buttons[6]  = new JButton("9");
		buttons[7]  = new JButton("/");
		buttons[8]  = new JButton("4");
		buttons[9]  = new JButton("5");
		buttons[10] = new JButton("6");
		buttons[11] = new JButton("*");
		buttons[12] = new JButton("1");
		buttons[13] = new JButton("2");
		buttons[14] = new JButton("3");
		buttons[15] = new JButton("+");
		buttons[16] = new JButton(".");
		buttons[17] = new JButton("0");
		buttons[18] = new JButton("=");
		buttons[19] = new JButton("-");

		// Le bouton "MR" n'est cliquable que lorsqu'on a une valeur dans la mémoire
		buttons[1].setEnabled(false);

		// Déclarer un JPenel qui utilise le layout "GridLayout" pour placer les
		// boutons de la calculatrice
		GridLayout myLayout = new GridLayout(5, 4, 1, 1);
		JPanel numericalPanel = new JPanel(myLayout);

		// Ajouter les boutons aux JPanel
		for (JButton button : buttons) {
			button.setFont(font);
			numericalPanel.add(button);
		}

		// Alligner le contenu du textfield à gauche
		input.setHorizontalAlignment(SwingConstants.RIGHT);
		input.setFont(font);

		// Suggérer au layout une dimention pour le TextField
		input.setPreferredSize(new Dimension(200, 60));

		// Rendre impossible d'editer le contenu du TextField sans passer
		// par les boutons de la calculatrice
		input.setEditable(false);

		// Placer le JPanle contenant les boutons dans le centre de la fenêtre
		this.add(numericalPanel, BorderLayout.CENTER);

		// Et le JTextField dans le nord
		this.add(input, BorderLayout.NORTH);

	}

	// Cette méthode initialise les événements de chaque bouton
	private void initEvents() {

		// Créer une instance de chaque controlleur
		MainController controller = new MainController(this);
		SecondaryController secondaryController = new SecondaryController(this);

		// Utiliser le premier controlleur pour tous les boutons
		for (JButton button : buttons) {
			button.addActionListener(controller);
		}

		// Sauf le bouton "MS"
		buttons[0].removeActionListener(controller);
		buttons[0].addActionListener(secondaryController);

		// Le bouton "MR"
		buttons[1].removeActionListener(controller);
		buttons[1].addActionListener(secondaryController);

		// Et le bouton "="
		buttons[18].removeActionListener(controller);
		buttons[18].addActionListener(secondaryController);

	}

	// Le constructeur de cette classe
	public MainUI() {

		// Titre de la fenêtre
		this.setTitle("Calculatrice");
		// Position et dimention
		this.setBounds(100, 100, 300, 350);
		// Terminer le programme en cas de fermeture de cette fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Rendre impossible de redimentionner la fenêtre
		this.setResizable(false);

		// Initialiser les composants et les événements (méthodes ci-dessus)
		this.initComponents();
		this.initEvents();

		// Rendre la fenêtre visible
		this.setVisible(true);

	}

}

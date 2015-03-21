package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.TimerTask;

import javax.swing.JLabel;

import core.Common;
import core.Configuracion;
import core.Timer;

public class SelectKanji extends Activity {

	private Timer timer;
	private core.SelectKanji sk;
	private int p, t;
	private String[] kanji;
	private final MouseAdapter badClick = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == 1) {
				timer.cancel();
				Common.errorMessage("Respuesta incorrecta!!");
				newQuestion();
			}
		}
	};
	private final MouseAdapter goodClick = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			if (e.getButton() == 1) {
				timer.cancel();
				p++;
				Common.message("Respuesta correcta +1");
				newQuestion();
			}
		}
	};
	private JLabel kanjiLabel = new JLabel();

	public SelectKanji() {
		p = t = 0;
		kanjiLabel.setFont(Configuracion.getInstance().getFont());
		try {
			sk = new core.SelectKanji();
			startPractice();
		} catch (Exception ex) {
			Common.errorMessage();
		}
	}

	private void startPractice() throws IOException {
		newQuestion();
	}

	private void newQuestion() {
		t++;
		if (t <= Configuracion.getInstance().getRepeats()) {
			kanji = sk.getExcercise();
			this.removeAll();
			this.setLayout(new GridBagLayout());
			configureNewQuestion();
			this.updateUI();
		} else {
			this.removeAll();
			Common.message("Puntaje total: " + p);
		}

	}

	private void configureNewQuestion() {
		GridBagConstraints cnt = new GridBagConstraints();

		// label layout configuration
		kanjiLabel.setText(kanji[0]);
		cnt.fill = GridBagConstraints.HORIZONTAL;
		cnt.gridx = 0;
		cnt.gridy = 0;
		this.add(kanjiLabel, cnt);

		for (int x = 0; x < 4; ++x) {
			CButton btn;
			if (kanji[x + 1] == kanji[5]) {
				btn = new CButton(kanji[x + 1], goodClick);
			} else {
				btn = new CButton(kanji[x + 1], badClick);
			}
			cnt.fill = GridBagConstraints.HORIZONTAL;
			cnt.gridx = x%2;
			cnt.gridy = ( x >= 2)? 1 : 2;
			this.add(btn,cnt);
		}
		// this is the timer
		this.add(new VisualTimer(10, 1));
		timer = new Timer(9, new TimerTask() {
			@Override
			public void run() {
				Common.errorMessage("Se agoto el tiempo");
				newQuestion();
			}
		});

	}

}

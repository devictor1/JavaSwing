package aula0605;




import javax.swing.JButton;
import javax.swing.JFrame;

public class ExemploSwing01 {

	public static void main(String[] args) {
		
		
		JFrame quadro = new JFrame();
		
		String escritaBotao = "Clebinho tome";
		
		JButton botao = new JButton(escritaBotao);
		int diminuirBotao = 0;
		
		String[] btnArray = escritaBotao.split("");
		
		for (int i = 0;i < btnArray.length;i++) {
			if (btnArray[i].equals(" ")) {
				diminuirBotao += 1;
				diminuirBotao = Math.max(0, Math.min(((btnArray.length)/5), diminuirBotao));
			}
			
		}
		
		botao.setBounds(30,100,(escritaBotao.length()-diminuirBotao)*10,40);
		
		quadro.add(botao);
		quadro.setSize(400,500);
		quadro.setLayout(null);
		quadro.setVisible(true);
		
	}

}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;
    Cola cola=new Cola();

    public ColaGUI() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                try {
                    // Intentar convertir la entrada en un número entero
                    int valor = Integer.parseInt(input);
                    cola.encolar(valor,txtResultado);
                    txtElemento.setText("");
                } catch (NumberFormatException ex) {
                    // Mostrar mensaje si la entrada no es un número válido
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.desencolar(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaGUI");
        frame.setContentPane(new ColaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

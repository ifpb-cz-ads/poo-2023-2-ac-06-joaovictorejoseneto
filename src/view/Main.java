package view;

import dao.UsuarioDao;
import model.Usuario;

import javax.swing.*;

public class Main {
    private static UsuarioDao usuarioDao = new UsuarioDao();
    public static void main(String[] args) {

        int choose;

        do {
            choose = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções abaixo:" +
                    "\n 1 - Cadastrar usuario" +
                    "\n 2 - Listar usuario" +
                    "\n 3 - Buscar usuario por email"));


            switch (choose) {
                case 1:
                    String emailValue = JOptionPane.showInputDialog(null, "Informe seu email");
                    String senhaValue = JOptionPane.showInputDialog(null, "Informe sua senha");
                    Usuario novoUser = new Usuario(emailValue, senhaValue);

                    if (usuarioDao.addUsuario(novoUser)){
                        JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                        break;
                    }
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário");
                    break;

                case 2:
                    var listaUsuarios = usuarioDao.listarUsuarios();
                    var text = "";
                    for (Usuario usuario : listaUsuarios) {
                        text += usuario.getEmail() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, text);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Buscar usuario");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção invalida");
                }

            } while (choose != 0);
            JOptionPane.showMessageDialog(null, "Programa encerrado");

    }
}
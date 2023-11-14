package view;

import dao.UsuarioDao;
import model.Usuario;

public class teste {
    public static void main(String[] args) {

        UsuarioDao usuario = new UsuarioDao();
        Usuario user = new Usuario("GABUROEL@gmail.com", "123456");

        System.out.println(usuario.buscarPorEmail("jose"));

    }
}

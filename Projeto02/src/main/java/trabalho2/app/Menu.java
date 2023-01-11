package trabalho2.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.*;

@SpringBootApplication
@EntityScan("trabalho2.entity")
@EnableJpaRepositories("trabalho2.dao")
public class Menu {

    public static void main(String[] args) {

        label:
        while (true) {
            String op = menu();
            if (op == null) {
                break;
            } else if (op.isEmpty()) {
                continue;
            }
            switch (op) {
                case "1": { //ATOR CRUD
                    SpringApplicationBuilder builder = new SpringApplicationBuilder(AtorCRUD.class);
                    builder.headless(false).run();
                    break;
                }
                case "2": {//FILME CRUD
                    SpringApplicationBuilder builder = new SpringApplicationBuilder(FilmeCRUD.class);
                    builder.headless(false).run();
                    break;
                }
                case "3": //SAIR
                    break label;
                default:
                    JOptionPane.showMessageDialog(null, "Comando inválido.");
                    break;
            }
        }

    }

    public static String menu(){
        return JOptionPane.showInputDialog("""
                Selecione uma opção:
                1 - Menu ATOR
                2 - Menu FILME
                3 - SAIR""");
    }

}

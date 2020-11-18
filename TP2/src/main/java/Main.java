import DBUtils.category.CategoryRepository;
import DBUtils.player.PlayerRepository;
import quizz.*;

import java.util.List;


public class Main {

    private static Quizz quizz;

    public static void main(String[] args) {
        //quizz = new quizz.Quizz();
        CategoryRepository categoryRepository = new CategoryRepository();
        PlayerRepository playerRepository = new PlayerRepository();
        List<Category> categories = categoryRepository.getAll();

        Category category = categoryRepository.get(categories.get(0).getId());

        int countPlayer = playerRepository.getCountPlayer();

        Player player1 = playerRepository.get(1);
    }


}

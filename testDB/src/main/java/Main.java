import DBUtils.CategoryRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CategoryRepository categoryRepository = new CategoryRepository();
        List<String> categories = categoryRepository.getAll();

        for(String categorie : categories)
            System.out.println(categorie);
    }
}

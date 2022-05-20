import java.io.File;

public interface CreatingFiles {

    /**
     * Создать каталог
     */
    String createDir(String dir);

    /**
     * Создать файл
     */
    String createFile(String file);

    /**
     * Записать результат выполнения операции
     */
    String writeFile(File file, boolean result);

    /**
     * Записать данные в файл
     */
    String writeToTheFile(File file);
}

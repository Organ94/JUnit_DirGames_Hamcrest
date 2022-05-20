import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreatingFilesTest {
    public CreatingFiles creatingFiles;

    String pathDir = "D://Alexey/JavaCore/JUnit/result/JUnit_DirGames_Hamcrest/test";
    String pathFile = pathDir + "/test.txt";

    @Test
    @DisplayName("Тест на успешное создание каталога")
    public void successCreateDir() {
        creatingFiles = new CreatingFilesImpl();

        var creatingDir = creatingFiles.createDir(pathDir);
        assertThat(pathDir, stringContainsInOrder(Arrays.asList(creatingDir)));
    }

    @Test
    @DisplayName("Тест на успешное создание файла")
    public void successCreateFile() {
        creatingFiles = new CreatingFilesImpl();
        var creatingDir = creatingFiles.createDir(pathDir);
        assertThat(pathDir, stringContainsInOrder(Arrays.asList(creatingDir)));
        var creatingFile = creatingFiles.createFile(pathFile);
        assertThat(creatingFile, notNullValue());
    }

    @Test
    @DisplayName("Тест на успешную запись файла")
    public void successwriteToTheFile() {
        creatingFiles = new CreatingFilesImpl();
        assertThat(creatingFiles, instanceOf(CreatingFiles.class));
        var creatingDir = creatingFiles.createDir(pathDir);
        var creatingFile = creatingFiles.createFile(pathFile);
        var writeToTheFileTest = creatingFiles.writeToTheFile(new File(pathFile));
        assertThat(pathFile, stringContainsInOrder(Arrays.asList(creatingDir, creatingFile)));
        assertThat(writeToTheFileTest, not("не создан"));
    }
}
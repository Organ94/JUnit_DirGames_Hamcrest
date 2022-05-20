import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final String PATH = "D://Alexey/JavaCore/JUnit/result/JUnit_DirGames_Hamcrest";

    public static void main(String[] args) {

        List<String> dirPath = Arrays.asList(PATH + "/src", PATH + "/res", PATH + "/savegames", PATH + "/temp",
                PATH + "/src/main", PATH + "/src/test",
                PATH + "/res/drawables", PATH + "/res/vectors", PATH + "/res/icons");
        List<String> filePath = Arrays.asList(PATH + "/src/main/Main.java", PATH + "/src/main/Utils.java",
                PATH + "/temp/temp.txt");

        CreatingFilesImpl creatingFiles = new CreatingFilesImpl();

        for (String dir : dirPath) {
            creatingFiles.createDir(dir);
        }

        for (String file : filePath) {
            creatingFiles.createFile(file);
        }


        creatingFiles.writeToTheFile(new File(PATH + "/temp/temp.txt"));
    }
}

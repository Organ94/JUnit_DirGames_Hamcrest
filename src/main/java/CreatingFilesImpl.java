import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingFilesImpl implements CreatingFiles {
    public static final StringBuilder SB = new StringBuilder();

    @Override
    public String createDir(String dir) {
        if (dir == null) {
            throw new IllegalStateException("There is no path the directory");
        }
        File dirs = new File(dir);
        writeFile(dirs, dirs.mkdir());
        String key = dirs.getName();
        return key;
    }

    @Override
    public String createFile(String file) {
        File files = new File(file);

        if (FilenameUtils.getExtension(files.getName()).length() < 1) {
            throw new IllegalStateException("There is no file path");
        }
        try {
            writeFile(files, files.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = files.getName();
        return value;
    }

    @Override
    public String writeFile(File file, boolean result) {
        SB.append(file.isDirectory() ? "Каталог '" : "Файл '")
                .append(file.getName())
                .append(result ? "' создан!" : "' не создан")
                .append((!result && file.exists()) ? ", потому что уже существует!" : "")
                .append((!result && !file.exists()) ? ", потому что неверно указан путь!" : "")
                .append("\n");
        return SB.toString();
    }

    @Override
    public String writeToTheFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(SB.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}

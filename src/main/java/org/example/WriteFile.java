package org.example;
/**
 * Класс записи данных в файл
 */

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import static java.nio.file.Files.exists;

public class WriteFile implements AutoCloseable {
    protected String fileName;
    boolean closed;

    public WriteFile(String fileName) {
        this.fileName = fileName;
        closed = false;
    }

    @Override
    public void close() throws Exception {
        closed = true;
    }

    /**
     * Метод записи в файл
     * @param userData
     * @throws IOException
     */
    public void getUser(UserData userData) throws IOException {
        if (closed){
            throw new IOException("Ресурс записи в файл закрыт.");
        }
        boolean ok = exists(Path.of(fileName));
        try (FileWriter fw =new FileWriter(fileName, ok)){
            fw.write(userData.toString());
            fw.flush();
        }
    }
}

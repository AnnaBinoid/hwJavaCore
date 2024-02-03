package hw05task1javaCore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main05 {
    /**
     * Написать функцию, создающую резервную копию всех файлов в директории
     * (без поддиректорий) во вновь созданную папку ./backup
     * @param args
     */
    public static void main(String[] args) {
        try {
            createBackup("C:\\Users\\User\\Desktop" , "\\backup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createBackup(String ourDir, String backupDir) throws IOException {
        File ourDirectory = new File(ourDir);
        File backupDirectory = new File(backupDir);

        if (!ourDirectory.isDirectory()) {
            throw new RuntimeException("Source directory is not found.");
        }
        if (!backupDirectory.exists()){
            backupDirectory.mkdirs();
        }

        File [] ourFiles = ourDirectory.listFiles();
        for (File file: ourFiles) {
            if (file.isFile()) {
                File backUp = new File (backupDir + " : " + file.getName());
                copyFile(file, backUp);
            }
        }
    }
    public static void copyFile(File fileForCopy, File newFile) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(fileForCopy);
             FileOutputStream outputStream = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        }
    }
}

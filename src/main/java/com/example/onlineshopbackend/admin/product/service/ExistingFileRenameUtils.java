package com.example.onlineshopbackend.admin.product.service;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;

class ExistingFileRenameUtils {
    public static String renameIfExists(Path uploadDir, String fileName) {

        if (Files.exists(uploadDir.resolve(fileName))) {
            return renameAndCheck(uploadDir, fileName);
        }
        return fileName;
    }

    private static String renameAndCheck(Path uploadDir, String fileName) {
        String newName = renameFileName(fileName);
        if (Files.exists(uploadDir.resolve(newName))) {
            newName = renameAndCheck(uploadDir, newName);
        }
        return newName;
    }

    private static String renameFileName(String fileName) {
        String name = FilenameUtils.getBaseName(fileName);
        String[] split = name.split("-(?=[0-9]+$)");
        int counter = split.length > 1 ? Integer.parseInt(split[1]) + 1 : 1;
        return split[0] + "-" + counter + "." + FilenameUtils.getExtension(fileName);
    }
}

package com.example.onlineshopbackend.admin.product.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ExistingFileRenameUtilsTest {

    @Test
    void shouldNotRenameExistingFile(@TempDir Path tempDir) {
        String newName = ExistingFileRenameUtils.renameIfExists(tempDir, "test.txt");
        assertEquals("test-1.png", newName);
    }


    @Test
    void shouldRenameExistingFile(@TempDir Path tempDir) throws IOException {
        Files.createFile(tempDir.resolve("test.png"));
        String newName = ExistingFileRenameUtils.renameIfExists(tempDir, "test.txt");
        assertEquals("test-1.png", newName);
    }

    @Test
    void shouldRenameManyExistingFile(@TempDir Path tempDir) throws IOException {
        Files.createFile(tempDir.resolve("test.png"));
        Files.createFile(tempDir.resolve("test.png-1"));
        Files.createFile(tempDir.resolve("test.png-2"));
        Files.createFile(tempDir.resolve("test.png-3"));
        String newName = ExistingFileRenameUtils.renameIfExists(tempDir, "test.txt");
        assertEquals("test-4.png", newName);
    }

}
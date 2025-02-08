package service;

import entry.File;
import entry.FileSystemEntry;
import entry.Folder;

public class FileSystemManagementService {
    StringBuilder currentPath;
    Folder rootFolder;

    public FileSystemManagementService() {
        currentPath = new StringBuilder();
        rootFolder = new Folder("root",null);
    }

    public void createFolder(String folderName, Folder destinationFolder) {}

    public void createFile(String fileName, Folder destinationFolder) {
        FileSystemEntry newFile = new File(fileName,destinationFolder);
        destinationFolder.addItem(newFile);
        System.out.println(newFile.getName() + " has been created in " + destinationFolder.getName());
    }


    public void deleteFolder(String fileName) {}
    public void deleteFile(String fileName) {}

    public void findEntry(){
    }

    public void copyEntry(){}

    public void moveEntry(){}
}

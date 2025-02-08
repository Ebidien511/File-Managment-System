package entry;

import java.util.ArrayList;

public class Folder extends FileSystemEntry {
    public ArrayList<FileSystemEntry> folderContents;

    public Folder(String name, Folder parentFolder) {
        super(name, parentFolder);
        folderContents = new ArrayList<>();
    }

    @Override
    public long getSize() {
        long size = 0;
        for(FileSystemEntry entry : folderContents) {
            if(entry instanceof Folder) {
                Folder nestedFolder = (Folder) entry;
                size += nestedFolder.getSize();
            } else if (entry instanceof File) {
                size += entry.getSize();
            }
        }
        return size;
    }

    public int getNumberOfFiles(){
        int count=0;
        for(FileSystemEntry entry : folderContents) {
            if(entry instanceof Folder) {
                Folder currentFolder = (Folder) entry;
                currentFolder.getNumberOfFiles();
            } else if (entry instanceof File) {
                count++;
            }
        }
        return count;
    }

    public void deleteEntry(FileSystemEntry entry) {
        folderContents.remove(entry);
    }

    public void addItem(FileSystemEntry entry) {
        folderContents.add(entry);
    }

    public void copyEntry(String entryToBeCopiedName, Folder destinationFolder) {

        FileSystemEntry entryToBeCopied = null;

        for(FileSystemEntry entry : folderContents) {
            if(entry.getName().equals(entryToBeCopiedName) && entry instanceof Folder) {
                entryToBeCopied = (Folder) entry;
                FileSystemEntry newEntry = new Folder(entryToBeCopiedName+"(1)", destinationFolder);
            }
            else if(entry.getName().equals(entryToBeCopiedName) && entry instanceof File) {
                entryToBeCopied = (File) entry;
                FileSystemEntry newEntry = new File(entryToBeCopiedName+"(1)", destinationFolder);
            }
        }
    }

    public void moveEntry(String entryToBeMovedName, Folder destinationFolder) {

    }

}

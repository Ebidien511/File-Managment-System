package entry;

import java.time.LocalDateTime;

public abstract class FileSystemEntry {
    protected String name;
    protected Folder parentFolder;
    protected LocalDateTime dateCreated;
    protected LocalDateTime lastModificationDate;
    protected LocalDateTime lastAccessedDate;

    public FileSystemEntry(String name, Folder parentFolder) {
        this.name = name;
        this.parentFolder = parentFolder;
        this.dateCreated = LocalDateTime.now();
        this.lastModificationDate = LocalDateTime.now();
        this.lastAccessedDate = LocalDateTime.now();
    }

    public abstract long getSize();

    public String getFullPath(){
        if(parentFolder == null) return name;
        else return parentFolder.getFullPath()+"/"+name;
    }

    public String getName(){
        return this.name;
    }

    public void rename(String newName){
        this.name = newName;
    }
}

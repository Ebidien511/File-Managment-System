package entry;

public class File extends FileSystemEntry {

    private long size;
    private String content;

    public File(String name, Folder parentFolder) {
        super(name, parentFolder);
    }

    @Override
    public long getSize() {
        return this.size;
    }

    public void writeContent(String content) {
        this.content = content;
    }

    public String readContent() {return this.content;}
}

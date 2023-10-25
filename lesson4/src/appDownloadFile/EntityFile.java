package appDownloadFile;

public class EntityFile {
    String url;
    String fileName;

    public EntityFile(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "EntityFile{" +
                "url='" + url + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}

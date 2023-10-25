package appDownloadFile;

/**
 * Нужно записать в файл downloadFiles, который нахоится в корневой директории,
 * все пути к файлам и название файла с которым вы хотите сохранить файл через пробел
 * Например:
 * https://ya.ru/download/1 file1
 */

public class AppDownloadFile {
    public static void main(String[] args) {
        ParseDownloadFiles downloadFiles = new ParseDownloadFiles();
        DownloadFile download = new DownloadFile();
        download.execute(downloadFiles.parseFile(), 2);
    }
}

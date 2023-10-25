package appDownloadFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseDownloadFiles {

    public List<EntityFile> parseFile() {
        List<EntityFile> files = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("downloadFiles.txt"))) {
            String temp = br.readLine();
            while (temp != null) {
                String[] splitTemp = temp.split(" ");
                files.add(new EntityFile(splitTemp[0], splitTemp[1]));
                temp = br.readLine();
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return files;
    }
}

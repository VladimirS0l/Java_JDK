package appDownloadFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadFile {

    public void download(String url, String fileName) {
        try{
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void execute(List<EntityFile> files, Integer numThreads) {
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);

        for (EntityFile file: files) {
            Runnable downloadTask = () -> {
                try {
                    download(file.url, file.fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            pool.execute(downloadTask);
        }
        pool.shutdown();
    }
}

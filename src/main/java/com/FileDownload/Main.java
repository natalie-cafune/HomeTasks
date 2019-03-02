package com.FileDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the download link : ");
        String linkStr = scanner.nextLine();
        URL url = new URL(linkStr);

        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream("D:\\downloads\\information.txt");
        fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        fos.close();
        readableByteChannel.close();
    }
}

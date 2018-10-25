import java.io.*;
import java.net.*;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Specify the full path for where you want the videos saved");
        System.out.println("Ex: C:\\Users\\Kevin\\Desktop");
        String path = keyboard.nextLine();

        String[] links = {  "http://embed.wistia.com/deliveries/0f829b03857192ae5b23256e0f96e4704191e18b/file.mp4",
                            "http://embed.wistia.com/deliveries/e20612c36e716b90778c0f74931ba61ded8a16e7/file.mp4",
                            "http://embed.wistia.com/deliveries/7963bd49e2a4e2a390a6132ca4842275e1c65c28/file.mp4",
                            "http://embed.wistia.com/deliveries/1a2aeca7831f15c3de3b2921f77318f4e69ecc80/file.mp4",
                            "http://embed.wistia.com/deliveries/76943542e6d68abdaf7894c0e06384cb470bf60a/file.mp4",
                            "http://embed.wistia.com/deliveries/d00593a1d2f2e3cb2f7e8ca515fd0797c9f4d135/file.mp4",
                            "http://embed.wistia.com/deliveries/2ddd4b56eebda8e8275b885f884c6013215d6523/file.mp4",
                            "http://embed.wistia.com/deliveries/307b6f9289097a26e6cd3ccb8492530cc7b08c9c/file.mp4",
                            "http://embed.wistia.com/deliveries/abb8f00ccef4b6026d099f06956d0451057aa46d/file.mp4",
                            "http://embed.wistia.com/deliveries/8b3cb10afdd4f6b49c46e9b90c2aa4c2678f03f6/file.mp4",
                            "http://embed.wistia.com/deliveries/9b974c464028765c23a848ad518d4492a66ae79e/file.mp4",
                            "http://embed.wistia.com/deliveries/8d36480fc3265ab1d27fb6ad26ad6c04c842c91d/file.mp4",
                            "http://embed.wistia.com/deliveries/7be9ec77af5b804b0ca278758c972d88ef509835/file.mp4",
                            "http://embed.wistia.com/deliveries/d837eb0b8e7e7587a9ed874b39fc3b04a0453bc1/file.mp4",
                            "http://embed.wistia.com/deliveries/5ce96799761c2133ae8b5a5a21a1ead00bfa57a8/file.mp4",
                            "http://embed.wistia.com/deliveries/5e00843369b18200f68d388c84bdf96c06b28fd3/file.mp4",
                            "http://embed.wistia.com/deliveries/93d57fc6e744ae591adb74859273d31ea7474a7d/file.mp4",
                            "http://embed.wistia.com/deliveries/663769bd0b5ca9ecc2a683b0613623ebc5d33f32/file.mp4"

        };
        String[] saveNames = {
                            "Week1-Lecture9",
                            "Week1-Lecture10",
                            "Week1-Lecture11",
                            "Week1-Lecture12",
                            "Week1-Lecture13",
                            "Week1-Lecture14",
                            "Week1-Lecture15",
                            "Week1-Lecture16",
                            "Week1-Lecture17",
                            "Week1-Lecture18",
                            "Week1-Lecture19",
                            "Week1-Lecture20",
                            "Week1-Lecture21",
                            "Week1-Lecture22",
                            "Week1-Lecture23",
                            "Week1-Lecture24",
                            "Week1-Lecture25",
                            "Week1-Lecture26"
        };

        if(saveNames.length != links.length)
        {
            System.out.println("Need to have a save name for each download");
            System.exit(0);
        }

        //set everything up for downloading
        URL url = null;
        InputStream inputStream = null;
        String writename = null;
        OutputStream outStream = null;
        URLConnection urlCon = null;

        for(int i = 0; i < links.length; i++)
        {
            try {
                byte[] buf;
                int byteRead;

                url = new URL(links[i]);
                System.out.println("Fetching " + links[i] + ". . .");
                writename = path + "\\" + saveNames[i] + ".mp4";
                System.out.println("Writing to " + writename);

                outStream = new BufferedOutputStream(new FileOutputStream(writename));
                urlCon = url.openConnection();
                inputStream = urlCon.getInputStream();
                buf = new byte[1024];

                System.out.println("Downloading . . .");
                while ((byteRead = inputStream.read(buf)) != -1) {
                    outStream.write(buf, 0, byteRead);
                }
                System.out.println("Finished downloading " + saveNames[i] +".mp4");
            }
            catch(MalformedURLException ex) {
                System.out.println("Oh no, something went wrong!");
            }
            catch(IOException ex) {
                System.out.println("Arg, not good, this is not good!");
            }
            finally {
                    try {
                    inputStream.close();
                    outStream.close();
                } catch(IOException e) {
                    System.out.println("We're doomed!");
                }
            }
        }
    }
}
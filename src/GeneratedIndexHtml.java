import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GeneratedIndexHtml {
    public static void indexhtml(String startpage, String fileroot, Set<String> directories, Set <String> images, Set <String> imageslink, Set <String> directorieslink, String parentdirectory, boolean elsomappa) throws Exception
    {
        File f = new File(fileroot);
        List <String> directorieslist = new ArrayList<>(directories);
        List <String> imageslist = new ArrayList<>(images);
        List <String> directorieslinklist = new ArrayList<>(directorieslink);
        List <String> imageslinklist = new ArrayList<>(imageslink);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write("<html>\n");
        bw.write("<body>\n");
        bw.write("<p><a href=" + startpage + "><h1><b>Start Page</a><b></h1></p>\n");
        bw.write("<hr>\n");
        bw.write("<b><h1>Directories:<b></h1>\n");
        if (elsomappa == false)
        {
            bw.write("<p><a href =" + parentdirectory + "> << " + "</a></p>\n" );
        }
        for (int i = 0; i < directorieslist.size(); i++)
        {
            bw.write("<ul><li><a href =" + directorieslinklist.get(i) +  ">" + directorieslist.get(i) + "</a></li></ul>\n");
        }
        bw.write("<hr>\n");

        bw.write("<b><h1>Images:<b></h1>\n");
        for (int i = 0; i < imageslist.size(); i++)
        {
            bw.write("<ul><li><a href =" + imageslinklist.get(i) +  ">" + imageslist.get(i) + "</a></li></ul>\n");
        }
        bw.write("</body>\n");
        bw.write("</html>");
        bw.close();
    }
}

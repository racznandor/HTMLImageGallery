import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class GeneratedImageHtml {

    public static void imagehtml(String startpage, String htmlfajnlev, String eleresiut, String kepnev, Set<String> imageslink, String mappa, String elozomappa) throws Exception
    {
        File file = new File(htmlfajnlev);
        List <String> imageslinks = new ArrayList<>(imageslink);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("<html>\n");
        bw.write("<body>\n");
        bw.write("<p><a href=" + startpage + "><h1><b>Start Page</a><b></h1></p>\n");
        bw.write("<hr>\n");
        int index = 0;
        int point = mappa.indexOf('.');
        String name2 = mappa.substring(0, point) + ".html";
        String name3 = name2.toLowerCase();
        for (int i = 0; i < imageslinks.size(); i++)
        {
            if (imageslinks.get(i).toLowerCase().equals(name3))
            {
                index = i;
            }
        }
        int height = 800;
        int width = 800;
        bw.write("<p><a href =" + elozomappa + "> ^^ </a>"  + "</a></p>\n");
        //Ha egy kép van a mappában
        if (imageslinks.size() == 1 && index == 0)
        {
            bw.write("<p><a href =" + imageslinks.get(index) + "> << </a>"  + kepnev +  " <a href = " + imageslinks.get(index) + " > >> </a></p>\n");
        }
        //Ha első kép
        else if (index == 0)
        {
            bw.write("<p><a href =" + imageslinks.get(index) + "> << </a>"  + kepnev +  " <a href = " + imageslinks.get(index + 1) + " > >> </a></p>\n");
        }
        //Ha utolsó kép
        else if (index == imageslinks.size() - 1)
        {
            bw.write("<p><a href =" + imageslinks.get(index - 1) + "> << </a>"  + kepnev + " <a href = " + imageslinks.get(index) + " > >> </a></p>\n");

        }
        //Ha középső kép
        else
        {
            bw.write("<p><a href =" + imageslinks.get(index - 1) + "> << </a>"  + kepnev + " <a href = " + imageslinks.get(index + 1) + " > >> </a></p>\n");
        }

        if (index == imageslinks.size() - 1)
        {
            bw.write("<p><a href =" + imageslinks.get(index) + "><center><img src = " + eleresiut + " width=" + width + " height=" + height + " ><center></a></p>\n");
        }
        else
        {
            bw.write("<p><a href =" + imageslinks.get(index + 1) + "><center><img src = " + eleresiut + " width=" + width + " height=" + height + " ><center></a></p>\n");
        }

        bw.write("</body>\n");
        bw.write("</html>");
        bw.close();
    }
}
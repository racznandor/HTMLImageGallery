import java.io.File;
import java.util.*;

public class Filewalker
{

    public void walk(String path, String rootf)
    {

        File root = new File(path);
        File[] list = root.listFiles();
        System.out.println(path);

        Set<String> directories = new LinkedHashSet<>();
        Set<String> directorieslink = new LinkedHashSet<>();

        if (list == null) return;

        //megnézzük, hogy egy mappának vannak-e még almappái
        boolean directory = false;
        int count = 0;
        for (File f: list)
        {
            if (f.isDirectory())
            {
                count++;
            }
        }
        if (count == 0)
        {
            directory=true;
        }
        boolean elsomappa = false;

        //Ha nincsenek, akkor
        if (directory)
        {
            if (path.equals(rootf)) //kiszűrjük, hogy az adott mappa az első mappa-e
            {
                elsomappa = true;
            }
            String indexgenerator = path + "\\index.html";
            Set<String> images = new LinkedHashSet<>();
            Set<String> imageslink = new LinkedHashSet<>();
            directories.clear();
            directorieslink.clear();
            String parentsdirectory = root.getParent() + "\\index.html";
            for (File item : list)
            {
                if (!item.isDirectory())
                {
                    String filename = item.toString().toLowerCase();
                    if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png"))
                    {
                        images.add(item.getName());
                        String eleresiut = item.getAbsolutePath().toLowerCase();
                        int point = eleresiut.indexOf('.');
                        String htmlfajlnev = eleresiut.substring(0, point) + ".html";
                        imageslink.add(htmlfajlnev);
                    }
                }
            }
            GeneratedIndexHtml index = new GeneratedIndexHtml();
            try
            {
                index.indexhtml(rootf + "\\index.html", indexgenerator, directories, images, imageslink, directorieslink, parentsdirectory, elsomappa);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            for (File item2 : list)
            {
                String filename = item2.toString().toLowerCase();
                if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png"))
                {
                    String mappa = item2.getAbsolutePath();
                    String eleresiut = item2.getAbsolutePath().toLowerCase();
                    String kepnev = item2.getName();
                    int point = eleresiut.indexOf('.');
                    String htmlfajlnev = eleresiut.substring(0, point) + ".html";
                    GeneratedImageHtml html = new GeneratedImageHtml();
                    try
                    {
                        html.imagehtml(rootf + "\\index.html", htmlfajlnev, eleresiut, kepnev, imageslink, mappa, indexgenerator);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        else
        {
            for (File f : list)
            {
                if (f.isDirectory())
                {
                    if (path.equals(rootf))
                    {
                        elsomappa = true;
                    }
                    walk(f.getAbsolutePath(), rootf);
                    String indexgenerator = f.getParent() + "\\index.html";
                    String link = f.toString() + "/" + "index.html";
                    directorieslink.add(link);
                    directories.add(f.getName());
                    File[] list2 = root.listFiles();
                    Set<String> images = new LinkedHashSet<>();
                    Set<String> imageslink = new LinkedHashSet<>();
                    String parentsdirectory = root.getParent() + "\\index.html";
                    for (File item : list2)
                    {
                        if (!item.isDirectory())
                        {
                            String filename = item.toString().toLowerCase();
                            if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png"))
                            {
                                images.add(item.getName());
                                String eleresiut = item.getAbsolutePath().toLowerCase();
                                int point = eleresiut.indexOf('.');
                                String htmlfajlnev = eleresiut.substring(0, point) + ".html";
                                imageslink.add(htmlfajlnev);
                            }
                        }
                    }
                    GeneratedIndexHtml index = new GeneratedIndexHtml();
                    try
                    {
                        index.indexhtml(rootf + "\\index.html", indexgenerator, directories, images, imageslink, directorieslink, parentsdirectory,elsomappa );
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                    for (File item2 : list2)
                    {
                        String filename = item2.toString().toLowerCase();
                        if (filename.endsWith(".jpg") || filename.endsWith(".jpeg") || filename.endsWith(".png"))
                        {
                            String mappa = item2.getAbsolutePath();
                            String kepnev = item2.getName();
                            String eleresiut = item2.getAbsolutePath().toLowerCase();
                            int point = eleresiut.indexOf('.');
                            String htmlfajlnev = eleresiut.substring(0, point) + ".html";
                            GeneratedImageHtml html = new GeneratedImageHtml();
                            try
                            {
                                html.imagehtml(rootf + "\\index.html", htmlfajlnev, eleresiut, kepnev, imageslink, mappa, indexgenerator);
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            if (args[0] == null || args[0].trim().isEmpty() || args[0].contains(".")) {
                System.out.println("You need to specify a path!");
                System.exit(1);
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You need to specify a path!");
            System.exit(1);
        }
        Filewalker fw = new Filewalker();
        fw.walk(args[0], args[0]);
    }

}
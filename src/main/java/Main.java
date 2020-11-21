import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

//        // learning reading file from different directories
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
//        printFile(filePath);
//
//        filePath = Paths.get("/Users/yc00/OneDrive - Tesco/Documents/175_StoreColleague/Learning/javaspringboot/OutThere.txt");
//        printFile(filePath);

        // learning creation of directories and files

        int FILE_LIMIT = 10;
        int fileLimit = FILE_LIMIT;
        String filePrefix = "File";

        for(int i=1;i<fileLimit;i++){

            String fileName = filePrefix + i+".txt";

            Path path = FileSystems.getDefault().getPath("files",fileName);
            Path pathSource = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
           try{
              // Files.createFile(path);
               System.out.println("Created File Successfully : "+path);
               Files.copy(pathSource,path,StandardCopyOption.REPLACE_EXISTING);

               System.out.println("Copied File Successfully from :"+pathSource);
           }catch(IOException e){
               System.out.println(e.getMessage());
               e.printStackTrace();
           }
        }

        // learning reading directory contents

        Path directory = FileSystems.getDefault().getPath("files");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory)) {

            for(Path file: contents){
                System.out.println("Reading File : "+ file.getFileName());
                printFile(file.getFileName());
            }

        } catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        }

  //  }

    private static void printFile(Path path){


        System.out.println("Printing from File : "+path);
        try(BufferedReader fileReader = Files.newBufferedReader(path)){
            String line;

            while((line = fileReader.readLine()) != null){
                System.out.println(line);
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }


}

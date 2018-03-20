package cal.worrybook;

/**
 * Created by C on 3/19/2018.
 */

public class Notes {
    private String fileName, fileContent;

    public Notes(){

    }
    public Notes(String fileName, String fileContent){
        this.fileName = fileName;
        this.fileContent = fileContent;
    }
    public String getFileName(){
        return fileName;
    }
    public String getContent(){
        return fileContent;
    }
}

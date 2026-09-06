class FileValidator {
    String validateFileExtension(String filename) {
        int pos = filename.lastIndexOf('.');
        if (pos == -1)
            return "Rejected — invalid file type";
        String ext = filename.substring(pos + 1);
        if (ext.equalsIgnoreCase("pdf") ||
            ext.equalsIgnoreCase("docx") ||
            ext.equalsIgnoreCase("zip"))
            return "Accepted";
        return "Rejected — invalid file type";
    }
}
public class File {
    public static void main(String[] args) {
        FileValidator obj = new FileValidator();
        System.out.println(obj.validateFileExtension("Assignment1.PDF"));
        System.out.println(obj.validateFileExtension("notes.txt"));
    }
}
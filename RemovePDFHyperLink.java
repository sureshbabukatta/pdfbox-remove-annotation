import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;

import java.io.File;
import java.util.List;

public class RemovePDFHyperLink {
    public static void main(String[] args){
        File test = new File("D:\\Apps\\TestProject\\src\\main\\resources\\test.pdf");
        try (PDDocument pdDocument = PDDocument.load(test);) {
            int totalPages = pdDocument.getNumberOfPages();
            for (int page = 0; page < totalPages; page++) {
                PDPage pdPage = pdDocument.getPage(page);
                List<PDAnnotation> annotations = pdPage.getAnnotations();
                annotations.clear();
                pdPage.setAnnotations(annotations);
            }
            pdDocument.save(test);
            System.out.println("completed...");
        }catch(Exception e){

        }
    }

}

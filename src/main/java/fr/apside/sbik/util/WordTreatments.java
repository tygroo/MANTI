package fr.apside.sbik.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.primefaces.component.api.UIColumn;
import org.primefaces.component.datatable.DataTable;

import fr.apside.sbik.entity.User;

public class WordTreatments {
  /**
   * Methode to open a file
   * @param FileToOpen
   * @throws IOException 
   */
  public static void openFile(String fileToOpen) throws IOException {

    if (!fileToOpen.isEmpty())
      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + fileToOpen);
  }

  public static void createWordByDatatable(String FileToOpen, DataTable dataTable) throws IOException {
    String filename = "docSample/sample.docx";

    File wordFile = new File(filename);

    XWPFDocument document = new XWPFDocument();
    XWPFParagraph tmpParagraph = document.createParagraph();
    XWPFRun tmpRun = tmpParagraph.createRun();
    tmpRun.setText("TEST");
    tmpRun.setFontSize(18);

    tmpRun.addCarriageReturn();
    
    XWPFTable tmpTable = document.createTable();
   // tmpTable
    UIColumn sortCol = dataTable.getSortColumn();
   List<UIColumn> coln = dataTable.getColumns();
   User obj = (User) dataTable.getRowData();
  
   tmpRun.setText( obj.getFirstName());
   tmpRun.setFontSize(18);
   
//    sortCol.
    // Injection des tableaux

    FileOutputStream fos;

    fos = new FileOutputStream(wordFile);
    document.write(fos);
    fos.close();

  }
//  private static XWPFDocument replaceText(XWPFDocument doc, String findText, String replaceText){
//    Range r1 = doc.getRange(); 
//
//    for (int i = 0; i < r1.numSections(); ++i ) { 
//        Section s = r1.getSection(i); 
//        for (int x = 0; x < s.numParagraphs(); x++) { 
//            Paragraph p = s.getParagraph(x); 
//            for (int z = 0; z < p.numCharacterRuns(); z++) { 
//                CharacterRun run = p.getCharacterRun(z); 
//                String text = run.text();
//                if(text.contains(findText)) {
//                    run.replaceText(findText, replaceText);
//                } 
//            }
//        }
//    } 
//    return doc;
//}

}

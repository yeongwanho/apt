package com.project.apt;





import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:/Users/goanh/Desktop/coding-master/coding-master/아파트(매매)_실거래가_경기도.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        List<String> dong= new ArrayList<>();
        Map<String,List> si =new HashMap<>();

        int rowindex=0;
        int columnindex=0;
        //시트 수 (첫번째에만 존재하므로 0을 준다)
        //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
        XSSFSheet sheet=workbook.getSheetAt(0);
        //행의 수
        int rows=sheet.getPhysicalNumberOfRows();
        for(rowindex=0;rowindex<rows;rowindex++){
            //행을읽는다
            XSSFRow row=sheet.getRow(rowindex);
            if(row !=null){
                //셀의 수
                int cells=row.getPhysicalNumberOfCells();
                //for(columnindex=0; columnindex<=cells; columnindex++){
                    //셀값을 읽는다
                    XSSFCell cell=row.getCell(columnindex);
                    if (String.valueOf(cell)!="null"){
                        System.out.println("{\n" +
                                "            text: '"+cell.toString().trim()+"',\n" +
                                "            value: '"+cell.toString().trim()+"',\n" +
                                "          }," );
                    }
//                    if (String.valueOf(cell)!="null"){
//                        System.out.print("if (this.citymiddlename === '"+cell.toString().trim()+"') {\n" +
//                                "        this.select4 = [];\n" +
//                                "        this.select4 = [");
//                    }
//                    XSSFCell cell2=row.getCell(columnindex+1);
//
//
//
//                    String value="";
//                    //셀이 빈값일경우를 위한 널체크
//
//                System.out.println("{\n" +
//                        "            text: '"+cell2+"',\n" +
//                        "          },");
//                    System.out.println(rowindex+"번 행 : "+columnindex+"번 열 값은: "+cell);
                //}

            }
        }
    }
}


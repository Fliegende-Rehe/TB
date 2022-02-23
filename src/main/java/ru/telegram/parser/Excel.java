package ru.telegram.parser;

import com.aspose.cells.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Excel {
    private final String PATH;
    private final Worksheet sheet;

    private Excel(String path, Worksheet sheet) {
        this.PATH = path;
        this.sheet = sheet;
    }

    public static Excel Path(String path, String name){
        Worksheet sheet = null;
        try { sheet = new Workbook(new FileInputStream(path)).getWorksheets().get(name); }
        catch (Exception e) { e.printStackTrace(); }
        return new Excel(path, sheet);
    }

    public void Style() {
        try {
            sheet.autoFitColumns();
            sheet.autoFitRows();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void Write(String t, int r, int c) {
        sheet.getCells().get(r, c).putValue(t);
        Style();
        try { sheet.getWorkbook().save(new FileOutputStream(PATH), 6); }
        catch (Exception e) { e.printStackTrace(); }
    }

    public String Read(int r, int c) { return sheet.getCells().get(r, c).getStringValue(); }

    public int Length() { return sheet.getCells().getMaxDataRow() + 1; }

    private int Width() { return sheet.getCells().getMaxDataColumn() + 1; }

    public void Shape(int r, int c) {
        for (int i = Length() - 1; i > r; i--) sheet.getCells().deleteRow(i);
        for (int i = Width() - 1; i > c; i--) sheet.getCells().deleteColumn(i);
    }
}
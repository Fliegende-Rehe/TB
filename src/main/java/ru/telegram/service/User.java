package ru.telegram.service;

import org.telegram.telegrambots.meta.api.objects.*;
import ru.telegram.parser.Excel;

public class User {

    public static void SaveInfo(Update update)  {
        Chat user = update.getMessage().getChat();
        Excel table = Excel.Path("src/main/java/ru/telegram/file/Excel.xlsx", "Sheet1");
        if(InfoSaved(table, user.getId())) return;
        int row = table.Length();
        table.Write("@" + user.getUserName(), row, 0);
        table.Write(user.getLastName(), row, 1);
        table.Write(user.getFirstName(), row, 2);
        table.Write(String.valueOf(user.getId()), row, 3);
        table.Shape(row, 4);
    }
    public static Boolean InfoSaved(Excel table, long id)  {
        for (int i = 0; i < table.Length(); i++) {
            if (id == Long.parseLong(table.Read(i, 3)))
                return true;
        }
        return false;
    }
}
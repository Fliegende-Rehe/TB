package ru.telegram.command;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.telegram.parser.Txt;

public class Help extends Command {

    public Help(String identifier, String description) {
        super(identifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String userName = getUserName(user);
        sendAnswer(absSender,
                chat.getId(),
                this.getCommandIdentifier(),
                userName,
                Txt.getText("src/main/java/ru/telegram/command/answers/Help.txt"));
    }
}
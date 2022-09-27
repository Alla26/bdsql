package ru.netology.bdsql.page;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequireArgsConstructor
public class UserData {
    private final String name;
    private final String password;
}

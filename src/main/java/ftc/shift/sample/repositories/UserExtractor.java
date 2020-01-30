package ftc.shift.sample.repositories;

import ftc.shift.sample.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserExtractor implements ResultSetExtractor<List<User>>{
    @Override
    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<String, User> users = new HashMap<>();

        while (rs.next()) {
            String personId = rs.getString("PERSON_ID");

            User user;
            if (users.containsKey(personId)) {
                user = users.get(personId);
            } else {
                user = new User();

                user.setId(rs.getString("PERSON_ID"));
                user.setName(rs.getString("NAME"));
                user.setLogin(rs.getString("LOGIN"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRegistrationDate(rs.getString("REGISTRATION_DATE"));
                user.setAvatar(rs.getString("AVATAR"));
                user.setBalance(rs.getInt("BALANCE"));
                users.put(personId, user);
            }
        }

        return new ArrayList<>(users.values());
    }
}

package hello.jdbc.connection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

class DBConnectionUtilTest {

    @DisplayName("")
    @Test
    void test() {
        // given
        Connection connection = DBConnectionUtil.getConnection();
        // when // then
        Assertions.assertThat(connection).isNotNull();
    }

}
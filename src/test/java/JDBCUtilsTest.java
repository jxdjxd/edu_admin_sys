import java.sql.Connection;
import java.sql.SQLException;
import com.hua.jdbcutil.JDBCUtils;
import org.junit.jupiter.api.Test;

public class JDBCUtilsTest {

	@Test
	public void test() throws SQLException {
		Connection conn = null;
		conn = JDBCUtils.getConnection();
		System.out.println(conn);
		JDBCUtils.closeConnection(conn);
	}

}

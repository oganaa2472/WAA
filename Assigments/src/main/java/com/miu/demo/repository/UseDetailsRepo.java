

import com.miu.demo.domain.User;
import com.miu.demo.domain.UserDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UseDetailsRepo extends JpaRepository<UserDetailsModel, Integer> {
    UserDetailsModel findByUsername(String username);
}



import com.miu.demo.domain.UserDetailsModel;
import com.miu.demo.repository.UseDetailsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl  implements UserDetailsService {

    @Autowired
    UseDetailsRepo userDetailsRepository;

    @Override
    public UserDetailsModel loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsRepository.findByUsername(username);
    }
}
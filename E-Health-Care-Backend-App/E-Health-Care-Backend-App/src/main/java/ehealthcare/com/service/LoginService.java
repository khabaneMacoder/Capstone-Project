package ehealthcare.com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ehealthcare.com.entity.Login;
import ehealthcare.com.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository loginRepository;
	
	public String signIn(Login login) {
		
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
						Login ll = result.get();
						if(ll.getPassword().equals(login.getPassword())) {
							
									if(ll.getTypeofuser().equalsIgnoreCase("admin")) {
										return "Admin Login successfully";
									}else {
										return "Customer Login successfully";
									}
							
						}else {
							return "Invalid password";
						}
		}else {
				return "InValid EmailId";
		}
	
	}
	
	public String signUp(Login login) {
		
		Optional<Login> result = loginRepository.findById(login.getEmailid());
		if(result.isPresent()) {
				return "Account already exists";
		}else {
				
				if(login.getTypeofuser().equalsIgnoreCase("admin")) {
					return "You Can't create Admin Account";
				}else {
					loginRepository.save(login);
					return "Account Created successfully";
				}
				
		}
	}
		
}





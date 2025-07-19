package naveen97.example.WatsOTPTemplates.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import naveen97.example.WatsOTPTemplates.Model.User;

public interface UserRepository  extends JpaRepository<User, Integer> {

	User findByEmailAndOtp(String email, String otp);

}

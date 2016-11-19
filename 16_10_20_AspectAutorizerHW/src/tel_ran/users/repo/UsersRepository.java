package tel_ran.users.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tel_ran.entities.Account;

public interface UsersRepository extends CrudRepository<Account, String> {


}

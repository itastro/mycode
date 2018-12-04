package com.bailian.car.dao.system;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.bailian.car.domain.system.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	@Transactional
	@Modifying
	@Query("update User u set u.password=?2 where u.uid=?1")
	int updatePassWord(Integer userId, String newpass);

	User findByTelephone(String telephone);

	User findByEmail(String email);

	List<User> findAll(Specification<User> querySpecifi);

	@Query(value = "SELECT * fROM t_user WHERE netid=?1", nativeQuery = true)
	User findByNetid(String NETID);

	User findByEmployeeCard(String employeeCard);

	User findUserByUidAndPassword(Integer userId, String pass);

	@Query(value = "SELECT * FROM t_user WHERE C_ID IN (SELECT C_USER_ID FROM t_user_role WHERE C_ROLE_ID= (SELECT C_ID from t_role where C_KEYWORD='maintain'))", nativeQuery = true)
	List<User> findEmployee();

	@Modifying
	@Query(value = "DELETE FROM t_user_role WHERE C_USER_ID=?1 AND C_ROLE_ID=?2", nativeQuery = true)
	void userCancleRole(Integer uid, int i);

}

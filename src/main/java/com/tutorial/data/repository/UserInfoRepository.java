/**
 * 
 */
package com.tutorial.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tutorial.data.entity.UserInfo;

/**
 * @author Jafer
 *
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}

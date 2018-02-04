package bulletinBoard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import bulletinBoard.domain.User;

/**
 * JPA ORMs repository.
 * JpaSpecificationExecutorはパラメータが未入力だったら無効になる検索条件
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	//ここでSpecification使用パラメータが未入力だったら無効になる検索条件
	//指定したページネーション情報に該当するEntityのコレクションを取得Pageable
    @Override
    Page<User> findAll(Specification<User> specifications, Pageable pageable);

    //idからuse情報取得
    User findById(int number);
    
    
//
//    @Query(name = "User.updatePassword")
//    User updatePassword(@Param("id") Integer staffId, @Param("oldPassword") String oldPassword,
//                        @Param("newPassword") String newPassword, @Param("modifiedAt") Timestamp modifiedAt);
}
package bulletinBoard.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import bulletinBoard.domain.Account;


public interface AccountRepository extends JpaRepository<Account, Integer>, JpaSpecificationExecutor<Account>{
	//ここでSpecification使用パラメータが未入力だったら無効になる検索条件
	//指定したページネーション情報に該当するEntityのコレクションを取得Pageable
    @Override
    Page<Account> findAll(Specification<Account> specifications, Pageable pageable);

    //idからAccount情報取得
    Account findById(int number);
    
    //ユーザー名からAccount情報取得
    Account findByuserName(String userName);
    
    

//    @Query(name = "User.updatePassword")
//    Account updatePassword(@Param("id") Integer id, @Param("oldPassword") String oldPassword,
//                        @Param("newPassword") String newPassword, @Param("modifiedAt") Timestamp modifiedAt);
}

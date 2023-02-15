package jinwoo.library.repository;

import jinwoo.library.entity.Member;
import jinwoo.library.entity.MemberBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("select m from Member m")
    List<Member> findAll();

    @Query("select m from Member m where m.id = :id")
    Member findById(Long id);

    @Query("select m from Member m where m.username = :username")
    List<Member> findByUsername(String username);

    @Query("select m from Member m where m.phoneNumber = :phoneNumber")
    Member findByPhoneNumber(String phoneNumber);

    @Query("select m from Member m where right(m.phoneNumber, 4) = :number")
    Member findByLastPhoneNumber(String number);

    @Query ("select m from Member m join fetch m.memberBooks b")
    List<MemberBook> findBooksByMemberId(Long Id);
}

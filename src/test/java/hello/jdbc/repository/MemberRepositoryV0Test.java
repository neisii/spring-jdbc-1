package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemberRepositoryV0Test {

    private MemberRepositoryV0 repository = new MemberRepositoryV0();

    @DisplayName("")
    @Test
    void curd() throws SQLException {
        // given
        Member member = new Member("member7", 10000);
        repository.save(member);

        // when
        Member findMember = repository.findById(member.getMemberId());
        log.info("findMember: {}", findMember);

        // then

        assertThat(findMember).isEqualTo(member);


        repository.update(member.getMemberId(), 20000);
        Member updatedMember = repository.findById(member.getMemberId());
        assertThat(updatedMember.getMoney()).isEqualTo(20000);

        repository.delete(member.getMemberId());
        Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
                .isInstanceOf(NoSuchElementException.class);
    }

}
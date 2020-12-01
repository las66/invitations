package ru.las.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InvitationMapper {

    @Insert({"<script>",
            "INSERT INTO invitation(phone, author, application)",
            "values",
            "    <foreach item=\"item\" index=\"index\" collection=\"phoneNumbers\" open=\"(\" separator=\"), (\" close=\")\">",
            "        #{item}, #{author}, #{app}",
            "    </foreach>",
            "</script>"})
    void create(@Param("phoneNumbers") List<String> phoneNumbers,
                @Param("author") int author,
                @Param("app") int application);

    @Select({"SELECT count(*)",
            "   FROM invitation",
            "  WHERE phone = #{phoneNumber}"})
    int invitationCount(@Param("phoneNumber") String phoneNumber);
}

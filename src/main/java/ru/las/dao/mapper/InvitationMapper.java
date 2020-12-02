package ru.las.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InvitationMapper {

    @Select({"<script>",
            "SELECT invite(#{author}, #{app}, ",
            "    <foreach item=\"item\" index=\"index\" collection=\"phoneNumbers\" open=\"array[\" separator=\",\" close=\"]\">",
            "        #{item}",
            "    </foreach>",
            ")",
            "</script>"})
    @SuppressWarnings("UnusedReturnValue")
    String create(@Param("phoneNumbers") List<String> phoneNumbers,
                  @Param("author") int author,
                  @Param("app") int application);

    @Select({"<script>",
            " SELECT count(*)",
            "   FROM invitation",
            "  WHERE phone in",
            "    <foreach item=\"item\" index=\"index\" collection=\"phoneNumbers\" open=\"(\" separator=\", \" close=\")\">",
            "        #{item}",
            "    </foreach>",
            "</script>"})
    int invitationCount(@Param("phoneNumbers") List<String> phoneNumber);

    @Select({"SELECT * ",
            "   FROM getcountinvitations(#{application})"})
    int invitationTodayCount(@Param("application") int application);
}

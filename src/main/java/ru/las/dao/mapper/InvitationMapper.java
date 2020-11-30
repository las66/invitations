package ru.las.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvitationMapper {

    @Insert({"<script>",
            "INSERT INTO invitation(phone, author, application)",
            "values",
            "    <foreach item=\"item\" index=\"index\" collection=\"numbers\" open=\"(\" separator=\"), (\" close=\")\">",
            "        #{item}, #{author}, #{app}",
            "    </foreach>",
            "</script>"})
    void create(@Param("numbers") List<String> phoneNumbers,
                @Param("author") int author,
                @Param("app") int application);
}

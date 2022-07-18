package persistence.mapper;

import org.apache.ibatis.annotations.*;
import persistence.dto.BoardDTO;

import java.util.Date;
import java.util.List;

public interface BoardMapper {
    final String getAll = "SELECT * FROM BOARD";

    @Select(getAll)
    @Results(id = "boardResultSet", value = {
            @Result(property = "id", column = "board_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "writer", column = "writer"),
            @Result(property = "content", column = "content"),
            @Result(property = "regDate", column = "regDate"),
            @Result(property = "hit", column = "hit")
    })
    List<BoardDTO> getAll();

    @Select("SELECT * FROM BOARD WHERE board_id=#{id}")
    @ResultMap("boardResultSet")
    BoardDTO selectById(@Param("id") Long id);

    @SelectProvider(type = persistence.mapper.BoardSql.class, method = "selectRecent")
    @ResultMap("boardResultSet")
    List<BoardDTO> selectRecentPost(int day);

    @SelectProvider(type = persistence.mapper.BoardSql.class, method = "selectLike")
    @ResultMap("boardResultSet")
    List<BoardDTO> selectTitleWriterLike(BoardDTO boardDTO);

    @SelectProvider(type = persistence.mapper.BoardSql.class, method = "selectLikeCondition")
    @ResultMap("boardResultSet")
    List<BoardDTO> selectTitleWriterLikeCondition(BoardDTO boardDTO);
}
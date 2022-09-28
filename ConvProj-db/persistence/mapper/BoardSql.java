package persistence.mapper;

import org.apache.ibatis.jdbc.SQL;
import persistence.dto.BoardDTO;

public class BoardSql {

    public String selectRecent(int day){
        SQL sql = new SQL(){{ // anonymous class
            SELECT("*");
            FROM("Board");
            WHERE("datediff(NOW(),regDate)<#{day}");
        }};
        return sql.toString();
    }

    public String selectLike(BoardDTO boardDTO){
        SQL sql = new SQL()
                .SELECT("*")
                .FROM("Board")
                .WHERE("writer LIKE CONCAT('%',#{writer},'%')")
                .OR()
                .WHERE("title LIKE CONCAT('%',#{title},'%')");
        return sql.toString();
    }

    public String selectLikeCondition(BoardDTO boardDTO){
        SQL sql = new SQL() {{
            SELECT("*");
            FROM("board");
            if(boardDTO.getTitle() !=null){
                WHERE("title LIKE CONCAT('%',#{title},'%')");
            }
            OR();
            if(boardDTO.getWriter() !=null){

                WHERE("writer LIKE CONCAT('%',#{writer},'%')");
            }
        }};
        return sql.toString();
    }

}
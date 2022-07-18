package persistence.dao;

import persistence.PooledDataSource;
import persistence.dto.BoardDTO;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    private final DataSource ds = PooledDataSource.getDataSource();

    public List<BoardDTO> findAll(){
        Connection conn = null;
        String sql = "SELECT * FROM BOARD";
        Statement stmt= null;
        ResultSet rs = null;

        List<BoardDTO> boardDTOs = new ArrayList<>();
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO();
                Long id = rs.getLong("board_id");
                String title = rs.getString("title");
                String writer = rs.getString("writer");
                String content = rs.getString("content");
                LocalDateTime regDate = rs.getTimestamp("regDate").toLocalDateTime();
                int hit = rs.getInt(6);

                boardDTO.setId(id);
                boardDTO.setTitle(title);
                boardDTO.setWriter(writer);
                boardDTO.setContent(content);
                boardDTO.setRegDate(regDate);
                boardDTO.setHit(hit);
                boardDTOs.add(boardDTO);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            try{
                if(conn != null && !rs.isClosed()){
                    rs.close();
                }
                if(conn != null && !stmt.isClosed()){
                    rs.close();
                }
                if(conn != null && !conn.isClosed()){
                    conn.close();
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return boardDTOs;
    }

}
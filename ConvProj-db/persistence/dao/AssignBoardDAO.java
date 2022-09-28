package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.BoardDTO;
import persistence.mapper.BoardMapper;

import java.util.Date;

public class AssignBoardDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public AssignBoardDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void insertTest(BoardDTO boardDTO){
        SqlSession session = sqlSessionFactory.openSession();
        session.insert("mapper.BoardMapper.insertTest",boardDTO);
        session.commit();
        session.close();
    }

    public void updateContentTest(BoardDTO boardDTO) {
        SqlSession session = sqlSessionFactory.openSession();
        session.update("mapper.BoardMapper.updateContentTest",boardDTO);
        session.commit();
        session.close();
    }

    public void deleteTest(BoardDTO boardDTO){
        SqlSession session = sqlSessionFactory.openSession();
        session.delete("mapper.BoardMapper.deleteTest",boardDTO);
        session.commit();
        session.close();
    }

}
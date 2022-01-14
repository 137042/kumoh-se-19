package persistence.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dto.BoardDTO;
import persistence.mapper.BoardMapper;

import java.util.List;
import java.util.Map;

public class MyBoardDAO {

    private SqlSessionFactory sqlSessionFactory = null;

    public MyBoardDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<BoardDTO> selectAll(){
        List<BoardDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.BoardMapper.selectAll");
        }finally{
            session.close();
        }
        return list;
    }

    public List<BoardDTO> findPostWithTitleLike(String title){
        List<BoardDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.BoardMapper.findPostWithTitleLike",title);
        }finally{
            session.close();
        }
        return list;
    }

    public List<BoardDTO> findPostWithTitleNameLike(Map<String, Object> params){
        List<BoardDTO> list = null;

        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.BoardMapper.findPostWithTitleNameLike",params);
        } finally {
            session.close();
        }
        return list;
    }

    public List<BoardDTO> findPostWithTitleNameLike2(BoardDTO boardDTO){
        List<BoardDTO> list = null;

        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.BoardMapper.findPostWithTitleNameLike2",boardDTO);
        } finally {
            session.close();
        }
        return list;
    }

    public List<BoardDTO> findPostWithTitleNameLike3(BoardDTO boardDTO){
        List<BoardDTO> list = null;

        SqlSession session = sqlSessionFactory.openSession();
        try {
            list = session.selectList("mapper.BoardMapper.selectWithTrim",boardDTO);
        } finally {
            session.close();
        }
        return list;
    }

    public List<BoardDTO> selectAllWithAnnotation(){
        List<BoardDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        try {
            list = mapper.getAll();
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    public BoardDTO selectOneWithAnnotation(Long id){
        BoardDTO boardDTO = new BoardDTO();
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        try {
            boardDTO = mapper.selectById(id);
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return boardDTO;
    }

    public List<BoardDTO> selectRecentWithAnnotation(int day){
        List<BoardDTO> list = null;
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        try {
            list = mapper.selectRecentPost(day);
            session.commit();
        } catch (Exception e){
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return list;
    }

    public List<BoardDTO> selectTitleWriterLikeWithAnnotation(BoardDTO boardDTO){
        List<BoardDTO> boardDTOS = null;
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        boardDTOS = mapper.selectTitleWriterLike(boardDTO);
        return boardDTOS;
    }

    public List<BoardDTO> selectTitleWriterLikeWithAnnotation2(BoardDTO boardDTO){
        SqlSession session = sqlSessionFactory.openSession();
        BoardMapper mapper = session.getMapper(BoardMapper.class);
        List<BoardDTO> boardDTOS = mapper.selectTitleWriterLikeCondition(boardDTO);
        return boardDTOS;
    }

}
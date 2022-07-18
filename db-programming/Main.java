import persistence.MyBatisConnectionFactory;
import persistence.dao.AssignBoardDAO;
import persistence.dao.BoardDAO;
import persistence.dao.MyBoardDAO;
import persistence.dto.BoardDTO;
import service.BoardService;
import view.BoardView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
//        BoardDAO boardDAO = new BoardDAO();
//        BoardView boardView = new BoardView();
//        BoardService boardService = new BoardService(boardDAO);

//        List<BoardDTO> all = boardService.findAll();
//        boardView.printAll(all);
        MyBoardDAO myBoardDAO = new MyBoardDAO(MyBatisConnectionFactory.getSqlSessionFactory()); // dependency injection
//        List<BoardDTO> boardDTOS = myBoardDAO.selectAll();
//        for(BoardDTO dto : boardDTOS){
//            System.out.println("dto.toString() = " + dto.toString());
//        }
//        List<BoardDTO> posts = myBoardDAO.findPostWithTitleLike("insert");
//        System.out.println("posts.size() = " + posts.size());
//        posts.stream().forEach(p-> System.out.println("p.toString() = " + p.toString()));

//        String title = "test";
//        String writer = "kim";
//        Map params = new HashMap<String, Object>();
//        params.put("title",title);
//        params.put("writer",writer);
//        List<BoardDTO> posts = myBoardDAO.findPostWithTitleNameLike(params);
//        System.out.println("posts.size() = " + posts.size());
//        posts.stream().forEach(p -> System.out.println(p.toString()));

//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setTitle("test");
//        boardDTO.setWriter("kim");

//        List<BoardDTO> posts2 = myBoardDAO.findPostWithTitleNameLike2(boardDTO);
//        System.out.println("posts2.size() = " + posts2.size());
//        posts2.stream().forEach(p -> System.out.println(p.toString()));

//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setId(1l);
//        boardDTO.setTitle("test");
//        boardDTO.setWriter("kim");

//        List<BoardDTO> posts3 = myBoardDAO.findPostWithTitleNameLike3(boardDTO);
//        System.out.println("posts2.size() = " + posts3.size());
//        posts3.stream().forEach(p -> System.out.println(p.toString()));

//        List<BoardDTO> boardDTOS = myBoardDAO.selectAllWithAnnotation();
//        boardDTOS.stream().forEach(v-> System.out.println("v.toString() = " + v.toString()));

//        BoardDTO boardDTO = myBoardDAO.selectOneWithAnnotation(2L);
//        System.out.println("boardDTO.toString() = " + boardDTO.toString());

//        List<BoardDTO> boardDTOS = myBoardDAO.selectRecentWithAnnotation(7);
//        boardDTOS.stream().forEach(v-> System.out.println("v.toString() = " + v.toString()));

//        BoardDTO boardDTO = new BoardDTO();
//        boardDTO.setTitle("Batis");
//        boardDTO.setWriter("kim");
//        List<BoardDTO> boardDTOS = myBoardDAO.selectTitleWriterLikeWithAnnotation(boardDTO);
//        boardDTOS.stream().forEach(v-> System.out.println("v.toString() = " + v.toString()));

        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Batis");
        boardDTO.setWriter("lee");
        List<BoardDTO> boardDTOS = myBoardDAO.selectTitleWriterLikeWithAnnotation2(boardDTO);
        boardDTOS.stream().forEach(v-> System.out.println("v.toString() = " + v.toString()));

        /* Assignment Code */
//        AssignBoardDAO assignBoardDAO = new AssignBoardDAO(MyBatisConnectionFactory.getSqlSessionFactory());
//        BoardDTO boardDTO = new BoardDTO();

//        boardDTO.setTitle("testTitle");
//        boardDTO.setWriter("testTitle");
//        boardDTO.setContent("testTitle");
//        boardDTO.setRegDate(LocalDateTime.now());
//        boardDTO.setHit(0);
//        assignBoardDAO.insertTest(boardDTO);

//        boardDTO.setId(7L);
//        assignBoardDAO.updateContentTest(boardDTO);

//        boardDTO.setId(7L);
//        assignBoardDAO.deleteTest(boardDTO);

    }

}
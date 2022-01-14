package view;

import persistence.dto.BoardDTO;

import java.util.List;

public class BoardView {

    public void printAll(List<BoardDTO> temp){
        System.out.println("board");
        for(BoardDTO dto:temp){
            System.out.println("dto.toString() = " + dto.toString());
        }
    }

}
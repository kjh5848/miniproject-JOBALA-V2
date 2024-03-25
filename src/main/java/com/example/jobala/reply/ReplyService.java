package com.example.jobala.reply;

import com.example.jobala._core.errors.exception.Exception404;
import com.example.jobala._user.User;
import com.example.jobala.board.Board;
import com.example.jobala.board.BoardJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyJPARepository replyJPARepository;
    private final BoardJPARepository boardJPARepository;

    @Transactional
    public void 댓글쓰기(ReplyRequest.SaveDTO reqDTO, User sessionUser){
       Board board = boardJPARepository.findById(reqDTO.getBoardId())
               .orElseThrow(() -> new Exception404("없는 게시글에 댓글을 작성 할 수 없습니다."));

       Reply reply = reqDTO.toEntity(sessionUser, board);

       replyJPARepository.save(reply);
    }
}

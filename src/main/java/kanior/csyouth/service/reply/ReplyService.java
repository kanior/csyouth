package kanior.csyouth.service.reply;

import kanior.csyouth.domain.reply.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
}

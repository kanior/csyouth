package kanior.csyouth.service.notes;

import kanior.csyouth.domain.notes.NotesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class NotesService {

    private final NotesRepository notesRepository;
}

package br.com.fiap.board_vault.boardgame;

import lombok.RequiredArgsConstructor;
import br.com.fiap.board_vault.boardgame.BoardGame;
import br.com.fiap.board_vault.boardgame.BoardGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/boardgames")
@CrossOrigin
@RequiredArgsConstructor
public class BoardGameController {

    private final BoardGameRepository boardGameRepository;

    @GetMapping
    public List<BoardGame> getAll() {
        return boardGameRepository.findAll();
    }

    @GetMapping("/{id}")
    public BoardGame getById(@PathVariable Long id) {
        return boardGameRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Jogo não encontrado: " + id));
    }
}
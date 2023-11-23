package br.com.sgv.controller;

import br.com.sgv.model.Estoque;
import br.com.sgv.repository.EstoqueRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class EstoqueController
 */
@Controller
public class EstoqueControler {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @GetMapping("/estoque")
    public String listar(Model model) {
        model.addAttribute("listaEstoque", estoqueRepository.findAll());
        return "gerenciar_estoques";
    }

    @GetMapping("/estoque/novo")
    public String novo(Model model) {
        model.addAttribute("estoque", new Estoque());
        return "editar_estoque";
    }

    @GetMapping("/estoque/{id}")
    public String editar(@PathVariable("id") long id, Model model) {
        Optional<Estoque> Estoque = estoqueRepository.findById(id);
        model.addAttribute("estoque", Estoque.get());
        return "editar_estoque";
    }

    @PostMapping("/estoque")
    public String salvar(@Valid Estoque estoque, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_estoque";
        }
        estoqueRepository.save(estoque);
        return "redirect:/estoque";
    }

    @DeleteMapping("/estoque/{id}")
    public String excluir(@PathVariable("id") long id) {
        estoqueRepository.deleteById(id);
        return "redirect:/estoque";
    }
}

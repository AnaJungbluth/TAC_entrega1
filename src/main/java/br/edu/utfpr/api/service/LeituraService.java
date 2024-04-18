package br.edu.utfpr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.api.dto.LeituraDTO;
import br.edu.utfpr.api.exceptions.NoteFoundException;
import br.edu.utfpr.api.model.Leitura;
import br.edu.utfpr.api.repository.LeituraRepository;

@Service
public class LeituraService {
    @Autowired
    private LeituraRepository leituraRepository;

    public Leitura create(LeituraDTO dto){
        var leitura = new Leitura();
        BeanUtils.copyProperties(dto, leitura);
        
        //Persistir no banco de dados
        return leituraRepository.save(leitura);
    }

    public List<Leitura> getAll(){
        return leituraRepository.findAll();
    }

    public Optional<Leitura> getByid(long id){
        return leituraRepository.findById(id);
    }

    public Leitura update(Long id, LeituraDTO dto) throws NoteFoundException{
        var res = leituraRepository.findById(id);

        if(res.isEmpty()){
            throw new NoteFoundException("Leitura " + id + " não existe.");
        }

        var leitura = res.get();
        leitura.setValor((dto.valor()));

        return leituraRepository.save(leitura);
        
    }

    public void delete(long id) throws NoteFoundException{
        var res = leituraRepository.findById(id);

        if(res.isEmpty()){
            throw new NoteFoundException("Leitura " + id + " não existe.");
        }

        leituraRepository.delete(res.get());

    }


}

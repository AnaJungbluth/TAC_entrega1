package br.edu.utfpr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.api.dto.AtuadorDTO;
import br.edu.utfpr.api.exceptions.NoteFoundException;
import br.edu.utfpr.api.model.Atuador;
import br.edu.utfpr.api.repository.AtuadorRepository;

@Service
public class AtuadorService {

    @Autowired
    private AtuadorRepository atuadorRepository;

    public Atuador create(AtuadorDTO dto){
        var atuador = new Atuador();
        BeanUtils.copyProperties(dto, atuador);
        
        //Persistir no banco de dados
        return atuadorRepository.save(atuador);
    }

    public List<Atuador> getAll(){
        return atuadorRepository.findAll();
    }

    public Optional<Atuador> getByid(long id){
        return atuadorRepository.findById(id);
    }

    public Atuador update(Long id, AtuadorDTO dto) throws NoteFoundException{
        var res = atuadorRepository.findById(id);

        if(res.isEmpty()){
            throw new NoteFoundException("Atuador " + id + " não existe.");
        }

        var atuador = res.get();
        atuador.setNome((dto.nome()));

        return atuadorRepository.save(atuador);
        
    }

    public void delete(long id) throws NoteFoundException{
        var res = atuadorRepository.findById(id);

        if(res.isEmpty()){
            throw new NoteFoundException("Atuador " + id + " não existe.");
        }

        atuadorRepository.delete(res.get());

    }

}

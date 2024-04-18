package br.edu.utfpr.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.api.dto.DispositivoDTO;
import br.edu.utfpr.api.exceptions.NoteFoundException;
import br.edu.utfpr.api.model.Dispositivo;
import br.edu.utfpr.api.repository.DispositivoRepository;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public Dispositivo create(DispositivoDTO dto){
        var dispositivo = new Dispositivo();
        BeanUtils.copyProperties(dto, dispositivo);
        
        //Persistir no banco de dados
        return dispositivoRepository.save(dispositivo);
    }

    public List<Dispositivo> getAll(){
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivo> getByid(long id){
        return dispositivoRepository.findById(id);
    }

    public Dispositivo update(Long id, DispositivoDTO dto) throws NoteFoundException{
        var res = dispositivoRepository.findById(id);

        if(res.isEmpty()){
            throw new NoteFoundException("Dispositivo " + id + " não existe.");
        }

        var dispositivo = res.get();
        dispositivo.setNome((dto.nome()));
        dispositivo.setDescricao(dto.descricao());
        dispositivo.setLocalizacao(dto.localizacao());

        return dispositivoRepository.save(dispositivo);
        
    }

    public void delete(long id) throws NoteFoundException{
        var res = dispositivoRepository.findById(id);

        if(res.isEmpty()){
            throw new NoteFoundException("Dispositivo " + id + " não existe.");
        }

        dispositivoRepository.delete(res.get());

    }

}


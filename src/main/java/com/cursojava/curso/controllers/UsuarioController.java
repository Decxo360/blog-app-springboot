package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Usuario;
import com.cursojava.curso.utils.Jwt;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController{

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private Jwt jwt;

    @RequestMapping(value = "api/usuarios",method = RequestMethod.GET)
    public List<Usuario> getUsuarios(@RequestHeader(value = "Authorization") String token){
        String idUser = jwt.getKey(token);
        if (idUser == null){
            return null;
        }

        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuario/update/{id}")
    public Usuario updateUsuario(@PathVariable String id){

        Usuario usuario= new Usuario();

        return usuario;
    }
    @RequestMapping(value="api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,usuario.getContrasena());
        usuario.setContrasena(hash);
        usuarioDao.registrarUsuario(usuario);
    }

    @RequestMapping(value = "api/usuario/delete/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "usuario/search/{id}")
    public Usuario searchUsuario(@PathVariable String id){

        Usuario usuario= new Usuario();

        return usuario;
    }

}

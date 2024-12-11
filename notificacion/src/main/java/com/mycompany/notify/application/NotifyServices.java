package com.mycompany.notify.application;

import com.mycompany.notify.domain.Notify;
import com.mycompany.notify.domain.INotifyServices;
import com.mycompany.notify.infrastructure.UsuarioContexto;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Andres
 */
@Service
@Getter
@Setter
public class NotifyServices {

    @Autowired
    private JavaMailSender mailSender;

    private final INotifyServices repositoryNotify;
    private final UsuarioContexto usuarioContexto; // Agregamos UsuarioContexto

    // Constructor que incluye UsuarioContexto
    @Autowired
    public NotifyServices(INotifyServices repositoryNotify, UsuarioContexto usuarioContexto) {
        this.repositoryNotify = repositoryNotify;
        this.usuarioContexto = usuarioContexto; // Inicializamos UsuarioContexto
    }

    public void saveNotify(Notify notify) {
        repositoryNotify.save(notify);
    }

    public List<Notify> getNotifyForUser(String emailUser) {
        return repositoryNotify.findByEmailUsuario(emailUser);
    }

    public void enviarNotificacion(String destinatario, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mailSender.send(mensaje);

        Notify notify = new Notify();
        notify.setEmailUsuario(destinatario);
        notify.setSubject(asunto);
        notify.setMessage(cuerpo);
        saveNotify(notify);
    }

    // Método para procesar notificaciones utilizando UsuarioContexto
    public void procesarNotificacionDesdeAPI(HttpServletRequest request, String mensaje) {
        // Extraemos el usuario desde UsuarioContexto
        var usuario = usuarioContexto.extraerUsuarioDesdeCabeceras(request);

        // Construimos la notificación
        String destinatario = usuario.getCorreoUsuario();
        String asunto = "Notificación personalizada desde Notify-Service";
        String cuerpo = String.format("Hola %s, tienes un nuevo mensaje: %s", usuario.getNombreUsuario(), mensaje);

        // Enviamos la notificación
        enviarNotificacion(destinatario, asunto, cuerpo);
    }
}

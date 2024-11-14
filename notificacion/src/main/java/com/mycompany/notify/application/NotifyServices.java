/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.notify.application;

import com.mycompany.notify.domain.Notify;
import com.mycompany.notify.domain.INotifyServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author William Andres
 */
@Service
public class NotifyServices {
        
    @Autowired
    private JavaMailSender mailSender;
    private final INotifyServices repositoryNotify;
    public NotifyServices(INotifyServices repositoryNotify) {
        this.repositoryNotify = repositoryNotify;
    }
    
    public void saveNotify(Notify notify) {
        repositoryNotify.save(notify);
    }

    public List<Notify> getNotifyForUser(String emailUser) {
        return repositoryNotify.findByEmailUsuario(emailUser);
    }
    
    public void procesarNotificacion(Notify notify) {
        // Aquí puedes construir el mensaje y enviar el correo.
        String destinatario = notify.getEmailUsuario();
        String asunto = "Nueva notificación";
        String cuerpo = "Has recibido una nueva notificación: " + notify.getMessage();
        enviarNotificacion(destinatario, asunto, cuerpo);
    }
    

    public void enviarNotificacion(String destinatario, String asunto, String cuerpo) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo(destinatario);
        mensaje.setSubject(asunto);
        mensaje.setText(cuerpo);
        mailSender.send(mensaje);
    }
}

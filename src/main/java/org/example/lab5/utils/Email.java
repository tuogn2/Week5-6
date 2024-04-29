/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.lab5.utils;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.example.lab5.models.OrderProduct;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Admin
 */
//email: 
//pass: zmyg uwdt fise aeky
public class Email {

    public static void sendMess(String to, String encodemess) {
        try {
            final String from = "tieutuong257@gmail.com";
            final String pass = "ofiw snys vqfz zgth";

//            final String to = "conguyetnaduongvulan@gmail.com";




            //decode
            OrderProduct op = (OrderProduct) ConvertToObject.convertJsonToOject(EncodeDecodeMessage.decodeMessage(encodemess), OrderProduct.class);

            String text = "Thông tin đơn hàng: \n" +
                    "Tên sản phẩm: " + op.getProduct().getName() + "\n" +
                    "Số lượng: " + op.getQuantity() + "\n" +
                    "Ngày đặt hàng: " + op.getOrderDate() + "\n" +
                    "Tên người nhận: " + op.getPerson().getName() + "\n" +
                    "Giới tính: " + op.getPerson().getGender() + "\n" +
                    "Địa chỉ: " + op.getPerson().getAddress() + "\n" +
                    "Số điện thoại: " + op.getPerson().getPhone() + "\n" +
                    "Email: " + op.getPerson().getEmail() ;
            // Properties configuration
            Properties prop = new Properties();
            prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587"); // Use 587 for TLS
            prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true");

            // Authenticator
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            };

            // Session
            Session session = Session.getInstance(prop, auth);

            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);

            message.addHeader("Content-type", "text/HTML; charset=UTF-8");
            message.setFrom(from);

            // Receiver's email address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Email subject
            message.setSubject("Thông baó bán hàng");

            // Email content
            message.setText(text);
            
            // Send the email
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}